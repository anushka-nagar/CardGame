/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cardgame;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author anush
 */
public class Game {
    private int currentPlayer;
    private String[] players;
    
    private Deck deck;
    private ArrayList<ArrayList<Card>> playerHand;
    private ArrayList<Card> stackPile;
    
    private Card.Suit validSuit;
    private Card.Value validValue;
    
    boolean gameDirection;
    
    public Game(String[] players) {
        this.players = players;
        deck = new Deck();
        deck.Shuffle();
        stackPile = new ArrayList<Card>();
        currentPlayer = 0;
        gameDirection = false;
        
        playerHand = new ArrayList<ArrayList<Card>>();
        
        for(String player : this.players) {
           ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCards(5)));
           playerHand.add(hand);
        }
    }
    
    public void startGame(){
        Card topCard = deck.drawCard();
        validSuit = topCard.getSuit();
        validValue = topCard.getValue();
        
        switch (validValue) {
            case Ace:{
                JLabel message = new JLabel(players[currentPlayer] + " was skipped!");
                message.setFont(new Font("Ariel", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                if (gameDirection == false){
                    currentPlayer = (currentPlayer + 1) % players.length;
                }   if (gameDirection == true){
                    currentPlayer = (currentPlayer - 1) % players.length;
                    if (currentPlayer == -1){
                        currentPlayer = players.length - 1;
                    }
                }   
                break;
            }
            case King:{
                JLabel message = new JLabel("The game direction was reversed.");
                message.setFont(new Font("Ariel", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                gameDirection = !gameDirection;
                currentPlayer = (currentPlayer - 1) % players.length;
                if (currentPlayer == -1){
                    currentPlayer = players.length - 1;
                }
                break;
            }
            case Queen:{
                getPlayerHand(players[currentPlayer]).addAll(new ArrayList<Card>(Arrays.asList(deck.drawCards(2))));
                break;
            }
            case Jack:{
                getPlayerHand(players[currentPlayer]).addAll(new ArrayList<Card>(Arrays.asList(deck.drawCards(4))));
                break;
            }
            default:
                break;
        }
        stackPile.add(topCard);
    }
    
    public Card getTopCard(){
        return new Card(validSuit,validValue);
    }
    
    public ImageIcon getTopCardImage(){
        Card topCard = new Card(validSuit,validValue);
        return new ImageIcon(topCard.toString() + ".png");
    }
    
    public boolean isGameOver(){
        for (String player : players){
            if (hasEmptyHand(player)){
                return true;
            }
        }
        return false;
    }
    
    public String getCurrentPlayer(){
        return players[currentPlayer];
    }
    
    public String getPreviousPlayer(){
        int previousPlayer = (currentPlayer - 1) % players.length;
        if (previousPlayer == -1){
            previousPlayer = players.length - 1;
        }
        return players[previousPlayer];
    }
    
    public String[] getPlayers(){
        return players;
    }
    
    public ArrayList<Card> getPlayerHand(String player){
        int playerId = Arrays.asList(players).indexOf(player);
        return playerHand.get(playerId);
    }
    
    public int getPlayerHandSize(String player){
        return getPlayerHand(player).size();
    }
    
    public Card getPlayerCard(String player, int choice){
        ArrayList<Card> hand = getPlayerHand(player);
        return hand.get(choice);
    }
    
    public boolean hasEmptyHand(String player){
        return getPlayerHand(player).isEmpty();
    }
    
    public boolean validCardPlay(Card card){
        if (validValue == Card.Value.Ace || validValue == Card.Value.King || validValue == Card.Value.Queen || validValue == Card.Value.Jack){
            return card.getSuit() == validSuit && card.getValue() != validValue;
        }
        return card.getSuit() == validSuit || card.getValue() == validValue;
    }
    
    public void checkPlayerTurn(String player) throws InvalidPlayerTurnException{
        if (!players[currentPlayer].equals(player)){
            throw new InvalidPlayerTurnException("It is not " + player + "'s turn", player);
        }
    }
    
    public void submitDraws(String player, int n) throws InvalidPlayerTurnException{
        checkPlayerTurn(player);
        
        if (deck.isEmpty()){
            //todo: here
            gameOver();
        }
        
        try{
            getPlayerHand(player).addAll(Arrays.asList(deck.drawCards(n)));
        }catch(IllegalArgumentException exp){
            //todo: here
            gameOver();
        }
        
        if(gameDirection == true){
            currentPlayer = (currentPlayer - 1) % players.length;
            if (currentPlayer == -1){
                currentPlayer = players.length - 1;
            }
        }
    }
    
    public void submitPlayerCard(String player, Card card) throws InvalidPlayerTurnException, InvalidSuitException, InvalidValueException{
        checkPlayerTurn(player);
        
        ArrayList<Card> hand = getPlayerHand(player);
        
        if(!validCardPlay(card)){
            String error;
            if(card.getSuit() != validSuit){
                if(card.getValue() != validValue){
                    error = "Invalid move, expected suit: "+ validSuit + " but got suit " + card.getSuit();
                }else{
                    error = "Invalid move, action cards are non-stackable expected suit: "+ validSuit + " but got suit " + card.getSuit();
                }
                JLabel message = new JLabel(error);
                message.setFont(new Font("Ariel", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                throw new InvalidSuitException(error, card.getSuit(),validSuit);
            }
            if(card.getValue() != validValue){
                error = "Invalid move, expected value: "+ validValue + " but got value " + card.getValue();
                JLabel message = new JLabel(error);
                message.setFont(new Font("Ariel", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                throw new InvalidValueException(error, card.getValue(), validValue);
            }
        }
        hand.remove(card);
        
        if(hasEmptyHand(players[currentPlayer])){
            JLabel message = new JLabel("Congratulations! " + players[currentPlayer] + " has won the game! Thank you for playing!");
            message.setFont(new Font("Ariel", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
        }
        
        stackPile.add(card);
        validSuit = card.getSuit();
        validValue = card.getValue();
        
        if(validValue == Card.Value.King){
            JLabel message = new JLabel(players[currentPlayer] + " changed the game direction.");
            message.setFont(new Font("Ariel", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            
            gameDirection = !gameDirection;
            
            if(gameDirection == true){
                currentPlayer = (currentPlayer - 1) % players.length;
                if (currentPlayer == -1){
                    currentPlayer = players.length - 1;
                }
            }else{
                currentPlayer = (currentPlayer + 1) % players.length;
            }
        }else{
            if (gameDirection == false){
                currentPlayer = (currentPlayer + 1) % players.length;
            }else{
                currentPlayer = (currentPlayer - 1) % players.length;
                if (currentPlayer == -1){
                    currentPlayer = this.players.length - 1;
                }
            }
            
            switch (validValue) {
                case Ace:{
                    JLabel message = new JLabel(players[currentPlayer] + " has been skipped!");
                    message.setFont(new Font("Ariel", Font.BOLD, 48));
                    JOptionPane.showMessageDialog(null, message);
                    if (gameDirection == false){
                        currentPlayer = (currentPlayer + 1) % players.length;
                    }else{
                        currentPlayer = (currentPlayer - 1) % players.length;
                        if (currentPlayer == -1){
                            currentPlayer = players.length - 1;
                        }
                    }       break;
                    }
                case Queen:{
                    submitDraws(players[currentPlayer], 2);
                    JLabel message = new JLabel(players[currentPlayer] + " drew 2 cards.");
                    message.setFont(new Font("Ariel", Font.BOLD, 48));
                    JOptionPane.showMessageDialog(null, message);
                        break;
                    }
                case Jack:{
                    submitDraws(players[currentPlayer], 4);
                    JLabel message = new JLabel(players[currentPlayer] + " drew 4 cards.");
                    message.setFont(new Font("Ariel", Font.BOLD, 48));
                    JOptionPane.showMessageDialog(null, message);
                        break;
                    }
                default:
                    break;
            }
        }
    } 
    
    public void gameOver(){
        //todo: Implement me
    }
}

class InvalidPlayerTurnException extends Exception  {
    String player;
    
    public InvalidPlayerTurnException(String message, String player){
        super(message);
        this.player = player;
    }
    
    public String getPlayer(){
        return player;
    }
}

class InvalidSuitException extends Exception  {
    private Card.Suit expected;
    private Card.Suit actual;
    
    public InvalidSuitException(String message, Card.Suit actual, Card.Suit expected){
        super(message);
        this.actual = actual;
        this.expected = expected;
    }
}

class InvalidValueException extends Exception  {
    private Card.Value expected;
    private Card.Value actual;
    
    public InvalidValueException(String message, Card.Value actual, Card.Value expected){
        super(message);
        this.actual = actual;
        this.expected = expected;
    }
}