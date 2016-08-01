/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 *
 */
public class ExcelSheetToColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder strb = new StringBuilder();
		while (n > 0) {
			int rem = (n - 1) % 26; // Corner cases sucks !
			strb.insert(0, (char) (65 + rem));
			n = (n - 1) / 26;
		}

		return strb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
