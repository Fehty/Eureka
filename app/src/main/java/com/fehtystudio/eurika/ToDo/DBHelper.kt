package com.fehtystudio.eurika.ToDo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?, name: String?, version: Int) : SQLiteOpenHelper(context, name, null, version) {

    val TABLE_TO_DO= "toDoTable"
    val KEY_ID = "_id"
    val KEY_ITEM = "item"
    var KEY_CHECKBOX = "checkBox"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table " + TABLE_TO_DO + "(" + KEY_ID + " integer primary key,"
                + KEY_ITEM + " text," + KEY_CHECKBOX + " integer" + ")" )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists" + TABLE_TO_DO)
        onCreate(db)
    }


}
