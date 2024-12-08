package com.example.eventurestyle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        // Initialize the ListView
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView userOptionsList = findViewById(R.id.userOptionsList);

        // Get options from the string array resource
        String[] userOptions = getResources().getStringArray(R.array.user_profile_options);

        // Set up ArrayAdapter to populate ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userOptions);
        userOptionsList.setAdapter(adapter);

        // Set an item click listener
        userOptionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = userOptions[position];
                handleOptionClick(selectedOption);
            }
        });
    }

    // Handle each item click
    private void handleOptionClick(String option) {
        switch (option) {
            case "My Coordinator":
                // Open My Coordinator activity or perform action
                Toast.makeText(this, "Opening My Coordinator...", Toast.LENGTH_SHORT).show();
                break;
            case "Event Records":
                // Open Event Records activity or perform action
                Toast.makeText(this, "Opening Event Records...", Toast.LENGTH_SHORT).show();
                break;
            case "Payments":
                // Open Payments activity or perform action
                Toast.makeText(this, "Opening Payments...", Toast.LENGTH_SHORT).show();
                break;
            case "Test Bookings":
                // Open Test Bookings activity or perform action
                Toast.makeText(this, "Opening Test Bookings...", Toast.LENGTH_SHORT).show();
                break;
            case "Privacy & Policy":
                // Open Privacy & Policy activity or perform action
                Toast.makeText(this, "Opening Privacy & Policy...", Toast.LENGTH_SHORT).show();
                break;
            case "Help Center":
                // Open Help Center activity or perform action
                Toast.makeText(this, "Opening Help Center...", Toast.LENGTH_SHORT).show();
                break;
            case "Logout":
                // Handle Logout action
                Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
