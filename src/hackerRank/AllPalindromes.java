package hackerRank;

public class AllPalindromes {
	
	public static boolean checkPalindrome(String str)
	{
		for(int i=0;i<=str.length()/2;i++)
			if(str.charAt(i)!=str.charAt(str.length()-1-i))
				return false;
		return true;
	}
	
	public static void printAllPalindrome(String str)
	
	{
		for(int i=0;i<=str.length();i++)
			for(int j=i;j<str.length();j++)
				if(checkPalindrome(str.substring(i,j+1)))
					System.out.println(str.substring(i,j+1));
	}
	
	public static void main(String[] args) {
	printAllPalindrome("abbaalla");
	}

}
