package com.example.inventorymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {

    // Declare button references
    Button signin, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        // Find buttons by their IDs in the layout
        signin = findViewById(R.id.open_signin);
        register = findViewById(R.id.open_register);

        // Set click listener for Sign In button
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to SignInActivity
                Intent intent = new Intent(LandingPage.this, SingInActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to RegistrationActivity
                Intent intent = new Intent(LandingPage.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
