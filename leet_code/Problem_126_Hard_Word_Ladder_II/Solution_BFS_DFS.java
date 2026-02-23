package leet_code.Problem_126_Hard_Word_Ladder_II;

import java.util.*;

public class Solution_BFS_DFS {

    /**
     * Finds all shortest transformation sequences from beginWord to endWord.
     * Uses BFS to build a graph of shortest paths and DFS to extract all paths.
     * 
     * Tìm tất cả các chuỗi biến đổi ngắn nhất từ beginWord đến endWord.
     * Sử dụng BFS để xây dựng đồ thị của các đường đi ngắn nhất và DFS để trích
     * xuất tất cả các đường đi.
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return res;

        // Maps to store distance and adjacency list
        // Bản đồ để lưu trữ khoảng cách và danh sách kề
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();

        // Phase 1: BFS to find min distance and build adjacency graph
        // Giai đoạn 1: BFS để tìm khoảng cách tối thiểu và xây dựng đồ thị kề
        bfs(beginWord, endWord, dict, distance, adj);

        // Phase 2: DFS to collect all paths
        // Giai đoạn 2: DFS để thu thập tất cả các đường đi
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, distance, adj, path, res);

        return res;
    }

    private void bfs(String beginWord, String endWord, Set<String> dict,
            Map<String, Integer> distance, Map<String, List<String>> adj) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int currDist = distance.get(curr);

                List<String> neighbors = getNeighbors(curr, dict);
                for (String neighbor : neighbors) {
                    adj.computeIfAbsent(curr, k -> new ArrayList<>()).add(neighbor);

                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currDist + 1);
                        if (neighbor.equals(endWord)) {
                            found = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if (found)
                break; // Optimal found
        }
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old)
                    continue;
                chars[i] = c;
                String next = new String(chars);
                if (dict.contains(next)) {
                    neighbors.add(next);
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }

    private void dfs(String curr, String target, Map<String, Integer> distance,
            Map<String, List<String>> adj, List<String> path, List<List<String>> res) {
        if (curr.equals(target)) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (!adj.containsKey(curr))
            return;

        for (String next : adj.get(curr)) {
            // Only move to next if it's strictly the next level
            // Chỉ di chuyển đến nút tiếp theo nếu nó đúng là ở tầng tiếp theo
            if (distance.get(next) == distance.get(curr) + 1) {
                path.add(next);
                dfs(next, target, distance, adj, path, res);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Solution_BFS_DFS solution = new Solution_BFS_DFS();
        String begin = "hit";
        String end = "cog";
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println("Test Case 1: " + solution.findLadders(begin, end, list));
        // Expected: [[hit, hot, dot, dog, cog], [hit, hot, lot, log, cog]]
    }
}
