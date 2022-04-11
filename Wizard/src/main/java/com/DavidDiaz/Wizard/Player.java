package com.DavidDiaz.Wizard;

import java.util.Iterator;

class Player {
    protected String name;
    protected int score;
    protected int currentGuess;
    protected SimpleLinkedList<Card> hand;
    
    public Player( String name ){
        this.name = name;
        score = 0;
        currentGuess = 0;
        hand = new SimpleLinkedList<>();
    }
    
    /**
     * Set prediction for current player
     */
    public void setGuess(){
        int a = -1;
        String question = "Introduce una prediccion para:  " + name;
        String format = "Introduce un numero del " + 0 + " al " + GameManager.currentRound.numberOfRound;
        String defaultValue = "1";
        while( a < 0 || a > GameManager.currentRound.numberOfRound){
            String input = App.askForUserInput(question, format, defaultValue);
            a = Integer.parseInt(input);
            if( a < 0 || a > GameManager.currentRound.numberOfRound){
                System.out.println("Invalid Guess for " + name);
            }
        }
        currentGuess = a;
    }

    /**
     * Validates if player can play the card 
     */
    public  boolean validateCard( String cardStr, int leaderFigure){
        //Validates that cardStr is a valid card
        Card c = Card.StrToCard(cardStr);
        if( c == null )
            return false;

        //Validates that player has the card in his hand
        if(!hand.contains(c))
            return false;
        
        //if leaderFigure is invalid(no leader figure yet) return true
        if(leaderFigure<= 0 || leaderFigure >4)
            return true;
        
        //If player has a card of the leaderFigure it hast to play one of those cards
        String leaderFigStr = RegularCard.getFigureStr(leaderFigure);
        if(c.getFigureStr() != leaderFigStr && handContainsFigure(leaderFigStr)){
            return false;
        }

        return true;

    }

    /**
     * Check if the hand of the player has a card with the specified figure
     * @return
     */
    public boolean handContainsFigure(String figure){
        Iterator<Card> it = hand.begin();
        while(it.hasNext()){
            Card c = it.next();
            if(c.getFigureStr() == figure){
                return true;
            }
        }
        return false;
    }

}
