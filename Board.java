package smelet01.hw2;
/**
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class Board 
{
	private char[][] table;
	private Snake snake;
	private Cell food;
	private RandomCellSelector selector;
	
	/**
	 * First Constructor.
	 * This is the N for the size of the table (Nx2*N+1)
	 * Calls the second constructor
	 */
	public Board() 
	{
		this(8);
	}
	
	/**
	 * Second Constructor.
	 * @param N size of board 
	 */
	public Board(int N)
	{
		table = new char[N][2 * N + 1];
		snake = new Snake(N);
		selector = new RandomCellSelector(N);	
		food = null;
				
		addFood();		
		rePrint();
	}
	
	/**
	 * Adds food on a random location.
	 * Checks if the cell is empty first(its not the snake)
	 */
	public void addFood() 
	{
		Cell c = selector.getRandomCell();//takes a random cell
		
		while (snake.ownsCell(c) || (food != null && food.equals(c))) //if the cell that was picked has snake or another food picks again
		{		
			c = selector.getRandomCell();
		}
			
		food = c;		//adds food on the c cell
	}
	
	/**
	 *Prints the board after every move. 
	 *Prints it with the updated position of the snake and food
	 */
	public void rePrint() 
	{		
		for (int i = 0; i < table.length; i++)
		{
			for (int j = 0; j < table[i].length; j++)
			{								
				table[i][j] = '.';			
			}
		}
		
		//set the food
		table[food.getY()][food.getX()] = '$';
		
		//set the snake
		Cell c = snake.getCell(0);
		
		table[c.getY()][c.getX()] = 'X';
		
		for (int i = 1; i < snake.getLength(); i++)
		{
			c = snake.getCell(i);
			table[c.getY()][c.getX()] = 'o';
		}		
	}
	
	/**
	 * Creates/Prints the grid of the board.
	 */
	public void show() 
	{			
		System.out.print(" ");
		
		for (int j = 0; j < table[0].length; j++)
		{
			System.out.print("=");
		}
		
		System.out.println();
		
		for (int i = 0; i < table.length; i++)
		{
			System.out.print("|");
			
			for (int j = 0; j < table[i].length; j++)
			{				
				System.out.print(table[i][j]);
			}	
			
			System.out.println("|");
		}
		
		System.out.print(" ");
		
		for (int j = 0; j < table[0].length; j++)
		{
			System.out.print("=");
		}
		
		System.out.println();
	}
	
	/**
	 * Executes the move after correct validation.
	 * 
	 * @param direction direction letter
	 * @return returns the move
	 */
	public boolean applyMove(char direction)
	{
		if (snake.move(direction, food))
		{
			if (snake.getHead().equals(food))//if the head is on the food cell
				addFood();				//adds a new food on the board 
			
			if (!snake.touchesEdge(table.length)) 
			{
				rePrint();
				show();
			}
		
			return true;
		}
		else 
			return false;		
	}
	
	/**
	 * Getter for the position of the snake.
	 * @return the position of the snake 
	 */
	public Snake getSnake() 
	{
		return snake;
	}
	
	/**
	 * Game Over checker.
	 * Checks if the snake touches its body or the grid so it can end the game 
	 * @return returns true or false accordingly 
	 */
	public boolean isGameOver() 
	{
		if (snake.touchesEdge(table.length) || !snake.canMove()) 
			return true;
		else
			return false;
		
	}
}
