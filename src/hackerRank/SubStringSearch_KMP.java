package hackerRank;

public class SubStringSearch_KMP {

	public static int[] prefixArray(String pattern) { // O(m).
		int len = pattern.length();
		int[] prefixArray = new int[len];

		int j = 0;
		int index = 1;
		for (int k = 1; k < len;) {
			if (pattern.charAt(j) == pattern.charAt(k)) {
				prefixArray[k] = index;
				k++;
				index++;	//important. so that the next match has the right length of prefix whhich is also the suffix.
			} else {
				if (j != 0)
					j = prefixArray[k - 1];
				else {
					prefixArray[k] = 0;
					k++;
				}

			}
		}
		return prefixArray;
	}

	public static int subStringSearch(String text, String pattern) { //O(m + n)
		int[] arr = prefixArray(pattern);
		int i = 0;
		int j = 0;
		while (i < text.length() && j < pattern.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;

			} 
			else if (j!=0){
				j = arr[j - 1];
			}
			else
				i++;
		}
		if (j == pattern.length() )
			return i - j;
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(subStringSearch("baabbbbbbbaaba","bbbbbbaa"));
	}

}
