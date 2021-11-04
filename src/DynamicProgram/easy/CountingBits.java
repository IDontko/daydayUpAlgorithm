package DynamicProgram.easy;

/**
 * @author gaoyang
 * create on 2021/10/28
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountingBits {
    /**
     * 低比特位算法
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    public int[] countBits2(int n){
        int[] bits = new int[n + 1];
        int highBits = 0;
        for (int i = 1; i <=n ; i++) {
            if ((i & (i-1)) == 0){
                highBits = i;
            }
            bits[i] = bits[i - highBits] + 1;

        }
        return bits;
    }
}
