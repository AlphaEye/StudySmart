package com.example.studysmart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Vector;

import static com.example.studysmart.MainActivity.deckList;
import static com.example.studysmart.MainActivity.selectedDeck;

public class CreateDeckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deck);

        /*Button createDeckButton = findViewById(R.id.createDeckButton);

        // event handling
        createDeckButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        // code for creating decks go here
                        // text in text views need to be retrieved first

                    }
                }
        );
    }*/


    }

    public void createNewDeck(View view)
    {
        Intent intent = new Intent(this, DeckCollectionActivity.class);
        EditText deckNameEditText = (EditText) findViewById(R.id.deckNameTextEdit);
        String name = deckNameEditText.getText().toString();
        EditText deckSubjectEditText = (EditText) findViewById(R.id.deckSubjectTextEdit);
        String subject = deckSubjectEditText.getText().toString();
        Deck newDeck = new Deck(name, subject);
        deckList.add(newDeck);
        selectedDeck = newDeck;
        saveData();
        startActivity(intent);
    }

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
}
