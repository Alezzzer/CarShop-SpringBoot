package com.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 * The persistent class for the azTipAutomobila database table.
 * 
 */
@Entity
@NamedQuery(name="AzTipAutomobila.findAll", query="SELECT a FROM AzTipAutomobila a")
public class AzTipAutomobila implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tip_id")
	private int tipId;

	@Column(name="naziv_tipa")
	private String nazivTipa;

	//bi-directional many-to-one association to AzAutomobili
	@OneToMany(mappedBy="azTipAutomobila")
	private List<AzAutomobili> azAutomobilis;

	public AzTipAutomobila() {
	}

	public int getTipId() {
		return this.tipId;
	}

	public void setTipId(int tipId) {
		this.tipId = tipId;
	}

	public String getNazivTipa() {
		return this.nazivTipa;
	}

	public void setNazivTipa(String nazivTipa) {
		this.nazivTipa = nazivTipa;
	}

	public List<AzAutomobili> getAzAutomobilis() {
		return this.azAutomobilis;
	}

	public void setAzAutomobilis(List<AzAutomobili> azAutomobilis) {
		this.azAutomobilis = azAutomobilis;
	}

	public AzAutomobili addAzAutomobili(AzAutomobili azAutomobili) {
		getAzAutomobilis().add(azAutomobili);
		azAutomobili.setAzTipAutomobila(this);

		return azAutomobili;
	}

	public AzAutomobili removeAzAutomobili(AzAutomobili azAutomobili) {
		getAzAutomobilis().remove(azAutomobili);
		azAutomobili.setAzTipAutomobila(null);

		return azAutomobili;
	}

}