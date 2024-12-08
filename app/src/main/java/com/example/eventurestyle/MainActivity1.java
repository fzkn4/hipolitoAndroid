package com.example.eventurestyle;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    private boolean isPasswordVisible = false; // Track password visibility state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button login = findViewById(R.id.login);
        EditText emailInput = findViewById(R.id.email_input);
        EditText passwordInput = findViewById(R.id.password_input);
        TextView dontHaveAccountText = findViewById(R.id.dont_have_account);
        ImageView eyeIcon = findViewById(R.id.eye_icon); // Eye icon for password visibility toggle

        // Login button onClickListener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered in the email and password fields
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // Check if both email and password are not empty
                if (email.isEmpty()) {
                    emailInput.setError("Email cannot be empty");
                } else if (password.isEmpty()) {
                    passwordInput.setError("Password cannot be empty");
                } else if (!isPasswordStrong(password)) {
                    // If the password is not strong, show an error message
                    passwordInput.setError("Password must contain at least 8 characters, including one uppercase, one lowercase, and one digit");
                } else {
                    // Proceed to MainActivity3 if credentials are valid
                    Intent intent = new Intent(MainActivity1.this, MainActivity3.class);
                    startActivity(intent);  // Start MainActivity3
                }
            }
        });

        // "Don't have an account?" TextView onClickListener
        dontHaveAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity2 when clicked
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                startActivity(intent);  // Start MainActivity2
            }
        });

        // Eye icon onClickListener to toggle password visibility
        eyeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Hide password
                    passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    eyeIcon.setImageResource(R.drawable.ic_eye_off); // Set icon to "closed eye"
                } else {
                    // Show password
                    passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    eyeIcon.setImageResource(R.drawable.ic_eye_on); // Set icon to "open eye"
                }

                isPasswordVisible = !isPasswordVisible;
                passwordInput.setSelection(passwordInput.getText().length()); // Move cursor to the end

                // Reapply the custom font
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    passwordInput.setTypeface(getResources().getFont(R.font.eb1));
                }
            }
        });
    }

    // Method to check if password is strong
    private boolean isPasswordStrong(String password) {
        // Minimum length of 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check for at least one uppercase letter, one lowercase letter, and one digit
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit;
    }
}
