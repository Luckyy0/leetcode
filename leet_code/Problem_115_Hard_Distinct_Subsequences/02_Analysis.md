# Analysis for Distinct Subsequences
# *Phân tích cho bài toán Các Chuỗi Con Phân Biệt*

## 1. Understanding the Concept
## *1. Hiểu rõ khái niệm*

### What is a Subsequence?
### *Chuỗi con là gì?*
*   A subsequence of a string is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
    *Một chuỗi con của một chuỗi là một chuỗi mới được tạo thành từ chuỗi ban đầu bằng cách xóa một số (có thể không có) các ký tự mà không làm xáo trộn vị trí tương đối của các ký tự còn lại.*
*   The goal is to count how many times string `t` can be formed as a subsequence of string `s`.
    *Mục tiêu là đếm xem chuỗi `t` có thể được tạo thành bao nhiêu lần dưới dạng một chuỗi con của chuỗi `s`.*

---

## 2. Dynamic Programming Approach
## *2. Hướng tiếp cận Quy hoạch động*

This problem has optimal substructure and overlapping subproblems, making it a perfect candidate for Dynamic Programming (DP).
*Bài toán này có cấu trúc con tối ưu và các bài toán con chồng chéo, biến nó thành một ứng viên hoàn hảo cho Quy hoạch động (DP).*

### State Definition
### *Định nghĩa trạng thái*
*   Let `dp[i][j]` be the number of distinct subsequences of `s[0...j-1]` which equals `t[0...i-1]`.
    *Gọi `dp[i][j]` là số lượng các chuỗi con phân biệt của `s[0...j-1]` mà bằng `t[0...i-1]`.*
*   The dimension of the DP table will be `(t.length + 1) x (s.length + 1)`.
    *Kích thước của bảng DP sẽ là `(t.length + 1) x (s.length + 1)`.*

### Base Cases
### *Các trường hợp cơ sở*
1.  `dp[0][j] = 1` for all `j`.
    *   If `t` is an empty string, there is exactly one way to form it from any prefix of `s` (by deleting all characters).
        *Nếu `t` là một chuỗi trống, có đúng một cách để tạo ra nó từ bất kỳ tiền tố nào của `s` (bằng cách xóa tất cả các ký tự).*
2.  `dp[i][0] = 0` for all `i > 0`.
    *   If `s` is empty but `t` is not, it's impossible to form `t`.
        *Nếu `s` trống nhưng `t` thì không, không thể tạo ra `t`.*

### Transition Formula
### *Công thức chuyển đổi*
At each position `i, j`:
*   **Case 1: `t[i-1] == s[j-1]`**
    *   We have two options:
        1.  **Use `s[j-1]`** to match `t[i-1]`. The number of ways is `dp[i-1][j-1]`.
        2.  **Ignore `s[j-1]`** even though it matches. We look for `t[0...i-1]` in the shorter prefix `s[0...j-2]`. The number of ways is `dp[i][j-1]`.
    *   Total: `dp[i][j] = dp[i-1][j-1] + dp[i][j-1]`.
*   **Case 2: `t[i-1] != s[j-1]`**
    *   We have no choice but to ignore `s[j-1]`.
    *   Total: `dp[i][j] = dp[i][j-1]`.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$, where $M$ is the length of `t` and $N$ is the length of `s`. We fill a matrix of size $(M+1) \times (N+1)$.
    *Độ phức tạp thời gian: $O(M \times N)$, trong đó $M$ là độ dài của `t` và $N$ là độ dài của `s`. Chúng ta điền vào một ma trận kích thước $(M+1) \times (N+1)$.*
*   **Space Complexity:** $O(M \times N)$ for the DP table.
    *Độ phức tạp không gian: $O(M \times N)$ cho bảng DP.*
    *   *Note:* Space can be optimized to $O(M)$ by recognizing that `dp[i][j]` only depends on the previous column or current column's previous row.
        *Lưu ý: Không gian có thể được tối ưu hóa thành $O(M)$ bằng cách nhận ra rằng `dp[i][j]` chỉ phụ thuộc vào cột trước đó hoặc hàng trước đó của cột hiện tại.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng hình ảnh*

`s = "babgbag", t = "bag"`

| | "" | b | a | b | g | b | a | g |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| **""** | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
| **b** | 0 | 1 | 1 | 2 | 2 | 3 | 3 | 3 |
| **a** | 0 | 0 | 1 | 1 | 1 | 1 | 4 | 4 |
| **g** | 0 | 0 | 0 | 0 | 1 | 1 | 1 | 5 |

Result: `dp[3][7] = 5`.
---
*Số lượng cách giải mã chuỗi con tăng dần khi chúng ta tìm thấy các ký tự khớp nhau ở các vị trí khác nhau trong chuỗi nguồn.*
The number of ways to decode subsequences increases as we find matching characters at different positions in the source string.
