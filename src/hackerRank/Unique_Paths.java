/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying 
to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */
package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 */
public class Unique_Paths {
	public static int uniquePaths(int m, int n) { // Recursive in efficient solution.
		if(m ==1 && n == 1)
			return 1;
		if(m < 1 || n < 1)
			return 0;
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}
	
	public static int uniquePaths(int m, int n) { // DP based solution. Still no the best one out there.
		if(m == 1 || n ==1 )
            return 1;
		int[][] DP = new int [m][n];
		
		for(int i = 0; i < m; i++)
			DP[i][0] = 1;
		for(int i = 0; i < n; i++)
			DP[0][i] = 1;
		
		for(int i =1; i < m; i++)
			for(int j = 1; j < n; j++)
				DP[i][j] = DP[i][j-1] + DP[i-1][j];
		
		return DP[m-1][n-1];
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(23, 12));
	}

}
