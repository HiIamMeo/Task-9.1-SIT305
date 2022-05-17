package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.data.DatabaseHelper;
import com.example.myapplication.model.Item;
import com.example.myapplication.util.Util;

import java.util.Arrays;

public class NewItemActivity extends AppCompatActivity {
    DatabaseHelper db;
    String radioResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);
        EditText sUsernameEditText = findViewById(R.id.sUsernameEditText);
        EditText sPhoneEditText = findViewById(R.id.sPhoneEditText);
        EditText sDescEditText = findViewById(R.id.sDescEditText);
        EditText sDateEditText = findViewById(R.id.sDateEditText);
        EditText sLocationEditText = findViewById(R.id.sLocationEditText);
        Button addButton = findViewById(R.id.addButton);
        db = new DatabaseHelper(this);

        addButton.setOnClickListener(view -> {
            String[] items = new String[]{
                    radioResult,
                    sUsernameEditText.getText().toString(),
                    sPhoneEditText.getText().toString(),
                    sDescEditText.getText().toString(),
                    sDateEditText.getText().toString(),
                    sLocationEditText.getText().toString()
            };
            if (Arrays.asList(items).contains("") | radioResult == null)  // If there is at least 1 blank input
                Toast.makeText(NewItemActivity.this, "Please complete the form", Toast.LENGTH_SHORT).show();
            else {
                //int id = Integer.parseInt(Util.ITEM_ID + 1);
                long newRowId = db.wItem(new Item(
                        //id,
                        items[0],
                        items[1],
                        items[2],
                        items[3],
                        items[4],
                        items[5]
                ));
                if (newRowId > 0) {
                    Toast.makeText(NewItemActivity.this, "ADD success", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else Toast.makeText(NewItemActivity.this, "Error: ADD failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioLost:
                if (checked)
                    Toast.makeText(NewItemActivity.this, "Lost", Toast.LENGTH_SHORT).show();
                    return radioResult = "Lost";
            case R.id.radioFound:
                if (checked)
                    Toast.makeText(NewItemActivity.this, "Found", Toast.LENGTH_SHORT).show();
                    return radioResult = "Found";
        }
        return null;
    }
}
