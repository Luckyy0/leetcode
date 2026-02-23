package leet_code.Problem_243_Easy_Shortest_Word_Distance;

public class Solution_OnePass {

    /**
     * Finds the shortest distance between two words.
     * Uses a single pass with two pointers tracking latest indices.
     * Time: O(N), Space: O(1).
     * 
     * Tìm khoảng cách ngắn nhất giữa hai từ.
     * Sử dụng một lần duyệt với hai con trỏ theo dõi các chỉ số mới nhất.
     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }

            // If both words have been found at least once, calculate distance
            // Nếu cả hai từ đã được tìm thấy ít nhất một lần, tính khoảng cách
            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        Solution_OnePass solution = new Solution_OnePass();

        String[] words = { "practice", "makes", "perfect", "coding", "makes" };

        // Test Case 1: coding, practice -> 3
        System.out.println("Dist 1: " + solution.shortestDistance(words, "coding", "practice"));

        // Test Case 2: makes, coding -> 1
        System.out.println("Dist 2: " + solution.shortestDistance(words, "makes", "coding"));
    }
}
