package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.studysmart.MainActivity.fromStudy;
import static com.example.studysmart.MainActivity.selectedDeck;

public class DeckDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_details);
        // NEED TO START ADDING CODE HERE
        Button addNewFlashCardButton = findViewById(R.id.addFlashCardButton);
        Button studyButton = findViewById(R.id.studyButton);

        TextView totalText = (TextView) findViewById(R.id.totalTextView);
        TextView percentText = (TextView) findViewById(R.id.percentageTextView);
        TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);

        totalText.setText("" + selectedDeck.totalSize);
        if (selectedDeck.easy_v.size() == 0)
        {
            percentText.setText( "" + 0 + "%");
        }
        else { percentText.setText( "" + (selectedDeck.easy_v.size() / selectedDeck.totalSize)*100 + "%"); }

        if(selectedDeck.easy_v.size() >= selectedDeck.medium_v.size() &&
                selectedDeck.easy_v.size() >= selectedDeck.hard_v.size()){
            difficultyText.setText("Easy");
        }
        else if(selectedDeck.medium_v.size() >= selectedDeck.easy_v.size() &&
                selectedDeck.medium_v.size() >= selectedDeck.hard_v.size()){
            difficultyText.setText("Medium");
        }
        else if(selectedDeck.hard_v.size() >= selectedDeck.easy_v.size() &&
                selectedDeck.hard_v.size() >= selectedDeck.medium_v.size()) {
            difficultyText.setText("Hard");
        }
        else {
            difficultyText.setText("Not rated");
        }

        // event handling
        addNewFlashCardButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(DeckDetailsActivity.this, AddCardToCurrentDeckActivity.class));
                    }
                }
        );

        studyButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(DeckDetailsActivity.this, ViewDeckActivity.class));
                    }
                }
        );
    }

    public void toStudy(View view)
    {
        Intent intent = new Intent(this, ViewDeckActivity.class);
        fromStudy = true;
        startActivity(intent);
    }

}
