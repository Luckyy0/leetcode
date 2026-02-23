# Analysis for Combination Sum IV
# *Phân tích cho bài toán Tổng Tổ hợp IV*

## 1. Problem Essence & Unbounded DP
## *1. Bản chất vấn đề & Quy hoạch động Không giới hạn*

### The Challenge
### *Thách thức*
Finding the number of ways to sum to `target` using numbers from `nums`. Since sequences like $(1, 2)$ and $(2, 1)$ are distinct, this is a variation of the "Change Making Problem" where order matters.

### Strategy: Linear DP
### *Chiến lược: DP Tuyến tính*
Let `dp[i]` be the number of ways to reach sum `i`.
1.  **Base Case:** `dp[0] = 1`. (There is exactly one way to get sum 0: using no numbers).
2.  **Transition:** To reach sum `i`, we can take any number $x$ from `nums` as the **last** element.
    - If $i \ge x$, then `dp[i] += dp[i - x]`.
3.  **Iteration Order:** We iterate $i$ from $1$ to $target$, and for each $i$, we iterate through all numbers in `nums`.

---

## 2. Approach: Iterative DP
## *2. Hướng tiếp cận: DP Lặp*

### Logic
### *Logic*
(See above). We build the solution for target by solving all smaller targets first.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(Target * N) Efficiency:** Linear with respect to the target value.
    *Hiệu quả O(Target * N): Tuyến tính so với giá trị mục tiêu.*
*   **Simple Transition:** The relationship `dp[i] = sum(dp[i - nums[k]])` is very clean.
    *Chuyển đổi đơn giản: Mối quan hệ tổng các bước trước đó rất sạch sẽ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(T \times N)$, where $T$ is target and $N$ is number of elements in array.
    *Độ phức tạp thời gian: $O(T \times N)$.*
*   **Space Complexity:** $O(T)$ to store the DP array.
    *Độ phức tạp không gian: $O(T)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [1, 2], target = 3`
1. `dp[0] = 1`.
2. `dp[1]`:
   - Use 1: `dp[1] += dp[0]` = 1.
3. `dp[2]`:
   - Use 1: `dp[2] += dp[1]` = 1.
   - Use 2: `dp[2] += dp[0]` = 2.
4. `dp[3]`:
   - Use 1: `dp[3] += dp[2]` = 2.
   - Use 2: `dp[3] += dp[1]` = 2 + 1 = 3.
Results: 3. (Ways: 1+1+1, 1+2, 2+1). Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterative DP ($O(T \times N)$).
*Quy hoạch động lặp ($O(T \times N)$).*
---
*Mỗi đích đến lớn lao (target) đều được xây dựng từ vô vàn những sự kết hợp của những bước đi nhỏ hơn (nums). Bằng cách thấu hiểu và cộng dồn những khả năng của quá khứ (dp[i-x]), ta có thể nhìn thấy toàn bộ bức tranh của tương lai.*
Every great destination (target) is built from countless combinations of smaller steps (nums). By understanding and accumulating the possibilities of the past (dp [i-x]), we can see the whole picture of the future.
