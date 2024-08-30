package com.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the azKorisnici database table.
 * 
 */
@Table(name = "azKorisnici")
@Entity
@NamedQuery(name="AzKorisnici.findAll", query="SELECT a FROM AzKorisnici a")
public class AzKorisnici implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="korisnik_id")
	private int korisnikId;

	private String email;

	private String ime;

	private String lozinka;

	private String prezime;

	//bi-directional many-to-one association to AzKomentari
	@JsonIgnore
	@OneToMany(mappedBy="azKorisnici")
	private List<AzKomentari> azKomentaris;

	public AzKorisnici() {
	}

	public int getKorisnikId() {
		return this.korisnikId;
	}

	public void setKorisnikId(int korisnikId) {
		this.korisnikId = korisnikId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<AzKomentari> getAzKomentaris() {
		return this.azKomentaris;
	}

	public void setAzKomentaris(List<AzKomentari> azKomentaris) {
		this.azKomentaris = azKomentaris;
	}

	public AzKomentari addAzKomentari(AzKomentari azKomentari) {
		getAzKomentaris().add(azKomentari);
		azKomentari.setAzKorisnici(this);

		return azKomentari;
	}

	public AzKomentari removeAzKomentari(AzKomentari azKomentari) {
		getAzKomentaris().remove(azKomentari);
		azKomentari.setAzKorisnici(null);

		return azKomentari;
	}

}