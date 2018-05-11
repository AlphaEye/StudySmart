package com.example.studysmart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Vector;

import static com.example.studysmart.MainActivity.currentCardNO;
import static com.example.studysmart.MainActivity.deckList;
import static com.example.studysmart.MainActivity.selectedDeck;

public class ViewDeckActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;

    Card currentCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_deck);

        //get the current card
        currentCard = selectedDeck.inOrder_v.elementAt(currentCardNO);

        //get the question string
        TextView questionText = (TextView) findViewById(R.id.questionText);
        questionText.setText(currentCard.getQuestion());

        ImageView image_view = (ImageView) findViewById(R.id.imageView);
        if(currentCard.questionImage != null)
        {

            image_view.setImageBitmap(currentCard.questionImage);
        }

    }

    //for loading images
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        loadData();
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK)
        {
            try {
                ImageView image_view = (ImageView) findViewById(R.id.imageView);
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                currentCard.setQuestionImage(selectedImage);
                image_view.setImageBitmap(currentCard.questionImage);
                //save that image to the card
                saveData();
                }
                catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
        }
        else {
                    Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
                }

    }

    public void returnToDeck(View view)
    {
        Intent intent = new Intent(this, DeckCollectionActivity.class);
        startActivity(intent);
    }

    public void answerCard(View view)
    {
        Intent intent = new Intent(this, AnswerCardActivity.class);
        startActivity(intent);
    }

    public void deleteCard(View view)
    {
        Intent intent = new Intent(this, ViewDeckActivity.class);
        selectedDeck.removeCard(currentCard);
        startActivity(intent);
    }

    public void addImage(View view)
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAGE);
        saveData();
    }

    public void saveData()
    {
        //we save user data to shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",
                MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(deckList);
        editor.putString("deck list", json);
        //this is what saves the deckList to memory
        editor.apply();
    }

    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",
                MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("deck list", null);
        Type type = new TypeToken<Vector<Deck>>() {}.getType();
        deckList = gson.fromJson(json, type);

        if (deckList == null)
        {
            deckList = new Vector<Deck>();
        }
    }
}
