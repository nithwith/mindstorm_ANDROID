package com.example.theo.dlcapp.model;

import java.util.ArrayList;

public class Admin {
    private ArrayList<Configuration> configs;
    private Configuration config;
    private String password;

    public Admin() {
        this.configs = new ArrayList<>();
        this.password ="admin";
    }




    public ArrayList<Configuration> getConfigs() {
        return configs;
    }

    public void setConfigs(ArrayList<Configuration> configs) {
        this.configs = configs;
    }

    public Configuration getConfig() {
        return config;
    }

    public void setConfig(Configuration config) {
        this.config = config;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
