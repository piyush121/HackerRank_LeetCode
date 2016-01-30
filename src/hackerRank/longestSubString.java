package hackerRank;

import java.util.HashSet;

public class longestSubString {
	
	 public static int lengthOfLongestSubstring(String s) {
		   
	        int max=0;
	        int count=0;
	        int low=0;
	        int start=0;
	        HashSet<Character> myhash=new HashSet<>();

	        for(low=0;low<s.length();)
	            {	
	                while(start<s.length())
	                {
	                	 if(!myhash.contains(s.charAt(start)))
	                     {
	                         count++;
	                         myhash.add(s.charAt(start));
	                         start++;
	                        // System.out.println(count);
	                     }
	                	 else
	                	 {
	                		 if(count>max)
	     	                     max=count;
	                		 while(s.charAt(low)!=s.charAt(start)) //Bringing the low pointer to the location of the repeated element+1.
	                			 {
	                			 	myhash.remove(s.charAt(low));
	                			 	low++;
	                			 }
	                		 myhash.remove(s.charAt(low));
	                		 low++;
	                		
	                		 count=start-low;
	                		 break;
	                	 }
	                	
	               }
	                if(start>=s.length())
     					break;

	            }
	        if(count>max)
                 max=count;
	        return max;
	    }

	 public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aaab"));
	}
}
