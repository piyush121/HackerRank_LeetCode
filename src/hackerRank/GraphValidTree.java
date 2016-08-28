/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 * 
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 * 
 * Hint:
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is
 * this case a valid tree? According to the definition of tree on Wikipedia: “a
 * tree is an undirected graph in which any two vertices are connected by
 * exactly one path. In other words, any connected graph without simple cycles
 * is a tree.” Note: you can assume that no duplicate edges will appear in
 * edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus
 * will not appear together in edges.
 *
 */
public class GraphValidTree {
	int count;

	public boolean validTree(int n, int[][] edges) {
		if (edges.length == 0 && n == 0)
			return true;
		count = 0;
		List<List<Integer>> adjList = new ArrayList<>();
		// Initialize adjlist.
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		// Fill up adjList
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		boolean[] visited = new boolean[n];
		boolean res = hasCycle(-1, 0, visited, adjList);
		if (count != n)
			return false;
		return !res;
	}

	private boolean hasCycle(int parent, int curr, boolean[] visited, List<List<Integer>> adjList) {

		visited[curr] = true;
		count++;
		for (int i = 0; i < adjList.get(curr).size(); i++) {
			int next = adjList.get(curr).get(i);
			if (visited[next] && next != parent)
				return true;
			if (!visited[next] && hasCycle(curr, next, visited, adjList))
				return true;

		}
		return false;

	}
}
