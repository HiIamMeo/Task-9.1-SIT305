package com.example.myapplication.data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Item;
import com.example.myapplication.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "tag";

    public DatabaseHelper(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_ITEM_TABLE = "CREATE TABLE " + Util.ITEM_TABLE_NAME + "(" +
                Util.ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Util.OPTION + " TEXT, " +
                Util.USERNAME + " TEXT, " +
                Util.PHONE + " TEXT, " +
                Util.DESCRIPTION + " TEXT, " +
                Util.DATE + " TEXT, " +
                Util.LOCATION + " TEXT) ";
        db.execSQL(CREATE_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_ITEM_TABLE = "DROP TABLE IF EXISTS " + Util.DATABASE_NAME;
        db.execSQL(DROP_ITEM_TABLE, new String[]{Util.ITEM_TABLE_NAME});
        onCreate(db);
    }

    public long wItem (Item item)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.USERNAME, item.getUsername());
        contentValues.put(Util.PHONE, item.getPhone());
        contentValues.put(Util.DESCRIPTION, item.getDescription());
        contentValues.put(Util.DATE, item.getDate());
        contentValues.put(Util.LOCATION, item.getLocation());
        contentValues.put(Util.OPTION, item.getRadioOption());
        long newRowId = db.insert(Util.ITEM_TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    public List<Item> fetchAllItems (){
        List<Item> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = " SELECT * FROM " + Util.ITEM_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setItem_id(cursor.getInt(0));
                item.setRadioOption(cursor.getString(1));
                item.setUsername(cursor.getString(2));
                item.setPhone(cursor.getString(3));
                item.setDescription(cursor.getString(4));
                item.setDate(cursor.getString(5));
                item.setLocation(cursor.getString(6));

                userList.add(item);
            } while (cursor.moveToNext());
        }
        return userList;
    }

    public int rmItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Util.ITEM_TABLE_NAME, Util.ITEM_ID + "=?", new String[]{String.valueOf(item.getItem_id())});
    }
}
