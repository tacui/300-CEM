package com.example.iulian.memo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class BDHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "memodb.db";
    public static final String TABLE_MEMOS = "memos";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "memotitle";
    public static final String COLUMN_TEXT = "memotext";

    public BDHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_MEMOS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_TEXT + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMOS);
        onCreate(db);
    }

    public void addMemo(DBMemo addedmemo){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, addedmemo.get_memotitle());
        values.put(COLUMN_TEXT, addedmemo.get_memotext());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MEMOS, null, values);
        db.close();
    }

    public void deleteMemo (int memoTitle){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MEMOS + " WHERE " + COLUMN_TITLE + "=\"" + memoTitle + "\";" );
    }

    public Cursor extractTitles(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + COLUMN_TITLE + " FROM " + TABLE_MEMOS + " WHERE 1";
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    public Cursor extractText (String memoTitle){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT " + COLUMN_TEXT + " FROM " + TABLE_MEMOS + " WHERE " + COLUMN_TITLE + "=\"" + memoTitle + "\";";
        Cursor c = db.rawQuery(query, null);
        return c;
    }

}
