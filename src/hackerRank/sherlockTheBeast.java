package hackerRank;

import java.io.*;
import java.util.*;

public class sherlockTheBeast {

	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            {
	            	int n = in.nextInt();
	            	//String str=String.valueOf(n);
	            	StringBuilder strb=new StringBuilder();
	            	int j=0;
	               	for(int i=n;i>0;i--)
	            		
	            	{	//System.out.println(i);
	            		if(i%3==0 && (n-i)%5==0)
	            		{
	            			for(j=0;j<i;j++)
	            				strb.append("5");
	            			for(int k=j;k<n;k++)
	            				strb.append("3");
	            			break;
	            			
	            		}
	            	}
	            	if(strb.length()==0 && n%5==0)
	            		for(int k=n;k>0;k--)
            				strb.append("3");
	            	else if(strb.length()==0)
	            		strb.append(-1);
	            	
	            	System.out.println(strb);
	            }
	            
	        }
	        
	        
	    }
	
}
