package stack.easy;

import java.util.Stack;

/**
 * @author gaoayang
 * create by gaoyang on 2020/7/31
 */
public class BackSpaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#'){
                ans.push(c);
            } else if (!ans.empty()){
                ans.pop();
            }
        }
        return String.valueOf(ans);
    }



    public static void main(String[] args) {
        String s = "a#c";
        String t = "b";
        BackSpaceCompare object = new BackSpaceCompare();
        object.backspaceCompare(s, t);
    }
}
