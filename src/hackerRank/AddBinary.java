/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * 
 */
/**
 * @author Piyush Chaudhary
 *
 */
public class AddBinary {

	public static String addBinary(String a, String b) { // looks easy but very tiring question!
		int i = a.length() - 1;
		int j = b.length() - 1;
		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();
		int carry = 0;
		StringBuilder strb = new StringBuilder();
		int aBit;
		int bBit;
		while (i > -1 || j > -1 || carry == 1) {

			if (i >= 0)
				aBit = a1[i] - '0';
			else
				aBit = 0;
			if (j >= 0)
				bBit = b1[j] - '0';
			else
				bBit = 0;

			int res = carry + (aBit) + (bBit);
			int xor = carry ^ (aBit) ^ (bBit);
			System.out.println(res);
			if (res >= 2) {
				carry = 1;

			} else {
				carry = 0;
				strb.append(xor);
				break;
			}

			strb.append(xor);
			i--;
			j--;
		}

		return strb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "1"));

	}

}
