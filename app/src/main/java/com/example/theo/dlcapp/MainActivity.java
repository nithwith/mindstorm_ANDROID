package com.example.theo.dlcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.app.Application;

import com.example.theo.dlcapp.model.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {



    public static Utilisateur utilisateur = new Utilisateur();
    public static Admin admin;
    public static Connector BTconnector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Connector

        BTconnector = new Connector();



        Button button_connexion = (Button) findViewById(R.id.connexion);
        Button button_connexion_admin = (Button) findViewById(R.id.connexion_admin);
        final TextView password_error = (TextView) findViewById(R.id.password_error);
        final EditText passField = (EditText)findViewById(R.id.password);


        button_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //connect to nxt
                BTconnector.connectToNXT();

                //BTConnector.readMessage(test);

                //BTconnector.write("Hola");

                //navigate to other activity
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });



        button_connexion_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //connect to nxt
//                Connector connector = new Connector();
//                connector.connectToNXT();
//                connector.write(passField.getText().toString());

                String password = passField.getText().toString();

                if(password == "admin"){
                    //navigate to admin activity
                    Intent intent_admin = new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(intent_admin);
                }
                else {
                    password_error.setText("Erreur, veuillez ressaisir votre mot de passe");
                    password_error.setText(password);
                }



            }
        });
    }
}
