package hackerRank;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */

/**
 * @author Piyush Chaudhary
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int[] res;
		if (digits[0] == 9)
			res = new int[digits.length + 1];
		else
			res = digits;
		int borrow = 1;
		for (int i = res.length - 1; i >= 0; i--) {
			if (borrow == 1) {
				if (res[i] + 1 == 10)
					res[i] = 0;
				else
					res[i]++;
			} else
				res[i] = digits[i];

		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
