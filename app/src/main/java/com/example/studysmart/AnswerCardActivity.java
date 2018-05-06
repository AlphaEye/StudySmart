package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnswerCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_card);
    }

    public void returnToDeck(View view)
    {
        Intent intent = new Intent(this, DeckCollectionActivity.class);
        startActivity(intent);
    }

    public void nextCard(View view)
    {
        Intent intent = new Intent(this, ViewDeckActivity.class);
        startActivity(intent);
    }
}
