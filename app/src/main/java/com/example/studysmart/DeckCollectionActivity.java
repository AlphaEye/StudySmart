package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.studysmart.MainActivity.currentCardNO;
import static com.example.studysmart.MainActivity.selectedDeck;

public class DeckCollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_collection);
        currentCardNO = 0;

        TextView textView = findViewById(R.id.cardNameText);
        textView.setText(selectedDeck.getName());
    }

    public void renameDeck(View view)
    {
        Intent intent = new Intent(this, RenameDeckActivity.class);
        startActivity(intent);
    }

    public void viewDeck(View view)
    {
        Intent intent = new Intent(this, ViewDeckActivity.class);
        startActivity(intent);
    }
}
