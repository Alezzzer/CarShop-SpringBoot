package com.dto;



public class AutomobilDTO {
    private int automobilId;
    private int cena;
    private int godinaProizvodnje;
    private String marka;
    private String model;
    private int kilometraza;

    public AutomobilDTO(int automobilId, int cena, int godinaProizvodnje, String marka, String model,int kilometraza) {
        this.automobilId = automobilId;
        this.cena = cena;
        this.godinaProizvodnje = godinaProizvodnje;
        this.marka = marka;
        this.model = model;
        this.setKilometraza(kilometraza);
    }

    
    public int getAutomobilId() {
        return automobilId;
    }

    public void setAutomobilId(int automobilId) {
        this.automobilId = automobilId;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

	public int getKilometraza() {
		return kilometraza;
	}

	public void setKilometraza(int kilometraza) {
		this.kilometraza = kilometraza;
	}
}
