package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.data.DatabaseHelper;
import com.example.myapplication.model.Item;
import com.example.myapplication.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ShowItemActivity extends AppCompatActivity {
    ListView itemsListView ;

    ArrayList<String> itemArrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);
        itemsListView = findViewById(R.id.itemsListView);
        itemArrayList = new ArrayList<>();
        DatabaseHelper db = new DatabaseHelper(ShowItemActivity.this);

        List<Item> itemList = db.fetchAllItems();
        for (Item item : itemList)
        {
            itemArrayList.add(item.getRadioOption() + item.getDescription());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemArrayList);
        itemsListView.setAdapter(adapter);

        //use setOnItemClickListener

        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent EditorIntent = new Intent(ShowItemActivity.this, ReadItemActivity.class);

                EditorIntent.putExtra(Util.ITEM_ID, itemList.get(position).getItem_id());
                EditorIntent.putExtra(Util.OPTION, itemList.get(position).getRadioOption());
                EditorIntent.putExtra(Util.PHONE, itemList.get(position).getRadioOption());
                EditorIntent.putExtra(Util.USERNAME, itemList.get(position).getItem_id());
                EditorIntent.putExtra(Util.DESCRIPTION, itemList.get(position).getDescription());
                EditorIntent.putExtra(Util.DATE, itemList.get(position).getDate());
                EditorIntent.putExtra(Util.LOCATION, itemList.get(position).getLocation());
                startActivityForResult(EditorIntent, 1);
                finish();
            }
        });
    }
}