// This code will not compile yet, and it will need the Card class
// to be programmed first.

package com.example.studysmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
// Other things can be imported here whenever we need them.


// The idea of this class is for the user to create an individual card.
// This class can be called by the CreateDeckActivity class repeatedly,
// for each card the user adds to the deck.

// For the user, this CreateCard class can appear as a screen where they are
// customizing a card.
// This CreateCard class will need to call the Card class.

public class CreateCard extends AppCompatActivity {

    // userCreateCard() returns a card, user_card, that has been
    // newly made and customized by the user.
    public Card userCreateCard() {
        Card user_card = new Card(/* Parameters for the card */);

        // ... More code will go here to modify the card based on
        // the user's input.

        // Return the newly made card.
        return user_card;
    }

}