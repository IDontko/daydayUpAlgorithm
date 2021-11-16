package String.easy;

/**
 * @author gaoyang
 * create on 2021/11/16
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    /**
     * 思路就是逐一比较
     * 直到不匹配
     * 时间复杂度O(mn)
     * 其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            char prefix = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != prefix) {
                    return strs[0].substring(0, i);
                }
            }

        }
        return strs[0];
    }


    /**
     * 自己写一个分治
     * 分治永远滴神，分治是有套路的，
     * 把大问题先分成一个个小问题。
     * 最后再合并小问题。
     *
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end){
        if (start == end){
            return strs[start];
        }else {
            int mid = (end - start)/2 + start;
            String leftCommonPrefix =  longestCommonPrefix(strs, start, mid);
            String rightCommonPrefix = longestCommonPrefix(strs, mid +1 , end);
            return commonPrefix(leftCommonPrefix, rightCommonPrefix);
        }
    }

    public String commonPrefix(String leftPrefix , String rightPrefix){
        int length = leftPrefix.length();
        for (int i = 0; i < length; i++) {
            char prefix = leftPrefix.charAt(i);
            if (i == rightPrefix.length() || rightPrefix.charAt(i) != prefix) {
                return leftPrefix.substring(0, i);
            }
        }
        return leftPrefix;
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefix2(strs);
        System.out.println(s);
    }
}
