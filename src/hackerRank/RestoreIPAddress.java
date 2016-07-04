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
								// solution is not so efficient. but should have
								// rather go with string instead of string
								// builder to make solution easier.
	public static List<String> restoreIpAddresses(String s) {
		StringBuilder strb = new StringBuilder();
		List<String> result = new ArrayList<>();
		helper(s, 1, 0, result, strb);

		return result;
	}

	private static void helper(String str, int count, int start, List<String> result, StringBuilder temp) {
		if (count > 4)
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
			System.out.println(st + "\t" + temp + "\t" + result);
			if ((st.startsWith("0") && st.length() > 1) || Integer.parseInt(st) > 255) {
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
