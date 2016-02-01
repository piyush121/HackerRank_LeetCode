package hackerRank;

import java.util.Arrays;

public class medianSortedArrays {
	
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2,int n,int s1,int e1,int s2,int e2 ) {
	        
	     int mid1=nums1.length/2;
	     int mid2=nums2.length/2;

	     if(n==1)
	    	 return (nums1[0]+nums2[0])/2;
	     if(nums1[mid1]==nums2[mid2])
	    	 return nums1[mid1];
	     if(n==2)
	    	 return (Math.max(nums1[0], nums1[1])+Math.min(nums2[0], nums2[1]))/2;
	    double m1=median(nums1);
	    double m2=median(nums2);
	    int[] arr;
	    if(m1>m2)
	    {	
	    		
	    }
	     return 0;
	    }
	 
	 public static double median(int[] arr )
	 {
		 int n=arr.length;
		 if(n%2==0)
		 {
			 return (arr[n/2] + arr[n/2-1])/2;
		 }
		 else 
			 return arr[n/2];
	 }
	 
	 public static void main(String[] args) {
		
	}

}
