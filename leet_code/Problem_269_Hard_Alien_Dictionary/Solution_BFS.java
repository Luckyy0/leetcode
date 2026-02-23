package leet_code.Problem_269_Hard_Alien_Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution_BFS {

    /**
     * Finds the alien language order.
     * Uses Topological Sort (Kahn's Algorithm).
     * Time: O(C), Space: O(1) (26 chars max).
     * 
     * Tìm thứ tự ngôn ngữ người ngoài hành tinh.
     * Sử dụng Sắp xếp Topo (Thuật toán Kahn).
     */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize graph for all unique characters
        // Khởi tạo đồ thị cho tất cả các ký tự duy nhất
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Build graph by comparing adjacent words
        // Xây dựng đồ thị bằng cách so sánh các từ liền kề
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Check for prefix case: "abc" before "ab" is invalid
            // Kiểm tra trường hợp tiền tố: "abc" trước "ab" là không hợp lệ
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    // Only the first mismatch matters
                    // Chỉ sự khác biệt đầu tiên mới quan trọng
                    break;
                }
            }
        }

        // BFS (Kahn's Algorithm)
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (Character c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char u = queue.poll();
            sb.append(u);

            for (char v : adj.get(u)) {
                inDegree.put(v, inDegree.get(v) - 1);
                if (inDegree.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        // If result length is less than total unique chars, there was a cycle
        // Nếu độ dài kết quả nhỏ hơn tổng số ký tự, đã có chu trình
        if (sb.length() < inDegree.size()) {
            return "";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: ["wrt","wrf","er","ett","rftt"] -> "wertf"
        String[] w1 = { "wrt", "wrf", "er", "ett", "rftt" };
        System.out.println("Order 1: " + solution.alienOrder(w1));

        // Test Case 2: ["z","x"] -> "zx"
        String[] w2 = { "z", "x" };
        System.out.println("Order 2: " + solution.alienOrder(w2));

        // Test Case 3: ["z","x","z"] -> ""
        String[] w3 = { "z", "x", "z" };
        System.out.println("Order 3: " + solution.alienOrder(w3));
    }
}
