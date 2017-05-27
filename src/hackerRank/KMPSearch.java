/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 */
public class KMPSearch {

	public static int strstr(String str, String x) { // O(M + N) runtime.
		int[] prefix = new int[x.length()];
		int j = 0;
		for(int i = 1 ; i < x.length(); i++) {
			if( x.charAt(i) == x.charAt(j)) {
				j++;
				prefix[i] = j;
			}
			else {
				if(j != 0) {
					j = prefix[j - 1];
				}	
			}
		}
		j = 0;
//		for(int num : prefix)
//			System.out.print(num);
		for(int i = 0 ; i < str.length(); i++) {
			while(str.charAt(i) != x.charAt(j) && j != 0) // tricky step.
				j = prefix[j];
			if(str.charAt(i) == x.charAt(j))
				j++;
			if(j == x.length())
				return i - j + 1;
		}
		return -1;

	}
	public static void main(String[] args) {
		System.out.println("\n" + strstr("ABABDABACDABABCABAB", "ABABCABAB"));

	}

}
