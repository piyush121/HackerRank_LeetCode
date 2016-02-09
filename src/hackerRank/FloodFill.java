package hackerRank;

public class FloodFill {
	
	public static void floodFillUtil(int[][] screen, int x, int y, int prevC,int newC)
	{
		if(screen[x][y]!=prevC)
			return;
		screen[x][y]=newC;
		
		floodFillUtil(screen, x+1, y, prevC, newC);
		floodFillUtil(screen, x-1, y, prevC, newC);
		floodFillUtil(screen, x, y+1, prevC, newC);
		floodFillUtil(screen, x, y-1, prevC, newC);
	}

}
