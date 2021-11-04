package stack.easy;

import java.util.Stack;

/**
 * @author gaoayang
 * create by gaoyang on 2020/7/31
 */
public class CalPoints {

    /**
     * 暴力解法简单
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
                continue;
            }
            if (op.equals("D")) {
                stack.push(stack.peek() * 2);
                continue;
            }
            if (op.equals("+")) {
                int temp = stack.pop();
                int temp2 = stack.peek();
                stack.push(temp);
                stack.push(temp2 + temp);
                continue;
            }
            stack.push(Integer.valueOf(op));
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        String[] ops2 = {"61","-50","65","+","D","-99","-58","88","19","-11"};
        CalPoints object = new CalPoints();
        object.calPoints(ops2);
    }
}
