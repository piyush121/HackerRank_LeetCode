package hackerRank;

import java.util.Arrays;

public class CountSort {
	
	public static void sort(int A[])
	{
		int max=9;		//Didn't want to write code to find max and min value in the array.
		int min=0;
		int[] B=new int[max-min+1];
		int[] res=new int[A.length];
		
		for(int i=0;i<A.length;i++)
		{
			B[A[i]]++;
		}
		
		for(int r=1;r<B.length;r++)
			B[r]=B[r-1]+B[r];
		System.out.println(Arrays.toString(B));
		for(int k=0;k<A.length;k++)
		{	System.out.println(k);
			res[B[A[k]]]=B[A[k]]-1;
			B[A[k]]--;
		}
		
	}

	public static void main(String[] args) {
		int[] arr={5,4,3,2,1,1,1,0,0,0,9};
		sort(arr);
		System.out.println(arr);
	}
}
