package com.example.theo.dlcapp.model;

import java.util.ArrayList;

public class Utilisateur {
    Configuration configuration;

    public Utilisateur(Configuration configuration) {
        this.configuration = configuration;
    }

    public Utilisateur() {

        //Constructeur de l'utilisateur de demo

        SimulateurLumière lum1 = new SimulateurLumière(1,Boolean.FALSE,0);
        SimulateurLumière lum2 = new SimulateurLumière(1,Boolean.FALSE,50);
        ArrayList<SimulateurLumière> list_lumiere = new ArrayList<>();
        list_lumiere.add(lum1);
        list_lumiere.add(lum2);
        this.configuration = new Configuration(1,"test",0,0,0,"yes",list_lumiere);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
