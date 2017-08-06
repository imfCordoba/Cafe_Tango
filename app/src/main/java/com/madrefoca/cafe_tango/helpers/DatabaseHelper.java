package com.madrefoca.cafe_tango.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.madrefoca.cafe_tango.model.Illness;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Fernando on 8/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "cafeTangoManager";

    // Illnesses table name
    private static final String TABLE_ILLNESSES = "illnesses";

    // Illnesses Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creating tables
        String CREATE_ILLNESSES_TABLE = "CREATE TABLE " + TABLE_ILLNESSES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DESCRIPTION + " TEXT" + ")";
        db.execSQL(CREATE_ILLNESSES_TABLE);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ILLNESSES);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new illness
    public void addIllness(Illness illness) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, illness.getName()); // Illness Name
        values.put(KEY_DESCRIPTION, illness.getDescription()); // Illness desciption

        // Inserting Row
        db.insert(TABLE_ILLNESSES, null, values);
        db.close(); // Closing database connection
    }

    // Getting single illness
    Illness getIllness(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ILLNESSES, new String[] { KEY_ID,
                        KEY_NAME, KEY_DESCRIPTION }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Illness illness = new Illness(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return illness;
    }

    // Getting All Illnesses
    public List<Illness> getAllIllnesses() {
        List<Illness> illnessesList = new ArrayList<Illness>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ILLNESSES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Illness illness = new Illness();
                illness.setId(Integer.parseInt(cursor.getString(0)));
                illness.setName(cursor.getString(1));
                illness.setDescription(cursor.getString(2));
                // Adding illness to list
                illnessesList.add(illness);
            } while (cursor.moveToNext());
        }

        // return illnesses list
        return illnessesList;
    }

    // Updating single illness
    public int updateContact(Illness illness) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, illness.getName());
        values.put(KEY_DESCRIPTION, illness.getDescription());

        // updating row
        return db.update(TABLE_ILLNESSES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(illness.getId()) });
    }

    // Deleting single illness
    public void deleteIllness(Illness illness) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ILLNESSES, KEY_ID + " = ?",
                new String[] { String.valueOf(illness.getId()) });
        db.close();
    }

    // Getting contacts Count
    public int getIllnessesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ILLNESSES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public boolean deleteAllIllnesses() {
        SQLiteDatabase db = this.getWritableDatabase();
        int doneDelete = 0;
        doneDelete = db.delete(TABLE_ILLNESSES, null , null);
        db.close();
        return doneDelete > 0;

    }
}
