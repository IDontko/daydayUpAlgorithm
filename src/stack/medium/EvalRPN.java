package stack.medium;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author gaoayang
 * create by gaoyang on 2020/8/28
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 逆波兰式
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        int result;
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int temp = 0;
                String firstVal = stack.pop();
                String secondVal = stack.pop();
                if (token.equals("+")) {
                    temp = Integer.valueOf(firstVal) + Integer.valueOf(secondVal);
                }
                if (token.equals("-")) {
                    temp = Integer.valueOf(secondVal) - Integer.valueOf(firstVal);
                }
                if (token.equals("*")) {
                    temp = Integer.valueOf(firstVal) * Integer.valueOf(secondVal);
                }
                if (token.equals("/")) {
                    temp = Integer.valueOf(secondVal) / Integer.valueOf(firstVal);
                }
                stack.push(String.valueOf(temp));
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());

    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.pop();
        list.isEmpty();
        String[] tokens = {"4","13","5","/","+"};
        EvalRPN evalRPN = new EvalRPN();
        evalRPN.evalRPN(tokens);
    }
}
