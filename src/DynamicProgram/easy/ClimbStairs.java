package DynamicProgram.easy;

/**
 * @author gaoyang
 * create on 2021/10/25
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 注意：给定 n 是一个正整数。
 * 思路 ：总结规律， 最后一次上台阶是 一阶。 那么多一层之后，就会有两种情况，1 阶 或者 2阶
 * 最后一次上台阶是二阶，那么多一层之后就 只有一种情况上台阶， 则1阶
 */
public class ClimbStairs {
    /**
     * 层数为 n最后一阶上台阶为1时，如果层数增加 1 ，n + 1 阶台阶最后一阶上台阶为1的个数为，
     * n阶层数 最后一阶为1的数量，加上 n阶台阶最后一阶为 2的数量
     * n + 1 阶台阶最后一阶台阶为2的个数为，最后一阶台阶为1的数量
     *
     * @param preOneCount 最后一次上台阶为1阶的方法个数
     * @param preTwoCount 最后一次上台阶为2阶的方法个数
     * @param result
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int result = 0;
        int preOneCount = 1;
        int preTwoCount = 0;
        for (int i = 1; i < n ; i++) {
            int preOneCopy = preOneCount;
            preOneCount = preOneCount + preTwoCount;
            preTwoCount = preOneCopy;
            result = preOneCount + preTwoCount;
        }
        return result;
    }

    /**
     * 我们用 f(x)f(x) 表示爬到第 xx 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
     *
     * f(x) = f(x - 1) + f(x - 2)
     * f(x)=f(x−1)+f(x−2)
     *
     * 它意味着爬到第 xx 级台阶的方案数是爬到第 x - 1x−1 级台阶的方案数和爬到第 x - 2x−2 级台阶的方案数的和。很好理解，因为每次只能爬 11 级或 22 级，所以 f(x)f(x) 只能从 f(x - 1)f(x−1) 和 f(x - 2)f(x−2) 转移过来，而这里要统计方案总数，我们就需要对这两项的贡献求和。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.climbStairs2(35);
    }
}
