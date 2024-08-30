package com.model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the azNarudzbina database table.
 * 
 */
@Table(name = "azNarudzbina")
@Entity
@NamedQuery(name="AzNarudzbina.findAll", query="SELECT a FROM AzNarudzbina a")
public class AzNarudzbina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="narudzba_id")
	private int narudzbaId;

	@Temporal(TemporalType.DATE)
	@Column(name="datum_narudzbe")
	private Date datumNarudzbe;

	private String status;

	@Column(name="ukupna_cena")
	private int ukupnaCena;
	@JsonIgnore

	//bi-directional many-to-one association to AzKorisnici
	@ManyToOne
	@JoinColumn(name="korisnik_id")
	private AzKorisnici azKorisnici;
	@JsonIgnore

	//bi-directional many-to-one association to AzNarudzbinaAutomobili
	@OneToMany(mappedBy="azNarudzbina")
	private List<AzNarudzbinaAutomobili> azNarudzbinaAutomobilis;
	@JsonIgnore

	//bi-directional many-to-one association to AzPlacanja
	@OneToMany(mappedBy="azNarudzbina")
	private List<AzPlacanja> azPlacanjas;

	public AzNarudzbina() {
	}

	public int getNarudzbaId() {
		return this.narudzbaId;
	}

	public void setNarudzbaId(int narudzbaId) {
		this.narudzbaId = narudzbaId;
	}

	public Date getDatumNarudzbe() {
		return this.datumNarudzbe;
	}

	public void setDatumNarudzbe(Date datumNarudzbe) {
		this.datumNarudzbe = datumNarudzbe;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUkupnaCena() {
		return this.ukupnaCena;
	}

	public void setUkupnaCena(int ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public AzKorisnici getAzKorisnici() {
		return this.azKorisnici;
	}

	public void setAzKorisnici(AzKorisnici azKorisnici) {
		this.azKorisnici = azKorisnici;
	}

	public List<AzNarudzbinaAutomobili> getAzNarudzbinaAutomobilis() {
		return this.azNarudzbinaAutomobilis;
	}

	public void setAzNarudzbinaAutomobilis(List<AzNarudzbinaAutomobili> azNarudzbinaAutomobilis) {
		this.azNarudzbinaAutomobilis = azNarudzbinaAutomobilis;
	}

	public AzNarudzbinaAutomobili addAzNarudzbinaAutomobili(AzNarudzbinaAutomobili azNarudzbinaAutomobili) {
		getAzNarudzbinaAutomobilis().add(azNarudzbinaAutomobili);
		azNarudzbinaAutomobili.setAzNarudzbina(this);

		return azNarudzbinaAutomobili;
	}

	public AzNarudzbinaAutomobili removeAzNarudzbinaAutomobili(AzNarudzbinaAutomobili azNarudzbinaAutomobili) {
		getAzNarudzbinaAutomobilis().remove(azNarudzbinaAutomobili);
		azNarudzbinaAutomobili.setAzNarudzbina(null);

		return azNarudzbinaAutomobili;
	}

	public List<AzPlacanja> getAzPlacanjas() {
		return this.azPlacanjas;
	}

	public void setAzPlacanjas(List<AzPlacanja> azPlacanjas) {
		this.azPlacanjas = azPlacanjas;
	}

	public AzPlacanja addAzPlacanja(AzPlacanja azPlacanja) {
		getAzPlacanjas().add(azPlacanja);
		azPlacanja.setAzNarudzbina(this);

		return azPlacanja;
	}

	public AzPlacanja removeAzPlacanja(AzPlacanja azPlacanja) {
		getAzPlacanjas().remove(azPlacanja);
		azPlacanja.setAzNarudzbina(null);

		return azPlacanja;
	}

}