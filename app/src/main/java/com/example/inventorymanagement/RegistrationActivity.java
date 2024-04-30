package com.example.inventorymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils; // For text manipulation methods
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    // Button references
    Button register, back;

    // Edit Text references for user input
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;

    // Checkbox for terms and conditions
    private CheckBox termsCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Find view references by their IDs in the layout
        register = findViewById(R.id.register);
        back = findViewById(R.id.back);
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        termsCheckbox = findViewById(R.id.terms_checkbox);

        // Register button click listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from EditTexts
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validation checks
                if (isEmpty(name)) {  // Helper method for checking empty string
                    Toast.makeText(RegistrationActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (isEmpty(email)) {
                    Toast.makeText(RegistrationActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidEmail(email)) {
                    Toast.makeText(RegistrationActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (isEmpty(password)) {
                    Toast.makeText(RegistrationActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 8) {
                    Toast.makeText(RegistrationActivity.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!termsCheckbox.isChecked()) {
                    Toast.makeText(RegistrationActivity.this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                    return;
                }

                // All validations passed, simulate success (no database for now)
                Toast.makeText(RegistrationActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrationActivity.this, SingInActivity.class);
                startActivity(intent);
            }
        });

        // Back button click listener
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LandingPage.class);
                startActivity(intent);
            }
        });

    }

    // Function to check for empty string (more concise than trim().isEmpty())
    private boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);  // Using TextUtils.isEmpty() for efficiency
    }

    // Function to check for valid email format (basic check)
    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$";
        return email.matches(emailRegex);
    }

}
