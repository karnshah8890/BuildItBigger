package com.proteus.androidjokepresenterlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokePresenterActivity extends AppCompatActivity {

    public final static String JOKE_INTENT = "JOKE_INTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_presenter);

        String joke = getIntent().getStringExtra(JOKE_INTENT);

        TextView textView = (TextView)findViewById(R.id.txt_joke);
        textView.setText(joke);
    }
}
