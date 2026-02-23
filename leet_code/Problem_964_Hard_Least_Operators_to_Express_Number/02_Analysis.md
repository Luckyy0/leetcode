# Analysis for Least Operators to Express Number
# *Phân tích cho bài toán Toán tử Ít nhất để Biểu diễn Số*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Represent `target` as sum/diff of powers of `x`. Minimize operators.
*Biểu diễn `target` thành tổng/hiệu của các lũy thừa của `x`. Tối thiểu hóa toán tử.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Base representation: `target` can be written in base `x`. `d_k ... d_1 d_0`.
- We can achieve digit `d_i` at position `i` (value `d_i * x^i`) in two ways:
  1. Add `d_i` copies of `x^i`. Cost for each `x^i` block is usually `i` (multiplications).
  2. Subtract `(x - d_i)` copies of `x^i`, effectively adding `1 * x^{i+1}` (carry over).
- We process from least significant digit (LSD) `d_0` upwards.
- State `dp[i]`: Minimum operators to clear the suffix `target % x^(i+1)`, possibly with a carry.
- Actually, easier to track two costs at each step `i`:
  - `pos`: cost to represent `target % x^(i+1)` perfectly (remainder 0).
  - `neg`: cost to represent `x^(i+1) - (target % x^(i+1))` (overshoot by one `x^(i+1)`, remainder 0 modulo `x^(i+1)` relative to the goal).
- Recurrence:
  - Let current digit `rem = target % x`. Next target `target /= x`.
  - Cost of `x^i` block:
    - `i = 0`: `x/x` -> 2 ops.
    - `i > 0`: `x*...*x` -> `i` ops? Wait. problem asks for *operators*.
    - `x` -> 0 ops.
    - `x*x` -> 1 op.
    - `x*x*x` -> 2 ops.
    - Generally `k-1` ops for `x^k`.
    - `x/x` (1) -> 1 op.
    - But effectively we add them. So `+ x^k` costs `k` ops if we include the `+`.
    - Let's refine cost `k` for `x^k (k>=1)` and `2` for `x^0`.
  - Transitions:
    - `new_pos`:
      - Pay `rem * cost(i)` + `pos`. (Just clear `rem`).
      - Pay `(x - rem) * cost(i)` + `neg`. (Overshoot, use previous neg carry).
      - `min(rem * k + pos, (x - rem) * k + neg)`
    - `new_neg`:
      - Target is `target + 1`. Digital transitions similar.
- Actually easier logic:
  - At step `i`, digit `r`.
  - To match `r`:
    - Option 1 (No carry): Add `r * x^i`. Cost `r * cost(i)`. Remaining problem: `target / x`.
    - Option 2 (Carry): Subtract `(x-r) * x^i`. Cost `(x-r) * cost(i)`. Remaining problem: `target / x + 1`.
  - Careful with cost of `x^0` being 2.
*Duyệt từ hàng đơn vị lên. Tại mỗi bước i với số dư r, ta có thể cộng r*x^i (không nhớ) hoặc trừ (x-r)*x^i (có nhớ 1 lên hàng sau). Tính chi phí tích lũy.*

---

## 2. Strategy: Dynamic Programming
## *2. Chiến lược: Quy hoạch Động*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Cost Function:** `k` ops for `x^k` generally. Special case $k=0$ is 2.
    *   **Hàm chi phí:** $k$ hoặc 2.*

2.  **Initialize:**
    - `pos`: cost to get `target` exactly at current level.
    - `neg`: cost to get `target + x^(i+1)` (overshoot).
    - Initial `k=0`. `r = target % x`.
    - `pos = r * 2`.
    - `neg = (x - r) * 2`.
    *   **Khởi tạo:** pos và neg cho tương ứng số dư r và x-r.*

3.  **Loop:** `k` from 1 upwards, update `target /= x`.
    - `r = target % x`.
    - `next_pos = min(r * k + pos, (r + 1) * k + neg)`. (Wait, logic check below).
    - `next_neg = min((x - r) * k + pos, (x - r - 1) * k + neg)`.
    - `pos = next_pos`, `neg = next_neg`.
    *   **Vòng lặp:** Cập nhật chi phí cho các chữ số tiếp theo.*

4.  **Refined Logic:**
    - `cost(k)` is usually `k`.
    - Transition for `pos` (reaching remaining `target`):
      - Use `r` blocks: `r * k + pos`.
      - Use `(x-r)` blocks (creating carry): `(x-r) * k + neg`.
    - Transition for `neg` (reaching `target + 1`):
      - Use `r` blocks (since we want `target+1`, digit is effectively `r` if no lower carry? No).
      - Actually, `neg` state tracks cost for `(target + 1)`.
      - Let's trace standard solution.
      - `memo[i]`: cost to represent `target % x^(i+1)`.
      - Let `r` be digit.
      - `pos`: reach `r`. `neg`: reach `x-r` (i.e. `target` effectively -1 at this pos, borrowing from next).
      - Formula:
        - `n_pos = min(r * k + pos, (x - r) * k + neg)`
        - `n_neg = min((r + 1) * k + pos, (x - (r + 1)) * k + neg)`
      - Base case at `k=0`:
        - `r = target % x`.
        - `pos = r * 2`.
        - `neg = (x - r) * 2`.
      - Loop `k` stops when `target` is 0.
      - Final adjustment: `min(pos, k + neg)`. Because `neg` implies we overshot by $x^{\text{final}}$. A single $x^{\text{final}}$ costs `k` ops.
    *   **Logic chuẩn:** Cập nhật pos và neg dựa trên r và x-r.*

5.  **Return:** `pos - 1`. Why -1?
    - Problem: expressions like `x + x`. 1 op.
    - With `r` terms, we add `r` blocks. Ops = `r * cost`.
    - Actually problem asks for operators.
    - `x` (0 ops). `x + x` (1 op). `x + x + x` (2 ops).
    - So `r` terms cost `r` operations if relative to an existing sum?
    - Yes, `sum + (x^k) + ...`.
    - My cost `r * k` assumes `k` operators to MAKE `x^k` and `1` operator to ADD it?
    - `x^k` needs `k-1` muls. Plus 1 add. Total `k`. Correct.
    - Exception: First term doesn't need `+`. So result `-1`.
    *   **Trả về:** pos - 1.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        int pos = 0;
        int neg = 0;
        int k = 0;
        
        // Initial state at k=0 (units)
        // Cost to produce 1 is 2 ops (x/x)
        int r = target % x;
        pos = r * 2;
        neg = (x - r) * 2;
        target /= x;
        k = 1;
        
        while (target > 0) {
            r = target % x;
            target /= x;
            
            // Cost to produce x^k is k ops
            // Next pos:
            // 1. Clear 'r' using addition: r * k + pos
            // 2. Clear 'r' using subtraction (borrow): (x - r) * k + neg
            int n_pos = Math.min(r * k + pos, (x - r) * k + neg);
            
            // Next neg (representing target + 1 at this level):
            // 1. Reach 'r+1' using addition (since lower level sent carry? NO.
            //    neg means we want to reach (target_current_digit + 1) * x^k.
            //    It basically means we treat current digit as (r+1)? No.
            //    Let's trust the logic: neg implies we have a carry +1 coming into this position.
            //    So effectively target digit is r+1?
            //    Actually standard recurrence:
            //    n_neg = min((r + 1) * k + pos, (x - (r + 1)) * k + neg)
            int n_neg = Math.min((r + 1) * k + pos, (x - (r + 1)) * k + neg);
            
            pos = n_pos;
            neg = n_neg;
            k++;
        }
        
        // Final adjustment:
        // pos: we represented target exactly.
        // neg: we represented target + x^limit. To fix, we subtract x^limit.
        // Cost of subtracting x^limit is 'k' ops.
        // Because k is current power level.
        return Math.min(pos, k + neg) - 1;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_x(\text{target}))$.
    *   **Độ phức tạp thời gian:** $O(\log \text{target})$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

DP tracking "exact match" and "overshoot by 1" costs at each digit position is necessary due to the possibility of using subtraction.
*DP theo dõi chi phí "khớp chính xác" và "vượt quá 1" tại mỗi vị trí chữ số là cần thiết do khả năng sử dụng phép trừ.*
