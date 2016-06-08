package hackerRank;

/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 * 
 */

/**
 * @author Piyush Chaudhary
 *
 */
public class Rotate_Image {
	
	 public void rotate(int[][] matrix) {
		 int len = matrix.length;
		 int result[][] = new int[len][len];

	        for (int i = 0; i < len; i++)
	        	for(int j = 0 ; j < len; j++) {
	        		result[i][j] = matrix[j][len - i];
	        		
	        	}
	    }
	 
	 public static void main(String[] args) {
		
	}

}
