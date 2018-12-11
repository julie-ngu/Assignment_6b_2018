/****************************************************************************
 *
 * Created by: Julie Nguyen
 * Created on: Dec 2018
 * Created for: ICS4U
 * This is the card class for a console blackjack program
 * 		Generates a card
 *
 ****************************************************************************/

public class Card {
	private Suits _suit;
	private Ranks _rank;
	
	//constructor
	public Card (Suits suit,
				 Ranks rank) {
		
		this._suit = suit;
		this._rank = rank;
	}
	
	public Suits getSuit() {
		return _suit;
	}
	
	public Ranks getRank() {
		return _rank;
	}
}