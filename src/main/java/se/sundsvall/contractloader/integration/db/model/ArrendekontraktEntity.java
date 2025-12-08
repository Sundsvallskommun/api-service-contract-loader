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
@Table(name = "arrende_arrendekontrakt", schema = "contract_staging")
public class ArrendekontraktEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Size(max = 255)
	@Column(name = "arrendekontrakt")
	private String arrendekontrakt;

	@Size(max = 255)
	@Column(name = "hyresid")
	private String hyresid;

	@Column(name = "kontraktsdatum")
	private OffsetDateTime kontraktsdatum;

	@Column(name = "fr_o_m_datum")
	private OffsetDateTime fromDatum;

	@Column(name = "t_o_m_datum")
	private OffsetDateTime tomDatum;

	@Column(name = "sista_debiteringsdatum")
	private OffsetDateTime sistaDebiteringsdatum;

	@Column(name = "godkant_datum")
	private OffsetDateTime godkantDatum;

	@Column(name = "uppsagt_datum")
	private OffsetDateTime uppsagtDatum;

	@Size(max = 255)
	@Column(name = "uppsagt_av")
	private String uppsagtAv;

	@Column(name = "preliminart_uppsagt_datum")
	private OffsetDateTime preliminartUppsagtDatum;

	@Column(name = "onskad_avflyttning")
	private OffsetDateTime onskadAvflyttning;

	@Size(max = 255)
	@Column(name = "kontraktstyp")
	private String kontraktstyp;

	@Size(max = 255)
	@Column(name = "upps_tid_arrendator")
	private String uppsTidArrendator;

	@Size(max = 255)
	@Column(name = "enhet_upps_tid_arrendator")
	private String enhetUppsTidArrendator;

	@Size(max = 255)
	@Column(name = "upps_tid_hyresvard")
	private String uppsTidHyresvard;

	@Size(max = 255)
	@Column(name = "enhet_upps_tid_hyresvard")
	private String enhetUppsTidHyresvard;

	@Size(max = 255)
	@Column(name = "forlangning")
	private String forlangning;

	@Size(max = 255)
	@Column(name = "enhet_forlangning")
	private String enhetForlangning;

	@Size(max = 255)
	@Column(name = "debiteringstyp")
	private String debiteringstyp;

	@Size(max = 255)
	@Column(name = "kontraktsarea")
	private String kontraktsarea;

	@Size(max = 255)
	@Column(name = "frifalt")
	private String frifalt;

	@Size(max = 255)
	@Column(name = "fakturaperiod")
	private String fakturaperiod;

	@Size(max = 255)
	@Column(name = "markning")
	private String markning;

	@Size(max = 255)
	@Column(name = "kontraktsnamn")
	private String kontraktsnamn;

	@Size(max = 255)
	@Column(name = "huvudkontrakt")
	private String huvudkontrakt;

	@Size(max = 255)
	@Column(name = "kopplat_till_id")
	private String kopplatTillId;

	@Size(max = 255)
	@Column(name = "id")
	private String id1;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "arrendekontrakt", referencedColumnName = "arrendekontrakt")
	private List<ArrendekontraktsraderEntity> arrendekontraktsraderEntities;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "arrendekontrakt", referencedColumnName = "arrendekontrakt")
	private List<ArrendatorEntity> arrendatorEntities;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "hyresid", referencedColumnName = "hyresid")
	private List<FastighetEntity> fastigheterEntities;

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

	public OffsetDateTime getKontraktsdatum() {
		return kontraktsdatum;
	}

	public void setKontraktsdatum(OffsetDateTime kontraktsdatum) {
		this.kontraktsdatum = kontraktsdatum;
	}

	public ArrendekontraktEntity withKontraktsdatum(OffsetDateTime kontraktsdatum) {
		this.kontraktsdatum = kontraktsdatum;
		return this;
	}

	public OffsetDateTime getFromDatum() {
		return fromDatum;
	}

	public void setFromDatum(OffsetDateTime fromDatum) {
		this.fromDatum = fromDatum;
	}

	public ArrendekontraktEntity withFromDatum(OffsetDateTime fromDatum) {
		this.fromDatum = fromDatum;
		return this;
	}

	public OffsetDateTime getTomDatum() {
		return tomDatum;
	}

	public void setTomDatum(OffsetDateTime tomDatum) {
		this.tomDatum = tomDatum;
	}

	public ArrendekontraktEntity withTomDatum(OffsetDateTime tomDatum) {
		this.tomDatum = tomDatum;
		return this;
	}

	public OffsetDateTime getSistaDebiteringsdatum() {
		return sistaDebiteringsdatum;
	}

	public void setSistaDebiteringsdatum(OffsetDateTime sistaDebiteringsdatum) {
		this.sistaDebiteringsdatum = sistaDebiteringsdatum;
	}

	public ArrendekontraktEntity withSistaDebiteringsdatum(OffsetDateTime sistaDebiteringsdatum) {
		this.sistaDebiteringsdatum = sistaDebiteringsdatum;
		return this;
	}

	public OffsetDateTime getGodkantDatum() {
		return godkantDatum;
	}

	public void setGodkantDatum(OffsetDateTime godkantDatum) {
		this.godkantDatum = godkantDatum;
	}

	public ArrendekontraktEntity withGodkantDatum(OffsetDateTime godkantDatum) {
		this.godkantDatum = godkantDatum;
		return this;
	}

	public OffsetDateTime getUppsagtDatum() {
		return uppsagtDatum;
	}

	public void setUppsagtDatum(OffsetDateTime uppsagtDatum) {
		this.uppsagtDatum = uppsagtDatum;
	}

	public ArrendekontraktEntity withUppsagtDatum(OffsetDateTime uppsagtDatum) {
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

	public OffsetDateTime getPreliminartUppsagtDatum() {
		return preliminartUppsagtDatum;
	}

	public void setPreliminartUppsagtDatum(OffsetDateTime preliminartUppsagtDatum) {
		this.preliminartUppsagtDatum = preliminartUppsagtDatum;
	}

	public ArrendekontraktEntity withPreliminartUppsagtDatum(OffsetDateTime preliminartUppsagtDatum) {
		this.preliminartUppsagtDatum = preliminartUppsagtDatum;
		return this;
	}

	public OffsetDateTime getOnskadAvflyttning() {
		return onskadAvflyttning;
	}

	public void setOnskadAvflyttning(OffsetDateTime onskadAvflyttning) {
		this.onskadAvflyttning = onskadAvflyttning;
	}

	public ArrendekontraktEntity withOnskadAvflyttning(OffsetDateTime onskadAvflyttning) {
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

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public ArrendekontraktEntity withId1(String id1) {
		this.id1 = id1;
		return this;
	}

	public List<ArrendekontraktsraderEntity> getArrendekontraktsrader() {
		return arrendekontraktsraderEntities;
	}

	public void setArrendekontraktsrader(List<ArrendekontraktsraderEntity> arrendekontraktsraderEntities) {
		this.arrendekontraktsraderEntities = arrendekontraktsraderEntities;
	}

	public ArrendekontraktEntity withArrendekontraktsrader(List<ArrendekontraktsraderEntity> arrendekontraktsraderEntities) {
		this.arrendekontraktsraderEntities = arrendekontraktsraderEntities;
		return this;
	}

	public List<ArrendatorEntity> getArrendatorEntities() {
		return arrendatorEntities;
	}

	public void setArrendatorEntities(List<ArrendatorEntity> arrendatorEntities) {
		this.arrendatorEntities = arrendatorEntities;
	}

	public ArrendekontraktEntity withArrendatorEntities(List<ArrendatorEntity> arrendatorEntities) {
		this.arrendatorEntities = arrendatorEntities;
		return this;
	}

	public List<FastighetEntity> getFastigheterEntities() {
		return fastigheterEntities;
	}

	public void setFastigheterEntities(List<FastighetEntity> fastigheterEntities) {
		this.fastigheterEntities = fastigheterEntities;
	}

	public ArrendekontraktEntity withFastigheterEntities(List<FastighetEntity> fastigheterEntities) {
		this.fastigheterEntities = fastigheterEntities;
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
						kopplatTillId, that.kopplatTillId) && Objects.equals(id1, that.id1) && Objects.equals(arrendekontraktsraderEntities, that.arrendekontraktsraderEntities) && Objects.equals(arrendatorEntities,
							that.arrendatorEntities) && Objects.equals(fastigheterEntities, that.fastigheterEntities);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, arrendekontrakt, hyresid, kontraktsdatum, fromDatum, tomDatum, sistaDebiteringsdatum, godkantDatum, uppsagtDatum, uppsagtAv, preliminartUppsagtDatum, onskadAvflyttning, kontraktstyp, uppsTidArrendator,
			enhetUppsTidArrendator, uppsTidHyresvard, enhetUppsTidHyresvard, forlangning, enhetForlangning, debiteringstyp, kontraktsarea, frifalt, fakturaperiod, markning, kontraktsnamn, huvudkontrakt, kopplatTillId, id1, arrendekontraktsraderEntities,
			arrendatorEntities, fastigheterEntities);
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
			", id1='" + id1 + '\'' +
			", arrendekontraktsraderEntities=" + arrendekontraktsraderEntities +
			", arrendatorEntities=" + arrendatorEntities +
			", fastigheterEntities=" + fastigheterEntities +
			'}';
	}

}
