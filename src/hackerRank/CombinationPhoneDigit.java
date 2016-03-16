package hackerRank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CombinationPhoneDigit {
	final static HashMap<Character,String> map = new HashMap<Character,String>(){{
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
	 public static List<String> letterCombinations(String digits) {
		 List<String> list1=new LinkedList<String>();
		 List<String> list2=new LinkedList<String>();
		 list2.add("");

		 for(int i=0;i<digits.length();i++) {
			 String str1=map.get(digits.charAt(i));
			 while(!list2.isEmpty()) {
				 String str2=list2.remove(0);
				 for(int j=0;j<str1.length();j++) {
					 list1.add(str2+str1.charAt(j));
				 }
			}
			 list2=list1;
			 list1=new LinkedList<>();
		 }
	        return list2;
	    }
	 
	 public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

}
