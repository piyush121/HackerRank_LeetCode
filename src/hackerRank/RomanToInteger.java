/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToInteger {
	
	public int romanToInt(String s) { // just another way.
		int[] a = new int[26];
		a['I' - 'A'] = 1;
		a['V' - 'A'] = 5;
		a['X' - 'A'] = 10;
		a['L' - 'A'] = 50;
		a['C' - 'A'] = 100;
		a['D' - 'A'] = 500;
		a['M' - 'A'] = 1000;
		int res = 0;
		int last = 0;
		for (char ch : s.toCharArray()) {
			int val = a[ch - 'A'];
			if (val > last) {
				res = res - last + val - last;
			} else
				res += val;
			last = val;
		}
		return res;

	}
	public int romanToInt1(String s) { // good but can be made better.
		int res = getInt(s.charAt(0));
		int last = res;
		for(int i = 1 ; i < s.length(); i++) {
			int val = getInt(s.charAt(i));
			if(val > last) {
				res = res - last + val - last;
			}
			else
				res += val;
			last = val;
		}
		return res;
	}
	
	private int getInt(char ch) {
		switch(ch) {
		
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default: return Integer.MIN_VALUE;
		}
	}
}
