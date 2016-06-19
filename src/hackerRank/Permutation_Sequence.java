package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
/**
 * @author Piyush Chaudhary
 *
 */
public class Permutation_Sequence {
	static int level = 1;
	static String result = "";

	public static String getPermutation(int n, int k) { // Slow and pathetic solution. Damn ! O(n!)
		StringBuilder strb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			strb.append(i);
		}
		permuteHelper("", strb.toString(), k);

		return result;
	}

	private static void permuteHelper( String prefix, String suffix, int k) {
		if (suffix.length() == 0) {
			if (k == level)
				result = prefix;
				
			level++;
			return;
		}
		for (int i = 0; i < suffix.length(); i++) {
			permuteHelper( prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1), k);
		}
	}
	public static String getPermutation1(int n, int k) { //Optimized one !So many smart people are present on this earth for helping us.
	
		StringBuilder result = new StringBuilder();
		int[] factorials = new int[n + 1];
		factorials[0] = 1;
		for(int i = 1; i <= n ; i++) { // calculating the factorials up to the max possible permutations.
			factorials[i] = factorials[i - 1] * i;
		}
		
		ArrayList<Integer> nums =  new ArrayList<>();
		for(int i = 1; i <= n; i ++) {
			nums.add(i);
		}
		k--;
		for(int i = 0; i < n; i++ ) { //trying to find pattern here.
			int fact = factorials[n - i];
			int magicNumber = fact / (n - i);
			int index = k / magicNumber;
			result.append(String.valueOf(nums.remove(index)));
			k -= index * magicNumber;
		}
		return result.toString();
		
	}
	

	public static void main(String[] args) {
		System.out.println(getPermutation1(4, 14));
	}
}
