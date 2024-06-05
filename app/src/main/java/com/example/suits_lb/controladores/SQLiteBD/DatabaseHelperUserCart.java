package com.example.suits_lb.controladores.SQLiteBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperUserCart extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "carritoUser.db";
    private static final int DATABASE_VERSION = 1;

    private static String SQL_CREATE_ENTRIES =
            "CREATE TABLE carritoUser(" +
                    "codRopa TEXT," +
                    "email TEXT," +
                    "cantidad INTEGER,"+
                    "precio REAL)";

    public DatabaseHelperUserCart(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL("DELETE FROM carritoUser");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
