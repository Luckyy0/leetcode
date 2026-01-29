# 828. Count Unique Characters of All Substrings of a Given String / Đếm các Ký tự Duy nhất của Tất cả các Chuỗi con của một Chuỗi cho trước

## Problem Description / Mô tả bài toán
Let `countUniqueChars(s)` be the number of unique characters in string `s`.
Gọi `countUniqueChars(s)` là số lượng các ký tự duy nhất trong chuỗi `s`.

Given a string `s`, return the sum of `countUniqueChars(t)` where `t` is every substring of `s`.
Cho một chuỗi `s`, trả về tổng của `countUniqueChars(t)` trong đó `t` là mọi chuỗi con của `s`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Contribution logic / Logic Đóng góp
Instead of iterating through every substring, we calculate the contribution of each character at index `i` to the total sum.
Thay vì lặp qua từng chuỗi con, chúng ta tính toán sự đóng góp của từng ký tự tại chỉ số `i` vào tổng chung.

A character `s[i]` is unique in a substring `s[L...R]` if and only if:
- `s[i]` is the only occurrence of that character between `L` and `R`.
- Let `prev` be the index of the previous occurrence of `s[i]`.
- Let `next` be the index of the next occurrence of `s[i]`.
- Then `s[i]` is unique for any `L` in `(prev, i]` and any `R` in `[i, next)`.

Total substrings where `s[i]` is unique: `(i - prev) * (next - i)`.
Tổng số chuỗi con mà `s[i]` là duy nhất là: `(i - prev) * (next - i)`.

Algorithm:
1. Store positions of each character in lists (e.g., `A -> [1, 5, 8]`).
2. For each list, iterate through positions and apply the formula.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Structural Contribution
Calculate for each character the range of indices where it remains the sole representative of its value. The product of the number of possible starts and the number of possible ends for such ranges gives its total contribution to the answer.
Tính toán cho mỗi ký tự phạm vi các chỉ số mà nó vẫn là đại diện duy nhất cho giá trị của nó. Tích của số lượng các điểm bắt đầu có thể và số lượng các điểm kết thúc có thể cho các phạm vi đó sẽ cho ra tổng đóng góp của nó vào câu trả lời.

---
