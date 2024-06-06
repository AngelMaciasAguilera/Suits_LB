package com.example.suits_lb.controladores.SQLiteBD;

import android.content.Context;
import android.database.Cursor;
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
                    "nomRopa TEXT,"+
                    "imgRopa TEXT,"+
                    "cantidad INTEGER,"+
                    "subtotal REAL)";

    public DatabaseHelperUserCart(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }


    public Cursor getAllCartItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + ProductosContractCart.AuxCarritoEntries.TABLE_NAME, null);
    }

    public void deleteAllItems(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ProductosContractCart.AuxCarritoEntries.TABLE_NAME);
        db.close();
    }

}
