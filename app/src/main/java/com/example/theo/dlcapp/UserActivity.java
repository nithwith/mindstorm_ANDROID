package com.example.theo.dlcapp;


import android.os.Bundle;
import android.os.UserManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.theo.dlcapp.model.*;

public class UserActivity extends AppCompatActivity {

    Utilisateur utilisateur = new Utilisateur();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Model


        //Activity

        SeekBar intensity_bar = (SeekBar) findViewById(R.id.intensity);
        final TextView intensityValue = (TextView)findViewById(R.id.intensityValue);
        Switch interrupteur1 = (Switch) findViewById(R.id.interrupteur1);
        Switch interrupteur2 = (Switch) findViewById(R.id.interrupteur2);

        intensity_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                intensityValue.setText(String.valueOf(progress));
                Plafonnier plafonnier = utilisateur.getPlafonnier();
                plafonnier.setIntensity(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



        interrupteur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Model", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Luminaire luminaire = utilisateur.getLuminaire();

                if (luminaire.isIs_on()){
                    luminaire.setIs_on(false);
                }
                else{
                    luminaire.setIs_on(true);
                }
            }
        });

        interrupteur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Model", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Plafonnier plafonnier = utilisateur.getPlafonnier();

                if (plafonnier.isIs_on()){
                    plafonnier.setIs_on(false);
                }
                else{
                    plafonnier.setIs_on(true);
                }

            }
        });
    }



}
