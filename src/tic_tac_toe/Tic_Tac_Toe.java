package tic_tac_toe;

import java.util.Scanner;

public class Tic_Tac_Toe{
	
//		this Tic_Tac_Toe is the manager class which is responsible for conducting the game
		
		private Player player1, player2;//these are the two game players
		private Board board;//this is the board on which the game is to be played
		
		public Tic_Tac_Toe() {//default constructor for this class
			
			
		}
		
		public void startGame() {
			
			Scanner s=new Scanner(System.in);		
					
			player1=takeInput(1);//taking input of player1
			player2=takeInput(2);//taking input of player2
						
			System.out.println("enter the side length of the board(>=3): ");
			int boardSize=s.nextInt();//getting the board size
			
			while(!(boardSize>=3)) {//to make sure we get a valid board size
				System.out.println("enter a valid side length(>=3) : ");
				boardSize=s.nextInt();
			}
			
			board=new Board(boardSize);//making a Board object
			
			System.out.println("the initial arrangement of board is : ");
			board.print();//printing the initial arrangement of the board
			
			boolean player1Turn=true;//first turn is of player1 by default
			
			while(!board.isFull()) {//to keep playing till a winner is found or the board is full
				
				if(player1Turn) {
					System.out.println("enter player1("+player1.getSymbol()+")'s move : ");											
				}
				else {
					System.out.println("enter player2("+player2.getSymbol()+")'s move : ");
				}
				
				int x=s.nextInt();
				int y=s.nextInt();
				
				while(!board.inRange(x, y) || !board.isAvailable(x, y)) {//making sure that the player enters a valid point
					System.out.println("enter a valid point : ");
					x=s.nextInt();
					y=s.nextInt();
				}					
				
				if(player1Turn) {
					board.setValue(x, y, player1.getSymbol());//set the value at x, y corresponding to the player		
					if(board.evaluate(x, y, player1.getSymbol())) {//checking if the player has won
						board.print();//printing the board before displaying the winner		
						System.out.println("PLAYER1 ("+player1.getName()+") WINS!!!");
						return ;
					}
					player1Turn=false;//shift turn to the other player
				}
				else {
					board.setValue(x, y, player2.getSymbol());					
					if(board.evaluate(x, y, player2.getSymbol())) {
						board.print();
						System.out.println("PLAYER2 ("+player2.getName()+") WINS!!!");
						return ;
					}
					player1Turn=true;
				}
				board.print();//print the board after each move
											
			}
			
			System.out.println("ITS A DRAW...");//draw case when no player wins and the board is full
					
		}
		
		private Player takeInput(int num) {//to take input of the player and return a Player object
			
			Scanner s=new Scanner(System.in);
			
			System.out.println("enter the name of player"+num+"(one word) : ");
			String name=s.next();//taking input of name
			
			System.out.println("enter the symbol of player"+num+"(one character) : ");
			String str=s.next();//taking input of symbol
			
			if(num==2) {		
				while(str.charAt(0)==player1.getSymbol()) {//making sure that the symbol of player2 is different from player1
					System.out.println("enter a symbol other than player1's : ");
					str=s.next();
				}			
			}
			
			char symbol=str.charAt(0);//getting player's symbol
			
			Player p=new Player(name, symbol);//making a Player object
			return p;//returning the player
			
		}
		
	}