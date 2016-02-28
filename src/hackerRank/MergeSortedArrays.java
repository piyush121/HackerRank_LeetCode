package hackerRank;

import java.util.Arrays;

public class MergeSortedArrays {
	
	public static Integer[] merge(int[] A, int[] B) {
		
		Integer[] merged=new Integer[A.length+B.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<A.length && j<B.length) //both pointers should be less than their respective length.
		{
			if(A[i]<=B[j])
			{
				merged[k]=A[i];
				i++;
			}
			else
			{
				merged[k]=B[j];
				j++;
			}
			k++;		//Increment main pointer
		}
		if(i!=A.length)	//onr of the pointers must be at less than the array's length.
		{
			while(i<A.length)
				{
				merged[k]=A[i];
				k++;
				i++;
				}
		}
		else
		{
			while(j<B.length)
				{
					merged[k]=B[j];
					k++;
					j++;
				}
		}
		
		return merged;
	}
	
	public static void main(String[] args) {
		int[] arr1={1,4,6,8,9};
		int[] arr2={7};
		System.out.println(Arrays.toString(merge(arr1,arr2)));
	}

}
