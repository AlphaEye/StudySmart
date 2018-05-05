package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.EditText;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.StudySmart.MESSAGE";

    public static Vector<Deck> deckList;
    public static Deck selectedDeck;
=======
import android.widget.Button;
//import android.widget.EditText; never used

public class MainActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.StudySmart.MESSAGE"; never used
>>>>>>> origin/devel
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        deckList = new Vector<Deck>();
        deckList.add(new Deck("Deck1", "SUBJECT"));
=======
        Button createDeckButton = findViewById(R.id.createDeckButton);
        Button deckCollectionButton = findViewById(R.id.deckCollectionButton);
        // NEED DECK DETAILS FROM DECK CLASS TO ADD TO TEXT VIEW
        // ...

        // THESE BUTTONS GO WITH THE COMMENTED CODE IN EVENT HANDLING SECTION
        //Button duelButton = findViewById(R.id.duelButton);

        // event handling
        createDeckButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, CreateDeckActivity.class));
                    }
                }
        );

        /*
            THESE ACTIVITIES CURRENTLY DON'T EXIST

        duelButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, DuelActivity.class));
                    }
                }
        );

        deckCollectionButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, DeckCollectionActivity.class));
                    }
                }
        );

        */

        // temporary code

        deckCollectionButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, DeckDetailsActivity.class));
                    }
                }
        );

>>>>>>> origin/devel
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
