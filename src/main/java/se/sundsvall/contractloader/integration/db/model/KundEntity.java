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
@Table(name = "kundreskontra_kund", schema = "contract_staging")
public class KundEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Size(max = 255)
	@Column(name = "person_org_nr")
	private String personOrgNr;

	@Size(max = 255)
	@Column(name = "kontaktid")
	private String kontaktid;

	@Size(max = 255)
	@Column(name = "kategori")
	private String kategori;

	@Size(max = 255)
	@Column(name = "namn")
	private String namn;

	@Size(max = 255)
	@Column(name = "fornamn")
	private String fornamn;

	@Size(max = 255)
	@Column(name = "efternamn")
	private String efternamn;

	@Size(max = 255)
	@Column(name = "avdelning")
	private String avdelning;

	@Size(max = 255)
	@Column(name = "postadress")
	private String postadress;

	@Size(max = 255)
	@Column(name = "postadress2")
	private String postadress2;

	@Size(max = 255)
	@Column(name = "postnummer")
	private String postnummer;

	@Size(max = 255)
	@Column(name = "ort")
	private String ort;

	@Size(max = 255)
	@Column(name = "land")
	private String land;

	@Size(max = 255)
	@Column(name = "telefon_mobil")
	private String telefonMobil;

	@Size(max = 255)
	@Column(name = "telefon_hem")
	private String telefonHem;

	@Size(max = 255)
	@Column(name = "telefon_arbete")
	private String telefonArbete;

	@Size(max = 255)
	@Column(name = "e_post")
	private String epost;

	@Size(max = 255)
	@Column(name = "foredraget_kontaktsatt")
	private String foredragetKontaktsatt;

	@Size(max = 255)
	@Column(name = "svefaktura")
	private String svefaktura;

	@Size(max = 255)
	@Column(name = "efakturaadress")
	private String efakturaadress;

	@Size(max = 255)
	@Column(name = "forvaltartyp")
	private String forvaltartyp;

	@Size(max = 255)
	@Column(name = "god_man_forvaltare")
	private String godManForvaltare;

	@Size(max = 255)
	@Column(name = "aktiv")
	private String aktiv;

	@Size(max = 255)
	@Column(name = "id")
	private String id1;

	public static KundEntity create() {
		return new KundEntity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KundEntity withId(Long id) {
		this.id = id;
		return this;
	}

	public String getPersonOrgNr() {
		return personOrgNr;
	}

	public void setPersonOrgNr(String personOrgNr) {
		this.personOrgNr = personOrgNr;
	}

	public KundEntity withPersonOrgNr(String personOrgNr) {
		this.personOrgNr = personOrgNr;
		return this;
	}

	public String getKontaktid() {
		return kontaktid;
	}

	public void setKontaktid(String kontaktid) {
		this.kontaktid = kontaktid;
	}

	public KundEntity withKontaktid(String kontaktid) {
		this.kontaktid = kontaktid;
		return this;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public KundEntity withKategori(String kategori) {
		this.kategori = kategori;
		return this;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public KundEntity withNamn(String namn) {
		this.namn = namn;
		return this;
	}

	public String getFornamn() {
		return fornamn;
	}

	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}

	public KundEntity withFornamn(String fornamn) {
		this.fornamn = fornamn;
		return this;
	}

	public String getEfternamn() {
		return efternamn;
	}

	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}

	public KundEntity withEfternamn(String efternamn) {
		this.efternamn = efternamn;
		return this;
	}

	public String getAvdelning() {
		return avdelning;
	}

	public void setAvdelning(String avdelning) {
		this.avdelning = avdelning;
	}

	public KundEntity withAvdelning(String avdelning) {
		this.avdelning = avdelning;
		return this;
	}

	public String getPostadress() {
		return postadress;
	}

	public void setPostadress(String postadress) {
		this.postadress = postadress;
	}

	public KundEntity withPostadress(String postadress) {
		this.postadress = postadress;
		return this;
	}

	public String getPostadress2() {
		return postadress2;
	}

	public void setPostadress2(String postadress2) {
		this.postadress2 = postadress2;
	}

	public KundEntity withPostadress2(String postadress2) {
		this.postadress2 = postadress2;
		return this;
	}

	public String getPostnummer() {
		return postnummer;
	}

	public void setPostnummer(String postnummer) {
		this.postnummer = postnummer;
	}

	public KundEntity withPostnummer(String postnummer) {
		this.postnummer = postnummer;
		return this;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public KundEntity withOrt(String ort) {
		this.ort = ort;
		return this;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public KundEntity withLand(String land) {
		this.land = land;
		return this;
	}

	public String getTelefonMobil() {
		return telefonMobil;
	}

	public void setTelefonMobil(String telefonMobil) {
		this.telefonMobil = telefonMobil;
	}

	public KundEntity withTelefonMobil(String telefonMobil) {
		this.telefonMobil = telefonMobil;
		return this;
	}

	public String getTelefonHem() {
		return telefonHem;
	}

	public void setTelefonHem(String telefonHem) {
		this.telefonHem = telefonHem;
	}

	public KundEntity withTelefonHem(String telefonHem) {
		this.telefonHem = telefonHem;
		return this;
	}

	public String getTelefonArbete() {
		return telefonArbete;
	}

	public void setTelefonArbete(String telefonArbete) {
		this.telefonArbete = telefonArbete;
	}

	public KundEntity withTelefonArbete(String telefonArbete) {
		this.telefonArbete = telefonArbete;
		return this;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public KundEntity withEpost(String epost) {
		this.epost = epost;
		return this;
	}

	public String getForedragetKontaktsatt() {
		return foredragetKontaktsatt;
	}

	public void setForedragetKontaktsatt(String foredragetKontaktsatt) {
		this.foredragetKontaktsatt = foredragetKontaktsatt;
	}

	public KundEntity withForedragetKontaktsatt(String foredragetKontaktsatt) {
		this.foredragetKontaktsatt = foredragetKontaktsatt;
		return this;
	}

	public String getSvefaktura() {
		return svefaktura;
	}

	public void setSvefaktura(String svefaktura) {
		this.svefaktura = svefaktura;
	}

	public KundEntity withSvefaktura(String svefaktura) {
		this.svefaktura = svefaktura;
		return this;
	}

	public String getEfakturaadress() {
		return efakturaadress;
	}

	public void setEfakturaadress(String efakturaadress) {
		this.efakturaadress = efakturaadress;
	}

	public KundEntity withEfakturaadress(String efakturaadress) {
		this.efakturaadress = efakturaadress;
		return this;
	}

	public String getForvaltartyp() {
		return forvaltartyp;
	}

	public void setForvaltartyp(String forvaltartyp) {
		this.forvaltartyp = forvaltartyp;
	}

	public KundEntity withForvaltartyp(String forvaltartyp) {
		this.forvaltartyp = forvaltartyp;
		return this;
	}

	public String getGodManForvaltare() {
		return godManForvaltare;
	}

	public void setGodManForvaltare(String godManForvaltare) {
		this.godManForvaltare = godManForvaltare;
	}

	public KundEntity withGodManForvaltare(String godManForvaltare) {
		this.godManForvaltare = godManForvaltare;
		return this;
	}

	public String getAktiv() {
		return aktiv;
	}

	public void setAktiv(String aktiv) {
		this.aktiv = aktiv;
	}

	public KundEntity withAktiv(String aktiv) {
		this.aktiv = aktiv;
		return this;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public KundEntity withId1(String id1) {
		this.id1 = id1;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		KundEntity that = (KundEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(personOrgNr, that.personOrgNr) && Objects.equals(kontaktid, that.kontaktid) && Objects.equals(kategori, that.kategori) && Objects.equals(namn,
			that.namn) && Objects.equals(fornamn, that.fornamn) && Objects.equals(efternamn, that.efternamn) && Objects.equals(avdelning, that.avdelning) && Objects.equals(postadress, that.postadress)
			&& Objects.equals(postadress2, that.postadress2) && Objects.equals(postnummer, that.postnummer) && Objects.equals(ort, that.ort) && Objects.equals(land, that.land) && Objects.equals(telefonMobil,
				that.telefonMobil) && Objects.equals(telefonHem, that.telefonHem) && Objects.equals(telefonArbete, that.telefonArbete) && Objects.equals(epost, that.epost) && Objects.equals(foredragetKontaktsatt,
					that.foredragetKontaktsatt) && Objects.equals(svefaktura, that.svefaktura) && Objects.equals(efakturaadress, that.efakturaadress) && Objects.equals(forvaltartyp, that.forvaltartyp) && Objects.equals(
						godManForvaltare, that.godManForvaltare) && Objects.equals(aktiv, that.aktiv) && Objects.equals(id1, that.id1);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, personOrgNr, kontaktid, kategori, namn, fornamn, efternamn, avdelning, postadress, postadress2, postnummer, ort, land, telefonMobil, telefonHem, telefonArbete, epost, foredragetKontaktsatt, svefaktura, efakturaadress,
			forvaltartyp, godManForvaltare, aktiv, id1);
	}

	@Override
	public String toString() {
		return "KundEntity{" +
			"id=" + id +
			", personOrgNr='" + personOrgNr + '\'' +
			", kontaktid='" + kontaktid + '\'' +
			", kategori='" + kategori + '\'' +
			", namn='" + namn + '\'' +
			", fornamn='" + fornamn + '\'' +
			", efternamn='" + efternamn + '\'' +
			", avdelning='" + avdelning + '\'' +
			", postadress='" + postadress + '\'' +
			", postadress2='" + postadress2 + '\'' +
			", postnummer='" + postnummer + '\'' +
			", ort='" + ort + '\'' +
			", land='" + land + '\'' +
			", telefonMobil='" + telefonMobil + '\'' +
			", telefonHem='" + telefonHem + '\'' +
			", telefonArbete='" + telefonArbete + '\'' +
			", epost='" + epost + '\'' +
			", foredragetKontaktsatt='" + foredragetKontaktsatt + '\'' +
			", svefaktura='" + svefaktura + '\'' +
			", efakturaadress='" + efakturaadress + '\'' +
			", forvaltartyp='" + forvaltartyp + '\'' +
			", godManForvaltare='" + godManForvaltare + '\'' +
			", aktiv='" + aktiv + '\'' +
			", id1='" + id1 + '\'' +
			'}';
	}
}
