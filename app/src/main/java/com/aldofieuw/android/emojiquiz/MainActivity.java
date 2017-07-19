package com.aldofieuw.android.emojiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String imgSrc, q2a1, q5a1, name;
    private int score, q1a1, q4a1;
    private RadioGroup q1, q4;
    private EditText q2, q5;
    private CheckBox q3c1, q3c2, q3c3;
    private boolean q3a1, q3a2, q3a3;
    private ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgSrc = getIntent().getStringExtra("imgSrc");
        name = getIntent().getStringExtra("name");
        score = 0;
        q1 = (RadioGroup) findViewById(R.id.celebrity);
        q2 = (EditText) findViewById(R.id.brand);
        q3c1 = (CheckBox) findViewById(R.id.burger);
        q3c2 = (CheckBox) findViewById(R.id.lion);
        q3c3 = (CheckBox) findViewById(R.id.king);
        q4 = (RadioGroup) findViewById(R.id.radioGroup2);
        q5 = (EditText) findViewById(R.id.winnie);


        /*set avatar to chosen one in the beginning */
        avatar = (ImageView) findViewById(R.id.avatar);
        switch (imgSrc) {
            case "e_baby":
                avatar.setImageResource(R.drawable.e_baby);
                break;
            case "e_boy":
                avatar.setImageResource(R.drawable.e_boy);
                break;
            case "e_girl":
                avatar.setImageResource(R.drawable.e_girl);
                break;
            case "e_man":
                avatar.setImageResource(R.drawable.e_man);
                break;
            case "e_woman":
                avatar.setImageResource(R.drawable.e_woman);
                break;
            case "e_oldman":
                avatar.setImageResource(R.drawable.e_oldman);
                break;
            case "e_oldwoman":
                avatar.setImageResource(R.drawable.e_oldwoman);
                break;
        }
        // show name in uppercase
        ((TextView) findViewById(R.id.nameAvatar)).setText(name.toString().toUpperCase());
    }

    public void score(View view) {
        /* check every answer if its the good one , then score +1 */
        q1a1 = q1.indexOfChild(findViewById(q1.getCheckedRadioButtonId()));
        //  correct: snow white
        if (q1a1 == 0) {
            score++;
        }
        //  correct: apple
        q2a1 = q2.getText().toString();
        if (q2a1.trim().equalsIgnoreCase("apple")) {
            score++;
        }
        //  correct: burger king
        q3a1 = q3c1.isChecked();
        q3a2 = q3c2.isChecked();
        q3a3 = q3c3.isChecked();
        if (q3a1 && !q3a2 && q3a3) {
            score++;
        }
        //  correct: Titanic
        q4a1 = q4.indexOfChild(findViewById(q4.getCheckedRadioButtonId()));
        if (q4a1 == 1) {
            score++;
        }
        //  correct: winnie the pooh
        q5a1 = q5.getText().toString();
        if (q5a1.trim().equalsIgnoreCase("winnie the pooh")) {
            score++;
        }

        // if score is zero, show message to try again, else show score
        if (score == 0) {
            Toast.makeText(this, R.string.no_right_answers, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this,
                    "You had " + Integer.toString(score) + " questions right!", Toast.LENGTH_LONG).show();
            score = 0;

            //  initialize with score button, then show startbutton/restart
            (findViewById(R.id.scoreBtn)).setVisibility(View.GONE);
            (findViewById(R.id.startBtn)).setVisibility(View.VISIBLE);
        }
    }

    //  start new activity (go to startActivity)
    public void restart(View view) {
        startActivity(new Intent(MainActivity.this, StartActivity.class));
    }

    // onSave and on restore
    // onSave
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("imgSrc", imgSrc);
        savedInstanceState.putString("name", name);
        savedInstanceState.putInt("score", score);

        savedInstanceState.putInt("q1a1", q1a1);
        savedInstanceState.putString("q2a1", q2a1);
        savedInstanceState.putBoolean("q3a1", q3a1);
        savedInstanceState.putBoolean("q3a2", q3a2);
        savedInstanceState.putBoolean("q3a3", q3a3);
        savedInstanceState.putInt("q4a1",q4a1);
        savedInstanceState.putString("q5a1", q5a1);

        super.onSaveInstanceState(savedInstanceState);
    }

    // onRestore
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        imgSrc = savedInstanceState.getString("imgSrc");
        name = savedInstanceState.getString("name");
        score = savedInstanceState.getInt("score");

        q1a1 = savedInstanceState.getInt("q1a1");
        q2a1 = savedInstanceState.getString("q2a1");
        q3a1 = savedInstanceState.getBoolean("q3a1");
        q3a2 = savedInstanceState.getBoolean("q3a2");
        q3a3 = savedInstanceState.getBoolean("q3a3");
        q4a1 = savedInstanceState.getInt("q4a1");
        q5a1 = savedInstanceState.getString("q5a1");


    }
}
