package com.example.eventurestyle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button for navigating to MainActivity1
        Button navigateButtonToMainActivity2 = findViewById(R.id.navigate_button_to_main_activity_2);

        // Set an OnClickListener on the button
        navigateButtonToMainActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to go to MainActivity1
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);  // Start the activity
            }
        });
    }
}
