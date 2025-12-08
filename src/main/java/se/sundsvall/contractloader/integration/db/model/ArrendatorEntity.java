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
@Table(name = "arrende_arrendator", schema = "contract_staging")
public class ArrendatorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id", nullable = false)
	private Long id;

	@Size(max = 255)
	@Column(name = "arrendekontrakt")
	private String arrendekontrakt;

	@Size(max = 255)
	@Column(name = "kontaktid")
	private String kontaktid;

	@Size(max = 255)
	@Column(name = "person_org_nr")
	private String personOrgNr;

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
	@Column(name = "kontraktsrelation")
	private String kontraktsrelation;

	@Column(name = "relaterad_fr_o_m_datum")
	private OffsetDateTime relateradFromDatum;

	@Column(name = "relaterad_t_o_m_datum")
	private OffsetDateTime relateradTomDatum;

	@Size(max = 255)
	@Column(name = "ordning")
	private String ordning;

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
	@Column(name = "betalarnummer_kontakt")
	private String betalarnummerKontakt;

	@Size(max = 255)
	@Column(name = "betalarnummerlangd_kontakt")
	private String betalarnummerlangdKontakt;

	@Size(max = 255)
	@Column(name = "clearingnummer_kontakt")
	private String clearingnummerKontakt;

	@Size(max = 255)
	@Column(name = "konto_kontakt")
	private String kontoKontakt;

	@Size(max = 255)
	@Column(name = "efakturaadress")
	private String efakturaadress;

	@Size(max = 255)
	@Column(name = "id")
	private String id1;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "kontaktid", referencedColumnName = "kontaktid")
	private List<KundEntity> kundEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static ArrendatorEntity create() {
		return new ArrendatorEntity();
	}

	public ArrendatorEntity withId(Long id) {
		this.id = id;
		return this;
	}

	public String getArrendekontrakt() {
		return arrendekontrakt;
	}

	public void setArrendekontrakt(String arrendekontrakt) {
		this.arrendekontrakt = arrendekontrakt;
	}

	public ArrendatorEntity withArrendekontrakt(String arrendekontrakt) {
		this.arrendekontrakt = arrendekontrakt;
		return this;
	}

	public String getKontaktid() {
		return kontaktid;
	}

	public void setKontaktid(String kontaktid) {
		this.kontaktid = kontaktid;
	}

	public ArrendatorEntity withKontaktid(String kontaktid) {
		this.kontaktid = kontaktid;
		return this;
	}

	public String getPersonOrgNr() {
		return personOrgNr;
	}

	public void setPersonOrgNr(String personOrgNr) {
		this.personOrgNr = personOrgNr;
	}

	public ArrendatorEntity withPersonOrgNr(String personOrgNr) {
		this.personOrgNr = personOrgNr;
		return this;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public ArrendatorEntity withKategori(String kategori) {
		this.kategori = kategori;
		return this;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public ArrendatorEntity withNamn(String namn) {
		this.namn = namn;
		return this;
	}

	public String getFornamn() {
		return fornamn;
	}

	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}

	public ArrendatorEntity withFornamn(String fornamn) {
		this.fornamn = fornamn;
		return this;
	}

	public String getEfternamn() {
		return efternamn;
	}

	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}

	public ArrendatorEntity withEfternamn(String efternamn) {
		this.efternamn = efternamn;
		return this;
	}

	public String getAvdelning() {
		return avdelning;
	}

	public void setAvdelning(String avdelning) {
		this.avdelning = avdelning;
	}

	public ArrendatorEntity withAvdelning(String avdelning) {
		this.avdelning = avdelning;
		return this;
	}

	public String getKontraktsrelation() {
		return kontraktsrelation;
	}

	public void setKontraktsrelation(String kontraktsrelation) {
		this.kontraktsrelation = kontraktsrelation;
	}

	public ArrendatorEntity withKontraktsrelation(String kontraktsrelation) {
		this.kontraktsrelation = kontraktsrelation;
		return this;
	}

	public OffsetDateTime getRelateradFromDatum() {
		return relateradFromDatum;
	}

	public void setRelateradFromDatum(OffsetDateTime relateradFromDatum) {
		this.relateradFromDatum = relateradFromDatum;
	}

	public ArrendatorEntity withRelateradFromDatum(OffsetDateTime relateradFromDatum) {
		this.relateradFromDatum = relateradFromDatum;
		return this;
	}

	public OffsetDateTime getRelateradTomDatum() {
		return relateradTomDatum;
	}

	public void setRelateradTomDatum(OffsetDateTime relateradTomDatum) {
		this.relateradTomDatum = relateradTomDatum;
	}

	public ArrendatorEntity withRelateradTomDatum(OffsetDateTime relateradTomDatum) {
		this.relateradTomDatum = relateradTomDatum;
		return this;
	}

	public String getOrdning() {
		return ordning;
	}

	public void setOrdning(String ordning) {
		this.ordning = ordning;
	}

	public ArrendatorEntity withOrdning(String ordning) {
		this.ordning = ordning;
		return this;
	}

	public String getPostadress() {
		return postadress;
	}

	public void setPostadress(String postadress) {
		this.postadress = postadress;
	}

	public ArrendatorEntity withPostadress(String postadress) {
		this.postadress = postadress;
		return this;
	}

	public String getPostadress2() {
		return postadress2;
	}

	public void setPostadress2(String postadress2) {
		this.postadress2 = postadress2;
	}

	public ArrendatorEntity withPostadress2(String postadress2) {
		this.postadress2 = postadress2;
		return this;
	}

	public String getPostnummer() {
		return postnummer;
	}

	public void setPostnummer(String postnummer) {
		this.postnummer = postnummer;
	}

	public ArrendatorEntity withPostnummer(String postnummer) {
		this.postnummer = postnummer;
		return this;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public ArrendatorEntity withOrt(String ort) {
		this.ort = ort;
		return this;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public ArrendatorEntity withLand(String land) {
		this.land = land;
		return this;
	}

	public String getTelefonMobil() {
		return telefonMobil;
	}

	public void setTelefonMobil(String telefonMobil) {
		this.telefonMobil = telefonMobil;
	}

	public ArrendatorEntity withTelefonMobil(String telefonMobil) {
		this.telefonMobil = telefonMobil;
		return this;
	}

	public String getTelefonHem() {
		return telefonHem;
	}

	public void setTelefonHem(String telefonHem) {
		this.telefonHem = telefonHem;
	}

	public ArrendatorEntity withTelefonHem(String telefonHem) {
		this.telefonHem = telefonHem;
		return this;
	}

	public String getTelefonArbete() {
		return telefonArbete;
	}

	public void setTelefonArbete(String telefonArbete) {
		this.telefonArbete = telefonArbete;
	}

	public ArrendatorEntity withTelefonArbete(String telefonArbete) {
		this.telefonArbete = telefonArbete;
		return this;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public ArrendatorEntity withEpost(String epost) {
		this.epost = epost;
		return this;
	}

	public String getForedragetKontaktsatt() {
		return foredragetKontaktsatt;
	}

	public void setForedragetKontaktsatt(String foredragetKontaktsatt) {
		this.foredragetKontaktsatt = foredragetKontaktsatt;
	}

	public ArrendatorEntity withForedragetKontaktsatt(String foredragetKontaktsatt) {
		this.foredragetKontaktsatt = foredragetKontaktsatt;
		return this;
	}

	public String getSvefaktura() {
		return svefaktura;
	}

	public void setSvefaktura(String svefaktura) {
		this.svefaktura = svefaktura;
	}

	public ArrendatorEntity withSvefaktura(String svefaktura) {
		this.svefaktura = svefaktura;
		return this;
	}

	public String getBetalarnummerKontakt() {
		return betalarnummerKontakt;
	}

	public void setBetalarnummerKontakt(String betalarnummerKontakt) {
		this.betalarnummerKontakt = betalarnummerKontakt;
	}

	public ArrendatorEntity withBetalarnummerKontakt(String betalarnummerKontakt) {
		this.betalarnummerKontakt = betalarnummerKontakt;
		return this;
	}

	public String getBetalarnummerlangdKontakt() {
		return betalarnummerlangdKontakt;
	}

	public void setBetalarnummerlangdKontakt(String betalarnummerlangdKontakt) {
		this.betalarnummerlangdKontakt = betalarnummerlangdKontakt;
	}

	public ArrendatorEntity withBetalarnummerlangdKontakt(String betalarnummerlangdKontakt) {
		this.betalarnummerlangdKontakt = betalarnummerlangdKontakt;
		return this;
	}

	public String getClearingnummerKontakt() {
		return clearingnummerKontakt;
	}

	public void setClearingnummerKontakt(String clearingnummerKontakt) {
		this.clearingnummerKontakt = clearingnummerKontakt;
	}

	public ArrendatorEntity withClearingnummerKontakt(String clearingnummerKontakt) {
		this.clearingnummerKontakt = clearingnummerKontakt;
		return this;
	}

	public String getKontoKontakt() {
		return kontoKontakt;
	}

	public void setKontoKontakt(String kontoKontakt) {
		this.kontoKontakt = kontoKontakt;
	}

	public ArrendatorEntity withKontoKontakt(String kontoKontakt) {
		this.kontoKontakt = kontoKontakt;
		return this;
	}

	public String getEfakturaadress() {
		return efakturaadress;
	}

	public void setEfakturaadress(String efakturaadress) {
		this.efakturaadress = efakturaadress;
	}

	public ArrendatorEntity withEfakturaadress(String efakturaadress) {
		this.efakturaadress = efakturaadress;
		return this;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public ArrendatorEntity withId1(String id1) {
		this.id1 = id1;
		return this;
	}

	public List<KundEntity> getKundEntities() {
		return kundEntities;
	}

	public void setKundEntities(List<KundEntity> kundEntities) {
		this.kundEntities = kundEntities;
	}

	public ArrendatorEntity withKundEntities(List<KundEntity> kundEntities) {
		this.kundEntities = kundEntities;
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		ArrendatorEntity that = (ArrendatorEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(arrendekontrakt, that.arrendekontrakt) && Objects.equals(kontaktid, that.kontaktid) && Objects.equals(personOrgNr, that.personOrgNr)
			&& Objects.equals(kategori, that.kategori) && Objects.equals(namn, that.namn) && Objects.equals(fornamn, that.fornamn) && Objects.equals(efternamn, that.efternamn) && Objects.equals(avdelning,
				that.avdelning) && Objects.equals(kontraktsrelation, that.kontraktsrelation) && Objects.equals(relateradFromDatum, that.relateradFromDatum) && Objects.equals(relateradTomDatum, that.relateradTomDatum)
			&& Objects.equals(ordning, that.ordning) && Objects.equals(postadress, that.postadress) && Objects.equals(postadress2, that.postadress2) && Objects.equals(postnummer, that.postnummer)
			&& Objects.equals(ort, that.ort) && Objects.equals(land, that.land) && Objects.equals(telefonMobil, that.telefonMobil) && Objects.equals(telefonHem, that.telefonHem) && Objects.equals(telefonArbete,
				that.telefonArbete) && Objects.equals(epost, that.epost) && Objects.equals(foredragetKontaktsatt, that.foredragetKontaktsatt) && Objects.equals(svefaktura, that.svefaktura) && Objects.equals(
					betalarnummerKontakt, that.betalarnummerKontakt) && Objects.equals(betalarnummerlangdKontakt, that.betalarnummerlangdKontakt) && Objects.equals(clearingnummerKontakt, that.clearingnummerKontakt) && Objects.equals(
						kontoKontakt, that.kontoKontakt) && Objects.equals(efakturaadress, that.efakturaadress) && Objects.equals(id1, that.id1) && Objects.equals(kundEntities, that.kundEntities);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, arrendekontrakt, kontaktid, personOrgNr, kategori, namn, fornamn, efternamn, avdelning, kontraktsrelation, relateradFromDatum, relateradTomDatum, ordning, postadress, postadress2, postnummer, ort, land, telefonMobil,
			telefonHem, telefonArbete, epost, foredragetKontaktsatt, svefaktura, betalarnummerKontakt, betalarnummerlangdKontakt, clearingnummerKontakt, kontoKontakt, efakturaadress, id1, kundEntities);
	}

	@Override
	public String toString() {
		return "ArrendatorEntity{" +
			"id=" + id +
			", arrendekontrakt='" + arrendekontrakt + '\'' +
			", kontaktid='" + kontaktid + '\'' +
			", personOrgNr='" + personOrgNr + '\'' +
			", kategori='" + kategori + '\'' +
			", namn='" + namn + '\'' +
			", fornamn='" + fornamn + '\'' +
			", efternamn='" + efternamn + '\'' +
			", avdelning='" + avdelning + '\'' +
			", kontraktsrelation='" + kontraktsrelation + '\'' +
			", relateradFromDatum=" + relateradFromDatum +
			", relateradTomDatum=" + relateradTomDatum +
			", ordning='" + ordning + '\'' +
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
			", betalarnummerKontakt='" + betalarnummerKontakt + '\'' +
			", betalarnummerlangdKontakt='" + betalarnummerlangdKontakt + '\'' +
			", clearingnummerKontakt='" + clearingnummerKontakt + '\'' +
			", kontoKontakt='" + kontoKontakt + '\'' +
			", efakturaadress='" + efakturaadress + '\'' +
			", id1='" + id1 + '\'' +
			", kundEntities=" + kundEntities +
			'}';
	}
}
