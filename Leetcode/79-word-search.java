/**
 * 
 * Leetcode #79 - https://leetcode.com/problems/word-search/
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (searchFurther(board, word, 0, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    public boolean searchFurther(char[][] board, String word, int index, int i, int j) {
        if (index >= word.length())
            return true;
        if (!checkBounds(board, i, j) || word.charAt(index) != board[i][j])
            return false;

        char temp = board[i][j];
        boolean flag = false;
        board[i][j] = '0';

        flag = searchFurther(board, word, index + 1, i, j + 1);
        if (!flag)
            flag = searchFurther(board, word, index + 1, i, j - 1);
        if (!flag)
            flag = searchFurther(board, word, index + 1, i + 1, j);
        if (!flag)
            flag = searchFurther(board, word, index + 1, i - 1, j);

        board[i][j] = temp;

        return flag;
    }

    public boolean checkBounds(char[][] board, int i, int j) {
        return (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] != '0');
    }
}