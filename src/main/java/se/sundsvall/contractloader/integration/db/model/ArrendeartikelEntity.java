package se.sundsvall.contractloader.integration.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "arrende_arrendeartikel", schema = "contract_staging")
public class ArrendeartikelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Size(max = 255)
	@Column(name = "arrendeartikel")
	private String arrendeartikel;

	@Size(max = 255)
	@Column(name = "artikelbenamning")
	private String artikelbenamning;

	@Size(max = 255)
	@Column(name = "avitext")
	private String avitext;

	@Size(max = 255)
	@Column(name = "artikelgrupp")
	private String artikelgrupp;

	@Size(max = 255)
	@Column(name = "artikeltyp")
	private String artikeltyp;

	@Size(max = 255)
	@Column(name = "reglering")
	private String reglering;

	@Size(max = 255)
	@Column(name = "pris")
	private String pris;

	@Size(max = 255)
	@Column(name = "ingar_i_kontraktssumma")
	private String ingarIKontraktssumma;

	@Size(max = 255)
	@Column(name = "avdrag")
	private String avdrag;

	@Size(max = 255)
	@Column(name = "debiteras_alltid_hel_period")
	private String debiterasAlltidHelPeriod;

	@Size(max = 255)
	@Column(name = "avvikelsetolerans_procent")
	private String avvikelsetoleransProcent;

	@Size(max = 255)
	@Column(name = "summarad")
	private String summarad;

	@Size(max = 255)
	@Column(name = "aktiv")
	private String aktiv;

	@Size(max = 255)
	@Column(name = "id")
	private String id1;

	public static ArrendeartikelEntity create() {
		return new ArrendeartikelEntity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrendeartikelEntity withId(Long id) {
		this.id = id;
		return this;
	}

	public String getArrendeartikel() {
		return arrendeartikel;
	}

	public void setArrendeartikel(String arrendeartikel) {
		this.arrendeartikel = arrendeartikel;
	}

	public ArrendeartikelEntity withArrendeartikel(String arrendeartikel) {
		this.arrendeartikel = arrendeartikel;
		return this;
	}

	public String getArtikelbenamning() {
		return artikelbenamning;
	}

	public void setArtikelbenamning(String artikelbenamning) {
		this.artikelbenamning = artikelbenamning;
	}

	public ArrendeartikelEntity withArtikelbenamning(String artikelbenamning) {
		this.artikelbenamning = artikelbenamning;
		return this;
	}

	public String getAvitext() {
		return avitext;
	}

	public void setAvitext(String avitext) {
		this.avitext = avitext;
	}

	public ArrendeartikelEntity withAvitext(String avitext) {
		this.avitext = avitext;
		return this;
	}

	public String getArtikelgrupp() {
		return artikelgrupp;
	}

	public void setArtikelgrupp(String artikelgrupp) {
		this.artikelgrupp = artikelgrupp;
	}

	public ArrendeartikelEntity withArtikelgrupp(String artikelgrupp) {
		this.artikelgrupp = artikelgrupp;
		return this;
	}

	public String getArtikeltyp() {
		return artikeltyp;
	}

	public void setArtikeltyp(String artikeltyp) {
		this.artikeltyp = artikeltyp;
	}

	public ArrendeartikelEntity withArtikeltyp(String artikeltyp) {
		this.artikeltyp = artikeltyp;
		return this;
	}

	public String getReglering() {
		return reglering;
	}

	public void setReglering(String reglering) {
		this.reglering = reglering;
	}

	public ArrendeartikelEntity withReglering(String reglering) {
		this.reglering = reglering;
		return this;
	}

	public String getPris() {
		return pris;
	}

	public void setPris(String pris) {
		this.pris = pris;
	}

	public ArrendeartikelEntity withPris(String pris) {
		this.pris = pris;
		return this;
	}

	public String getIngarIKontraktssumma() {
		return ingarIKontraktssumma;
	}

	public void setIngarIKontraktssumma(String ingarIKontraktssumma) {
		this.ingarIKontraktssumma = ingarIKontraktssumma;
	}

	ArrendeartikelEntity withIngarIKontraktssumma(String ingarIKontraktssumma) {
		this.ingarIKontraktssumma = ingarIKontraktssumma;
		return this;
	}

	public String getAvdrag() {
		return avdrag;
	}

	public void setAvdrag(String avdrag) {
		this.avdrag = avdrag;
	}

	public ArrendeartikelEntity withAvdrag(String avdrag) {
		this.avdrag = avdrag;
		return this;
	}

	public String getDebiterasAlltidHelPeriod() {
		return debiterasAlltidHelPeriod;
	}

	public void setDebiterasAlltidHelPeriod(String debiterasAlltidHelPeriod) {
		this.debiterasAlltidHelPeriod = debiterasAlltidHelPeriod;
	}

	public ArrendeartikelEntity withDebiterasAlltidHelPeriod(String debiterasAlltidHelPeriod) {
		this.debiterasAlltidHelPeriod = debiterasAlltidHelPeriod;
		return this;
	}

	public String getAvvikelsetoleransProcent() {
		return avvikelsetoleransProcent;
	}

	public void setAvvikelsetoleransProcent(String avvikelsetoleransProcent) {
		this.avvikelsetoleransProcent = avvikelsetoleransProcent;
	}

	public ArrendeartikelEntity withAvvikelsetoleransProcent(String avvikelsetoleransProcent) {
		this.avvikelsetoleransProcent = avvikelsetoleransProcent;
		return this;
	}

	public String getSummarad() {
		return summarad;
	}

	public void setSummarad(String summarad) {
		this.summarad = summarad;
	}

	public ArrendeartikelEntity withSummarad(String summarad) {
		this.summarad = summarad;
		return this;
	}

	public String getAktiv() {
		return aktiv;
	}

	public void setAktiv(String aktiv) {
		this.aktiv = aktiv;
	}

	public ArrendeartikelEntity withAktiv(String aktiv) {
		this.aktiv = aktiv;
		return this;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public ArrendeartikelEntity withId1(String id1) {
		this.id1 = id1;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		ArrendeartikelEntity that = (ArrendeartikelEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(arrendeartikel, that.arrendeartikel) && Objects.equals(artikelbenamning, that.artikelbenamning) && Objects.equals(avitext, that.avitext)
			&& Objects.equals(artikelgrupp, that.artikelgrupp) && Objects.equals(artikeltyp, that.artikeltyp) && Objects.equals(reglering, that.reglering) && Objects.equals(pris, that.pris) && Objects.equals(
				ingarIKontraktssumma, that.ingarIKontraktssumma) && Objects.equals(avdrag, that.avdrag) && Objects.equals(debiterasAlltidHelPeriod, that.debiterasAlltidHelPeriod) && Objects.equals(avvikelsetoleransProcent,
					that.avvikelsetoleransProcent) && Objects.equals(summarad, that.summarad) && Objects.equals(aktiv, that.aktiv) && Objects.equals(id1, that.id1);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, arrendeartikel, artikelbenamning, avitext, artikelgrupp, artikeltyp, reglering, pris, ingarIKontraktssumma, avdrag, debiterasAlltidHelPeriod, avvikelsetoleransProcent, summarad, aktiv, id1);
	}

	@Override
	public String toString() {
		return "ArrendeartikelEntity{" +
			"id=" + id +
			", arrendeartikel='" + arrendeartikel + '\'' +
			", artikelbenamning='" + artikelbenamning + '\'' +
			", avitext='" + avitext + '\'' +
			", artikelgrupp='" + artikelgrupp + '\'' +
			", artikeltyp='" + artikeltyp + '\'' +
			", reglering='" + reglering + '\'' +
			", pris='" + pris + '\'' +
			", ingarIKontraktssumma='" + ingarIKontraktssumma + '\'' +
			", avdrag='" + avdrag + '\'' +
			", debiterasAlltidHelPeriod='" + debiterasAlltidHelPeriod + '\'' +
			", avvikelsetoleransProcent='" + avvikelsetoleransProcent + '\'' +
			", summarad='" + summarad + '\'' +
			", aktiv='" + aktiv + '\'' +
			", id1='" + id1 + '\'' +
			'}';
	}
}
