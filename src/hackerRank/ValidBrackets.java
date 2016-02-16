package hackerRank;

public class ValidBrackets {
	
	public static void printBrackets(int open,int close,String str)
	{
		if(open==0 && close==0)
			System.out.println(str);
		
		if(open>0)
			printBrackets(open-1, close+1, str+"<");
		if(close>0)
			printBrackets(open, close-1, str+">");

	}
	
	public static void main(String[] args) {
		printBrackets(3, 0, "");
	}

}
