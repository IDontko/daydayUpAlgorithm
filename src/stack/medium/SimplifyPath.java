package stack.medium;


import java.util.Stack;

/**
 * @author gaoayang
 * create by gaoyang on 2020/8/14
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            if (!str[i].equals("") && !str[i].equals(".")) {
                stack.push(str[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            ans.append( "/" + stack.get(i) );
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String path = "/../";
        SimplifyPath simplifyPath = new SimplifyPath();
        simplifyPath.simplifyPath(path);
    }
}
