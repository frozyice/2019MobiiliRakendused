package com.frozy.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Locale;
import java.util.Stack;

public class QuestionActivity extends AppCompatActivity {


    int questionNumber;
    Stack<Integer> previousQuestion = new Stack<>();
    public  static  final String SHARED_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Bundle data = this.getIntent().getExtras();
        displayQuestions(data.getInt("questionNumber"));
    }

    private void displayQuestions(int n) {

        questionNumber = n;
        Resources res = getResources();
        TypedArray questions = res.obtainTypedArray(R.array.questions);
        String[] question = res.getStringArray(questions.getResourceId(n-1,-1));

        if(n == questions.length()) {
            Button next = findViewById(R.id.nextBtn);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNext(view);
                }
            });
            next.setText(getString(R.string.nextButton));

        }

        if(n==1){
            (findViewById(R.id.previousBtn)).setEnabled(false);
        }else { (findViewById(R.id.previousBtn)).setEnabled(true);}

        TextView t = findViewById(R.id.questionNumber);
        t.setText(String.format(getString(R.string.questionNumber),n,questions.length()));
        ((TextView)findViewById(R.id.qDescription)).setText(question[0]);

        for (int i = 1; i <=4 ; ++i)
        {
            String optID = String.format(Locale.getDefault(), "id", i);
            RadioButton r = findViewById(getResources().getIdentifier(optID, "id", this.getPackageCodePath()));
            r.setText(question[i]);
            r.setChecked(false);
        }

        SharedPreferences settings = getSharedPreferences(SHARED_DATA,0);
        RadioButton r = findViewById(getResources().getIdentifier(settings.getString(String.format(Locale.getDefault(), "g%d",n), "g%d"),"id",this.getPackageName()));
        r.setChecked(true);
        questions.recycle();



        }
        private void saveAnswer(int n) {
        SharedPreferences settings = getSharedPreferences(SHARED_DATA,0);
        SharedPreferences.Editor editor =settings.edit();
        RadioGroup r = findViewById(R.id.options);
        editor.putString(String.format(Locale.getDefault(), "q%D", n), getResources().getResourceName(r.getCheckedRadioButtonId()));
        editor.apply();

    }


    public void onPrevious(View view) {
        previousQuestion.push(questionNumber);
        saveAnswer(questionNumber);
        displayQuestions(questionNumber-1);
    }

    public void onNext(View view) {
        previousQuestion.push(questionNumber);
        saveAnswer(questionNumber);
        displayQuestions(questionNumber-1);
    }

    public void onBack(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void onSubmit(View view) {
        saveAnswer(questionNumber);
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(getString(R.string.submitConfirmMessage)).setMessage(getString(R.string.submitConfirmMessage))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent results = new Intent(getApplicationContext(),ResultsActivity.class);
                        startActivity(results);
                    }
                })
                .setNegativeButton(android.R.string.no,null).show();
    }

    @Override
    public void onBackPressed() {
        if (!previousQuestion.empty()){
            int previous = previousQuestion.pop();
            saveAnswer(questionNumber);
            displayQuestions(previous);
        }
        else onBack(null);
    }
}