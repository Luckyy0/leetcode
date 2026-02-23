# Analysis for Regular Expression Matching
# *Phân tích cho bài toán Khớp Biểu Thức Chính Quy*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s` (text), `p` (pattern). *Chuỗi `s` (văn bản), `p` (mẫu).*
*   **Output:** Boolean. *Kiểu Boolean.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   $N, M \le 20$ (Very small). Recursion would work, but DP is safer and standard for this "Hard" problem.
    *$N, M \le 20$ (Rất nhỏ). Đệ quy sẽ hoạt động, nhưng Quy hoạch động (DP) an toàn hơn và là chuẩn cho bài toán "Khó" này.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming (Bottom-Up)
### *Hướng tiếp cận: Quy hoạch động (Từ dưới lên)*

*   **State:** `dp[i][j]` is `true` if `s[0...i-1]` matches `p[0...j-1]`.
    *Trạng thái: `dp[i][j]` là `true` nếu `s[0...i-1]` khớp với `p[0...j-1]`.*
    *   `dp` size is `(s.length + 1) x (p.length + 1)`.

*   **Initialization:**
    *   `dp[0][0] = true` (Empty string matches empty pattern).
        *`dp[0][0] = true` (Chuỗi rỗng khớp với mẫu rỗng).*
    *   Handle patterns like `a*`, `a*b*`, etc., that can match empty string.
        *Xử lý các mẫu như `a*`, `a*b*`, v.v., có thể khớp với chuỗi rỗng.*
        *   If `p[j-1] == '*'`, `dp[0][j] = dp[0][j-2]`.

*   **Transitions:**
    *   Iterate `i` from 1 to `N`, `j` from 1 to `M`.
    *   **Case 1:** `p[j-1] == s[i-1]` OR `p[j-1] == '.'`:
        *   It's a direct match. `dp[i][j] = dp[i-1][j-1]`.
    *   **Case 2:** `p[j-1] == '*'`:
        *   The char before star is `p[j-2]`.
        *   **Option A (Zero occurrences):** Ignore `char*`. `dp[i][j] = dp[i][j-2]`.
        *   **Option B (One or more occurrences):** match `s[i-1]` with `p[j-2]`.
            *   If `p[j-2] == s[i-1]` OR `p[j-2] == '.'`:
            *   `dp[i][j] = dp[i][j] (from Option A) || dp[i-1][j]`.
            *   (Explanation: `dp[i-1][j]` means `s` without current char matched `p`, so we consume one char of `s`).

*   **Complexity:**
    *   Time: $O(N \times M)$.
    *   Space: $O(N \times M)$.

### Dry Run
### *Chạy thử*
`s = "aa"`, `p = "a*"`
`dp` size 3x3.
1.  `dp[0][0] = T`.
2.  `j=1 ('a')`: `dp[0][1] = F`.
3.  `j=2 ('*')`: `dp[0][2] = dp[0][0] = T` ("a*" matches "").
4.  `i=1 ('a')`:
    *   `j=1 ('a')`: Match. `dp[1][1] = dp[0][0] = T`.
    *   `j=2 ('*')`: `p[0]='a'==s[0]='a'`. `dp[1][2] = dp[1][0] (F) || dp[0][2] (T) = T`.
5.  `i=2 ('a')`:
    *   `j=1 ('a')`: No match (prev chars). `dp[2][1] = F`.
    *   `j=2 ('*')`: `p[0]='a'==s[1]='a'`. `dp[2][2] = dp[2][0] (F) || dp[1][2] (T) = T`.
Result: `dp[2][2] = true`.
