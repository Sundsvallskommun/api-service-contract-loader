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

class NoteringEntityTest {

	@Test
	void testBean() {
		MatcherAssert.assertThat(NoteringEntity.class, allOf(
			hasValidBeanConstructor(),
			hasValidGettersAndSetters(),
			hasValidBeanHashCode(),
			hasValidBeanEquals(),
			hasValidBeanToString()));
	}

	@Test
	void testBuilderMethods() {

		final var id = 1L;
		final var noteringsnamn = "noteringsnamn";
		final var prioritet = "prioritet";
		final var typ = "typ";
		final var folder = "folder";
		final var objektid = "objektid";
		final var objektid2 = "objektid2";
		final var foretag = "foretag";
		final var forvaltningsenhet = "forvaltningsenhet";
		final var fastighetsnr = "fastighetsnr";
		final var byggnad = "byggnad";
		final var arrendeobjekt = "arrendeobjekt";
		final var byggnadsdel = "byggnadsdel";
		final var markyta = "markyta";
		final var system = "system";
		final var uppgangVaning = "uppgangVaning";
		final var bilplats = "bilplats";
		final var lokal = "lokal";
		final var bostad = "bostad";
		final var underhallsenhet = "underhallsenhet";
		final var ovrigtHyresobjekt = "ovrigtHyresobjekt";
		final var rum = "rum";
		final var komponent = "komponent";
		final var noteringsid = "noteringsid";
		final var filnamn = "filnamn";
		final var id1 = "id1";

		var noteringEntity = NoteringEntity.create()
			.withId(id)
			.withNoteringsnamn(noteringsnamn)
			.withPrioritet(prioritet)
			.withTyp(typ)
			.withFolder(folder)
			.withObjektid(objektid)
			.withObjektid2(objektid2)
			.withForetag(foretag)
			.withForvaltningsenhet(forvaltningsenhet)
			.withFastighetsnr(fastighetsnr)
			.withByggnad(byggnad)
			.withArrendeobjekt(arrendeobjekt)
			.withByggnadsdel(byggnadsdel)
			.withMarkyta(markyta)
			.withSystem(system)
			.withUppgangVaning(uppgangVaning)
			.withBilplats(bilplats)
			.withLokal(lokal)
			.withBostad(bostad)
			.withUnderhallsenhet(underhallsenhet)
			.withOvrigtHyresobjekt(ovrigtHyresobjekt)
			.withRum(rum)
			.withKomponent(komponent)
			.withNoteringsid(noteringsid)
			.withFilnamn(filnamn)
			.withId1(id1);

		assertThat(noteringEntity).hasNoNullFieldsOrProperties();
		assertThat(noteringEntity.getId()).isEqualTo(id);
		assertThat(noteringEntity.getNoteringsnamn()).isEqualTo(noteringsnamn);
		assertThat(noteringEntity.getPrioritet()).isEqualTo(prioritet);
		assertThat(noteringEntity.getTyp()).isEqualTo(typ);
		assertThat(noteringEntity.getFolder()).isEqualTo(folder);
		assertThat(noteringEntity.getObjektid()).isEqualTo(objektid);
		assertThat(noteringEntity.getObjektid2()).isEqualTo(objektid2);
		assertThat(noteringEntity.getForetag()).isEqualTo(foretag);
		assertThat(noteringEntity.getForvaltningsenhet()).isEqualTo(forvaltningsenhet);
		assertThat(noteringEntity.getFastighetsnr()).isEqualTo(fastighetsnr);
		assertThat(noteringEntity.getByggnad()).isEqualTo(byggnad);
		assertThat(noteringEntity.getArrendeobjekt()).isEqualTo(arrendeobjekt);
		assertThat(noteringEntity.getByggnadsdel()).isEqualTo(byggnadsdel);
		assertThat(noteringEntity.getMarkyta()).isEqualTo(markyta);
		assertThat(noteringEntity.getSystem()).isEqualTo(system);
		assertThat(noteringEntity.getUppgangVaning()).isEqualTo(uppgangVaning);
		assertThat(noteringEntity.getBilplats()).isEqualTo(bilplats);
		assertThat(noteringEntity.getLokal()).isEqualTo(lokal);
		assertThat(noteringEntity.getBostad()).isEqualTo(bostad);
		assertThat(noteringEntity.getUnderhallsenhet()).isEqualTo(underhallsenhet);
		assertThat(noteringEntity.getOvrigtHyresobjekt()).isEqualTo(ovrigtHyresobjekt);
		assertThat(noteringEntity.getRum()).isEqualTo(rum);
		assertThat(noteringEntity.getKomponent()).isEqualTo(komponent);
		assertThat(noteringEntity.getNoteringsid()).isEqualTo(noteringsid);
		assertThat(noteringEntity.getFilnamn()).isEqualTo(filnamn);
		assertThat(noteringEntity.getId1()).isEqualTo(id1);
	}

	@Test
	void hasNoDirtOnCreatedBean() {
		assertThat(NoteringEntity.create()).hasAllNullFieldsOrProperties();
		assertThat(new NoteringEntity()).hasAllNullFieldsOrProperties();
	}
}
