# Analysis for Generate Parentheses
# *Phân tích cho bài toán Tạo Dấu Ngoặc*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n` (pairs). *Số nguyên `n` (cặp).*
*   **Output:** List of strings. *Danh sách các chuỗi.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` up to 8. The number of valid parentheses is given by the Catalan number $\frac{1}{n+1}\binom{2n}{n}$. For $n=8$, it's 1430. Very small.
    *`n` lên tới 8. Số lượng dấu ngoặc hợp lệ được cho bởi số Catalan. Với $n=8$, nó là 1430. Rất nhỏ.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking
### *Hướng tiếp cận: Quay lui*

*   **Intuition:** We build the string char by char. We can add `(` if we strictly have fewer than `n` open brackets. We can add `)` if we strictly have fewer closed brackets than open brackets.
    *Ý tưởng: Chúng ta xây dựng chuỗi từng ký tự một. Chúng ta có thể thêm `(` nếu chúng ta có ít hơn `n` dấu ngoặc mở. Chúng ta có thể thêm `)` nếu chúng ta có ít dấu ngoặc đóng hơn dấu ngoặc mở.*
*   **Algorithm Steps:**
    1.  `backtrack(currentString, openCount, closeCount)`.
    2.  Base case: If `currentString.length == 2 * n`, add to result.
    3.  If `openCount < n`: `backtrack(current + "(", open + 1, close)`.
    4.  If `closeCount < openCount`: `backtrack(current + ")", open, close + 1)`.

*   **Complexity:**
    *   Time: $O(4^n / \sqrt{n})$ (Catalan Number).
    *   Space: $O(n)$ (Recursion stack).

### Dry Run
### *Chạy thử*
`n=2`.
1.  `(` (open=1, close=0)
    *   `((` (open=2, close=0)
        *   `(()` (open=2, close=1)
            *   `(())` (open=2, close=2). Done. Add "(( ))".
    *   `()` (open=1, close=1)
        *   `()( ` (open=2, close=1)
            *   `()()` (open=2, close=2). Done. Add "()()".
