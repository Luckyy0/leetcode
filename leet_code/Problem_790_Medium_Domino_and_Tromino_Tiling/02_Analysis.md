# Analysis for Domino and Tromino Tiling
# *Phân tích cho bài toán Lát gạch Domino và Tromino*

## 1. Problem Essence & DP States
## *1. Bản chất vấn đề & Các trạng thái DP*

### The Challenge
### *Thách thức*
We need to fill a `2 x N` grid.
The last column can end in a few states (partially filled or fully filled).
*Chúng ta cần lấp đầy lưới `2 x N`. Cột cuối cùng có thể kết thúc ở một vài trạng thái (lấp một phần hoặc lấp đầy).*

### States
### *Trạng thái*
Let `dp[i]` be the number of ways to fully tile a `2 x i` board.
But we need auxiliary states for "Partial" filling (one square sticking out).
*Gọi `dp[i]` là số cách lấp đầy bảng `2 x i`. Nhưng chúng ta cần trạng thái phụ cho việc lấp "Một phần" (một ô nhô ra).*

State definition:
- `f[i]`: Fully filled up to column `i`.
- `p[i]`: Partially filled up to column `i` (one row filled at `i`, one row empty at `i`, but filled up to `i-1`).
    - Note: Due to symmetry, "top row filled" and "bottom row filled" have the same count. Let's merge them into `p[i]` (count for ONE specific protruding case, or combined? Let's use combined).
    - Let `p[i]` be the count where *exactly one* cell at col `i` is covered (and the other is empty).
*Định nghĩa trạng thái: `f[i]`: Lấp đầy hoàn toàn đến cột `i`. `p[i]`: Lấp một phần đến cột `i` (chỉ một ô ở cột `i` được lấp).*

### Transitions
### *Chuyển trạng thái*

1.  **To reach Full `f[i]`:**
    - From `f[i-1]`: Place 1 vertical domino `|`.
    - From `f[i-2]`: Place 2 horizontal dominoes `=`.
    - From `p[i-1]`: Place a Tromino `L` to fill the gap. (2 orientations: one for top gap, one for bottom gap).
      - If `p[i-1]` counts *one* type of gap (e.g. top), we need both.
      - Let's say `p[i]` represents count for "top filled". "bottom filled" is same.
      - `f[i] = f[i-1] + f[i-2] + 2 * p[i-1]` (2 times because we can fill top-gap or bottom-gap).
    *   **Để đạt Full `f[i]`:** Từ `f[i-1]` (thêm dọc). Từ `f[i-2]` (thêm 2 ngang). Từ `p[i-1]` (thêm Tromino). `f[i] = f[i-1] + f[i-2] + 2 * p[i-1]`.*

2.  **To reach Partial `p[i]` (say top filled, bottom empty):**
    - From `f[i-2]`: Place a Tromino `L` sideways. (Wait, tromino covers 2cols x 2rows - 1).
      - From `f[i-2]`: Place Tromino such that it fills `(i-1)` both rows and `i` top row? Yes.
    - From `p[i-1]` (top filled): Place horizontal domino on top row.
      - `p[i] = f[i-2] + p[i-1]`.
    *   **Để đạt Partial `p[i]`:** Từ `f[i-2]` (thêm Tromino). Từ `p[i-1]` (thêm ngang). `p[i] = f[i-2] + p[i-1]`.*

Wait, standard recurrence relation derivation:
`f[i] = f[i-1] + f[i-2] + 2*p[i-1]`
`p[i] = p[i-1] + f[i-2]`

Can we simplify?
`p[i] - p[i-1] = f[i-2]` -> `p[i-1] = f[i-3] + p[i-2]`.
`f[i] = f[i-1] + f[i-2] + 2*p[i-1]`
`f[i-1] = f[i-2] + f[i-3] + 2*p[i-2]`
`f[i] - f[i-1] = f[i-2] + 2*p[i-1] - f[i-2] - f[i-3] - 2*p[i-2]`
`f[i] - f[i-1] = 2(p[i-1] - p[i-2]) - f[i-3]`
Substitute `p[i-1] - p[i-2] = f[i-3]`:
`f[i] - f[i-1] = 2*f[i-3] - f[i-3] = f[i-3]`
`f[i] = f[i-1] + f[i-3]` ? No something wrong.

Let's stick to the base transitions:
`f[n] = f[n-1] + f[n-2] + 2*p[n-1]`
`p[n] = p[n-1] + f[n-2]`

Valid range:
`f[0] = 1` (Empty board has 1 way)
`f[1] = 1`
`f[2] = 2` (| |, = =)
`p[1] = 0` (Cannot have partial at 1 from f[-1]?)
Let's trace:
`p[2] = p[1] + f[0] = 0 + 1 = 1`. (Actually Tromino shape at 2 needs 2 cols. One filled, one empty at col 2).
`f[3] = f[2] + f[1] + 2*p[2] = 2 + 1 + 2*1 = 5`. Correct.

Simplified formula exists: `f[n] = 2*f[n-1] + f[n-3]`.
Let's verify: `f[3] = 2*f[2] + f[0] = 2*2 + 1 = 5`. Correct.
`f[4]`:
`p[3] = p[2] + f[1] = 1 + 1 = 2`.
`f[4] = f[3] + f[2] + 2*p[3] = 5 + 2 + 4 = 11`.
Formula: `2*f[3] + f[1] = 2*5 + 1 = 11`. Correct.

Formula: `f[n] = 2*f[n-1] + f[n-3]` for $n \ge 3$.
Initial: `f[0]=1, f[1]=1, f[2]=2`.

---

## 2. Strategy: DP with Formula
## *2. Chiến lược: DP với Công thức*

### Algorithm
### *Thuật toán*

1.  **Values:**
    - `f[0] = 1`
    - `f[1] = 1`
    - `f[2] = 2`
2.  **Loop:** `i` from 3 to `n`.
    - `f[i] = (2 * f[i-1] + f[i-3]) % MOD`.
3.  **Return:** `f[n]`.

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int numTilings(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    long[] dp = new long[n + 1];
    dp[0] = 1; 
    dp[1] = 1;
    dp[2] = 2;
    long MOD = 1_000_000_007;
    for (int i = 3; i <= n; i++) {
        dp[i] = (2 * dp[i-1] + dp[i-3]) % MOD;
    }
    return (int) dp[n];
}
```

Wait, need to be careful with `dp[0]=1` interpretation for `n=3`. `dp[0]` is conceptual empty -> 1 way.
Input `N` is up to 1000. Array is fine.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$. Can be $O(1)$ with variables.
    *   **Độ phức tạp không gian:** $O(N)$ hoặc $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**N = 3**
Init: `dp[0]=1, dp[1]=1, dp[2]=2`.
`dp[3] = 2*dp[2] + dp[0] = 2*2 + 1 = 5`.
Result: 5.

**N = 4**
`dp[4] = 2*dp[3] + dp[1] = 2*5 + 1 = 11`.
Result: 11.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The formula `f[n] = 2*f[n-1] + f[n-3]` is the most efficient and simple way. Just handle modulo arithmetic carefully.
*Công thức `f[n] = 2*f[n-1] + f[n-3]` là cách hiệu quả và đơn giản nhất. Chỉ cần xử lý số học modulo cẩn thận.*
