package com.example.quanlysinhvien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database  extends SQLiteOpenHelper {
        private static final String DATABASE_NAME="qlsv.sqlLite";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "sinhvien";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_GT = "gioitinh";
    public static final String COLUMN_SDT = "sdt";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_LOP = "lop";

    public Database(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)"
                        , TABLE_NAME
                        , COLUMN_ID
                        , COLUMN_NAME
                        , COLUMN_GT
                        , COLUMN_SDT
                        , COLUMN_EMAIL
                        , COLUMN_LOP));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
