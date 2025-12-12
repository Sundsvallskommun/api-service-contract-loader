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

class ArrendeartikelEntityTest {

	@Test
	void testBean() {
		MatcherAssert.assertThat(ArrendeartikelEntity.class, allOf(
			hasValidBeanConstructor(),
			hasValidGettersAndSetters(),
			hasValidBeanHashCode(),
			hasValidBeanEquals(),
			hasValidBeanToString()));
	}

	@Test
	void testBuilderMethods() {

		final var id = 1L;
		final var arrendeartikel = "arrendeartikel";
		final var artikelbenamning = "artikelbenamning";
		final var avitext = "avitext";
		final var artikelgrupp = "artikelgrupp";
		final var artikeltyp = "artikeltyp";
		final var reglering = "reglering";
		final var pris = "pris";
		final var ingarIKontraktssumma = "ingarIKontraktssumma";
		final var avdrag = "avdrag";
		final var debiterasAlltidHelPeriod = "debiterasAlltidHelPeriod";
		final var avvikelsetoleransProcent = "avvikelsetoleransProcent";
		final var summarad = "summarad";
		final var aktiv = "aktiv";

		var arrendeartikelEntity = ArrendeartikelEntity.create()
			.withId(id)
			.withArrendeartikel(arrendeartikel)
			.withArtikelbenamning(artikelbenamning)
			.withAvitext(avitext)
			.withArtikelgrupp(artikelgrupp)
			.withArtikeltyp(artikeltyp)
			.withReglering(reglering)
			.withPris(pris)
			.withIngarIKontraktssumma(ingarIKontraktssumma)
			.withAvdrag(avdrag)
			.withDebiterasAlltidHelPeriod(debiterasAlltidHelPeriod)
			.withAvvikelsetoleransProcent(avvikelsetoleransProcent)
			.withSummarad(summarad)
			.withAktiv(aktiv);

		assertThat(arrendeartikelEntity).hasNoNullFieldsOrProperties();
		assertThat(arrendeartikelEntity.getId()).isEqualTo(id);
		assertThat(arrendeartikelEntity.getArrendeartikel()).isEqualTo(arrendeartikel);
		assertThat(arrendeartikelEntity.getArtikelbenamning()).isEqualTo(artikelbenamning);
		assertThat(arrendeartikelEntity.getAvitext()).isEqualTo(avitext);
		assertThat(arrendeartikelEntity.getArtikelgrupp()).isEqualTo(artikelgrupp);
		assertThat(arrendeartikelEntity.getArtikeltyp()).isEqualTo(artikeltyp);
		assertThat(arrendeartikelEntity.getReglering()).isEqualTo(reglering);
		assertThat(arrendeartikelEntity.getPris()).isEqualTo(pris);
		assertThat(arrendeartikelEntity.getIngarIKontraktssumma()).isEqualTo(ingarIKontraktssumma);
		assertThat(arrendeartikelEntity.getAvdrag()).isEqualTo(avdrag);
		assertThat(arrendeartikelEntity.getDebiterasAlltidHelPeriod()).isEqualTo(debiterasAlltidHelPeriod);
		assertThat(arrendeartikelEntity.getAvvikelsetoleransProcent()).isEqualTo(avvikelsetoleransProcent);
		assertThat(arrendeartikelEntity.getSummarad()).isEqualTo(summarad);
		assertThat(arrendeartikelEntity.getAktiv()).isEqualTo(aktiv);
	}

	@Test
	void hasNoDirtOnCreatedBean() {
		assertThat(ArrendeartikelEntity.create()).hasAllNullFieldsOrProperties();
		assertThat(new ArrendeartikelEntity()).hasAllNullFieldsOrProperties();
	}
}
