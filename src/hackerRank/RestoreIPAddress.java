/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */
public class RestoreIPAddress { // Wow! that was a great learning curve ! This
								// solution is not so efficient, but I should have
								// rather gone with string instead of StringBuilder 
								//to make solution easier.
	public static List<String> restoreIpAddresses(String s) {
		String strb = "";
		List<String> result = new ArrayList<>();
		efficientHelper(s, 0, 0, result, strb);

		return result;
	}

	private static void efficientHelper(String str, int count, int start, List<String> result, String temp) { // This
																												// one
																												// is
																												// efficient
																												// but
																												// might
																												// be
																												// hard
																												// to
																												// code
																												// up
																												// in
																												// an
																												// interview.
																												// Time
		if(count > 4)																							// O(3^4)
			return;																								
		if (count == 4 && start == str.length()) {
			result.add(temp);
			return;
		}
		for (int i = start; i < start + 3 && i < str.length(); i++) {
			String st = str.substring(start, i + 1);
			if (st.startsWith("0") && st.length() > 1 || i - start == 2 && Integer.parseInt(st) > 255) // notice "01" can be parse as 1. Deal with that.
				break;
			if (count != 3)
				st = st + ".";
			efficientHelper(str, count + 1, i + 1, result, temp + st);
		}
	}

	private static void helper(String str, int count, int start, List<String> result, StringBuilder temp) {
		if(count > 4)
			return;
		if (count == 4) {
			String st = str.substring(start, str.length());
			if ((st.startsWith("0") && st.length() > 1) || st.equals("") || st.length() > 3
					|| Integer.parseInt(st) > 255)
				return;
			else {
				StringBuilder strb = new StringBuilder(temp);
				strb.append(Integer.parseInt(st));
				result.add(strb.toString());
			}
			return;
		}

		for (int i = start; i <= start + 3 && i < str.length(); i++) {
			String st = str.substring(start, i + 1);
			if ((st.startsWith("0") && st.length() > 1) || Integer.parseInt(st) > 255) { // Got too complex :P.
				for (int j = temp.length() - 1; j > 0 && temp.charAt(j) != '.'; j--)
					temp.deleteCharAt(temp.length() - 1);
				return;
			}
			temp.append(str.charAt(i) + ".");
			helper(str, count + 1, i + 1, result, temp);
			temp.deleteCharAt(temp.length() - 1);
		}
		for (int j = temp.length() - 1; j > 0 && temp.charAt(j) != '.'; j--)
			temp.deleteCharAt(temp.length() - 1);

	}
	
	

	public static void main(String[] args) {
		// System.out.println(Integer.parseInt("010"));

		System.out.println(restoreIpAddresses("101023"));

	}

}
