package dailyExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyang
 * create on 2021/8/5
 * https://leetcode-cn.com/problems/find-eventual-safe-states/
 * <p>
 * 输入 : graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上
 * <p>
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 */
public class EventualSafeNodes805 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<Integer>();//记录结果
        int n = graph.length;//长度
        int[] type = new int[n];//访问类型
        for (int i = 0; i < n; i++) {
            if (DFS(graph, i, type) == 2) ans.add(i);
        }
        return ans;
    }

    // type 节点状态  0 初始未访问 1标记访问  2 安全 3 成环
    public static int DFS(int[][] graph, int index, int[] type) {
        if (type[index] == 1) return 3;//如果访问过了，说明成环
        if (type[index] != 0) return type[index];    //如果不是0，返回自身
        type[index] = 1;//标记访问了
        for (int i : graph[index]) {
            if (DFS(graph, i, type) == 3) {
                type[i] = 3;
                return 3;
            }
        }

        type[index] = 2;//不成环
        return 2;
    }

    public static void main(String[] args) {
        int[][] graph  = new int[7][2];
        graph[0] = new int[]{1, 2};
        graph[1] = new int[]{2, 3};
        graph[2] = new int[]{5};
        graph[3] = new int[]{0};
        graph[4] = new int[]{5};
        graph[5] = new int[]{};
        graph[6] = new int[]{};
        EventualSafeNodes805 safeNodes805 = new EventualSafeNodes805();
        List<Integer> result = safeNodes805.eventualSafeNodes(graph);
        result.stream().forEach(item -> System.out.println(item));

    }
}
