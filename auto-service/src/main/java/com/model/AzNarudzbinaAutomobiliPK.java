package com.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the azNarudzbinaAutomobili database table.
 * 
 */
@Embeddable
public class AzNarudzbinaAutomobiliPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="narudzba_id", insertable=false, updatable=false)
	private int narudzbaId;

	@Column(name="automobil_id", insertable=false, updatable=false)
	private int automobilId;

	public AzNarudzbinaAutomobiliPK() {
	}
	public int getNarudzbaId() {
		return this.narudzbaId;
	}
	public void setNarudzbaId(int narudzbaId) {
		this.narudzbaId = narudzbaId;
	}
	public int getAutomobilId() {
		return this.automobilId;
	}
	public void setAutomobilId(int automobilId) {
		this.automobilId = automobilId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AzNarudzbinaAutomobiliPK)) {
			return false;
		}
		AzNarudzbinaAutomobiliPK castOther = (AzNarudzbinaAutomobiliPK)other;
		return 
			(this.narudzbaId == castOther.narudzbaId)
			&& (this.automobilId == castOther.automobilId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.narudzbaId;
		hash = hash * prime + this.automobilId;
		
		return hash;
	}
}