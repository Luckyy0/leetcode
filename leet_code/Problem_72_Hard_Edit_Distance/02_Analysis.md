# Analysis for Edit Distance
# *Phân tích cho bài toán Khoảng Cách Chỉnh Sửa*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two strings `word1`, `word2`. *Hai chuỗi `word1`, `word2`.*
*   **Output:** Minimum operations count. *Số lượng thao tác tối thiểu.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 500. $O(N \cdot M)$ complexity is acceptable.
*   Operations: Insert, Delete, Replace. All have cost 1.
*   *Độ dài lên tới 500. Độ phức tạp $O(N \cdot M)$ là chấp nhận được.*
*   *Thao tác: Chèn, Xóa, Thay thế. Tất cả đều có chi phí là 1.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming
### *Hướng tiếp cận: Quy Hoạch Động*

*   **Intuition:** Define `dp[i][j]` as the minimum operations to convert `word1[0...i-1]` to `word2[0...j-1]`.
*   *Ý tưởng: Định nghĩa `dp[i][j]` là số thao tác tối thiểu để chuyển đổi `word1[0...i-1]` thành `word2[0...j-1]`.*

*   **Algorithm Steps:**
    1.  Base cases: 
        *   `dp[0][j] = j` (Convert empty string to `word2[0...j-1]` requires `j` insertions).
        *   `dp[i][0] = i` (Convert `word1[0...i-1]` to empty string requires `i` deletions).
    2.  Transitions:
        *   If `word1[i-1] == word2[j-1]`: `dp[i][j] = dp[i-1][j-1]` (No operation needed).
        *   Else: `dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])`.
            *   `dp[i-1][j-1]`: Replace.
            *   `dp[i-1][j]`: Delete.
            *   `dp[i][j-1]`: Insert.
    3.  Return `dp[word1.length][word2.length]`.

*   **Complexity:**
    *   Time: $O(N \cdot M)$.
    *   Space: $O(N \cdot M)$.

### Dry Run
### *Chạy thử*
`word1 = "ros", word2 = "horse"`
- Base cases fill.
- `r` vs `h`: `1 + min(dp[0][0], dp[0][1], dp[1][0])` = `1 + min(0, 1, 1) = 1`.
- ... and so on.
---
*Quy hoạch động giúp giải quyết bài toán này một cách chính xác bằng cách xây dựng dựa trên các bài toán con.*
Dynamic Programming solves this problem accurately by building on top of subproblems.
