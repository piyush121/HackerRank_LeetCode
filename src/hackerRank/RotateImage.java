/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

Try to solve this in-place - in a real interview, you will only be allowed to use O(1) additional memory.

Example

For

a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
the output should be

rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
 *
 */
public class RotateImage {
	int[][] rotateImage(int[][] a) {
		if (a.length <= 1)
			return a;
		reverseTopBottom(a);
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < a[0].length; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
		return a;
	}

	void reverseTopBottom(int arr[][]) {
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length / 2; i++) {
				int temp = arr[i][j];
				arr[i][j] = arr[arr.length - i - 1][j];
				arr[arr.length - i - 1][j] = temp;
			}
		}
	}

}
