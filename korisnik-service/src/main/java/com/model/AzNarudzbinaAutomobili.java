package com.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the azNarudzbinaAutomobili database table.
 * 
 */
@Entity
@NamedQuery(name="AzNarudzbinaAutomobili.findAll", query="SELECT a FROM AzNarudzbinaAutomobili a")
public class AzNarudzbinaAutomobili implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AzNarudzbinaAutomobiliPK id;

	private int kolicina;

	//bi-directional many-to-one association to AzNarudzbina
	@ManyToOne
	@JoinColumn(name="narudzba_id")
	private AzNarudzbina azNarudzbina;

	//bi-directional many-to-one association to AzAutomobili
	@ManyToOne
	@JoinColumn(name="automobil_id")
	private AzAutomobili azAutomobili;

	public AzNarudzbinaAutomobili() {
	}

	public AzNarudzbinaAutomobiliPK getId() {
		return this.id;
	}

	public void setId(AzNarudzbinaAutomobiliPK id) {
		this.id = id;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public AzNarudzbina getAzNarudzbina() {
		return this.azNarudzbina;
	}

	public void setAzNarudzbina(AzNarudzbina azNarudzbina) {
		this.azNarudzbina = azNarudzbina;
	}

	public AzAutomobili getAzAutomobili() {
		return this.azAutomobili;
	}

	public void setAzAutomobili(AzAutomobili azAutomobili) {
		this.azAutomobili = azAutomobili;
	}

}