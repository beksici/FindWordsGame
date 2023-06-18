package com.mytutorials.findwordsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreTableActivity extends AppCompatActivity {
    private ListView mListView;
    private ImageView imgCup;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> myData = new ArrayList<>();
    private ArrayList<Integer> scoreArrayList = new ArrayList<>();
    private ArrayList<String> dateArrayList = new ArrayList<>();
    private Cursor cursor;
    private Cursor cursor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);

        mListView = findViewById(R.id.listView);
        imgCup = findViewById(R.id.imgCup);
        imgCup.setImageResource(R.drawable.cup);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        cursor = dbHelper.getCursor();
        cursor1 = dbHelper.getCursor();
        scoreArrayList = dbHelper.getDataScore(scoreArrayList, cursor);
        dateArrayList = dbHelper.getDataDate(dateArrayList, cursor1);

        if (!scoreArrayList.isEmpty() && !dateArrayList.isEmpty()) {
            for (int i = 0; i < scoreArrayList.size(); i++) {
                myData.add(scoreArrayList.get(i).toString() + "\n" + dateArrayList.get(i));
                //System.out.println(scoreArrayList.get(i).toString() + " " + dateArrayList.get(i));
            }
            if (!myData.isEmpty()) {
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myData);
                mListView.setAdapter(adapter);
            }
        } else {
            myData.add("YOU DON'T HAVE ANY SCORE\n\n\t\tLET'S PlAY!");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myData);
            mListView.setAdapter(adapter);
            mListView.setClickable(false);
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ScoreTableActivity.this, FirstPageActivity.class);
        finish();
        startActivity(intent);
    }
}