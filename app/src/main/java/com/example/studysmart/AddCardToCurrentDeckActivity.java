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

public class AddCardToCurrentDeckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card_to_current_deck);
    }

    public void addCard(View view)
    {
        Intent intent = new Intent(this, DeckCollectionActivity.class);
        EditText frontEditText = (EditText) findViewById(R.id.flashcardFrontTextInput);
        String front = frontEditText.getText().toString();
        EditText backEditText = (EditText) findViewById(R.id.flashCardBackTextInput);
        String back = backEditText.getText().toString();
        selectedDeck.addCard(new Card(front, back));
        saveData();
        startActivity(intent);
    }

    public void cancelAddCard(View view)
    {
        Intent intent = new Intent(this, DeckCollectionActivity.class);
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
