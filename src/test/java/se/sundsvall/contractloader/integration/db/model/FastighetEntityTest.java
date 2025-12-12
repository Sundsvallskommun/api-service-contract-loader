package se.sundsvall.contractloader.integration.db.model;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static java.time.OffsetDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.allOf;

import com.google.code.beanmatchers.BeanMatchers;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Random;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FastighetEntityTest {

	@BeforeAll
	static void setup() {
		BeanMatchers.registerValueGenerator(() -> now().plusDays(new Random().nextInt()), OffsetDateTime.class);
	}

	@Test
	void testBean() {
		MatcherAssert.assertThat(FastighetEntity.class, allOf(
			hasValidBeanConstructor(),
			hasValidGettersAndSetters(),
			hasValidBeanHashCode(),
			hasValidBeanEquals(),
			hasValidBeanToString()));
	}

	@Test
	void testBuilderMethods() {

		final var id = 1L;
		final var hyresid = "hyresid";
		final var foretag = "foretag";
		final var foretagsnamn = "foretagsnamn";
		final var fastighetsnr = "fastighetsnr";
		final var fastighetsbeteckning = "fastighetsbeteckning";
		final var kommun = "kommun";
		final var trakt = "trakt";
		final var block = "block";
		final var fangesdatum = now();
		final var agarforhallande = "agarforhallande";
		final var agare = "agare";
		final var agarenamn = "agarenamn";
		final var postadress = "postadress";
		final var postadress2 = "postadress2";
		final var postnummer = "postnummer";
		final var ort = "ort";
		final var land = "land";
		final var tomtratt = "tomtratt";
		final var tomtrattDodadDatum = "tomtrattDodadDatum";
		final var franDatum = "franDatum";
		final var tillDatum = "tillDatum";
		final var enForvaltningsenhetKopplad = "enForvaltningsenhetKopplad";
		final var noteringEntities = List.of(new NoteringEntity());

		var fastighetEntity = FastighetEntity.create()
			.withId(id)
			.withHyresid(hyresid)
			.withForetag(foretag)
			.withForetagsnamn(foretagsnamn)
			.withFastighetsnr(fastighetsnr)
			.withFastighetsbeteckning(fastighetsbeteckning)
			.withKommun(kommun)
			.withTrakt(trakt)
			.withBlock(block)
			.withFangesdatum(fangesdatum)
			.withAgarforhallande(agarforhallande)
			.withAgare(agare)
			.withAgarenamn(agarenamn)
			.withPostadress(postadress)
			.withPostadress2(postadress2)
			.withPostnummer(postnummer)
			.withOrt(ort)
			.withLand(land)
			.withTomtratt(tomtratt)
			.withTomtrattDodadDatum(tomtrattDodadDatum)
			.withFranDatum(franDatum)
			.withTillDatum(tillDatum)
			.withEnForvaltningsenhetKopplad(enForvaltningsenhetKopplad)
			.withNoteringar(noteringEntities);

		assertThat(fastighetEntity).hasNoNullFieldsOrProperties();
		assertThat(fastighetEntity.getId()).isEqualTo(id);
		assertThat(fastighetEntity.getHyresid()).isEqualTo(hyresid);
		assertThat(fastighetEntity.getForetag()).isEqualTo(foretag);
		assertThat(fastighetEntity.getForetagsnamn()).isEqualTo(foretagsnamn);
		assertThat(fastighetEntity.getFastighetsnr()).isEqualTo(fastighetsnr);
		assertThat(fastighetEntity.getFastighetsbeteckning()).isEqualTo(fastighetsbeteckning);
		assertThat(fastighetEntity.getKommun()).isEqualTo(kommun);
		assertThat(fastighetEntity.getTrakt()).isEqualTo(trakt);
		assertThat(fastighetEntity.getBlock()).isEqualTo(block);
		assertThat(fastighetEntity.getFangesdatum()).isEqualTo(fangesdatum);
		assertThat(fastighetEntity.getAgarforhallande()).isEqualTo(agarforhallande);
		assertThat(fastighetEntity.getAgare()).isEqualTo(agare);
		assertThat(fastighetEntity.getAgarenamn()).isEqualTo(agarenamn);
		assertThat(fastighetEntity.getPostadress()).isEqualTo(postadress);
		assertThat(fastighetEntity.getPostadress2()).isEqualTo(postadress2);
		assertThat(fastighetEntity.getPostnummer()).isEqualTo(postnummer);
		assertThat(fastighetEntity.getOrt()).isEqualTo(ort);
		assertThat(fastighetEntity.getLand()).isEqualTo(land);
		assertThat(fastighetEntity.getTomtratt()).isEqualTo(tomtratt);
		assertThat(fastighetEntity.getTomtrattDodadDatum()).isEqualTo(tomtrattDodadDatum);
		assertThat(fastighetEntity.getFranDatum()).isEqualTo(franDatum);
		assertThat(fastighetEntity.getTillDatum()).isEqualTo(tillDatum);
		assertThat(fastighetEntity.getEnForvaltningsenhetKopplad()).isEqualTo(enForvaltningsenhetKopplad);
		assertThat(fastighetEntity.getNoteringar()).isEqualTo(noteringEntities);
	}

	@Test
	void hasNoDirtOnCreatedBean() {
		assertThat(FastighetEntity.create()).hasAllNullFieldsOrProperties();
		assertThat(new FastighetEntity()).hasAllNullFieldsOrProperties();
	}
}
