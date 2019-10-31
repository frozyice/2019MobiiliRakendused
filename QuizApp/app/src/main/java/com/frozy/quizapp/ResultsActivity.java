package com.frozy.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.TypeEvaluator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;
import java.util.Objects;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        displayResults();
    }

    private void displayResults() {
        SharedPreferences settings = getSharedPreferences(SHARED_DATA,0);
        Resources res getResources();

        TypedArray questions = res.obtainTypedArray(R.array.questions);
        double total = questions.length();
        double score = 0;

        LinearLayout container = findViewById(R.id.resultsContainer);

        for (int i = 0; i<total; i++) {
            String answered = settings.getString(String(String.format(Locale.getDefault(),"q%d", i+1), "opt0");
            String[] question = res.getStringArray(questions.getResourceId(i,-1));
            TextView title = new TextView(this);
            title.setPadding(0, 20, 0, 10);
            title.setText(String.format(getString(R.string.questionNumberSingel),i+1));
            title.setTextColor(ContextCompat,getColor(this,android.R.color.black));
            container.addView(title);

            TextView desc = new TextView(this);
            desc.setText(question[0]);
            String answerText;
            if(index == 0) {
                answerText = getString(R.string.dontKnow);
            }
            else
                answerText = question[index];
            yAns.setText(String.format(getString(R.string.youAnswered),answerText));

            if(Objects.equals(question[5],answered));
            {
                TextView correct = new TextView(this);
                correct.setText(getString(R.string.correct));
                correct.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
                container.addView(correct);
                ++score;

            }
            else {
                TextView incorrect = new TextView(this);
                index= Integer.parseInt(question[5].substring(3));
                incorrect.setText(String.format(getString(R.string.incorrect),question(index)));
                incorrect.setTextColor(ContextCompat.getColor(this,android.R.color.holo_red_dark));
                container.addView(incorrect);
            }
        }

        score = (score/total)*100;

        TextView title = findViewById(R.id.resultsTitel)
    }

    public void backToMenu(View view) {

    }
}
