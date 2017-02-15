package asywalul.finddifferen.android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StatusInfoDB {
	public static final String ROW_ID = "_id";
	public static final String LAST_UPDATE = "updateDate";
	public static final String MIN_DURATION = "duration";
	public static final String NUM_ERRORS = "errors";
	
	private static final String DATABASE_TABLE = "SCORE";

	private DatabaseHandler mDbHandler;
	private SQLiteDatabase mDb;

	private final Context mCtx;

	@SuppressWarnings("unused")
	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DatabaseHandler.DATABASE_NAME, null,
					DatabaseHandler.DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	}

	/**
	 * Constructor - takes the context to allow the database to be
	 * opened/created
	 * 
	 * @param ctx
	 *            the Context within which to work
	 */
	public StatusInfoDB(Context ctx) {
		this.mCtx = ctx;
	}

	/**
	 * Open the Apps database. If it cannot be opened, try to create a new
	 * instance of the database. If it cannot be created, throw an exception to
	 * signal the failure
	 * 
	 * @return this (self reference, allowing this to be chained in an
	 *         initialization call)
	 * @throws SQLException
	 *             if the database could be neither opened or created
	 */
	public StatusInfoDB open() throws SQLException {
		this.mDbHandler = new DatabaseHandler(this.mCtx);
		this.mDb = this.mDbHandler.getWritableDatabase();
		return this;
	}

	/**
	 * close return type: void
	 */
	public void close() {
		this.mDbHandler.close();
	}

	/**
	 * Create a new App. If the App is successfully created return the new rowId
	 * for that App, otherwise return a -1 to indicate failure.
	 * 
	 * @return rowId or -1 if failed
	 */
	public long createScore(int id, String update, int duration, int errors) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(ROW_ID, id);
		initialValues.put(LAST_UPDATE, update);
		initialValues.put(MIN_DURATION, duration);
		initialValues.put(NUM_ERRORS, errors);
		return this.mDb.insert(DATABASE_TABLE, null, initialValues);
	}

	/**
	 * Delete the Score with the given rowId
	 * 
	 * @param rowId
	 * @return true if deleted, false otherwise
	 */
	public boolean deleteScore(long rowId) {

		return this.mDb.delete(DATABASE_TABLE, ROW_ID + "=" + rowId, null) > 0; //$NON-NLS-1$
	}
	
	/**
	 * Return a Cursor over the list of all Apps in the database
	 * 
	 * @return Cursor over all Apps
	 */
	public Cursor getAllScores() {
		return this.mDb.query(DATABASE_TABLE, new String[] { ROW_ID, 
				LAST_UPDATE,MIN_DURATION,NUM_ERRORS}, null, null,
		 null, null, null);
	}
	
	/**
	 * Return a Cursor positioned at the App that matches the given rowId
	 * 
	 * @param rowId
	 * @return Cursor positioned to matching App, if found
	 * @throws SQLException
	 *             if App could not be found/retrieved
	 */
	public Cursor getScore(int rowId) throws SQLException {

		String sql = "SELECT _id, updateDate, duration, errors FROM " 
		+ DATABASE_TABLE + " WHERE _id = " + rowId;

		Cursor mCursor = this.mDb.rawQuery(sql, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	/**
	 * Update the Score.
	 * 
	 * @return true if the score was successfully updated, false otherwise
	 */
	public boolean updateScore(int id, String update, int duration, int errors) {
		ContentValues args = new ContentValues();
		args.put(ROW_ID, id);
		args.put(LAST_UPDATE, update);
		args.put(MIN_DURATION, duration);
		args.put(NUM_ERRORS, errors);

		return this.mDb
				.update(DATABASE_TABLE, args, ROW_ID + "=" + id, null) > 0;
	}	
}
