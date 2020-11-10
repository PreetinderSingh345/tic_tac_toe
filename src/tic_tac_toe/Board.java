package tic_tac_toe;
	public class Board{
		
//		this is the Board class to handle the board related part of the game 
		
		private char board[][];//this is the board on which the game is to be played
		private int boardSize;//this is the size of that square board
		
		
		public Board(int boardSize) {
			
			this.boardSize=boardSize;//set the board size to the given value 
						
			board=new char[boardSize][boardSize];//make a board of that size
			
		}
		
		public void setValue(int x, int y, char ch) {//to set the value ch at x, y point on the board
			
			board[x][y]=ch;		
			
		}
		
		public char getValue(int x, int y) {//to get the value at x, y point on the board
			
			return board[x][y];
			
		}
		
		public boolean evaluate(int x, int y, char ch) {			
			
			int j=0;
			while(j<boardSize && board[x][j]==ch) {//checking if xth row is filled completely with ch or not
				j++;
			}
			if(j==boardSize) {
				return true;
			}
			
			int i=0;
			while(i<boardSize && board[i][y]==ch) {//checking if yth col is filled completely with ch or not
				i++;
			}
			if(i==boardSize) {
				return true;
			}
			
			
			if(x==y) {//checking the top left to bottom right diagonal
				i=0;
				while(i<boardSize && board[i][i]==ch) {
					i++;
				}
				if(i==boardSize) {
					return true;
				}
			}
			
			if((x+y)==(boardSize-1)) {	//checking the top right to bottom left diagonal
				i=0;
				while(i<boardSize && board[i][boardSize-1-i]==ch) {
					i++;
				}
				if(i==boardSize) {
					return true;
				}		
			}
					
			return false;//player is not winning with the current move
			
		}
		
		public boolean isFull() {//checking whether board is full or not
			
			for(int i=0;i<boardSize;i++) {
				for(int j=0;j<boardSize;j++) {
					if(board[i][j]=='\0') {
						return false;
					}
				}
			}
			return true;
			
		}
		
		public int getSize() {//to get the size of the board
			
			return boardSize;
			
		}
		
		public boolean inRange(int x,int y) {//to check if x, y point is within board range or not
			
			return (x>=0 && x<boardSize && y>=0 && y<boardSize);
					
		}
		
		public boolean isAvailable(int x, int y) {//to check if x, y is a valid point in terms of availability
			
			return (board[x][y]=='\0');
			
		}
		
		public void print() {//to print the board
					
			System.out.print("   ");
			for(int i=0;i<boardSize;i++) {
				System.out.print("---");
			}
			System.out.println();
			System.out.print("   ");
			for(int i=0;i<boardSize;i++) {
				System.out.print("|"+i+"|");
			}
			System.out.println();
			
			for(int i=0;i<boardSize;i++) {
				System.out.print("|"+i+"|");
				for(int j=0;j<boardSize;j++) {				
					if(board[i][j]=='\0') {
						System.out.print("| |");
					}
					else {
						System.out.print("|"+board[i][j]+"|");
					}
				}
				System.out.println();
			}
			
			System.out.print("   ");
			for(int i=0;i<boardSize;i++) {
				System.out.print("---");
			}
			System.out.println();
			
		}
		
	}