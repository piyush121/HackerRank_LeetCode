package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDigitsWords {
	
	 @SuppressWarnings("serial")
	static final HashMap<Character,String> map = new HashMap<Character,String>(){{
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
	    
	    public static ArrayList<String> letterCombinations(String digits) {
	        ArrayList<String> res = new ArrayList<String>();
	        ArrayList<String> preres = new ArrayList<String>();
	        res.add("");
	        for(int i=0;i<digits.length();i++)  ///O(n)
	        {
	        	for(String str: res) //O(n^2)
	        	{
		        	String letters=map.get(digits.charAt(i));
		        	for(int j=0;j<letters.length();j++) //O(1)
		        	preres.add(str+letters.charAt(j));

	        	}
	        	res=preres;
	        	preres=new ArrayList<>();
	        }
	        return res;

	      
	    }
	    
	    public static void main(String[] args) {
			System.out.println(letterCombinations("22"));
		}

}
