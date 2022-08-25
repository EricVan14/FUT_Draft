package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String PLAYER_TABLE_NAME = "players"; //Table name
    protected Button singlePlayer, splitScreen;
    public static DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePlayer = findViewById(R.id.singlePlayer);
        splitScreen = findViewById(R.id.splitScreen);

        db = new DatabaseHandler(this);
        db.clearDatabase();
        db.addDefaults();


        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SinglePlayer.class);
                MainActivity.this.startActivity(myIntent);


            }
        });
    }
}