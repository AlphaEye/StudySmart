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


public class FrontOfFlashCardFragment extends android.app.Fragment {
    //private TextView frontOfFlashCardTextView;



    // MIGHT NOT NEED AN INTERFACE
    FrontOfFlashCardListener frontOfFlashCardInterface;

    // BackOfFlashCardFragment.BackOfFlashCardListener can be found in BackOfFlashCardFragment.java
    public interface FrontOfFlashCardListener extends BackOfFlashCardFragment.BackOfFlashCardListener {
        void gotoAddNewFlashCardActivity();
        void gotoBackOfFlashCardFragment();

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            frontOfFlashCardInterface = (FrontOfFlashCardListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.study_activity_front_of_flashcard_fragment, container, false);
        //frontOfFlashCardTextView = view.findViewById(R.id.frontOfFlashCardTextView);
        final Button addNewFlashCardButton = view.findViewById(R.id.addNewFlashcard);
        final Button answerButton = view.findViewById(R.id.answerButton);

        addNewFlashCardButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        addFlashCardButtonClicked();
                    }
                }
        );

        answerButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        answerButtonClicked();
                    }
                }
        );
        return view;
    }

    public void addFlashCardButtonClicked() {
        frontOfFlashCardInterface.gotoAddNewFlashCardActivity();
    }

    public void answerButtonClicked() {
        frontOfFlashCardInterface.gotoBackOfFlashCardFragment();
    }
}
