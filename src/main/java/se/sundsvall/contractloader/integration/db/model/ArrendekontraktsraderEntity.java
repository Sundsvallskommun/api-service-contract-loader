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
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "arrende_arrendekontraktsrader", schema = "contract_staging")
public class ArrendekontraktsraderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Size(max = 255)
	@Column(name = "arrendekontrakt")
	private String arrendekontrakt;

	@Size(max = 255)
	@Column(name = "arrendeartikel")
	private String arrendeartikel;

	@Size(max = 255)
	@Column(name = "avitext")
	private String avitext;

	@Column(name = "debiteras_fr_o_m_datum")
	private OffsetDateTime debiterasFromDatum;

	@Column(name = "debiteras_t_o_m_datum")
	private OffsetDateTime debiterasTomDatum;

	@Size(max = 255)
	@Column(name = "basarshyra")
	private String basarshyra;

	@Size(max = 255)
	@Column(name = "arshyra")
	private String arshyra;

	@Column(name = "del_av_ar_fr_o_m")
	private OffsetDateTime delAvArFrom;

	@Column(name = "del_av_ar_t_o_m")
	private OffsetDateTime delAvArTom;

	@Size(max = 255)
	@Column(name = "indexklausul")
	private String indexklausul;

	@Size(max = 255)
	@Column(name = "indexnamn")
	private String indexnamn;

	@Size(max = 255)
	@Column(name = "indexandel")
	private String indexandel;

	@Size(max = 255)
	@Column(name = "indexbasar")
	private String indexbasar;

	@Size(max = 255)
	@Column(name = "indexbasmanad")
	private String indexbasmanad;

	@Size(max = 255)
	@Column(name = "indexbasvarde")
	private String indexbasvarde;

	@Size(max = 255)
	@Column(name = "index_nuvarande_ar")
	private String indexNuvarandeAr;

	@Size(max = 255)
	@Column(name = "index_nuvarande_manad")
	private String indexNuvarandeManad;

	@Size(max = 255)
	@Column(name = "index_nuvarande_varde")
	private String indexNuvarandeVarde;

	@Size(max = 255)
	@Column(name = "radnummer")
	private String radnummer;

	@Size(max = 255)
	@Column(name = "id")
	private String id1;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "arrendeartikel", referencedColumnName = "arrendeartikel")
	private List<ArrendeartikelEntity> arrendeartikelEntities;

	public static ArrendekontraktsraderEntity create() {
		return new ArrendekontraktsraderEntity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrendekontraktsraderEntity withId(Long id) {
		this.id = id;
		return this;
	}

	public String getArrendekontrakt() {
		return arrendekontrakt;
	}

	public void setArrendekontrakt(String arrendekontrakt) {
		this.arrendekontrakt = arrendekontrakt;
	}

	public ArrendekontraktsraderEntity withArrendekontrakt(String arrendekontrakt) {
		this.arrendekontrakt = arrendekontrakt;
		return this;
	}

	public String getArrendeartikel() {
		return arrendeartikel;
	}

	public void setArrendeartikel(String arrendeartikel) {
		this.arrendeartikel = arrendeartikel;
	}

	public ArrendekontraktsraderEntity withArrendeartikel(String arrendeartikel) {
		this.arrendeartikel = arrendeartikel;
		return this;
	}

	public String getAvitext() {
		return avitext;
	}

	public void setAvitext(String avitext) {
		this.avitext = avitext;
	}

	public ArrendekontraktsraderEntity withAvitext(String avitext) {
		this.avitext = avitext;
		return this;
	}

	public OffsetDateTime getDebiterasFromDatum() {
		return debiterasFromDatum;
	}

	public void setDebiterasFromDatum(OffsetDateTime debiterasFromDatum) {
		this.debiterasFromDatum = debiterasFromDatum;
	}

	public ArrendekontraktsraderEntity withDebiterasFromDatum(OffsetDateTime debiterasFromDatum) {
		this.debiterasFromDatum = debiterasFromDatum;
		return this;
	}

	public OffsetDateTime getDebiterasTomDatum() {
		return debiterasTomDatum;
	}

	public void setDebiterasTomDatum(OffsetDateTime debiterasTomDatum) {
		this.debiterasTomDatum = debiterasTomDatum;
	}

	public ArrendekontraktsraderEntity withDebiterasTomDatum(OffsetDateTime debiterasTomDatum) {
		this.debiterasTomDatum = debiterasTomDatum;
		return this;
	}

	public String getBasarshyra() {
		return basarshyra;
	}

	public void setBasarshyra(String basarshyra) {
		this.basarshyra = basarshyra;
	}

	public ArrendekontraktsraderEntity withBasarshyra(String basarshyra) {
		this.basarshyra = basarshyra;
		return this;
	}

	public String getArshyra() {
		return arshyra;
	}

	public void setArshyra(String arshyra) {
		this.arshyra = arshyra;
	}

	public ArrendekontraktsraderEntity withArshyra(String arshyra) {
		this.arshyra = arshyra;
		return this;
	}

	public OffsetDateTime getDelAvArFrom() {
		return delAvArFrom;
	}

	public void setDelAvArFrom(OffsetDateTime delAvArFrom) {
		this.delAvArFrom = delAvArFrom;
	}

	public ArrendekontraktsraderEntity withDelAvArFrom(OffsetDateTime delAvArFrom) {
		this.delAvArFrom = delAvArFrom;
		return this;
	}

	public OffsetDateTime getDelAvArTom() {
		return delAvArTom;
	}

	public void setDelAvArTom(OffsetDateTime delAvArTom) {
		this.delAvArTom = delAvArTom;
	}

	public ArrendekontraktsraderEntity withDelAvArTom(OffsetDateTime delAvArTom) {
		this.delAvArTom = delAvArTom;
		return this;
	}

	public String getIndexklausul() {
		return indexklausul;
	}

	public void setIndexklausul(String indexklausul) {
		this.indexklausul = indexklausul;
	}

	public ArrendekontraktsraderEntity withIndexklausul(String indexklausul) {
		this.indexklausul = indexklausul;
		return this;
	}

	public String getIndexnamn() {
		return indexnamn;
	}

	public void setIndexnamn(String indexnamn) {
		this.indexnamn = indexnamn;
	}

	public ArrendekontraktsraderEntity withIndexnamn(String indexnamn) {
		this.indexnamn = indexnamn;
		return this;
	}

	public String getIndexandel() {
		return indexandel;
	}

	public void setIndexandel(String indexandel) {
		this.indexandel = indexandel;
	}

	public ArrendekontraktsraderEntity withIndexandel(String indexandel) {
		this.indexandel = indexandel;
		return this;
	}

	public String getIndexbasar() {
		return indexbasar;
	}

	public void setIndexbasar(String indexbasar) {
		this.indexbasar = indexbasar;
	}

	public ArrendekontraktsraderEntity withIndexbasar(String indexbasar) {
		this.indexbasar = indexbasar;
		return this;
	}

	public String getIndexbasmanad() {
		return indexbasmanad;
	}

	public void setIndexbasmanad(String indexbasmanad) {
		this.indexbasmanad = indexbasmanad;
	}

	public ArrendekontraktsraderEntity withIndexbasmanad(String indexbasmanad) {
		this.indexbasmanad = indexbasmanad;
		return this;
	}

	public String getIndexbasvarde() {
		return indexbasvarde;
	}

	public void setIndexbasvarde(String indexbasvarde) {
		this.indexbasvarde = indexbasvarde;
	}

	public ArrendekontraktsraderEntity withIndexbasvarde(String indexbasvarde) {
		this.indexbasvarde = indexbasvarde;
		return this;
	}

	public String getIndexNuvarandeAr() {
		return indexNuvarandeAr;
	}

	public void setIndexNuvarandeAr(String indexNuvarandeAr) {
		this.indexNuvarandeAr = indexNuvarandeAr;
	}

	public ArrendekontraktsraderEntity withIndexNuvarandeAr(String indexNuvarandeAr) {
		this.indexNuvarandeAr = indexNuvarandeAr;
		return this;
	}

	public String getIndexNuvarandeManad() {
		return indexNuvarandeManad;
	}

	public void setIndexNuvarandeManad(String indexNuvarandeManad) {
		this.indexNuvarandeManad = indexNuvarandeManad;
	}

	public ArrendekontraktsraderEntity withIndexNuvarandeManad(String indexNuvarandeManad) {
		this.indexNuvarandeManad = indexNuvarandeManad;
		return this;
	}

	public String getIndexNuvarandeVarde() {
		return indexNuvarandeVarde;
	}

	public void setIndexNuvarandeVarde(String indexNuvarandeVarde) {
		this.indexNuvarandeVarde = indexNuvarandeVarde;
	}

	public ArrendekontraktsraderEntity withIndexNuvarandeVarde(String indexNuvarandeVarde) {
		this.indexNuvarandeVarde = indexNuvarandeVarde;
		return this;
	}

	public String getRadnummer() {
		return radnummer;
	}

	public void setRadnummer(String radnummer) {
		this.radnummer = radnummer;
	}

	public ArrendekontraktsraderEntity withRadnummer(String radnummer) {
		this.radnummer = radnummer;
		return this;
	}

	public List<ArrendeartikelEntity> getArrendeartikelEntities() {
		return arrendeartikelEntities;
	}

	public void setArrendeartikelEntities(List<ArrendeartikelEntity> arrendeartikelEntities) {
		this.arrendeartikelEntities = arrendeartikelEntities;
	}

	public ArrendekontraktsraderEntity withArrendeartikelEntities(List<ArrendeartikelEntity> arrendeartikelEntities) {
		this.arrendeartikelEntities = arrendeartikelEntities;
		return this;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public ArrendekontraktsraderEntity withId1(String id1) {
		this.id1 = id1;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		ArrendekontraktsraderEntity that = (ArrendekontraktsraderEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(arrendekontrakt, that.arrendekontrakt) && Objects.equals(arrendeartikel, that.arrendeartikel) && Objects.equals(avitext, that.avitext)
			&& Objects.equals(debiterasFromDatum, that.debiterasFromDatum) && Objects.equals(debiterasTomDatum, that.debiterasTomDatum) && Objects.equals(basarshyra, that.basarshyra) && Objects.equals(arshyra,
				that.arshyra) && Objects.equals(delAvArFrom, that.delAvArFrom) && Objects.equals(delAvArTom, that.delAvArTom) && Objects.equals(indexklausul, that.indexklausul) && Objects.equals(indexnamn, that.indexnamn)
			&& Objects.equals(indexandel, that.indexandel) && Objects.equals(indexbasar, that.indexbasar) && Objects.equals(indexbasmanad, that.indexbasmanad) && Objects.equals(indexbasvarde, that.indexbasvarde)
			&& Objects.equals(indexNuvarandeAr, that.indexNuvarandeAr) && Objects.equals(indexNuvarandeManad, that.indexNuvarandeManad) && Objects.equals(indexNuvarandeVarde, that.indexNuvarandeVarde) && Objects.equals(
				radnummer, that.radnummer) && Objects.equals(id1, that.id1) && Objects.equals(arrendeartikelEntities, that.arrendeartikelEntities);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, arrendekontrakt, arrendeartikel, avitext, debiterasFromDatum, debiterasTomDatum, basarshyra, arshyra, delAvArFrom, delAvArTom, indexklausul, indexnamn, indexandel, indexbasar, indexbasmanad, indexbasvarde, indexNuvarandeAr,
			indexNuvarandeManad, indexNuvarandeVarde, radnummer, id1, arrendeartikelEntities);
	}

	@Override
	public String toString() {
		return "ArrendekontraktsraderEntity{" +
			"id=" + id +
			", arrendekontrakt='" + arrendekontrakt + '\'' +
			", arrendeartikel='" + arrendeartikel + '\'' +
			", avitext='" + avitext + '\'' +
			", debiterasFromDatum=" + debiterasFromDatum +
			", debiterasTomDatum=" + debiterasTomDatum +
			", basarshyra='" + basarshyra + '\'' +
			", arshyra='" + arshyra + '\'' +
			", delAvArFrom=" + delAvArFrom +
			", delAvArTom=" + delAvArTom +
			", indexklausul='" + indexklausul + '\'' +
			", indexnamn='" + indexnamn + '\'' +
			", indexandel='" + indexandel + '\'' +
			", indexbasar='" + indexbasar + '\'' +
			", indexbasmanad='" + indexbasmanad + '\'' +
			", indexbasvarde='" + indexbasvarde + '\'' +
			", indexNuvarandeAr='" + indexNuvarandeAr + '\'' +
			", indexNuvarandeManad='" + indexNuvarandeManad + '\'' +
			", indexNuvarandeVarde='" + indexNuvarandeVarde + '\'' +
			", radnummer='" + radnummer + '\'' +
			", id1='" + id1 + '\'' +
			", arrendeartikelEntities=" + arrendeartikelEntities +
			'}';
	}
}
