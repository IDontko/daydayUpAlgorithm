package DynamicProgram.easy.medium;

/**
 * @author gaoyang
 * create on 2022/4/19
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 * 输入:
 * [
 *   [1,0,1],
 *   [0,0,1],
 *   [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 *
 *
 * 返回一个数组 [r, c, size] ，其中r,c分别代表子方阵左上角的行号和列号，
 * size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-black-square-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
 /**
  * 获取每个节点的最大黑边行和列
  * mxrow[r,c]为当前点往右的最大黑边行
  * mxcol[r,c]为当前点往下的最大黑边列
  * 从右下角开始遍历得到它们, 这样能利用之前得到的结果
  * 计算最大方阵
  * 从左上角开始遍历, 针对黑节点, 找其黑边行和列的较小值, 作为size的最大值
  * 然后递减size遍历, 如果找到一个符合条件的(右顶点和下顶点的边长度>=cursize)就break
  * 注意一个优化操作是循环遍历到当前res size+1为止, 因为如果等于当前res size的话一定不满足要求了
 * */
public class MaxBlackSquareLcci {
    public int[] findSquare(int[][] mat) {
        int R = mat.length, C = mat[0].length;
        //记录当前点[r,c]到右边，能探到的黑色点的距离
        int[][] maxRow = new int[R][C];
        //记录当前点[r,c]到下边，能探到的黑色点的距离
        int[][] maxCol = new int[R][C];
        //从右下角的点开始遍历
        for (int r = R - 1; r >= 0; --r) {
            for (int c = C - 1; c >= 0; --c) {
                if (mat[r][c] == 0) {//本身是黑色点，开始计算,只有本身一个黑色点的话，边长是0
                    maxRow[r][c] = 1;
                    if (c < C - 1) maxRow[r][c] += maxRow[r][c + 1];
                    maxCol[r][c] = 1;
                    if (r < R - 1) maxCol[r][c] += maxCol[r + 1][c];
                }
            }
        }
//            PrintUtils.printMatrix(maxRow);
//            PrintUtils.printMatrix(maxCol);
        int[] res = new int[3];//结果集
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (mat[r][c] == 0) {
//                        System.out.printf("%d:%d\n", r, c);
                    //到下面和到右边所能探到的最大距离
                    int upper = Math.min(maxRow[r][c], maxCol[r][c]);
                    //小于当前结果集的边长的，没有意义
                    int bound = res[2];
                    for (int size = upper; size > bound; size--) {
                        if (maxRow[r + size - 1][c] >= size && maxCol[r][c + size - 1] >= size) {
                            res[0] = r;
                            res[1] = c;
                            res[2] = size;
                            break;//最大边结束了，break掉
                        }
                    }
                }
            }
        }
        //特判一下
        if (res[2] == 0) return new int[]{};
        return res;
    }



}
