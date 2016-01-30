package hackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class sherlockPair {
	

	 public static void main(String[] args) {
		    Scanner in= new Scanner(System.in);
		    
		    HashSet<Long> myhash=new HashSet<>();
		    int N=in.nextInt();
		    int[] arr;
		    for(int i=0;i<N;i++)
		    {   
		        Long pairs=Long.valueOf(1);
		        myhash.clear();
		    	int len=in.nextInt();
		    	arr=new int[len];
		    	for(int j=0;j<len;j++)
		    	{
		    		arr[j]=in.nextInt();
		    	}
		    	if(len>0)
		    		myhash.add(Long.valueOf(arr[0]));
		    	for(int k=1;k<len;k++)
		    	{
		    		if(!myhash.contains(arr[k]))
		                myhash.add(Long.valueOf(arr[k]));
		    		
		            else
		                pairs++;
		    	}
		    	  if(pairs>2)
			    	  System.out.println(pairs*(pairs-1));
	                if(pairs==1)
	                    System.out.println(0);
	                if(pairs==2)
	                    System.out.println(2);
		    }
		    in.close();
		  
		}
}