package hackerRank;
import java.math.BigInteger;
import java.util.*;

public class bigInteger {

	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        BigInteger big = BigInteger.valueOf(n);
	        
	        for(int i=1;i<=n;i++)
	        	big=big.multiply(BigInteger.valueOf(i));
	        
	        System.out.println(big);
	        in.close();
	    }
	 
	  
}
