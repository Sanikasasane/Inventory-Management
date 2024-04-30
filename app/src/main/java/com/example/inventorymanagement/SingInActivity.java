package com.example.inventorymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils; // For text manipulation methods
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
/// Import for Toast messages
import android.widget.Toast;

public class SingInActivity extends AppCompatActivity {

    // Button references
    Button signin, back;

    // Edit Text references for user input
    private EditText emailEditText;
    private EditText passwordEditText;

    // Checkbox for terms and conditions
    private CheckBox termsCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        // Find view references by their IDs in the layout
        signin = findViewById(R.id.Signin);
        back = findViewById(R.id.back_signin);
        emailEditText = findViewById(R.id.email_edit_text_signin);
        passwordEditText = findViewById(R.id.password_edit_text_signin);
        termsCheckbox = findViewById(R.id.terms_checkbox_signin);

        // Sign In button click listener
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from EditTexts
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validation checks
                if (isEmpty(email)) {
                    Toast.makeText(SingInActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidEmail(email)) {
                    Toast.makeText(SingInActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (isEmpty(password)) {
                    Toast.makeText(SingInActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 8) {
                    Toast.makeText(SingInActivity.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!termsCheckbox.isChecked()) {
                    Toast.makeText(SingInActivity.this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
                    return;
                }

                // All validations passed, simulate success (no database for now)
                Toast.makeText(SingInActivity.this, "Sign in successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SingInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Back button click listener
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingInActivity.this, LandingPage.class);
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
