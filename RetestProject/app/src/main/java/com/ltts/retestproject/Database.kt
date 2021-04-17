package com.ltts.retestproject

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase


class Database (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY " +
                "AUTOINCREMENT,USERNAME TEXT,PASSWORD TEXT,EMAIL TEXT,MOBILE INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(uname: String, pass: String, email: String, mobile: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, uname)
        contentValues.put(COL_3, pass)
        contentValues.put(COL_4, email)
        contentValues.put(COL_5, mobile)
        db.insert(TABLE_NAME, null, contentValues)
    }
    companion object {
        val DATABASE_NAME = "data.db"
        val TABLE_NAME = "student"
        val COL_1 = "ID"
        val COL_2 = "USERNAME"
        val COL_3 = "PASSWORD"
        val COL_4 = "EMAIL"
        val COL_5 = "MOBILE"
    }

}