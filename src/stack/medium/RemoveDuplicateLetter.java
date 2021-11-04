package stack.medium;

import java.util.Stack;

/**
 * @author create by  on 2021/6/10
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetter {
    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            //当前栈中有该值说明不可替换。不打乱字符的相对位置
            if (visited[charArray[i] - 'a']) {
                continue;
            }
            //当栈不为空，并且栈顶元素的字典顺序大于遍历到元素的顺序, 并且 栈顶元素的lastIndex > i 。(比如 abaca
            // ,lastIndex  = [4,1,3],表示每个元素出现的最后的位置下标)。 说明栈顶元素可以被替换。
            while (!stack.isEmpty() && stack.peek() > charArray[i] && lastIndex[stack.peek() - 'a'] > i) {
                Character top = stack.pop();
                visited[top - 'a']  = false;
            }
            stack.push(charArray[i]);
            visited[charArray[i]-'a'] = true;
        }
        StringBuilder result = new StringBuilder();
        for(char c : stack){
            result.append(c);
        }
        System.out.println(result.toString());
        return result.toString();

    }

    public static void main(String[] args) {
//     expectResult  "acdb"

        String s = "cbacdcbc";
        removeDuplicateLetters(s);

    }

}
