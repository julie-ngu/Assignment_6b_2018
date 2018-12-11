/****************************************************************************
 *
 * Created by: Julie Nguyen
 * Created on: Dec 2018
 * Created for: ICS4U
 * This is the deck class for a console blackjack program
 *
 ****************************************************************************/

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> _cardDeck = new ArrayList<Card>();
	
	// constructor
	public Deck() {
		// no parameters are needed
	}
	
	public void generateDeck() {
		// creates a standard deck of cards
		for(Suits suit : Suits.values()) {
			for(Ranks rank : Ranks.values()) {
				_cardDeck.add(new Card(suit, rank));
			}
		}
	}
	
	public void printHand(ArrayList<Card> hand) {
		// prints hand and total value of hand of player 
		System.out.println();
		for(Card card : hand) {
			System.out.print(card.getRank() + " " + card.getSuit() + "\n");
		}
		System.out.println("Total Value: " + getValues(hand));
	}
	
	public void printCard(ArrayList<Card> hand) {
		// prints one card from hand
		Random randGen = new Random();
		int randInd = randGen.nextInt(hand.size() - 1);
		Card card = hand.get(randInd);
		System.out.print(card.getRank() + " " + card.getSuit() + "\n");
	}
	
	public void shuffleDeck() {
		// shuffles deck
		Collections.shuffle(_cardDeck);
	}
	
	public ArrayList<Card> deal(ArrayList<Card> hand) {
		// deals cards from top of deck
		if(hand.size() == 2) {
			return hand;
		}
		else {
			Card card = _cardDeck.get(_cardDeck.size()-1);
			
			hand.add(card);
			_cardDeck.remove(card);
			deal(hand);
		}
		
		return hand;
	}
	
	public void hit(ArrayList<Card> hand) {
		// gives the card from top of deck
		Card card = _cardDeck.get(_cardDeck.size()-1);
		hand.add(card);
		_cardDeck.remove(card);
	}
	
	public int getValues(ArrayList<Card> hand) {
		// gets suit and rank of card
		int value = 0;
		int aceVal = 0;
		
		for(Card card : hand) {
			switch(card.getRank()) {
			
			case TWO:
				value += 2;
				break;

			case THREE:
				value += 3;
				break;
			
			case FOUR:
				value += 4;
				break;

			case FIVE:
				value += 5;
				break;
			
			case SIX:
				value += 6;
				break;

			case SEVEN:
				value += 7;
				break;
			
			case EIGHT:
				value += 8;
				break;

			case NINE:
				value += 9;
				break;
			
			case TEN:
				value += 10;
				break;

			case JACK:
				value += 10;
				break;
			
			case QUEEN:
				value += 10;
				break;

			case KING:
				value += 10;
				break;
			
			case ACE:
				aceVal += 1;
				break;
			}
			
			for(int count = 0; count < aceVal; count++) {
				if(value > 10) {
					value += 1;
				}
				else {
					value += 11;
				}
			}
		}
		return value;
	}
}