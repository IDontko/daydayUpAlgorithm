package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 移掉K位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 * eg :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 思考：要使得数最小，移除后使得栈顶元素小。
 *
 * @author create on 2021/6/11
 */
public class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < len; i++) {
            Character element = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > element) {
                stack.removeLast();
                k--;
            }
            stack.offerLast(element);

        }
        for (int i = 0; i < k; ++i) {
            stack.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        System.out.println(ret.toString());
        return ret.length() == 0 ? "0" : ret.toString();
    }

    public static void main(String[] args) {
        String num = "10";
        int k = 1;
        removeKdigits(num, k);

    }
}

