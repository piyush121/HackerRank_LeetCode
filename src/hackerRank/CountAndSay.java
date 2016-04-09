package hackerRank;

public class CountAndSay {

	public static String countAndSay(String str) {
		int count = 1;
		StringBuilder strb = new StringBuilder();
		int i = 0;
		for (i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1))
				count++;
			else {
				strb.append(count);
				strb.append(str.charAt(i));
				count = 1;
			}
		}
		strb.append(count);
		strb.append(str.charAt(i));
		return strb.toString();
	}

	public static String countAndSay(int n) {
		StringBuilder strb = new StringBuilder();
		String str1 = "1";
		for (int i = 1; i < n; i++) {
			String str = countAndSay(str1);
			str1 = str;
		}
		strb.append(str1);
		return strb.toString();
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
	}
}
