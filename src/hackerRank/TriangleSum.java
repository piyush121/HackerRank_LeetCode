package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleSum {
	public static int minimumTotal(List<List<Integer>> triangle) {

		int[][] table = new int[triangle.size() + 1][triangle.size() + 1];
		for (int i = 1; i < table.length; i++)
			Arrays.fill(table[i], Integer.MAX_VALUE); // fill table with max
														// value
		for (int i = 1; i < table.length; i++)
			for (int j = 1; j <= triangle.get(i - 1).size(); j++) //take minimum of upper and upeer left value.
				table[i][j] = Math.min(table[i - 1][j], table[i - 1][j - 1]) + triangle.get(i - 1).get(j - 1);

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < table.length; i++)
			if (table[table.length - 1][i] < min)
				min = table[table.length - 1][i]; // Scan last row to find minimum element.
		return min;

	}

	public static void main(String[] args) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.get(0).add(-1);
		list.get(1).add(2);
		list.get(1).add(3);
		list.get(2).add(1);
		list.get(2).add(-1);
		list.get(2).add(-3);

		System.out.println(minimumTotal(list));
	}
}
