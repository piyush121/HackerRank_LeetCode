package hackerRank;


public class spiralMatrix {
	
	public static void printMatrix(int[][] matrix, int rows, int col)
	{
		int rowStart=0;
		int rowEnd=rows-1;
		int colStart=0;
		int colEnd=col-1;
		
		while(colStart<=colEnd || rowStart<=rowEnd)
		{
			for(int i=colStart;i<colEnd;i++)
				System.out.println(matrix[rowStart][i]);
			
			for(int i=rowStart;i<rowEnd;i++)
				System.out.println(matrix[i][colEnd]);
			
			for(int i=colEnd;i>colStart;i--)
				System.out.println(matrix[rowEnd][i]);
			
			for(int i=rowEnd;i>rowStart;i--)
				System.out.println(matrix[i][colStart]);
			rowStart++;
			colEnd--;
			rowEnd--;
			colStart++;
			
		}
						
	}
	public static void main(String[] args){
		
		int[][] array={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		printMatrix(array,3,4);
	}

}
