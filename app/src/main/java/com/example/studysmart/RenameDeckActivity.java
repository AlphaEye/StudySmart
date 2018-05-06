package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.studysmart.MainActivity.deckList;
import static com.example.studysmart.MainActivity.selectedDeck;

public class RenameDeckActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.StudySmart.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rename_deck);
    }

    /** Called when the user taps the confirm button */
    public void changeName(View view) {
        Intent intent = new Intent(this, ViewCollectionActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();
        for (int i = 0; i < deckList.size(); i++) {
            if (deckList.elementAt(i).getName() == selectedDeck.getName()) {
                deckList.elementAt(i).name = name;
                break;
            }
        }
        startActivity(intent);
    }
}
