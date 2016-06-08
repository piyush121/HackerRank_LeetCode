package hackerRank;

import java.util.Arrays;

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
	
	 public static void rotate(int[][] matrix) {
		 int len = matrix.length;
		 int result[][] = new int[len][len];

	        for (int i = 0; i < len; i++)
	        	for(int j = 0 ; j < len; j++) {
	        		result[j][len - i - 1] = matrix[i][j];
	        	}
	     matrix = result;
	    }
	 
	 public static void main(String[] args) {
		int test[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		rotate(test);
		for (int i = 0; i < 4; i++){
        	for(int j = 0 ; j < 4; j++) 
        		System.out.print(test[i][j]+"\t");
    		System.out.println();

		}
	}

}
