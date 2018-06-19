package com.example.theo.dlcapp.model;

public class Utilisateur {
    Plafonnier plafonnier;
    Luminaire luminaire;

    public Utilisateur() {
        this.plafonnier = new Plafonnier();
        this.luminaire = new Luminaire();
    }

    public Plafonnier getPlafonnier() {
        return plafonnier;
    }

    public Luminaire getLuminaire() {
        return luminaire;
    }

    public void setPlafonnier(Plafonnier plafonnier) {
        this.plafonnier = plafonnier;
    }

    public void setLuminaire(Luminaire luminaire) {
        this.luminaire = luminaire;
    }
}
