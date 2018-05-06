package com.example.studysmart;

import android.content.SharedPreferences;

import java.util.Random;
import java.util.Vector;

public class Deck {
    //vectors hold Card objects. Vectors do not need a fixed size so they are better than arrays

    //when cards are first added, they go into the unseen vector
    Vector<Card> unseen_v;

    //used to keep track of cards in order. Is never used except to display the cards
    Vector<Card> inOrder_v;

    //the three difficulty arrays
    Vector<Card> easy_v;
    Vector<Card> medium_v;
    Vector<Card> hard_v;

    String name;
    String subject;

    int totalSize;




    //constructor
    public Deck(String n, String s)
    {
        this.name = n;
        this.subject = s;
        this.totalSize = 0;

        this.unseen_v = new Vector<Card>();
        this.inOrder_v = new Vector<Card>();
        this.easy_v = new Vector<Card>();
        this.medium_v = new Vector<Card>();
        this.hard_v = new Vector<Card>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String s)
    {
        subject = s;
    }

    //saves instance of the deck. may need to put in activity file or somewhere else
    public void saveDeck()
    {

    }


    public void addCard(Card card)
    {
        this.unseen_v.addElement(card);
        this.inOrder_v.addElement(card);
        this.totalSize++;

        //save this deck to file
        saveDeck();
    }

    //if user says card was easy
    public void addCardToEasy(Card card) { this.easy_v.addElement(card); }

    //if user says card was medium
    public void addCardToMedium(Card card) { this.medium_v.addElement(card); }

    //if user says card was hard
    public void addCardToHard(Card card) { this.hard_v.addElement(card); }

    public void viewCardsInOrder()
    {
        for (Card card : inOrder_v)
        {
            System.out.println(card.question);
        }
    }

    public void removeCard(Card card)
    {
        //will need to check all 4 vectors (unseen, easy, medium, hard) to look for card to delete
        this.unseen_v.removeElement(card);
        this.inOrder_v.removeElement(card);
        this.easy_v.removeElement(card);
        this.medium_v.removeElement(card);
        this.hard_v.removeElement(card);

        this.totalSize--;

        //save this deck to file
        saveDeck();
    }


    public Card getNextCard()
    {
        //we either take a card out of the unseen deck or one of the difficulty decks to show the
        // user next
        //it is more likely to get a card that the user hasn't seen yet, so the "weight" of the
        //unseen deck will be higher than the weight of the other decks combined.
        //the weight is out of 10 points total;
        //unseen: 7
        //rest of the decks: 3
        //We pick a random integer between 0 and 10
        //if the number is between 0 and 6 (weight 7), inclusive, take unseen card
        //if the number is between 7 and 10 (weight 3), inclusive, take difficulty-type card
        Random r = new Random();
        int low = 0;
        int high1 = 10;

        //method to get a random number. produces a number between 0 and 10, inclusive
        int random = r.nextInt(high1 - low) + low;

        if (random >= 0 && random <= 6)
        {
            int tempHigh = unseen_v.size();

            //returns card at random index in unseen vector
            return easy_v.get(r.nextInt(tempHigh - low) + low);

        }

        else
        {

            //each difficulty deck has a weight, out of 20:
            //Easy: 2
            //Medium: 8
            //Hard: 10
            //We pick a random integer between 0 and 20
            //if the number is between 0 and 1 (weight 2), inclusive, take a easy card
            //if the number is between 2 and 10 (weight 8), inclusive, take a medium card
            //if it is between 11 and 20 (weight 10), inclusive, take an hard card

            /*set the bounds for easy cards
            int easyLow = 0;
            int easyHigh = 1;
            //set the bounds for medium cards
            int mediumLow = 2;
            int mediumHigh = 10;
            //set the bounds for hard cards
            int hardLow = 11;
            int hardHigh = 20;*/

            //bound for the random number of difficulty deck
            int high = 20;

            //now get number between 0 and 20
            int randInt = r.nextInt(high - low) + low;


            if (randInt >= 0 && randInt <= 1)
            {
                int tempHigh = easy_v.size();

                //returns card at random index in easy vector
                return easy_v.get(r.nextInt(tempHigh - low) + low);
            }

            else if (randInt >= 2 && randInt <= 10)
            {
                int tempHigh = medium_v.size();

                //returns card at random index in medium vector
                return medium_v.get(r.nextInt(tempHigh - low) + low);
            }

            else {

                int tempHigh = hard_v.size();
                //returns card at random index in hard vector
                return hard_v.get(r.nextInt(tempHigh - low) + low);
            }
        }
    }
}