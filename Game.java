package smelet01.hw2;

import java.util.*;

/**
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class Game {
	/**
	 * This is where the game runs.
	 * 
	 * @param args (not in use)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Board board = new Board();
		board.show();

		char direction = ' ';
		String input = null;
		do {
			do// input checker
			{
				System.out.println("Player move (l - left, r - right, u - up, d - down): ");
				input = sc.nextLine();
				if (input.length() > 0) {
					direction = input.charAt(0);

					if (direction != 'l' && direction != 'r' && direction != 'u' && direction != 'd') {
						System.out.println("Invalid input.");
						board.show(); // reprints the board
					}
				}
			} while (direction != 'l' && direction != 'r' && direction != 'u' && direction != 'd');

			if (!board.applyMove(direction))// this message is for when you try to go back from the way you came
				System.out.println("You cannot move to this direction.");
		} while (!board.isGameOver());

		System.out.println("Game Over! ");

		sc.close();
	}

}
