package smelet01.hw2;
import java.util.*;
/**
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class RandomCellSelector 
{
	private Random rnd;
	private int rows;
	private int columns;
	
	/**
	 * Constructor.
	 * Picks a cell randomly 
	 * @param N board size 
	 */
	public RandomCellSelector(int N) 
	{	
		rnd = new Random();
		rows = N;
		columns = 2 * N + 1;
	}
	
	/**
	 * Random cell picker.
	 * Takes 2 random nums x,y to be the coordinates of the food 
	 * @return returns the cell position so the food can be added
	 */
	public Cell getRandomCell() 
	{
		int x = rnd.nextInt(columns);
		int y = rnd.nextInt(rows);
		
		return new Cell(x,y);					
	}	
}
