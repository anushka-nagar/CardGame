/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cardgame;

/**
 *
 * @author anush
 */
public class Card {
    enum Suit {
        Heart, Spade, Diamond, Club;
        
        private static final Suit[] suits = Suit.values();
        public static Suit getSuit(int i) {
            return Suit.suits[i];
        }
    }
    
    enum Value {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
        
        private static final Value[] values = Value.values();
        public static Value getValue(int i) {
            return Value.values[i];
        }
    }
    
    private final Suit suit;
    private final Value value;
    
    public Card (final Suit suit,final Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    public Suit getSuit(){
        return this.suit;
    }
    
    public Value getValue(){
        return this.value;
    }
    
    public String toString() {
        return this.suit + "_" + this.value;
    }
}
