package com.mytutorials.findwordsgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_PATH = "/data/data/com.mytutorials.findwordsgame/";
    private static final String DATABASE_NAME = "words.db";
    private static final int SCHEMA_VERSION = 1;
    private static final String TABLE_NAME = "words";
    private static final String COLUMN_WORD = "word";
    public static  SQLiteDatabase database = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor fetchData(String arg1){
        String databasePath = DATABASE_PATH + DATABASE_NAME;
        database = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
        database.setVersion(1);
        Cursor cursor=database.rawQuery("select * from "+TABLE_NAME+" where "+COLUMN_WORD+"='"+arg1+"'", null);
        return cursor;
    }
    public void writeData(int _score){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm");
        String currentDateandTime = sdf.format(new Date());
        String databasePath = DATABASE_PATH + DATABASE_NAME;
        database = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
        database.setVersion(1);
        try {
            database.execSQL("CREATE TABLE IF NOT EXISTS scores (score INT,date VARCHAR)");
            ContentValues values = new ContentValues();
            values.put("score",_score);
            values.put("date",currentDateandTime);
            database.insert("scores",null,values);
         //   database.execSQL("INSERT INTO scores(score,date) VALUES ("+_score+","+currentDateandTime+")");
            System.out.println("done");
        }
        catch (Exception e){ e.printStackTrace();}


    }
    /*public void delete(){

        String databasePath = DATABASE_PATH + DATABASE_NAME;
        database = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
        database.setVersion(1);
        database.execSQL("Delete from scores");
    }*/

    public Cursor getCursor() {
        //get data
        String databasePath = DATABASE_PATH + DATABASE_NAME;
        database = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
        database.setVersion(1);
        database.execSQL("CREATE TABLE IF NOT EXISTS scores (score INT,date VARCHAR)");
        Cursor cursor= database.rawQuery("SELECT * FROM scores order by score DESC",null);

        return cursor;
    }
    public ArrayList<Integer> getDataScore(ArrayList<Integer> scoreArrayList,Cursor cursor){
        int scoreIndex=cursor.getColumnIndex("score");
        int i=0;
        while(cursor.moveToNext()){
            // System.out.println("score = "+cursor.getInt(scoreIndex)+"  date= "+cursor.getString(dateIndex));
            scoreArrayList.add(cursor.getInt(scoreIndex));
            i++;
        }
        return scoreArrayList;
    }

    public ArrayList<String> getDataDate(ArrayList<String> dateArrayList,Cursor cursor){
        int dateIndex=cursor.getColumnIndex("date");
        int i=0;
        while(cursor.moveToNext()){
            // System.out.println("score = "+cursor.getInt(scoreIndex)+"  date= "+cursor.getString(dateIndex));
            dateArrayList.add(cursor.getString(dateIndex));
            i++;
        }
        return dateArrayList;
    }


}
