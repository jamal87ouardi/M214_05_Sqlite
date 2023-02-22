package com.example.m214_05_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Movie;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context) {
        super(context, "DB1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String req = "CREATE TABLE Molinet (Nom TEXT,Prix float, Url text)";
        db.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Molinet");

        onCreate(db);

    }

    public long add_Molinet(Molinet m) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put("Nom", m.getNom());

        values.put("Prix",m.getPrix());

        values.put("Url",m.getUrl());

        // Inserting Row
        long r = db.insert("Molinet", null, values);

        // Closing database connection
        db.close();

        return r;

    }


    public List<Molinet> get_All() {

        SQLiteDatabase db = this.getWritableDatabase();

        List<Molinet> molinets = new ArrayList<>();

        Cursor cur = db.rawQuery("SELECT * FROM Molinet",null);
        if(cur.moveToFirst()) {
            do {
                Molinet m = new Molinet();

                m.setNom(cur.getString(0));
                m.setPrix(cur.getFloat(1));
                m.setUrl(cur.getString(2));

                molinets.add(m);
            } while (cur.moveToNext());
        }

        return molinets;
    }



}
