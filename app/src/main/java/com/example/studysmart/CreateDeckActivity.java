package com.example.studysmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateDeckActivity extends AppCompatActivity {

    //below are the shared preference constants needed to save the user data
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String DECK_NAME = "deck_name";
    //cannot make the deck state static

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deck);
    }
}
