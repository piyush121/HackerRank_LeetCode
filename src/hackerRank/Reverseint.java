package hackerRank;

public class Reverseint {
	
	 public static int reverse(int x) {
	        int div=1;
	        int num=0;
	        while(Math.abs(x/div)>=1)
	            {   
	                if((num*10 + (x/div)%10)/10!=num)
	                    return 0;
	                num=num*10 + (x/div)%10;
	                if((div*10)/10!=div)
	                	break;
	                div*=10;
	     }

	            return num;
	}
	 
	 public static void main(String[] args) {
		 
		 System.out.println(reverse(-2147483412));
		
	}

}
