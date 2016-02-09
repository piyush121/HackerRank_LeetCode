package hackerRank;

public class NumToBinary {

	public static void numTobin(int num)
	{
		String str="";
		while(num/2!=0) //O(logn)
		{
			str+=String.valueOf(num%2);
			num/=2;
		}
		
		if(num==1)
			str+=String.valueOf(num);
		String str1="";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			str1+=str.charAt(i);
		}
		System.out.println(str1);
	}

	
	public static void main(String[] args) {
		numTobin(16);
	}
}
