/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 */

class Tuple {
	int val;
	int row;
	int col;
	public Tuple(int val, int row, int col) {
		this.val = val;
		this.col = col;
		this.row = row;
	}
}
public class KthSmallestElementInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) { //
		if (matrix.length == 0)
			return -1;
		PriorityQueue<Tuple> que = new PriorityQueue<>(new Comparator<Tuple>() {
			public int compare(Tuple t1, Tuple t2) {
				return t1.val - t2.val;
			}
		});
		for (int i = 0; i < matrix[0].length; i++) // put 1st row in the que.
			que.offer(new Tuple(matrix[0][i], 0, i));
		Tuple curr = null;
		while (k > 0) { // extract row and col of the lowest val and put the
						// next item in the same row.
			curr = que.poll();
			if (curr.row < matrix[0].length - 1)
				que.offer(new Tuple(matrix[curr.row + 1][curr.col], curr.row + 1, curr.col));
			k--;
		}

		return curr.val;
	}

	public int kthSmallest1(int[][] matrix, int k) { // Wild Binary Search
														// solution !
		int low = matrix[0][0];
		int high = matrix[matrix.length - 1][matrix.length - 1];

		while (low < high) {
			int mid = (low + high) / 2;
			int count = 0;
			int j = matrix[0].length - 1;
			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid)
					j--;
				count += (j + 1);

			}
			if (count < k)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
}
