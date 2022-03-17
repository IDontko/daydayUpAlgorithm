package Array.medium;

import java.util.*;

/**
 * @author gaoyang
 * create on 2022/2/21
 * https://leetcode-cn.com/problems/push-dominoes/
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 */
public class PushDominoes {
    /**
     * dfs的解法
     *
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        Deque<int[]> deque = new LinkedList<>();
        int n = dominoes.length();
        int[] ne = new int[dominoes.length()];
        StringBuilder builder = new StringBuilder(dominoes);
        for (int i = 0; i < dominoes.length(); i++) {
            char item = dominoes.charAt(i);
            if (item == '.') {
                continue;
            }
            ne[i] = 1;
            //添加一个数组，数组表示 loc ,time, dire 位置，时间，方向
            deque.add(new int[]{i, 1, item == 'L' ? -1 : 1});
        }

        //bfs
        while (!deque.isEmpty()) {
            int[] item = deque.pollFirst();
            int loc = item[0];
            int time = item[1];
            int dire = item[2];
            if (builder.charAt(loc) == '.' || (loc + dire >= n || loc + dire < 0)) {
                continue;
            }
            //首次受力
            if (ne[loc + dire] == 0) {
                deque.addLast(new int[]{loc + dire, time + 1, dire});
                ne[loc + dire] = time + 1;
                builder.setCharAt(loc + dire, dire == -1 ? 'L' : 'R');
                //多次受力
            } else if (ne[loc + dire] == time + 1) {
                builder.setCharAt(loc + dire, '.');
            }

        }
        return builder.toString();
    }

    public String pushDominoes2(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int[] g = new int[n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') continue;
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[]{i, 1, dire});
            g[i] = 1;
        }
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int loc = info[0], time = info[1], dire = info[2];
            int ne = loc + dire;
            if (cs[loc] == '.' || (ne < 0 || ne >= n)) continue;
            if (g[ne] == 0) { // 首次受力
                d.addLast(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) { // 多次受力
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);
    }


    public static void main(String[] args) {
        PushDominoes ps = new PushDominoes();
        ps.pushDominoes2("..R..");
    }
}
