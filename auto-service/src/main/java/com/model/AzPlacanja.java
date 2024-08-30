package com.model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the azPlacanja database table.
 * 
 */
@Table(name = "azPlacanja")
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
	@JsonIgnore

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