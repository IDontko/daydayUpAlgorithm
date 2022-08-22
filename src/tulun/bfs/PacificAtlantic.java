package tulun.bfs;

import java.util.*;

/**
 * @author gaoyang
 * create on 2022/7/27
 */
public class PacificAtlantic {
    int[][] heights;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        //标识某一个点是否可流入太平洋
        boolean[][] pacific = new boolean[m][n];
        //标识某一个点是否可流入大西洋
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }

        }
        return result;
    }

    //深度优先搜索
    private void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        //遍历每一个方向
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && heights[nextRow][nextCol] >= heights[row][col]) {
                dfs(nextRow, nextCol, ocean);
            }
        }
    }

    //广度优先搜索
    private void bfs(int row, int col, boolean[][] ocean){
        if (ocean[row][col]){
            return;
        }
        ocean[row][col] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()){
            int[] item = queue.poll();
            for (int[] dir : dirs) {
                int nextRow = item[0] + dir[0];
                int nextCol = item[1] + dir[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && heights[nextRow][nextCol] >= heights[row][col]) {
                    bfs(nextRow, nextCol, ocean);
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

    }

}
