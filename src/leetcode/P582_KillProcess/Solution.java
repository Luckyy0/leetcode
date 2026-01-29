package leetcode.P582_KillProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Build adjacency list (Parent -> Children)
        // Xây dựng danh sách kề (Cha -> Con)
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }

        // Output list
        // Danh sách đầu ra
        List<Integer> killed = new ArrayList<>();

        // BFS to find all descendants
        // BFS để tìm tất cả các con cháu
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            killed.add(current);

            if (tree.containsKey(current)) {
                queue.addAll(tree.get(current));
            }
        }

        return killed;
    }
}
