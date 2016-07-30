/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 *
 */
public class MaxProductSubArray {
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		int maxProd = Integer.MIN_VALUE;
		int currProd = 1;

		for (int i = 0; i < nums.length; i++) { // This will give max sum till last negative elements if there are odd no. of -ve elements.
			currProd *= nums[i];
			maxProd = Math.max(currProd, maxProd);
			if (currProd == 0)
				currProd = 1;
		}	// 0 will act as a delimiter here.
		currProd = 1; // if there are odd number of Negative elements then we need to choose between last one and first one.
		for (int i = nums.length - 1; i >= 0; i--) {// This will give max sum after first negative elements if there are odd no. of -ve elements.
			currProd *= nums[i];
			maxProd = Math.max(currProd, maxProd);
			if (currProd == 0)
				currProd = 1;
		}

		return maxProd;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
