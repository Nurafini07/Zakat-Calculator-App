package com.example.myzakatcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class About extends AppCompatActivity {

    Toolbar aboutToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutToolbar = findViewById(R.id.about_toolbar);
        setSupportActionBar(aboutToolbar);
        getSupportActionBar().setTitle("About");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Your existing code for setting the text and image

        // ...

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        } else if (item.getItemId() == R.id.action_share) {
            shareContent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareContent() {
        String shareText = "Check out this cool information about me:\n\n" +
                "NAME: Nurafini Atirah Binti Kamal\n" +
                "STUDENT ID: 2021829044\n" +
                "PROGRAMME: Information Technology\n" +
                "SEMESTER: Part 5\n" +
                "AMBITION: Police Officer\n" +
                "HOBBY: Listening to Music, Fishing, Singing";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        startActivity(Intent.createChooser(shareIntent, "Share using"));
    }
}
