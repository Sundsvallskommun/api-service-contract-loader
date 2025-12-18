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
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "arrende_arrendekontrakt")
public class ArrendekontraktEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Column(name = "arrendekontrakt")
	private String arrendekontrakt;

	@Column(name = "hyresid")
	private String hyresid;

	@Column(name = "kontraktsdatum")
	private LocalDate kontraktsdatum;

	@Column(name = "fr_o_m_datum")
	private LocalDate fromDatum;

	@Column(name = "t_o_m_datum")
	private LocalDate tomDatum;

	@Column(name = "sista_debiteringsdatum")
	private LocalDate sistaDebiteringsdatum;

	@Column(name = "godkant_datum")
	private LocalDate godkantDatum;

	@Column(name = "uppsagt_datum")
	private LocalDate uppsagtDatum;

	@Column(name = "uppsagt_av")
	private String uppsagtAv;

	@Column(name = "preliminart_uppsagt_datum")
	private LocalDate preliminartUppsagtDatum;

	@Column(name = "onskad_avflyttning")
	private LocalDate onskadAvflyttning;

	@Column(name = "kontraktstyp")
	private String kontraktstyp;

	@Column(name = "upps_tid_arrendator")
	private String uppsTidArrendator;

	@Column(name = "enhet_upps_tid_arrendator")
	private String enhetUppsTidArrendator;

	@Column(name = "upps_tid_hyresvard")
	private String uppsTidHyresvard;

	@Column(name = "enhet_upps_tid_hyresvard")
	private String enhetUppsTidHyresvard;

	@Column(name = "forlangning")
	private String forlangning;

	@Column(name = "enhet_forlangning")
	private String enhetForlangning;

	@Column(name = "debiteringstyp")
	private String debiteringstyp;

	@Column(name = "kontraktsarea")
	private String kontraktsarea;

	@Column(name = "frifalt")
	private String frifalt;

	@Column(name = "fakturaperiod")
	private String fakturaperiod;

	@Column(name = "markning")
	private String markning;

	@Column(name = "kontraktsnamn")
	private String kontraktsnamn;

	@Column(name = "huvudkontrakt")
	private String huvudkontrakt;

	@Column(name = "kopplat_till_id")
	private String kopplatTillId;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "arrendekontrakt", referencedColumnName = "arrendekontrakt")
	private List<ArrendekontraktsradEntity> arrendekontraktsrader;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "arrendekontrakt", referencedColumnName = "arrendekontrakt")
	private List<ArrendatorEntity> arrendatorer;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "hyresid", referencedColumnName = "hyresid")
	private List<FastighetEntity> fastigheter;

	public static ArrendekontraktEntity create() {
		return new ArrendekontraktEntity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrendekontraktEntity withId(Long id) {
		this.id = id;
		return this;
	}

	public String getArrendekontrakt() {
		return arrendekontrakt;
	}

	public void setArrendekontrakt(String arrendekontrakt) {
		this.arrendekontrakt = arrendekontrakt;
	}

	public ArrendekontraktEntity withArrendekontrakt(String arrendekontrakt) {
		this.arrendekontrakt = arrendekontrakt;
		return this;
	}

	public String getHyresid() {
		return hyresid;
	}

	public void setHyresid(String hyresid) {
		this.hyresid = hyresid;
	}

	public ArrendekontraktEntity withHyresid(String hyresid) {
		this.hyresid = hyresid;
		return this;
	}

	public LocalDate getKontraktsdatum() {
		return kontraktsdatum;
	}

	public void setKontraktsdatum(LocalDate kontraktsdatum) {
		this.kontraktsdatum = kontraktsdatum;
	}

	public ArrendekontraktEntity withKontraktsdatum(LocalDate kontraktsdatum) {
		this.kontraktsdatum = kontraktsdatum;
		return this;
	}

	public LocalDate getFromDatum() {
		return fromDatum;
	}

	public void setFromDatum(LocalDate fromDatum) {
		this.fromDatum = fromDatum;
	}

	public ArrendekontraktEntity withFromDatum(LocalDate fromDatum) {
		this.fromDatum = fromDatum;
		return this;
	}

	public LocalDate getTomDatum() {
		return tomDatum;
	}

	public void setTomDatum(LocalDate tomDatum) {
		this.tomDatum = tomDatum;
	}

	public ArrendekontraktEntity withTomDatum(LocalDate tomDatum) {
		this.tomDatum = tomDatum;
		return this;
	}

	public LocalDate getSistaDebiteringsdatum() {
		return sistaDebiteringsdatum;
	}

	public void setSistaDebiteringsdatum(LocalDate sistaDebiteringsdatum) {
		this.sistaDebiteringsdatum = sistaDebiteringsdatum;
	}

	public ArrendekontraktEntity withSistaDebiteringsdatum(LocalDate sistaDebiteringsdatum) {
		this.sistaDebiteringsdatum = sistaDebiteringsdatum;
		return this;
	}

	public LocalDate getGodkantDatum() {
		return godkantDatum;
	}

	public void setGodkantDatum(LocalDate godkantDatum) {
		this.godkantDatum = godkantDatum;
	}

	public ArrendekontraktEntity withGodkantDatum(LocalDate godkantDatum) {
		this.godkantDatum = godkantDatum;
		return this;
	}

	public LocalDate getUppsagtDatum() {
		return uppsagtDatum;
	}

	public void setUppsagtDatum(LocalDate uppsagtDatum) {
		this.uppsagtDatum = uppsagtDatum;
	}

	public ArrendekontraktEntity withUppsagtDatum(LocalDate uppsagtDatum) {
		this.uppsagtDatum = uppsagtDatum;
		return this;
	}

	public String getUppsagtAv() {
		return uppsagtAv;
	}

	public void setUppsagtAv(String uppsagtAv) {
		this.uppsagtAv = uppsagtAv;
	}

	public ArrendekontraktEntity withUppsagtAv(String uppsagtAv) {
		this.uppsagtAv = uppsagtAv;
		return this;
	}

	public LocalDate getPreliminartUppsagtDatum() {
		return preliminartUppsagtDatum;
	}

	public void setPreliminartUppsagtDatum(LocalDate preliminartUppsagtDatum) {
		this.preliminartUppsagtDatum = preliminartUppsagtDatum;
	}

	public ArrendekontraktEntity withPreliminartUppsagtDatum(LocalDate preliminartUppsagtDatum) {
		this.preliminartUppsagtDatum = preliminartUppsagtDatum;
		return this;
	}

	public LocalDate getOnskadAvflyttning() {
		return onskadAvflyttning;
	}

	public void setOnskadAvflyttning(LocalDate onskadAvflyttning) {
		this.onskadAvflyttning = onskadAvflyttning;
	}

	public ArrendekontraktEntity withOnskadAvflyttning(LocalDate onskadAvflyttning) {
		this.onskadAvflyttning = onskadAvflyttning;
		return this;
	}

	public String getKontraktstyp() {
		return kontraktstyp;
	}

	public void setKontraktstyp(String kontraktstyp) {
		this.kontraktstyp = kontraktstyp;
	}

	public ArrendekontraktEntity withKontraktstyp(String kontraktstyp) {
		this.kontraktstyp = kontraktstyp;
		return this;
	}

	public String getUppsTidArrendator() {
		return uppsTidArrendator;
	}

	public void setUppsTidArrendator(String uppsTidArrendator) {
		this.uppsTidArrendator = uppsTidArrendator;
	}

	public ArrendekontraktEntity withUppsTidArrendator(String uppsTidArrendator) {
		this.uppsTidArrendator = uppsTidArrendator;
		return this;
	}

	public String getEnhetUppsTidArrendator() {
		return enhetUppsTidArrendator;
	}

	public void setEnhetUppsTidArrendator(String enhetUppsTidArrendator) {
		this.enhetUppsTidArrendator = enhetUppsTidArrendator;
	}

	public ArrendekontraktEntity withEnhetUppsTidArrendator(String enhetUppsTidArrendator) {
		this.enhetUppsTidArrendator = enhetUppsTidArrendator;
		return this;
	}

	public String getUppsTidHyresvard() {
		return uppsTidHyresvard;
	}

	public void setUppsTidHyresvard(String uppsTidHyresvard) {
		this.uppsTidHyresvard = uppsTidHyresvard;
	}

	public ArrendekontraktEntity withUppsTidHyresvard(String uppsTidHyresvard) {
		this.uppsTidHyresvard = uppsTidHyresvard;
		return this;
	}

	public String getEnhetUppsTidHyresvard() {
		return enhetUppsTidHyresvard;
	}

	public void setEnhetUppsTidHyresvard(String enhetUppsTidHyresvard) {
		this.enhetUppsTidHyresvard = enhetUppsTidHyresvard;
	}

	public ArrendekontraktEntity withEnhetUppsTidHyresvard(String enhetUppsTidHyresvard) {
		this.enhetUppsTidHyresvard = enhetUppsTidHyresvard;
		return this;
	}

	public String getForlangning() {
		return forlangning;
	}

	public void setForlangning(String forlangning) {
		this.forlangning = forlangning;
	}

	public ArrendekontraktEntity withForlangning(String forlangning) {
		this.forlangning = forlangning;
		return this;
	}

	public String getEnhetForlangning() {
		return enhetForlangning;
	}

	public void setEnhetForlangning(String enhetForlangning) {
		this.enhetForlangning = enhetForlangning;
	}

	public ArrendekontraktEntity withEnhetForlangning(String enhetForlangning) {
		this.enhetForlangning = enhetForlangning;
		return this;
	}

	public String getDebiteringstyp() {
		return debiteringstyp;
	}

	public void setDebiteringstyp(String debiteringstyp) {
		this.debiteringstyp = debiteringstyp;
	}

	public ArrendekontraktEntity withDebiteringstyp(String debiteringstyp) {
		this.debiteringstyp = debiteringstyp;
		return this;
	}

	public String getKontraktsarea() {
		return kontraktsarea;
	}

	public void setKontraktsarea(String kontraktsarea) {
		this.kontraktsarea = kontraktsarea;
	}

	public ArrendekontraktEntity withKontraktsarea(String kontraktsarea) {
		this.kontraktsarea = kontraktsarea;
		return this;
	}

	public String getFrifalt() {
		return frifalt;
	}

	public void setFrifalt(String frifalt) {
		this.frifalt = frifalt;
	}

	public ArrendekontraktEntity withFrifalt(String frifalt) {
		this.frifalt = frifalt;
		return this;
	}

	public String getFakturaperiod() {
		return fakturaperiod;
	}

	public void setFakturaperiod(String fakturaperiod) {
		this.fakturaperiod = fakturaperiod;
	}

	public ArrendekontraktEntity withFakturaperiod(String fakturaperiod) {
		this.fakturaperiod = fakturaperiod;
		return this;
	}

	public String getMarkning() {
		return markning;
	}

	public void setMarkning(String markning) {
		this.markning = markning;
	}

	public ArrendekontraktEntity withMarkning(String markning) {
		this.markning = markning;
		return this;
	}

	public String getKontraktsnamn() {
		return kontraktsnamn;
	}

	public void setKontraktsnamn(String kontraktsnamn) {
		this.kontraktsnamn = kontraktsnamn;
	}

	public ArrendekontraktEntity withKontraktsnamn(String kontraktsnamn) {
		this.kontraktsnamn = kontraktsnamn;
		return this;
	}

	public String getHuvudkontrakt() {
		return huvudkontrakt;
	}

	public void setHuvudkontrakt(String huvudkontrakt) {
		this.huvudkontrakt = huvudkontrakt;
	}

	public ArrendekontraktEntity withHuvudkontrakt(String huvudkontrakt) {
		this.huvudkontrakt = huvudkontrakt;
		return this;
	}

	public String getKopplatTillId() {
		return kopplatTillId;
	}

	public void setKopplatTillId(String kopplatTillId) {
		this.kopplatTillId = kopplatTillId;
	}

	public ArrendekontraktEntity withKopplatTillId(String kopplatTillId) {
		this.kopplatTillId = kopplatTillId;
		return this;
	}

	public List<ArrendekontraktsradEntity> getArrendekontraktsrader() {
		return arrendekontraktsrader;
	}

	public void setArrendekontraktsrader(List<ArrendekontraktsradEntity> arrendekontraktsrader) {
		this.arrendekontraktsrader = arrendekontraktsrader;
	}

	public ArrendekontraktEntity withArrendekontraktsrader(List<ArrendekontraktsradEntity> arrendekontraktsrader) {
		this.arrendekontraktsrader = arrendekontraktsrader;
		return this;
	}

	public List<ArrendatorEntity> getArrendatorer() {
		return arrendatorer;
	}

	public void setArrendatorer(List<ArrendatorEntity> arrendatorer) {
		this.arrendatorer = arrendatorer;
	}

	public ArrendekontraktEntity withArrendatorer(List<ArrendatorEntity> arrendatorer) {
		this.arrendatorer = arrendatorer;
		return this;
	}

	public List<FastighetEntity> getFastigheter() {
		return fastigheter;
	}

	public void setFastigheter(List<FastighetEntity> fastigheter) {
		this.fastigheter = fastigheter;
	}

	public ArrendekontraktEntity withFastigheter(List<FastighetEntity> fastigheter) {
		this.fastigheter = fastigheter;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		ArrendekontraktEntity that = (ArrendekontraktEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(arrendekontrakt, that.arrendekontrakt) && Objects.equals(hyresid, that.hyresid) && Objects.equals(kontraktsdatum, that.kontraktsdatum)
			&& Objects.equals(fromDatum, that.fromDatum) && Objects.equals(tomDatum, that.tomDatum) && Objects.equals(sistaDebiteringsdatum, that.sistaDebiteringsdatum) && Objects.equals(godkantDatum, that.godkantDatum)
			&& Objects.equals(uppsagtDatum, that.uppsagtDatum) && Objects.equals(uppsagtAv, that.uppsagtAv) && Objects.equals(preliminartUppsagtDatum, that.preliminartUppsagtDatum) && Objects.equals(onskadAvflyttning,
				that.onskadAvflyttning) && Objects.equals(kontraktstyp, that.kontraktstyp) && Objects.equals(uppsTidArrendator, that.uppsTidArrendator) && Objects.equals(enhetUppsTidArrendator, that.enhetUppsTidArrendator)
			&& Objects.equals(uppsTidHyresvard, that.uppsTidHyresvard) && Objects.equals(enhetUppsTidHyresvard, that.enhetUppsTidHyresvard) && Objects.equals(forlangning, that.forlangning) && Objects.equals(
				enhetForlangning, that.enhetForlangning) && Objects.equals(debiteringstyp, that.debiteringstyp) && Objects.equals(kontraktsarea, that.kontraktsarea) && Objects.equals(frifalt, that.frifalt) && Objects.equals(
					fakturaperiod, that.fakturaperiod) && Objects.equals(markning, that.markning) && Objects.equals(kontraktsnamn, that.kontraktsnamn) && Objects.equals(huvudkontrakt, that.huvudkontrakt) && Objects.equals(
						kopplatTillId, that.kopplatTillId) && Objects.equals(arrendekontraktsrader, that.arrendekontraktsrader) && Objects.equals(arrendatorer,
							that.arrendatorer) && Objects.equals(fastigheter, that.fastigheter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, arrendekontrakt, hyresid, kontraktsdatum, fromDatum, tomDatum, sistaDebiteringsdatum, godkantDatum, uppsagtDatum, uppsagtAv, preliminartUppsagtDatum, onskadAvflyttning, kontraktstyp, uppsTidArrendator,
			enhetUppsTidArrendator, uppsTidHyresvard, enhetUppsTidHyresvard, forlangning, enhetForlangning, debiteringstyp, kontraktsarea, frifalt, fakturaperiod, markning, kontraktsnamn, huvudkontrakt, kopplatTillId, arrendekontraktsrader,
			arrendatorer, fastigheter);
	}

	@Override
	public String toString() {
		return "ArrendekontraktEntity{" +
			"id=" + id +
			", arrendekontrakt='" + arrendekontrakt + '\'' +
			", hyresid='" + hyresid + '\'' +
			", kontraktsdatum=" + kontraktsdatum +
			", fromDatum=" + fromDatum +
			", tomDatum=" + tomDatum +
			", sistaDebiteringsdatum=" + sistaDebiteringsdatum +
			", godkantDatum=" + godkantDatum +
			", uppsagtDatum=" + uppsagtDatum +
			", uppsagtAv='" + uppsagtAv + '\'' +
			", preliminartUppsagtDatum=" + preliminartUppsagtDatum +
			", onskadAvflyttning=" + onskadAvflyttning +
			", kontraktstyp='" + kontraktstyp + '\'' +
			", uppsTidArrendator='" + uppsTidArrendator + '\'' +
			", enhetUppsTidArrendator='" + enhetUppsTidArrendator + '\'' +
			", uppsTidHyresvard='" + uppsTidHyresvard + '\'' +
			", enhetUppsTidHyresvard='" + enhetUppsTidHyresvard + '\'' +
			", forlangning='" + forlangning + '\'' +
			", enhetForlangning='" + enhetForlangning + '\'' +
			", debiteringstyp='" + debiteringstyp + '\'' +
			", kontraktsarea='" + kontraktsarea + '\'' +
			", frifalt='" + frifalt + '\'' +
			", fakturaperiod='" + fakturaperiod + '\'' +
			", markning='" + markning + '\'' +
			", kontraktsnamn='" + kontraktsnamn + '\'' +
			", huvudkontrakt='" + huvudkontrakt + '\'' +
			", kopplatTillId='" + kopplatTillId + '\'' +
			", arrendekontraktsrader=" + arrendekontraktsrader +
			", arrendatorer=" + arrendatorer +
			", fastigheter=" + fastigheter +
			'}';
	}

}
