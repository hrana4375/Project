package com.example.himsrana.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, "Database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USER (Title text,Content text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)  {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(sqLiteDatabase);
    }


    void onAdd(String title,String content) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Title",title);
        contentValues.put("Content",content);

        sqLiteDatabase.insert("USER",null,contentValues);
    }

    Cursor getData() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query("USER",null,null,null,null,null,null,null);

        return cursor;

    }
    void onUpdate(String title,String content) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("Title",title);
        cv.put("Content",content);
        String arr[] = {};

        sqLiteDatabase.update("USER",cv,"",arr);

    }

    void onDelete(String title) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String arr[] = {title};
        sqLiteDatabase.delete("USER","Title=?",arr);

    }
}
