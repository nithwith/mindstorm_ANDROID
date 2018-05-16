package com.example.theo.dlcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_connexion = (Button) findViewById(R.id.connexion);
        button_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to other activity
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);

            }
        });
    }
}
