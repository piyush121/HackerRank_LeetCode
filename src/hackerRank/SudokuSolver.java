/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 *
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {

		dfs(board, 0, 0);
	}

	public boolean dfs(char[][] board, int row, int col) {
		if (row == board.length) // Slution found.
			return true;
		if (col == board[0].length) { // Time to move to new row.
			return dfs(board, row + 1, 0);
		}
		if (board[row][col] != '.') { // Pre allocated immutable value.
			return dfs(board, row, col + 1);
		}

		for (int val = 1; val < 10; val++) {// O(1). Try all possible values i.e only 9 values.
			char ch = (char) ('0' + val);
			if (isValid(board, row, col, ch)) {
				board[row][col] = ch;
				if (dfs(board, row, col + 1))
					return true;
				else
					board[row][col] = '.';
			}
		}
		return false;
	}

	public boolean isValid(char[][] board, int row, int col, char c) {
		// row check
		for (int i = 0; i < 9; i++)
			if (board[row][i] == c)
				return false;
		// column check
		for (int i = 0; i < 9; i++)
			if (board[i][col] == c)
				return false;

		// 3 x 3 block check
		row = row / 3 * 3;
		col = col / 3 * 3;
		for (int i = row; i < row + 3; i++)
			for (int j = col; j < col + 3; j++)
				if (board[i][j] == c)
					return false;
		return true;
	}
}
