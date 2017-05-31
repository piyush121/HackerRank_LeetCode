package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class SpiralMtrx {
	
	 public static List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> result = new ArrayList<>();
	        if( matrix.length == 0)
	        	return result;
	        int colStart = 0;
	        int colEnd = matrix[0].length - 1;
	        int rowStart = 0;
	        int rowEnd = matrix.length - 1;
	        
	        while (colStart <= colEnd && rowStart <=rowEnd) {
	        for(int i = colStart; i <= colEnd && rowStart <= rowEnd; i++) // You gotta check both the conditions everytime !
	        	result.add(matrix[rowStart][i]);
        	rowStart++;

	        for(int i = rowStart; i <= rowEnd && colStart <= colEnd; i++)
	        	result.add(matrix[i][colEnd]);
        	colEnd--;

	        for(int i = colEnd; i >= colStart && rowStart <= rowEnd; i--)
	        	result.add(matrix[rowEnd][i]);
        	rowEnd--;

	        for(int i = rowEnd; i >= rowStart && colStart <= colEnd; i--)
	        	result.add(matrix[i][colStart]);
	        colStart++;
	        }
	        
	        return result;
	    }
	 
	 public static void main(String[] args){
			
			int[][] array={{1,2,3},{4,5,6},{7,8,9}};
			System.out.println(spiralOrder(array)); //send input correctly.
		}

}
