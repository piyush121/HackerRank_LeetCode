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
	public int[] plusOne(int[] digits) { // easy one. Still took a long time.
											// Sleep makes me more lazy !

		int borrow = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (borrow == 1 && digits[i] + 1 <= 9) {
				++digits[i];
				borrow = 0;
				break;
			} else if (borrow == 1 && digits[i] + 1 == 10) {
				digits[i] = 0;
			}

		}
		if (borrow == 1) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}

		return digits;
	}

	public int[] plusOneEff(int[] digits) { // More optimized !
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 <= 9) {
				++digits[i];
				break;
			} else if (digits[i] + 1 == 10) {
				digits[i] = 0;
			}

		}
		if (digits[0] == 0) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}

		return digits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
