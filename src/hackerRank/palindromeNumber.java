package hackerRank;

public class palindromeNumber {
	
	public static boolean isPalindrome(int x) {
       int p=1;
       int r=1;
       while(x/p>=10)
    	 p*=10;
       
       while(p>r)
       {
    	   if((x/p)%10 == (x/r)%10)
    	   {
    		   p=p/10;
    	   	r=r*10;
    	   }
    	  else
    	   	return false;
       }
        
   return true;
        
        
    }
	
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(10));
	
	}

}
