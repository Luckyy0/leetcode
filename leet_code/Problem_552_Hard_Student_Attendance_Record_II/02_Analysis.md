# Analysis for Student Attendance Record II
# *Phân tích cho bài toán Hồ sơ Điểm danh Học sinh II*

## 1. Problem Essence & Multi-State Counting
## *1. Bản chất vấn đề & Đếm đa trạng thái*

### The Challenge
### *Thách thức*
We need to count how many attendance strings of length $N$ are eligible for an award.
*Chúng ta cần đếm xem có bao nhiêu chuỗi điểm danh độ dài $N$ đủ điều kiện nhận giải thưởng.*

The constraints are:
*Các ràng buộc là:*
1.  Fewer than 2 'A's in total.
    * *Tổng cộng có ít hơn 2 chữ 'A'.*
2.  No 3 or more consecutive 'L's.
    * *Không có 3 chữ 'L' liên tiếp trở lên.*

With $N$ up to $10^5$, a brute-force approach (trying all $3^N$ strings) is impossible.
*Với $N$ lên đến $10^5$, phương pháp vét cạn (thử tất cả $3^N$ chuỗi) là không thể.*

---

## 2. Strategy: Dynamic Programming with State Transitions
## *2. Chiến lược: Quy hoạch động với Chuyển trạng thái*

A valid record can be categorized by two factors: how many 'A's have appeared so far (0 or 1), and how many 'L's are at the very end of the record (0, 1, or 2).
*Một hồ sơ hợp lệ có thể được phân loại theo hai yếu tố: có bao nhiêu chữ 'A' đã xuất hiện (0 hoặc 1), và có bao nhiêu chữ 'L' ở ngay cuối hồ sơ (0, 1, hoặc 2).*

### State Definition
### *Định nghĩa Trạng thái*
`dp[i][j][k]`: The number of valid records of length `i` with `j` total 'A's so far and `k` consecutive 'L's at the end.
*`dp[i][j][k]`: Số lượng hồ sơ hợp lệ độ dài `i` với tổng cộng `j` chữ 'A' đã xuất hiện và `k` chữ 'L' liên tiếp ở cuối.*
- $j \in \{0, 1\}$
- $k \in \{0, 1, 2\}$

### Transition Logic (Appending a new character)
### *Logic Chuyển trạng thái (Thêm một ký tự mới)*

For each state `(j, k)` at length `i-1`:
*Đối với mỗi trạng thái `(j, k)` ở độ dài `i-1`:*

1.  **Add 'P' (Present):**
    - The number of 'A's remains `j`.
    - *Số lượng chữ 'A' vẫn là `j`.*
    - The number of consecutive 'L's at the end becomes `0`.
    - *Số lượng chữ 'L' liên tiếp ở cuối trở thành `0`.*
    - `next_dp[j][0] += prev_dp[j][k]`

2.  **Add 'A' (Absent):**
    - Only possible if `j == 0`. The new `j` becomes `1`.
    - *Chỉ có thể nếu `j == 0`. Giá trị `j` mới trở thành `1`.*
    - The number of consecutive 'L's at the end becomes `0`.
    - *Số lượng chữ 'L' liên tiếp ở cuối trở thành `0`.*
    - `next_dp[1][0] += prev_dp[0][k]`

3.  **Add 'L' (Late):**
    - Only possible if `k < 2`. The new `k` becomes `k+1`.
    - *Chỉ có thể nếu `k < 2`. Giá trị `k` mới trở thành `k+1`.*
    - The number of 'A's remains `j`.
    - *Số lượng chữ 'A' vẫn là `j`.*
    - `next_dp[j][k+1] += prev_dp[j][k]`

---

## 3. Structural Advantages & Matrix Exponentiation
## *3. Ưu điểm Cấu trúc & Lũy thừa Ma trận*

*   **Space Optimization:** Since `dp[i]` only depends on `dp[i-1]`, we can reduce space from $O(N)$ to $O(1)$ by using only two layers: `current` and `next`.
    * **Tối ưu hóa không gian:** Vì `dp[i]` chỉ phụ thuộc vào `dp[i-1]`, chúng ta có thể giảm không gian từ $O(N)$ xuống $O(1)$ bằng cách chỉ sử dụng hai lớp: `current` (hiện tại) và `next` (tiếp theo).*
*   **Modulo Arithmetic:** All additions must be wrapped in `(A + B) % MOD` to prevent overflow and satisfy the problem requirement.
    * **Phép toán Modulo:** Tất cả các phép cộng phải được bao bọc trong `(A + B) % MOD` để ngăn chặn tràn số và đáp ứng yêu cầu của bài toán.*
*   **Advanced Scaling:** For even larger $N$ (e.g., $10^9$), this DP can be rewritten as a matrix multiplication $V_n = M \times V_{n-1}$ and solved in $O(\log N)$ using Matrix Exponentiation.
    * **Mở rộng nâng cao:** Đối với $N$ thậm chí còn lớn hơn (ví dụ: $10^9$), DP này có thể được viết lại dưới dạng nhân ma trận $V_n = M \times V_{n-1}$ và được giải trong $O(\log N)$ bằng cách sử dụng Lũy thừa ma trận.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate from 1 to $N$, and for each step, we perform a fixed number of operations (6 states).
    * **Độ phức tạp thời gian:** $O(N)$. Chúng ta lặp từ 1 đến $N$, và với mỗi bước, chúng ta thực hiện một số lượng phép tính cố định (6 trạng thái).*
*   **Space Complexity:** $O(1)$ with state compression, or $O(N)$ if storing the full history.
    * **Độ phức tạp không gian:** $O(1)$ với nén trạng thái, hoặc $O(N)$ nếu lưu trữ toàn bộ lịch sử.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**N = 1:**
- Add 'P': State (0,0) = 1 record ("P")
- Add 'A': State (1,0) = 1 record ("A")
- Add 'L': State (0,1) = 1 record ("L")
- Other states: 0.
- Total valid for N=1: 1+1+1 = 3.

**N = 2:**
- From (0,0) ["P"]: Add 'P' -> (0,0) ["PP"]; Add 'A' -> (1,0) ["PA"]; Add 'L' -> (0,1) ["PL"]
- From (1,0) ["A"]: Add 'P' -> (1,0) ["AP"]; Add 'A' -> NO; Add 'L' -> (1,1) ["AL"]
- From (0,1) ["L"]: Add 'P' -> (0,0) ["LP"]; Add 'A' -> (1,0) ["LA"]; Add 'L' -> (0,2) ["LL"]
- Sum up... and so on.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

State compression is essential to maintain a low memory footprint while solving large-scale counting problems.
*Nén trạng thái là điều cần thiết để duy trì mức sử dụng bộ nhớ thấp trong khi giải các bài toán đếm quy mô lớn.*
---
*Số lượng các khả năng (Number of valid records) tăng trưởng một cách kỳ diệu khi chiều dài (N) mở rộng. Trong sự hỗn loạn của các tổ hợp, DP giúp ta duy trì trật tự bằng cách phân loại chúng thành những trạng thái hữu hạn. Đây là bài học về việc quản lý sự phức tạp bằng cách chia nhỏ nó thành những bước chuyển tiếp có thể kiểm soát được.*
The number of possibilities (Number of valid records) grows miraculously as the length (N) expands. In the chaos of combinations, DP helps us maintain order by classifying them into finite states. This is a lesson in managing complexity by breaking it down into controllable transition steps.
