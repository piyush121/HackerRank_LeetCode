package hackerRank;

import java.util.Scanner;

public class timeConversion {
	
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String time = in.next();
	        String hr=time.charAt(0)+""+time.charAt(1);
        	String min=time.charAt(3)+""+time.charAt(4);
        	String sec=time.charAt(6)+""+time.charAt(7);
	        
	        String str=time.charAt(time.length()-2)+""+time.charAt(time.length()-1);
	        System.out.println(str);
	        
	        if(str.equals("PM") && !hr.equals("12"))
	        	{
	        		hr=String.valueOf(Integer.parseInt(hr)+12);
	        	}
	        if(hr.equals("12")&& !str.equals("PM"))
	        	hr="00";
	        System.out.println(hr+":"+min+":"+sec);
	        	in.close();
	    }

}
