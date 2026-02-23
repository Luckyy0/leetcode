# Analysis for Scramble String
# *Phân tích cho bài toán Chuỗi Xáo Trộn*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two strings `s1` and `s2`. *Hai chuỗi `s1` và `s2`.*
*   **Output:** Boolean (is scrambled or not). *Boolean (có phải chuỗi xáo trộn hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 30.
*   Strings consist of lowercase English letters.
*   Recursive structure: swap or stay.
*   *Độ dài lên đến 30.*
*   *Chuỗi gồm các chữ cái tiếng Anh viết thường.*
*   *Cấu trúc đệ quy: tráo đổi hoặc giữ nguyên.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Recursive with Memoization (DP)
### *Hướng tiếp cận: Đệ quy với Ghi nhớ (DP)*

*   **Logic:**
    1.  Base cases:
        *   If `s1.equals(s2)`, return `true`.
        *   If the character frequencies don't match, return `false`.
    2.  For a given pair of strings of length `n`, try splitting at every possible index `i` from `1` to `n-1`.
    3.  Two possibilities for each split:
        *   **Case 1: No swap.** Compare `s1(0, i)` with `s2(0, i)` AND `s1(i, n)` with `s2(i, n)`.
        *   **Case 2: Swap.** Compare `s1(0, i)` with `s2(n-i, n)` AND `s1(i, n)` with `s2(0, n-i)`.
    4.  If either case is true for any `i`, then `s2` is a scramble of `s1`.
    5.  Use a `Map` or a 3D array for memoization to store results of previously computed subproblems.

*   **Algorithm Steps:**
    1.  Create a memoization map `memo`.
    2.  Define `isScramble(s1, s2)`:
        *   If `memo` contains key `s1 + "," + s2`, return its value.
        *   Check base cases (equals, frequency check).
        *   Loop `i` from `1` to `len - 1`:
            *   Check "No swap" condition.
            *   Check "Swap" condition.
            *   If either true, store `true` in `memo` and return.
        *   Store `false` in `memo` and return.

*   **Complexity:**
    *   Time: $O(n^4)$ or $O(n^3)$ with optimized memoization.
    *   Space: $O(n^4)$ or $O(n^3)$.

### Dry Run
### *Chạy thử*
`s1 = "great", s2 = "rgeat"`
1. Split `s1` into "gr" and "eat".
2. Try Case 1 (No swap): `isScramble("gr", "rg")` and `isScramble("eat", "eat")`.
3. `isScramble("eat", "eat")` is true.
4. `isScramble("gr", "rg")`: Split into "g" and "r".
5. Case 2 (Swap): `isScramble("g", "g")` and `isScramble("r", "r")`. Both true.
6. So `isScramble("gr", "rg")` is true.
Result: `true`.
---
*Việc kiểm tra tần suất ký tự là một bước tối ưu hóa quan trọng để cắt bỏ các nhánh đệ quy vô ích.*
Character frequency check is a crucial optimization to prune useless recursion branches.
