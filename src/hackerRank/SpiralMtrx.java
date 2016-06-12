package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class SpiralMtrx {
	
	 public List<Integer> spiralOrder(int[][] matrix) {
	        
	        int colStart = 0;
	        int colEnd = matrix[0].length - 1;
	        int rowStart = 0;
	        int rowEnd = matrix.length;
	        List<Integer> result = new ArrayList<>();
	        for(int i = colStart; i < colEnd; i++)
	        	result.add(matrix[rowStart][i]);
	        
	        for(int i = rowStart; i < rowEnd; i++)
	        	result.add(matrix[i][colEnd]);
	        
	        for(int i = colEnd; i < colStart; i--)
	        	result.add(matrix[rowEnd][i]);
	        
	        for(int i = rowEnd; i < rowEnd; i--)
	        	result.add(matrix[i][colStart]);
	        
	        return result;
	    }

}
