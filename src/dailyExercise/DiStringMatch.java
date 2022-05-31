package dailyExercise;

/**
 * @author gaoyang
 * create on 2022/5/9
 * https://leetcode.cn/problems/di-string-match/
 */
public class DiStringMatch {
    public int[] diStringMatch(String s) {
        s = s + "C";
        int[] ans = new int[s.length()];
        int start = 0;
        int end = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I'){
                ans[i] = start++;
            }else if (c=='D'){
                ans[i] = end--;
            }else {
                ans[i] = start;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new DiStringMatch().diStringMatch("III");
    }
}
