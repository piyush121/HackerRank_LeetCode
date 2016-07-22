/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 *
 */
public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>(); // use same list again and keep adding it to the result.
		
		for (int i = 0; i < numRows; i++) {
			list.add(0,1);
			for (int j = 1; j < i; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
				
			}
			res.add(new ArrayList<>(list));
		}
		
		return res;
	}
	
	
	public static List<List<Integer>> generate1(int numRows) { // Efficient but can be made better.
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if (numRows == 0)
			return res;
		list.add(1);
		res.add(list);
		for (int i = 1; i < numRows; i++) {
			list = new ArrayList<>();
			list.add(1);
			for (int j = 1; j < i; j++) {
				list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
			}
			list.add(1);
			res.add(list);
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(generate(5));

	}

}
