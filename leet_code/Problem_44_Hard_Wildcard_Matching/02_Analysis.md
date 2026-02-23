# Analysis for Wildcard Matching
# *Phân tích cho bài toán Khớp Chuỗi Ký Tự Đại Diện*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s`, pattern `p`. *Chuỗi `s`, mẫu `p`.*
*   **Output:** Boolean (match or not). *Boolean (khớp hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Lengths up to 2000. $O(N \cdot M)$ is required.
*   Difference from Regular Expression Matching: `*` in Wildcard matches any sequence, whereas in Regex it modifiers the preceding character.
*   *Sự khác biệt so với Khớp biểu thức chính quy: `*` trong Wildcard khớp với bất kỳ chuỗi nào, trong khi trong Regex nó sửa đổi ký tự đứng trước.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming
### *Hướng tiếp cận: Quy Hoạch Động*

*   **Intuition:** Define `dp[i][j]` as whether `s[0...i-1]` matches `p[0...j-1]`.
*   *Ý tưởng: Định nghĩa `dp[i][j]` là liệu `s[0...i-1]` có khớp với `p[0...j-1]` hay không.*

*   **Algorithm Steps:**
    1.  Initialize `dp[s.length + 1][p.length + 1]`.
    2.  `dp[0][0] = true` (empty string matches empty pattern).
    3.  Init first row: `dp[0][j] = dp[0][j-1]` if `p[j-1] == '*'`.
    4.  Iterate `i` from 1 to `s.length` and `j` from 1 to `p.length`:
        *   If `p[j-1] == '?'` or `p[j-1] == s[i-1]`: `dp[i][j] = dp[i-1][j-1]`.
        *   Else if `p[j-1] == '*'`: `dp[i][j] = dp[i-1][j] || dp[i][j-1]`.
            *   `dp[i-1][j]` means `*` matches at least one character.
            *   `dp[i][j-1]` means `*` matches empty sequence.
    5.  Return `dp[s.length][p.length]`.

*   **Complexity:**
    *   Time: $O(N \cdot M)$.
    *   Space: $O(N \cdot M)$ (can be optimized to $O(M)$).

### Dry Run
### *Chạy thử*
`s = "cb", p = "?a"`
1.  `dp[0][0] = true`.
2.  `dp[1][1]`: `p[0] = '?'`. `dp[1][1] = dp[0][0] = true`.
3.  `dp[2][2]`: `p[1] = 'a'`, `s[1] = 'b'`. mismatch. `dp[2][2] = false`.
Result: `false`.
