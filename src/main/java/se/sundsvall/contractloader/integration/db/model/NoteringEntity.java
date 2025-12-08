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
@Table(name = "gemensamt_notering", schema = "contract_staging")
public class NoteringEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Size(max = 255)
	@Column(name = "noteringsnamn")
	private String noteringsnamn;

	@Size(max = 255)
	@Column(name = "prioritet")
	private String prioritet;

	@Size(max = 255)
	@Column(name = "typ")
	private String typ;

	@Size(max = 255)
	@Column(name = "folder")
	private String folder;

	@Size(max = 255)
	@Column(name = "objektid")
	private String objektid;

	@Size(max = 255)
	@Column(name = "objektid2")
	private String objektid2;

	@Size(max = 255)
	@Column(name = "foretag")
	private String foretag;

	@Size(max = 255)
	@Column(name = "forvaltningsenhet")
	private String forvaltningsenhet;

	@Size(max = 255)
	@Column(name = "fastighetsnr")
	private String fastighetsnr;

	@Size(max = 255)
	@Column(name = "byggnad")
	private String byggnad;

	@Size(max = 255)
	@Column(name = "arrendeobjekt")
	private String arrendeobjekt;

	@Size(max = 255)
	@Column(name = "byggnadsdel")
	private String byggnadsdel;

	@Size(max = 255)
	@Column(name = "markyta")
	private String markyta;

	@Size(max = 255)
	@Column(name = "system")
	private String system;

	@Size(max = 255)
	@Column(name = "uppgang_vaning")
	private String uppgangVaning;

	@Size(max = 255)
	@Column(name = "bilplats")
	private String bilplats;

	@Size(max = 255)
	@Column(name = "lokal")
	private String lokal;

	@Size(max = 255)
	@Column(name = "bostad")
	private String bostad;

	@Size(max = 255)
	@Column(name = "underhallsenhet")
	private String underhallsenhet;

	@Size(max = 255)
	@Column(name = "ovrigt_hyresobjekt")
	private String ovrigtHyresobjekt;

	@Size(max = 255)
	@Column(name = "rum")
	private String rum;

	@Size(max = 255)
	@Column(name = "komponent")
	private String komponent;

	@Size(max = 255)
	@Column(name = "noteringsid")
	private String noteringsid;

	@Size(max = 255)
	@Column(name = "filnamn")
	private String filnamn;

	@Size(max = 255)
	@Column(name = "id")
	private String id1;

	public static NoteringEntity create() {
		return new NoteringEntity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NoteringEntity withId(Long id) {
		this.id = id;
		return this;
	}

	public String getNoteringsnamn() {
		return noteringsnamn;
	}

	public void setNoteringsnamn(String noteringsnamn) {
		this.noteringsnamn = noteringsnamn;
	}

	public NoteringEntity withNoteringsnamn(String noteringsnamn) {
		this.noteringsnamn = noteringsnamn;
		return this;
	}

	public String getPrioritet() {
		return prioritet;
	}

	public void setPrioritet(String prioritet) {
		this.prioritet = prioritet;
	}

	public NoteringEntity withPrioritet(String prioritet) {
		this.prioritet = prioritet;
		return this;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public NoteringEntity withTyp(String typ) {
		this.typ = typ;
		return this;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public NoteringEntity withFolder(String folder) {
		this.folder = folder;
		return this;
	}

	public String getObjektid() {
		return objektid;
	}

	public void setObjektid(String objektid) {
		this.objektid = objektid;
	}

	public NoteringEntity withObjektid(String objektid) {
		this.objektid = objektid;
		return this;
	}

	public String getObjektid2() {
		return objektid2;
	}

	public void setObjektid2(String objektid2) {
		this.objektid2 = objektid2;
	}

	public NoteringEntity withObjektid2(String objektid2) {
		this.objektid2 = objektid2;
		return this;
	}

	public String getForetag() {
		return foretag;
	}

	public void setForetag(String foretag) {
		this.foretag = foretag;
	}

	public NoteringEntity withForetag(String foretag) {
		this.foretag = foretag;
		return this;
	}

	public String getForvaltningsenhet() {
		return forvaltningsenhet;
	}

	public void setForvaltningsenhet(String forvaltningsenhet) {
		this.forvaltningsenhet = forvaltningsenhet;
	}

	public NoteringEntity withForvaltningsenhet(String forvaltningsenhet) {
		this.forvaltningsenhet = forvaltningsenhet;
		return this;
	}

	public String getFastighetsnr() {
		return fastighetsnr;
	}

	public void setFastighetsnr(String fastighetsnr) {
		this.fastighetsnr = fastighetsnr;
	}

	public NoteringEntity withFastighetsnr(String fastighetsnr) {
		this.fastighetsnr = fastighetsnr;
		return this;
	}

	public String getByggnad() {
		return byggnad;
	}

	public void setByggnad(String byggnad) {
		this.byggnad = byggnad;
	}

	public NoteringEntity withByggnad(String byggnad) {
		this.byggnad = byggnad;
		return this;
	}

	public String getArrendeobjekt() {
		return arrendeobjekt;
	}

	public void setArrendeobjekt(String arrendeobjekt) {
		this.arrendeobjekt = arrendeobjekt;
	}

	public NoteringEntity withArrendeobjekt(String arrendeobjekt) {
		this.arrendeobjekt = arrendeobjekt;
		return this;
	}

	public String getByggnadsdel() {
		return byggnadsdel;
	}

	public void setByggnadsdel(String byggnadsdel) {
		this.byggnadsdel = byggnadsdel;
	}

	public NoteringEntity withByggnadsdel(String byggnadsdel) {
		this.byggnadsdel = byggnadsdel;
		return this;
	}

	public String getMarkyta() {
		return markyta;
	}

	public void setMarkyta(String markyta) {
		this.markyta = markyta;
	}

	public NoteringEntity withMarkyta(String markyta) {
		this.markyta = markyta;
		return this;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public NoteringEntity withSystem(String system) {
		this.system = system;
		return this;
	}

	public String getUppgangVaning() {
		return uppgangVaning;
	}

	public void setUppgangVaning(String uppgangVaning) {
		this.uppgangVaning = uppgangVaning;
	}

	public NoteringEntity withUppgangVaning(String uppgangVaning) {
		this.uppgangVaning = uppgangVaning;
		return this;
	}

	public String getBilplats() {
		return bilplats;
	}

	public void setBilplats(String bilplats) {
		this.bilplats = bilplats;
	}

	public NoteringEntity withBilplats(String bilplats) {
		this.bilplats = bilplats;
		return this;
	}

	public String getLokal() {
		return lokal;
	}

	public void setLokal(String lokal) {
		this.lokal = lokal;
	}

	public NoteringEntity withLokal(String lokal) {
		this.lokal = lokal;
		return this;
	}

	public String getBostad() {
		return bostad;
	}

	public void setBostad(String bostad) {
		this.bostad = bostad;
	}

	public NoteringEntity withBostad(String bostad) {
		this.bostad = bostad;
		return this;
	}

	public String getUnderhallsenhet() {
		return underhallsenhet;
	}

	public void setUnderhallsenhet(String underhallsenhet) {
		this.underhallsenhet = underhallsenhet;
	}

	public NoteringEntity withUnderhallsenhet(String underhallsenhet) {
		this.underhallsenhet = underhallsenhet;
		return this;
	}

	public String getOvrigtHyresobjekt() {
		return ovrigtHyresobjekt;
	}

	public void setOvrigtHyresobjekt(String ovrigtHyresobjekt) {
		this.ovrigtHyresobjekt = ovrigtHyresobjekt;
	}

	public NoteringEntity withOvrigtHyresobjekt(String ovrigtHyresobjekt) {
		this.ovrigtHyresobjekt = ovrigtHyresobjekt;
		return this;
	}

	public String getRum() {
		return rum;
	}

	public void setRum(String rum) {
		this.rum = rum;
	}

	public NoteringEntity withRum(String rum) {
		this.rum = rum;
		return this;
	}

	public String getKomponent() {
		return komponent;
	}

	public void setKomponent(String komponent) {
		this.komponent = komponent;
	}

	public NoteringEntity withKomponent(String komponent) {
		this.komponent = komponent;
		return this;
	}

	public String getNoteringsid() {
		return noteringsid;
	}

	public void setNoteringsid(String noteringsid) {
		this.noteringsid = noteringsid;
	}

	public NoteringEntity withNoteringsid(String noteringsid) {
		this.noteringsid = noteringsid;
		return this;
	}

	public String getFilnamn() {
		return filnamn;
	}

	public void setFilnamn(String filnamn) {
		this.filnamn = filnamn;
	}

	public NoteringEntity withFilnamn(String filnamn) {
		this.filnamn = filnamn;
		return this;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public NoteringEntity withId1(String id1) {
		this.id1 = id1;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		NoteringEntity that = (NoteringEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(noteringsnamn, that.noteringsnamn) && Objects.equals(prioritet, that.prioritet) && Objects.equals(typ, that.typ) && Objects.equals(folder,
			that.folder) && Objects.equals(objektid, that.objektid) && Objects.equals(objektid2, that.objektid2) && Objects.equals(foretag, that.foretag) && Objects.equals(forvaltningsenhet, that.forvaltningsenhet)
			&& Objects.equals(fastighetsnr, that.fastighetsnr) && Objects.equals(byggnad, that.byggnad) && Objects.equals(arrendeobjekt, that.arrendeobjekt) && Objects.equals(byggnadsdel, that.byggnadsdel)
			&& Objects.equals(markyta, that.markyta) && Objects.equals(system, that.system) && Objects.equals(uppgangVaning, that.uppgangVaning) && Objects.equals(bilplats, that.bilplats) && Objects.equals(
				lokal, that.lokal) && Objects.equals(bostad, that.bostad) && Objects.equals(underhallsenhet, that.underhallsenhet) && Objects.equals(ovrigtHyresobjekt, that.ovrigtHyresobjekt) && Objects.equals(rum, that.rum)
			&& Objects.equals(komponent, that.komponent) && Objects.equals(noteringsid, that.noteringsid) && Objects.equals(filnamn, that.filnamn) && Objects.equals(id1, that.id1);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, noteringsnamn, prioritet, typ, folder, objektid, objektid2, foretag, forvaltningsenhet, fastighetsnr, byggnad, arrendeobjekt, byggnadsdel, markyta, system, uppgangVaning, bilplats, lokal, bostad, underhallsenhet,
			ovrigtHyresobjekt, rum, komponent, noteringsid, filnamn, id1);
	}

	@Override
	public String toString() {
		return "NoteringEntity{" +
			"id=" + id +
			", noteringsnamn='" + noteringsnamn + '\'' +
			", prioritet='" + prioritet + '\'' +
			", typ='" + typ + '\'' +
			", folder='" + folder + '\'' +
			", objektid='" + objektid + '\'' +
			", objektid2='" + objektid2 + '\'' +
			", foretag='" + foretag + '\'' +
			", forvaltningsenhet='" + forvaltningsenhet + '\'' +
			", fastighetsnr='" + fastighetsnr + '\'' +
			", byggnad='" + byggnad + '\'' +
			", arrendeobjekt='" + arrendeobjekt + '\'' +
			", byggnadsdel='" + byggnadsdel + '\'' +
			", markyta='" + markyta + '\'' +
			", system='" + system + '\'' +
			", uppgangVaning='" + uppgangVaning + '\'' +
			", bilplats='" + bilplats + '\'' +
			", lokal='" + lokal + '\'' +
			", bostad='" + bostad + '\'' +
			", underhallsenhet='" + underhallsenhet + '\'' +
			", ovrigtHyresobjekt='" + ovrigtHyresobjekt + '\'' +
			", rum='" + rum + '\'' +
			", komponent='" + komponent + '\'' +
			", noteringsid='" + noteringsid + '\'' +
			", filnamn='" + filnamn + '\'' +
			", id1='" + id1 + '\'' +
			'}';
	}
}
