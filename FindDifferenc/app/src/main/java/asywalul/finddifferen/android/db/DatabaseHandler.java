package asywalul.finddifferen.android.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	public static final int DATABASE_VERSION = 1;

	// Database Name
	public static final String DATABASE_NAME = "FindMe.db";

	// Create tables

	private static final String CREATE_TABLE_SCORE = "create table SCORE "
			+ "(_id integer primary key, " 
			+ StatusInfoDB.LAST_UPDATE + " TEXT," 
			+ StatusInfoDB.MIN_DURATION + " INTEGER," 
			+ StatusInfoDB.NUM_ERRORS + " INTEGER);";


	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void close() {
		try {
			super.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_SCORE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS SCORE;");
		// Create tables again
		onCreate(db);
	}
}
