package com.example.theo.dlcapp;


import android.os.Bundle;
import android.os.UserManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.theo.dlcapp.model.*;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get Connector
        final Connector BTconnector = MainActivity.BTconnector;


        //Activity

        SeekBar intensity_bar = (SeekBar) findViewById(R.id.intensity);
        final TextView intensityValue = (TextView)findViewById(R.id.intensityValue);
        final Switch interrupteur1 = (Switch) findViewById(R.id.interrupteur1);
        final Switch interrupteur2 = (Switch) findViewById(R.id.interrupteur2);

        intensity_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                intensityValue.setText(String.valueOf(progress));

                Utilisateur utilisateur = MainActivity.utilisateur;

                Configuration config = utilisateur.getConfiguration();
                ArrayList<SimulateurLumière> list_lumiere = config.getList_lumiere();
                SimulateurLumière lum2 = list_lumiere.get(1);
                lum2.setIntensity(progress);
                list_lumiere.set(1,lum2);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        interrupteur1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Utilisateur utilisateur = MainActivity.utilisateur;

                if (isChecked) {
                    Configuration config = utilisateur.getConfiguration();
                    ArrayList<SimulateurLumière> list_lumiere = config.getList_lumiere();
                    SimulateurLumière lum1 = list_lumiere.get(0);
                    lum1.setIs_on(Boolean.TRUE);
                    list_lumiere.set(0,lum1);
                } else {
                    Configuration config = utilisateur.getConfiguration();
                    ArrayList<SimulateurLumière> list_lumiere = config.getList_lumiere();
                    SimulateurLumière lum1 = list_lumiere.get(0);
                    lum1.setIs_on(Boolean.FALSE);
                    list_lumiere.set(0,lum1);
                }
            }
        });

        interrupteur2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Utilisateur utilisateur = MainActivity.utilisateur;

                if (isChecked) {
                    Configuration config = utilisateur.getConfiguration();
                    ArrayList<SimulateurLumière> list_lumiere = config.getList_lumiere();
                    SimulateurLumière lum2 = list_lumiere.get(1);
                    lum2.setIs_on(Boolean.TRUE);
                    list_lumiere.set(1,lum2);
                } else {
                    Configuration config = utilisateur.getConfiguration();
                    ArrayList<SimulateurLumière> list_lumiere = config.getList_lumiere();
                    SimulateurLumière lum2 = list_lumiere.get(1);
                    lum2.setIs_on(Boolean.FALSE);
                    list_lumiere.set(1,lum2);
                }
            }
        });

    }



}
