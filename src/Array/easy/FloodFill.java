package Array.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gaoyang
 * create on 2022/2/18
 * https://leetcode-cn.com/problems/flood-fill/
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FloodFill {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int row = image.length;
        int col = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && my >= 0 && mx < row && my < col && image[mx][my] == currColor) {
                    image[x][y] = newColor;
                    queue.offer(new int[]{mx, my});
                }

            }
        }
        return image;
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, newColor, currColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int newColor, int currColor) {
        if (image[x][y] == currColor){
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && my >= 0 && mx < image.length && my < image[0].length && image[mx][my] == currColor) {
                    dfs(image, mx, my, newColor, currColor);
                }
            }
        }
    }
}
