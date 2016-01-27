package hackerRank;

import java.util.Scanner;

public class maxSumSubArray {

	public static void findS(int[] arr)
	{
		int maxsofar=0;
		int sum1=0;
		int sum2=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
				sum2+=arr[i];
			if(arr[i]+sum1<0)
				sum1=0;
			if(arr[i]+sum1>=0)
				sum1+=arr[i];
			
			if(sum1>maxsofar)
				maxsofar=sum1;
		}
		System.out.println(maxsofar+" "+sum2);
	}
	
	
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int t=in.nextInt();
	for(int i=0;i<t;i++)
	{
		int s = in.nextInt();
	    int[] ar = new int[s];
	    for(int j=0;j<s;j++){
	        ar[j]=in.nextInt(); 
     }
	    findS(ar);

	}
	}
}