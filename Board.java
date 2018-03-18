import java.util.ArrayList;
import java.util.Random;

										//FOR MINESWEEPER

public class Board {
	static int r = 0;
	static Random rand = new Random();
	static int x;
	static int y;
	//public ArrayList<Square> grid = new ArrayList<Square>();
	//public static Square[][] grid = new Square[9][9];//perhaps i need to specify each square for constructor to work
	public static Square[][] sqrGrid = { //sqrGrid = square grid
		{new Square(false, 0, 1), new Square(false, 0, 2), new Square(false, 0, 3), new Square(false, 0, 4), new Square(false, 0, 5), new Square(false, 0, 6), new Square(false, 0, 7), new Square(false, 0, 8), new Square(false, 0, 9),},
		{new Square(false, 0, 10), new Square(false, 0, 11), new Square(false, 0, 12), new Square(false, 0, 13), new Square(false, 0, 14), new Square(false, 0, 15), new Square(false, 0, 16), new Square(false, 0, 17), new Square(false, 0, 18),},
		{new Square(false, 0, 19), new Square(false, 0, 20), new Square(false, 0, 21), new Square(false, 0, 22), new Square(false, 0, 23), new Square(false, 0, 24), new Square(false, 0, 25), new Square(false, 0, 26), new Square(false, 0, 27),},
		{new Square(false, 0, 28), new Square(false, 0, 29), new Square(false, 0, 30), new Square(false, 0, 31), new Square(false, 0, 32), new Square(false, 0, 33), new Square(false, 0, 34), new Square(false, 0, 35), new Square(false, 0, 36),},
		{new Square(false, 0, 37), new Square(false, 0, 38), new Square(false, 0, 39), new Square(false, 0, 40), new Square(false, 0, 41), new Square(false, 0, 42), new Square(false, 0, 43), new Square(false, 0, 44), new Square(false, 0, 45),},
		{new Square(false, 0, 46), new Square(false, 0, 47), new Square(false, 0, 48), new Square(false, 0, 49), new Square(false, 0, 50), new Square(false, 0, 51), new Square(false, 0, 52), new Square(false, 0, 53), new Square(false, 0, 54),},
		{new Square(false, 0, 55), new Square(false, 0, 56), new Square(false, 0, 57), new Square(false, 0, 58), new Square(false, 0, 59), new Square(false, 0, 60), new Square(false, 0, 61), new Square(false, 0, 62), new Square(false, 0, 63),},
		{new Square(false, 0, 64), new Square(false, 0, 65), new Square(false, 0, 66), new Square(false, 0, 67), new Square(false, 0, 68), new Square(false, 0, 69), new Square(false, 0, 70), new Square(false, 0, 71), new Square(false, 0, 72),},
		{new Square(false, 0, 73), new Square(false, 0, 74), new Square(false, 0, 75), new Square(false, 0, 76), new Square(false, 0, 77), new Square(false, 0, 78), new Square(false, 0, 79), new Square(false, 0, 80), new Square(false, 0, 81),},
	};
	
	public static String[][] grid = { //char grid that represents the 2D array of squares
			{" ", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ",},
			{" ", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=",},
			{"1", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"2", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"3", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"4", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"5", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"6", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"7", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"8", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{"9", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
			{" ", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=",},
	};
	
	public static String[][] testGrid = { //char grid that represents the 2D array of squares
		{" ", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ",},
		{" ", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=",},
		{"1", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"2", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"3", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"4", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"5", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"6", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"7", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"8", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{"9", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|",},
		{" ", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=", "=",},
};
	
	public static ArrayList<Square> checked = new ArrayList<Square>();//used to put squares that have been checked
	
	public static void fillBoard()//puts down bombs
	{
		for(int i = 0; i < 10; i++)
		{
			x = rand.nextInt(9);
			y = rand.nextInt(9);
			sqrGrid[x][y].makeBomb();
		}
	}
	
	public void test(){//testing to make sure pathfinding works. This is so I can look at the Squares not near bombs
		for(int x = 0; x < 9; x++){
			for(int y = 0; y < 9; y++){
				if(sqrGrid[x][y].bombCheck() == true){
					testGrid[x+2][y+2] = "X";
				}
			}
		}
		for(int x = 2; x < 11; x++){
			for(int y = 2; y < 11; y++){
				if(sqrGrid[x-2][y-2].bombCheck() == false){
					testGrid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				}
				
			}
		}
		for(int rows = 0; rows < Board.testGrid.length; rows++){
			System.out.println(" ");
			for(int columns = 0; columns < Board.testGrid[0].length; columns++){
				System.out.print(Board.testGrid[rows][columns] +" ");
			}
		}
	}
	
	public static void pathfind(int x, int y){ //to find Squares next to bombs. 2 and 3 are subtracted due to differences in lengths of the two arrays
		if(sqrGrid[x-2][y-2].bombCheck() == false && sqrGrid[x-2][y-2].getBombNum() == 0){
			if((y < 9 && y > 3 && x < 9 && x > 2) && (checked.contains(sqrGrid[x-2][y-3]) == false)){//square right above input
				checked.add(sqrGrid[x-2][y-3]);
				grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				pathfind(x, y-1);
			}
			else if((y < 9 && y > 3 && x < 9 && x > 1) && (checked.contains(sqrGrid[x-1][y-3]) == false)){//diagonally up right
				checked.add(sqrGrid[x-1][y-3]);
				
				grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				pathfind(x+1, y-1);
			}
			else if((y < 9 && y > 2 && x < 9 && x > 1) && (checked.contains(sqrGrid[x-1][y-2]) == false)){//directly right
				checked.add(sqrGrid[x-1][y-2]);
				
				grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				pathfind(x+1, y);
			}
			else if((y < 9 && y > 1 && x < 9 && x > 1) && (checked.contains(sqrGrid[x-1][y-1]) == false)){//diagonally down right
				checked.add(sqrGrid[x-1][y-1]);
				
				grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				pathfind(x+1, y+1);
			}
			else if((y < 9 && y > 1 && x < 9 && x > 2) && (checked.contains(sqrGrid[x-2][y-1]) == false)){//directly down
				checked.add(sqrGrid[x-2][y-1]);
				
				grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				pathfind(x, y+1);
			}
			else if((y < 9 && y > 1 && x < 9 && x > 3) && (checked.contains(sqrGrid[x-3][y-1]) == false)){//diagonally down left
				checked.add(sqrGrid[x-3][y-1]);
				
				grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				pathfind(x-1, y+1);
			}
			else if((y < 9 && y > 2 && x < 9 && x > 3) && (checked.contains(sqrGrid[x-3][y-2]) == false)){//directly left
				checked.add(sqrGrid[x-3][y-2]);
				
				grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				pathfind(x-1, y);
			}
			else if((y < 9 && y > 3 && x < 9 && x > 3) && (checked.contains(sqrGrid[x-3][y-3]) == false)){//diagonally up left
				checked.add(sqrGrid[x-3][y-3]);
				
				grid[x][y] = Integer.toString(sqrGrid[x-1][y-1].getBombNum());
				pathfind(x-1, y-1);
			}
			else{
				if(checked.contains(sqrGrid[x-2][y-2]) == false && (y < 9 && y > 1 && x < 9 && x > 1)){
					checked.add(sqrGrid[x-2][y-2]);
					grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
					}
				}
			}
		else if(sqrGrid[x-2][y-2].bombCheck() == false && sqrGrid[x-2][y-2].getBombNum() > 0){
			grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
		}
		else{
			
		}
		/*if((y < 9 && y > 3 && x < 9 && x > 2) && (checked.contains(sqrGrid[x-2][y-3]) == false) && (sqrGrid[x-2][y-2].isBomb == false)){//square right above input
			checked.add(sqrGrid[x-2][y-3]);
			grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
			pathfind(x, y-1);
		}
		else if((y < 9 && y > 3 && x < 9 && x > 1) && (checked.contains(sqrGrid[x-1][y-3]) == false) && (sqrGrid[x-2][y-2].isBomb == false)){//diagonally up right
			checked.add(sqrGrid[x-1][y-3]);
			
			grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
			pathfind(x+1, y-1);
		}
		else if((y < 9 && y > 2 && x < 9 && x > 1) && (checked.contains(sqrGrid[x-1][y-2]) == false) && (sqrGrid[x-2][y-2].isBomb == false)){//directly right
			checked.add(sqrGrid[x-1][y-2]);
			
			grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
			pathfind(x+1, y);
		}
		else if((y < 9 && y > 1 && x < 9 && x > 1) && (checked.contains(sqrGrid[x-1][y-1]) == false) && (sqrGrid[x-2][y-2].isBomb == false)){//diagonally down right
			checked.add(sqrGrid[x-1][y-1]);
			
			grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
			pathfind(x+1, y+1);
		}
		else if((y < 9 && y > 1 && x < 9 && x > 2) && (checked.contains(sqrGrid[x-2][y-1]) == false) && (sqrGrid[x-2][y-2].isBomb == false)){//directly down
			checked.add(sqrGrid[x-2][y-1]);
			
			grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
			pathfind(x, y+1);
		}
		else if((y < 9 && y > 1 && x < 9 && x > 3) && (checked.contains(sqrGrid[x-3][y-1]) == false) && (sqrGrid[x-2][y-2].isBomb == false)){//diagonally down left
			checked.add(sqrGrid[x-3][y-1]);
			
			grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
			pathfind(x-1, y+1);
		}
		else if((y < 9 && y > 2 && x < 9 && x > 3) && (checked.contains(sqrGrid[x-3][y-2]) == false) && (sqrGrid[x-2][y-2].isBomb == false)){//directly left
			checked.add(sqrGrid[x-3][y-2]);
			
			grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
			pathfind(x-1, y);
		}
		else if((y < 9 && y > 3 && x < 9 && x > 3) && (checked.contains(sqrGrid[x-3][y-3]) == false) && (sqrGrid[x-2][y-2].isBomb == false)){//diagonally up left
			checked.add(sqrGrid[x-3][y-3]);
			
			grid[x][y] = Integer.toString(sqrGrid[x-1][y-1].getBombNum());
			pathfind(x-1, y-1);
		}
		else{
			if(checked.contains(sqrGrid[x-2][y-2]) == false && (y < 9 && y > 1 && x < 9 && x > 1)){
				if(sqrGrid[x-2][y-2].isBomb == false){
					checked.add(sqrGrid[x-2][y-2]);
					//for(int xx = 0; xx < sqrGrid.length; xx++){
					//	for(int yy = 0; yy < sqrGrid[0].length; yy++){
					//		if(checked.contains(sqrGrid[x][y]) && sqrGrid[x][y].isBomb == false && sqrGrid[x][y].bombNum == 0){
					//			grid[x+2][y+2] = Integer.toString(sqrGrid[x][y].getBombNum());
					//		}
					//	}
					grid[x][y] = Integer.toString(sqrGrid[x-2][y-2].getBombNum());
				}
			}
		}*/
		for(int i = 0; i < checked.size(); i++){//temporary
			System.out.println(checked.get(i));
		}
	}
	
	boolean checkClick(int x, int y){//checks to see if a click input was a bomb
		if((x < 9) && (y < 9) && sqrGrid[x-2][y-2].isBomb == true){
			return true; // means you've lost
		}
		else{
			return false; 
		}
	}
}



