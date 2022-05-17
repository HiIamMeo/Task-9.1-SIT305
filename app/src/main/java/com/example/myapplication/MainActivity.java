package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button writeButton = findViewById(R.id.write);
        Button showButton = findViewById(R.id.show);
        db = new DatabaseHelper(this);

        writeButton.setOnClickListener(view -> {

            Intent signupIntent = new Intent(MainActivity.this, NewItemActivity.class);
            startActivity(signupIntent);
        });

        showButton.setOnClickListener(view -> {
            Intent showIntent = new Intent(MainActivity.this, ShowItemActivity.class);
            startActivity(showIntent);
        });
    }
}

