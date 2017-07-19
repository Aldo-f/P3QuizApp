package com.aldofieuw.android.emojiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    private String imgSrc, name;
    private ImageView avatar;
    //Attribute for rebuilding view after chosing avatar
    private boolean chosen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        avatar = (ImageView) findViewById(R.id.avaterName);
    }

    public void chooseEmoticon(View view) {
        switch (view.getId()) {
            case R.id.baby:
                imgSrc = "e_baby";
                avatar.setImageResource(R.drawable.e_baby);
                break;
            case R.id.boy:
                imgSrc = "e_boy";
                avatar.setImageResource(R.drawable.e_boy);
                break;
            case R.id.girl:
                imgSrc = "e_girl";
                avatar.setImageResource(R.drawable.e_girl);
                break;
            case R.id.man:
                imgSrc = "e_man";
                avatar.setImageResource(R.drawable.e_man);
                break;
            case R.id.woman:
                imgSrc = "e_woman";
                avatar.setImageResource(R.drawable.e_woman);
                break;
            case R.id.oldman:
                imgSrc = "e_oldman";
                avatar.setImageResource(R.drawable.e_oldman);
                break;
            case R.id.oldwoman:
                imgSrc = "e_oldwoman";
                avatar.setImageResource(R.drawable.e_oldwoman);
                break;
        }


        //  removes all LinearLayouts and shows only the chosen avatar
        (findViewById(R.id.avatars)).setVisibility(View.GONE);
        (findViewById(R.id.avatars1)).setVisibility(View.GONE);
        (findViewById(R.id.avatars2)).setVisibility(View.GONE);
        (findViewById(R.id.avatars3)).setVisibility(View.GONE);
        (findViewById(R.id.avatars4)).setVisibility(View.GONE);
        (findViewById(R.id.name)).setVisibility(View.VISIBLE);
        (findViewById(R.id.avaterName)).setVisibility(View.VISIBLE);
        chosen = true;
    }

    public void startGame(View view) {
        name = ((EditText) findViewById(R.id.nameInput)).getText().toString();
        EditText field = (EditText) findViewById(R.id.nameInput);
        if (imgSrc == null) {
            Toast.makeText(StartActivity.this,
                    "You need to choose an emoticon.", Toast.LENGTH_LONG).show();
            return;
        }
        if (name.isEmpty()) {
            field.setError("Cannot be empty..");
            return;
        }

        final Intent intent = new Intent(StartActivity.this, MainActivity.class);
        intent.putExtra("imgSrc", imgSrc);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    // onSave and on restore
    // onSave
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("imgSrc", imgSrc);
        savedInstanceState.putString("name", name);
        savedInstanceState.putBoolean("chosen", chosen);

        super.onSaveInstanceState(savedInstanceState);
    }

    // onRestore
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        imgSrc = savedInstanceState.getString("imgSrc");
        name = savedInstanceState.getString("name");
        chosen = savedInstanceState.getBoolean("chosen");
        if (chosen){
            resetViewAfterRotating();
        }
    }

    private void resetViewAfterRotating(){
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

         // removes all LinearLayouts and shows only the chosen avatar
        (findViewById(R.id.avatars)).setVisibility(View.GONE);
        (findViewById(R.id.avatars1)).setVisibility(View.GONE);
        (findViewById(R.id.avatars2)).setVisibility(View.GONE);
        (findViewById(R.id.avatars3)).setVisibility(View.GONE);
        (findViewById(R.id.avatars4)).setVisibility(View.GONE);
        (findViewById(R.id.name)).setVisibility(View.VISIBLE);
        (findViewById(R.id.avaterName)).setVisibility(View.VISIBLE);

    }
}
