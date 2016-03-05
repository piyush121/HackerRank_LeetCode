package hackerRank;

import java.util.BitSet;

public class UniqueChars {

	public static boolean uniqChars(String str) // using just an int value as an integer vector.
	{
		int checker=0;
		for(int i=0;i<str.toCharArray().length;i++)
		{
			if((checker & 1<<(str.charAt(i)-'a')) > 0)
				return false;
			else
				checker|=1<<(str.charAt(i)-'a');
			
		}
		return true;
	}
	public static boolean uniqChars1(String str) // using BitSet or bit vector
	{
		BitSet set= new BitSet(256);
		for(int i=0;i<str.toCharArray().length;i++)
		{
			if(set.get(str.charAt(i)-'a') == true)
				return false;
			else
				set.set(str.charAt(i)-'a',true);
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(uniqChars1("world"));
	}
}
