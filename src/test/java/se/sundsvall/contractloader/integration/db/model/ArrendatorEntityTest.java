package se.sundsvall.contractloader.integration.db.model;

import com.google.code.beanmatchers.BeanMatchers;
import java.time.LocalDate;
import java.util.Random;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.allOf;

class ArrendatorEntityTest {

	@BeforeAll
	static void setup() {
		BeanMatchers.registerValueGenerator(() -> now().plusDays(new Random().nextInt()), LocalDate.class);
	}

	@Test
	void testBean() {
		MatcherAssert.assertThat(ArrendatorEntity.class, allOf(
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
		final var kontaktid = "kontaktid";
		final var personOrgNr = "personOrgNr";
		final var kategori = "kategori";
		final var namn = "namn";
		final var fornamn = "fornamn";
		final var efternamn = "efternamn";
		final var avdelning = "avdelning";
		final var kontraktsrelation = "kontraktsrelation";
		final var relateradFromDatum = LocalDate.now();
		final var relateradTomDatum = LocalDate.now();
		final var ordning = "ordning";
		final var postadress = "postadress";
		final var postadress2 = "postadress2";
		final var postnummer = "postnummer";
		final var ort = "ort";
		final var land = "land";
		final var telefonMobil = "telefonMobil";
		final var telefonHem = "telefonHem";
		final var telefonArbete = "telefonArbete";
		final var epost = "epost";
		final var foredragetKontaktsatt = "foredragetKontaktsatt";
		final var svefaktura = "svefaktura";
		final var betalarnummerKontakt = "betalarnummerKontakt";
		final var betalarnummerlangdKontakt = "betalarnummerlangdKontakt";
		final var clearingnummerKontakt = "clearingnummerKontakt";
		final var kontoKontakt = "kontoKontakt";
		final var efakturaadress = "efakturaadress";

		var arrendatorEntity = ArrendatorEntity.create()
			.withId(id)
			.withArrendekontrakt(arrendekontrakt)
			.withKontaktid(kontaktid)
			.withPersonOrgNr(personOrgNr)
			.withKategori(kategori)
			.withNamn(namn)
			.withFornamn(fornamn)
			.withEfternamn(efternamn)
			.withAvdelning(avdelning)
			.withKontraktsrelation(kontraktsrelation)
			.withRelateradFromDatum(relateradFromDatum)
			.withRelateradTomDatum(relateradTomDatum)
			.withOrdning(ordning)
			.withPostadress(postadress)
			.withPostadress2(postadress2)
			.withPostnummer(postnummer)
			.withOrt(ort)
			.withLand(land)
			.withTelefonMobil(telefonMobil)
			.withTelefonHem(telefonHem)
			.withTelefonArbete(telefonArbete)
			.withEpost(epost)
			.withForedragetKontaktsatt(foredragetKontaktsatt)
			.withSvefaktura(svefaktura)
			.withBetalarnummerKontakt(betalarnummerKontakt)
			.withBetalarnummerlangdKontakt(betalarnummerlangdKontakt)
			.withClearingnummerKontakt(clearingnummerKontakt)
			.withKontoKontakt(kontoKontakt)
			.withEfakturaadress(efakturaadress);

		assertThat(arrendatorEntity).hasNoNullFieldsOrProperties();
		assertThat(arrendatorEntity.getId()).isEqualTo(id);
		assertThat(arrendatorEntity.getArrendekontrakt()).isEqualTo(arrendekontrakt);
		assertThat(arrendatorEntity.getKontaktid()).isEqualTo(kontaktid);
		assertThat(arrendatorEntity.getPersonOrgNr()).isEqualTo(personOrgNr);
		assertThat(arrendatorEntity.getKategori()).isEqualTo(kategori);
		assertThat(arrendatorEntity.getNamn()).isEqualTo(namn);
		assertThat(arrendatorEntity.getFornamn()).isEqualTo(fornamn);
		assertThat(arrendatorEntity.getEfternamn()).isEqualTo(efternamn);
		assertThat(arrendatorEntity.getAvdelning()).isEqualTo(avdelning);
		assertThat(arrendatorEntity.getKontraktsrelation()).isEqualTo(kontraktsrelation);
		assertThat(arrendatorEntity.getRelateradFromDatum()).isEqualTo(relateradFromDatum);
		assertThat(arrendatorEntity.getRelateradTomDatum()).isEqualTo(relateradTomDatum);
		assertThat(arrendatorEntity.getOrdning()).isEqualTo(ordning);
		assertThat(arrendatorEntity.getPostadress()).isEqualTo(postadress);
		assertThat(arrendatorEntity.getPostadress2()).isEqualTo(postadress2);
		assertThat(arrendatorEntity.getPostnummer()).isEqualTo(postnummer);
		assertThat(arrendatorEntity.getOrt()).isEqualTo(ort);
		assertThat(arrendatorEntity.getLand()).isEqualTo(land);
		assertThat(arrendatorEntity.getTelefonMobil()).isEqualTo(telefonMobil);
		assertThat(arrendatorEntity.getTelefonHem()).isEqualTo(telefonHem);
		assertThat(arrendatorEntity.getTelefonArbete()).isEqualTo(telefonArbete);
		assertThat(arrendatorEntity.getEpost()).isEqualTo(epost);
		assertThat(arrendatorEntity.getForedragetKontaktsatt()).isEqualTo(foredragetKontaktsatt);
		assertThat(arrendatorEntity.getSvefaktura()).isEqualTo(svefaktura);
		assertThat(arrendatorEntity.getBetalarnummerKontakt()).isEqualTo(betalarnummerKontakt);
		assertThat(arrendatorEntity.getBetalarnummerlangdKontakt()).isEqualTo(betalarnummerlangdKontakt);
		assertThat(arrendatorEntity.getClearingnummerKontakt()).isEqualTo(clearingnummerKontakt);
		assertThat(arrendatorEntity.getKontoKontakt()).isEqualTo(kontoKontakt);
		assertThat(arrendatorEntity.getEfakturaadress()).isEqualTo(efakturaadress);
	}

	@Test
	void hasNoDirtOnCreatedBean() {
		assertThat(ArrendatorEntity.create()).hasAllNullFieldsOrProperties();
		assertThat(new ArrendatorEntity()).hasAllNullFieldsOrProperties();
	}
}
