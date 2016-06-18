package hackerRank;

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
	static int level = 0;
	public static String getPermutation(int n, int k) {
		StringBuilder strb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			strb.append(i);
		}
		String result = permuteHelper(strb.toString(),strb.toString(),"", k, level);
		
		return result;
	}

	private static String permuteHelper(String str, String prefix, String suffix, int k, int level) {
		if( prefix == "" ) {
			if( k == level)
				return suffix;
			else
				level++;
		}
		
		for( int i = 0; i < str.length(); i++ ) {
			permuteHelper(str, str.substring(0,i),str.substring(i),k, level);
		}

	}
}
