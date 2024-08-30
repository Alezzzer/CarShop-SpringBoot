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


/**
 * The persistent class for the AzTema database table.
 * 
 */
@Entity
@NamedQuery(name="AzTema.findAll", query="SELECT a FROM AzTema a")
public class AzTema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tema_id")
	private int temaId;

	private String naslov;

	//bi-directional many-to-one association to AzKomentari
	@JsonIgnore
	@OneToMany(mappedBy="azTema")
	private List<AzKomentari> azKomentaris;

	public AzTema() {
	}

	public int getTemaId() {
		return this.temaId;
	}

	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public List<AzKomentari> getAzKomentaris() {
		return this.azKomentaris;
	}

	public void setAzKomentaris(List<AzKomentari> azKomentaris) {
		this.azKomentaris = azKomentaris;
	}

	public AzKomentari addAzKomentari(AzKomentari azKomentari) {
		getAzKomentaris().add(azKomentari);
		azKomentari.setAzTema(this);

		return azKomentari;
	}

	public AzKomentari removeAzKomentari(AzKomentari azKomentari) {
		getAzKomentaris().remove(azKomentari);
		azKomentari.setAzTema(null);

		return azKomentari;
	}

}