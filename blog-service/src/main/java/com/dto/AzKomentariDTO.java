package com.dto;

import java.util.Date;

public class AzKomentariDTO {

    private int komentarId;
    private Date datum;
    private String tekst;
   
    public AzKomentariDTO() {
    }

    public int getKomentarId() {
        return komentarId;
    }

    public void setKomentarId(int komentarId) {
        this.komentarId = komentarId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

}
