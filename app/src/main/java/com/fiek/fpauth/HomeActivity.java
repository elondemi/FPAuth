package com.fiek.fpauth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        databaseHelper = new DatabaseHelper(this);

        SharedPreferences prefs = this.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = prefs.getString("username", null);
        ((TextView)findViewById(R.id.username)).setText(username);



        CardView goMeditate = findViewById(R.id.card00);
        CardView goWalk = findViewById(R.id.card01);
        CardView goExercise = findViewById(R.id.card10);
        CardView goEat= findViewById(R.id.card11);
        CardView goSleep = findViewById(R.id.card20);
        CardView logout = findViewById(R.id.card21);


        goMeditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MeditationActivity.class));
            }
        });

        goWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, WalkingActivity.class));
            }
        });

        goExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ExerciseActivity.class));
            }
        });

        goEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FoodActivity.class));
            }
        });

        goSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SleepActivity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LogInActivity.class));
            }
        });

    }
}