package com.example.tallerlabo.Adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DBAdapter.CREAR_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int versionAnterior, int nuevaVersion){
        db.execSQL("ALTER TABLE pais ADD COLUMN bandera BLOB);");
    }
}