package com.fiek.fpauth;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        databaseHelper = new DatabaseHelper(this);

//        Intent i = getIntent();
//        String message = i.getStringExtra("name");
//        ((TextView)findViewById(R.id.name)).setText(message);


//        String name = databaseHelper.getName();
//        ((TextView)findViewById(R.id.name)).setText(name);

    }
}