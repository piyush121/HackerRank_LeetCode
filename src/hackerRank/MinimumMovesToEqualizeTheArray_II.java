/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements 
 * equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 */
public class MinimumMovesToEqualizeTheArray_II {
	public int minMoves2(int[] arr) { // equalize every element to the median.
        if(arr.length == 1)
            return 0;
       Arrays.sort(arr);
       int res = 0;
       int median = arr[arr.length / 2];
       for(int num : arr) 
            res += Math.abs(num - median);
        return res;
    }  
}
