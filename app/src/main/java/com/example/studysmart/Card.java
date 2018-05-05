package com.example.studysmart;

import android.graphics.Bitmap;

import static android.graphics.Bitmap.Config.ARGB_8888;

public class Card
{
    /*the user will input info into the Card's front and back variables.
    Depending on user input, an xml file will be created for front and back of card.
    We cannot store xml's into objects so all we can do is save the data and
    create the xmls on the fly based on the data we get from user*/

    //user inputted question. Goes on front of card
    String question;
    //user inputted answer. Goes on back of card
    String answer;

    //if user wants to upload a picture as a question
    Bitmap questionImage;
    //if user wants to upload a picture as an answer
    Bitmap answerImage;
    //Bitmap configuration, will be set by us automatically
    Bitmap.Config conf;


    //empty constructor if no info is given
    public Card()
    {
        this.conf = ARGB_8888;
    }

    //half constructor, if only a question and answer is given
    public Card(String q, String a)
    {
        this.question = q;
        this.answer = a;
    }

    //half constructor if only pictures are given
    public Card(Bitmap qi, Bitmap ai)
    {
        this.questionImage = qi;
        this.answerImage = ai;
    }

    //full constructor if all info is given
    public Card(String q, String a, Bitmap qi, Bitmap ai)
    {
        this.question = q;
        this.answer = a;
        this.questionImage = qi;
        this.answerImage = ai;
        //this Bitmap configuration save images with 4 bytes per pixel. Don't worry too much
        //about what it means, only for where to put it.
        this.conf = ARGB_8888;
    }

    /*methods*/////////////////////////////////////////////////////////////////////////////////////

    String getQuestion()
    {
        return question;
    }

    String getAnswer()
    {
        return answer;
    }

    Bitmap getQuestionImage()
    {
        return questionImage;
    }

    Bitmap getAnswerImage()
    {
        return answerImage;
    }

    void setQuestion(String q)
    {
        question = q;
    }

    void setAnswer(String a)
    {
        answer = a;
    }

    void setQuestionImage(Bitmap qi)
    {
        questionImage = qi;
    }

    void setAnswerImage(Bitmap ai)
    {
        answerImage = ai;
    }

}
