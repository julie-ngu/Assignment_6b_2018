/****************************************************************************
 *
 * Created by: Julie Nguyen
 * Created on: Dec 2018
 * Created for: ICS4U
 * This is the main file for a console blackjack program
 *
 ****************************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
	public static void main(String[] args) {
		// main, get user input here
		Scanner input = new Scanner(System.in);
		int playerMoney = 100;
		int LIMIT = 21;
		
		System.out.print("Welcome to Blackjack! ");
		do {
			System.out.print("You have $" + playerMoney + ". How much would you like to bet this round? ");
			
			if(input.hasNextInt()) {
				int bet = input.nextInt();
				input.nextLine(); 
				//consumes \n (scanner will wait for next input)
				
				if(bet <= playerMoney && bet > 0) {
					Deck deck = new Deck();
					deck.generateDeck();
					deck.shuffleDeck();
					
					ArrayList<Card> playerHand = new ArrayList<Card>();
					ArrayList<Card> compHand = new ArrayList<Card>();
					
					deck.deal(playerHand);
					deck.deal(compHand);
					
					System.out.println("\nYour hand: ");
					deck.printHand(playerHand);
					
					System.out.println("\nDealer's hand: ");
					deck.printCard(compHand);
					System.out.println("(hidden)");
					
					System.out.print("\nHit or stand? ");
					
					if(input.hasNextLine()) {
						String choice = input.nextLine();
						if(choice.equalsIgnoreCase("Hit") || choice.equalsIgnoreCase("H")) {
							deck.hit(playerHand);
							System.out.println("\nYour hand: ");
							deck.printHand(playerHand);
							
							System.out.println("\nDealer's hand: ");
							deck.printHand(compHand);
						}
						else if(choice.equalsIgnoreCase("Stand") || choice.equalsIgnoreCase("S")){
							deck.printHand(playerHand);

							System.out.println("\nDealer's hand: ");
							deck.printHand(compHand);
						}
						else {
							System.out.print("Error");
							System.exit(0);
						}
						
						int playerVal = deck.getValues(playerHand);
						int compVal = deck.getValues(compHand);
						
						if(playerVal > LIMIT) {
							System.out.println("\nYou bust! House wins!");
							playerMoney -= bet;
						}
						else if(playerVal == compVal) {
							System.out.println("\nIt's a tie! House wins!");
							playerMoney -= bet;
						}
						else if(playerVal > compVal && playerVal <= LIMIT) {
							System.out.println("\nYou win!");
							playerMoney += bet;
						}
						else {
							System.out.println("\nHouse wins!");
							playerMoney -= bet;
						}
						
						if(playerMoney > 0) {
							System.out.println("\nAnother Round? (Y/N) ");
							
							if(input.hasNextLine()) {
								String nextRound = input.nextLine();
								
								if(nextRound.equalsIgnoreCase("Yes") || nextRound.equalsIgnoreCase("Y")) {
									System.out.println("\n(Your current score: " + playerMoney + ")\n");
								}
								else if(nextRound.equalsIgnoreCase("No") || nextRound.equalsIgnoreCase("N")) {
									System.out.println("\nYour final score: " + playerMoney + "\nSee ya next time!\n");
									System.exit(0);
								}
								else {
									System.out.print("Error\n");
									System.exit(0);
								}
							}
							else {
								System.out.print("Error\n");
								System.exit(0);
							}
						}
						else {
							System.out.print("\nYour current score: " + playerMoney + "\nYikes. You're out of money! See ya, chump!\n");
							System.exit(0);
						}
					}
					else {
						System.out.print("Error\n");
						System.exit(0);
					}
				}
				else {
					System.out.print("Error\n");
					System.exit(0);
				}
			}
			else {
				System.out.print("Error\n");
				System.exit(0);
			}
		} while (playerMoney > 0);
	}
}