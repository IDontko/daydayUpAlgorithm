package matrix.easy;

/**
 * @author gaoyang
 * create on 2021/12/9
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    result += 4;
                    //看看左边有没有相邻陆地
                    if (j > 0 && grid[i][j-1] == 1){
                            result -= 1;
                    }
                    //看看右边有没有相邻陆地
                    if (j < col - 1 && grid[i][j + 1] == 1){
                        result -= 1;
                    }
                    //看看上边有没有相邻陆地
                    if (i > 0 && grid[i - 1][j] == 1){
                        result -= 1;
                    }
                    //看看下边有没有相邻陆地
                    if (i < row - 1 && grid[i + 1][j] == 1){
                        result -= 1;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        IslandPerimeter is = new  IslandPerimeter();
        is.islandPerimeter(grid);

     }
}
