/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the 
 * number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in 
linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or 
in any other language.
Hint:

You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from 
previous.
Or does the odd/even status of the number help you in calculating the number of 1s?
 *
 */
public class CountingBits {
	public int[] countBits(int num) {
        if(num == 0)
        	return new int[]{0};
        int[] res = new int[num + 1];
        int offset = 1;
 // Pattern goes like : 0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4...       
        for(int i = 1; i <=num; i++) {
        	if(offset * 2 == i)
        		offset *= 2; // This part makes you think really hard, how to code !
        	res[i] = 1 + res[i - offset]; // Tricky part !
        }
        return res;
    }
	
	public int[] countBits1(int num) { // yet another method.
        if(num == 0)
        	return new int[]{0};
        int[] res = new int[num + 1];
        int pow = 1;
        int prev = 0;
        for(int i = 1; i <=num; i++) {
        	if(pow == i) {
        	    prev = 0;    
        	    pow *= 2;
        	}
        	res[i] = 1 + res[prev];
        	prev++;
        }
        return res;
    }
}
