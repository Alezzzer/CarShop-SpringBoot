package com.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the azPlacanja database table.
 * 
 */
@Entity
@NamedQuery(name="AzPlacanja.findAll", query="SELECT a FROM AzPlacanja a")
public class AzPlacanja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="placanje_id")
	private int placanjeId;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_placanja")
	private Date datumPlacanja;

	private int iznos;

	@Column(name="nacin_placanja")
	private String nacinPlacanja;

	//bi-directional many-to-one association to AzNarudzbina
	@ManyToOne
	@JoinColumn(name="narudzba_id")
	private AzNarudzbina azNarudzbina;

	public AzPlacanja() {
	}

	public int getPlacanjeId() {
		return this.placanjeId;
	}

	public void setPlacanjeId(int placanjeId) {
		this.placanjeId = placanjeId;
	}

	public Date getDatumPlacanja() {
		return this.datumPlacanja;
	}

	public void setDatumPlacanja(Date datumPlacanja) {
		this.datumPlacanja = datumPlacanja;
	}

	public int getIznos() {
		return this.iznos;
	}

	public void setIznos(int iznos) {
		this.iznos = iznos;
	}

	public String getNacinPlacanja() {
		return this.nacinPlacanja;
	}

	public void setNacinPlacanja(String nacinPlacanja) {
		this.nacinPlacanja = nacinPlacanja;
	}

	public AzNarudzbina getAzNarudzbina() {
		return this.azNarudzbina;
	}

	public void setAzNarudzbina(AzNarudzbina azNarudzbina) {
		this.azNarudzbina = azNarudzbina;
	}

}