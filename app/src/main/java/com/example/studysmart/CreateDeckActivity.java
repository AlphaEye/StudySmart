package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.studysmart.MainActivity.deckList;
import static com.example.studysmart.MainActivity.selectedDeck;

public class CreateDeckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        deckList.addElement(newDeck);
        selectedDeck = newDeck;
        startActivity(intent);
    }
}
