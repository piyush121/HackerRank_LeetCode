/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * Rectangle Area Assume that the total area is never beyond the maximum
 * possible value of int.
 *
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) { // Straight
																						// forward
																						// Math
																						// based
																						// solution.
		if (C <= E || A >= G || B >= H || D <= F)
			return (C - A) * (D - B) + (G - E) * (H - F);

		int topX = Math.min(C, G);
		int topY = Math.min(H, D);
		int bottomX = Math.max(A, E);
		int bottomY = Math.max(F, B);
		int overlap = (topX - bottomX) * (topY - bottomY);

		return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
