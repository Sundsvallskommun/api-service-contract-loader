package se.sundsvall.contractloader.integration.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "arrende_arrendekontraktsrader")
public class ArrendekontraktsradEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Column(name = "arrendekontrakt")
	private String arrendekontrakt;

	@Column(name = "arrendeartikel")
	private String arrendeartikel;

	@Column(name = "avitext")
	private String avitext;

	@Column(name = "debiteras_fr_o_m_datum")
	private LocalDate debiterasFromDatum;

	@Column(name = "debiteras_t_o_m_datum")
	private LocalDate debiterasTomDatum;

	@Column(name = "basarshyra")
	private String basarshyra;

	@Column(name = "arshyra")
	private String arshyra;

	@Column(name = "del_av_ar_fr_o_m")
	private LocalDate delAvArFrom;

	@Column(name = "del_av_ar_t_o_m")
	private LocalDate delAvArTom;

	@Column(name = "indexklausul")
	private String indexklausul;

	@Column(name = "indexnamn")
	private String indexnamn;

	@Column(name = "indexandel")
	private String indexandel;

	@Column(name = "indexbasar")
	private String indexbasar;

	@Column(name = "indexbasmanad")
	private String indexbasmanad;

	@Column(name = "indexbasvarde")
	private String indexbasvarde;

	@Column(name = "index_nuvarande_ar")
	private String indexNuvarandeAr;

	@Column(name = "index_nuvarande_manad")
	private String indexNuvarandeManad;

	@Column(name = "index_nuvarande_varde")
	private String indexNuvarandeVarde;

	@Column(name = "radnummer")
	private String radnummer;

	public static ArrendekontraktsradEntity create() {
		return new ArrendekontraktsradEntity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrendekontraktsradEntity withId(Long id) {
		this.id = id;
		return this;
	}

	public String getArrendekontrakt() {
		return arrendekontrakt;
	}

	public void setArrendekontrakt(String arrendekontrakt) {
		this.arrendekontrakt = arrendekontrakt;
	}

	public ArrendekontraktsradEntity withArrendekontrakt(String arrendekontrakt) {
		this.arrendekontrakt = arrendekontrakt;
		return this;
	}

	public String getArrendeartikel() {
		return arrendeartikel;
	}

	public void setArrendeartikel(String arrendeartikel) {
		this.arrendeartikel = arrendeartikel;
	}

	public ArrendekontraktsradEntity withArrendeartikel(String arrendeartikel) {
		this.arrendeartikel = arrendeartikel;
		return this;
	}

	public String getAvitext() {
		return avitext;
	}

	public void setAvitext(String avitext) {
		this.avitext = avitext;
	}

	public ArrendekontraktsradEntity withAvitext(String avitext) {
		this.avitext = avitext;
		return this;
	}

	public LocalDate getDebiterasFromDatum() {
		return debiterasFromDatum;
	}

	public void setDebiterasFromDatum(LocalDate debiterasFromDatum) {
		this.debiterasFromDatum = debiterasFromDatum;
	}

	public ArrendekontraktsradEntity withDebiterasFromDatum(LocalDate debiterasFromDatum) {
		this.debiterasFromDatum = debiterasFromDatum;
		return this;
	}

	public LocalDate getDebiterasTomDatum() {
		return debiterasTomDatum;
	}

	public void setDebiterasTomDatum(LocalDate debiterasTomDatum) {
		this.debiterasTomDatum = debiterasTomDatum;
	}

	public ArrendekontraktsradEntity withDebiterasTomDatum(LocalDate debiterasTomDatum) {
		this.debiterasTomDatum = debiterasTomDatum;
		return this;
	}

	public String getBasarshyra() {
		return basarshyra;
	}

	public void setBasarshyra(String basarshyra) {
		this.basarshyra = basarshyra;
	}

	public ArrendekontraktsradEntity withBasarshyra(String basarshyra) {
		this.basarshyra = basarshyra;
		return this;
	}

	public String getArshyra() {
		return arshyra;
	}

	public void setArshyra(String arshyra) {
		this.arshyra = arshyra;
	}

	public ArrendekontraktsradEntity withArshyra(String arshyra) {
		this.arshyra = arshyra;
		return this;
	}

	public LocalDate getDelAvArFrom() {
		return delAvArFrom;
	}

	public void setDelAvArFrom(LocalDate delAvArFrom) {
		this.delAvArFrom = delAvArFrom;
	}

	public ArrendekontraktsradEntity withDelAvArFrom(LocalDate delAvArFrom) {
		this.delAvArFrom = delAvArFrom;
		return this;
	}

	public LocalDate getDelAvArTom() {
		return delAvArTom;
	}

	public void setDelAvArTom(LocalDate delAvArTom) {
		this.delAvArTom = delAvArTom;
	}

	public ArrendekontraktsradEntity withDelAvArTom(LocalDate delAvArTom) {
		this.delAvArTom = delAvArTom;
		return this;
	}

	public String getIndexklausul() {
		return indexklausul;
	}

	public void setIndexklausul(String indexklausul) {
		this.indexklausul = indexklausul;
	}

	public ArrendekontraktsradEntity withIndexklausul(String indexklausul) {
		this.indexklausul = indexklausul;
		return this;
	}

	public String getIndexnamn() {
		return indexnamn;
	}

	public void setIndexnamn(String indexnamn) {
		this.indexnamn = indexnamn;
	}

	public ArrendekontraktsradEntity withIndexnamn(String indexnamn) {
		this.indexnamn = indexnamn;
		return this;
	}

	public String getIndexandel() {
		return indexandel;
	}

	public void setIndexandel(String indexandel) {
		this.indexandel = indexandel;
	}

	public ArrendekontraktsradEntity withIndexandel(String indexandel) {
		this.indexandel = indexandel;
		return this;
	}

	public String getIndexbasar() {
		return indexbasar;
	}

	public void setIndexbasar(String indexbasar) {
		this.indexbasar = indexbasar;
	}

	public ArrendekontraktsradEntity withIndexbasar(String indexbasar) {
		this.indexbasar = indexbasar;
		return this;
	}

	public String getIndexbasmanad() {
		return indexbasmanad;
	}

	public void setIndexbasmanad(String indexbasmanad) {
		this.indexbasmanad = indexbasmanad;
	}

	public ArrendekontraktsradEntity withIndexbasmanad(String indexbasmanad) {
		this.indexbasmanad = indexbasmanad;
		return this;
	}

	public String getIndexbasvarde() {
		return indexbasvarde;
	}

	public void setIndexbasvarde(String indexbasvarde) {
		this.indexbasvarde = indexbasvarde;
	}

	public ArrendekontraktsradEntity withIndexbasvarde(String indexbasvarde) {
		this.indexbasvarde = indexbasvarde;
		return this;
	}

	public String getIndexNuvarandeAr() {
		return indexNuvarandeAr;
	}

	public void setIndexNuvarandeAr(String indexNuvarandeAr) {
		this.indexNuvarandeAr = indexNuvarandeAr;
	}

	public ArrendekontraktsradEntity withIndexNuvarandeAr(String indexNuvarandeAr) {
		this.indexNuvarandeAr = indexNuvarandeAr;
		return this;
	}

	public String getIndexNuvarandeManad() {
		return indexNuvarandeManad;
	}

	public void setIndexNuvarandeManad(String indexNuvarandeManad) {
		this.indexNuvarandeManad = indexNuvarandeManad;
	}

	public ArrendekontraktsradEntity withIndexNuvarandeManad(String indexNuvarandeManad) {
		this.indexNuvarandeManad = indexNuvarandeManad;
		return this;
	}

	public String getIndexNuvarandeVarde() {
		return indexNuvarandeVarde;
	}

	public void setIndexNuvarandeVarde(String indexNuvarandeVarde) {
		this.indexNuvarandeVarde = indexNuvarandeVarde;
	}

	public ArrendekontraktsradEntity withIndexNuvarandeVarde(String indexNuvarandeVarde) {
		this.indexNuvarandeVarde = indexNuvarandeVarde;
		return this;
	}

	public String getRadnummer() {
		return radnummer;
	}

	public void setRadnummer(String radnummer) {
		this.radnummer = radnummer;
	}

	public ArrendekontraktsradEntity withRadnummer(String radnummer) {
		this.radnummer = radnummer;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		ArrendekontraktsradEntity that = (ArrendekontraktsradEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(arrendekontrakt, that.arrendekontrakt) && Objects.equals(arrendeartikel, that.arrendeartikel) && Objects.equals(avitext, that.avitext)
			&& Objects.equals(debiterasFromDatum, that.debiterasFromDatum) && Objects.equals(debiterasTomDatum, that.debiterasTomDatum) && Objects.equals(basarshyra, that.basarshyra) && Objects.equals(arshyra,
				that.arshyra) && Objects.equals(delAvArFrom, that.delAvArFrom) && Objects.equals(delAvArTom, that.delAvArTom) && Objects.equals(indexklausul, that.indexklausul) && Objects.equals(indexnamn, that.indexnamn)
			&& Objects.equals(indexandel, that.indexandel) && Objects.equals(indexbasar, that.indexbasar) && Objects.equals(indexbasmanad, that.indexbasmanad) && Objects.equals(indexbasvarde, that.indexbasvarde)
			&& Objects.equals(indexNuvarandeAr, that.indexNuvarandeAr) && Objects.equals(indexNuvarandeManad, that.indexNuvarandeManad) && Objects.equals(indexNuvarandeVarde, that.indexNuvarandeVarde) && Objects.equals(
				radnummer, that.radnummer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, arrendekontrakt, arrendeartikel, avitext, debiterasFromDatum, debiterasTomDatum, basarshyra, arshyra, delAvArFrom, delAvArTom, indexklausul, indexnamn, indexandel, indexbasar, indexbasmanad, indexbasvarde, indexNuvarandeAr,
			indexNuvarandeManad, indexNuvarandeVarde, radnummer);
	}

	@Override
	public String toString() {
		return "ArrendekontraktsradEntity{" +
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
			'}';
	}
}
