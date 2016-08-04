/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * Related problem: Reverse Integer
 *
 */
public class ReverseBits {
	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		int res = 0;
		for(int i = 0 ; i < 32; i++) {
		res += n & 1;
		n >>>= 1; // Shift fill zero operator.
		if( i < 31) // Don't shift left the last bit otherwise it may overflow.
			res <<= 1;
		}
		return res;
	}


	public static void main(String[] args) {
		System.out.println(reverseBits( 2147483647));

	}

}
