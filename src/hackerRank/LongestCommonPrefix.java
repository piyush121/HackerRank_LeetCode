package hackerRank;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) { // brute force not
																// efficient.
		StringBuilder str = new StringBuilder();
		if (strs.length != 0)
			str = str.append(strs[0]);
		else
			return "";
		int min = strs[0].length();
		int count = 0;
		for (String st : strs) {
			for (int i = 0; i < Math.min(str.length(), st.length()); i++) {
				if (str.charAt(i) == st.charAt(i))
					count++;
				else
					break;

			}
			if (count < min) {
				min = count;
				str.delete(min, str.length());
			}
			count = 0;
		}

		return str.toString();

	}

	public static String longestCommonPrefix1(String[] strs) { // efficient one.
		if (strs.length == 0)
			return "";
		String str;
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < strs.length; i++)
			if (strs[i].length() < min) {
				min = strs[i].length();
				index = i;
			}
		str = strs[index];
		for (int j = 0; j < min; j++) { // Basically I am matching every string
										// in the array char by char. Complexity : O(n)
			for (int i = 0; i < strs.length; i++) {
				if (str.charAt(j) != strs[i].charAt(j))
					return str.substring(0, j);

			}
		}

		return str.substring(0, min);

	}

	public static void main(String[] args) {
		String[] strs = { "aaa", "aa", "aaa" };
		System.out.println(longestCommonPrefix1(strs));
	}

}
