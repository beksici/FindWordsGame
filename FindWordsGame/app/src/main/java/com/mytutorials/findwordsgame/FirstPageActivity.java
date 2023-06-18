package com.mytutorials.findwordsgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FirstPageActivity extends AppCompatActivity {
    Button btnNewGame,btnScoreTable,btnExit,btnAboutgame;
    ImageView imgCover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        btnNewGame=findViewById(R.id.btn_new_game);
        btnScoreTable=findViewById(R.id.btn_score_table);
        btnExit=findViewById(R.id.btn_exit);
        btnAboutgame=findViewById(R.id.btn_about_game);
        assetFileToDb();


        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageActivity.this,MainActivity.class);
                finish();
                startActivity(intent);
            }
        });



        btnScoreTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageActivity.this,ScoreTableActivity.class);
                finish();
                startActivity(intent);
            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogForExit();

            }
        });


        btnAboutgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageActivity.this,AboutGameActivity.class);
                finish();
                startActivity(intent);
            }
        });







    }

    private void alertDialogForExit() {
        AlertDialog.Builder alert = new AlertDialog.Builder(FirstPageActivity.this);
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

                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);

            }
        });
        alert.show();
    }

    @Override
    public void onBackPressed() {
        alertDialogForExit();
    }

    private void assetFileToDb() {
        try {
            final String DB_DESTINATION = "/data/data/com.mytutorials.findwordsgame/words.db";


// Check if the database exists before copying
            boolean initialiseDatabase = (new File(DB_DESTINATION)).exists();
            if (initialiseDatabase == false) {

                // Open the .db file in your assets directory
                InputStream is = this.getAssets().open("words.db");

                // Copy the database into the destination
                OutputStream os = new FileOutputStream(DB_DESTINATION);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0){
                    os.write(buffer, 0, length);
                }
                os.flush();

                os.close();
                is.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}