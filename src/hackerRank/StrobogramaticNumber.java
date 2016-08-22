/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogramaticNumber {
	public boolean isStrobogrammatic(String num) {
		int[] map = new int[10];
		Arrays.fill(map, -1);
		map[6] = 9;
		map[9] = 6;
		map[8] = 8;
		map[1] = 1;
		for(int i = 0 ; i <= num.length() / 2; i++) {
			char ch = num.charAt(i);
			char hc = num.charAt(num.length() - i - 1);
			if(map[ch - '0'] != hc - '0')
				return false;
		}	
		
		return true;
		
	}
	public static void main(String[] args) {
		StrobogramaticNumber obj = new StrobogramaticNumber();
		System.out.println(obj.isStrobogrammatic("696"));
	}
}
