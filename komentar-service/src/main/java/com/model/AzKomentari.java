package com.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * The persistent class for the AzKomentari database table.
 * 
 */
@Entity
@NamedQuery(name="AzKomentari.findAll", query="SELECT a FROM AzKomentari a")
public class AzKomentari implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="komentar_id")
	private int komentarId;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String tekst;

	//bi-directional many-to-one association to AzKorisnici
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	private AzKorisnici azKorisnici;

	//bi-directional many-to-one association to AzTema
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="tema_id")
	private AzTema azTema;

	public AzKomentari() {
	}

	public int getKomentarId() {
		return this.komentarId;
	}

	public void setKomentarId(int komentarId) {
		this.komentarId = komentarId;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public AzKorisnici getAzKorisnici() {
		return this.azKorisnici;
	}

	public void setAzKorisnici(AzKorisnici azKorisnici) {
		this.azKorisnici = azKorisnici;
	}

	public AzTema getAzTema() {
		return this.azTema;
	}

	public void setAzTema(AzTema azTema) {
		this.azTema = azTema;
	}

}