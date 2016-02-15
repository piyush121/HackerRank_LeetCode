package hackerRank;

public class StringtoNum {
	
	public static void strToNum(String str)
	{	
		int num=0;
		int num2='0';

		for(int i=0;i<str.length();i++)
			num= num*10+ (str.charAt(i)-'0');

	
		
		System.out.println(num);
	}
	public static void main(String[] args) {
		strToNum("0435");
	}
}
