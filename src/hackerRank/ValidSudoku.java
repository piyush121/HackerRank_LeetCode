package hackerRank;

import java.util.HashSet;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rows = new HashSet<>();
			HashSet<Character> columns = new HashSet<>();
			HashSet<Character> blocks = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !rows.add(board[j][i]))
					return false;
				int rowIndex = j % 3;
				int colIndex = j / 3;

			}
		}

		return true;

	}

}
