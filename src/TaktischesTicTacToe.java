import java.util.Scanner;

public class TaktischesTicTacToe {
	
	static Scanner input = new Scanner(System.in);
	static boolean firstMoveDone = false; 
	static int currentPanel = 0;
	
	public static void main(String[] args) {
		
		 boolean gameOver = false;

		
		
		String[][] gameBoard = {
				{"_","_","_","_","_","_","_","_","_"},
				{"_","_","_","_","_","_","_","_","_"},
				{"_","_","_","_","_","_","_","_","_"},
				{"_","_","_","_","_","_","_","_","_"},
				{"_","_","_","_","_","_","_","_","_"},
				{"_","_","_","_","_","_","_","_","_"},
				{"_","_","_","_","_","_","_","_","_"},
				{"_","_","_","_","_","_","_","_","_"},
				{"_","_","_","_","_","_","_","_","_"}
		};
		
		String[][] progressTracker = {
				{"1","2","3","4","5","6","7","8","9"}, // X and o
				{"0","0","0","0","0","0","0","0","0"} // has field been set one?
		};
		
		printGameboard(gameBoard);
		printProgressTracker(progressTracker);
		
		while (!gameOver) {
			player1Move(gameBoard, progressTracker);
			gameOver = isGameOver(progressTracker);
			if (gameOver) break;
			player2Move(gameBoard, progressTracker);
			gameOver = isGameOver(progressTracker);
			if (gameOver) break;
		}
		
	}
	
	
	public static void printGameboard(String[][] gb) {
		/* Layout Game Board:
		 *  _______________________________________________________
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |  1  |  2  |  3  ||  1  |  2  |  3  ||  .  |  .  |  .  |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |  4  |  5  |  6  ||  4  |  5  |  6  ||     |     |     |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |  7  |  8  |  9  ||  7  |  8  |  9  ||     |     |     |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 * |_________________||_________________||_________________|
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 * |_________________||_________________||_________________|
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |     |     |     ||     |     |     ||     |     |     |
		 * |_____|_____|_____||_____|_____|_____||_____|_____|_____|
		 */
		System.out.println("\nGame Board:");
		System.out.println(
				" _______________________________________________________\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[0][0] + "  |  " + gb[0][1] + "  |  " + gb[0][2] + "  ||  " + gb[1][0] + "  |  " + gb[1][1] + "  |  " + gb[1][2] + "  ||  " + gb[2][0] + "  |  " + gb[2][1] + "  |  " + gb[2][2] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[0][3] + "  |  " + gb[0][4] + "  |  " + gb[0][5] + "  ||  " + gb[1][3] + "  |  " + gb[1][4] + "  |  " + gb[1][5] + "  ||  " + gb[2][3] + "  |  " + gb[2][4] + "  |  " + gb[2][5] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[0][6] + "  |  " + gb[0][7] + "  |  " + gb[0][8] + "  ||  " + gb[1][6] + "  |  " + gb[1][7] + "  |  " + gb[1][8] + "  ||  " + gb[2][6] + "  |  " + gb[2][7] + "  |  " + gb[2][8] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|\r\n"
				+ "|_________________||_________________||_________________|\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[3][0] + "  |  " + gb[3][1] + "  |  " + gb[3][2] + "  ||  " + gb[4][0] + "  |  " + gb[4][1] + "  |  " + gb[4][2] + "  ||  " + gb[5][0] + "  |  " + gb[5][1] + "  |  " + gb[5][2] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[3][3] + "  |  " + gb[3][4] + "  |  " + gb[3][5] + "  ||  " + gb[4][3] + "  |  " + gb[4][4] + "  |  " + gb[4][5] + "  ||  " + gb[5][3] + "  |  " + gb[5][4] + "  |  " + gb[5][5] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[3][6] + "  |  " + gb[3][7] + "  |  " + gb[3][8] + "  ||  " + gb[4][6] + "  |  " + gb[4][7] + "  |  " + gb[4][8] + "  ||  " + gb[5][6] + "  |  " + gb[5][7] + "  |  " + gb[5][8] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|\r\n"
				+ "|_________________||_________________||_________________|\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[6][0] + "  |  " + gb[6][1] + "  |  " + gb[6][2] + "  ||  " + gb[7][0] + "  |  " + gb[7][1] + "  |  " + gb[7][2] + "  ||  " + gb[8][0] + "  |  " + gb[8][1] + "  |  " + gb[8][2] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[6][3] + "  |  " + gb[6][4] + "  |  " + gb[6][5] + "  ||  " + gb[7][3] + "  |  " + gb[7][4] + "  |  " + gb[7][5] + "  ||  " + gb[8][3] + "  |  " + gb[8][4] + "  |  " + gb[8][5] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|\r\n"
				+ "|     |     |     ||     |     |     ||     |     |     |\r\n"
				+ "|  " + gb[6][6] + "  |  " + gb[6][7] + "  |  " + gb[6][8] + "  ||  " + gb[7][6] + "  |  " + gb[7][7] + "  |  " + gb[7][8] + "  ||  " + gb[8][6] + "  |  " + gb[8][7] + "  |  " + gb[8][8] + "  |\r\n"
				+ "|_____|_____|_____||_____|_____|_____||_____|_____|_____|");
	};

	public static void printProgressTracker(String[][] pt) {
		/* Progress tracker:
		 *  _________________
		 * |     |     |     |
		 * |  1  |  2  |  3  |
		 * |_____|_____|_____|
		 * |     |     |     |
		 * |  4  |  5  |  6  |
		 * |_____|_____|_____|
		 * |     |     |     |
		 * |  7  |  8  |  9  |
		 * |_____|_____|_____|
		 */
		System.out.println("\nProgress Tracker:");
		System.out.println(
				" _________________\r\n"
				+ "|     |     |     |\r\n"
				+ "|  " + pt[0][0] + "  |  " + pt[0][1] + "  |  " + pt[0][2] + "  |\r\n"
				+ "|_____|_____|_____|\r\n"
				+ "|     |     |     |\r\n"
				+ "|  " + pt[0][3] + "  |  " + pt[0][4] + "  |  " + pt[0][5] + "  |\r\n"
				+ "|_____|_____|_____|\r\n"
				+ "|     |     |     |\r\n"
				+ "|  " + pt[0][6] + "  |  " + pt[0][7] + "  |  " + pt[0][8] + "  |\r\n"
				+ "|_____|_____|_____|"
				);
	}
	
	public static void updateGameBoard(int player, int position, String[][] gameBoard) {
		
		// gb ^= Game Board
		// pt ^= Progress Tracker
		String sign = "?";
		
		if (player == 1) {
			sign = "X";
		}
		if (player == 2) {
			sign = "O";
		}
		
		
		switch (position) {
		
		case 1:
			gameBoard[currentPanel][0] = sign;
			printGameboard(gameBoard);
			break;
		case 2:
			gameBoard[currentPanel][1] = sign;
			printGameboard(gameBoard);
			break;
		case 3:
			gameBoard[currentPanel][2] = sign;
			printGameboard(gameBoard);
			break;
		case 4:
			gameBoard[currentPanel][3] = sign;
			printGameboard(gameBoard);
			break;
		case 5:
			gameBoard[currentPanel][4] = sign;
			printGameboard(gameBoard);
			break;
		case 6:
			gameBoard[currentPanel][5] = sign;
			printGameboard(gameBoard);
			break;
		case 7:
			gameBoard[currentPanel][6] = sign;
			printGameboard(gameBoard);
			break;
		case 8:
			gameBoard[currentPanel][7] = sign;
			printGameboard(gameBoard);
			break;
		case 9:
			gameBoard[currentPanel][8] = sign;
			printGameboard(gameBoard);
			break;
		
		default: 
			break;
		}
	}
	
	public static void player1Move(String[][] gameBoard, String[][] progressTracker) {
		//first Move
		if (firstMoveDone == false) {
			System.out.print("Player 1: Please choose a panel, you would like to start with (1-9): ");
			int pick = input.nextInt();
			while (pick < 1 || pick > 9) {
				System.out.print("Sorry, please try again (1-9): ");
				pick = input.nextInt();
			}
			currentPanel = pick - 1;
			firstMoveDone = true;
		}
		
		//Move in chosen Panel
		System.out.println("> Player 1: You are currently in panel " + (currentPanel+1));
		System.out.print("> Please choose a field within the panel (1-9): ");
		int move = input.nextInt();
		boolean moveValid = isMoveValid(move, gameBoard);  
		
		while(!moveValid) {
			System.out.print("Sorry, Input invalid. Try again (1-9): ");
			move = input.nextInt();
			moveValid = isMoveValid(move, gameBoard);
		}
		
		updateGameBoard(1, move, gameBoard);
		System.out.println("Player 1 moved in panel " + (currentPanel+1) + " field " + move);
		
		updateProgressTracker(progressTracker, gameBoard, 1);
		currentPanel = move - 1;
		
	}
	
	public static void player2Move(String[][] gameBoard, String[][] progressTracker) {
		
		System.out.println("> Player 2: You are currently in panel " + (currentPanel+1));
		System.out.print("> Please choose a field within the panel (1-9): ");
		int move = input.nextInt();
		boolean moveValid = isMoveValid(move, gameBoard);  
		
		while(!moveValid) {
			System.out.print("Sorry, Input invalid. Try again (1-9): ");
			move = input.nextInt();
			moveValid = isMoveValid(move, gameBoard);
		}
		
		updateGameBoard(2, move, gameBoard);
		System.out.println("Player 2 moved in panel " + (currentPanel+1) + " field " + move);
		
		updateProgressTracker(progressTracker, gameBoard, 2);
		currentPanel = move - 1;
	}
	
	public static boolean isMoveValid(int move, String[][] gameBoard) {
		
		
		int mv = move -1;
		switch (move) {
		case 9:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		case 1:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		case 2:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		case 3:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		case 4:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		case 5:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		case 6:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		case 7:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		case 8:
			if (gameBoard[currentPanel][mv] == "_" ) return true;
		
		default:
			return false;
		
		}
			
	}
	
	public static void updateProgressTracker(String[][] progressTracker, String[][] gameBoard, int player) {
		String sign = "?";
		
		if (player == 1) sign = "X";
		if (player == 2) sign = "O";
		
		String[][] gb = gameBoard;
		
		
		//HORIZONTAL
		
		switch (gb[currentPanel][0] + gb[currentPanel][1] + gb[currentPanel][2]) {
		
		case "XXX":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
		
		case "OOO":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		default:
			break;
		}
		
		
		switch (gb[currentPanel][3] + gb[currentPanel][4] + gb[currentPanel][5]) {
		
		case "XXX":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
		
		case "OOO":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		default:
			break;
		}
		
		
		switch (gb[currentPanel][6] + gb[currentPanel][7] + gb[currentPanel][8]) {
		
		case "XXX":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		case "OOO":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		default:
			break;
		}
		
		
		// VERTICAL
		
		switch (gb[currentPanel][0] + gb[currentPanel][3] + gb[currentPanel][6]) {
		
		case "XXX":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
		
		case "OOO":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		default:
			break;
		}
		
		
		switch (gb[currentPanel][1] + gb[currentPanel][4] + gb[currentPanel][7]) {
		
		case "XXX":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
		
		case "OOO":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		default:
			break;
		}
		
		
		switch (gb[currentPanel][2] + gb[currentPanel][5] + gb[currentPanel][8]) {
		
		case "XXX":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		case "OOO":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		default:
			break;
		}
		
		
		// DIAGONAL
		
		switch (gb[currentPanel][0] + gb[currentPanel][4] + gb[currentPanel][8]) {
		
		case "XXX":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
		
		case "OOO":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		default:
			break;
		}
		
		
		switch (gb[currentPanel][2] + gb[currentPanel][4] + gb[currentPanel][6]) {
		
		case "XXX":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
		
		case "OOO":
			if (progressTracker[1][currentPanel] == "0") {
				progressTracker[1][currentPanel] = "1";
				progressTracker[0][currentPanel] = sign;
			}
			break;
			
		default:
			break;
		}
		
		//IF TIE > LAST PLAYER GETS POINT
		if (gb[currentPanel][0] != "_" && gb[currentPanel][1] != "_" && gb[currentPanel][2] != "_" &&
				gb[currentPanel][3] != "_" && gb[currentPanel][4] != "_" && gb[currentPanel][5] != "_" && 
				gb[currentPanel][6] != "_" && gb[currentPanel][7] != "_" && gb[currentPanel][8] != "_") {
			progressTracker[1][currentPanel] = "1";
			progressTracker[0][currentPanel] = sign;
			
		}
		printProgressTracker(progressTracker);
		
	}
	
	public static boolean isGameOver(String[][] progressTracker) {
		String[][] pt = progressTracker;

		//Horizontal
		
		switch (pt[0][0] + pt[0][1] + pt[0][2]) {
		case "XXX":
			System.out.println("> > > Player 1 wins!!! < < <");
			return true;
		case "OOO":
			System.out.println("> > > Player 2 wins!!! < < <");
			return true;
		}
		switch (pt[0][3] + pt[0][4] + pt[0][5]) {
		case "XXX":
			System.out.println("> > > Player 1 wins!!! < < <");
			return true;
		case "OOO":
			System.out.println("> > > Player 2 wins!!! < < <");
			return true;
		}
		switch (pt[0][6] + pt[0][7] + pt[0][8]) {
		case "XXX":
			System.out.println("> > > Player 1 wins!!! < < <");
			return true;
		case "OOO":
			System.out.println("> > > Player 2 wins!!! < < <");
			return true;
		}
		
		
		//Vertical

		switch (pt[0][0] + pt[0][3] + pt[0][6]) {
		case "XXX":
			System.out.println("> > > Player 1 wins!!! < < <");
			return true;
		case "OOO":
			System.out.println("> > > Player 2 wins!!! < < <");
			return true;
		}
		switch (pt[0][1] + pt[0][4] + pt[0][7]) {
		case "XXX":
			System.out.println("> > > Player 1 wins!!! < < <");
			return true;
		case "OOO":
			System.out.println("> > > Player 2 wins!!! < < <");
			return true;
		}
		switch (pt[0][2] + pt[0][5] + pt[0][8]) {
		case "XXX":
			System.out.println("> > > Player 1 wins!!! < < <");
			return true;
		case "OOO":
			System.out.println("> > > Player 2 wins!!! < < <");
			return true;
		}
		
		
		// Diagonal

		switch (pt[0][0] + pt[0][4] + pt[0][8]) {
		case "XXX":
			System.out.println("> > > Player 1 wins!!! < < <");
			return true;
		case "OOO":
			System.out.println("> > > Player 2 wins!!! < < <");
			return true;
		}
		switch (pt[0][2] + pt[0][4] + pt[0][6]) {
		case "XXX":
			System.out.println("> > > Player 1 wins!!! < < <");
			return true;
		case "OOO":
			System.out.println("> > > Player 2 wins!!! < < <");
			return true;
		}
		
		
		//Tie
		
		if (pt[0][0] != "1" && pt[0][1] != "2" && pt[0][2] != "3" && 
				pt[0][3] != "4" && pt[0][4] != "5" && pt[0][5] != "6" && 
				pt[0][6] != "7" && pt[0][7] != "8" && pt[0][8] != "9") {
			System.out.println("> > > It's a tie!!! < < <");
			return true;
		}
		
		return false;
		
	}
	
}