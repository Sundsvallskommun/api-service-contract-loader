package se.sundsvall.contractloader.integration.db.model;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.allOf;

import com.google.code.beanmatchers.BeanMatchers;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.sundsvall.contractloader.integration.db.model.enums.SendStatus;

class ArrendekontraktEntityTest {

	@BeforeAll
	static void setup() {
		BeanMatchers.registerValueGenerator(() -> now().plusDays(new Random().nextInt()), LocalDate.class);
	}

	@Test
	void testBean() {
		MatcherAssert.assertThat(ArrendekontraktEntity.class, allOf(
			hasValidBeanConstructor(),
			hasValidGettersAndSetters(),
			hasValidBeanHashCode(),
			hasValidBeanEquals(),
			hasValidBeanToString()));
	}

	@Test
	void testBuilderMethods() {

		final var id = 1L;
		final var arrendekontrakt = "arrendekontrakt";
		final var hyresid = "hyresid";
		final var kontraktsdatum = LocalDate.now();
		final var fromDatum = LocalDate.now();
		final var tomDatum = LocalDate.now();
		final var sistaDebiteringsdatum = LocalDate.now();
		final var godkantDatum = LocalDate.now();
		final var uppsagtDatum = LocalDate.now();
		final var uppsagtAv = "uppsagtAv";
		final var preliminartUppsagtDatum = LocalDate.now();
		final var onskadAvflyttning = LocalDate.now().plusDays(10);
		final var kontraktstyp = "kontraktstyp";
		final var uppsTidArrendator = "uppsTidArrendator";
		final var enhetUppsTidArrendator = "enhetUppsTidArrendator";
		final var uppsTidHyresvard = "uppsTidHyresvard";
		final var enhetUppsTidHyresvard = "enhetUppsTidHyresvard";
		final var forlangning = "forlangning";
		final var enhetForlangning = "enhetForlangning";
		final var debiteringstyp = "debiteringstyp";
		final var kontraktsarea = "kontraktsarea";
		final var frifalt = "frifalt";
		final var fakturaperiod = "fakturaperiod";
		final var markning = "markning";
		final var kontraktsnamn = "kontraktsnamn";
		final var huvudkontrakt = "huvudkontrakt";
		final var kopplatTillId = "kopplatTillId";
		final var sendStatus = SendStatus.SENT;
		final var arrendatorEntities = List.of(ArrendatorEntity.create());
		final var arrendeKontratsraderEntities = List.of(ArrendekontraktsradEntity.create());
		final var fastighetEntity = FastighetEntity.create();

		var arrendekontraktEntity = ArrendekontraktEntity.create()
			.withId(id)
			.withArrendekontrakt(arrendekontrakt)
			.withHyresid(hyresid)
			.withKontraktsdatum(kontraktsdatum)
			.withFromDatum(fromDatum)
			.withTomDatum(tomDatum)
			.withSistaDebiteringsdatum(sistaDebiteringsdatum)
			.withGodkantDatum(godkantDatum)
			.withUppsagtDatum(uppsagtDatum)
			.withUppsagtAv(uppsagtAv)
			.withPreliminartUppsagtDatum(preliminartUppsagtDatum)
			.withOnskadAvflyttning(onskadAvflyttning)
			.withKontraktstyp(kontraktstyp)
			.withUppsTidArrendator(uppsTidArrendator)
			.withEnhetUppsTidArrendator(enhetUppsTidArrendator)
			.withUppsTidHyresvard(uppsTidHyresvard)
			.withEnhetUppsTidHyresvard(enhetUppsTidHyresvard)
			.withForlangning(forlangning)
			.withEnhetForlangning(enhetForlangning)
			.withDebiteringstyp(debiteringstyp)
			.withKontraktsarea(kontraktsarea)
			.withFrifalt(frifalt)
			.withFakturaperiod(fakturaperiod)
			.withMarkning(markning)
			.withKontraktsnamn(kontraktsnamn)
			.withHuvudkontrakt(huvudkontrakt)
			.withKopplatTillId(kopplatTillId)
			.withSendStatus(sendStatus)
			.withArrendatorer(arrendatorEntities)
			.withArrendekontraktsrader(arrendeKontratsraderEntities)
			.withFastighet(fastighetEntity);

		assertThat(arrendekontraktEntity).hasNoNullFieldsOrProperties();
		assertThat(arrendekontraktEntity.getId()).isEqualTo(id);
		assertThat(arrendekontraktEntity.getArrendekontrakt()).isEqualTo(arrendekontrakt);
		assertThat(arrendekontraktEntity.getHyresid()).isEqualTo(hyresid);
		assertThat(arrendekontraktEntity.getKontraktsdatum()).isEqualTo(kontraktsdatum);
		assertThat(arrendekontraktEntity.getFromDatum()).isEqualTo(fromDatum);
		assertThat(arrendekontraktEntity.getTomDatum()).isEqualTo(tomDatum);
		assertThat(arrendekontraktEntity.getSistaDebiteringsdatum()).isEqualTo(sistaDebiteringsdatum);
		assertThat(arrendekontraktEntity.getGodkantDatum()).isEqualTo(godkantDatum);
		assertThat(arrendekontraktEntity.getUppsagtDatum()).isEqualTo(uppsagtDatum);
		assertThat(arrendekontraktEntity.getUppsagtAv()).isEqualTo(uppsagtAv);
		assertThat(arrendekontraktEntity.getPreliminartUppsagtDatum()).isEqualTo(preliminartUppsagtDatum);
		assertThat(arrendekontraktEntity.getOnskadAvflyttning()).isEqualTo(onskadAvflyttning);
		assertThat(arrendekontraktEntity.getKontraktstyp()).isEqualTo(kontraktstyp);
		assertThat(arrendekontraktEntity.getUppsTidArrendator()).isEqualTo(uppsTidArrendator);
		assertThat(arrendekontraktEntity.getEnhetUppsTidArrendator()).isEqualTo(enhetUppsTidArrendator);
		assertThat(arrendekontraktEntity.getUppsTidHyresvard()).isEqualTo(uppsTidHyresvard);
		assertThat(arrendekontraktEntity.getEnhetUppsTidHyresvard()).isEqualTo(enhetUppsTidHyresvard);
		assertThat(arrendekontraktEntity.getForlangning()).isEqualTo(forlangning);
		assertThat(arrendekontraktEntity.getEnhetForlangning()).isEqualTo(enhetForlangning);
		assertThat(arrendekontraktEntity.getDebiteringstyp()).isEqualTo(debiteringstyp);
		assertThat(arrendekontraktEntity.getKontraktsarea()).isEqualTo(kontraktsarea);
		assertThat(arrendekontraktEntity.getFrifalt()).isEqualTo(frifalt);
		assertThat(arrendekontraktEntity.getFakturaperiod()).isEqualTo(fakturaperiod);
		assertThat(arrendekontraktEntity.getMarkning()).isEqualTo(markning);
		assertThat(arrendekontraktEntity.getKontraktsnamn()).isEqualTo(kontraktsnamn);
		assertThat(arrendekontraktEntity.getHuvudkontrakt()).isEqualTo(huvudkontrakt);
		assertThat(arrendekontraktEntity.getKopplatTillId()).isEqualTo(kopplatTillId);
		assertThat(arrendekontraktEntity.getSendStatus()).isEqualTo(sendStatus);
		assertThat(arrendekontraktEntity.getArrendatorer()).isEqualTo(arrendatorEntities);
		assertThat(arrendekontraktEntity.getArrendekontraktsrader()).isEqualTo(arrendeKontratsraderEntities);
		assertThat(arrendekontraktEntity.getFastighet()).isEqualTo(fastighetEntity);
	}

	@Test
	void hasNoDirtOnCreatedBean() {
		assertThat(ArrendekontraktEntity.create()).hasAllNullFieldsOrProperties();
		assertThat(new ArrendekontraktEntity()).hasAllNullFieldsOrProperties();
	}
}
