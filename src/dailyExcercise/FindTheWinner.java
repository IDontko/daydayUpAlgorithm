package dailyExcercise;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author gaoyang
 * create on 2022/5/4
 * https://leetcode.cn/problems/find-the-winner-of-the-circular-game/
 */
public class FindTheWinner {

    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        FindTheWinner obj = new FindTheWinner();
        obj.findTheWinner(n, k);
    }
}
