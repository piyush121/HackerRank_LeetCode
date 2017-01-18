/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 */
public class NumberOfConnectedComponents {
	public int countComponents(int n, int[][] edges) {
		int[] roots = new int[n];

		for (int i = 0; i < n; i++)
			roots[i] = i; // initially every node is assumed to be isolated.
		for (int[] edge : edges) {
			int root1 = find(edge[0], roots); // root of 1st node.
			int root2 = find(edge[1], roots);
			if (root1 != root2) { // not connected. So, connect them now.
				roots[root1] = root2; // Order doesnt matter here. Think deep !
				n--; // since the node is now connected, overall number of
						// connected components will decrease.
			}
		}
		return n;
	}

	public int find(int node, int[] roots) { // find the root node.

		while (roots[node] != node) {
			roots[node] = roots[roots[node]];
			node = roots[node];
		}
		return node;
	}
}
