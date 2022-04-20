package DynamicProgram.easy.medium;

/**
 * @author gaoyang
 * create on 2022/3/15
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        int length = s.length();
        char[] sArray = s.toCharArray();
        int maxLength = 1;
        int begin = 0;
        //dp数组, dp[i][j]为true表示 子串s[i][j]为回文字符串
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int l = 2; l <=length ; l++) {
            for (int i = 0; i < length ; i++) {
                int j = l + i - 1;
                if (j >= length){
                    break;
                }
                if (sArray[i] != sArray[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLength){
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin , begin +maxLength);
    }


    public static void main(String[] args) {
        String  s= "babadbabad";
        LongestPalindrome longestPalindrome=  new LongestPalindrome();
        longestPalindrome.longestPalindrome(s);
    }
}
