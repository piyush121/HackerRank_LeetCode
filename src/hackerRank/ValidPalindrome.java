/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. 
 * "race a car" is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 */
public class ValidPalindrome {
	public static boolean isPalindrome(String s) { //Efficient than using regex because you can skip one whole pass.
		if (s.length() == 0)
			return true;
		int i = 0;
		int j = s.length() - 1;
		s = s.toLowerCase();
		while(i < j) {
			while(i < s.length() && !valid(s.charAt(i))) //move until you are on a valid character.
				i++;
			while(j >= 0 && !valid(s.charAt(j)))
				j--;
			if(i < s.length() && j >=0 && s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

	private static boolean valid(char x) { 
		if (((x <= 'z') && (x >= 'a')) || ((x <= '9') && (x >= '0')))
			return true;
		return false;
	}

	public boolean isPalindrome1(String s) { // Works but not efficient.
		if (s.length() == 0)
			return true;
		s = s.replaceAll("\\W+", "").toLowerCase();

		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] != arr[s.length() - 1 - i])
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(".,11"));

	}

}
