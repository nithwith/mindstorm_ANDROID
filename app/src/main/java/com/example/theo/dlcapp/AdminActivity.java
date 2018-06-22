package com.example.theo.dlcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.theo.dlcapp.Model.*;
import com.example.theo.dlcapp.Adaptateur.*;

import java.util.ArrayList;
import java.util.List;


public class AdminActivity extends AppCompatActivity {

    private ListView list;
    private String[] configs = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    //model

    Admin admin = new Admin();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);



        //activity

        list = (ListView) findViewById(R.id.list);

        List<Configuration> configs = admin.getConfigs();
        List<String> names = new ArrayList<String>();
        for(int i=0; i<configs.size();i++) {
            names.add(configs.get(i).getNom());
        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }

    private void displayListConfig(){

    }


}
