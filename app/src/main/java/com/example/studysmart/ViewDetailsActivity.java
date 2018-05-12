package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import static com.example.studysmart.MainActivity.fromStudy;
import static com.example.studysmart.MainActivity.selectedDeck;

public class ViewDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        // NEED TO START ADDING CODE HERE
        Button addCardButton = findViewById(R.id.addCardButton);
        Button studyButton = findViewById(R.id.studyButton);

        TextView totalText = (TextView) findViewById(R.id.totalTextView);
        TextView percentEasyText = (TextView) findViewById(R.id.percentEasyTextView);
        TextView percentMediumText = (TextView) findViewById(R.id.percentMediumTextView);
        TextView percentHardText = (TextView) findViewById(R.id.percentHardTextView);
        TextView difficultyText = (TextView) findViewById(R.id.difficultyTextView);

        totalText.setText("" + selectedDeck.totalSize + " total cards");
        //easy
        if (selectedDeck.easy_v.size() == 0)
        {
            percentEasyText.setText( "" + 0 + "%");
        }
        else { percentEasyText.setText( "" + (selectedDeck.easy_v.size() / selectedDeck.totalSize)*100 + "%"); }
        //medium
        if (selectedDeck.medium_v.size() == 0)
        {
            percentMediumText.setText( "" + 0 + "%");
        }
        else { percentMediumText.setText( "" + (selectedDeck.medium_v.size() / selectedDeck.totalSize)*100 + "%"); }
        //hard
        if (selectedDeck.hard_v.size() == 0)
        {
            percentHardText.setText( "" + 0 + "%");
        }
        else { percentHardText.setText( "" + (selectedDeck.hard_v.size() / selectedDeck.totalSize)*100 + "%"); }

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
        addCardButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(ViewDetailsActivity.this, AddCardToCurrentDeckActivity.class));
                    }
                }
        );

        studyButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        fromStudy = true;
                        startActivity(new Intent(ViewDetailsActivity.this, ViewDeckActivity.class));
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

