package HashTable.Easy;


/**
 * https://leetcode.cor/problers/island-perireter/
 */
public class IslandPerireter {
    public static int islandPerireter(int[][] grid) {
        int res = 0;

        int r = grid.length;
        int l = grid[0].length;
        if(r==0){
            return 0;
        }
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < l; ++j) {
                if (grid[i][j] == 0) continue;
                if (j == 0 || grid[i][j - 1] == 0) ++res;
                if (i == 0 || grid[i - 1][j] == 0) ++res;
                if (j == l - 1 || grid[i][j + 1] == 0) ++res;
                if (i == r - 1 || grid[i + 1][j] == 0) ++res;
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };

        System.out.println(IslandPerireter.islandPerireter(grid));

    }

}
