package stack.easy;

/**
 * @author gaoayang
 * create by gaoyang on 2020/7/20
 * 有效的括号：
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        String[] word = s.split("");
        int acount = 0;
        int bcount = 0;
        int ccount = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i].equals("(") && !word[i].equals("{") && !word[i].equals("[")) {
                acount++;
            } else if (word[i].equals(")")) {
                acount--;
            } else if (word[i].equals("{")) {
                bcount++;
            } else if (word[i].equals("}")) {
                bcount--;
            } else if (word[i].equals("[")) {
                ccount++;
            } else if (word[i].equals("[")) {
                ccount--;
            }
        }
        if (acount != 0 || bcount != 0 || ccount != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(";
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValid(s);
    }

}
