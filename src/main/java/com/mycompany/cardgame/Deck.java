/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cardgame;

import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author anush
 */
public class Deck {
    private Card cards[];
    private int cardsInDeck;
    
    public void reset() {
        Card.Suit[] suits = Card.Suit.values();
        Card.Value[] values = Card.Value.values();
        cardsInDeck = 0;

        for (Card.Suit suit : suits) {
            for (Card.Value value : values) {
                cards[cardsInDeck++] = new Card(suit, value);
            }
        }
    } 
    
    public void replaceDeckWith(ArrayList<Card> cards) {
        this.cards = cards.toArray(new Card[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }
    
    public boolean isEmpty() {
        return cardsInDeck == 0;
    }
    
    public void Shuffle() {
         for ( int i = cards.length-1; i > 0; i-- ) {
            int random = (int)(Math.random()*(i+1));
            Card tempCard = cards[i];
            cards[i] = cards[random];
            cards[random] = tempCard;
        }
    }
    
    public Card drawCard() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot draw a card because the deck is empty.");
        }
        
        return cards[--cardsInDeck];
    }
    
    public ImageIcon drawCardImage() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot draw a card because the deck is empty.");
        }
        
        return new ImageIcon(cards[--cardsInDeck].toString() + ".png");
    }
    
    public Card[] drawCards(int n) throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot draw a card because the deck is empty.");
        }
        
        if (n < 0) {
            throw new IllegalArgumentException("Must draw positive number of cards, requested " + n + " cards.");
        }
        
        if (n > cardsInDeck) {
            throw new IllegalArgumentException("Cannot draw " + n + " cards as the number of cards in the deck are " + cardsInDeck);
        }
        
        Card[] drawnCards = new Card[n];
        
        for (int i = 0; i < n; i++){
            drawnCards[i] = cards[--cardsInDeck];
        }
        
        return drawnCards;
    }
}

