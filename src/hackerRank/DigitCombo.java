package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DigitCombo {
	
	public static void printCombo(String str)
	{
	
	
		 @SuppressWarnings("serial")
			final HashMap<Character,String> map = new HashMap<Character,String>(){{
					put('1',"");
			        put('2',"abc");
			        put('3',"def");
			        put('4',"ghi");
			        put('5',"jkl");
			        put('6',"mno");
			        put('7',"pqrs");
			        put('8',"tuv");
			        put('9',"wxyz");
			    }} ;
		 ArrayList<String> res = new ArrayList<String>();
	     ArrayList<String> preres = new ArrayList<String>();
		res.add("");
		for(int i=0;i<str.length();i++)
		{
			String letters=map.get(str.charAt(i));
			
			for(int j=0;j<letters.length();j++)
			{
				for(String st: res)
					preres.add(letters.charAt(j)+st);
			}
			res=preres;
			preres=new ArrayList<>();
			
		}
		System.out.println(res);
		
	}
	
	public static void main(String[] args)
	{
		printCombo("22");
	}


}