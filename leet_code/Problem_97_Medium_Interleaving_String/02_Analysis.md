# Analysis for Interleaving String
# *Phân tích cho bài toán Chuỗi Xen Kẽ*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Three strings `s1`, `s2`, and `s3`. *Ba chuỗi `s1`, `s2` và `s3`.*
*   **Output:** Boolean (is interleaving or not). *Boolean (có phải là xen kẽ hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Lengths up to 100 for `s1` and `s2`, 200 for `s3`.
*   If `s1.length + s2.length != s3.length`, return `false`.
*   *Độ dài lên tới 100 cho `s1` và `s2`, 200 cho `s3`.*
*   *Nếu `s1.length + s2.length != s3.length`, trả về `false`.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dynamic Programming (2nd Order)
### *Hướng tiếp cận: Quy Hoạch Động (Bậc 2)*

*   **Logic:**
    1.  Let `dp[i][j]` be a boolean indicating whether the prefix of `s3` of length `i+j` is an interleaving of the prefix of `s1` of length `i` and the prefix of `s2` of length `j`.
    2.  Base Case: `dp[0][0] = true` (empty strings).
    3.  First row/column: Only depends on `s1` or `s2` respectively.
    4.  General transition: `dp[i][j]` is true if:
        *   `dp[i-1][j]` is true AND `s1[i-1] == s3[i+j-1]`.
        *   OR `dp[i][j-1]` is true AND `s2[j-1] == s3[i+j-1]`.

*   **Algorithm Steps:**
    1.  If `s1.length() + s2.length() != s3.length()`, return `false`.
    2.  Initialize `dp` matrix of $(n1+1) \times (n2+1)$.
    3.  Set `dp[0][0] = true`.
    4.  Fill first row (`i=0`) and first column (`j=0`).
    5.  Iterate through the rest of the matrix and fill based on the transition rules.
    6.  Return `dp[n1][n2]`.

*   **Complexity:**
    *   Time: $O(n1 \cdot n2)$.
    *   Space: $O(n1 \cdot n2)$ (can be optimized to $O(min(n1, n2))$).

### Dry Run
### *Chạy thử*
`s1="aab", s2="axy", s3="aaxaby"`
1. `dp[0][0] = T`.
2. First row (s2): `dp[0][1] (a==a)=T`, `dp[0][2] (x==a)=F`, `dp[0][3]=F`.
3. First col (s1): `dp[1][0] (a==a)=T`, `dp[2][0] (a==a)=T`, `dp[3][0] (b==x)=F`.
...
---
*Bài toán này tương tự như bài toán Tìm chuỗi con chung dài nhất (LCS), nhưng kiểm tra tính liên tục của việc ghép chuỗi.*
This problem is similar to the Longest Common Subsequence (LCS) problem, but it checks the continuity of string concatenation.
