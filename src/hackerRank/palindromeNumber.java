package hackerRank;

public class palindromeNumber {
	
	public static boolean isPalindrome(int x) {
        int ten=10;
        String str="";

while(x/ten>=1)
    {
        str+=x%ten;
        ten=ten*10;
    }
    
    str+=(10*x)/ten;
    System.out.println(str);
    for(int i=0;i<str.length()/2;i++)
        if(str.charAt(i)!=str.charAt(str.length()-1-i))
            return false;
    return true;
        
        
    }
	
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(202));
	
	}

}
