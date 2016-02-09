package hackerRank;

public class FloodFill {
	
	public static void floodFillUtil(int[][] screen, int x, int y, int prevC,int newC)
	{	
		if(x>screen.length || x<0 || y>screen[0].length || y<0)
			return ;
		if(screen[x][y]!=prevC)
			return;
		screen[x][y]=newC;
		
		floodFillUtil(screen, x+1, y, prevC, newC);
		floodFillUtil(screen, x-1, y, prevC, newC);
		floodFillUtil(screen, x, y+1, prevC, newC);
		floodFillUtil(screen, x, y-1, prevC, newC);
	}

}
