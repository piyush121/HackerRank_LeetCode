/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Hint:

How many MHTs can a graph have at most?
Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 */
public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) { // Based on topological sort.
		List<Set<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new HashSet<Integer>()); 

		for (int i = 0; i < n; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);// create adjancency list.
			adjList.get(edges[i][1]).add(edges[i][0]);

		}
		int count = 0;
		List<Integer> leaves = new ArrayList<>(); // keep track of all leaves
		for (int i = 0; i < n; i++)
			if (adjList.get(i).size() == 1) {
				leaves.add(i);
				count++;
			}
		while (count > 2) { // In the end at most two leaves will be left.
			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf : leaves) {
				count--;
				int next = adjList.get(leaf).iterator().next();
				;
				adjList.get(next).remove(leaf);
				if (adjList.get(next).size() == 1)
					newLeaves.add(next);

			}
			leaves = newLeaves;
		}

		return leaves;
	}
}
