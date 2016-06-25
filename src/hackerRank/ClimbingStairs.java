/**
 * @author Piyush Chaudhary
 */
package hackerRank;
/*
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
/**
 * @author Piyush Chaudhary
 *
 */
public class ClimbingStairs {

	public int climbStairs(int n) { // Basically a Fibonacci series.
       int prevPrev = 1;
       int prev = 2;
       if( n == 2)
    	   return prevPrev;
       if(n == 1)
    	   return prev;
       int curr = 0;
       for(int i = 3; i <= n ; i ++) {
    	   curr = prev + prevPrev;
    	   prevPrev = prev;
    	   prev = curr;
   	   }
       return curr; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
