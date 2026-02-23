# Analysis for Tallest Billboard
# *Phân tích cho bài toán Bảng quảng cáo Cao nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find two disjoint subsets of `rods` with equal sum. Maximize this sum.
*Tìm hai tập hợp con rời nhau của `rods` có tổng bằng nhau. Tối đa hóa tổng này.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Let the two sets be `A` and `B`. We want `sum(A) == sum(B)`.
- Consider the states as the *difference* between the two supports. `diff = sum(A) - sum(B)`.
- We initialize `dp[0] = 0` (difference 0, max height 0). All other states `dp[diff] = -infinity`.
- For each rod `r`, we can:
  1. Add `r` to the taller support (increasing difference): `new_diff = diff + r`.
  2. Add `r` to the shorter support (decreasing difference): `new_diff = |diff - r|`.
  3. Don't use `r` at all: `new_diff = diff`.
- `dp[diff]` stores the maximum height of the *taller* support for a given difference `diff`. If we know the taller height `h` and difference `d`, the shorter height is `h - d`.
- Actually, better state definition:
  - `dp[d]` = max height of the pair of supports where difference is `d`.
  - Wait, usually `dp[d]` stores the max sum of the set that creates the positive difference `d`.
  - Let `pair = (h1, h2)` with `h1 >= h2` and `h1 - h2 = d`. We want to maximize `h1` (or `h2`, doesn't matter since `h2 = h1-d`). Let's say `dp[d]` stores max `h1`.
- Transitions for rod `r`:
  - Iterate all existing differences `d` in `dp`.
  - Case 1: Add `r` to strictly larger side -> `new_d = d + r`, new height `h1 + r`.
  - Case 2: Add `r` to smaller side.
    - If `r <= d`: difference decreases to `d - r`. Height of larger side `h1` doesn't change?
      - Original: `h1, h2`. `h1 - h2 = d`.
      - Add `r` to `h2`: `h1, h2 + r`.
      - Since `r <= d` => `h2 + r <= h1`. New diff `h1 - (h2+r) = d - r`. Max height remains `h1`.
    - If `r > d`: difference becomes `r - d`. New supports `h1, h2+r` where `h2+r > h1`.
      - New larger height is `h2 + r`. Since `h2 = h1 - d`, new height `h1 - d + r`.
  - Case 3: Do nothing.
- Constraint: `sum(rods) <= 5000`. So difference is at most 5000. Array size 5001 is sufficient.
*Đặt `dp[d]` là chiều cao lớn nhất của cột cao hơn với chênh lệch `d`. Duyệt qua từng thanh rod để cập nhật trạng thái chênh lệch.*

---

## 2. Strategy: Dynamic Programming on Difference
## *2. Chiến lược: Quy hoạch Động trên Độ chênh lệch*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `dp` map or array. `dp[0] = 0`. Others -1.
    *   **Khởi tạo:** `dp[0] = 0`.*

2.  **Iterate Rods:** For each `x` in `rods`:
    - Create `cur` copy of `dp`.
    - For each `diff, height` in `dp`:
      - **Add to taller:** `cur[diff + x] = max(cur[diff + x], height + x)`
      - **Add to shorter:**
        - `newDiff = abs(diff - x)`
        - If `diff >= x`: `newHeight = height`.
        - If `diff < x`: `newHeight = height - diff + x`.
        - Simpler formula: `newHeight = max(height, height - diff + x)`? No.
        - Let's re-verify: `h1` is max height stored. `h2 = h1 - diff`.
        - Adding to shorter means adding to `h2`. New support is `h2 + x`.
        - New max height is `max(h1, h2 + x)`.
        - `cur[abs(diff - x)] = max(..., max(h1, h2 + x))`
    - `dp = cur`.
    *   **Duyệt Rods:** Cập nhật DP.*

3.  **Result:** `dp[0]`. If `dp[0] == 0`, check if valid (it always is, empty set).
    *   **Kết quả:** `dp[0]`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int tallestBillboard(int[] rods) {
        // dp[d] = max height of the taller support with difference d
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        
        for (int r : rods) {
            Map<Integer, Integer> cur = new HashMap<>(dp);
            for (int d : dp.keySet()) {
                int h1 = dp.get(d); // taller support height
                int h2 = h1 - d;    // shorter support height
                
                // 1. Add r to the taller support
                // New diff: d + r. New taller height: h1 + r
                cur.put(d + r, Math.max(cur.getOrDefault(d + r, 0), h1 + r));
                
                // 2. Add r to the shorter support
                // New supports: h1 and h2 + r
                // New diff: abs(h1 - (h2 + r)) = abs(d - r)
                // New taller height: max(h1, h2 + r)
                int newDiff = Math.abs(d - r);
                int newH1 = Math.max(h1, h2 + r);
                cur.put(newDiff, Math.max(cur.getOrDefault(newDiff, 0), newH1));
            }
            dp = cur;
        }
        
        return dp.get(0);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot S)$ where $S$ is sum of rods (max 5000). $20 \cdot 5000 = 10^5$.
    *   **Độ phức tạp thời gian:** $O(N \cdot S)$.*
*   **Space Complexity:** $O(S)$ for DP map/array.
    *   **Độ phức tạp không gian:** $O(S)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

DP on the difference between the sum of two sets is powerful for "equal sum partition" variants where values are added/subtracted.
*DP trên độ chênh lệch giữa tổng hai tập hợp rất mạnh mẽ cho các biến thể "phân chia tổng bằng nhau".*
