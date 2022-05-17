package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.data.DatabaseHelper;
import com.example.myapplication.model.Item;
import com.example.myapplication.util.Util;

public class ReadItemActivity extends AppCompatActivity {
    DatabaseHelper db;
    String content;
    Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_item);

        TextView readBox = findViewById(R.id.ReadItemBox);
        Button rmButton = findViewById(R.id.rmbutton);
        db = new DatabaseHelper(this);
        Intent getContentIntent = getIntent();


        String type = getContentIntent.getStringExtra(Util.OPTION);
        String name = getContentIntent.getStringExtra(Util.USERNAME);
        String desc = getContentIntent.getStringExtra(Util.DESCRIPTION);
        String date = getContentIntent.getStringExtra(Util.DATE);
        String location = getContentIntent.getStringExtra(Util.LOCATION);
        String phone = getContentIntent.getStringExtra(Util.PHONE);
        Integer ID = getContentIntent.getIntExtra(Util.ITEM_ID,0);

        readBox.setText(type + "\n" + desc + " \n" + date + " \n" + location);

        //create delete button click event
        rmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deleteIndex = db.rmItem(new Item (ID, type, name, phone, desc, date, location));
                if (deleteIndex > 0) {
                    Toast.makeText(ReadItemActivity.this, "You delete advert successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReadItemActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(ReadItemActivity.this, ShowItemActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}