package hackerRank;

public class LongestPlindromicSubstring {
	static int maxLen=1;
	static String subString="";
	
	public static String LPS(String s)
	{
		 if(s.length()==1)
		        return s;
		 if(s.length()==0)
		        return "";
		 if(s.length()==2)
		 {
			 if(s.charAt(0)==s.charAt(1))
				 return s;
			 else 
				 return String.valueOf(s.charAt(0));
		 }
		for(int i=0;i<s.length()-1;i++)
		{
			checkThis(s,i,i);
			checkThis(s,i,i+1);
		}
		
		return subString;
	}
	private static void checkThis(String s1,int index1,int index2)
	{
		int left=index1;
		int right=index2;
		while(left>=0 && right<s1.length()&&s1.charAt(left)==s1.charAt(right))
		{
			left--;
			right++;
		}
		
		if(right-left-1>=maxLen)
			{
				maxLen=right-left-1;
				subString=s1.substring(left+1, right);
			}
		
	}
	public static void main(String[] args) {
		
		System.out.println(LPS("abbgb"));
	}

}
