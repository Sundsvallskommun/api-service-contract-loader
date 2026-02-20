package se.sundsvall.contractloader.service.provider;

import generated.se.sundsvall.contract.Address;
import generated.se.sundsvall.contract.Contract;
import generated.se.sundsvall.contract.ContractType;
import generated.se.sundsvall.contract.Duration;
import generated.se.sundsvall.contract.Extension;
import generated.se.sundsvall.contract.ExtraParameterGroup;
import generated.se.sundsvall.contract.Fees;
import generated.se.sundsvall.contract.Invoicing;
import generated.se.sundsvall.contract.LeaseType;
import generated.se.sundsvall.contract.Notice;
import generated.se.sundsvall.contract.NoticeTerm;
import generated.se.sundsvall.contract.Parameter;
import generated.se.sundsvall.contract.Party;
import generated.se.sundsvall.contract.Period;
import generated.se.sundsvall.contract.PropertyDesignation;
import generated.se.sundsvall.contract.Stakeholder;
import generated.se.sundsvall.contract.StakeholderRole;
import generated.se.sundsvall.contract.Status;
import generated.se.sundsvall.contract.TimeUnit;
import generated.se.sundsvall.estateinfo.EstateDesignationResponse;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;
import se.sundsvall.contractloader.integration.db.model.ArrendatorEntity;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktEntity;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktsradEntity;
import se.sundsvall.contractloader.integration.db.model.FastighetEntity;
import se.sundsvall.contractloader.integration.db.model.NoteringEntity;
import se.sundsvall.contractloader.integration.estateinfo.EstateInfoClient;
import se.sundsvall.contractloader.integration.party.PartyClient;
import se.sundsvall.contractloader.service.Constants;

import static generated.se.sundsvall.contract.AddressType.POSTAL_ADDRESS;
import static generated.se.sundsvall.contract.ContractType.LAND_LEASE_PUBLIC;
import static generated.se.sundsvall.contract.ContractType.LEASEHOLD;
import static generated.se.sundsvall.contract.ContractType.LEASE_AGREEMENT;
import static generated.se.sundsvall.contract.InvoicedIn.ADVANCE;
import static generated.se.sundsvall.contract.Party.LESSEE;
import static generated.se.sundsvall.contract.StakeholderType.MUNICIPALITY;
import static generated.se.sundsvall.contract.StakeholderType.OTHER;
import static generated.se.sundsvall.contract.Status.ACTIVE;
import static generated.se.sundsvall.contract.Status.TERMINATED;
import static generated.se.sundsvall.party.PartyType.ENTERPRISE;
import static generated.se.sundsvall.party.PartyType.PRIVATE;
import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;
import static java.util.function.Predicate.not;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.zalando.problem.Status.PRECONDITION_FAILED;
import static se.sundsvall.contractloader.service.Constants.ALLMAN_PLATSUPPLATELSE;
import static se.sundsvall.contractloader.service.Constants.CATEGORY_PERSON;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_CONTRACT_DATE_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_CONTRACT_NAME_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_CONTRACT_NUMBER_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_FINAL_BILLING_DATE_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_GROUP_NAME;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_MAIN_CONTRACT_REFERENCE_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_MIGRATED_FROM_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_MIGRATED_FROM_VALUE;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_ORIGINAL_CONTRACT_TYPE_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_ORIGINAL_FILE_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_TERMINATED_BY_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.CONTRACT_DETAILS_TERMINATION_DATE_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.INVOICE_INFO_ARTICLE_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.INVOICE_INFO_GROUP_NAME;
import static se.sundsvall.contractloader.service.Constants.INVOICE_INFO_MARKUP_PARAMETER;
import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_ID;
import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_NAME;
import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_PARTY_ID;
import static se.sundsvall.contractloader.service.Constants.ORDERING_FIRST;
import static se.sundsvall.contractloader.service.Constants.ORGANIZATION_NAME_EXTENSION_DISPLAY;
import static se.sundsvall.contractloader.service.Constants.ORGANIZATION_NAME_EXTENSION_KEY;
import static se.sundsvall.contractloader.service.Constants.ORGANIZATION_NAME_EXTENSION_VALUE;
import static se.sundsvall.contractloader.service.Constants.SEK_CURRENCY;
import static se.sundsvall.contractloader.service.Constants.TOMTRATT;
import static se.sundsvall.contractloader.service.Constants.additionalInformationMapping;
import static se.sundsvall.contractloader.service.Constants.intervalTypeMapping;
import static se.sundsvall.contractloader.service.Constants.partyMapping;
import static se.sundsvall.contractloader.service.Constants.stakeholderTypeMapping;

@Component
public final class ContractProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContractProvider.class);
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final String HUNDRED_PERCENT = "100";
	private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
	private static final double ONE = 1;
	private static final String MONTH = "månad";
	private static final String YEAR = "år";
	private final PartyClient partyClient;
	private final EstateInfoClient estateInfoClient;

	public ContractProvider(PartyClient partyClient, EstateInfoClient estateInfoClient) {
		this.partyClient = partyClient;
		this.estateInfoClient = estateInfoClient;
	}

	public Contract toContract(final ArrendekontraktEntity arrendekontraktEntity) {
		return ofNullable(arrendekontraktEntity)
			.map(entity -> new Contract()
				.externalReferenceId(entity.getArrendekontrakt())
				.leaseType(toLeaseType(entity.getKontraktstyp()))
				.status(toStatus(entity))
				.type(toContractType(entity.getKontraktstyp()))
				.extraParameters(toExtraParameterGroups(entity))
				.stakeholders(toStakeholders(entity.getArrendatorer()))
				.propertyDesignations(getPropertyDesignations(entity.getFastighet()))
				.duration(toDuration(entity.getFromDatum(), entity.getTomDatum()))
				.fees(toFees(entity.getArrendekontraktsrader(), entity.getKontraktstyp()))
				.invoicing(toInvoicing(entity))
				.startDate(entity.getFromDatum())
				.endDate(toEnd(entity))
				.extension(toExtension(entity))
				.notice(toNotice(entity))
				.currentPeriod(toCurrentPeriod(entity))
				.area(toArea(entity.getKontraktsarea())))
			.orElse(null);
	}

	private static ContractType toContractType(String contractType) {
		if (contractType == null) {
			return LEASE_AGREEMENT;
		}
		return switch (contractType) {
			case ALLMAN_PLATSUPPLATELSE -> LAND_LEASE_PUBLIC;
			case TOMTRATT -> LEASEHOLD;
			default -> LEASE_AGREEMENT;
		};
	}

	private static LeaseType toLeaseType(String contractType) {
		return Constants.leaseTypeMapping.get(contractType);
	}

	private Status toStatus(final ArrendekontraktEntity arrendekontraktEntity) {
		if (Objects.nonNull(arrendekontraktEntity.getSistaDebiteringsdatum()) && arrendekontraktEntity.getSistaDebiteringsdatum().isBefore(LocalDate.now())) {
			return TERMINATED;
		}
		return ACTIVE;
	}

	private LocalDate toEnd(final ArrendekontraktEntity arrendekontraktEntity) {
		if (toStatus(arrendekontraktEntity) == TERMINATED) {
			return arrendekontraktEntity.getTomDatum();
		}
		return null;
	}

	private Invoicing toInvoicing(final ArrendekontraktEntity arrendekontraktEntity) {
		return ofNullable(arrendekontraktEntity)
			.map(ArrendekontraktEntity::getFakturaperiod)
			.filter(not(String::isBlank))
			.map(period -> new Invoicing()
				.invoiceInterval(intervalTypeMapping.get(period))
				.invoicedIn(ADVANCE)).orElse(null);
	}

	private Extension toExtension(final ArrendekontraktEntity arrendekontraktEntity) {
		final var extension = arrendekontraktEntity.getForlangning();
		final var leaseExtension = ofNullable(extension).map(this::toInteger).orElse(null);
		final var unit = ofNullable(arrendekontraktEntity.getEnhetForlangning())
			// There are only "månad" and "år" in the data
			.map(unit1 -> MONTH.equals(unit1) ? TimeUnit.MONTHS : TimeUnit.YEARS).orElse(null);

		return new Extension()
			.autoExtend(toAutoExtend(extension))
			.leaseExtension(leaseExtension)
			.unit(unit);
	}

	private Integer toArea(final String kontrakstarea) {
		return ofNullable(kontrakstarea)
			.map(this::toInteger)
			.orElse(null);
	}

	private Boolean toAutoExtend(final String extension) {
		if (isBlank(extension)) {
			return false;
		}
		Integer value = this.toInteger(extension);
		return value != null && value > 0;
	}

	private Notice toNotice(final ArrendekontraktEntity arrendekontraktEntity) {
		var terms = new ArrayList<NoticeTerm>();

		if (isNotEmpty(arrendekontraktEntity.getUppsTidArrendator())) {
			terms.add(toLesseeTerm(arrendekontraktEntity));
		}
		if (isNotEmpty(arrendekontraktEntity.getUppsTidHyresvard())) {
			terms.add(toLessorTerm(arrendekontraktEntity));
		}

		return new Notice()
			.noticeDate(arrendekontraktEntity.getUppsagtDatum())
			.noticeGivenBy(partyMapping.get(Optional.ofNullable(arrendekontraktEntity.getUppsagtAv()).orElse("")))
			.terms(terms);
	}

	private NoticeTerm toLesseeTerm(ArrendekontraktEntity arrendekontraktEntity) {
		return new NoticeTerm()
			.periodOfNotice(ofNullable(arrendekontraktEntity.getUppsTidArrendator()).map(this::toInteger).orElse(null))
			.unit(ofNullable(arrendekontraktEntity.getEnhetUppsTidArrendator())
				// There are only "månad" and "år" in the data
				.map(unit -> MONTH.equals(unit) ? TimeUnit.MONTHS : TimeUnit.YEARS)
				.orElse(null))
			.party(LESSEE);
	}

	private NoticeTerm toLessorTerm(ArrendekontraktEntity arrendekontraktEntity) {
		return new NoticeTerm()
			.periodOfNotice(ofNullable(arrendekontraktEntity.getUppsTidHyresvard()).map(this::toInteger).orElse(null))
			.unit(ofNullable(arrendekontraktEntity.getEnhetUppsTidHyresvard())
				// There are only "månad" and "år" in the data
				.map(unit -> MONTH.equals(unit) ? TimeUnit.MONTHS : TimeUnit.YEARS)
				.orElse(null))
			.party(Party.LESSOR);
	}

	private List<PropertyDesignation> getPropertyDesignations(final FastighetEntity fastighetEntity) {
		return ofNullable(fastighetEntity)
			.map(FastighetEntity::getFastighetsbeteckning)
			.filter(not(String::isBlank))
			.map(designation -> {
				var propertyDesignation = new PropertyDesignation().name(designation);
				try {
					var estates = estateInfoClient.getEstateByDesignation(MUNICIPALITY_ID, designation);
					// In getEstateByDesignation we get a list of estates which starts with the given designation,
					// we need to find the one which matches exactly to get the correct district
					propertyDesignation.district(getDistrictName(designation, estates));
				} catch (Exception e) {
					LOGGER.warn("Could not retrieve district for designation {}", designation, e);
				}
				return List.of(propertyDesignation);
			})
			.orElse(Collections.emptyList());
	}

	private String getDistrictName(String propertyDesignation, List<EstateDesignationResponse> estates) {
		if (estates == null || estates.isEmpty()) {
			return null;
		}
		return estates.stream()
			.filter(estate -> propertyDesignation.equals(estate.getDesignation()))
			.map(EstateDesignationResponse::getDistrictname)
			.filter(Objects::nonNull)
			.filter(not(String::isBlank))
			.findFirst()
			.orElse(null);
	}

	private List<ExtraParameterGroup> toExtraParameterGroups(final ArrendekontraktEntity arrendekontraktEntity) {
		var extraParameterGroups = new ArrayList<ExtraParameterGroup>();

		extraParameterGroups.add(createInvoiceInfoGroup(arrendekontraktEntity));
		extraParameterGroups.add(createContractDetailsGroup(arrendekontraktEntity));

		return extraParameterGroups;
	}

	private ExtraParameterGroup createInvoiceInfoGroup(
		final ArrendekontraktEntity arrendekontraktEntity) {

		var parameters = new LinkedHashMap<String, String>();

		final var article = ofNullable(arrendekontraktEntity.getArrendekontraktsrader())
			.orElse(emptyList())
			.stream()
			.filter(row -> Objects.nonNull(row.getDebiterasFromDatum()))
			.max(Comparator.comparing(ArrendekontraktsradEntity::getDebiterasFromDatum))
			.map(ArrendekontraktsradEntity::getAvitext);

		ofNullable(arrendekontraktEntity.getMarkning())
			.filter(not(String::isBlank))
			.ifPresent(marking -> parameters.put(INVOICE_INFO_MARKUP_PARAMETER, marking));
		article.filter(not(String::isBlank))
			.ifPresent(a -> parameters.put(INVOICE_INFO_ARTICLE_PARAMETER, a));

		return new ExtraParameterGroup()
			.name(INVOICE_INFO_GROUP_NAME)
			.parameters(parameters);
	}

	private ExtraParameterGroup createContractDetailsGroup(
		final ArrendekontraktEntity arrendekontraktEntity) {

		var parameters = new LinkedHashMap<String, String>();

		final var fileName = ofNullable(arrendekontraktEntity.getFastighet())
			.map(FastighetEntity::getNotering)
			.map(NoteringEntity::getFilnamn)
			.filter(not(String::isBlank));

		parameters.put(
			CONTRACT_DETAILS_MIGRATED_FROM_PARAMETER,
			CONTRACT_DETAILS_MIGRATED_FROM_VALUE);
		ofNullable(arrendekontraktEntity.getArrendekontrakt())
			.filter(not(String::isBlank))
			.ifPresent(n -> parameters.put(CONTRACT_DETAILS_CONTRACT_NUMBER_PARAMETER, n));
		ofNullable(arrendekontraktEntity.getKontraktsnamn())
			.filter(not(String::isBlank))
			.ifPresent(n -> parameters.put(CONTRACT_DETAILS_CONTRACT_NAME_PARAMETER, n));
		ofNullable(arrendekontraktEntity.getHuvudkontrakt())
			.filter(not(String::isBlank))
			.ifPresent(r -> parameters.put(CONTRACT_DETAILS_MAIN_CONTRACT_REFERENCE_PARAMETER, r));
		ofNullable(arrendekontraktEntity.getKontraktsdatum())
			.ifPresent(d -> parameters.put(
				CONTRACT_DETAILS_CONTRACT_DATE_PARAMETER, d.format(DATE_FORMAT)));
		ofNullable(arrendekontraktEntity.getSistaDebiteringsdatum())
			.ifPresent(d -> parameters.put(
				CONTRACT_DETAILS_FINAL_BILLING_DATE_PARAMETER, d.format(DATE_FORMAT)));
		ofNullable(arrendekontraktEntity.getUppsagtDatum())
			.ifPresent(d -> parameters.put(
				CONTRACT_DETAILS_TERMINATION_DATE_PARAMETER, d.format(DATE_FORMAT)));
		ofNullable(arrendekontraktEntity.getUppsagtAv())
			.filter(not(String::isBlank))
			.ifPresent(t -> parameters.put(CONTRACT_DETAILS_TERMINATED_BY_PARAMETER, t));
		ofNullable(arrendekontraktEntity.getKontraktstyp())
			.filter(not(String::isBlank))
			.ifPresent(t -> parameters.put(CONTRACT_DETAILS_ORIGINAL_CONTRACT_TYPE_PARAMETER, t));
		fileName
			.ifPresent(f -> parameters.put(CONTRACT_DETAILS_ORIGINAL_FILE_PARAMETER, f));

		return new ExtraParameterGroup()
			.name(CONTRACT_DETAILS_GROUP_NAME)
			.parameters(parameters);
	}

	private List<Stakeholder> toStakeholders(
		final List<ArrendatorEntity> arrendatorEntities) {

		var stakeholders = new ArrayList<Stakeholder>();
		stakeholders.add(createLessorStakeholder());
		if (arrendatorEntities != null) {
			stakeholders.addAll(arrendatorEntities.stream()
				.map(this::createStakeholder)
				.toList());
		}
		return stakeholders;
	}

	private Stakeholder createLessorStakeholder() {
		return new Stakeholder()
			.roles(List.of(StakeholderRole.LESSOR))
			.type(MUNICIPALITY)
			.organizationName(MUNICIPALITY_NAME)
			.partyId(MUNICIPALITY_PARTY_ID)
			.address(new Address()
				.type(POSTAL_ADDRESS)
				.postalCode(Constants.MUNICIPALITY_POSTAL_CODE)
				.town(Constants.MUNICIPALITY_TOWN))
			.parameters(List.of(new Parameter()
				.key(ORGANIZATION_NAME_EXTENSION_KEY)
				.displayName(ORGANIZATION_NAME_EXTENSION_DISPLAY)
				.addValuesItem(ORGANIZATION_NAME_EXTENSION_VALUE)));
	}

	private Stakeholder createStakeholder(
		final ArrendatorEntity arrendatorEntity) {

		final var type = ofNullable(stakeholderTypeMapping.get(arrendatorEntity.getKategori()))
			.orElse(OTHER);

		return new Stakeholder()
			.type(type)
			.roles(getRoles(arrendatorEntity))
			.organizationName(getOrganizationName(arrendatorEntity))
			.partyId(getPartyId(arrendatorEntity.getPersonOrgNr()))
			.emailAddress(getNullableString(arrendatorEntity.getEpost()))
			.phoneNumber(getPhoneNumber(arrendatorEntity))
			.firstName(getNullableString(arrendatorEntity.getFornamn()))
			.lastName(getNullableString(arrendatorEntity.getEfternamn()))
			.address(new Address()
				.type(POSTAL_ADDRESS)
				.careOf(getNullableString(arrendatorEntity.getAvdelning()))
				.postalCode(getNullableString(arrendatorEntity.getPostnummer()))
				.streetAddress(getStreetAddress(arrendatorEntity))
				.town(getNullableString(arrendatorEntity.getOrt()))
				.country(getNullableString(arrendatorEntity.getLand())));
	}

	private List<StakeholderRole> getRoles(
		final ArrendatorEntity arrendatorEntity) {

		if (ORDERING_FIRST.equals(arrendatorEntity.getOrdning())) {
			return List.of(StakeholderRole.LESSEE, StakeholderRole.PRIMARY_BILLING_PARTY);
		}
		return List.of(StakeholderRole.LESSEE, StakeholderRole.CONTACT_PERSON);
	}

	private String getNullableString(final String value) {
		return ofNullable(value).filter(not(String::isBlank)).orElse(null);
	}

	private String getPhoneNumber(final ArrendatorEntity arrendatorEntity) {
		final var mobileNumber = ofNullable(arrendatorEntity.getTelefonMobil())
			.orElse("");
		final var homeNumber = ofNullable(arrendatorEntity.getTelefonHem())
			.orElse("");
		final var workNumber = ofNullable(arrendatorEntity.getTelefonArbete())
			.orElse("");

		var phoneNumber = "";
		if (!mobileNumber.isBlank()) {
			phoneNumber = mobileNumber;
		}
		if (!homeNumber.isBlank()) {
			if (!phoneNumber.isBlank()) {
				phoneNumber = phoneNumber.concat(", " + homeNumber);
			} else {
				phoneNumber = homeNumber;
			}
		}
		if (!workNumber.isBlank()) {
			if (!phoneNumber.isBlank()) {
				phoneNumber = phoneNumber.concat(", " + workNumber);
			} else {
				phoneNumber = workNumber;
			}
		}
		return Optional.of(phoneNumber)
			.filter(not(String::isBlank))
			.orElse(null);
	}

	private String getPartyId(final String persOrgNr) {
		if (isBlank(persOrgNr)) {
			throw Problem.valueOf(PRECONDITION_FAILED, "Person- or organization number is blank");
		}
		var partyId = Optional.of("");
		try {
			partyId = partyClient.getPartyId(MUNICIPALITY_ID, ENTERPRISE, persOrgNr);
		} catch (Exception _) {
			LOGGER.warn("Could not retrieve partyId for organization number {}", persOrgNr);
		}
		if (partyId.isEmpty()) {
			partyId = partyClient.getPartyId(MUNICIPALITY_ID, PRIVATE, persOrgNr);
		}
		return partyId.orElseThrow(() -> Problem.valueOf(PRECONDITION_FAILED,
			"No partyId found for person- or organization number"));
	}

	private String getOrganizationName(final ArrendatorEntity arrendatorEntity) {
		return ofNullable(arrendatorEntity.getKategori())
			.filter(not(CATEGORY_PERSON::equals))
			.map(category -> arrendatorEntity.getNamn())
			.filter(not(String::isBlank))
			.orElse(null);
	}

	private String getStreetAddress(final ArrendatorEntity arrendatorEntity) {
		return ofNullable(arrendatorEntity.getPostadress())
			.map(address1 -> {
				var address = address1;
				if (!isBlank(arrendatorEntity.getPostadress2())) {
					address = address + ", " + arrendatorEntity.getPostadress2();
				}
				return address;
			})
			.orElse(null);
	}

	private Duration toDuration(LocalDate fromDate, LocalDate toDate) {
		if (isNull(fromDate) || isNull(toDate)) {
			return null;
		}
		final var durationInYears = ChronoUnit.YEARS.between(fromDate, toDate.plusDays(1));
		return new Duration()
			.leaseDuration(Math.toIntExact(durationInYears))
			.unit(TimeUnit.YEARS);
	}

	private Fees toFees(List<ArrendekontraktsradEntity> arrendekontraktsrader, String kontraktstyp) {
		final var additionalInformation = ofNullable(kontraktstyp)
			.map(type -> List.of(additionalInformationMapping.get(type)))
			.orElse(emptyList());
		return ofNullable(arrendekontraktsrader).orElse(emptyList())
			.stream()
			.filter(row -> Objects.nonNull(row.getDebiterasFromDatum()))
			.max(Comparator.comparing(ArrendekontraktsradEntity::getDebiterasFromDatum))
			.map(row -> new Fees()
				.currency(SEK_CURRENCY)
				.yearly(toBigDecimal(row.getBasarshyra()))
				.total(toBigDecimal(row.getBasarshyra()))
				.indexType(ofNullable(row.getIndexnamn()).filter(not(String::isBlank)).orElse(null))
				.indexYear(ofNullable(row.getIndexbasar()).map(this::toInteger).orElse(null))
				.indexNumber(ofNullable(row.getIndexbasvarde()).map(this::toInteger).orElse(null))
				.indexationRate(getIndexationRate(row))
				.additionalInformation(additionalInformation))
			.orElse(null);

	}

	private Period toCurrentPeriod(ArrendekontraktEntity arrendekontraktEntity) {
		if (isNull(arrendekontraktEntity.getFromDatum()) || isNull(arrendekontraktEntity.getTomDatum())) {
			return null;
		}

		var period = new Period()
			.startDate(arrendekontraktEntity.getFromDatum());
		final boolean autoExtend = toAutoExtend(arrendekontraktEntity.getForlangning());
		final boolean isTerminated = Optional.ofNullable(arrendekontraktEntity.getUppsagtDatum()).isPresent();
		final String extensionUnit = arrendekontraktEntity.getEnhetForlangning();

		if (autoExtend && !isTerminated) {
			Integer extension = toInteger(arrendekontraktEntity.getForlangning());

			// Validate extension value to prevent null pointer and infinite loops
			if (extension != null && extension > 0) {
				if (YEAR.equals(extensionUnit)) {
					period.endDate(calculateExtendedEndDate(arrendekontraktEntity.getFromDatum(), extension, ChronoUnit.YEARS));
				} else if (MONTH.equals(extensionUnit)) {
					period.endDate(calculateExtendedEndDate(arrendekontraktEntity.getFromDatum(), extension, ChronoUnit.MONTHS));
				} else {
					LOGGER.warn("Unexpected extension unit '{}' for contract {}, using tomDatum",
						extensionUnit, arrendekontraktEntity.getArrendekontrakt());
					period.endDate(arrendekontraktEntity.getTomDatum());
				}
			} else {
				// Invalid extension value, use tomDatum
				period.endDate(arrendekontraktEntity.getTomDatum());
			}
		} else if (isTerminated) {
			period.endDate(getEndDateWhenTerminated(arrendekontraktEntity));
		} else {
			period.endDate(arrendekontraktEntity.getTomDatum());
		}

		return period;
	}

	private LocalDate calculateExtendedEndDate(LocalDate startDate, int extensionValue, ChronoUnit unit) {
		var endDate = startDate;
		while (endDate.plus(extensionValue, unit).isBefore(LocalDate.now())) {
			endDate = endDate.plus(extensionValue, unit);
		}
		return endDate.plus(extensionValue, unit);
	}

	private LocalDate getEndDateWhenTerminated(ArrendekontraktEntity arrendekontraktEntity) {
		if (isNull(arrendekontraktEntity.getUppsagtDatum())) {
			return null;
		}

		Integer extension = toInteger(arrendekontraktEntity.getForlangning());
		String extensionUnit = arrendekontraktEntity.getEnhetForlangning();

		// Return termination date if no valid extension is configured
		if (extension == null || extension <= 0) {
			return arrendekontraktEntity.getUppsagtDatum();
		}

		if (YEAR.equals(extensionUnit)) {
			return arrendekontraktEntity.getUppsagtDatum().plusYears(extension);
		} else if (MONTH.equals(extensionUnit)) {
			return arrendekontraktEntity.getUppsagtDatum().plusMonths(extension);
		}

		return arrendekontraktEntity.getUppsagtDatum();
	}

	private BigDecimal getIndexationRate(ArrendekontraktsradEntity row) {
		if (isBlank(row.getIndexbasar()) || isBlank(row.getIndexbasvarde())) {
			return null;
		}
		final var indexRate = ofNullable(row.getIndexandel()).orElse(HUNDRED_PERCENT);
		if (isBlank(indexRate)) {
			// If index rate is blank default to 1.0 (100%)
			return BigDecimal.valueOf(ONE);
		}

		final var rate = toBigDecimal(indexRate);
		if (rate == null) {
			return BigDecimal.valueOf(ONE);
		}
		return rate.divide(HUNDRED);
	}

	private Integer toInteger(String value) {
		if (isBlank(value)) {
			return null;
		}

		try {
			return value.contains(",")
				? NumberFormat.getInstance(Locale.forLanguageTag("sv-SE")).parse(value).intValue()
				: Integer.parseInt(value);
		} catch (java.text.ParseException | NumberFormatException _) {
			return null;
		}
	}

	private BigDecimal toBigDecimal(String value) {
		if (isBlank(value)) {
			return null;
		}
		try {
			return value.contains(",")
				? BigDecimal.valueOf(NumberFormat.getInstance(Locale.forLanguageTag("sv-SE")).parse(value).doubleValue())
				: new BigDecimal(value);
		} catch (java.text.ParseException | NumberFormatException _) {
			return null;
		}
	}
}
