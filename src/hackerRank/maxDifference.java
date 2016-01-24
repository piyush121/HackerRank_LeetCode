package hackerRank;

import java.util.Arrays;

public class maxDifference {
	
	static int max1Difference(int[] a) {
		
		int min = a[0];
		int max_diff=a[1]-a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]<min)
				min=a[i];
				
			if(a[i]-min>max_diff)
				max_diff=a[i]-min;
		}
		
		return max_diff;
    }
	static int maxdiff(int[] a)
	{
		int diff = a[1] - a[0];
		  int min = a[0];
		  int i;
		  for(i = 1; i < a.length; i++)
		  {       
		    if (a[i] - min > diff)                               
		      diff = a[i] - min;
		    if (a[i] < min)
		         min = a[i];                     
		  }
		  return diff;
	}
	
public static void main(String[] args) {
	int [] arr={3,4,5,1,9};
	System.out.println(maxdiff(arr));
}
}
