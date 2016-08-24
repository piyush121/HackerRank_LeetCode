/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Iterator;
import java.util.List;

/**
 * mplement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Hint:

How many variables do you need to keep track?
Two variables is all you need. Try with x and y.
Beware of empty rows. It could be the first few rows.
To write correct code, think about the invariant to maintain. What is it?
The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
Not sure? Think about how you would implement hasNext(). Which is more complex?
Common logic in two different places should be refactored into a common method.
 *
 */
public class Vector2D implements Iterator<Integer> {
	List<List<Integer>> list;
	int x;
	int y;

	public Vector2D(List<List<Integer>> vec2d) {
		list = vec2d;
		x = 0;
		y = 0;
	}

	@Override
	public Integer next() {
		int val = list.get(y).get(x);
		x++;
		return val;
	}

	@Override
	public boolean hasNext() {
		if (list.size() == 0)
			return false;
		if (x < list.get(y).size())
			return true;
		y++; // Increment because the row has ended.
		while (y < list.size() && list.get(y).size() == 0) // check if empty row.
			y++;
		x = 0;
		if (y < list.size())
			return true;
		return false;
	}
}