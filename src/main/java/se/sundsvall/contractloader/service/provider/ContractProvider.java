package se.sundsvall.contractloader.service.provider;

import static generated.se.sundsvall.contract.InvoicedIn.ADVANCE;
import static generated.se.sundsvall.contract.LeaseType.OTHER_FEE;
import static generated.se.sundsvall.contract.Party.LESSEE;
import static generated.se.sundsvall.contract.StakeholderType.MUNICIPALITY;
import static generated.se.sundsvall.contract.StakeholderType.OTHER;
import static generated.se.sundsvall.contract.TimeUnit.MONTHS;
import static generated.se.sundsvall.contract.TimeUnit.YEARS;
import static generated.se.sundsvall.party.PartyType.ENTERPRISE;
import static generated.se.sundsvall.party.PartyType.PRIVATE;
import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;
import static java.util.function.Predicate.not;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.zalando.problem.Status.PRECONDITION_FAILED;
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
import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_ORGANIZATION_NUMBER;
import static se.sundsvall.contractloader.service.Constants.ORDERING_FIRST;
import static se.sundsvall.contractloader.service.Constants.ORGANIZATION_NAME_EXTENSION_KEY;
import static se.sundsvall.contractloader.service.Constants.ORGANIZATION_NAME_EXTENSION_VALUE;
import static se.sundsvall.contractloader.service.Constants.SEK_CURRENCY;
import static se.sundsvall.contractloader.service.Constants.additionalInformationMapping;
import static se.sundsvall.contractloader.service.Constants.intervalTypeMapping;
import static se.sundsvall.contractloader.service.Constants.stakeholderTypeMapping;

import generated.se.sundsvall.contract.Address;
import generated.se.sundsvall.contract.AddressType;
import generated.se.sundsvall.contract.Contract;
import generated.se.sundsvall.contract.ContractType;
import generated.se.sundsvall.contract.Duration;
import generated.se.sundsvall.contract.Extension;
import generated.se.sundsvall.contract.ExtraParameterGroup;
import generated.se.sundsvall.contract.Fees;
import generated.se.sundsvall.contract.Invoicing;
import generated.se.sundsvall.contract.LeaseType;
import generated.se.sundsvall.contract.Notice;
import generated.se.sundsvall.contract.Parameter;
import generated.se.sundsvall.contract.Party;
import generated.se.sundsvall.contract.PropertyDesignation;
import generated.se.sundsvall.contract.Stakeholder;
import generated.se.sundsvall.contract.StakeholderRole;
import generated.se.sundsvall.contract.Status;
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
import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;
import se.sundsvall.contractloader.integration.db.model.ArrendatorEntity;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktEntity;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktsradEntity;
import se.sundsvall.contractloader.integration.db.model.FastighetEntity;
import se.sundsvall.contractloader.integration.db.model.NoteringEntity;
import se.sundsvall.contractloader.integration.party.PartyClient;
import se.sundsvall.contractloader.service.Constants;

@Component
public final class ContractProvider {

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final String HUNDRED_PERCENT = "100";
	private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
	private static final double ONE = 1;
	private static final String MONTH = "månad";
	private final PartyClient partyClient;

	public ContractProvider(PartyClient partyClient) {
		this.partyClient = partyClient;
	}

	public Contract toContract(final ArrendekontraktEntity arrendekontraktEntity) {
		return ofNullable(arrendekontraktEntity)
			.map(entity -> new Contract()
				.externalReferenceId(entity.getArrendekontrakt())
				.leaseType(toLeaseType(entity.getKontraktstyp()))
				.status(toStatus(entity))
				.type(ContractType.LEASE_AGREEMENT)
				.extraParameters(toExtraParameterGroups(entity))
				.stakeholders(toStakeholders(entity.getArrendatorer()))
				.propertyDesignations(getPropertyDesignations(entity.getFastigheter()))
				.duration(toDuration(entity.getFromDatum(), entity.getTomDatum()))
				.fees(toFees(entity.getArrendekontraktsrader(), entity.getKontraktstyp()))
				.invoicing(toInvoicing(entity))
				.start(entity.getFromDatum())
				.end(entity.getTomDatum())
				.extension(toExtension(entity))
				.notices(toNotices(entity))
				.area(toArea(entity.getKontraktsarea())))
			.orElse(null);
	}

	private static LeaseType toLeaseType(String contractType) {
		return ofNullable(Constants.leaseTypeMapping.get(contractType)).orElse(OTHER_FEE);
	}

	private Status toStatus(final ArrendekontraktEntity arrendekontraktEntity) {
		if (isNull(arrendekontraktEntity.getTomDatum()) || arrendekontraktEntity.getTomDatum().isAfter(LocalDate.now())) {
			return Status.ACTIVE;
		} else if (arrendekontraktEntity.getTomDatum().isBefore(LocalDate.now()) || Objects.nonNull(arrendekontraktEntity.getSistaDebiteringsdatum())) {
			return Status.TERMINATED;
		}
		return Status.ACTIVE;
	}

	private Invoicing toInvoicing(final ArrendekontraktEntity arrendekontraktEntity) {
		return ofNullable(arrendekontraktEntity)
			.map(entity -> new Invoicing()
				.invoiceInterval(intervalTypeMapping.get(entity.getFakturaperiod()))
				.invoicedIn(ADVANCE)).orElse(null);
	}

	private Extension toExtension(final ArrendekontraktEntity arrendekontraktEntity) {
		final var extension = arrendekontraktEntity.getForlangning();
		final var autoExtend = isNotEmpty(extension) && this.toInteger(extension) > 0;
		final var leaseExtension = ofNullable(extension).map(this::toInteger).orElse(null);
		final var unit = ofNullable(arrendekontraktEntity.getEnhetForlangning())
			// There are only "månad" and "år" in the data
			.map(unit1 -> MONTH.equals(unit1) ? MONTHS : YEARS).orElse(null);

		return new Extension()
			.autoExtend(autoExtend)
			.leaseExtension(leaseExtension)
			.unit(unit);
	}

	private Integer toArea(final String kontrakstarea) {
		return ofNullable(kontrakstarea)
			.map(this::toInteger)
			.orElse(null);
	}

	private List<Notice> toNotices(final ArrendekontraktEntity arrendekontraktEntity) {
		var notices = new ArrayList<Notice>();
		if (isNotEmpty(arrendekontraktEntity.getUppsTidArrendator())) {
			notices.add(toLesseeNotice(arrendekontraktEntity));
		}
		if (isNotEmpty(arrendekontraktEntity.getUppsTidHyresvard())) {
			notices.add(toLessorNotice(arrendekontraktEntity));
		}
		return notices;
	}

	private Notice toLesseeNotice(ArrendekontraktEntity arrendekontraktEntity) {
		return new Notice()
			.periodOfNotice(ofNullable(arrendekontraktEntity.getUppsTidArrendator()).map(this::toInteger).orElse(null))
			.unit(ofNullable(arrendekontraktEntity.getEnhetUppsTidArrendator())
				// There are only "månad" and "år" in the data
				.map(unit -> MONTH.equals(unit) ? MONTHS : YEARS)
				.orElse(null))
			.party(LESSEE);
	}

	private Notice toLessorNotice(ArrendekontraktEntity arrendekontraktEntity) {
		return new Notice()
			.periodOfNotice(ofNullable(arrendekontraktEntity.getUppsTidHyresvard()).map(this::toInteger).orElse(null))
			.unit(ofNullable(arrendekontraktEntity.getUppsTidHyresvard())
				// There are only "månad" and "år" in the data
				.map(unit -> MONTH.equals(unit) ? MONTHS : YEARS)
				.orElse(null))
			.party(Party.LESSOR);
	}

	private static List<PropertyDesignation> getPropertyDesignations(final List<FastighetEntity> fastighetEntities) {
		if (fastighetEntities == null) {
			return Collections.emptyList();
		}
		return fastighetEntities.stream()
			.map(entity -> new PropertyDesignation()
				.name(entity.getFastighetsbeteckning()))
			.filter(Objects::nonNull)
			.toList();
	}

	private List<ExtraParameterGroup> toExtraParameterGroups(final ArrendekontraktEntity arrendekontraktEntity) {
		var extraParameterGroups = new ArrayList<ExtraParameterGroup>();

		extraParameterGroups.add(createInvoiceInfoGroup(arrendekontraktEntity));
		extraParameterGroups.add(createContractDetailsGroup(arrendekontraktEntity));

		return extraParameterGroups;
	}

	private ExtraParameterGroup createInvoiceInfoGroup(final ArrendekontraktEntity arrendekontraktEntity) {
		var parameters = new LinkedHashMap<String, String>();

		final var article = ofNullable(arrendekontraktEntity.getArrendekontraktsrader()).orElse(emptyList())
			.stream()
			.filter(row -> Objects.nonNull(row.getDebiterasFromDatum()))
			.max(Comparator.comparing(ArrendekontraktsradEntity::getDebiterasFromDatum))
			.map(ArrendekontraktsradEntity::getAvitext);

		ofNullable(arrendekontraktEntity.getMarkning()).ifPresent(marking -> parameters.put(INVOICE_INFO_MARKUP_PARAMETER, marking));
		article.ifPresent(article1 -> parameters.put(INVOICE_INFO_ARTICLE_PARAMETER, article1));

		return new ExtraParameterGroup()
			.name(INVOICE_INFO_GROUP_NAME)
			.parameters(parameters);
	}

	private ExtraParameterGroup createContractDetailsGroup(final ArrendekontraktEntity arrendekontraktEntity) {
		var parameters = new LinkedHashMap<String, String>();

		final var fileName = ofNullable(arrendekontraktEntity.getFastigheter()).orElse(emptyList()).stream()
			.map(FastighetEntity::getNoteringar)
			.filter(Objects::nonNull)
			.flatMap(List::stream)
			.filter(Objects::nonNull)
			.map(NoteringEntity::getFilnamn)
			.findFirst();

		parameters.put(CONTRACT_DETAILS_MIGRATED_FROM_PARAMETER, CONTRACT_DETAILS_MIGRATED_FROM_VALUE);
		ofNullable(arrendekontraktEntity.getArrendekontrakt()).ifPresent(contractNumber -> parameters.put(CONTRACT_DETAILS_CONTRACT_NUMBER_PARAMETER, contractNumber));
		ofNullable(arrendekontraktEntity.getKontraktsnamn()).ifPresent(contractName -> parameters.put(CONTRACT_DETAILS_CONTRACT_NAME_PARAMETER, contractName));
		ofNullable(arrendekontraktEntity.getHuvudkontrakt()).ifPresent(mainContractReference -> parameters.put(CONTRACT_DETAILS_MAIN_CONTRACT_REFERENCE_PARAMETER, mainContractReference));
		ofNullable(arrendekontraktEntity.getKontraktsdatum()).ifPresent(contractDate -> parameters.put(CONTRACT_DETAILS_CONTRACT_DATE_PARAMETER, contractDate.format(DATE_FORMAT)));
		ofNullable(arrendekontraktEntity.getSistaDebiteringsdatum()).ifPresent(finalBillingDate -> parameters.put(CONTRACT_DETAILS_FINAL_BILLING_DATE_PARAMETER, finalBillingDate.format(DATE_FORMAT)));
		ofNullable(arrendekontraktEntity.getUppsagtDatum()).ifPresent(terminationDate -> parameters.put(CONTRACT_DETAILS_TERMINATION_DATE_PARAMETER, terminationDate.format(DATE_FORMAT)));
		ofNullable(arrendekontraktEntity.getUppsagtAv()).ifPresent(terminatedBy -> parameters.put(CONTRACT_DETAILS_TERMINATED_BY_PARAMETER, terminatedBy));
		ofNullable(arrendekontraktEntity.getKontraktstyp()).ifPresent(contractType -> parameters.put(CONTRACT_DETAILS_ORIGINAL_CONTRACT_TYPE_PARAMETER, contractType));
		fileName.ifPresent(file -> parameters.put(CONTRACT_DETAILS_ORIGINAL_FILE_PARAMETER, file));

		return new ExtraParameterGroup()
			.name(CONTRACT_DETAILS_GROUP_NAME)
			.parameters(parameters);
	}

	private List<Stakeholder> toStakeholders(final List<ArrendatorEntity> arrendatorEntities) {
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
			.organizationNumber(MUNICIPALITY_ORGANIZATION_NUMBER)
			.address(new Address()
				.postalCode(Constants.MUNICIPALITY_POSTAL_CODE)
				.town(Constants.MUNICIPALITY_TOWN))
			.parameters(List.of(new Parameter()
				.key(ORGANIZATION_NAME_EXTENSION_KEY)
				.addValuesItem(ORGANIZATION_NAME_EXTENSION_VALUE)));
	}

	private Stakeholder createStakeholder(final ArrendatorEntity arrendatorEntity) {
		return new Stakeholder()
			.type(ofNullable(stakeholderTypeMapping.get(arrendatorEntity.getKategori())).orElse(OTHER))
			.roles(getRoles(arrendatorEntity))
			.organizationName(getOrganizationName(arrendatorEntity))
			.partyId(getPartyId(arrendatorEntity.getPersonOrgNr()))
			.emailAddress(arrendatorEntity.getEpost())
			.phoneNumber(getPhoneNumber(arrendatorEntity))
			.firstName(arrendatorEntity.getFornamn())
			.lastName(arrendatorEntity.getEfternamn())
			.address(new Address()
				.type(AddressType.POSTAL_ADDRESS)
				.careOf(arrendatorEntity.getAvdelning())
				.postalCode(arrendatorEntity.getPostnummer())
				.streetAddress(getStreetAddress(arrendatorEntity))
				.town(arrendatorEntity.getPostnummer())
				.country(arrendatorEntity.getLand()));

	}

	private List<StakeholderRole> getRoles(ArrendatorEntity arrendatorEntity) {
		if (ORDERING_FIRST.equals(arrendatorEntity.getOrdning())) {
			return List.of(StakeholderRole.LESSEE, StakeholderRole.PRIMARY_BILLING_PARTY);
		}
		return List.of(StakeholderRole.LESSEE, StakeholderRole.CONTACT_PERSON);
	}

	private String getPhoneNumber(final ArrendatorEntity arrendatorEntity) {
		final var mobileNumber = ofNullable(arrendatorEntity.getTelefonMobil()).orElse("");
		final var homeNumber = ofNullable(arrendatorEntity.getTelefonHem()).orElse("");
		final var workNumber = ofNullable(arrendatorEntity.getTelefonArbete()).orElse("");

		var phoneNumber = "";
		if (!mobileNumber.isEmpty()) {
			phoneNumber = mobileNumber;
		}
		if (!homeNumber.isEmpty()) {
			if (!phoneNumber.isEmpty()) {
				phoneNumber = phoneNumber.concat(", " + homeNumber);
			} else {
				phoneNumber = homeNumber;
			}
		}
		if (!workNumber.isEmpty()) {
			if (!phoneNumber.isEmpty()) {
				phoneNumber = phoneNumber.concat(", " + workNumber);
			} else {
				phoneNumber = workNumber;
			}
		}
		return phoneNumber;
	}

	private String getPartyId(final String persOrgNr) {
		if (isBlank(persOrgNr)) {
			throw Problem.valueOf(PRECONDITION_FAILED, "Person- or organization number is blank");
		}
		var partyId = partyClient.getPartyId(MUNICIPALITY_ID, ENTERPRISE, persOrgNr);
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
		final var durationInYears = ChronoUnit.YEARS.between(fromDate, toDate);
		return new Duration()
			.leaseDuration(Math.toIntExact(durationInYears))
			.unit(YEARS);
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
				.indexType(row.getIndexnamn())
				.indexYear(ofNullable(row.getIndexbasar()).map(this::toInteger).orElse(null))
				.indexNumber(ofNullable(row.getIndexbasvarde()).map(this::toInteger).orElse(null))
				.indexationRate(getIndexationRate(row))
				.additionalInformation(additionalInformation))
			.orElse(null);

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
		try {
			return value.contains(",")
				? BigDecimal.valueOf(NumberFormat.getInstance(Locale.forLanguageTag("sv-SE")).parse(value).doubleValue())
				: new BigDecimal(value);
		} catch (java.text.ParseException | NumberFormatException _) {
			return null;
		}
	}
}
