package HashTable.Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 * eg:[[0,1],[1,1]]
 * output: 1
 *  fillping no values ,1 row has all values equal
 *
 */
public class FipColumnsForMaxNumber {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] flip = new int[c];
        int ans = 0;
        for(int i =0;i<r;i++){
            int count = 0;
            for(int j = 0; j < c;j++){
                flip[j] = 1- matrix[i][j];
            }
            for(int k = 0; k < r;k++){
                if(Arrays.equals(matrix[k],matrix[i])||Arrays.equals(matrix[k],flip)){
                    count++;
                }
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("b");
        stringBuilder.append("a");
        System.out.println(stringBuilder.toString());
        int[][] matrix = {{0,1},{1,1}};
        System.out.println("测试");
    }
}
