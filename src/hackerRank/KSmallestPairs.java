/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the 
second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
 *
 */

class Solution {
	class Pairs {
		int sum;
		int jIdx;
		int[] pair;

		public Pairs(int[] pair, int idx) {
			this.sum = pair[0] + pair[1];
			this.pair = pair;
			this.jIdx = idx;
		}

		public String toString() {
			return sum + "";
		}
	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) { // O(klogk) solution!.
		List<int[]> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0)
			return res;
		PriorityQueue<Pairs> que = new PriorityQueue<>(new Comparator<Pairs>() {
			public int compare(Pairs obj1, Pairs obj2) {
				return obj1.sum - obj2.sum;
			}

		});
		for (int i = 0; i < nums1.length; i++)
			que.add(new Pairs(new int[] { nums1[i], nums2[0] }, 0));
		// System.out.println(que);

		for (int i = 0; i < k && !que.isEmpty(); i++) {
			Pairs temp = que.poll();
			res.add(temp.pair);
			int idx = temp.jIdx;
			if (idx + 1 != nums2.length) {
				que.offer(new Pairs(new int[] { temp.pair[0], nums2[idx + 1] }, idx + 1));
			}
		}
		return res;
	}
}

public class KSmallestPairs {

	class Pairs {
		int sum;
		int[] pair;

		public Pairs(int[] pair) {
			this.sum = pair[0] + pair[1];
			this.pair = pair;
		}
	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) { // O(n^2)
																			// solution.

		PriorityQueue<Pairs> que = new PriorityQueue<>(new Comparator<Pairs>() {
			public int compare(Pairs obj1, Pairs obj2) {
				return obj1.sum - obj2.sum;
			}

		});
		for (int i = 0; i < nums1.length; i++)
			for (int j = 0; j < nums2.length; j++)
				que.add(new Pairs(new int[] { nums1[i], nums2[j] }));
		// System.out.println(que);
		int size = que.size();
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < k && i < size; i++) {
			res.add(que.poll().pair);
		}
		return res;
	}
}
