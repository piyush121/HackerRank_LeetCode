/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 
 * 01 - 1 
 * 11 - 3 
 * 10 - 2 Note: For a given n, a gray code sequence is not
 * uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 */
public class GrayCode {
	public static List<Integer> grayCode(int n) {//THis works but not very efficient.
		int[] arr = new int[n];
		List<Integer> result = new LinkedList<>();
		codeHelper(result, arr, n);
		return result;

	}

	private static void codeHelper(List<Integer> result, int[] arr, int n) {
		result.add(binToNum(arr));
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = 1;
			codeHelper(result, arr, i);
			arr[i] = 0;
		}

	}

	private static int binToNum(int[] arr) {
		int num = 0;
		int len = arr.length;
		for (int i = len - 1; i >= 0; i--) {
			num += Math.pow(2, len - i - 1) * arr[i];
		}

		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(grayCode(2));
	}

}
