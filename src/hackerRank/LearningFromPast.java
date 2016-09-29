/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Scanner;

/**
 * Submitted as a part of Moody's University Hackathon.
 *
 */
public class LearningFromPast {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[3];
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < 3; j++) {
                arr[j] = scan.nextInt();
            }
            int sum = Math.max(Math.max(arr[0] + arr[1], arr[1] + arr[2]), arr[0] + arr[2]);
            if(sum > max)
                max = sum;
        }
            
        System.out.println(max);
    }
}
