package leet_code.Problem_943_Hard_Find_the_Shortest_Superstring;

import java.util.Arrays;

/**
 * Problem 943: Find the Shortest Superstring
 * https://leetcode.com/problems/find-the-shortest-superstring/
 */
public class Solution {

    /**
     * Finds the shortest string that contains every string in words as a substring.
     * Strategy: Traveling Salesperson Problem (TSP) with Bitmask DP.
     * 
     * @param words Array of strings.
     * @return The shortest superstring.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bài toán này tương đương với việc tìm đường đi qua tất cả các đỉnh
     *         (TSP) sao cho tổng chi phí là nhỏ nhất.
     *         Ở đây, "chi phí" giữa từ A và từ B là phần KHÔNG chồng lấp của B khi
     *         nối vào sau A.
     *         Tối đa hóa "phần chồng lấp" (overlap) cũng tương đương với tối thiểu
     *         hóa tổng độ dài.
     *         2. B1: Tính trước ma trận `overlaps[i][j]`: độ dài hậu tố dài nhất
     *         của `words[i]` khớp với tiền tố của `words[j]`.
     *         3. B2: Quy hoạch động Bitmask:
     *         `dp[mask][i]` = độ chồng lấp tối đa khi đã sử dụng tập hợp các từ
     *         trong `mask` và kết thúc bằng từ `i`.
     *         `parent[mask][i]` = từ liền trước từ `i` trong đường đi tối ưu, dùng
     *         để truy vết.
     *         4. B3: Truy vết và xây dựng chuỗi kết quả:
     *         Sau khi điền bảng DP, tìm trạng thái cuối cùng có overlap lớn nhất.
     *         Lần ngược lại `parent` để tìm thứ tự các từ.
     *         Ghép các từ lại với nhau, bỏ qua phần chồng lấp.
     */
    public String shortestSuperstring(String[] words) {
        int n = words.length;

        // Step 1: Precompute overlaps between all pairs
        // overlaps[i][j] is the length of the longest suffix of words[i] that matches a
        // prefix of words[j]
        int[][] overlaps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int minLen = Math.min(words[i].length(), words[j].length());
                    for (int k = minLen; k > 0; k--) {
                        if (words[i].endsWith(words[j].substring(0, k))) {
                            overlaps[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }

        // Step 2: DP with Bitmask
        // dp[mask][i] store max overlap using subset mask, ending with word i
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int[] row : parent)
            Arrays.fill(row, -1);

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int bit = 0; bit < n; bit++) {
                // If word 'bit' is in the current mask
                if ((mask & (1 << bit)) > 0) {
                    int prevMask = mask ^ (1 << bit);

                    // Case 1: prevMask is 0, meaning 'bit' is the first word in the sequence
                    if (prevMask == 0) {
                        dp[mask][bit] = 0; // No previous word, so 0 overlap
                    } else {
                        // Case 2: Try all possible previous words 'prev'
                        for (int prev = 0; prev < n; prev++) {
                            if ((prevMask & (1 << prev)) > 0) {
                                int val = dp[prevMask][prev] + overlaps[prev][bit];
                                // We want to MAXIMIZE total overlap
                                if (val > dp[mask][bit]) {
                                    dp[mask][bit] = val;
                                    parent[mask][bit] = prev;
                                }
                            }
                        }
                    }
                }
            }
        }

        // Step 3: Find the last word in the best path
        int bestLast = -1;
        int maxTotalOverlap = -1;
        int fullMask = (1 << n) - 1;

        for (int i = 0; i < n; i++) {
            if (dp[fullMask][i] > maxTotalOverlap) {
                maxTotalOverlap = dp[fullMask][i];
                bestLast = i;
            }
        }

        // Step 4: Reconstruct the path
        int[] path = new int[n];
        int curr = bestLast;
        int currMask = fullMask;

        for (int i = n - 1; i >= 0; i--) {
            path[i] = curr;
            int prev = parent[currMask][curr];
            currMask ^= (1 << curr);
            curr = prev;
        }

        // Step 5: Construct the result string
        // Start with the first word fully
        StringBuilder sb = new StringBuilder(words[path[0]]);

        // Append subsequent words skipping the overlapping part
        for (int i = 1; i < n; i++) {
            int prevIdx = path[i - 1];
            int currIdx = path[i];
            int overlap = overlaps[prevIdx][currIdx];

            sb.append(words[currIdx].substring(overlap));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] w1 = { "alex", "loves", "leetcode" };
        System.out.println("Result: " + sol.shortestSuperstring(w1));
        // Expected: "alexlovesleetcode" (or similar minimal length)

        String[] w2 = { "catg", "ctaagt", "gcta", "ttca", "atgcatc" };
        System.out.println("Result: " + sol.shortestSuperstring(w2));
        // Expected: "gctaagttcatgcatc"
    }
}
