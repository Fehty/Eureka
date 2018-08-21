package com.fehtystudio.eurika.HomeWork

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HomeWorkDBHelper(context: Context?, name: String?, version: Int) : SQLiteOpenHelper(context, name, null, version) {

    val TABLE_HOMEWORK = "homework"
    val KEY_ID = "_id"
    val KEY_SUBJECT = "itemS"
    val KEY_HOME_WORK_DESCRIPTION = "itemD"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table " + TABLE_HOMEWORK + "(" + KEY_ID + " integer primary key,"
                + KEY_SUBJECT + " text," + KEY_HOME_WORK_DESCRIPTION + " text" + ")" )
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("drop table if exists" + TABLE_HOMEWORK)
        onCreate(db)
    }
}