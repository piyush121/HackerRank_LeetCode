package hackerRank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LIC {

	
	
	 
	/** Class  LongestIncreasingSubsequence **/
	
	    /** function lis **/
	    public static Integer[] lis(int[] A)
	    {        
	    	int[] m = new int[A.length];
	        //Arrays.fill(m, 1);//not important here
	        for (int x = A.length - 2; x >= 0; x--) {
	          for (int y = A.length - 1; y > x; y--) {
	            if (A[x] < A[y] && m[x] <= m[y]) {
	              m[x]++;//or use m[x] = m[y] + 1;
	            }
	          }
	        }
	        int max = m[0];
	        for (int i = 1; i < m.length; i++) {
	          if (max < m[i]) {
	            max = m[i];
	          }
	        }
	        List<Integer> result = new ArrayList<Integer>();
	        for (int i = 0; i < m.length; i++) {
	          if (m[i] == max) {
	            result.add(A[i]);
	            max--;
	          }
	        }
	        return result.toArray(new Integer[0]);
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
	 
	        
	        Integer[] result = lis(arr);       
	 
	        /** print result **/ 
	 
	        System.out.print("\nLongest Increasing Subsequence : ");
	            System.out.print(n-result.length-1);
	       
	    }
	}

