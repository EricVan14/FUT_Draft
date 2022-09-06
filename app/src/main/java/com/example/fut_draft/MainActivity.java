package com.example.fut_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    protected Button singlePlayer, splitScreen;
    public static DatabaseHandler db;
    public EditText enterName;
    public String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePlayer = findViewById(R.id.singlePlayer);
        splitScreen = findViewById(R.id.splitScreen);
        enterName = findViewById(R.id.name);

        db = new DatabaseHandler(this);
        //db.clearDatabase();
        //db.addDefaults();




        singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterName.getText() != null){
                    name = enterName.getText().toString();
                    Intent myIntent = new Intent(MainActivity.this, SinglePlayer.class);
                    myIntent.putExtra("NAME",name);
                    MainActivity.this.startActivity(myIntent);
                }



            }
        });
    }
}