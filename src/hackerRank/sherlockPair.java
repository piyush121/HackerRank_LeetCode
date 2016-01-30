package hackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class sherlockPair {
	

	 public static void main(String[] args) {
		    Scanner in= new Scanner(System.in);
		    
		    HashMap<Long,Long> myhash=new HashMap<>();
		    int N=in.nextInt();
		    Long[] arr;
		    for(int i=0;i<N;i++)
		    {   
		        Long pairs=Long.valueOf(0);
		        myhash.clear();
		    	int len=in.nextInt();
		    	arr=new Long[len];
		    	for(int j=0;j<len;j++)
		    	{
		    		arr[j]=Long.valueOf(in.nextInt());
		    	}
		    	if(len>0)
		    		myhash.put(Long.valueOf(arr[0]),(long) 1);
		    	for(int k=1;k<len;k++)
		    	{
		    		if(!myhash.containsKey(Long.valueOf(arr[k])))
		                myhash.put(Long.valueOf(arr[k]),(long) 1);
		    		
		            else
		            	 {
		            		Long val=myhash.get(Long.valueOf(arr[k]));
		            		myhash.put(Long.valueOf(arr[k]), val+1);
		            	 }
		          }
		    	
		    	  for(Long key : myhash.values())
		    		  if(key>1)
		    			  pairs+=(key*(key-1));
	                System.out.println(pairs);
		    	  	
		    }
		    in.close();
}
}