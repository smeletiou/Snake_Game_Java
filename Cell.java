package smelet01.hw2;
/**
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class Cell {

	private int x;
	private int y;
	
	/**
	 * First Constructor.
	 * Calls the second constructor
	 */
	
	public Cell() 
	{
		this(-1, -1);
	}
	
	/**
	 * Second Constructor.
	 * @param x x axis
	 * @param y y axis
	 */
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * X getter method.
	 * @return returns X
	 */
	public int getX() 
	{
		return x;		
	}
	
	/**
	 * X setter method.
	 * @param x x axis 
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 *Y getter method.
	 * @return returns Y
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Y setter method.
	 * @param y Y axis
	 */
	public void setY(int y)
	{
		this.y =  y;
	}
	
	/**
	 * Cell equal checker.
	 * This checks if two cells are the same for example if the head is on the same cell as the food
	 * @param c the cell with his coordinates
	 * @return true or false accordingly
	 */
	public boolean equals(Cell c)
	{
		return x == c.getX() && y == c.getY();		
	}
}
