package hackerRank;

import java.util.Arrays;

public class QuickSort {
	public static void qSort(int[] A,int low,int high)
	{	
		
		if(low<high)
		{
			int index=partition(A,low,high);
			qSort(A,low,index-1);
			qSort(A,index+1,high);
		}
	}
	
	public static int partition(int[] arr,int low, int high)
	{
		int i=low;
		for(int j=low;j<=high;j++)
		{
			if(arr[j]<arr[low])
			{
				i++;
				arr[j]=arr[i]^arr[j]^(arr[i]=arr[j]);
			}
		}
		
		arr[i]=arr[low]^arr[i]^(arr[low]=arr[i]);
		return i;
	}
	
	public static void main(String[] args) {
		int[] arr={4,5,3,2,1,7,8};
		qSort(arr,0,6);
		System.out.println(Arrays.toString(arr));
	}

}
