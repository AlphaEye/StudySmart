package com.example.studysmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.studysmart.MainActivity.deckList;
import static com.example.studysmart.MainActivity.selectedDeck;

public class ViewCollectionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_collection);

        //Spinner Button
        Spinner spinner = (Spinner) findViewById(R.id.deckSpinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        //Deck Selections
        List<String> deckNames = new ArrayList<String>();
        deckNames.add("");
        for (int i = 0; i < deckList.size(); i++)
        {
            deckNames.add(deckList.elementAt(i).getName() + "     " + deckList.elementAt(i).getSubject());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, deckNames);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        if (parent.getItemAtPosition(position) == "")
            return;
        for (int i = 0; i < deckList.size(); i++) {
            if (deckList.elementAt(i).getName() == parent.getItemAtPosition(position))
                selectedDeck = deckList.elementAt(i);
        }
        Intent intent = new Intent(this, DeckCollectionActivity.class);
        startActivity(intent);
    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    public void addDeck(View view)
    {
        Intent intent = new Intent(this, CreateDeckActivity.class);
        startActivity(intent);
    }

    public void backToMainMenu(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
