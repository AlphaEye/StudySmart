package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.StudySmart.MESSAGE";

    public static Vector<Deck> deckList;
    public static Deck selectedDeck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deckList = new Vector<Deck>();
        deckList.add(new Deck("Deck1", "SUBJECT"));
    }

    /** Called when the user taps the button */
    public void createDeck(View view) {
        Intent intent = new Intent(this, CreateDeckActivity.class);
        startActivity(intent);
    }

    public void collection(View view)
    {
        Intent intent = new Intent(this, ViewCollectionActivity.class);
        startActivity(intent);
    }
}
