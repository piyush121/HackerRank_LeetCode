/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
 *
 */
public class FactorCombinations {
	public List<List<Integer>> getFactors1(int n) {
        if(n < 2)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper1(n, 2, new ArrayList<>(), res); // usual stuff.
        return res;
    }
    
    private void helper1(int n, int start, List<Integer> curr,List<List<Integer>> res ) {
        if(n == 1 ) { // Recurse only when you have found all the factors.
            if(curr.size() > 1) { // Leave the number itself as a factor. Will cost some time.
            List<Integer> temp = new ArrayList<>();
            temp.addAll(curr);
            res.add(temp);
           return;
        }
    }
        for(int i = start; i <= n; i++) { // This will go all the way till `n`.
            if( n % i == 0) {
                curr.add(i);
                helper1(n/i, i, curr, res);
                curr.remove(curr.size() -1 );
            }
        }
    }
//Here comes the efficient one: (f**k the base case. No need here.)

public List<List<Integer>> getFactors(int n) {
        if(n < 2)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(n, 2, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(int n, int start, List<Integer> curr,List<List<Integer>> res ) { // No need of base case. Think why?
        for(int i = start; i <= (int)Math.sqrt(n); i++) { // will go only till sqrt `n`
            if( n % i == 0) {
                curr.add(i);
                helper(n/i, i, curr, res); // send the next factor to the recursive call.
                List<Integer> temp = new ArrayList<>();
                temp.addAll(curr);
                temp.add(n/i); // Now add that factor which you just sent to that recursive call.
                res.add(temp);
                curr.remove(curr.size() -1 );
            }
        }
    }
}
