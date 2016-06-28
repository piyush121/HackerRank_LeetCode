/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [['A','B','C','E'],
 *  ['S','F','C','S'], 
 *  ['A','D','E','E']] 
 *  word = "ABCCED", -> returns true,
 *  word = "SEE", -> returns true, 
 *  word = "ABCB", -> returns false.
 *
 */
public class WordSearch {
	public static boolean exist(char[][] board, String word) { // Cant do better than this. Most optimal yet !
		char[] words = word.toCharArray();
		for(int i = 0 ; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == words[0])
					if (DFS(i, j, board, words, 0))
						return true;
			}
		}
		return false;
    }
	
	private static boolean DFS(int row, int col, char[][] board, char[] word, int index) {
		
		if(index == word.length)
			return true;
		if(row > board.length -1 || row < 0 || col > board[0].length - 1 || col < 0 )
			return false;
		if(word[index] != board[row][col])
			return false;
		board[row][col] ^= 256;
		boolean result = DFS(row+1, col, board, word, index + 1)|| DFS(row - 1, col, board, word, index + 1) || DFS(row, col + 1, board, word, index + 1) || DFS(row, col - 1, board, word, index + 1);

		board[row][col] ^= 256;

		
		return result;
	}
	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
						};
		System.out.println(exist(board,"ABCB"));
	}

}
