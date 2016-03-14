package hackerRank;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = Integer.MIN_VALUE;
		int i = 0;
		int j = height.length - 1;

		while (i < j) {   //O(n) time and O(1) space.
			int area = Math.min(height[i], height[j]) * (j - i);
			if (area > maxArea)
				maxArea = area;
			if (height[i] > height[j]) // Since the bottleneck is the smaller
				j--;					// coordinate, so it's better to
			else						// increment/decrement it in the hope
				i++;					// of getting a bigger one.
		}
		return maxArea;
	}
}
