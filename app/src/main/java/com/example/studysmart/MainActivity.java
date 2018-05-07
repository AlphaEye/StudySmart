package com.example.studysmart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Type;
import java.util.Vector;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import android.widget.EditText; never used

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.StudySmart.MESSAGE";

    //For list of deck, should be loaded from the phone(AlphaEye)
    public static Vector<Deck> deckList = new Vector<Deck>();
    //Selected deck, used to implement deck collections(AlphaEye)
    public static Deck selectedDeck;
    //public static final String EXTRA_MESSAGE = "com.example.StudySmart.MESSAGE"; never used
    //Actually needed for viewing cards
    public static int currentCardNO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //For testing (AlphaEye)
        //deckList = new Vector<Deck>();

        /*deckList.add(new Deck("CS410", "Comp Sci"));
        for (int i = 0; i <= 33; i++)
        {
            deckList.elementAt(0).addCardToEasy(new Card("Easy Q" + Integer.toString(i), "Easy A" + Integer.toString(i)));
        }
        for (int i = 34; i <= 66; i++)
        {
            deckList.elementAt(0).addCardToMedium(new Card("Medium Q" + Integer.toString(i), "Medium A" + Integer.toString(i)));
        }
        for (int i = 67; i <= 100; i++)
        {
            deckList.elementAt(0).addCardToHard(new Card("Hard Q" + Integer.toString(i), "Hard A" + Integer.toString(i)));
        }
        deckList.elementAt(0).addCard(new Card("TEST1", "ANSWER1"));
        deckList.elementAt(0).addCard(new Card("TEST2", "ANSWER2"));
        deckList.elementAt(0).addCard(new Card("TEST3", "ANSWER3"));
        deckList.add(new Deck("CS410", "Comp Sci"));
        deckList.elementAt(1).addCard(new Card("Water", "H2O"));*/

        Button createDeckButton = findViewById(R.id.createDeckButton);
        // Leave the collection to me(AlphaEye)
//        Button deckCollectionButton = findViewById(R.id.deckCollectionButton);
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




        Button duelButton = findViewById(R.id.duelButton);

        duelButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, DuelActivity.class));
                    }
                }
        );



    /*
    THESE ACTIVITIES CURRENTLY DON'T EXIST

        deckCollectionButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, DeckCollectionActivity.class));
                    }
                }
        );

        */

        // temporary code
/*
        deckCollectionButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, DeckDetailsActivity.class));
                    }
                }
        );*/

    }

    //method to save user defined decks
    public void saveData()
    {
        //we save user data to shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(deckList);
        editor.putString("deck list", json);
        //this is what saves the deckList to memory
        editor.apply();
    }

    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",
                MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("deck list", null);
        Type type = new TypeToken<Vector<Deck>>() {}.getType();
        deckList = gson.fromJson(json, type);

        if (deckList == null)
        {
            deckList = new Vector<Deck>();
        }
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

    public void duel(View view)
    {
        Intent intent = new Intent(this, DuelActivity.class);
        startActivity(intent);
    }
}
