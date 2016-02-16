package hackerRank;

public class StringtoNum {
	
	public static void strToNum(String str)
	{	
		int num=0;
		for(int i=0;i<str.length();i++)
			num= num*10+ (str.charAt(i)-'0');

		System.out.println(num);
	}
	public static void strToNum1(String str)
	{	
		int num=0;
		for(int i=str.length()-1;i>=0;i--)
			num+=Math.pow(10, str.length()-1-i)* (str.charAt(i)-'0');

		System.out.println(num);
	}
	public static void main(String[] args) {
		strToNum1("0435");
	}
}
