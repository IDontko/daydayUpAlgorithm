package Array.medium;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];
        int startX = 0;
        int startY = 0;
        int loop = 0;
        int i, j;
        int count = 1;
        while (loop++ < n / 2) {
            for (j = startX; j < n - loop; j++) {
                result[startX][j] = count++;
            }
            for (i = startY; i < n - loop; i++) {
                result[i][j] = count++;
            }
            for (; j >= loop; j--) {
                result[i][j] = count++;
            }
            for (; i >= loop; i--) {
                result[i][j] = count++;
            }
            startX++;
            startY++;
        }
        if (n % 2 == 1) {
            result[n / 2][n / 2] = count;
        }
        return result;
    }

    /**
     * 剑指 Offer 29. 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        int i = 0, j = 0;
        int directionIndex = 0;
        boolean[][] visited = new boolean[row][col];
        while (count < result.length) {
            result[count++] = matrix[i][j];
            visited[i][j] = true;
            int nextRow = i+ directions[directionIndex][0];
            int nextCol = j+ directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            i = i + directions[directionIndex][0];
            j = j + directions[directionIndex][1];
        }
        return  result;
    }

    public static void main(String[] args) {
        new GenerateMatrix().generateMatrix(3);
    }
}
