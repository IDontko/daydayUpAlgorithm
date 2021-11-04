package HashTable.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * create by gaoyang on 2019/9/11
 * https://leetcode.com/problems/valid-sudoku/
 */
public class Validsudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (!set.add(board[i][j] + "r" + i) || !set.add(board[i][j] + "c" + j) || !set.add(board[i][j] + "g" + i / 3 + j / 3))
                    return false;
            }
        }
        return true;
    }
}
