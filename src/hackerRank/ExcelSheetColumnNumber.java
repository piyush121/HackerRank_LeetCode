/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

 *
 */
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) { // Can't get shorter than this.
		int answer = 0;
		for (int i = 0; i < s.length(); i++) 
			answer = 26 * answer + (s.charAt(i) - 64);
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(titleToNumber("AAA"));

	}

}
