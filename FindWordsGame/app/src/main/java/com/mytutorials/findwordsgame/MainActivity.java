package com.mytutorials.findwordsgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView iv1_1, iv1_2, iv1_3, iv1_4, iv1_5, iv1_6, iv1_7, iv1_8;
    ImageView iv2_1, iv2_2, iv2_3, iv2_4, iv2_5, iv2_6, iv2_7, iv2_8;
    ImageView iv3_1, iv3_2, iv3_3, iv3_4, iv3_5, iv3_6, iv3_7, iv3_8;
    ImageView iv4_1, iv4_2, iv4_3, iv4_4, iv4_5, iv4_6, iv4_7, iv4_8;
    ImageView iv5_1, iv5_2, iv5_3, iv5_4, iv5_5, iv5_6, iv5_7, iv5_8;
    ImageView iv6_1, iv6_2, iv6_3, iv6_4, iv6_5, iv6_6, iv6_7, iv6_8;
    ImageView iv7_1, iv7_2, iv7_3, iv7_4, iv7_5, iv7_6, iv7_7, iv7_8;
    ImageView iv8_1, iv8_2, iv8_3, iv8_4, iv8_5, iv8_6, iv8_7, iv8_8;
    ImageView iv9_1, iv9_2, iv9_3, iv9_4, iv9_5, iv9_6, iv9_7, iv9_8;
    ImageView iv10_1, iv10_2, iv10_3, iv10_4, iv10_5, iv10_6, iv10_7, iv10_8;
    ImageView iv11_1, iv11_2, iv11_3, iv11_4, iv11_5, iv11_6, iv11_7, iv11_8;
    ImageView blockImage;
    TextView readyText;
    public SQLiteDatabase database;
    int a, b, c, cc, d, e, f, g, gg, h, i, ii, j, k, l, m, n, o, oo, p, r, s, ss, t, u, uu, vv, y, z, back, back1;
    HashMap<String, Integer> scoreOfAlphabeticalMap = new HashMap<>();
    HashMap<Integer, String> whichLettersChooseMap = new HashMap<>();
    ArrayList<ImageView> colomn1 = new ArrayList<>();
    ArrayList<ImageView> colomn2 = new ArrayList<>();
    ArrayList<ImageView> colomn3 = new ArrayList<>();
    ArrayList<ImageView> colomn4 = new ArrayList<>();
    ArrayList<ImageView> colomn5 = new ArrayList<>();
    ArrayList<ImageView> colomn6 = new ArrayList<>();
    ArrayList<ImageView> colomn7 = new ArrayList<>();
    ArrayList<ImageView> colomn8 = new ArrayList<>();
    ArrayList<Integer> letters = new ArrayList<>();
    ArrayList<String> displayText = new ArrayList<>();
    ArrayList<ImageView> selectedImageViews = new ArrayList<>();
    Handler handler = new Handler();
    int beginFallRowCount = 0;
    ArrayList<Integer> randomsRow1 = new ArrayList<>();
    ArrayList<Integer> randomsRow2 = new ArrayList<>();
    ArrayList<Integer> randomsRow3 = new ArrayList<>();
    Button deleteButton, tickButton;
    Random random = new Random();
    boolean clikedSecondcolomn1[] = new boolean[11];
    boolean clikedSecondcolomn2[] = new boolean[11];
    boolean clikedSecondcolomn3[] = new boolean[11];
    boolean clikedSecondcolomn4[] = new boolean[11];
    boolean clikedSecondcolomn5[] = new boolean[11];
    boolean clikedSecondcolomn6[] = new boolean[11];
    boolean clikedSecondcolomn7[] = new boolean[11];
    boolean clikedSecondcolomn8[] = new boolean[11];
    ImageView heart;
    int life = 3, score = 0;
    TextView textheart, textscore, textDisplay;
    boolean gameOver = false;
    //Delay settings
    int delay = 200;
    int secondDelay = 40;
    int timerd = 1800;
    int timerDelay;
    Timer timer0 = new Timer();
    Timer timer1 = new Timer();
    Timer timer2 = new Timer();
    Timer timer3 = new Timer();
    Timer timer4 = new Timer();
    Timer timer5 = new Timer();
    boolean timer1Started = false;
    boolean timer2Started = false;
    boolean timer3Started = false;
    boolean timer4Started = false;
    boolean timer5Started = false;

    ArrayList<Integer> deleteColomn1Indexes = new ArrayList<>();
    ArrayList<Integer> deleteColomn2Indexes = new ArrayList<>();
    ArrayList<Integer> deleteColomn3Indexes = new ArrayList<>();
    ArrayList<Integer> deleteColomn4Indexes = new ArrayList<>();
    ArrayList<Integer> deleteColomn5Indexes = new ArrayList<>();
    ArrayList<Integer> deleteColomn6Indexes = new ArrayList<>();
    ArrayList<Integer> deleteColomn7Indexes = new ArrayList<>();
    ArrayList<Integer> deleteColomn8Indexes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For DB
        DBHelper dbHelper = new DBHelper(getApplicationContext());


        //all colomn second  cliked false
        Arrays.fill(clikedSecondcolomn1, false);
        Arrays.fill(clikedSecondcolomn2, false);
        Arrays.fill(clikedSecondcolomn3, false);
        Arrays.fill(clikedSecondcolomn4, false);
        Arrays.fill(clikedSecondcolomn5, false);
        Arrays.fill(clikedSecondcolomn6, false);
        Arrays.fill(clikedSecondcolomn7, false);
        Arrays.fill(clikedSecondcolomn8, false);


        // connect textviews,Buttons ect.
        deleteButton = findViewById(R.id.deleteButton);
        tickButton = findViewById(R.id.tickButton);
        blockImage = findViewById(R.id.blockImage);
        readyText = findViewById(R.id.textViewsReady);
        heart = findViewById(R.id.heart);
        textheart = findViewById(R.id.textHeart);
        textscore = findViewById(R.id.textScore);
        textDisplay = findViewById(R.id.textDisplay);
        iv1_1 = findViewById(R.id.iv1_1);
        iv1_2 = findViewById(R.id.iv1_2);
        iv1_3 = findViewById(R.id.iv1_3);
        iv1_4 = findViewById(R.id.iv1_4);
        iv1_5 = findViewById(R.id.iv1_5);
        iv1_6 = findViewById(R.id.iv1_6);
        iv1_7 = findViewById(R.id.iv1_7);
        iv1_8 = findViewById(R.id.iv1_8);

        iv2_1 = findViewById(R.id.iv2_1);
        iv2_2 = findViewById(R.id.iv2_2);
        iv2_3 = findViewById(R.id.iv2_3);
        iv2_4 = findViewById(R.id.iv2_4);
        iv2_5 = findViewById(R.id.iv2_5);
        iv2_6 = findViewById(R.id.iv2_6);
        iv2_7 = findViewById(R.id.iv2_7);
        iv2_8 = findViewById(R.id.iv2_8);

        iv3_1 = findViewById(R.id.iv3_1);
        iv3_2 = findViewById(R.id.iv3_2);
        iv3_3 = findViewById(R.id.iv3_3);
        iv3_4 = findViewById(R.id.iv3_4);
        iv3_5 = findViewById(R.id.iv3_5);
        iv3_6 = findViewById(R.id.iv3_6);
        iv3_7 = findViewById(R.id.iv3_7);
        iv3_8 = findViewById(R.id.iv3_8);

        iv4_1 = findViewById(R.id.iv4_1);
        iv4_2 = findViewById(R.id.iv4_2);
        iv4_3 = findViewById(R.id.iv4_3);
        iv4_4 = findViewById(R.id.iv4_4);
        iv4_5 = findViewById(R.id.iv4_5);
        iv4_6 = findViewById(R.id.iv4_6);
        iv4_7 = findViewById(R.id.iv4_7);
        iv4_8 = findViewById(R.id.iv4_8);

        iv5_1 = findViewById(R.id.iv5_1);
        iv5_2 = findViewById(R.id.iv5_2);
        iv5_3 = findViewById(R.id.iv5_3);
        iv5_4 = findViewById(R.id.iv5_4);
        iv5_5 = findViewById(R.id.iv5_5);
        iv5_6 = findViewById(R.id.iv5_6);
        iv5_7 = findViewById(R.id.iv5_7);
        iv5_8 = findViewById(R.id.iv5_8);

        iv6_1 = findViewById(R.id.iv6_1);
        iv6_2 = findViewById(R.id.iv6_2);
        iv6_3 = findViewById(R.id.iv6_3);
        iv6_4 = findViewById(R.id.iv6_4);
        iv6_5 = findViewById(R.id.iv6_5);
        iv6_6 = findViewById(R.id.iv6_6);
        iv6_7 = findViewById(R.id.iv6_7);
        iv6_8 = findViewById(R.id.iv6_8);

        iv7_1 = findViewById(R.id.iv7_1);
        iv7_2 = findViewById(R.id.iv7_2);
        iv7_3 = findViewById(R.id.iv7_3);
        iv7_4 = findViewById(R.id.iv7_4);
        iv7_5 = findViewById(R.id.iv7_5);
        iv7_6 = findViewById(R.id.iv7_6);
        iv7_7 = findViewById(R.id.iv7_7);
        iv7_8 = findViewById(R.id.iv7_8);

        iv8_1 = findViewById(R.id.iv8_1);
        iv8_2 = findViewById(R.id.iv8_2);
        iv8_3 = findViewById(R.id.iv8_3);
        iv8_4 = findViewById(R.id.iv8_4);
        iv8_5 = findViewById(R.id.iv8_5);
        iv8_6 = findViewById(R.id.iv8_6);
        iv8_7 = findViewById(R.id.iv8_7);
        iv8_8 = findViewById(R.id.iv8_8);


        iv9_1 = findViewById(R.id.iv9_1);
        iv9_2 = findViewById(R.id.iv9_2);
        iv9_3 = findViewById(R.id.iv9_3);
        iv9_4 = findViewById(R.id.iv9_4);
        iv9_5 = findViewById(R.id.iv9_5);
        iv9_6 = findViewById(R.id.iv9_6);
        iv9_7 = findViewById(R.id.iv9_7);
        iv9_8 = findViewById(R.id.iv9_8);

        iv10_1 = findViewById(R.id.iv10_1);
        iv10_2 = findViewById(R.id.iv10_2);
        iv10_3 = findViewById(R.id.iv10_3);
        iv10_4 = findViewById(R.id.iv10_4);
        iv10_5 = findViewById(R.id.iv10_5);
        iv10_6 = findViewById(R.id.iv10_6);
        iv10_7 = findViewById(R.id.iv10_7);
        iv10_8 = findViewById(R.id.iv10_8);

        iv11_1 = findViewById(R.id.iv11_1);
        iv11_2 = findViewById(R.id.iv11_2);
        iv11_3 = findViewById(R.id.iv11_3);
        iv11_4 = findViewById(R.id.iv11_4);
        iv11_5 = findViewById(R.id.iv11_5);
        iv11_6 = findViewById(R.id.iv11_6);
        iv11_7 = findViewById(R.id.iv11_7);
        iv11_8 = findViewById(R.id.iv11_8);


        // images trun a number
        imgToNum();
        // score of alphabe
        scoreOfAlphabeticalMap = scoreOfAlphabetic(scoreOfAlphabeticalMap);
        whichLettersChooseMap = StringLetterOfIntImages(whichLettersChooseMap);
        setColomn();

        letters.add(a);
        letters.add(b);
        letters.add(c);
        letters.add(cc);
        letters.add(d);
        letters.add(e);
        letters.add(f);
        letters.add(g);
        letters.add(gg);
        letters.add(h);
        letters.add(i);
        letters.add(ii);
        letters.add(j);
        letters.add(k);
        letters.add(l);
        letters.add(m);
        letters.add(n);
        letters.add(o);
        letters.add(oo);
        letters.add(p);
        letters.add(r);
        letters.add(s);
        letters.add(ss);
        letters.add(t);
        letters.add(u);
        letters.add(uu);
        letters.add(vv);
        letters.add(y);
        letters.add(z);

        //begining settings
        beginSetVisibility();
        setTagAll();
        setEnabletAll(false);

        //wait for 3 rows fall
        deleteButton.setEnabled(false);
        tickButton.setEnabled(false);
        blockImage.setEnabled(false);
        blockImage.setVisibility(View.VISIBLE);
        readyText.setVisibility(View.VISIBLE);
        tickButton.setVisibility(View.INVISIBLE);
        deleteButton.setVisibility(View.INVISIBLE);
        textheart.setVisibility(View.INVISIBLE);
        textscore.setVisibility(View.INVISIBLE);
        heart.setVisibility(View.INVISIBLE);
        heart.setEnabled(false);
        textDisplay.setVisibility(View.INVISIBLE);
        textDisplay.setEnabled(false);

        //generate number for 3 rows
        generateNumberLetters(randomsRow1);
        generateNumberLetters(randomsRow2);
        generateNumberLetters(randomsRow3);
        //BUTTONS
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedImageViews.isEmpty()) {
                    textDisplay.setText("\n");
                    displayText.clear();
                    for (int i = 0; i < selectedImageViews.size(); i++) {
                        selectedImageViews.get(i).setAlpha(1F);
                        Arrays.fill(clikedSecondcolomn1, false);
                        Arrays.fill(clikedSecondcolomn2, false);
                        Arrays.fill(clikedSecondcolomn3, false);
                        Arrays.fill(clikedSecondcolomn4, false);
                        Arrays.fill(clikedSecondcolomn5, false);
                        Arrays.fill(clikedSecondcolomn6, false);
                        Arrays.fill(clikedSecondcolomn7, false);
                        Arrays.fill(clikedSecondcolomn8, false);
                    }

                    selectedImageViews.clear();
                }
            }
        });
        tickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = dbHelper.fetchData(textDisplay.getText().toString().toLowerCase(Locale.forLanguageTag("tr")).replaceAll("\n", ""));

                System.out.println(textDisplay.getText().toString());
                if (cursor.getCount() > 0)
                {//burada database kontrolü yapılmalı textDisplay.getText().toString() içeriyor mu doğru ise ifin içi yanlış ise else
//canımız skorumuz da hesaplanacak atanacak

                    if (!selectedImageViews.isEmpty()) {
                        textDisplay.setText("\n");
                        for (int i = 0; i < selectedImageViews.size(); i++) {
                            selectedImageViews.get(i).setAlpha(1F);
                            Arrays.fill(clikedSecondcolomn1, false);
                            Arrays.fill(clikedSecondcolomn2, false);
                            Arrays.fill(clikedSecondcolomn3, false);
                            Arrays.fill(clikedSecondcolomn4, false);
                            Arrays.fill(clikedSecondcolomn5, false);
                            Arrays.fill(clikedSecondcolomn6, false);
                            Arrays.fill(clikedSecondcolomn7, false);
                            Arrays.fill(clikedSecondcolomn8, false);
                        }

                        score = scoreCalculate(displayText, score);
                        textscore.setText("SCORE: " + score);
                        displayText.clear();
                        for (int i = 0; i < selectedImageViews.size(); i++) {
                            // selectedImageViews.get(i).setVisibility(View.INVISIBLE);
                            // selectedImageViews.get(i).setTag("x");
                            if (colomn1.indexOf(selectedImageViews.get(i)) != -1) {
                                int indexOfLast = colomn1.indexOf(selectedImageViews.get(i));
                                colomn1.get(indexOfLast).setVisibility(View.INVISIBLE);
                                colomn1.get(indexOfLast).setTag("x");
                                deleteColomn1Indexes.add(indexOfLast);
                                //colomn1=deleteEmptyINColomnBottomToTop(colomn1, indexOfLast);
                            } else if (colomn2.indexOf(selectedImageViews.get(i)) != -1) {
                                int indexOfLast = colomn2.indexOf(selectedImageViews.get(i));
                                colomn2.get(indexOfLast).setVisibility(View.INVISIBLE);
                                colomn2.get(indexOfLast).setTag("x");
                                deleteColomn2Indexes.add(indexOfLast);
                                //colomn2=deleteEmptyINColomnBottomToTop(colomn2, indexOfLast);

                            } else if (colomn3.indexOf(selectedImageViews.get(i)) != -1) {
                                int indexOfLast = colomn3.indexOf(selectedImageViews.get(i));
                                colomn3.get(indexOfLast).setVisibility(View.INVISIBLE);
                                colomn3.get(indexOfLast).setTag("x");
                                deleteColomn3Indexes.add(indexOfLast);
                                //colomn3=deleteEmptyINColomnBottomToTop(colomn3, indexOfLast);

                            } else if (colomn4.indexOf(selectedImageViews.get(i)) != -1) {
                                int indexOfLast = colomn4.indexOf(selectedImageViews.get(i));
                                colomn4.get(indexOfLast).setVisibility(View.INVISIBLE);
                                colomn4.get(indexOfLast).setTag("x");
                                deleteColomn4Indexes.add(indexOfLast);
                                //colomn4=deleteEmptyINColomnBottomToTop(colomn4, indexOfLast);

                            } else if (colomn5.indexOf(selectedImageViews.get(i)) != -1) {
                                int indexOfLast = colomn5.indexOf(selectedImageViews.get(i));
                                colomn5.get(indexOfLast).setVisibility(View.INVISIBLE);
                                colomn5.get(indexOfLast).setTag("x");
                                deleteColomn5Indexes.add(indexOfLast);
                                //colomn5= deleteEmptyINColomnBottomToTop(colomn5, indexOfLast);

                            } else if (colomn6.indexOf(selectedImageViews.get(i)) != -1) {
                                int indexOfLast = colomn6.indexOf(selectedImageViews.get(i));
                                colomn6.get(indexOfLast).setVisibility(View.INVISIBLE);
                                colomn6.get(indexOfLast).setTag("x");
                                deleteColomn6Indexes.add(indexOfLast);
                                // colomn6= deleteEmptyINColomnBottomToTop(colomn6, indexOfLast);

                            } else if (colomn7.indexOf(selectedImageViews.get(i)) != -1) {
                                int indexOfLast = colomn7.indexOf(selectedImageViews.get(i));
                                colomn7.get(indexOfLast).setVisibility(View.INVISIBLE);
                                colomn7.get(indexOfLast).setTag("x");
                                deleteColomn7Indexes.add(indexOfLast);
                                // colomn7= deleteEmptyINColomnBottomToTop(colomn7, indexOfLast);

                            } else if (colomn8.indexOf(selectedImageViews.get(i)) != -1) {
                                int indexOfLast = colomn8.indexOf(selectedImageViews.get(i));
                                colomn8.get(indexOfLast).setVisibility(View.INVISIBLE);
                                colomn8.get(indexOfLast).setTag("x");
                                deleteColomn8Indexes.add(indexOfLast);
                                // colomn8= deleteEmptyINColomnBottomToTop(colomn8, indexOfLast);

                            }


                        }

                        if (!deleteColomn1Indexes.isEmpty()) {
                            Collections.sort(deleteColomn1Indexes);
                            for (int i = 0; i < deleteColomn1Indexes.size(); i++) {
                                colomn1 = deleteEmptyINColomnBottomToTop(colomn1, deleteColomn1Indexes.get(i));
                            }
                            deleteColomn1Indexes.clear();
                        }
                        if (!deleteColomn2Indexes.isEmpty()) {
                            Collections.sort(deleteColomn2Indexes);
                            for (int i = 0; i < deleteColomn2Indexes.size(); i++) {
                                colomn2 = deleteEmptyINColomnBottomToTop(colomn2, deleteColomn2Indexes.get(i));
                            }
                            deleteColomn2Indexes.clear();
                        }
                        if (!deleteColomn3Indexes.isEmpty()) {
                            Collections.sort(deleteColomn3Indexes);
                            for (int i = 0; i < deleteColomn3Indexes.size(); i++) {
                                colomn3 = deleteEmptyINColomnBottomToTop(colomn3, deleteColomn3Indexes.get(i));
                            }
                            deleteColomn3Indexes.clear();
                        }
                        if (!deleteColomn4Indexes.isEmpty()) {
                            Collections.sort(deleteColomn4Indexes);
                            for (int i = 0; i < deleteColomn4Indexes.size(); i++) {
                                colomn4 = deleteEmptyINColomnBottomToTop(colomn4, deleteColomn4Indexes.get(i));
                            }
                            deleteColomn4Indexes.clear();
                        }
                        if (!deleteColomn5Indexes.isEmpty()) {
                            Collections.sort(deleteColomn5Indexes);
                            for (int i = 0; i < deleteColomn5Indexes.size(); i++) {
                                colomn5 = deleteEmptyINColomnBottomToTop(colomn5, deleteColomn5Indexes.get(i));
                            }
                            deleteColomn5Indexes.clear();
                        }

                        if (!deleteColomn6Indexes.isEmpty()) {
                            Collections.sort(deleteColomn6Indexes);
                            for (int i = 0; i < deleteColomn6Indexes.size(); i++) {
                                colomn6 = deleteEmptyINColomnBottomToTop(colomn6, deleteColomn6Indexes.get(i));
                            }
                            deleteColomn6Indexes.clear();
                        }

                        if (!deleteColomn7Indexes.isEmpty()) {
                            Collections.sort(deleteColomn7Indexes);
                            for (int i = 0; i < deleteColomn7Indexes.size(); i++) {
                                colomn7 = deleteEmptyINColomnBottomToTop(colomn7, deleteColomn7Indexes.get(i));
                            }
                            deleteColomn7Indexes.clear();
                        }
                        if (!deleteColomn8Indexes.isEmpty()) {
                            Collections.sort(deleteColomn8Indexes);
                            for (int i = 0; i < deleteColomn8Indexes.size(); i++) {
                                colomn8 = deleteEmptyINColomnBottomToTop(colomn8, deleteColomn8Indexes.get(i));
                            }
                            deleteColomn8Indexes.clear();
                        }


                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                colomn1 = deleteEmptyINColomn(colomn1);
                                colomn2 = deleteEmptyINColomn(colomn2);

                                colomn3 = deleteEmptyINColomn(colomn3);
                                colomn4 = deleteEmptyINColomn(colomn4);
                                colomn5 = deleteEmptyINColomn(colomn5);
                                colomn6 = deleteEmptyINColomn(colomn6);
                                colomn7 = deleteEmptyINColomn(colomn7);
                                colomn8 = deleteEmptyINColomn(colomn8);
                            }
                        }, 400);//gecikme süresi senkronizasyonu yapılacak

                        selectedImageViews.clear();

                        //The task for falling periodic with checking score
                        TimerTask task1 = new TimerTask() {
                            @Override
                            public void run() {

                                switch (generateNumberWhichColomn()) {
                                    case 0:
                                        colomn1 = fallImagesViewSetWithPeriod(colomn1, delay, letters.get(generateNumberLetters()), secondDelay);
                                        break;
                                    case 1:
                                        colomn2 = fallImagesViewSetWithPeriod(colomn2, delay, letters.get(generateNumberLetters()), secondDelay);
                                        break;
                                    case 2:
                                        colomn3 = fallImagesViewSetWithPeriod(colomn3, delay, letters.get(generateNumberLetters()), secondDelay);
                                        break;
                                    case 3:
                                        colomn4 = fallImagesViewSetWithPeriod(colomn4, delay, letters.get(generateNumberLetters()), secondDelay);
                                        break;
                                    case 4:
                                        colomn5 = fallImagesViewSetWithPeriod(colomn5, delay, letters.get(generateNumberLetters()), secondDelay);
                                        break;
                                    case 5:
                                        colomn6 = fallImagesViewSetWithPeriod(colomn6, delay, letters.get(generateNumberLetters()), secondDelay);
                                        break;
                                    case 6:
                                        colomn7 = fallImagesViewSetWithPeriod(colomn7, delay, letters.get(generateNumberLetters()), secondDelay);
                                        break;
                                    case 7:
                                        colomn8 = fallImagesViewSetWithPeriod(colomn8, delay, letters.get(generateNumberLetters()), secondDelay);
                                        break;

                                }
                            }

                        };


                        if (score < 100 && timer1Started == false) {
                            timerDelay = 6000;
                            timer1Started = true;
                            timer0.cancel();
                            timer1.schedule(task1, 6000, timerDelay);
                        } else if (score < 200 && score >= 100 && timer2Started == false && timer1Started == true) {
                            timerDelay = 5000;
                            timer2Started = true;
                            timer0.cancel();
                            timer1.cancel();
                            timer2.schedule(task1, 6000, timerDelay);
                        } else if (score < 300 && score >= 200 && timer3Started == false && timer2Started == true && timer1Started == true) {
                            timerDelay = 4000;
                            timer3Started = true;
                            timer0.cancel();
                            timer1.cancel();
                            timer2.cancel();
                            timer3.schedule(task1, 5000, timerDelay);
                        } else if (score < 400 && score >= 300 && timer4Started == false && timer3Started == true && timer2Started == true && timer1Started == true) {
                            timerDelay = 3000;
                            timer4Started = true;
                            timer0.cancel();
                            timer1.cancel();
                            timer2.cancel();
                            timer3.cancel();
                            timer4.schedule(task1, 4000, timerDelay);
                        } else if (score < 500 && score >= 400 && timer5Started == false && timer4Started == true && timer3Started == true && timer2Started == true && timer1Started == true) {
                            timerDelay = 2000;
                            timer5Started = true;
                            timer0.cancel();
                            timer1.cancel();
                            timer2.cancel();
                            timer3.cancel();
                            timer4.cancel();
                            timer5.schedule(task1, 3000, timerDelay);
                        }


                    }
                } else {
                    //can düşecek ,skor hesaplanacak, can sıfıra ulaşırsa satır düşecek ya
                    //tıklanılan şeyler sıfırlanmalı
                    if (!selectedImageViews.isEmpty()) {
                        textDisplay.setText("\n");
                        displayText.clear();
                        for (int i = 0; i < selectedImageViews.size(); i++) {
                            selectedImageViews.get(i).setAlpha(1F);
                            Arrays.fill(clikedSecondcolomn1, false);
                            Arrays.fill(clikedSecondcolomn2, false);
                            Arrays.fill(clikedSecondcolomn3, false);
                            Arrays.fill(clikedSecondcolomn4, false);
                            Arrays.fill(clikedSecondcolomn5, false);
                            Arrays.fill(clikedSecondcolomn6, false);
                            Arrays.fill(clikedSecondcolomn7, false);
                            Arrays.fill(clikedSecondcolomn8, false);
                        }
                        selectedImageViews.clear();
                        if (life != 1) {
                            life--;
                            textheart.setText(String.valueOf(life));
                        } else {
                            life--;
                            if (life == 0) {
                                textheart.setText("3");
                            } else {
                                textheart.setText(String.valueOf(life));
                            }

                        }
                    }

                }

            }
        });


        //fallingImagesViews(colomn3, delay, b, secondDelay);
        beginTimerFalling(randomsRow1, randomsRow2, randomsRow3, delay, secondDelay, timerd);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                readyText.setText("GO!");
                //writing tags for check
                /*
                for (int i = colomn1.size() - 1; i >= 8; i--) {
                   System.out.println((String) colomn1.get(i).getTag());
                    System.out.println((String) colomn2.get(i).getTag());
                    System.out.println((String) colomn3.get(i).getTag());

                    System.out.println((String) colomn4.get(i).getTag());
                    System.out.println((String) colomn5.get(i).getTag());
                    System.out.println((String) colomn6.get(i).getTag());
                    System.out.println((String) colomn7.get(i).getTag());
                    System.out.println((String) colomn8.get(i).getTag());

                }*/
                readyText.setVisibility(View.GONE);
                blockImage.setVisibility(View.GONE);
                setEnabletAll(true);
                deleteButton.setEnabled(true);
                deleteButton.setVisibility(View.VISIBLE);
                tickButton.setEnabled(true);
                tickButton.setVisibility(View.VISIBLE);
                textheart.setVisibility(View.VISIBLE);
                textscore.setVisibility(View.VISIBLE);
                heart.setVisibility(View.VISIBLE);
                textDisplay.setVisibility(View.VISIBLE);

            }
        }, 3 * timerd + 100);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                colomn1.get(10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[10]);
                        if (clikedSecondcolomn1[10] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(10).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(10).setAlpha(0.3F);
                            clikedSecondcolomn1[10] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(10));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(10),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(10).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(10));


                            clikedSecondcolomn1[10] = false;
                            colomn1.get(10).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[10]);
                        if (clikedSecondcolomn1[9] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(9).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(9).setAlpha(0.3F);
                            clikedSecondcolomn1[9] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(9));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(10),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(9).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(9));


                            clikedSecondcolomn1[9] = false;
                            colomn1.get(9).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(8).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[8]);
                        if (clikedSecondcolomn1[8] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(8).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(8).setAlpha(0.3F);
                            clikedSecondcolomn1[8] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(8));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(8),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(8).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(8));


                            clikedSecondcolomn1[8] = false;
                            colomn1.get(8).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(7).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[7]);
                        if (clikedSecondcolomn1[7] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(7).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(7).setAlpha(0.3F);
                            clikedSecondcolomn1[7] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(7));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(7),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(7).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(7));


                            clikedSecondcolomn1[7] = false;
                            colomn1.get(7).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(6).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[6]);
                        if (clikedSecondcolomn1[6] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(6).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(6).setAlpha(0.3F);
                            clikedSecondcolomn1[6] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(6));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(6),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(6).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(6));


                            clikedSecondcolomn1[6] = false;
                            colomn1.get(6).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(5).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[5]);
                        if (clikedSecondcolomn1[5] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(5).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(5).setAlpha(0.3F);
                            clikedSecondcolomn1[5] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(5));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(5),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(5).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(5));


                            clikedSecondcolomn1[5] = false;
                            colomn1.get(5).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[4]);
                        if (clikedSecondcolomn1[4] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(4).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(4).setAlpha(0.3F);
                            clikedSecondcolomn1[4] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(4));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(4),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(4).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(4));


                            clikedSecondcolomn1[4] = false;
                            colomn1.get(4).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[3]);
                        if (clikedSecondcolomn1[3] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(3).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(3).setAlpha(0.3F);
                            clikedSecondcolomn1[3] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(3));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(3),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(3).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(3));


                            clikedSecondcolomn1[3] = false;
                            colomn1.get(3).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[2]);
                        if (clikedSecondcolomn1[2] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(2).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(2).setAlpha(0.3F);
                            clikedSecondcolomn1[2] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(2));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(2),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(2).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(2));


                            clikedSecondcolomn1[2] = false;
                            colomn1.get(2).setAlpha(1F);
                        }
                    }
                });

                colomn1.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  System.out.println(clikedSecondcolomn1[1]);
                        if (clikedSecondcolomn1[1] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn1.get(1).getTag().toString());
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn1.get(1).setAlpha(0.3F);
                            clikedSecondcolomn1[1] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn1.get(1));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(1),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn1.get(1).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn1.get(1));


                            clikedSecondcolomn1[1] = false;
                            colomn1.get(1).setAlpha(1F);
                        }
                    }
                });


                colomn2.get(10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[10]);
                        if (clikedSecondcolomn2[10] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(10).getTag().toString());
                            //  int whichColomn = 2;
                            //  int whichRow = 10;
                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(10).setAlpha(0.3F);
                            clikedSecondcolomn2[10] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(10));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(10),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(10).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(10));

                            clikedSecondcolomn2[10] = false;
                            colomn2.get(10).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[9]);
                        if (clikedSecondcolomn2[9] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(9).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(9).setAlpha(0.3F);
                            clikedSecondcolomn2[9] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(9));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(9),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(9).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(9));

                            clikedSecondcolomn2[9] = false;
                            colomn2.get(9).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(8).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[8]);
                        if (clikedSecondcolomn2[8] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(8).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(8).setAlpha(0.3F);
                            clikedSecondcolomn2[8] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(8));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(8),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(8).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(8));

                            clikedSecondcolomn2[8] = false;
                            colomn2.get(8).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(7).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[7]);
                        if (clikedSecondcolomn2[7] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(7).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(7).setAlpha(0.3F);
                            clikedSecondcolomn2[7] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(7));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(7),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(7).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(7));

                            clikedSecondcolomn2[7] = false;
                            colomn2.get(7).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(6).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[6]);
                        if (clikedSecondcolomn2[6] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(6).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(6).setAlpha(0.3F);
                            clikedSecondcolomn2[6] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(6));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(6),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(6).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(6));

                            clikedSecondcolomn2[6] = false;
                            colomn2.get(6).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(5).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[5]);
                        if (clikedSecondcolomn2[5] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(5).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(5).setAlpha(0.3F);
                            clikedSecondcolomn2[5] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(5));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(5),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(5).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(5));

                            clikedSecondcolomn2[5] = false;
                            colomn2.get(5).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[4]);
                        if (clikedSecondcolomn2[4] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(4).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(4).setAlpha(0.3F);
                            clikedSecondcolomn2[4] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(4));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(4),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(4).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(4));

                            clikedSecondcolomn2[4] = false;
                            colomn2.get(4).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[3]);
                        if (clikedSecondcolomn2[3] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(3).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(3).setAlpha(0.3F);
                            clikedSecondcolomn2[3] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(3));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(3),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(3).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(3));

                            clikedSecondcolomn2[3] = false;
                            colomn2.get(3).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[2]);
                        if (clikedSecondcolomn2[2] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(2).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(2).setAlpha(0.3F);
                            clikedSecondcolomn2[2] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(2));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(2),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(2).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(2));

                            clikedSecondcolomn2[2] = false;
                            colomn2.get(2).setAlpha(1F);
                        }
                    }
                });

                colomn2.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[1]);
                        if (clikedSecondcolomn2[1] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn2.get(1).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn2.get(1).setAlpha(0.3F);
                            clikedSecondcolomn2[1] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn2.get(1));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(1),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn2.get(1).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn2.get(1));

                            clikedSecondcolomn2[1] = false;
                            colomn2.get(1).setAlpha(1F);
                        }
                    }
                });


                colomn3.get(10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    System.out.println(clikedSecondcolomn1[3]);
                        if (clikedSecondcolomn3[10] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(10).getTag().toString());

                            // System.out.println(  whichLettersChooseMap.get(whichLettersClicked));
                            //textviewde göster veya arraylistine atılacak
                            colomn3.get(10).setAlpha(0.3F);
                            clikedSecondcolomn3[10] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(10));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn1.get(3),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn3.get(10).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(10));

                            clikedSecondcolomn3[10] = false;
                            colomn3.get(10).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn3[9] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(9).getTag().toString());

                            colomn3.get(9).setAlpha(0.3F);
                            clikedSecondcolomn3[9] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(9));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn3.get(9).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(9));

                            clikedSecondcolomn3[9] = false;
                            colomn3.get(9).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(8).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn3[8] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(8).getTag().toString());

                            colomn3.get(8).setAlpha(0.3F);
                            clikedSecondcolomn3[8] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(8));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn3.get(8).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(8));

                            clikedSecondcolomn3[8] = false;
                            colomn3.get(8).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(7).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn3[7] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(7).getTag().toString());

                            colomn3.get(7).setAlpha(0.3F);
                            clikedSecondcolomn3[7] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(7));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn3.get(7).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(7));

                            clikedSecondcolomn3[7] = false;
                            colomn3.get(7).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(6).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn3[6] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(6).getTag().toString());

                            colomn3.get(6).setAlpha(0.3F);
                            clikedSecondcolomn3[6] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(6));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn3.get(6).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(6));

                            clikedSecondcolomn3[6] = false;
                            colomn3.get(6).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(5).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn3[5] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(5).getTag().toString());

                            colomn3.get(5).setAlpha(0.3F);
                            clikedSecondcolomn3[5] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(5));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn3.get(5).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(5));

                            clikedSecondcolomn3[5] = false;
                            colomn3.get(5).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn3[4] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(4).getTag().toString());

                            colomn3.get(4).setAlpha(0.3F);
                            clikedSecondcolomn3[4] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(4));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn3.get(4).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(4));

                            clikedSecondcolomn3[4] = false;
                            colomn3.get(4).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn3[3] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(3).getTag().toString());

                            colomn3.get(3).setAlpha(0.3F);
                            clikedSecondcolomn3[3] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(3));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn3.get(3).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(3));

                            clikedSecondcolomn3[3] = false;
                            colomn3.get(3).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn3[2] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(2).getTag().toString());

                            colomn3.get(2).setAlpha(0.3F);
                            clikedSecondcolomn3[2] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(2));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn3.get(2),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn3.get(2).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(2));


                            clikedSecondcolomn3[2] = false;
                            colomn3.get(2).setAlpha(1F);
                        }
                    }
                });

                colomn3.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn3[1] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn3.get(1).getTag().toString());

                            colomn3.get(1).setAlpha(0.3F);
                            clikedSecondcolomn3[1] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn3.get(1));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn3.get(1),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn3.get(1).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn3.get(1));


                            clikedSecondcolomn3[1] = false;
                            colomn3.get(1).setAlpha(1F);
                        }
                    }
                });


                colomn4.get(10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn4[10] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(10).getTag().toString());


                            colomn4.get(10).setAlpha(0.3F);
                            clikedSecondcolomn4[10] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(10));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn4.get(10).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(10));

                            clikedSecondcolomn4[10] = false;
                            colomn4.get(10).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn4[9] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(9).getTag().toString());

                            colomn4.get(9).setAlpha(0.3F);
                            clikedSecondcolomn4[9] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(9));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn4.get(9).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(9));

                            clikedSecondcolomn4[9] = false;
                            colomn4.get(9).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(8).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn4[8] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(8).getTag().toString());

                            colomn4.get(8).setAlpha(0.3F);
                            clikedSecondcolomn4[8] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(8));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn4.get(8).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(8));

                            clikedSecondcolomn4[8] = false;
                            colomn4.get(8).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(7).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn4[7] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(7).getTag().toString());

                            colomn4.get(7).setAlpha(0.3F);
                            clikedSecondcolomn4[7] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(7));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn4.get(7).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(7));

                            clikedSecondcolomn4[7] = false;
                            colomn4.get(7).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(6).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn4[6] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(6).getTag().toString());

                            colomn4.get(6).setAlpha(0.3F);
                            clikedSecondcolomn4[6] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(6));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn4.get(6).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(6));

                            clikedSecondcolomn4[6] = false;
                            colomn4.get(6).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(5).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn4[5] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(5).getTag().toString());

                            colomn4.get(5).setAlpha(0.3F);
                            clikedSecondcolomn4[5] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(5));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn4.get(5).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(5));

                            clikedSecondcolomn4[5] = false;
                            colomn4.get(5).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn4[4] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(4).getTag().toString());

                            colomn4.get(4).setAlpha(0.3F);
                            clikedSecondcolomn4[4] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(4));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn4.get(4).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(4));

                            clikedSecondcolomn4[4] = false;
                            colomn4.get(4).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn4[3] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(3).getTag().toString());

                            colomn4.get(3).setAlpha(0.3F);
                            clikedSecondcolomn4[3] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(3));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn4.get(3).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(3));

                            clikedSecondcolomn4[3] = false;
                            colomn4.get(3).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn4[2] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(2).getTag().toString());

                            colomn4.get(2).setAlpha(0.3F);
                            clikedSecondcolomn4[2] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(2));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn4.get(2),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn4.get(2).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(2));


                            clikedSecondcolomn4[2] = false;
                            colomn4.get(2).setAlpha(1F);
                        }
                    }
                });

                colomn4.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn4[1] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn4.get(1).getTag().toString());

                            colomn4.get(1).setAlpha(0.3F);
                            clikedSecondcolomn4[1] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn4.get(1));
                            //burada bir fonksiyon olmalı tıklanılan resmi ve nereye tıklanıldığını göndereceğiz
                            //çünkü onaylama butonuna bastığında doğru ise silecek resmi ve invisible yapıcak
                            //  function(colomn4.get(1),whichColomn,whichRow)
                        } else {
                            //textviewden silveya arraylistinden  silinicek
                            int whichLettersClicked = Integer.parseInt(colomn4.get(1).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn4.get(1));


                            clikedSecondcolomn4[1] = false;
                            colomn4.get(1).setAlpha(1F);
                        }
                    }
                });


                colomn5.get(10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn5[10] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(10).getTag().toString());


                            colomn5.get(10).setAlpha(0.3F);
                            clikedSecondcolomn5[10] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(10));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(10).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(10));

                            clikedSecondcolomn5[10] = false;
                            colomn5.get(10).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn5[9] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(9).getTag().toString());

                            colomn5.get(9).setAlpha(0.3F);
                            clikedSecondcolomn5[9] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(9));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(9).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(9));

                            clikedSecondcolomn5[9] = false;
                            colomn5.get(9).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(8).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn5[8] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(8).getTag().toString());

                            colomn5.get(8).setAlpha(0.3F);
                            clikedSecondcolomn5[8] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(8));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(8).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(8));

                            clikedSecondcolomn5[8] = false;
                            colomn5.get(8).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(7).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn5[7] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(7).getTag().toString());

                            colomn5.get(7).setAlpha(0.3F);
                            clikedSecondcolomn5[7] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(7));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(7).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(7));

                            clikedSecondcolomn5[7] = false;
                            colomn5.get(7).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(6).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn5[6] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(6).getTag().toString());

                            colomn5.get(6).setAlpha(0.3F);
                            clikedSecondcolomn5[6] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(6));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(6).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(6));

                            clikedSecondcolomn5[6] = false;
                            colomn5.get(6).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(5).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn5[5] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(5).getTag().toString());

                            colomn5.get(5).setAlpha(0.3F);
                            clikedSecondcolomn5[5] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(5));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(5).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(5));

                            clikedSecondcolomn5[5] = false;
                            colomn5.get(5).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn5[4] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(4).getTag().toString());

                            colomn5.get(4).setAlpha(0.3F);
                            clikedSecondcolomn5[4] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(4));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(4).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(4));

                            clikedSecondcolomn5[4] = false;
                            colomn5.get(4).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn5[3] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(3).getTag().toString());

                            colomn5.get(3).setAlpha(0.3F);
                            clikedSecondcolomn5[3] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(3));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(3).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(3));

                            clikedSecondcolomn5[3] = false;
                            colomn5.get(3).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn5[2] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(2).getTag().toString());

                            colomn5.get(2).setAlpha(0.3F);
                            clikedSecondcolomn5[2] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(2));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(2).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(2));


                            clikedSecondcolomn5[2] = false;
                            colomn5.get(2).setAlpha(1F);
                        }
                    }
                });

                colomn5.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn5[1] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn5.get(1).getTag().toString());

                            colomn5.get(1).setAlpha(0.3F);
                            clikedSecondcolomn5[1] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn5.get(1));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn5.get(1).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn5.get(1));


                            clikedSecondcolomn5[1] = false;
                            colomn5.get(1).setAlpha(1F);
                        }
                    }
                });


                colomn6.get(10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn6[10] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(10).getTag().toString());


                            colomn6.get(10).setAlpha(0.3F);
                            clikedSecondcolomn6[10] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(10));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(10).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(10));

                            clikedSecondcolomn6[10] = false;
                            colomn6.get(10).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn6[9] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(9).getTag().toString());

                            colomn6.get(9).setAlpha(0.3F);
                            clikedSecondcolomn6[9] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(9));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(9).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(9));

                            clikedSecondcolomn6[9] = false;
                            colomn6.get(9).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(8).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn6[8] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(8).getTag().toString());

                            colomn6.get(8).setAlpha(0.3F);
                            clikedSecondcolomn6[8] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(8));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(8).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(8));

                            clikedSecondcolomn6[8] = false;
                            colomn6.get(8).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(7).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn6[7] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(7).getTag().toString());

                            colomn6.get(7).setAlpha(0.3F);
                            clikedSecondcolomn6[7] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(7));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(7).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(7));

                            clikedSecondcolomn6[7] = false;
                            colomn6.get(7).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(6).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn6[6] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(6).getTag().toString());

                            colomn6.get(6).setAlpha(0.3F);
                            clikedSecondcolomn6[6] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(6));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(6).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(6));

                            clikedSecondcolomn6[6] = false;
                            colomn6.get(6).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(5).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn6[5] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(5).getTag().toString());

                            colomn6.get(5).setAlpha(0.3F);
                            clikedSecondcolomn6[5] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(5));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(5).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(5));

                            clikedSecondcolomn6[5] = false;
                            colomn6.get(5).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn6[4] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(4).getTag().toString());

                            colomn6.get(4).setAlpha(0.3F);
                            clikedSecondcolomn6[4] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(4));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(4).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(4));

                            clikedSecondcolomn6[4] = false;
                            colomn6.get(4).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn6[3] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(3).getTag().toString());

                            colomn6.get(3).setAlpha(0.3F);
                            clikedSecondcolomn6[3] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(3));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(3).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(3));

                            clikedSecondcolomn6[3] = false;
                            colomn6.get(3).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn6[2] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(2).getTag().toString());

                            colomn6.get(2).setAlpha(0.3F);
                            clikedSecondcolomn6[2] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(2));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(2).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(2));


                            clikedSecondcolomn6[2] = false;
                            colomn6.get(2).setAlpha(1F);
                        }
                    }
                });

                colomn6.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn6[1] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn6.get(1).getTag().toString());

                            colomn6.get(1).setAlpha(0.3F);
                            clikedSecondcolomn6[1] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn6.get(1));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn6.get(1).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn6.get(1));


                            clikedSecondcolomn6[1] = false;
                            colomn6.get(1).setAlpha(1F);
                        }
                    }
                });


                colomn7.get(10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn7[10] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(10).getTag().toString());


                            colomn7.get(10).setAlpha(0.3F);
                            clikedSecondcolomn7[10] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(10));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(10).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(10));

                            clikedSecondcolomn7[10] = false;
                            colomn7.get(10).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn7[9] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(9).getTag().toString());

                            colomn7.get(9).setAlpha(0.3F);
                            clikedSecondcolomn7[9] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(9));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(9).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(9));

                            clikedSecondcolomn7[9] = false;
                            colomn7.get(9).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(8).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn7[8] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(8).getTag().toString());

                            colomn7.get(8).setAlpha(0.3F);
                            clikedSecondcolomn7[8] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(8));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(8).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(8));

                            clikedSecondcolomn7[8] = false;
                            colomn7.get(8).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(7).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn7[7] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(7).getTag().toString());

                            colomn7.get(7).setAlpha(0.3F);
                            clikedSecondcolomn7[7] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(7));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(7).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(7));

                            clikedSecondcolomn7[7] = false;
                            colomn7.get(7).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(6).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn7[6] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(6).getTag().toString());

                            colomn7.get(6).setAlpha(0.3F);
                            clikedSecondcolomn7[6] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(6));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(6).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(6));

                            clikedSecondcolomn7[6] = false;
                            colomn7.get(6).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(5).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn7[5] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(5).getTag().toString());

                            colomn7.get(5).setAlpha(0.3F);
                            clikedSecondcolomn7[5] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(5));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(5).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(5));

                            clikedSecondcolomn7[5] = false;
                            colomn7.get(5).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn7[4] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(4).getTag().toString());

                            colomn7.get(4).setAlpha(0.3F);
                            clikedSecondcolomn7[4] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(4));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(4).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(4));

                            clikedSecondcolomn7[4] = false;
                            colomn7.get(4).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn7[3] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(3).getTag().toString());

                            colomn7.get(3).setAlpha(0.3F);
                            clikedSecondcolomn7[3] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(3));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(3).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(3));

                            clikedSecondcolomn7[3] = false;
                            colomn7.get(3).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn7[2] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(2).getTag().toString());

                            colomn7.get(2).setAlpha(0.3F);
                            clikedSecondcolomn7[2] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(2));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(2).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(2));


                            clikedSecondcolomn7[2] = false;
                            colomn7.get(2).setAlpha(1F);
                        }
                    }
                });

                colomn7.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn7[1] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn7.get(1).getTag().toString());

                            colomn7.get(1).setAlpha(0.3F);
                            clikedSecondcolomn7[1] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn7.get(1));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn7.get(1).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn7.get(1));


                            clikedSecondcolomn7[1] = false;
                            colomn7.get(1).setAlpha(1F);
                        }
                    }
                });


                colomn8.get(10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn8[10] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(10).getTag().toString());


                            colomn8.get(10).setAlpha(0.3F);
                            clikedSecondcolomn8[10] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(10));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(10).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(10));

                            clikedSecondcolomn8[10] = false;
                            colomn8.get(10).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn8[9] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(9).getTag().toString());

                            colomn8.get(9).setAlpha(0.3F);
                            clikedSecondcolomn8[9] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(9));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(9).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(9));

                            clikedSecondcolomn8[9] = false;
                            colomn8.get(9).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(8).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn8[8] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(8).getTag().toString());

                            colomn8.get(8).setAlpha(0.3F);
                            clikedSecondcolomn8[8] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(8));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(8).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(8));

                            clikedSecondcolomn8[8] = false;
                            colomn8.get(8).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(7).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn8[7] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(7).getTag().toString());

                            colomn8.get(7).setAlpha(0.3F);
                            clikedSecondcolomn8[7] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(7));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(7).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(7));

                            clikedSecondcolomn8[7] = false;
                            colomn8.get(7).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(6).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn8[6] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(6).getTag().toString());

                            colomn8.get(6).setAlpha(0.3F);
                            clikedSecondcolomn8[6] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(6));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(6).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(6));

                            clikedSecondcolomn8[6] = false;
                            colomn8.get(6).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(5).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn8[5] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(5).getTag().toString());

                            colomn8.get(5).setAlpha(0.3F);
                            clikedSecondcolomn8[5] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(5));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(5).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(5));

                            clikedSecondcolomn8[5] = false;
                            colomn8.get(5).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(4).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn8[4] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(4).getTag().toString());

                            colomn8.get(4).setAlpha(0.3F);
                            clikedSecondcolomn8[4] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(4));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(4).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(4));

                            clikedSecondcolomn8[4] = false;
                            colomn8.get(4).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clikedSecondcolomn8[3] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(3).getTag().toString());

                            colomn8.get(3).setAlpha(0.3F);
                            clikedSecondcolomn8[3] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(3));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(3).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(3));

                            clikedSecondcolomn8[3] = false;
                            colomn8.get(3).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn8[2] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(2).getTag().toString());

                            colomn8.get(2).setAlpha(0.3F);
                            clikedSecondcolomn8[2] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(2));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(2).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(2));


                            clikedSecondcolomn8[2] = false;
                            colomn8.get(2).setAlpha(1F);
                        }
                    }
                });

                colomn8.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikedSecondcolomn8[1] == false) {
                            int whichLettersClicked = Integer.parseInt(colomn8.get(1).getTag().toString());

                            colomn8.get(1).setAlpha(0.3F);
                            clikedSecondcolomn8[1] = true;
                            displayText.add(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            textDisplay.setText("\n");
                            for (int i = 0; i < displayText.size(); i++) {
                                textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                            }
                            selectedImageViews.add(colomn8.get(1));

                        } else {

                            int whichLettersClicked = Integer.parseInt(colomn8.get(1).getTag().toString());
                            int lastIndex = displayText.lastIndexOf(whichLettersChooseMap.get(whichLettersClicked).toString().toUpperCase(Locale.forLanguageTag("tr")));
                            displayText.remove(lastIndex);
                            if (!displayText.isEmpty()) {
                                textDisplay.setText("\n");
                                for (int i = 0; i < displayText.size(); i++) {
                                    textDisplay.setText(textDisplay.getText().toString() + displayText.get(i));
                                }
                            } else textDisplay.setText("\n");

                            selectedImageViews.remove(colomn8.get(1));


                            clikedSecondcolomn8[1] = false;
                            colomn8.get(1).setAlpha(1F);
                        }
                    }
                });


            }
        }, 3 * timerd + 200);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TimerTask task1 = new TimerTask() {
                    @Override
                    public void run() {
                        switch (generateNumberWhichColomn()) {
                            case 0:
                                colomn1 = fallImagesViewSetWithPeriod(colomn1, delay, letters.get(generateNumberLetters()), secondDelay);
                                break;
                            case 1:
                                colomn2 = fallImagesViewSetWithPeriod(colomn2, delay, letters.get(generateNumberLetters()), secondDelay);
                                break;
                            case 2:
                                colomn3 = fallImagesViewSetWithPeriod(colomn3, delay, letters.get(generateNumberLetters()), secondDelay);
                                break;
                            case 3:
                                colomn4 = fallImagesViewSetWithPeriod(colomn4, delay, letters.get(generateNumberLetters()), secondDelay);
                                break;
                            case 4:
                                colomn5 = fallImagesViewSetWithPeriod(colomn5, delay, letters.get(generateNumberLetters()), secondDelay);
                                break;
                            case 5:
                                colomn6 = fallImagesViewSetWithPeriod(colomn6, delay, letters.get(generateNumberLetters()), secondDelay);
                                break;
                            case 6:
                                colomn7 = fallImagesViewSetWithPeriod(colomn7, delay, letters.get(generateNumberLetters()), secondDelay);
                                break;
                            case 7:
                                colomn8 = fallImagesViewSetWithPeriod(colomn8, delay, letters.get(generateNumberLetters()), secondDelay);
                                break;
                        }
                    }
                };
                timer0.schedule(task1, 0, 6000);
            }
        }, 3 * timerd + 300);


        //  beginTimerFalling(colomn3, delay, c, secondDelay, timerd);
       /* for (int i = 0; i < 3; i++) {
            beginTimerFalling( colomn3,delay,c, secondDelay, timerd);
            timerd += timerd;
        }
     /*   new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                fallingImagesViews(colomn3, delay,b,secondDelay);
                fallingImagesViews(colomn2, delay,b,secondDelay);
                fallingImagesViews(colomn4, delay,b,secondDelay);
                fallingImagesViews(colomn1, delay,b,secondDelay);
                fallingImagesViews(colomn5, delay,b,secondDelay);
                fallingImagesViews(colomn6, delay,b,secondDelay);
                fallingImagesViews(colomn7, delay,b,secondDelay);
                fallingImagesViews(colomn8, delay,b,secondDelay);
            }
        }, 7000);/*
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                fallingImagesViews(colomn3,delay,b);
                fallingImagesViews(colomn2,delay,b);
                fallingImagesViews(colomn4,delay,b);
                fallingImagesViews(colomn1,delay,b);
                fallingImagesViews(colomn5,delay,b);
                fallingImagesViews(colomn6,delay,b);
                fallingImagesViews(colomn7,delay,b);
                fallingImagesViews(colomn8,delay,b);
            }
        }, 10500);
/*handler.post(new Runnable() {
    @Override
    public synchronized void run() {
        fallingImagesViews(colomn3,delay,b);

    }
});
/*
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                fallingImagesViews(colomn3,delay,b);
                fallingImagesViews(colomn2,delay,b);
                fallingImagesViews(colomn4,delay,b);
                fallingImagesViews(colomn1,delay,b);
                fallingImagesViews(colomn5,delay,b);
                fallingImagesViews(colomn6,delay,b);
                fallingImagesViews(colomn7,delay,b);
                fallingImagesViews(colomn8,delay,b);

            }
        },1000);
*/



      /* Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                for (int i=0; i <colomn1.size();i++){
                    if(i!=colomn1.size()-1)
                    animateFall(colomn1.get(i),colomn1.get(i+1));
                   if(i==0) {colomn1.get(i).setImageResource(a);}
else { colomn1.get(i-1).setImageResource(back1);
colomn1.get(i).setImageResource(a);
}
                }
                animateFall(iv2_1, iv10_1, b, 2, 2000);
            }
        },5000);
*/

/*
        iv11_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFall(iv2_1, iv10_1, b, 2, 2000);

            }
        });
*/

    }

    private void beginSetVisibility() {
        for (int i = 0; i < colomn1.size(); i++) {
            colomn1.get(i).setVisibility(View.INVISIBLE);
            colomn2.get(i).setVisibility(View.INVISIBLE);
            colomn3.get(i).setVisibility(View.INVISIBLE);

            colomn4.get(i).setVisibility(View.INVISIBLE);
            colomn5.get(i).setVisibility(View.INVISIBLE);
            colomn6.get(i).setVisibility(View.INVISIBLE);
            colomn7.get(i).setVisibility(View.INVISIBLE);
            colomn8.get(i).setVisibility(View.INVISIBLE);

        }
    }

    private void beginTimerFalling(ArrayList<Integer> randomsRow1, ArrayList<Integer> randomsRow2, ArrayList<Integer> randomsRow3, int delay, int secondDelay, int period) //ArrayList<ImageView> colomn geliyordu normalde ve kolona göre ayarlıyorsun -- int image ile de göndereceğen resim
    {
        Timer timer1 = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                beginFallRowCount++;
                if (beginFallRowCount < 4) {
                    switch (beginFallRowCount) {
                        case 1:
                            colomn1 = fallingImagesViews(colomn1, delay, randomsRow1.get(0), secondDelay);
                            colomn2 = fallingImagesViews(colomn2, delay, randomsRow1.get(1), secondDelay);
                            colomn3 = fallingImagesViews(colomn3, delay, randomsRow1.get(2), secondDelay);
                            colomn4 = fallingImagesViews(colomn4, delay, randomsRow1.get(3), secondDelay);
                            colomn5 = fallingImagesViews(colomn5, delay, randomsRow1.get(4), secondDelay);
                            colomn6 = fallingImagesViews(colomn6, delay, randomsRow1.get(5), secondDelay);
                            colomn7 = fallingImagesViews(colomn7, delay, randomsRow1.get(6), secondDelay);
                            colomn8 = fallingImagesViews(colomn8, delay, randomsRow1.get(7), secondDelay);

                            break;
                        case 2:
                            colomn1 = fallingImagesViews(colomn1, delay, randomsRow2.get(0), secondDelay);
                            colomn2 = fallingImagesViews(colomn2, delay, randomsRow2.get(1), secondDelay);
                            colomn3 = fallingImagesViews(colomn3, delay, randomsRow2.get(2), secondDelay);
                            colomn4 = fallingImagesViews(colomn4, delay, randomsRow2.get(3), secondDelay);
                            colomn5 = fallingImagesViews(colomn5, delay, randomsRow2.get(4), secondDelay);
                            colomn6 = fallingImagesViews(colomn6, delay, randomsRow2.get(5), secondDelay);
                            colomn7 = fallingImagesViews(colomn7, delay, randomsRow2.get(6), secondDelay);
                            colomn8 = fallingImagesViews(colomn8, delay, randomsRow2.get(7), secondDelay);
                            break;
                        case 3:
                            colomn1 = fallingImagesViews(colomn1, delay, randomsRow3.get(0), secondDelay);
                            colomn2 = fallingImagesViews(colomn2, delay, randomsRow3.get(1), secondDelay);
                            colomn3 = fallingImagesViews(colomn3, delay, randomsRow3.get(2), secondDelay);
                            colomn4 = fallingImagesViews(colomn4, delay, randomsRow3.get(3), secondDelay);
                            colomn5 = fallingImagesViews(colomn5, delay, randomsRow3.get(4), secondDelay);
                            colomn6 = fallingImagesViews(colomn6, delay, randomsRow3.get(5), secondDelay);
                            colomn7 = fallingImagesViews(colomn7, delay, randomsRow3.get(6), secondDelay);
                            colomn8 = fallingImagesViews(colomn8, delay, randomsRow3.get(7), secondDelay);
                            break;

                    }


                } else {
                    timer1.cancel();
                    beginFallRowCount = 0;
                }

            }
        };
        timer1.schedule(task1, 0, period);

    }


    private void imgToNum() {
        a = R.drawable.a;
        b = R.drawable.b;
        c = R.drawable.c;
        cc = R.drawable.cc;
        d = R.drawable.d;
        e = R.drawable.e;
        f = R.drawable.f;
        g = R.drawable.g;
        gg = R.drawable.gg;
        h = R.drawable.h;
        i = R.drawable.i;
        ii = R.drawable.ii;
        j = R.drawable.j;
        k = R.drawable.k;
        l = R.drawable.l;
        m = R.drawable.m;
        n = R.drawable.n;
        o = R.drawable.o;
        oo = R.drawable.oo;
        p = R.drawable.p;
        r = R.drawable.r;
        s = R.drawable.s;
        ss = R.drawable.ss;
        t = R.drawable.t;
        u = R.drawable.u;
        uu = R.drawable.uu;
        vv = R.drawable.v;
        y = R.drawable.y;
        z = R.drawable.z;
        back = R.drawable.back;
        back1 = R.drawable.back1;
    }

    private HashMap scoreOfAlphabetic(HashMap<String, Integer> hashMap) {
        hashMap.put("a", 1);
        hashMap.put("b", 3);
        hashMap.put("c", 4);
        hashMap.put("ç", 4);
        hashMap.put("d", 3);
        hashMap.put("e", 1);
        hashMap.put("f", 7);
        hashMap.put("g", 5);
        hashMap.put("ğ", 8);
        hashMap.put("h", 5);
        hashMap.put("i", 2);
        hashMap.put("ii", 1);
        hashMap.put("j", 10);
        hashMap.put("k", 1);
        hashMap.put("l", 1);
        hashMap.put("m", 2);
        hashMap.put("n", 1);
        hashMap.put("o", 2);
        hashMap.put("ö", 7);
        hashMap.put("p", 5);
        hashMap.put("r", 1);
        hashMap.put("s", 2);
        hashMap.put("ş", 4);
        hashMap.put("t", 1);
        hashMap.put("u", 2);
        hashMap.put("ü", 3);
        hashMap.put("v", 7);
        hashMap.put("y", 3);
        hashMap.put("z", 4);

        return hashMap;
    }

    private HashMap StringLetterOfIntImages(HashMap<Integer, String> hashMap) {
        hashMap.put(a, "a");
        hashMap.put(b, "b");
        hashMap.put(c, "c");
        hashMap.put(cc, "ç");
        hashMap.put(d, "d");
        hashMap.put(e, "e");
        hashMap.put(f, "f");
        hashMap.put(g, "g");
        hashMap.put(gg, "ğ");
        hashMap.put(h, "h");
        hashMap.put(i, "ı");
        hashMap.put(ii, "i");
        hashMap.put(j, "j");
        hashMap.put(k, "k");
        hashMap.put(l, "l");
        hashMap.put(m, "m");
        hashMap.put(n, "n");
        hashMap.put(o, "o");
        hashMap.put(oo, "ö");
        hashMap.put(p, "p");
        hashMap.put(r, "r");
        hashMap.put(s, "s");
        hashMap.put(ss, "ş");
        hashMap.put(t, "t");
        hashMap.put(u, "u");
        hashMap.put(uu, "ü");
        hashMap.put(vv, "v");
        hashMap.put(y, "y");
        hashMap.put(z, "z");

        return hashMap;
    }


    public void setColomn() {
        colomn1.add(iv11_1);
        colomn1.add(iv10_1);
        colomn1.add(iv9_1);
        colomn1.add(iv8_1);
        colomn1.add(iv7_1);
        colomn1.add(iv6_1);
        colomn1.add(iv5_1);
        colomn1.add(iv4_1);
        colomn1.add(iv3_1);
        colomn1.add(iv2_1);
        colomn1.add(iv1_1);

        colomn2.add(iv11_2);
        colomn2.add(iv10_2);
        colomn2.add(iv9_2);
        colomn2.add(iv8_2);
        colomn2.add(iv7_2);
        colomn2.add(iv6_2);
        colomn2.add(iv5_2);
        colomn2.add(iv4_2);
        colomn2.add(iv3_2);
        colomn2.add(iv2_2);
        colomn2.add(iv1_2);

        colomn3.add(iv11_3);
        colomn3.add(iv10_3);
        colomn3.add(iv9_3);
        colomn3.add(iv8_3);
        colomn3.add(iv7_3);
        colomn3.add(iv6_3);
        colomn3.add(iv5_3);
        colomn3.add(iv4_3);
        colomn3.add(iv3_3);
        colomn3.add(iv2_3);
        colomn3.add(iv1_3);

        colomn4.add(iv11_4);
        colomn4.add(iv10_4);
        colomn4.add(iv9_4);
        colomn4.add(iv8_4);
        colomn4.add(iv7_4);
        colomn4.add(iv6_4);
        colomn4.add(iv5_4);
        colomn4.add(iv4_4);
        colomn4.add(iv3_4);
        colomn4.add(iv2_4);
        colomn4.add(iv1_4);

        colomn5.add(iv11_5);
        colomn5.add(iv10_5);
        colomn5.add(iv9_5);
        colomn5.add(iv8_5);
        colomn5.add(iv7_5);
        colomn5.add(iv6_5);
        colomn5.add(iv5_5);
        colomn5.add(iv4_5);
        colomn5.add(iv3_5);
        colomn5.add(iv2_5);
        colomn5.add(iv1_5);

        colomn6.add(iv11_6);
        colomn6.add(iv10_6);
        colomn6.add(iv9_6);
        colomn6.add(iv8_6);
        colomn6.add(iv7_6);
        colomn6.add(iv6_6);
        colomn6.add(iv5_6);
        colomn6.add(iv4_6);
        colomn6.add(iv3_6);
        colomn6.add(iv2_6);
        colomn6.add(iv1_6);

        colomn7.add(iv11_7);
        colomn7.add(iv10_7);
        colomn7.add(iv9_7);
        colomn7.add(iv8_7);
        colomn7.add(iv7_7);
        colomn7.add(iv6_7);
        colomn7.add(iv5_7);
        colomn7.add(iv4_7);
        colomn7.add(iv3_7);
        colomn7.add(iv2_7);
        colomn7.add(iv1_7);

        colomn8.add(iv11_8);
        colomn8.add(iv10_8);
        colomn8.add(iv9_8);
        colomn8.add(iv8_8);
        colomn8.add(iv7_8);
        colomn8.add(iv6_8);
        colomn8.add(iv5_8);
        colomn8.add(iv4_8);
        colomn8.add(iv3_8);
        colomn8.add(iv2_8);
        colomn8.add(iv1_8);
    }

    public void generateNumberLetters(ArrayList<Integer> randomsRow) {

        for (int i = 0; i < 8; i++) //buradaki 8 sutun sayısı(we assign letters for 3 rows)
        {
            int num = generateNumberLetters();
            randomsRow.add(letters.get(num));

        }
    }

    public int generateNumberLetters() {
        int num = random.nextInt(37);
        System.out.println(num);
        if(num==29){
           num= 0;
        }else if(num==30){
            num=5;
        }else if(num==31){
            num=10;
        }else if(num==32){
            num=11;
        }else if(num==33){
            num=17;
        }else if(num==34){
            num=18;
        }else if(num==35){
            num=24;
        }else if(num==36){
            num=25;
        }

        return num;

    }

    public int generateNumberWhichColomn() {
        int num = random.nextInt(8);
        return num;
    }

   /* public void checkEnd() {
        if ((colomn1.get(1).getVisibility() == View.VISIBLE) || (colomn2.get(1).getVisibility() == View.VISIBLE) || (colomn3.get(1).getVisibility() == View.VISIBLE) || (colomn4.get(1).getVisibility() == View.VISIBLE) || (colomn5.get(1).getVisibility() == View.VISIBLE) || (colomn6.get(1).getVisibility() == View.VISIBLE) || (colomn7.get(1).getVisibility() == View.VISIBLE) || (colomn8.get(1).getVisibility() == View.VISIBLE)) {
// GAME OVER alert dialogunu getirirsin
            //Ve enable et imageviewi
            alertGameOver();
        }

    }*/

    public void alertGameOver() {
        //BURASIDA DÜZENLENECEK
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("GAME OVER");
        alertDialogBuilder.setIcon(R.drawable.v);
        alertDialogBuilder.setMessage("\nSCORE: " + score).setCancelable(false).setPositiveButton(" NEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                finish();
                startActivity(intent);

            }
        }).setNegativeButton("EXİT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, FirstPageActivity.class);
                finish();
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.writeData(score);
        alertDialog.show();

    }


    public ArrayList<ImageView> fallingImagesViews(ArrayList<ImageView> colomn, int firstDelay, int image, int seconDelay) {
        //deleteEmptyINColomn(colomn);
        //oyun biterse gameover true olur
        if (life >= 1 && !gameOver) {
            colomn = falling(colomn, firstDelay, image, seconDelay);
        } else if (!gameOver) {
            colomn1 = falling(colomn1, firstDelay, letters.get(generateNumberLetters()), seconDelay);
            colomn2 = falling(colomn2, firstDelay, letters.get(generateNumberLetters()), seconDelay);
            colomn3 = falling(colomn3, firstDelay, letters.get(generateNumberLetters()), seconDelay);
            colomn4 = falling(colomn4, firstDelay, letters.get(generateNumberLetters()), seconDelay);
            colomn5 = falling(colomn5, firstDelay, letters.get(generateNumberLetters()), seconDelay);
            colomn6 = falling(colomn6, firstDelay, letters.get(generateNumberLetters()), seconDelay);
            colomn7 = falling(colomn7, firstDelay, letters.get(generateNumberLetters()), seconDelay);
            colomn8 = falling(colomn8, firstDelay, letters.get(generateNumberLetters()), seconDelay);
            life = 3;
        }
        return colomn;
    }

    private ArrayList<ImageView> falling(ArrayList<ImageView> colomn, int firstDelay, int image, int seconDelay) {
        for (int i = 0; i < colomn.size(); i++) {
//her seferinde kontol edilmeli boşluk altta var mı o boşluklar kapanmalı


            int finalI = i;
            firstDelay = firstDelay + seconDelay;
            if (colomn.get(finalI).getVisibility() != View.VISIBLE) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //  deleteEmptyINColomnBottomToTopp(colomn, 10);
                        //bu for yeni eklendi
                       /*for(int k=finalI;k<colomn.size();k++){
                            if(!colomn.get(k).getTag().equals("x")){
                                int lastindex=k;
                                System.out.println("lastindex"+k);

                                lastIndex=lastindex;//deleteEmptyINColomnTopToBottom(colomn,k);
                                break;}
                        }*/
                        if (finalI == 0) {
                            // colomn.get(finalI - 1).setImageResource(back);
                            if (colomn.get(finalI + 1).getVisibility() == View.VISIBLE) {
                                //OYUN BİTER
                                System.out.println("oyun bitti");
                                readyText.setText("GAME\nOVER");
                                readyText.setVisibility(View.VISIBLE);
                                gameOver = true;
                                alertGameOver();

                            } else {

                                colomn.get(finalI).setVisibility(View.INVISIBLE);
                                //  colomn.get(finalI).setEnabled(false);
                                colomn.get(finalI).setTag("x");

                            }

                        } else {
                            colomn.get(finalI - 1).setVisibility(View.INVISIBLE);
                            colomn.get(finalI - 1).setTag("x");
                            //   colomn.get(finalI - 1).setEnabled(false);
                            colomn.get(finalI).setVisibility(View.VISIBLE);
                            colomn.get(finalI).setImageResource(image);
                            colomn.get(finalI).setTag("" + image);
                        }

                     /*else {
                        colomn.get(finalI - 1).setImageResource(a);
                        colomn.get(finalI - 1).setVisibility(View.VISIBLE);

                    }*/
                    }
                }, firstDelay);
            } else {
                //burası şuan en üst kısım demek o zaman buraya has altları silen fonsiyon yapıcaz
                //function(finalI)
                //colomn.get(finalI).setEnabled(true);
                break;
               /* if(finalI!=10){
                deleteEmptyINColomnBottomToTopp(colomn,finalI);}
                else  {deleteEmptyINColomnBottomToTopp(colomn,finalI-1);}*/

            }
        }
        return colomn;
    }

    public void setTagAll() {
        for (int i = 0; i < colomn1.size(); i++) {
            colomn1.get(i).setTag("x");
            colomn2.get(i).setTag("x");
            colomn3.get(i).setTag("x");

            colomn4.get(i).setTag("x");
            colomn5.get(i).setTag("x");
            colomn6.get(i).setTag("x");
            colomn7.get(i).setTag("x");
            colomn8.get(i).setTag("x");

        }
    }

    public void setEnabletAll(boolean b) {
        for (int i = 0; i < colomn1.size(); i++) {
            colomn1.get(i).setEnabled(b);
            colomn2.get(i).setEnabled(b);
            colomn3.get(i).setEnabled(b);

            colomn4.get(i).setEnabled(b);
            colomn5.get(i).setEnabled(b);
            colomn6.get(i).setEnabled(b);
            colomn7.get(i).setEnabled(b);
            colomn8.get(i).setEnabled(b);


        }

    }

    private ArrayList<ImageView> fallImagesViewSetWithPeriod(ArrayList<ImageView> colomn, int delay, int image, int secondDelay) //ArrayList<ImageView> colomn geliyordu normalde ve kolona göre ayarlıyorsun -- int image ile de göndereceğen resim
    {

        colomn = fallingImagesViews(colomn, delay, image, secondDelay);
        return colomn;
    /*   if(period!=0){
           int count=period/timerd;
           if(score<100)
               period=count*5000;
           else if(score<200)
               period=count*4000;
           else if(score<300)
               period=count*3000;
           else if(score<400)
               period=count*2000;
           else if (score<500)
               period=count*1000;
           else
               period=count*5000;
       }
       */

    }

    public ArrayList<ImageView> deleteEmptyINColomn(ArrayList<ImageView> colomn) {
        //yazdırma için

        for (int i = colomn.size() - 1; i > 0; i--) {
            if (colomn.get(i).getTag().toString().equals("x")) {
                for (int j = i - 1; j > 0; j--) {
                    if (!(colomn.get(j).getTag().toString().equals("x"))) {
                        String temp = colomn.get(j).getTag().toString();
                        colomn.get(i).setTag("" + temp);
                        colomn.get(i).setImageResource(Integer.parseInt(temp));
                        colomn.get(j).setTag("x");
                        colomn.get(j).setVisibility(View.INVISIBLE);
                        colomn.get(i).setVisibility(View.VISIBLE);
                        if (j != 1) j--;
                        else break;
                    }
                }

            }


        }
        //yazdırma öncesi sonrası için
        return colomn;
    }

    public int scoreCalculate(ArrayList<String> display, int score) {
        for (int i = 0; i < display.size(); i++) {
            String s = display.get(i).toString().toLowerCase(Locale.forLanguageTag("tr"));
            if (s.equals("ı")) {
                score += scoreOfAlphabeticalMap.get("i");

            } else if (s.equals("i")) {
                score += scoreOfAlphabeticalMap.get("ii");

            } else {
                score += scoreOfAlphabeticalMap.get(s);
            }
        }
        return score;
    }

    public void deleteEmptyINColomnTopToBottom(ArrayList<ImageView> colomn, int index) {
        for (int i = colomn.size() - 1; i >= index; i--) {
            if (colomn.get(i).getTag().toString().equals("x")) {
                for (int j = i - 1; j >= index; j--) {
                    if (!(colomn.get(j).getTag().toString().equals("x"))) {
                        String temp = colomn.get(j).getTag().toString();
                        colomn.get(i).setTag("" + temp);
                        colomn.get(i).setImageResource(Integer.parseInt(temp));
                        colomn.get(j).setTag("x");
                        colomn.get(j).setVisibility(View.INVISIBLE);
                        colomn.get(i).setVisibility(View.VISIBLE);
                        if (j != 1) j--;
                        else break;
                    }
                }

            }


        }
    }

    public ArrayList<ImageView> deleteEmptyINColomnBottomToTop(ArrayList<ImageView> colomn, int index) {

        int i = index;
        while (colomn.get(i - 1).getVisibility() == View.VISIBLE) {
            colomn.get(i).setTag("" + colomn.get(i - 1).getTag());
            colomn.get(i).setImageResource(Integer.parseInt((String) colomn.get(i - 1).getTag()));
            colomn.get(i).setVisibility(View.VISIBLE);
            colomn.get(i - 1).setVisibility(View.INVISIBLE);
            colomn.get(i - 1).setTag("x");
            //   colomn.get(i-1).setEnabled(false);
            //  colomn.get(i).setEnabled(true);
            i--;
        }

        return colomn;
    }

    public void deleteEmptyINColomnBottomToTopp(ArrayList<ImageView> colomn, int index) {
       /* int i;
       for(int j=index;j>0;j--){
           if(colomn.get(j).getVisibility() != View.VISIBLE){
             i=j;
               while (colomn.get(i - 1).getVisibility() == View.VISIBLE && i!=0) {
                   colomn.get(i).setTag("" + colomn.get(i - 1).getTag());
                   colomn.get(i).setImageResource(Integer.parseInt((String) colomn.get(i - 1).getTag()));
                   colomn.get(i).setVisibility(View.VISIBLE);
                   colomn.get(i - 1).setVisibility(View.INVISIBLE);
                   colomn.get(i - 1).setTag("x");
                   i--;
               }

               break;}
       }

*/
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                if (colomn.get(index + 1).getVisibility() == View.INVISIBLE) {
                    colomn.get(index + 1).setVisibility(View.VISIBLE);
                    colomn.get(index + 1).setTag("" + colomn.get(index).getTag());
                    colomn.get(index + 1).setImageResource(Integer.parseInt((String) colomn.get(index).getTag()));
                    colomn.get(index).setVisibility(View.INVISIBLE);
                    colomn.get(index).setTag("x");
                    //   colomn.get(index).setEnabled(true);
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle(" Find Words Game ");
        alert.setMessage("Are you sure exit?");
        alert.setCancelable(false);//kapatılamaz
        alert.setIcon(R.drawable.v);//iconlarımız mipmap klasörü içindedir
        alert.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ;

            }
        });
        alert.setNegativeButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(MainActivity.this, FirstPageActivity.class);
                finish();
                startActivity(intent);

            }
        });
        alert.show();
    }
}