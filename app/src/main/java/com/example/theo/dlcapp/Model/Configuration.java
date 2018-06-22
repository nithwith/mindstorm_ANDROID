package com.example.theo.dlcapp.Model;

import com.example.theo.dlcapp.MainActivity;

import java.util.ArrayList;

public class Configuration {
    private int id;
    private String nom;
    private int T1;
    private int T2;
    private int T3;
    private Boolean is_strandard;
    private ArrayList<SimulateurLumière> list_lumiere;

    public Configuration(int id, String nom, int t1, int t2, int t3, Boolean is_strandard, ArrayList<SimulateurLumière> list_lumiere) {
        this.id = id;
        this.nom = nom;
        T1 = t1;
        T2 = t2;
        T3 = t3;
        this.is_strandard = is_strandard;
        this.list_lumiere = list_lumiere;
    }

    public Configuration() {
        this.id = 1;
        this.nom = "Test";
        T1 = 0;
        T2 = 0;
        T3 = 0;
        this.is_strandard = Boolean.FALSE;
        ArrayList<SimulateurLumière> list_lumiere = new ArrayList<>();
        list_lumiere.add(MainActivity.lum1);
        list_lumiere.add(MainActivity.lum2);
        this.list_lumiere = list_lumiere;
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

    public int getT1() {
        return T1;
    }

    public void setT1(int t1) {
        T1 = t1;
    }

    public int getT2() {
        return T2;
    }

    public void setT2(int t2) {
        T2 = t2;
    }

    public int getT3() {
        return T3;
    }

    public void setT3(int t3) {
        T3 = t3;
    }

    public ArrayList<SimulateurLumière> getList_lumiere() {
        return list_lumiere;
    }

    public void setList_lumiere(ArrayList<SimulateurLumière> list_lumiere) {
        this.list_lumiere = list_lumiere;
    }

    public Boolean getIs_strandard() {
        return is_strandard;
    }

    public void setIs_strandard(Boolean is_strandard) {
        this.is_strandard = is_strandard;
    }
}
