package com.fiek.fpauth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fiek.fpauth.databinding.ActivityLogInBinding;

public class LogInActivity extends AppCompatActivity {
    ActivityLogInBinding binding;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.loginUsername.getText().toString();
                String password = binding.loginPassword.getText().toString();
                TextView tv = (TextView)findViewById(R.id.textView);


                if(username.equals("")||password.equals(""))
                    Toast.makeText(LogInActivity.this, "Please fill All details", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = databaseHelper.checkUsernamePassword(username, password);
                    if(checkCredentials == true){
                        Toast.makeText(LogInActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();

//                        databaseHelper.openDataBase();
//                        String text = databaseHelper.getName();
//                        databaseHelper.close();
//                        tv.setText(text);
//
//                        String message = ((TextView)findViewById(R.id.textView)).getText().toString();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.apply();

                        Intent intent  = new Intent(getApplicationContext(), HomeActivity.class);
//                        intent.putExtra("name", message);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LogInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}