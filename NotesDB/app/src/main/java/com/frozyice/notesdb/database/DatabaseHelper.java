package com.frozyice.notesdb.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.frozyice.notesdb.database.model.Note;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "notes_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating Tables
    //onCreate() will be called only once when the app is installed. In this method, we execute the create table sql statements to create necessary tables.
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create notes table
        db.execSQL(Note.CREATE_TABLE);
    }

    //Upgrading database
    //You have to take care of database migrations here without loosing the older data if necessary. For now, we just drop the older tables and recreate them again.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Note.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    //Inserting Note
    public long insertNote(String note){
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Note.COLUMN_NOTE, note);

        //insert row
        long id = db.insert(Note.TABLE_NAME, null, values);

        //close db connection
        db.close();

        //return newly inserted row id
        return id;
    }

    //Reading Notes
    //getNote() takes already existed note `id` and fetches the note object.
    public Note getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        //SELECT FROM Note.TABLE_NAME WHERE Note.COLUMN_ID=id
        Cursor cursor = db.query(Note.TABLE_NAME,
                new String[]{Note.COLUMN_ID, Note.COLUMN_NOTE, Note.COLUMN_TIMESTAMP},
                Note.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null,null,null);

        if (cursor != null)
            cursor.moveToFirst();

        //prepare note object
        Note note = new Note(
                cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP))
        );

        //close the cursor
        cursor.close();

        return note;
    }

    //getAllNotes() fetches all the notes in descending order by timestamp.
    public List<Node> getAllNotes(){
        List<Node> notes = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Note.TABLE_NAME + " ORDER BY " +
                Note.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase(); //TODO:getReadableDatabase?
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)));
                note.setNote(cursor.getString(cursor.getColumnIndex(Note.COLUMN_NOTE)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));
            } while (cursor.moveToNext()); //Move the cursor to the next row. This method will return false if the cursor is already past the last entry in the result set
        }

        db.close();
        return notes;
    }

    //getNotesCount() returns the count of notes stored in database.
    public int getNotesCount() {
        String countQuery = "SELECT * FROM " + Note.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    //Updating Note
    public int updateNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Note.COLUMN_NOTE, note.getNote());

        //updating row
        return db.update(Note.TABLE_NAME, values, Note.COLUMN_ID + "=?", new String[]{String.valueOf(note.getId())});

    }

    //Deleting Note
    public void deleteNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Note.TABLE_NAME, Note.COLUMN_ID + "=?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }

}
