package se.sundsvall.contractloader.integration.db.model;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.allOf;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

class KundEntityTest {

	@Test
	void testBean() {
		MatcherAssert.assertThat(KundEntity.class, allOf(
			hasValidBeanConstructor(),
			hasValidGettersAndSetters(),
			hasValidBeanHashCode(),
			hasValidBeanEquals(),
			hasValidBeanToString()));
	}

	@Test
	void testBuilderMethods() {

		final var id = 1L;
		final var personOrgNr = "personOrgNr";
		final var kontaktid = "kontaktid";
		final var kategori = "kategori";
		final var namn = "namn";
		final var fornamn = "fornamn";
		final var efternamn = "efternamn";
		final var avdelning = "avdelning";
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
		final var efakturaadress = "efakturaadress";
		final var forvaltartyp = "forvaltartyp";
		final var godManForvaltare = "godManForvaltare";
		final var aktiv = "aktiv";
		final var id1 = "id1";

		var kundEntity = KundEntity.create()
			.withId(id)
			.withPersonOrgNr(personOrgNr)
			.withKontaktid(kontaktid)
			.withKategori(kategori)
			.withNamn(namn)
			.withFornamn(fornamn)
			.withEfternamn(efternamn)
			.withAvdelning(avdelning)
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
			.withEfakturaadress(efakturaadress)
			.withForvaltartyp(forvaltartyp)
			.withGodManForvaltare(godManForvaltare)
			.withAktiv(aktiv)
			.withId1(id1);

		assertThat(kundEntity).hasNoNullFieldsOrProperties();
		assertThat(kundEntity.getId()).isEqualTo(id);
		assertThat(kundEntity.getPersonOrgNr()).isEqualTo(personOrgNr);
		assertThat(kundEntity.getKontaktid()).isEqualTo(kontaktid);
		assertThat(kundEntity.getKategori()).isEqualTo(kategori);
		assertThat(kundEntity.getNamn()).isEqualTo(namn);
		assertThat(kundEntity.getFornamn()).isEqualTo(fornamn);
		assertThat(kundEntity.getEfternamn()).isEqualTo(efternamn);
		assertThat(kundEntity.getAvdelning()).isEqualTo(avdelning);
		assertThat(kundEntity.getPostadress()).isEqualTo(postadress);
		assertThat(kundEntity.getPostadress2()).isEqualTo(postadress2);
		assertThat(kundEntity.getPostnummer()).isEqualTo(postnummer);
		assertThat(kundEntity.getOrt()).isEqualTo(ort);
		assertThat(kundEntity.getLand()).isEqualTo(land);
		assertThat(kundEntity.getTelefonMobil()).isEqualTo(telefonMobil);
		assertThat(kundEntity.getTelefonHem()).isEqualTo(telefonHem);
		assertThat(kundEntity.getTelefonArbete()).isEqualTo(telefonArbete);
		assertThat(kundEntity.getEpost()).isEqualTo(epost);
		assertThat(kundEntity.getForedragetKontaktsatt()).isEqualTo(foredragetKontaktsatt);
		assertThat(kundEntity.getSvefaktura()).isEqualTo(svefaktura);
		assertThat(kundEntity.getEfakturaadress()).isEqualTo(efakturaadress);
		assertThat(kundEntity.getForvaltartyp()).isEqualTo(forvaltartyp);
		assertThat(kundEntity.getGodManForvaltare()).isEqualTo(godManForvaltare);
		assertThat(kundEntity.getAktiv()).isEqualTo(aktiv);
		assertThat(kundEntity.getId1()).isEqualTo(id1);
	}

	@Test
	void hasNoDirtOnCreatedBean() {
		assertThat(KundEntity.create()).hasAllNullFieldsOrProperties();
		assertThat(new KundEntity()).hasAllNullFieldsOrProperties();
	}
}
