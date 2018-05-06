package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.studysmart.MainActivity.currentCardNO;
import static com.example.studysmart.MainActivity.selectedDeck;

public class ViewDeckActivity extends AppCompatActivity {

    Card currentCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_deck);

        //get the current card
        currentCard = selectedDeck.inOrder_v.elementAt(currentCardNO);

        //get the question string
        TextView questionText = (TextView) findViewById(R.id.questionText);
        questionText.setText(currentCard.getQuestion());
    }

    public void returnToDeck(View view)
    {
        Intent intent = new Intent(this, DeckCollectionActivity.class);
        startActivity(intent);
    }

    public void answerCard(View view)
    {
        Intent intent = new Intent(this, AnswerCardActivity.class);
        startActivity(intent);
    }

    public void deleteCard(View view)
    {
        Intent intent = new Intent(this, ViewDeckActivity.class);
        selectedDeck.removeCard(currentCard);
        startActivity(intent);
    }
}
