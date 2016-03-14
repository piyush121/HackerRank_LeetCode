package hackerRank;

public class LongestCommonPrefix {
	 public static String longestCommonPrefix(String[] strs) {
	        StringBuilder str=new StringBuilder();
	        if(strs.length!=0)
	            str=str.append(strs[0]);
	        else
	            return "";
	        int min=strs[0].length();
	        int count=0;
	        for(String st : strs){
	            for(int i=0;i<Math.min(str.length(),st.length());i++){
	                if(str.charAt(i)==st.charAt(i))
	                    count++;
	                else
	                    break;
	                    
	            }
	            if(count<min)
	                {
	                    min=count;
	                    str.delete(min,str.length());
	                }
	            count=0;
	        }
	        
	        return str.toString();
	        
	    }
	 
	 public static void main(String[] args) {
		 String[] strs={"aaa","aa","aaa"};
		System.out.println(longestCommonPrefix(strs));
	}

}
