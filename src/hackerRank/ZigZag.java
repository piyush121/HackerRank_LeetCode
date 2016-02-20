package hackerRank;

public class ZigZag {

	public static void print(String str, int rows) {
		boolean dir = true;
		for (int i = 0; i < rows; i++) {
			int j = i;
			int ptr = i;
			dir = true;
			while (j < str.length()) {
				if (j % (rows - 1) == 0) {
					System.out.print(str.charAt(j));
					j += 2 * (rows - 1);
				} else {
					if (dir) {
						// System.out.print(j);
						System.out.print(str.charAt(j));
						j += 2 * (rows - 1 - ptr);
						dir = !dir;
					} else {
						// System.out.print(j);
						System.out.print(str.charAt(j));
						j += 2 * (ptr);
						dir = !dir;
					}

				}

			}
		}

	}

	public static void main(String[] args) {
		print("paypalishiring", 4);
	}

}
