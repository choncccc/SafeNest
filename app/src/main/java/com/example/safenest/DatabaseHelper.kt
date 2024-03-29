package com.example.safenest
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

val TABLE_NAME = "WithCountTB"
val COL_ID = "userID"
val COL_USERNAME= "Username"
val COL_PASSWORD= "Password"
val COL_NAME = "Name"
val  COL_LOGIN_COUNTER = "LoginCounter"

//on NextPage after signup
val COL_FIRSTDAYLASTPERIOD = "firstDayLastPeriod"
val COL_MONTHLASTPERIOD = "MonthLastPeriod"
val COL_ESTIMATEDDUE= "estimatedDue"


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        //createDB
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_USERNAME + " VARCHAR(256)," +
                COL_NAME + " VARCHAR(256)," +
                COL_PASSWORD + " VARCHAR(256)," +
                COL_LOGIN_COUNTER + " INTEGER DEFAULT 0" +
                ")"
        db.execSQL(createTable)
    }

    fun InsertValuesFromSignUp(username: String, name: String, password: String): Long {
        val contentValues = ContentValues().apply {
            put(COL_USERNAME, username)
            put(COL_NAME, name)
            put(COL_PASSWORD, password)

        }
        val db = this.writableDatabase
        return db.insert(TABLE_NAME, null, contentValues)
    }

    fun checkUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(COL_USERNAME),
            "$COL_USERNAME = ? AND $COL_PASSWORD = ?",
            arrayOf(username, password),
            null,
            null,
            null
        )
        val isValidUser = cursor.count > 0
        cursor.close()
        return isValidUser
    }
    fun getName(username: String): String? {
        var name: String? = null
        val db = this.readableDatabase
        val query = "SELECT $COL_NAME FROM $TABLE_NAME WHERE $COL_USERNAME = ?"
        val cursor: Cursor = db.rawQuery(query, arrayOf(username))
        if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex(COL_NAME)
            if (columnIndex != -1) {
                name = cursor.getString(columnIndex)
            }
        }
        cursor.close()
        db.close()
        return name
    }
    fun incrementLoginCounter(username: String) {
        val db = this.writableDatabase
        val currentLoginCounter = getLoginCounterByUsername(username) // Retrieve current login counter
        val newLoginCounter = if (currentLoginCounter == -1) {
            1
        } else {
            currentLoginCounter + 1
        }

        val contentValues = ContentValues().apply {
            put(COL_LOGIN_COUNTER, newLoginCounter)
        }
        db.update(TABLE_NAME, contentValues, "$COL_USERNAME = ?", arrayOf(username))
        db.close()
    }

    fun getLoginCounterByUsername(username: String): Int {
        var loginCounter = -1
        val db = this.readableDatabase
        val query = "SELECT $COL_LOGIN_COUNTER FROM $TABLE_NAME WHERE $COL_USERNAME = ?"
        val cursor = db.rawQuery(query, arrayOf(username))
        if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex(COL_LOGIN_COUNTER)
            if (columnIndex != -1) {
                loginCounter = cursor.getInt(columnIndex)
            }
        }
        cursor.close()
        return loginCounter
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //Alter tables here
    }


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "WithCounterDB"
    }
}
