package com.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Table(name = "azNarudzbinaAutomobili")
@Entity
@NamedQuery(name="AzNarudzbinaAutomobili.findAll", query="SELECT a FROM AzNarudzbinaAutomobili a")
public class AzNarudzbinaAutomobili implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AzNarudzbinaAutomobiliPK id = new AzNarudzbinaAutomobiliPK(); // Inicijalizacija PK

    private int kolicina;

    @JsonIgnore
    @ManyToOne
    @MapsId("automobilId")
    @JoinColumn(name="automobil_id", referencedColumnName = "automobil_id") // Promeni na odgovarajući naziv
    private AzAutomobili azAutomobili;


    @JsonIgnore
    @ManyToOne
    @MapsId("narudzbaId") // Mapiranje na deo primarnog ključa
    @JoinColumn(name="narudzba_id", referencedColumnName = "narudzba_id")
    private AzNarudzbina azNarudzbina;

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

    public AzAutomobili getAzAutomobili() {
        return this.azAutomobili;
    }

    public void setAzAutomobili(AzAutomobili azAutomobili) {
        this.azAutomobili = azAutomobili;
    }

    public AzNarudzbina getAzNarudzbina() {
        return this.azNarudzbina;
    }

    public void setAzNarudzbina(AzNarudzbina azNarudzbina) {
        this.azNarudzbina = azNarudzbina;
    }
}
