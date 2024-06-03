package com.example.suits_lb.controladores.SQLiteBD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperUserPr extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "productosUser.db";
    private static final int DATABASE_VERSION = 1;

    private static String SQL_CREATE_ENTRIES =
            "CREATE TABLE productosUser(" +
                    "codRopa TEXT PRIMARY KEY," +
                    "nombreRopa TEXT," +
                    "descripcion TEXT," +
                    "precio REAL," +
                    "categoria TEXT," +
                    "stock INTEGER," +
                    "imgProducto TEXT," +
                    "ventaDisponible TEXT)";

    public DatabaseHelperUserPr(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS productosUser");
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS productosUser");
        onCreate(db);
    }
}
