package com.example.studysmart;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.studysmart.MainActivity.currentCard;
import static com.example.studysmart.MainActivity.currentCardNO;
import static com.example.studysmart.MainActivity.fromStudy;
import static com.example.studysmart.MainActivity.selectedDeck;

public class AnswerCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_card);

        if (fromStudy == false && selectedDeck.totalSize != 0) {
            currentCard = selectedDeck.inOrder_v.elementAt(currentCardNO);
            if (currentCardNO < selectedDeck.inOrder_v.size())
                currentCardNO++;
            else
                currentCardNO = -1;
            //get the answer string
            TextView answerText = (TextView) findViewById(R.id.answerText);
            answerText.setText(currentCard.getAnswer());
        }
        else
        {
            //get the answer string
            TextView answerText = (TextView) findViewById(R.id.answerText);
            answerText.setText(currentCard.getAnswer());
        }
    }

    public void returnToDeck(View view)
    {
        Intent intent = new Intent(this, DeckCollectionActivity.class);
        startActivity(intent);
    }

    public void nextCard(View view)
    {
        Intent intent;
        if (currentCardNO >= selectedDeck.inOrder_v.size())
            currentCardNO = -1;
        if (currentCardNO == -1)
            intent = new Intent(this, DeckCollectionActivity.class);
        else
            intent = new Intent(this, ViewDeckActivity.class);
        startActivity(intent);
    }

    public void addEasy(View view)
    {
        Intent intent;
        selectedDeck.addCardToEasy(currentCard);
        if (currentCardNO >= selectedDeck.inOrder_v.size())
            currentCardNO = -1;
        if (currentCardNO == -1)
            intent = new Intent(this, DeckCollectionActivity.class);
        else
            intent = new Intent(this, ViewDeckActivity.class);
        startActivity(intent);
    }

    public void addMedium(View view)
    {
        Intent intent;
        selectedDeck.addCardToMedium(currentCard);
        if (currentCardNO >= selectedDeck.inOrder_v.size())
            currentCardNO = -1;
        if (currentCardNO == -1)
            intent = new Intent(this, DeckCollectionActivity.class);
        else
            intent = new Intent(this, ViewDeckActivity.class);
        startActivity(intent);
    }

    public void addHard(View view)
    {
        Intent intent;
        selectedDeck.addCardToHard(currentCard);
        if (currentCardNO >= selectedDeck.inOrder_v.size())
            currentCardNO = -1;
        if (currentCardNO == -1)
            intent = new Intent(this, DeckCollectionActivity.class);
        else
            intent = new Intent(this, ViewDeckActivity.class);
        startActivity(intent);
    }
}
