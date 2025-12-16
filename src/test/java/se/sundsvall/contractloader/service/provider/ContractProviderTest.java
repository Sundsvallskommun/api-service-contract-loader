package se.sundsvall.contractloader.service.provider;

import static generated.se.sundsvall.contract.ContractType.LEASE_AGREEMENT;
import static generated.se.sundsvall.contract.LeaseType.USUFRUCT_MOORING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static se.sundsvall.contractloader.service.Constants.BATPLATS;
import static se.sundsvall.contractloader.service.Constants.CATEGORY_PERSON;

import generated.se.sundsvall.contract.Contract;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
		//TODO: Complete mapping assertions
		// Is Organization and therefore uses org number of the second call
		verify(partyClient, times(2)).getPartyId(anyString(), any(), anyString());
		verifyNoMoreInteractions(partyClient);
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
			.withFakturaperiod("halvår")
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
					.withFilnamn("filnamn-1")))
		);
	}

	private List<ArrendekontraktsradEntity> createArrendekontraktsrader() {
		return List.of(
			new ArrendekontraktsradEntity()
				.withArrendekontrakt("arrendekontrakt-1")
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
