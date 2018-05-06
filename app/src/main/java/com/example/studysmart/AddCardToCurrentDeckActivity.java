package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        startActivity(intent);
    }
}
