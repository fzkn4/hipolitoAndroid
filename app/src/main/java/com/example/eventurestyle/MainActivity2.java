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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Find the views by their IDs
        EditText nameInput = findViewById(R.id.name_input);
        EditText emailInput = findViewById(R.id.email_input);
        EditText passwordInput = findViewById(R.id.password_input);
        EditText confirmPasswordInput = findViewById(R.id.confirm_password_input);
        Button signUpButton = findViewById(R.id.sign_up_button);
        TextView alreadyHaveAccountText = findViewById(R.id.already_have_account);
        ImageView showPasswordIcon = findViewById(R.id.show_password_icon);
        ImageView showConfirmPasswordIcon = findViewById(R.id.show_password_icon1);

        // Set the font for all EditText fields
        nameInput.setTypeface(getResources().getFont(R.font.eb1));
        emailInput.setTypeface(getResources().getFont(R.font.eb1));
        passwordInput.setTypeface(getResources().getFont(R.font.eb1));
        confirmPasswordInput.setTypeface(getResources().getFont(R.font.eb1));

        // Set up password visibility toggle for the password field
        showPasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Hide password
                    passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showPasswordIcon.setImageResource(R.drawable.ic_eye_off);
                } else {
                    // Show password
                    passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    showPasswordIcon.setImageResource(R.drawable.ic_eye_on);
                }
                isPasswordVisible = !isPasswordVisible;
                passwordInput.setSelection(passwordInput.getText().length());

                // Reapply the font to maintain consistency when toggling visibility
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    passwordInput.setTypeface(getResources().getFont(R.font.eb1));
                }
            }
        });

        // Set up password visibility toggle for the confirm password field
        showConfirmPasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConfirmPasswordVisible) {
                    // Hide confirm password
                    confirmPasswordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showConfirmPasswordIcon.setImageResource(R.drawable.ic_eye_off);
                } else {
                    // Show confirm password
                    confirmPasswordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    showConfirmPasswordIcon.setImageResource(R.drawable.ic_eye_on);
                }
                isConfirmPasswordVisible = !isConfirmPasswordVisible;
                confirmPasswordInput.setSelection(confirmPasswordInput.getText().length());

                // Reapply the font to maintain consistency when toggling visibility
                confirmPasswordInput.setTypeface(getResources().getFont(R.font.eb1));
            }
        });

        // Set an OnClickListener for the Sign Up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text entered in the fields
                String name = nameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String confirmPassword = confirmPasswordInput.getText().toString().trim();

                // Validate the input fields
                if (name.isEmpty()) {
                    nameInput.setError("Name cannot be empty");
                } else if (email.isEmpty()) {
                    emailInput.setError("Email cannot be empty");
                } else if (password.isEmpty()) {
                    passwordInput.setError("Password cannot be empty");
                } else if (confirmPassword.isEmpty()) {
                    confirmPasswordInput.setError("Confirm Password cannot be empty");
                } else if (!password.equals(confirmPassword)) {
                    confirmPasswordInput.setError("Passwords do not match");
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailInput.setError("Please enter a valid email");
                } else {
                    // All inputs are valid, proceed to the next activity
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);  // Start MainActivity3
                }
            }
        });

        // Set an OnClickListener to navigate to MainActivity1 (login page)
        alreadyHaveAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to go to MainActivity1
                Intent intent = new Intent(MainActivity2.this, MainActivity1.class);
                startActivity(intent);  // Start the activity
            }
        });
    }
}
