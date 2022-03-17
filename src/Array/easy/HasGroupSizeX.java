package Array.easy;

/**
 * @author gaoyang
 * create on 2022/2/25
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * 输入：deck = [1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]+
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasGroupSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            count[deck[i]]++;
        }
        int length = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && length == 0) {
                length = count[i];
            }else {
                length = gcd(length, count[i]);
            }
        }
        return length >= 2;
    }
    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }


}
