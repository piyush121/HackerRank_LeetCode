package hackerRank;

import java.util.Arrays;

/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place? :O
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
	        		result[j][len - i - 1] = matrix[i][j]; // The only medium hard part for this ques.
	        	}
	        for(int i = 0; i< len ; i++) {
	        	matrix[i] = result[i];
	        }
	        		
	    }
	 public static void rotateInPlace(int[][] matrix) { // Amazing solution !!! in place O(1) space O(n^2) time.
		 int len = matrix.length;
		 int[] temp = null;
		 for(int i=0 ; i < len/2 ; i++) { //reverse the array from top to bottom.
			 temp = matrix[i];
			 matrix[i] = matrix[len - 1 - i] ;
			 matrix[len - 1 - i] = temp;
		 }
		 
		 	int var = 0;
	        for (int i = 0; i < len; i++) {
	        	for(int j = i + 1 ; j < len; j++) { // j = i + 1 => imp. concept !
	        	 var = matrix[i][j] ;
	   			 matrix[i][j] = matrix[j][i] ;
	   			 matrix[j][i] = var;	  
	   			 }
	        }
	    }
	 
	 public static void main(String[] args) {
		int test[][] = {{1,2},{3,4}};
		
		rotateInPlace(test);
		for (int i = 0; i < 2; i++){
        	for(int j = 0 ; j < 2; j++) 
        		System.out.print(test[i][j]+"\t");
    		System.out.println();

		}
	}

}
