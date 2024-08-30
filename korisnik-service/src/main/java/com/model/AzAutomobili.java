package com.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the azAutomobili database table.
 * 
 */
@Entity
@NamedQuery(name="AzAutomobili.findAll", query="SELECT a FROM AzAutomobili a")
public class AzAutomobili implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="automobil_id")
	private int automobilId;

	private int cena;

	@Column(name="godina_proizvodnje")
	private int godinaProizvodnje;

	private int kilometraza;

	private String marka;

	private String model;

	//bi-directional many-to-one association to AzTipAutomobila
	@ManyToOne
	@JoinColumn(name="tip_id")
	private AzTipAutomobila azTipAutomobila;

	//bi-directional many-to-one association to AzNarudzbinaAutomobili
	@OneToMany(mappedBy="azAutomobili")
	private List<AzNarudzbinaAutomobili> azNarudzbinaAutomobilis;

	public AzAutomobili() {
	}

	public int getAutomobilId() {
		return this.automobilId;
	}

	public void setAutomobilId(int automobilId) {
		this.automobilId = automobilId;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getGodinaProizvodnje() {
		return this.godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public int getKilometraza() {
		return this.kilometraza;
	}

	public void setKilometraza(int kilometraza) {
		this.kilometraza = kilometraza;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public AzTipAutomobila getAzTipAutomobila() {
		return this.azTipAutomobila;
	}

	public void setAzTipAutomobila(AzTipAutomobila azTipAutomobila) {
		this.azTipAutomobila = azTipAutomobila;
	}

	public List<AzNarudzbinaAutomobili> getAzNarudzbinaAutomobilis() {
		return this.azNarudzbinaAutomobilis;
	}

	public void setAzNarudzbinaAutomobilis(List<AzNarudzbinaAutomobili> azNarudzbinaAutomobilis) {
		this.azNarudzbinaAutomobilis = azNarudzbinaAutomobilis;
	}

	public AzNarudzbinaAutomobili addAzNarudzbinaAutomobili(AzNarudzbinaAutomobili azNarudzbinaAutomobili) {
		getAzNarudzbinaAutomobilis().add(azNarudzbinaAutomobili);
		azNarudzbinaAutomobili.setAzAutomobili(this);

		return azNarudzbinaAutomobili;
	}

	public AzNarudzbinaAutomobili removeAzNarudzbinaAutomobili(AzNarudzbinaAutomobili azNarudzbinaAutomobili) {
		getAzNarudzbinaAutomobilis().remove(azNarudzbinaAutomobili);
		azNarudzbinaAutomobili.setAzAutomobili(null);

		return azNarudzbinaAutomobili;
	}

}