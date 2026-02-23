# Analysis for Jump Game II
# *Phân tích cho bài toán Trò Chơi Nhảy II*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums`. *Mảng `nums`.*
*   **Output:** Minimum jumps. *Số lần nhảy tối thiểu.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` up to $10^4$.
*   Time complexity $O(n)$ is expected.
*   The target (last index) is always reachable.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Greedy
### *Hướng tiếp cận: Tham Lam*

*   **Intuition:** We can maintain the current coverage (maximum index reachable from current jumps) and the next coverage (maximum index reachable if we take one more jump).
*   *Ý tưởng: Chúng ta có thể duy trì phạm vi hiện tại (chỉ số tối đa có thể đạt được với số lần nhảy hiện tại) và phạm vi tiếp theo (chỉ số tối đa có thể đạt được nếu chúng ta nhảy thêm một lần nữa).*

*   **Algorithm Steps:**
    1.  Initialize `jumps = 0`, `current_end = 0`, `farthest = 0`.
    2.  Iterate `i` from `0` to `n - 2` (we don't need to jump if we are already at the last index):
        *   Update `farthest = max(farthest, i + nums[i])`.
        *   If `i == current_end`:
            *   `jumps++`.
            *   `current_end = farthest`.
            *   If `current_end >= n - 1`, break.
    3.  Return `jumps`.

*   **Complexity:**
    *   Time: $O(n)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`nums = [2, 3, 1, 1, 4]`
1.  `i=0`: `farthest = 2`. `i == current_end (0)`. `jumps=1`, `current_end=2`.
2.  `i=1`: `farthest = max(2, 1+3) = 4`.
3.  `i=2`: `farthest = max(4, 2+1) = 4`. `i == current_end (2)`. `jumps=2`, `current_end=4`.
4.  `current_end >= 4`. Stop.
Result: 2.
