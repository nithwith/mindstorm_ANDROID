package com.example.theo.dlcapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.theo.dlcapp.Model.*;

import javax.xml.transform.Source;

public class MainActivity extends AppCompatActivity  {


    public static SimulateurLumière lum1 = new SimulateurLumière(1,Boolean.FALSE,0,"luminaire");
    public static SimulateurLumière lum2 = new SimulateurLumière(1,Boolean.FALSE,50,"plafonnier");
    public static Configuration configuration = new Configuration();
    public static Utilisateur utilisateur = new Utilisateur();
    public static Admin admin = new Admin();
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
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


        button_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                alertDialogBuilder.setMessage("Connexion ...");
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                //connect to nxt
                BTconnector.connectToNXT();

                String test = new String();
                //BTconnector.readMessage(test);
                //System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
                //System.out.println(test);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
                BTconnector.write("Hola");




                //

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
                showDialog(0);

                String password = passField.getText().toString();

                //if(password == admin.getPassword()){
                    //navigate to admin activity
                    Intent intent_admin = new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(intent_admin);
                //}
                //else {
                  //  password_error.setText("Erreur, veuillez ressaisir votre mot de passe");
                //}



            }
        });
    }





}
