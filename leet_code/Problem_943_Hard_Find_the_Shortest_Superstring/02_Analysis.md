# Analysis for Find the Shortest Superstring
# *Phân tích cho bài toán Tìm Siêu chuỗi Ngắn nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Combine given strings into the shortest possible string such that every given string is a substring.
*Kết hợp các chuỗi đã cho thành chuỗi ngắn nhất có thể sao cho mỗi chuỗi đã cho đều là chuỗi con.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a variation of the **Traveling Salesperson Problem (TSP)**.
- We want to visit every "word" exactly once.
- The "cost" of moving from word A to word B is the length added to the superstring.
- If A overlaps B by `k` characters (suffix of A matches prefix of B), the added length is `len(B) - k`.
- Maximizing total overlap is equivalent to minimizing total length.
- Precompute overlaps between all pairs of words. `overlap[i][j]` = max length of suffix of `words[i]` matching prefix of `words[j]`.
- Use Dynamic Programming with Bitmask: `dp[mask][last]` stores the max overlap (or min length) for the subset of words represented by `mask`, ending with `words[last]`.
- Reconstruct the path to build the result string.
- Constraints: $N \le 12$. $2^{12} * 12^2$ is small enough for DP.
*Đây là biến thể của bài toán Người du lịch (TSP). Tối đa hóa tổng độ chồng lấp tương đương với tối thiểu hóa tổng độ dài. Tính toán trước độ chồng lấp giữa tất cả các cặp. Sử dụng Quy hoạch Động với Bitmask: `dp[mask][last]`.*

---

## 2. Strategy: TSP with Bitmask DP
## *2. Chiến lược: TSP với Quy hoạch Động Bitmask*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Precompute Overlaps:**
    - For every pair `i, j`, calculate `overlap[i][j]`.
    - Iterate length `k` from `min(len(i), len(j))` down to 1. Check if suffix of `i` matches prefix of `j`.
    *   **Tính trước độ chồng lấp:** Tính `overlap[i][j]` cho mọi cặp.*

2.  **Initialize DP:**
    - `dp[mask][i]` = max overlap achieved visiting subset `mask` ending at `i`.
    - `parent[mask][i]` = previous node to reconstruct path.
    - Initialize `dp` with 0.
    *   **Khởi tạo DP:** `dp[mask][i]` lưu độ chồng lấp tối đa.*

3.  **DP Transitions:**
    - Iterate `mask` from 1 to `2^n - 1`.
    - Iterate `bit` (current node) in `mask`.
    - Iterate `prev` (previous node) in `mask ^ (1 << bit)`.
    - `dp[mask][bit] = max(dp[prev_mask][prev] + overlap[prev][bit])`.
    *   **Chuyển trạng thái DP:** Cập nhật độ chồng lấp dựa trên node trước đó.*

4.  **Reconstruct Path:**
    - Find `last` node that maximizes `dp[(1<<n)-1][last]`.
    - Backtrack using `parent` array to find the order of words.
    - Concatenate words taking overlaps into account.
    *   **Tái tạo đường đi:** Tìm node cuối tối ưu, truy vết ngược để tìm thứ tự, ghép chuỗi.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] overlaps = new int[n][n];
        
        // 1. Precompute overlaps
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    for (int k = Math.min(words[i].length(), words[j].length()); k > 0; k--) {
                        if (words[i].endsWith(words[j].substring(0, k))) {
                            overlaps[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }
        
        // 2. DP initialization
        // dp[mask][i] stores the max overlap for subset mask ending with i
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int[] row : parent) Arrays.fill(row, -1);
        
        // 3. DP transitions
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int bit = 0; bit < n; bit++) {
                if ((mask & (1 << bit)) > 0) {
                    int prevMask = mask ^ (1 << bit);
                    if (prevMask == 0) continue;
                    
                    for (int prev = 0; prev < n; prev++) {
                        if ((prevMask & (1 << prev)) > 0) {
                            int val = dp[prevMask][prev] + overlaps[prev][bit];
                            if (val >= dp[mask][bit]) { // use >= to ensure updates
                                dp[mask][bit] = val;
                                parent[mask][bit] = prev;
                            }
                        }
                    }
                }
            }
        }
        
        // 4. Find the best ending word
        int mask = (1 << n) - 1;
        int last = 0;
        int maxOverlap = -1;
        
        for (int i = 0; i < n; i++) {
            if (dp[mask][i] > maxOverlap) {
                maxOverlap = dp[mask][i];
                last = i;
            }
        }
        
        // 5. Reconstruct path
        int[] path = new int[n];
        int curr = last;
        int currMask = mask;
        for (int i = n - 1; i >= 0; i--) {
            path[i] = curr;
            int prev = parent[currMask][curr];
            currMask ^= (1 << curr);
            curr = prev;
        }
        
        // 6. Build the string
        StringBuilder sb = new StringBuilder(words[path[0]]);
        for (int i = 1; i < n; i++) {
            int p = path[i - 1]; // previous word index
            int c = path[i];     // current word index
            int overlap = overlaps[p][c];
            sb.append(words[c].substring(overlap));
        }
        
        return sb.toString();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \cdot 2^N)$. $N \le 12$, so $144 \cdot 4096 \approx 6 \cdot 10^5$, very fast.
    *   **Độ phức tạp thời gian:** $O(N^2 \cdot 2^N)$.*
*   **Space Complexity:** $O(N \cdot 2^N)$ for DP table.
    *   **Độ phức tạp không gian:** $O(N \cdot 2^N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use Bitmask DP to solve the TSP variation. Remember to calculate overlaps correctly (suffix of A matching prefix of B).
*Sử dụng Bitmask DP để giải biến thể TSP. Nhớ tính toán độ chồng lấp chính xác (hậu tố của A khớp với tiền tố của B).*
