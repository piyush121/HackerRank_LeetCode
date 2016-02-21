package hackerRank;

public class ZigZag {	

	public static void print(String str, int rows) {
		boolean dir = true;
		if (rows == 1)
			return;
		for (int i = 0; i < rows; i++) {
			int j = i;
			int ptr = i;	// to track current location.
			dir = true;
			while (j < str.length()) {
				if (j % (rows - 1) == 0) {
					System.out.print(str.charAt(j));
					j += 2 * (rows - 1);	//IF POINTER is at top or bottom location.
				} else {
					if (dir) {
						System.out.print(str.charAt(j));
						j += 2 * (rows - 1 - ptr);	// if pointer is between 0 & rows and its going down.
						dir = !dir;
					} else {
						System.out.print(str.charAt(j));
						j += 2 * (ptr);	// if its going up.
						dir = !dir;
					}

				}

			}
		}

	}

	public static void main(String[] args) {
		print("paypalishiring", 2);
	}

}
