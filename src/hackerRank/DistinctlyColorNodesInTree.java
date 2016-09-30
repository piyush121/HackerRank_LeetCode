/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Submitted as a part of Moody's University Hackathon.
 *
 */
public class DistinctlyColorNodesInTree { // Could not pass all test case as
											// this was sort of a Brute force
											// approach. So, I got timed out on
											// most test cases.
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] c = new int[n];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			c[i] = scan.nextInt();
		Map<Integer, List<Integer>> edges = new HashMap<>();
		Set<Integer> set1 = null;
		Set<Integer> set2 = null;
		for (int i = 0; i < n - 1; i++) {
			int u = scan.nextInt() - 1;
			if (!map.containsKey(u))
				map.put(u, new HashSet<Integer>());
			set1 = map.get(u);
			int v = scan.nextInt() - 1;
			set1.add(v);
			if (!map.containsKey(v))
				map.put(v, new HashSet<Integer>());
			set2 = map.get(v);
			set2.add(u);
			if (!edges.containsKey(u))
				edges.put(u, new ArrayList<Integer>());
			edges.get(u).add(v);
		}

		// System.out.println(map);
		// System.out.println("Edges : " + edges);

		int res = 0;
		Iterator it = edges.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			int u = (int) pair.getKey();
			for (int v : (List<Integer>) pair.getValue()) {
				map.get(v).remove(u);
				map.get(u).remove(v);
				int d1 = dfs(c, map, new HashSet<Integer>(), new HashSet<Integer>(), u);
				int d2 = dfs(c, map, new HashSet<Integer>(), new HashSet<Integer>(), v);
				map.get(v).add(u);
				map.get(u).add(v);
				res += d1 * d2;

				// System.out.println(res);
			}
		}

		System.out.println(res);

	}

	public static int dfs(int[] c, Map<Integer, Set<Integer>> map, Set<Integer> seenColors, Set<Integer> visited,
			int node) {
		visited.add(node);
		int res = 0;
		if (!seenColors.contains(c[node])) {
			res++;
			seenColors.add(c[node]);
		}
		for (int val : map.get(node)) {
			if (!visited.contains(val)) {
				res += dfs(c, map, seenColors, visited, val);
			}
		}

		return res;
	}
}
