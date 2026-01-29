# 781. Rabbits in Forest / Những chú Thỏ trong Rừng

## Problem Description / Mô tả bài toán
There is a forest with some number of rabbits. You ask some rabbits how many other rabbits have the same color as them. You are given an integer array `answers` where `answers[i]` is the answer of the `ith` rabbit.
Có một khu rừng với một số lượng thỏ nhất định. Bạn hỏi một số chú thỏ xem có bao nhiêu chú thỏ khác có cùng màu với chúng. Bạn được cung cấp một mảng số nguyên `answers` trong đó `answers[i]` là câu trả lời của chú thỏ thứ `i`.

Return the minimum number of rabbits that could be in the forest.
Trả về số lượng thỏ tối thiểu có thể có trong rừng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Grouping logic / Logic Nhóm
If a rabbit says `x`, it means there are `x + 1` rabbits of that same color in total.
Nếu một chú thỏ nói `x`, điều đó có nghĩa là có tổng cộng `x + 1` chú thỏ cùng màu đó.

Algorithm:
1. Count the frequency of each answer `x`.
2. For each answer `x`, how many groups of `x + 1` rabbits are needed?
   - Number of rabbits who answered `x` is `count`.
   - Each group of `x + 1` rabbits can provide at most `x + 1` answers of `x`.
   - Number of groups = `ceil(count / (x + 1))`.
   - Total rabbits for this `x` = `groups * (x + 1)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(UniqueAnswers).

---

## Analysis / Phân tích

### Approach: Frequency-based Grouping
Aggregate the answers. For a common answer value, fill as many rabbits as possible into existing groups before creating a new group of the same color.
Tổng hợp các câu trả lời. Đối với một giá trị câu trả lời chung, hãy điền càng nhiều thỏ càng tốt vào các nhóm hiện có trước khi tạo một nhóm mới cùng màu.

---
