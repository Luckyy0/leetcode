# Analysis for Burst Balloons
# *Phân tích cho bài toán Nổ Bong bóng*

## 1. Problem Essence & Interval DP
## *1. Bản chất vấn đề & DP Khoảng*

### The Challenge
### *Thách thức*
Bursting order affects neighbors. A greedy approach fails because bursting a small balloon might enable adjacent large balloons to multiply.
Dependencies change dynamically.
Brute force permutations: $O(N!)$. Too slow.

### Strategy: Reverse Thinking (Last Balloon)
### *Chiến lược: Tư duy ngược (Bong bóng cuối cùng)*
Instead of picking the *first* to burst, pick the *last*.
Suppose in range `(i, j)`, we pick balloon `k` to burst **last**.
This means all balloons between `i` and `k` are already burst, and all between `k` and `j` are already burst.
So when `k` bursts, its neighbors are `i` and `j` (the boundaries).
Gain: `nums[i] * nums[k] * nums[j]`.
Subproblems:
1.  Max coins from `(i, k)` (with `k` acting as right boundary).
2.  Max coins from `(k, j)` (with `k` acting as left boundary).
Note: 'boundary' means the balloon strictly outside the range that is available when the inner ones are gone.

### DP State
### *Trạng thái DP*
`dp[i][j]` = max coins obtained from bursting all balloons strictly between index `i` and `j`.
Base case: `j == i + 1`, range empty -> 0 coins.

### Recurrence
### *Công thức truy hồi*
`dp[i][j] = max(dp[i][k] + dp[k][j] + nums[i]*nums[k]*nums[j])` for all `k` in `(i, j)`.

### Optimization
### *Tối ưu hóa*
Pad `nums` with `1` at beginning and end.
Iterate length `gap` from 2 to `n+1`.

---

## 2. Approach: Bottom-Up DP
## *2. Hướng tiếp cận: DP Từ dưới lên*

### Logic
### *Logic*
1.  Create `newNums` of size `n+2`. Copy `nums` to `1...n`. Set `0` and `n+1` to `1`.
2.  `dp[n+2][n+2]`.
3.  Loop `len` from 2 to `n+1` (gap).
    - Loop `left` from 0 to `n+1 - len`.
    - `right = left + len`.
    - Loop `k` from `left + 1` to `right - 1`.
        - `val = dp[left][k] + dp[k][right] + newNums[left] * newNums[k] * newNums[right]`.
        - `dp[left][right] = max(dp[left][right], val)`.
4.  Return `dp[0][n+1]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Independence:** Choosing the *last* balloon decouples the sub-intervals.
    *Sự độc lập: Việc chọn bong bóng *cuối cùng* tách biệt các khoảng con.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$. Three nested loops. `N` up to 300, $27 \cdot 10^6$ ops. Feasible.
    *Độ phức tạp thời gian: $O(N^3)$.*
*   **Space Complexity:** $O(N^2)$.
    *Độ phức tạp không gian: $O(N^2)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[3, 1, 5]`
Pad: `[1, 3, 1, 5, 1]` (Indices 0..4)
Len 2 (Ranges (0,2), (1,3), (2,4)):
- `(0,2)` "3": `k=1`. `0 + 0 + 1*3*1` = 3. `dp[0][2]=3`.
- `(1,3)` "1": `k=2`. `0 + 0 + 3*1*5` = 15. `dp[1][3]=15`.
- `(2,4)` "5": `k=3`. `0 + 0 + 1*5*1` = 5. `dp[2][4]=5`.
Len 3 (Ranges (0,3), (1,4)):
- `(0,3)` "3,1":
  - `k=1` (Burst 1 last): `dp[0][1] + dp[1][3] + 1*3*5` = `0 + 15 + 15` = 30.
  - `k=2` (Burst 1 last? No k is index in newNums):
  - `k=1` (Burst "3" last): `dp[0][1]+dp[1][3] + 1*3*5` = 30.
  - `k=2` (Burst "1" last): `dp[0][2]+dp[2][3] + 1*1*5` = `3 + 0 + 5` = 8.
  - Max 30. `dp[0][3] = 30`.
- `(1,4)` "1,5":
  - `k=2` ("1" last): `dp[1][2]+dp[2][4] + 3*1*1` = `0 + 5 + 3` = 8.
  - `k=3` ("5" last): `dp[1][3]+dp[3][4] + 3*5*1` = `15 + 0 + 15` = 30.
  - Max 30. `dp[1][4] = 30`.
Len 4 (Range (0,4) "3,1,5"):
- `k=1` ("3" last): `dp[0][1] + dp[1][4] + 1*3*1` = `0 + 30 + 3 = 33`.
- `k=2` ("1" last): `dp[0][2] + dp[2][4] + 1*1*1` = `3 + 5 + 1 = 9`.
- `k=3` ("5" last): `dp[0][3] + dp[3][4] + 1*5*1` = `30 + 0 + 5 = 35`.
Max 35.

Wait manual calc check `[3, 1, 5]`.
3,1,5 -> burst 1 (3*1*5=15) -> [3,5]. Burst 3 (1*3*5=15) -> [5]. Burst 5 (1*5*1=5). Total 35.
Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Interval DP with split point `k`. Key concept: `k` is the LAST element.
*DP Khoảng với điểm chia `k`. Khái niệm chính: `k` là phần tử CUỐI CÙNG.*
---
*Đôi khi người ở lại cuối cùng (last balloon) là người đóng vai trò quan trọng nhất, kết nối hai thế giới (boundaries) bị chia cắt.*
Sometimes the one who stays until the end (last balloon) plays the most important role, connecting two separated worlds (boundaries).
