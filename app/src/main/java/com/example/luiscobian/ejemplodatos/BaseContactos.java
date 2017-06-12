package com.example.luiscobian.ejemplodatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by luiscobian on 6/11/17.
 */

public class BaseContactos extends SQLiteOpenHelper {

    public final static String  DATABASE_NAME = "contados.bd";
    public final static int DATABASE_NUMBER_VERSION = 1;
    public final static String SQL_CREATE_ENTRIES = "CREATE TABLE contacto (nombre TEXT, telefono TEXT)";
    public final static String SQL_DELETE_ENTRIES = "DROP TABLE IF EXIST contacto";

    public BaseContactos(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_NUMBER_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
