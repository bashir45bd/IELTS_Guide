package com.bashirbd.ieltsguide;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Dbhelper extends SQLiteAssetHelper {
    public Dbhelper(Context context) {
        super(context, "dictionary2.db", null, 1);

    }


    public Cursor getalldata (){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Dictionary",null);

        return cursor;
    }


    public Cursor searchword ( String key){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Dictionary WHERE word LIKE '"+key+"%'",null);

        return cursor;
    }


}
