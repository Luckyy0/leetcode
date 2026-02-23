# Analysis for Knight Dialer
# *Phân tích cho bài toán Quay số Mã tuần*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count distinct phone numbers of length `n` dialable by a knight on a phone pad.
*Đếm số lượng số điện thoại riêng biệt có độ dài `n` mà con mã có thể quay trên bàn phím điện thoại.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a DP problem on a graph.
- The phone pad nodes: 0, 1, 2, ..., 9.
- Edges define valid knight moves:
  - 0 -> 4, 6
  - 1 -> 6, 8
  - 2 -> 7, 9
  - 3 -> 4, 8
  - 4 -> 3, 9, 0
  - 5 -> (no moves)
  - 6 -> 1, 7, 0
  - 7 -> 2, 6
  - 8 -> 1, 3
  - 9 -> 2, 4
- Let `dp[k][d]` be the number of ways to land on digit `d` after `k` steps (length `k+1`).
- Base case: `dp[0][d] = 1` for all `d`.
- Transitions: `dp[k][d] = sum(dp[k-1][neighbor])` for all neighbors of `d`.
- Total answer for length `n`: `sum(dp[n-1][d])` for `d` in 0..9.
- Modulo arithmetic at each step.
*Đây là bài toán DP trên đồ thị. Các nút bàn phím và các cạnh di chuyển hợp lệ. `dp[k][d]` là số cách đến số `d` sau `k` bước. Chuyển trạng thái dựa trên hàng xóm. Tổng hợp kết quả và lấy dư.*

---

## 2. Strategy: Dynamic Programming
## *2. Chiến lược: Quy hoạch Động*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define Moves:** Map each digit to its possible previous positions (or next positions, graph is undirected).
    - `Map: 0->{4,6}, 1->{6,8}, ...`
    *   **Định nghĩa Di chuyển:** Ánh xạ các bước nhảy hợp lệ.*

2.  **Initialize DP:** Array `counts` of size 10, initialized to 1 (for `n=1`).
    *   **Khởi tạo DP:** Mảng `counts` kích thước 10, giá trị 1.*

3.  **Iterate:** Loop `n-1` times.
    - Create `newCounts`.
    - For each digit `i` from 0 to 9:
        - `newCounts[i] = sum(counts[neighbor]) % MOD` for all neighbors that can jump to `i`. (Or iterate neighbors `j` of `i`: `newCounts[j] += counts[i]`).
        - The direction is symmetric. Let's say `counts[i]` stores ways to end at `i`.
        - `newCounts[next_hop] += counts[current]`.
    - Update `counts = newCounts`.
    *   **Duyệt:** Lặp `n-1` lần. Cập nhật mảng đếm dựa trên các bước nhảy.*

4.  **Sum Result:** Sum all elements in `counts` modulo 10^9 + 7.
    *   **Tổng kết:** Tổng tất cả các phần tử modulo 10^9 + 7.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.Arrays;

public class Solution {
    public int knightDialer(int n) {
        if (n == 1) return 10;
        
        long MOD = 1_000_000_007;
        long[] counts = new long[10];
        Arrays.fill(counts, 1);
        
        // Define neighbors map (graph)
        int[][] jumps = {
            {4, 6},    // 0
            {6, 8},    // 1
            {7, 9},    // 2
            {4, 8},    // 3
            {0, 3, 9}, // 4
            {},        // 5
            {0, 1, 7}, // 6
            {2, 6},    // 7
            {1, 3},    // 8
            {2, 4}     // 9
        };
        
        for (int i = 1; i < n; i++) {
            long[] nextCounts = new long[10];
            for (int digit = 0; digit <= 9; digit++) {
                for (int nextDigit : jumps[digit]) {
                    nextCounts[nextDigit] = (nextCounts[nextDigit] + counts[digit]) % MOD;
                }
            }
            counts = nextCounts;
        }
        
        long total = 0;
        for (long count : counts) {
            total = (total + count) % MOD;
        }
        
        return (int) total;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. The inner loops are constant size (10 digits, max 3 jumps).
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$. Array of size 10.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Straightforward DP observing the state transitions defined by knight moves. Note `5` is isolated.
*DP trực tiếp quan sát chuyển trạng thái được xác định bởi các nước đi của mã. Lưu ý số `5` bị cô lập.*
