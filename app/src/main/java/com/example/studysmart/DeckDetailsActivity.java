package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeckDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_details);
        // NEED TO START ADDING CODE HERE
        Button addNewFlashCardButton = findViewById(R.id.addFlashCardButton);
        Button studyButton = findViewById(R.id.studyButton);

        // event handling
        addNewFlashCardButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(DeckDetailsActivity.this, AddFlashCardActivity.class));
                    }
                }
        );

        studyButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(DeckDetailsActivity.this, StudyActivity.class));
                    }
                }
        );
    }
}
