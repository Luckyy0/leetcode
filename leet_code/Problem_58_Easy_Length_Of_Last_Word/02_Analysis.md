# Analysis for Length of Last Word
# *Phân tích cho bài toán Độ Dài Từ Cuối Cùng*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s` with spaces. *Chuỗi `s` có khoảng trắng.*
*   **Output:** Length of the trailing word. *Độ dài của từ cuối cùng.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Trailing spaces must be ignored.
*   One word guaranteed.
*   *Phải bỏ qua các khoảng trắng ở cuối.*
*   *Đảm bảo có ít nhất một từ.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Reverse Iteration
### *Hướng tiếp cận: Duyệt ngược*

*   **Intuition:** Start from the end of the string. Skip trailing spaces, then count characters until the next space or the start of the string.
*   *Ý tưởng: Bắt đầu từ cuối chuỗi. Bỏ qua các khoảng trắng ở cuối, sau đó đếm các ký tự cho đến khi gặp khoảng trắng tiếp theo hoặc bắt đầu chuỗi.*

*   **Algorithm Steps:**
    1.  Initialize `length = 0`.
    2.  `i = s.length - 1`.
    3.  Loop while `i >= 0` and `s[i] == ' '`: `i--`. (Skip trailing spaces).
    4.  Loop while `i >= 0` and `s[i] != ' '`: `length++, i--`. (Count word).
    5.  Return `length`.

*   **Complexity:**
    *   Time: $O(N)$ (one pass from the end).
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`s = "   moon  "`
1. `i = 8`. `s[8]` is ' '. `i = 7`.
2. `s[7]` is ' '. `i = 6`.
3. `s[6]` is 'n'. `length = 1, i = 5`.
4. `s[5]` is 'o'. `length = 2, i = 4`.
5. `s[4]` is 'o'. `length = 3, i = 3`.
6. `s[3]` is 'm'. `length = 4, i = 2`.
7. `s[2]` is ' '. Stop.
Result: 4.
---
This avoids `split()` and extra space allocation.
*Cách này tránh dùng `split()` và cấp phát thêm bộ nhớ.*
