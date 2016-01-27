package hackerRank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LIC {

	
	
	 
	/** Class  LongestIncreasingSubsequence **/
	
	    /** function lis **/
	    public static int[] lis(int[] x)
	    {        
	    	int n = x.length;
	        int[] len = new int[n];
	        Arrays.fill(len, 1);
	        int[] pred = new int[n];
	        Arrays.fill(pred, -1);
	        for (int i = 1; i < n; i++) {
	          for (int j = 0; j < i; j++) {
	            if (x[j] < x[i] && len[i] < len[j] + 1) {
	              len[i] = len[j] + 1;
	              pred[i] = j;
	            }
	          }
	        }
	        int bi = 0;
	        for (int i = 1; i < n; i++) {
	          if (len[bi] < len[i]) {
	            bi = i;
	          }
	        }
	        int cnt = len[bi];
	        int[] res = new int[cnt];
	        for (int i = bi; i != -1; i = pred[i]) {
	          res[--cnt] = x[i];
	        }
	        return res;
	    	  }
	 
	    /** Main Function **/
	    public static void main(String[] args) 
	    {    
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Longest Increasing Subsequence Algorithm Test\n");
	 
	        System.out.println("Enter number of elements");
	        int n = scan.nextInt();
	        int[] arr = new int[n + 1];
	        System.out.println("\nEnter "+ n +" elements");
	        for (int i = 1; i <= n; i++)
	            arr[i] = scan.nextInt();
	 
	        
	        int[] result = lis(arr);       
	 
	        /** print result **/ 
	 
	        System.out.print("\nLongest Increasing Subsequence : ");
	            System.out.print(n-result.length+1);
	       
	    }
	}

