package hackerRank;

import java.util.HashSet;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) { // O(n^2) time O(n)
															// space.
		for (int i = 0; i < 9; i++) { // O(n)
			HashSet<Character> rows = new HashSet<>();
			HashSet<Character> columns = new HashSet<>();
			HashSet<Character> blocks = new HashSet<>();
			for (int j = 0; j < 9; j++) { // O(n)
				if (board[i][j] != '.' && !rows.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !columns.add(board[j][i]))
					return false;
				
				int rowIndex = 3 * (i / 3); // row index of current block to be
											// checked.
				int colIndex = 3 * (i % 3);
				if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !blocks.add(board[rowIndex + j / 3][colIndex + j % 3]))
					return false;

			}
		}

		return true;

	}

}
