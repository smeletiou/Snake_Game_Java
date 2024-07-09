package smelet01.hw2;
/**
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class Snake 
{	
	private Cell[] body;
	
	/**
	 * Constructor.
	 * Makes the staring point of the snake at the middle of the board
	 * and creates the first snake with length 4	
	 * @param N board size 
	 */
	public Snake(int N)	
	{		
		int x = (2 * N + 1) / 2;
		int y = N / 2;
		
		body = new Cell[4];
		
		for (int j = 0; j < 4; j++) 
			body[3-j] = new Cell(x++, y);
	}
	
	/**
	 * Body cell checker.
	 * checks the cells that are the body of the snake 
	 * @param c cell
	 * @return  returns if this cell is part of the snake
	 */
	public boolean ownsCell(Cell c)
	{
		boolean found = false;
		int i = 0;
		
		while (!found && i < body.length)			
			if (body[i].equals(c)) 
				found = true;
			else 
				i++;

		return found;		
	}
	
	/**
	 * Getter for the length of the snake.
	 * @return returns the length 
	 */
	public int getLength() 
	{
		return body.length;
	}
	
	/**
	 * Getter of the cell in position index.
	 * its inside a for loop that returns every cell of the body
	 * @param index position
	 * @return returns the cell in the position index
	 */
	public Cell getCell(int index)
	{
		return body[index];
	}
	
	/**
	 * Getter for the position of the head.
	 * @return returns the position of the head
	 */
	public Cell getHead() 
	{
		return body[0];
	}
	
	/**
	 * Grows the snake.
	 * Grows the snake +1 cell after eating a fruit
	 */
	public void grow()
	{
		Cell[] tmp = new Cell[getLength() + 1];
					
		for (int i = 0; i < getLength(); i++)
			tmp[i] = body[i];
		
		tmp[getLength()] = new Cell();
		
		body = tmp;	
	}

	/**
	 * Moves validation and actions.
	 * Checks if a move is valid and calls the {@link isValidMove} 
	 * if the snake eats calls the {@link eatsFood} and then the {@link grow}
	 * and sets the snake to its new position after every move 
	 * @param direction the current given direction (l,r,d,u)
	 * @param food current food position 
	 * @return returns if the move was made or not 
	 */
	public boolean move(char direction, Cell food)
	{	
		if (isValidMove(direction))
		{		
			if (eatsFood(direction, food))
				grow();
					
			for (int i = getLength() - 1; i > 0; i--)
			{
				body[i].setX(body[i-1].getX());
				body[i].setY(body[i-1].getY());		
			}
			
			switch (direction)
			{
				case 'r':
					body[0].setX(body[0].getX() + 1);
					break;
					
				case 'l':
					body[0].setX(body[0].getX() - 1);
					break;
				
				case 'u':
					body[0].setY(body[0].getY() - 1);
					break;
					
				case 'd':
					body[0].setY(body[0].getY() + 1);
					break;				
			}		
			
			return true;
		}
		else 
		{
			return false;
		}		
	}
	
	/**
	 * Valid move checker.
	 * Checks if the input is one of the four letters
	 * @param direction reads direction letter
	 * @return
	 */
	private boolean isValidMove(char direction) 
	{	
		Cell head = body[0];
		int x = 0;
		int y = 0;
		
		switch (direction)
		{
			case 'r':
				x = head.getX() + 1;
				y = head.getY();
				break;
			case 'l':
				x = head.getX() - 1;
				y = head.getY();
				break;
			case 'u':
				x = head.getX();
				y = head.getY() - 1;
				break;
			default:
				x = head.getX();
				y = head.getY() + 1;
				break;				
		}
		
		Cell c = new Cell(x,y);
				
		return !ownsCell(c);			
	}
	
	/**
	 * Eat food method.
	 * Checks if the head is on the same position with the food
	 * @param direction reads direction
	 * @param food foods position
	 * @return returns if its on top of it or not
	 */
	private boolean eatsFood(char direction, Cell food)
	{
		int x = body[0].getX();
		int y = body[0].getY();
		
		switch (direction)
		{
			case 'r':
				x++;
				break;
				
			case 'l':
				x--;
				break;
			
			case 'u':
				y--;
				break;
				
			case 'd':
				y++;
				break;				
		}		
		
		Cell c = new Cell(x,y);
		
		return c.equals(food);
	}
	
	/**
	 * Edge touch checker.
	 * Checks if the snakes head touches the grid so it can end the game
	 * @param N the size of the board
	 * @return returns true or false accordingly
	 */
	public boolean touchesEdge(int N) 
	{				
		//head
		int x = body[0].getX();
		int y = body[0].getY();
		
		//last cell of tail
		int x2 = body[getLength()-1].getX();
		int y2 = body[getLength()-1].getY();
		
		if (x < 0 || y < 0 || x == 2 * N + 1 || y == N || x2 < 0 || y2 < 0 || x2 == 2 * N + 1 || y2 == N)
			return true;	
		else 
			return false;		
	}

	/**
	 * Next move checker.
	 * Checks if the head can move further
	 * @return returns true false accordingly
	 */
	public boolean canMove() 
	{
		int x = body[0].getX();
		int y = body[0].getY();
		
		Cell leftCell = new Cell(x - 1, y);
		Cell rightCell = new Cell(x + 1, y);
		Cell upCell = new Cell(x, y - 1);
		Cell downCell = new Cell(x, y + 1);
		
		if (ownsCell(leftCell) && ownsCell(rightCell) && ownsCell(upCell) && ownsCell(downCell))
			return false;
		else 
		
			return true;	
	}
}
