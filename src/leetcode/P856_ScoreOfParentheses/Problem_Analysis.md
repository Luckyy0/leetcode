# 856. Score of Parentheses / Điểm số của Dấu ngoặc

## Problem Description / Mô tả bài toán
Given a balanced parentheses string `s`, return the score of the string.
Cho một chuỗi dấu ngoặc cân bằng `s`, hãy trả về điểm số của chuỗi đó.

The score is calculated as:
- `()` has score 1.
- `AB` has score `A + B`.
- `(A)` has score `2 * A`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack or Depth Tracking / Ngăn xếp hoặc Theo dõi Độ sâu
We can use a stack to keep track of the scores at each level of nesting.
Chúng ta có thể sử dụng một ngăn xếp để theo dõi điểm số ở mỗi cấp độ lồng nhau.

Algorithm (Stack):
1. Initialize a stack with a `0`.
2. For each character `c` in `s`:
   - If `c == '('`, push `0`.
   - If `c == ')'`:
     - Pop the current score `v`.
     - Update the previous level with `max(2 * v, 1)`.

Algorithm (Direct calculation):
- Each `()` contributes $2^{depth}$ to the result, where `depth` is the number of open parentheses that enclose this pair.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Depth-based Contribution
Sum the power-of-two scores for every innermost pair `()`. The value of each such pair depends strictly on its degree of nesting.
Tổng hợp điểm số lũy thừa của hai cho mỗi cặp `()` trong cùng. Giá trị của mỗi cặp như vậy phụ thuộc nghiêm ngặt vào mức độ lồng nhau của nó.

---
