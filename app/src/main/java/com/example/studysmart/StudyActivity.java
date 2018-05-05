package com.example.studysmart;

//import android.app.Fragment;
import android.app.FragmentTransaction;
//import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class StudyActivity extends AppCompatActivity implements FrontOfFlashCardFragment.FrontOfFlashCardListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

    }

    /* this is called by FrontOfFlashCardFragment when the user clicks the add new flashcard button */
    @Override
    public void gotoAddNewFlashCardActivity() {
        startActivity(new Intent(StudyActivity.this, AddFlashCardActivity.class));
    }

    /* this is called by FrontOfFlashCardFragment when the user clicks the answer button */
    // THIS NEEDS TO BE TESTED STILL.
    @Override
    public void gotoBackOfFlashCardFragment() {
        RelativeLayout studyActivityFragmentLayout = findViewById(R.id.studyActivityFragmentLayout);
        studyActivityFragmentLayout.removeAllViews();
        BackOfFlashCardFragment backOfFlashCardFragment = new BackOfFlashCardFragment();
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.studyActivity, backOfFlashCardFragment);
        //ft.addToBackStack(null);
        ft.commit();
    }

    /* this is called by BackOfFlashCardFragment when the user clicks either easy, correct or hard button */
    // THIS NEEDS TO BE TESTED STILL.
    @Override
    public void gotoNextFlashCardFront() {
        RelativeLayout studyActivityFragmentLayout = findViewById(R.id.studyActivityFragmentLayout);
        studyActivityFragmentLayout.removeAllViews();
        FrontOfFlashCardFragment frontOfFlashCardFragment = new FrontOfFlashCardFragment();
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.studyActivity, frontOfFlashCardFragment);
        //ft.addToBackStack(null);
        ft.commit();
    }
}
