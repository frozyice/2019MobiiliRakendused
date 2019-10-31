package com.frozy.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    private TextView highScore;
    public static final String SHARED_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highScore = findViewById(R.id.txtHighScore);

    }



    public void onStart(View view) {
        Bundle data = new Bundle();
        data.putInt("questionNumber",1);
        Intent quiz = new Intent(getApplicationContext(),QuestionActivity.class);
        quiz.putExtras(data);
        startActivity(quiz);
    }

    public void onResetScore(View view) {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(getString(R.string.resetHighConfirmTitle))
                .setMessage(getString(R.string.resetHighConfirmMessage)).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences settings = getSharedPreferences(SHARED_DATA,0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putFloat("highscore",0);
                editor.apply();
                mainScore();
            }
        })
                .setNegativeButton(android.R.string.no, null).show();

    }

    public void onResetAnswer(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(getString(R.string.resetAnsConfirmTitle))
                .setMessage(getString(R.string.resetAnsConfirmMessage))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        SharedPreferences settings = getSharedPreferences(SHARED_DATA,0);
                        SharedPreferences.Editor editor = settings.edit();
                        int total = getResources().obtainTypedArray(R.array.questions).length();
                        for (int i = 1; i<total; ++i){
                            RadioGroup r = findViewById(R.id.options);
                            editor.remove(String.format("q%d",i));

                        }
                        editor.apply();
                    }
                })
                .setNegativeButton(android.R.string.no,null).show();

    }

    private void mainScore(){
        SharedPreferences settings = getSharedPreferences(SHARED_DATA,0);
        double highscore = settings.getFloat("highscore",0);
        String textScore = String.format(getString(R.string.highscore), highscore);
        highScore.setText(textScore);

    }

    @Override
    public void onBackPressed() {
        Intent homeScreen = new Intent(Intent.ACTION_MAIN);
        homeScreen.addCategory(Intent.CATEGORY_HOME);
        startActivity(homeScreen);

    }
}
