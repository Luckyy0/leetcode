package leet_code.Problem_245_Medium_Shortest_Word_Distance_III;

public class Solution_OnePass {

    /**
     * Finds the shortest distance between two words (which might be the same).
     * Uses a single pass.
     * Time: O(N), Space: O(1).
     * 
     * Tìm khoảng cách ngắn nhất giữa hai từ (có thể giống nhau).
     * Sử dụng một lần duyệt.
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        boolean sameWord = word1.equals(word2);

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                // If words are same, index1 stores the PREVIOUS occurrence
                // before we update it to current 'i'.
                // Nếu từ giống nhau, index1 lưu lần xuất hiện TRƯỚC ĐÓ
                // trước khi ta cập nhật nó thành 'i' hiện tại.
                if (sameWord) {
                    if (index1 != -1) {
                        minDistance = Math.min(minDistance, i - index1);
                    }
                    index1 = i;
                } else {
                    index1 = i;
                }
            } else if (wordsDict[i].equals(word2)) {
                // Only enters here if word1 != word2
                // Chỉ vào đây nếu word1 != word2
                index2 = i;
            }

            // Standard distance update for distinct words
            // Cập nhật khoảng cách tiêu chuẩn cho các từ khác nhau
            if (!sameWord && index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        Solution_OnePass solution = new Solution_OnePass();
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };

        // Test Case 1: makes, coding -> 1
        System.out.println("Dist 1: " + solution.shortestWordDistance(words, "makes", "coding"));

        // Test Case 2: makes, makes -> 3
        System.out.println("Dist 2: " + solution.shortestWordDistance(words, "makes", "makes"));
    }
}
