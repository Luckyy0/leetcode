package leet_code.Problem_127_Hard_Word_Ladder;

import java.util.*;

public class Solution_BFS {

    /**
     * Finds the length of the shortest transformation sequence from beginWord to
     * endWord.
     * Uses Breadth-First Search (BFS) to find the shortest path in an unweighted
     * graph.
     * 
     * Tìm độ dài của chuỗi biến đổi ngắn nhất từ beginWord đến endWord.
     * Sử dụng Tìm kiếm theo chiều rộng (BFS) để tìm đường đi ngắn nhất trong đồ thị
     * không trọng số.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Use a set for O(1) lookups
        // Sử dụng một tập hợp để tra cứu với thời gian O(1)
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process all words in the current level
            // Xử lý tất cả các từ ở tầng hiện tại
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                // If we reached the end word, return current level
                // Nếu chúng ta đã đạt đến từ kết thúc, hãy trả về tầng hiện tại
                if (curr.equals(endWord)) {
                    return level;
                }

                // Generate all possible next words by changing one character at a time
                // Tạo ra tất cả các từ tiếp theo có thể bằng cách thay đổi từng ký tự một
                char[] chars = curr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == temp)
                            continue;
                        chars[j] = c;
                        String next = new String(chars);

                        if (dict.contains(next)) {
                            queue.add(next);
                            // Remove the word from the dictionary once visited to prevent reuse
                            // Xóa từ khỏi từ điển sau khi đã truy cập để ngăn chặn việc sử dụng lại
                            dict.remove(next);
                        }
                    }
                    chars[j] = temp; // Restore original character
                }
            }
            level++;
        }

        return 0; // No path found
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Test Case 1: "hit" -> "cog"
        List<String> list1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Test Case 1 Length: " + solution.ladderLength("hit", "cog", list1));
        // Expected: 5

        // Test Case 2: "hit" -> "cog" (missing "cog" in list)
        List<String> list2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("Test Case 2 Length: " + solution.ladderLength("hit", "cog", list2));
        // Expected: 0
    }
}
