package DynamicProgram.medium;

import java.util.*;

/**
 * @author gaoyang
 * create on 2022/4/20
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParetheses {
    public List<String> generateParenthesis(int n) {
        Set<String> ans = new HashSet<>();
        Stack<Set<String>> stack = new Stack<>();
        ans.add("()");
        if (n == 1) {
            return new ArrayList<>(ans);
        }
        stack.push(ans);
        for (int i = 2; i <= n; i++) {
            Set<String> prev = stack.pop();
            Set<String> set = new HashSet<>();
            for (String ele : prev) {
                for (int j = 0; j < ele.length() - 1; j++) {
                    if (ele.charAt(j) == '(') {
                        String newEle = ele.substring(0, j) +"(()" + ele.substring(j + 1);
                        set.add(newEle);
                    }
                }
                StringBuilder last = new StringBuilder("()");
                for (int k = 1; k < i ; k++) {
                    last.append("()");
                }
                set.add(last.toString());
            }
            stack.push(set);
        }
        return new ArrayList<>(stack.pop());
    }

    public static void main(String[] args) {
        new GenerateParetheses().generateParenthesis(3);
    }


}
