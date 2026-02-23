# Analysis for Longest Valid Parentheses
# *Phân tích cho bài toán Chuỗi Ngoặc Hợp Lệ Dài Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s`. *Chuỗi `s`.*
*   **Output:** Integer `maxLen`. *Số nguyên `maxLen`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to $3 \times 10^4$.
*   $O(N)$ expected.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Stack
### *Hướng tiếp cận: Ngăn xếp (Stack)*

*   **Intuition:** Use a stack to keep track of indices of unmatched parentheses.
    *Ý tưởng: Dùng stack để theo dõi chỉ số của các dấu ngoặc chưa khớp.*
*   **Algorithm Steps:**
    1.  Push `-1` onto stack. (Base for length calculation).
    2.  Iterate `s` with index `i`.
    3.  If `s[i] == '(':` Push `i`.
    4.  If `s[i] == ')':`
        *   Pop stack.
        *   If stack is empty: Push `i`. (This `)` is a new base, as it breaks validity).
        *   If stack not empty: `len = i - stack.peek()`. Update `maxLen`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(N)$.

### Dry Run
### *Chạy thử*
`")()())"`
1.  Stack: `[-1]`. `max=0`.
2.  `i=0 (')')`. Pop `-1`. Stack empty. Push `0`. Stack: `[0]`.
3.  `i=1 ('(')`. Push `1`. Stack: `[0, 1]`.
4.  `i=2 (')')`. Pop `1`. Stack: `[0]`. `len = 2 - 0 = 2`. `max=2`.
5.  `i=3 ('(')`. Push `3`. Stack: `[0, 3]`.
6.  `i=4 (')')`. Pop `3`. Stack: `[0]`. `len = 4 - 0 = 4`. `max=4`.
7.  `i=5 (')')`. Pop `0`. Stack empty. Push `5`. Stack: `[5]`.
Result 4. Correct.
