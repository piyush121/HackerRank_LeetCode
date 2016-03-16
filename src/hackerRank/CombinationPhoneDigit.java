package hackerRank;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Piyush Chaudhary
 *
 */
public class CombinationPhoneDigit { // not efficient.

	public static List<String> letterCombinations(String digits) {
		String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> list1 = new LinkedList<String>();
		List<String> list2 = new LinkedList<String>();
		if (digits.length() == 0)
			return list2;
		list2.add("");

		for (int i = 0; i < digits.length(); i++) {
			String str1 = map[digits.charAt(i) - '0'];
			while (!list2.isEmpty()) {
				String str2 = list2.remove(0);
				for (int j = 0; j < str1.length(); j++) {
					list1.add(str2 + str1.charAt(j)); // adding every character
														// to the elements
														// already present in
														// the list.
				}
			}
			list2 = list1;
			list1 = new LinkedList<>();
		}
		return list2;
	}

	public static List<String> letterCombinations1(String digits) {//Efficient one. but may be hard to come up with during an interview.
	    if(digits.length()==0)
	        return new LinkedList<>();
	   List<String> results = new LinkedList<>();
	   return letterCombinations1(digits,"",0,results);
}

	public static List<String> letterCombinations1(String digits, String single, int start,List<String> result) {
		String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if (start == digits.length()) { // return when it reaches length of the digits because we would have formed  a combination by then.
			result.add(single);
			return result;
		}
		String str=map[digits.charAt(start) - '0'];
		for(int i=0;i<str.length();i++) {
			single=single+str.charAt(i);
			letterCombinations1(digits, single, start+1,result);
			single=single.substring(0, single.length()-1); //remove the last added character so that we can add the next one.
		}

		return result;
	}



	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations1("23"));
	}

}
