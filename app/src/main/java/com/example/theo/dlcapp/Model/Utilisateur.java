package com.example.theo.dlcapp.Model;

import com.example.theo.dlcapp.MainActivity;

public class Utilisateur {
    Configuration configuration;

    public Utilisateur(Configuration configuration) {
        this.configuration = configuration;
    }

    public Utilisateur() {

        //Constructeur de l'utilisateur de demo

        this.configuration = MainActivity.configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
