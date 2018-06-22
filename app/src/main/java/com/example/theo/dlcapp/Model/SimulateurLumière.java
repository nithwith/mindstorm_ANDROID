package com.example.theo.dlcapp.Model;

public class SimulateurLumière {
    private int id;
    private String nom;
    private Boolean is_on;
    private int intensity;

    public SimulateurLumière(int id, Boolean is_on, int intensity, String nom) {
        this.id = id;
        this.is_on = is_on;
        this.intensity = intensity;
        this.nom = nom;
    }

    public void inverser(){
        if(this.is_on.equals(Boolean.TRUE)){
            this.is_on = Boolean.FALSE;
        }
        else {
            this.is_on =Boolean.TRUE;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getIs_on() {
        return is_on;
    }

    public void setIs_on(Boolean is_on) {
        this.is_on = is_on;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
