package com.github.stuartyeates.TEIDictLeitner;

import android.os.Environment;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;
import android.util.Log;

import java.io.File;
import java.util.*;

public class Logger {
/*
	static private String LANGUAGE_CODES;
	static private String DATABASE_NAME;
	static private int DATABASE_VERSION = 1;
	static private String WORDS_TABLE_NAME = "words";
	// private String ACTION_TABLE_NAME = "actions";

	static private Context context = null;
	static private SQLiteDatabase db = null;

	static private SQLiteStatement wordInsertStmt;
	static private String WORD_INSERT;

	// private SQLiteStatement actionInsertStmt;
	// private String ACTION_INSERT ;

	static private SQLiteStatement wordUpdateStmt;
	static private String WORD_UPDATE;

	// = "insert into " + TABLE_NAME + "(name) values (?)";

	public Logger(Context context, String LANGUAGE_CODES) {
		Logger.LANGUAGE_CODES = LANGUAGE_CODES;
		Logger.DATABASE_NAME = "teiDict" + LANGUAGE_CODES + ".db";
		Logger.context = context;
		Helper openHelper = new Helper(Logger.context);
		Logger.db = openHelper.getWritableDatabase();
		Logger.WORD_INSERT = "insert into " + WORDS_TABLE_NAME
				+ "(word, definition, date, deck) values (?,?,?,?)";
		Logger.WORD_UPDATE = "insert into " + WORDS_TABLE_NAME
				+ "(word, definition, date, deck) values (?,?,?,?)";

		wordInsertStmt = this.db.compileStatement(this.WORD_INSERT);
		wordUpdateStmt = this.db.compileStatement(this.WORD_UPDATE);
	}

	public long insert(Word word) {
		wordInsertStmt.bindString(1, word.getWord());
		wordInsertStmt.bindString(2, word.getDefinition());
		wordInsertStmt.bindLong(3, word.getDate().getTime());
		wordInsertStmt.bindLong(4, 0);
		return wordInsertStmt.executeInsert();
	}

	public long insert(Word word, int deck) {
		wordInsertStmt.bindString(1, word.getWord());
		wordInsertStmt.bindString(2, word.getDefinition());
		wordInsertStmt.bindLong(3, word.getDate().getTime());
		wordInsertStmt.bindLong(4, deck);
		return wordInsertStmt.executeInsert();
	}

	public long update(Word word, int deck, long index) {
		wordUpdateStmt.bindString(1, word.getWord());
		wordUpdateStmt.bindString(2, word.getDefinition());
		wordUpdateStmt.bindLong(3, word.getDate().getTime());
		wordUpdateStmt.bindLong(4, deck);
		return wordUpdateStmt.executeInsert();

	}

	private void deleteAll() {
		this.db.delete(WORDS_TABLE_NAME, null, null);
	}

	public List<String> selectAll() {
		List<String> list = new ArrayList<String>();
		Cursor cursor = this.db.query(WORDS_TABLE_NAME,
				new String[] { "name" }, null, null, null, null, "name desc");
		if (cursor.moveToFirst()) {
			do {
				list.add(cursor.getString(0));
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return list;
	}

	private static class Helper extends SQLiteOpenHelper {

		Helper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + WORDS_TABLE_NAME
					+ "(id INTEGER PRIMARY KEY, name TEXT)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("Example",
					"Upgrading database, this will drop tables and recreate.");
			db.execSQL("DROP TABLE IF EXISTS " + WORDS_TABLE_NAME);
			onCreate(db);
		}
	}
	*/
}
