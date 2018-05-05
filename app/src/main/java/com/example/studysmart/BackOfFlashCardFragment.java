package com.example.studysmart;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.app.Activity;
import android.widget.Button;
//import android.widget.TextView;

public class BackOfFlashCardFragment extends android.app.Fragment {
    //private TextView backOfFlashCardTextView;

    // MIGHT NOT NEED AN INTERFACE
    BackOfFlashCardListener backOfFlashCardInterface;

    public interface BackOfFlashCardListener {
        void gotoAddNewFlashCardActivity();
        void gotoNextFlashCardFront();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            backOfFlashCardInterface = (BackOfFlashCardListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.study_activity_back_of_flashcard_fragment, container, false);

        final Button easyButton = view.findViewById(R.id.easyButton);
        final Button correctButton = view.findViewById(R.id.correctButton);
        final Button hardButton = view.findViewById(R.id.hardButton);
        final Button addNewFlashCardButton = view.findViewById(R.id.addNewFlashcard);
        //TextView backOfFlashCardTextView = view.findViewById(R.id.backOfFlashCardTextView);





    // NEED THE ONCLICK LISTENER FOR ADDING NEW FLASHCARDS
        addNewFlashCardButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        addFlashCardButtonClicked();
                    }
                }
        );


    // NEED AN ONCLICK LISTENER FOR EACH BUTTON: EASY, CORRECT, HARD
        easyButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        easyButtonClicked();
                    }
                }
        );

        correctButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        correctButtonClicked();
                    }
                }
        );

        hardButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        hardButtonClicked();
                    }
                }
        );

        return view;
    }


    public void addFlashCardButtonClicked() {
        backOfFlashCardInterface.gotoAddNewFlashCardActivity();
    }

    public void easyButtonClicked() {
        // update flashcard scheduling
        backOfFlashCardInterface.gotoNextFlashCardFront();
    }

    public void correctButtonClicked() {
        // update flashcard scheduling
        backOfFlashCardInterface.gotoNextFlashCardFront();
    }

    public void hardButtonClicked() {
        // update flashcard scheduling
        backOfFlashCardInterface.gotoNextFlashCardFront();

    }

}