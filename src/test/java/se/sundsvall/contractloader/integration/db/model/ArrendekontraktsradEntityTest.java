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

class ArrendekontraktsradEntityTest {

	@BeforeAll
	static void setup() {
		BeanMatchers.registerValueGenerator(() -> now().plusDays(new Random().nextInt()), LocalDate.class);
	}

	@Test
	void testBean() {
		MatcherAssert.assertThat(ArrendekontraktsradEntity.class, allOf(
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
		final var arrendeartikel = "arrendeartikel";
		final var avitext = "avitext";
		final var debiterasFromDatum = now();
		final var debiterasTomDatum = now();
		final var basarshyra = "basarshyra";
		final var arshyra = "arshyra";
		final var delAvArFrom = now();
		final var delAvArTom = now();
		final var indexklausul = "indexklausul";
		final var indexnamn = "indexnamn";
		final var indexandel = "indexandel";
		final var indexbasar = "indexbasar";
		final var indexbasmanad = "indexbasmanad";
		final var indexbasvarde = "indexbasvarde";
		final var indexNuvarandeAr = "indexNuvarandeAr";
		final var indexNuvarandeManad = "indexNuvarandeManad";
		final var indexNuvarandeVarde = "indexNuvarandeVarde";
		final var radnummer = "radnummer";
		final var arrendeartikelEntities = List.of(new ArrendeartikelEntity());

		var arrendekontraktsraderEntity = ArrendekontraktsradEntity.create()
			.withId(id)
			.withArrendekontrakt(arrendekontrakt)
			.withArrendeartikel(arrendeartikel)
			.withAvitext(avitext)
			.withDebiterasFromDatum(debiterasFromDatum)
			.withDebiterasTomDatum(debiterasTomDatum)
			.withBasarshyra(basarshyra)
			.withArshyra(arshyra)
			.withDelAvArFrom(delAvArFrom)
			.withDelAvArTom(delAvArTom)
			.withIndexklausul(indexklausul)
			.withIndexnamn(indexnamn)
			.withIndexandel(indexandel)
			.withIndexbasar(indexbasar)
			.withIndexbasmanad(indexbasmanad)
			.withIndexbasvarde(indexbasvarde)
			.withIndexNuvarandeAr(indexNuvarandeAr)
			.withIndexNuvarandeManad(indexNuvarandeManad)
			.withIndexNuvarandeVarde(indexNuvarandeVarde)
			.withRadnummer(radnummer)
			.withArrendeartiklar(arrendeartikelEntities);

		assertThat(arrendekontraktsraderEntity).hasNoNullFieldsOrProperties();
		assertThat(arrendekontraktsraderEntity.getId()).isEqualTo(id);
		assertThat(arrendekontraktsraderEntity.getArrendekontrakt()).isEqualTo(arrendekontrakt);
		assertThat(arrendekontraktsraderEntity.getArrendeartikel()).isEqualTo(arrendeartikel);
		assertThat(arrendekontraktsraderEntity.getAvitext()).isEqualTo(avitext);
		assertThat(arrendekontraktsraderEntity.getDebiterasFromDatum()).isEqualTo(debiterasFromDatum);
		assertThat(arrendekontraktsraderEntity.getDebiterasTomDatum()).isEqualTo(debiterasTomDatum);
		assertThat(arrendekontraktsraderEntity.getBasarshyra()).isEqualTo(basarshyra);
		assertThat(arrendekontraktsraderEntity.getArshyra()).isEqualTo(arshyra);
		assertThat(arrendekontraktsraderEntity.getDelAvArFrom()).isEqualTo(delAvArFrom);
		assertThat(arrendekontraktsraderEntity.getDelAvArTom()).isEqualTo(delAvArTom);
		assertThat(arrendekontraktsraderEntity.getIndexklausul()).isEqualTo(indexklausul);
		assertThat(arrendekontraktsraderEntity.getIndexnamn()).isEqualTo(indexnamn);
		assertThat(arrendekontraktsraderEntity.getIndexandel()).isEqualTo(indexandel);
		assertThat(arrendekontraktsraderEntity.getIndexbasar()).isEqualTo(indexbasar);
		assertThat(arrendekontraktsraderEntity.getIndexbasmanad()).isEqualTo(indexbasmanad);
		assertThat(arrendekontraktsraderEntity.getIndexbasvarde()).isEqualTo(indexbasvarde);
		assertThat(arrendekontraktsraderEntity.getIndexNuvarandeAr()).isEqualTo(indexNuvarandeAr);
		assertThat(arrendekontraktsraderEntity.getIndexNuvarandeManad()).isEqualTo(indexNuvarandeManad);
		assertThat(arrendekontraktsraderEntity.getIndexNuvarandeVarde()).isEqualTo(indexNuvarandeVarde);
		assertThat(arrendekontraktsraderEntity.getRadnummer()).isEqualTo(radnummer);
		assertThat(arrendekontraktsraderEntity.getArrendeartiklar()).isEqualTo(arrendeartikelEntities);
	}

	@Test
	void hasNoDirtOnCreatedBean() {
		assertThat(ArrendekontraktsradEntity.create()).hasAllNullFieldsOrProperties();
		assertThat(new ArrendekontraktsradEntity()).hasAllNullFieldsOrProperties();
	}
}
