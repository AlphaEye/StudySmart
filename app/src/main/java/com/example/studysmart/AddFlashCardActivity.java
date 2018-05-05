package com.example.studysmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddFlashCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flashcard);

        Button addFlashCardButton = findViewById(R.id.addFlashCardButton);

        // event handling
        addFlashCardButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        // code to create and add flashcard to deck goes here
                    }
                }
        );

    }
}
