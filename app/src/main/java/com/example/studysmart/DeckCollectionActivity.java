package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.studysmart.MainActivity.currentCardNO;
import static com.example.studysmart.MainActivity.selectedDeck;
import static com.example.studysmart.MainActivity.fromStudy;

public class DeckCollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_collection);

        TextView textView = findViewById(R.id.cardNameText);
        textView.setText(selectedDeck.getName());

        currentCardNO = 0;
    }

    public void renameDeck(View view)
    {
        Intent intent = new Intent(this, RenameDeckActivity.class);
        startActivity(intent);
    }

    public void viewDeck(View view)
    {
        Intent intent = new Intent(this, ViewDeckActivity.class);
        fromStudy = false;
        startActivity(intent);
    }

    public void returnToMainMenu(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addCard(View view)
    {
        Intent intent = new Intent(this, AddCardToCurrentDeckActivity.class);
        startActivity(intent);
    }

    public void study(View view)
    {
        Intent intent = new Intent(this, ViewDeckActivity.class);
        fromStudy = true;
        startActivity(intent);
    }

    public void viewDetails(View view)
    {
        //Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(this, DeckDetailsActivity.class);
        startActivity(intent);
    }
}
