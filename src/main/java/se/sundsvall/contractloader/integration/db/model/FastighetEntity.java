package se.sundsvall.contractloader.integration.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "fastighetsbas_fastighet", schema = "contract_staging")
public class FastighetEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Column(name = "hyresid")
	private String hyresid;

	@Column(name = "foretag")
	private String foretag;

	@Column(name = "foretagsnamn")
	private String foretagsnamn;

	@Column(name = "fastighetsnr")
	private String fastighetsnr;

	@Column(name = "fastighetsbeteckning")
	private String fastighetsbeteckning;

	@Column(name = "kommun")
	private String kommun;

	@Column(name = "trakt")
	private String trakt;

	@Column(name = "block")
	private String block;

	@Column(name = "fangesdatum")
	private OffsetDateTime fangesdatum;

	@Column(name = "agarforhallande")
	private String agarforhallande;

	@Column(name = "agare")
	private String agare;

	@Column(name = "agarenamn")
	private String agarenamn;

	@Column(name = "postadress")
	private String postadress;

	@Column(name = "postadress2")
	private String postadress2;

	@Column(name = "postnummer")
	private String postnummer;

	@Column(name = "ort")
	private String ort;

	@Column(name = "land")
	private String land;

	@Column(name = "tomtratt")
	private String tomtratt;

	@Column(name = "tomtratt_dodad_datum")
	private String tomtrattDodadDatum;

	@Column(name = "fran_datum")
	private String franDatum;

	@Column(name = "till_datum")
	private String tillDatum;

	@Column(name = "en_forvaltningsenhet_kopplad")
	private String enForvaltningsenhetKopplad;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "fastighetsnr", referencedColumnName = "fastighetsnr")
	private List<NoteringEntity> noteringar;

	public static FastighetEntity create() {
		return new FastighetEntity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FastighetEntity withId(Long id) {
		this.id = id;
		return this;
	}

	public String getHyresid() {
		return hyresid;
	}

	public void setHyresid(String hyresid) {
		this.hyresid = hyresid;
	}

	public FastighetEntity withHyresid(String hyresid) {
		this.hyresid = hyresid;
		return this;
	}

	public String getForetag() {
		return foretag;
	}

	public void setForetag(String foretag) {
		this.foretag = foretag;
	}

	public FastighetEntity withForetag(String foretag) {
		this.foretag = foretag;
		return this;
	}

	public String getForetagsnamn() {
		return foretagsnamn;
	}

	public void setForetagsnamn(String foretagsnamn) {
		this.foretagsnamn = foretagsnamn;
	}

	public FastighetEntity withForetagsnamn(String foretagsnamn) {
		this.foretagsnamn = foretagsnamn;
		return this;
	}

	public String getFastighetsnr() {
		return fastighetsnr;
	}

	public void setFastighetsnr(String fastighetsnr) {
		this.fastighetsnr = fastighetsnr;
	}

	public FastighetEntity withFastighetsnr(String fastighetsnr) {
		this.fastighetsnr = fastighetsnr;
		return this;
	}

	public String getFastighetsbeteckning() {
		return fastighetsbeteckning;
	}

	public void setFastighetsbeteckning(String fastighetsbeteckning) {
		this.fastighetsbeteckning = fastighetsbeteckning;
	}

	public FastighetEntity withFastighetsbeteckning(String fastighetsbeteckning) {
		this.fastighetsbeteckning = fastighetsbeteckning;
		return this;
	}

	public String getKommun() {
		return kommun;
	}

	public void setKommun(String kommun) {
		this.kommun = kommun;
	}

	public FastighetEntity withKommun(String kommun) {
		this.kommun = kommun;
		return this;
	}

	public String getTrakt() {
		return trakt;
	}

	public void setTrakt(String trakt) {
		this.trakt = trakt;
	}

	public FastighetEntity withTrakt(String trakt) {
		this.trakt = trakt;
		return this;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public FastighetEntity withBlock(String block) {
		this.block = block;
		return this;
	}

	public OffsetDateTime getFangesdatum() {
		return fangesdatum;
	}

	public void setFangesdatum(OffsetDateTime fangesdatum) {
		this.fangesdatum = fangesdatum;
	}

	public FastighetEntity withFangesdatum(OffsetDateTime fangesdatum) {
		this.fangesdatum = fangesdatum;
		return this;
	}

	public String getAgarforhallande() {
		return agarforhallande;
	}

	public void setAgarforhallande(String agarforhallande) {
		this.agarforhallande = agarforhallande;
	}

	public FastighetEntity withAgarforhallande(String agarforhallande) {
		this.agarforhallande = agarforhallande;
		return this;
	}

	public String getAgare() {
		return agare;
	}

	public void setAgare(String agare) {
		this.agare = agare;
	}

	public FastighetEntity withAgare(String agare) {
		this.agare = agare;
		return this;
	}

	public String getAgarenamn() {
		return agarenamn;
	}

	public void setAgarenamn(String agarenamn) {
		this.agarenamn = agarenamn;
	}

	public FastighetEntity withAgarenamn(String agarenamn) {
		this.agarenamn = agarenamn;
		return this;
	}

	public String getPostadress() {
		return postadress;
	}

	public void setPostadress(String postadress) {
		this.postadress = postadress;
	}

	public FastighetEntity withPostadress(String postadress) {
		this.postadress = postadress;
		return this;
	}

	public String getPostadress2() {
		return postadress2;
	}

	public void setPostadress2(String postadress2) {
		this.postadress2 = postadress2;
	}

	public FastighetEntity withPostadress2(String postadress2) {
		this.postadress2 = postadress2;
		return this;
	}

	public String getPostnummer() {
		return postnummer;
	}

	public void setPostnummer(String postnummer) {
		this.postnummer = postnummer;
	}

	public FastighetEntity withPostnummer(String postnummer) {
		this.postnummer = postnummer;
		return this;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public FastighetEntity withOrt(String ort) {
		this.ort = ort;
		return this;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public FastighetEntity withLand(String land) {
		this.land = land;
		return this;
	}

	public String getTomtratt() {
		return tomtratt;
	}

	public void setTomtratt(String tomtratt) {
		this.tomtratt = tomtratt;
	}

	public FastighetEntity withTomtratt(String tomtratt) {
		this.tomtratt = tomtratt;
		return this;
	}

	public String getTomtrattDodadDatum() {
		return tomtrattDodadDatum;
	}

	public void setTomtrattDodadDatum(String tomtrattDodadDatum) {
		this.tomtrattDodadDatum = tomtrattDodadDatum;
	}

	public FastighetEntity withTomtrattDodadDatum(String tomtrattDodadDatum) {
		this.tomtrattDodadDatum = tomtrattDodadDatum;
		return this;
	}

	public String getFranDatum() {
		return franDatum;
	}

	public void setFranDatum(String franDatum) {
		this.franDatum = franDatum;
	}

	public FastighetEntity withFranDatum(String franDatum) {
		this.franDatum = franDatum;
		return this;
	}

	public String getTillDatum() {
		return tillDatum;
	}

	public void setTillDatum(String tillDatum) {
		this.tillDatum = tillDatum;
	}

	public FastighetEntity withTillDatum(String tillDatum) {
		this.tillDatum = tillDatum;
		return this;
	}

	public String getEnForvaltningsenhetKopplad() {
		return enForvaltningsenhetKopplad;
	}

	public void setEnForvaltningsenhetKopplad(String enForvaltningsenhetKopplad) {
		this.enForvaltningsenhetKopplad = enForvaltningsenhetKopplad;
	}

	public FastighetEntity withEnForvaltningsenhetKopplad(String enForvaltningsenhetKopplad) {
		this.enForvaltningsenhetKopplad = enForvaltningsenhetKopplad;
		return this;
	}

	public List<NoteringEntity> getNoteringar() {
		return noteringar;
	}

	public void setNoteringar(List<NoteringEntity> noteringar) {
		this.noteringar = noteringar;
	}

	public FastighetEntity withNoteringar(List<NoteringEntity> noteringar) {
		this.noteringar = noteringar;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		FastighetEntity that = (FastighetEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(hyresid, that.hyresid) && Objects.equals(foretag, that.foretag) && Objects.equals(foretagsnamn, that.foretagsnamn) && Objects.equals(fastighetsnr,
			that.fastighetsnr) && Objects.equals(fastighetsbeteckning, that.fastighetsbeteckning) && Objects.equals(kommun, that.kommun) && Objects.equals(trakt, that.trakt) && Objects.equals(block, that.block)
			&& Objects.equals(fangesdatum, that.fangesdatum) && Objects.equals(agarforhallande, that.agarforhallande) && Objects.equals(agare, that.agare) && Objects.equals(agarenamn, that.agarenamn)
			&& Objects.equals(postadress, that.postadress) && Objects.equals(postadress2, that.postadress2) && Objects.equals(postnummer, that.postnummer) && Objects.equals(ort, that.ort) && Objects.equals(
				land, that.land) && Objects.equals(tomtratt, that.tomtratt) && Objects.equals(tomtrattDodadDatum, that.tomtrattDodadDatum) && Objects.equals(franDatum, that.franDatum) && Objects.equals(tillDatum,
					that.tillDatum) && Objects.equals(enForvaltningsenhetKopplad, that.enForvaltningsenhetKopplad) && Objects.equals(noteringar, that.noteringar);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, hyresid, foretag, foretagsnamn, fastighetsnr, fastighetsbeteckning, kommun, trakt, block, fangesdatum, agarforhallande, agare, agarenamn, postadress, postadress2, postnummer, ort, land, tomtratt, tomtrattDodadDatum,
			franDatum, tillDatum, enForvaltningsenhetKopplad, noteringar);
	}

	@Override
	public String toString() {
		return "FastighetEntity{" +
			"id=" + id +
			", hyresid='" + hyresid + '\'' +
			", foretag='" + foretag + '\'' +
			", foretagsnamn='" + foretagsnamn + '\'' +
			", fastighetsnr='" + fastighetsnr + '\'' +
			", fastighetsbeteckning='" + fastighetsbeteckning + '\'' +
			", kommun='" + kommun + '\'' +
			", trakt='" + trakt + '\'' +
			", block='" + block + '\'' +
			", fangesdatum=" + fangesdatum +
			", agarforhallande='" + agarforhallande + '\'' +
			", agare='" + agare + '\'' +
			", agarenamn='" + agarenamn + '\'' +
			", postadress='" + postadress + '\'' +
			", postadress2='" + postadress2 + '\'' +
			", postnummer='" + postnummer + '\'' +
			", ort='" + ort + '\'' +
			", land='" + land + '\'' +
			", tomtratt='" + tomtratt + '\'' +
			", tomtrattDodadDatum='" + tomtrattDodadDatum + '\'' +
			", franDatum='" + franDatum + '\'' +
			", tillDatum='" + tillDatum + '\'' +
			", enForvaltningsenhetKopplad='" + enForvaltningsenhetKopplad + '\'' +
			", noteringar=" + noteringar +
			'}';
	}

}
