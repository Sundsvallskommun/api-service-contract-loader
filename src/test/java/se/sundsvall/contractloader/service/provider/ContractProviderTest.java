package se.sundsvall.contractloader.service.provider;

import static generated.se.sundsvall.contract.AddressType.POSTAL_ADDRESS;
import static generated.se.sundsvall.contract.ContractType.LEASE_AGREEMENT;
import static generated.se.sundsvall.contract.IntervalType.YEARLY;
import static generated.se.sundsvall.contract.InvoicedIn.ADVANCE;
import static generated.se.sundsvall.contract.LeaseType.USUFRUCT_MOORING;
import static generated.se.sundsvall.contract.StakeholderRole.CONTACT_PERSON;
import static generated.se.sundsvall.contract.StakeholderRole.LESSEE;
import static generated.se.sundsvall.contract.StakeholderRole.LESSOR;
import static generated.se.sundsvall.contract.StakeholderRole.PRIMARY_BILLING_PARTY;
import static generated.se.sundsvall.contract.StakeholderType.MUNICIPALITY;
import static generated.se.sundsvall.contract.StakeholderType.ORGANIZATION;
import static generated.se.sundsvall.contract.StakeholderType.PERSON;
import static generated.se.sundsvall.contract.Status.TERMINATED;
import static generated.se.sundsvall.contract.TimeUnit.YEARS;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.zalando.problem.Status.PRECONDITION_FAILED;
import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_NAME;
import static se.sundsvall.contractloader.service.Constants.MUNICIPALITY_ORGANIZATION_NUMBER;

import generated.se.sundsvall.contract.Address;
import generated.se.sundsvall.contract.Contract;
import generated.se.sundsvall.contract.Duration;
import generated.se.sundsvall.contract.Extension;
import generated.se.sundsvall.contract.ExtraParameterGroup;
import generated.se.sundsvall.contract.Invoicing;
import generated.se.sundsvall.contract.Notice;
import generated.se.sundsvall.contract.Parameter;
import generated.se.sundsvall.contract.Party;
import generated.se.sundsvall.contract.Stakeholder;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.zalando.problem.ThrowableProblem;
import se.sundsvall.contractloader.integration.db.model.ArrendatorEntity;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktEntity;
import se.sundsvall.contractloader.integration.db.model.ArrendekontraktsradEntity;
import se.sundsvall.contractloader.integration.db.model.FastighetEntity;
import se.sundsvall.contractloader.integration.db.model.NoteringEntity;
import se.sundsvall.contractloader.integration.party.PartyClient;
import se.sundsvall.contractloader.service.Constants;

@ExtendWith(MockitoExtension.class)
class ContractProviderTest {

	@Mock
	private PartyClient partyClient;

	@InjectMocks
	private ContractProvider contractProvider;

	@Test
	void toContract() {
		// Arrange
		final var arrendekontraktEntity = createArrendekontrakt();

		when(partyClient.getPartyId(anyString(), any(), anyString())).thenReturn(Optional.of("partyId-1"));

		// Call
		final Contract contract = contractProvider.toContract(arrendekontraktEntity);

		// Assert and verify
		assertThat(contract).isNotNull();
		assertThat(contract.getExternalReferenceId()).isEqualTo(arrendekontraktEntity.getArrendekontrakt());
		assertThat(contract.getType()).isEqualTo(LEASE_AGREEMENT);
		assertThat(contract.getLeaseType()).isEqualTo(USUFRUCT_MOORING);
		assertThat(contract.getStatus()).isEqualTo(TERMINATED);
		assertThat(contract.getDuration()).isEqualTo(new Duration().leaseDuration(0).unit(YEARS));
		assertThat(contract.getInvoicing()).isEqualTo(new Invoicing().invoicedIn(ADVANCE).invoiceInterval(YEARLY));
		assertThat(contract.getStart()).isEqualTo(arrendekontraktEntity.getFromDatum());
		assertThat(contract.getEnd()).isEqualTo(arrendekontraktEntity.getTomDatum());
		assertThat(contract.getExtension()).isEqualTo(new Extension().leaseExtension(1).autoExtend(true).unit(YEARS));
		assertThat(contract.getNotices()).hasSize(2)
			.extracting(
				Notice::getParty,
				Notice::getPeriodOfNotice,
				generated.se.sundsvall.contract.Notice::getUnit)
			.containsExactlyInAnyOrder(
				tuple(Party.LESSOR, 6, YEARS),
				tuple(Party.LESSEE, 10, YEARS));
		assertThat(contract.getArea()).isEqualTo(7780);

		assertThat(contract.getExtraParameters()).filteredOn(extraParameterGroup -> extraParameterGroup.getName().equals("InvoiceInfo"))
			.extracting(ExtraParameterGroup::getParameters)
			.flatExtracting(Map::entrySet)
			.extracting(Map.Entry::getKey, Map.Entry::getValue)
			.containsExactlyInAnyOrder(
				tuple("markup", arrendekontraktEntity.getMarkning()),
				tuple("article", arrendekontraktEntity.getArrendekontraktsrader().getFirst().getAvitext()));

		assertThat(contract.getExtraParameters()).filteredOn(extraParameterGroup -> extraParameterGroup.getName().equals("ContractDetails"))
			.extracting(ExtraParameterGroup::getParameters)
			.flatExtracting(Map::entrySet)
			.extracting(Map.Entry::getKey, Map.Entry::getValue)
			.containsExactlyInAnyOrder(
				tuple("migratedFrom", "Xpand"),
				tuple("contractNumber", arrendekontraktEntity.getArrendekontrakt()),
				tuple("mainContractReference", arrendekontraktEntity.getHuvudkontrakt()),
				tuple("contractDate", arrendekontraktEntity.getKontraktsdatum().toString()),
				tuple("finalBillingDate", arrendekontraktEntity.getSistaDebiteringsdatum().toString()),
				tuple("terminationDate", arrendekontraktEntity.getUppsagtDatum().toString()),
				tuple("terminatedBy", arrendekontraktEntity.getUppsagtAv()),
				tuple("originalContractType", arrendekontraktEntity.getKontraktstyp()),
				tuple("originalContractFilename", arrendekontraktEntity.getFastigheter().getFirst().getNoteringar().getFirst().getFilnamn()));

		assertThat(contract.getStakeholders()).hasSize(3)
			.extracting(
				Stakeholder::getType,
				Stakeholder::getOrganizationName,
				Stakeholder::getPartyId,
				Stakeholder::getRoles,
				Stakeholder::getAddress,
				Stakeholder::getOrganizationNumber,
				Stakeholder::getParameters)
			.containsExactly(
				tuple(MUNICIPALITY,
					MUNICIPALITY_NAME,
					null,
					List.of(LESSOR),
					new Address()
						.type(POSTAL_ADDRESS)
						.postalCode(Constants.MUNICIPALITY_POSTAL_CODE)
						.town(Constants.MUNICIPALITY_TOWN),
					MUNICIPALITY_ORGANIZATION_NUMBER,
					List.of(new Parameter()
						.key(Constants.ORGANIZATION_NAME_EXTENSION_KEY)
						.displayName(Constants.ORGANIZATION_NAME_EXTENSION_DISPLAY)
						.addValuesItem(Constants.ORGANIZATION_NAME_EXTENSION_VALUE))),
				tuple(PERSON,
					null,
					"partyId-1",
					List.of(LESSEE, PRIMARY_BILLING_PARTY),
					new Address()
						.type(POSTAL_ADDRESS)
						.streetAddress("postadress-1, postadress2-1")
						.careOf("avdelning-1")
						.postalCode("postnummer-1")
						.town("ort-1")
						.country("land-1"),
					null,
					emptyList()),
				tuple(ORGANIZATION,
					"namn-2",
					"partyId-1",
					List.of(LESSEE, CONTACT_PERSON),
					new Address()
						.type(POSTAL_ADDRESS)
						.streetAddress("postadress-2")
						.postalCode("postnummer-2")
						.town("ort-2")
						.country("land-2"),
					null,
					emptyList()));

		// Is Organization and therefore uses org number of the second call
		verify(partyClient, times(2)).getPartyId(anyString(), any(), anyString());
		verifyNoMoreInteractions(partyClient);
	}

	@Test
	void toContractWhenPartyIdNotFound() {
		// Arrange
		final var arrendekontraktEntity = createArrendekontrakt();

		when(partyClient.getPartyId(anyString(), any(), anyString())).thenReturn(Optional.empty());

		// Call
		final var exception = assertThrows(ThrowableProblem.class, () -> contractProvider.toContract(arrendekontraktEntity));

		assertThat(exception.getStatus()).isEqualTo(PRECONDITION_FAILED);
		assertThat(exception.getTitle()).isEqualTo(PRECONDITION_FAILED.getReasonPhrase());
		assertThat(exception.getDetail()).isEqualTo("No partyId found for person- or organization number");

		// Verify
		verify(partyClient, times(2)).getPartyId(anyString(), any(), anyString());
		verifyNoMoreInteractions(partyClient);
	}

	@Test
	void toContractWhenNullContract() {

		final var contract = contractProvider.toContract(null);

		assertThat(contract).isNull();
		verifyNoInteractions(partyClient);
	}

	private ArrendekontraktEntity createArrendekontrakt() {
		return new ArrendekontraktEntity()
			.withArrendekontrakt("arrendekontrakt-1")
			.withKontraktstyp("BÅTPLATS")
			.withMarkning("markning-1")
			.withFromDatum(LocalDate.of(2023, 1, 1))
			.withTomDatum(LocalDate.of(2023, 12, 31))
			.withKontraktsdatum(LocalDate.of(2022, 12, 15))
			.withSistaDebiteringsdatum(LocalDate.of(2023, 11, 30))
			.withUppsagtDatum(LocalDate.of(2023, 6, 30))
			.withUppsagtAv("uppsagtAv-1")
			.withDebiteringstyp("debiteringstyp-1")
			.withKontraktsarea("kontraktsarea-1")
			.withHyresid("hyresid-1")
			.withHuvudkontrakt("huvudkontrakt-1")
			.withUppsTidArrendator("10")
			.withEnhetUppsTidArrendator("år")
			.withUppsTidHyresvard("6")
			.withEnhetUppsTidHyresvard("månad")
			.withForlangning("1")
			.withEnhetForlangning("år")
			.withKontraktsarea("7780,00")
			.withFakturaperiod("år")
			.withArrendekontraktsrader(createArrendekontraktsrader())
			.withArrendatorer(createArrendatorer())
			.withFastigheter(createFastigheter());
	}

	private List<ArrendatorEntity> createArrendatorer() {
		return List.of(
			new ArrendatorEntity()
				.withArrendekontrakt("arrendekontrakt-1")
				.withKategori("Person")
				.withOrdning("1")
				.withNamn("namn-1")
				.withFornamn("fornamn-1")
				.withEfternamn("efternamn-1")
				.withPersonOrgNr("personOrgNr-1")
				.withTelefonMobil("telefonMobil-1")
				.withTelefonHem("telefonHem-1")
				.withTelefonArbete("telefonArbete-1")
				.withEpost("epost-1")
				.withPostadress("postadress-1")
				.withPostadress2("postadress2-1")
				.withAvdelning("avdelning-1")
				.withPostnummer("postnummer-1")
				.withOrt("ort-1")
				.withLand("land-1"),
			new ArrendatorEntity()
				.withArrendekontrakt("arrendekontrakt-1")
				.withKategori(Constants.CATEGORY_COMPANY)
				.withOrdning("2")
				.withNamn("namn-2")
				.withPersonOrgNr("personOrgNr-2")
				.withTelefonArbete("telefonArbete-2")
				.withEpost("epost-2")
				.withPostadress("postadress-2")
				.withPostnummer("postnummer-2")
				.withOrt("ort-2")
				.withLand("land-2"));
	}

	private List<FastighetEntity> createFastigheter() {
		return List.of(
			new FastighetEntity()
				.withFastighetsnr("fastighetsnr-1")
				.withFastighetsbeteckning("fastighetsbeteckning-1")
				.withHyresid("hyresid-1")
				.withNoteringar(List.of(new NoteringEntity()
					.withFastighetsnr("fastighetsnr-1")
					.withFilnamn("filnamn-1"))));
	}

	private List<ArrendekontraktsradEntity> createArrendekontraktsrader() {
		return List.of(
			new ArrendekontraktsradEntity()
				.withArrendekontrakt("arrendekontrakt-1")
				.withAvitext("Avitext för rad 1")
				.withBasarshyra("5000,00")
				.withArshyra("5000,00")
				.withIndexnamn("KPI 80")
				.withIndexbasar("2014")
				.withIndexbasvarde("300,00")
				.withIndexNuvarandeAr("2023")
				.withIndexNuvarandeVarde("350,00")
				.withIndexandel("50")
				.withDebiterasFromDatum(LocalDate.of(2025, 1, 1)),
			new ArrendekontraktsradEntity()
				.withArrendekontrakt("arrendekontrakt-1")
				.withDebiterasFromDatum(LocalDate.of(2023, 1, 1))
				.withDebiterasTomDatum(LocalDate.of(2023, 12, 31))
				.withAvitext("Avitext för rad 2")
				.withIndexandel("100")
				.withIndexNuvarandeVarde("400,00")
				.withBasarshyra("2000,00")
				.withArshyra("2000,00")
				.withIndexnamn("KPI 80")
				.withIndexbasar("2014")
				.withIndexbasvarde("300,00")
				.withIndexNuvarandeAr("2023"));
	}
}
