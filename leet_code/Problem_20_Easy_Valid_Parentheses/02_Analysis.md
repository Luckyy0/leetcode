# Analysis for Valid Parentheses
# *Phân tích cho bài toán Ngoặc Hợp Lệ*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s`. *Chuỗi `s`.*
*   **Output:** Boolean. *Boolean.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to $10^4$. $O(N)$ is required.
    *Độ dài lên tới $10^4$. Yêu cầu $O(N)$.*
*   Stack operations are $O(1)$, so overall time complexity will be $O(N)$.
    *Các thao tác Stack là $O(1)$, nên tổng độ phức tạp thời gian sẽ là $O(N)$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Stack
### *Hướng tiếp cận: Ngăn xếp (Stack)*

*   **Intuition:** The last opened bracket must be the first one closed (LIFO). This perfectly matches a Stack data structure.
    *Ý tưởng: Dấu ngoặc mở cuối cùng phải là dấu ngoặc đóng đầu tiên (LIFO). Điều này hoàn toàn khớp với cấu trúc dữ liệu Ngăn xếp (Stack).*
*   **Algorithm Steps:**
    1.  Initialize an empty stack.
    2.  Iterate through `s`:
        *   If `char` is open `(`, `{`, `[`, push to stack.
        *   If `char` is close `)`, `}`, `]`:
            *   If stack empty, return `false`.
            *   Pop top. If top doesn't match current close (e.g. `(` matching `]`), return `false`.
    3.  After loop, if stack is empty, return `true` (all closed). Else `false`.

*   **Custom Implementation:**
    *   Since `java.util.Stack` is not allowed/preferred, implement a simple char array stack.
    *   `char[] stack = new char[s.length()]`. `top = -1`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(N)$.

### Dry Run
### *Chạy thử*
`s = "()[]{}"`
1.  `(` push. Stack: `(`.
2.  `)` pop. Match `(`. Stack empty.
3.  `[` push. Stack: `[`.
4.  `]` pop. Match `[`. Stack empty.
... Returns true.

`s = "(]"`
1.  `(` push. Stack: `(`.
2.  `]` pop `(`. Mismatch! Return false.
