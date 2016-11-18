/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Scanner;

/**
 * @author Piyush Chaudhary
 *
 */
public class LonelyInteger {
	 private static int lonelyInteger(int[] a) {
	        for(int i = 1; i < a.length; i++)
	            a[i] ^= a[i - 1];
	         return a[a.length - 1];
	    }
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = in.nextInt();
	        }
	        System.out.println(lonelyInteger(a));
	    }
}
