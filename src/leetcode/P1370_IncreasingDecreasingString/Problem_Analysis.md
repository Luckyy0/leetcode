# 1370. Increasing Decreasing String / Chuỗi Tăng giảm

## Problem Description / Mô tả bài toán
String `s`. Reorder characters:
1. Smallest > last appened. Append smallest.
2. Repeat until no larger char.
3. Largest < last appended. Append largest.
4. Repeat.
Loop until empty.
Basically: A -> Z -> A -> Z (using available chars).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Bucket
Count frequency of each char (a-z).
Loop while string not full:
- Loop 0 to 25. If `count[i] > 0`, append `char(i)`, decrement count.
- Loop 25 to 0. If `count[i] > 0`, append `char(i)`, decrement count.

### Complexity / Độ phức tạp
- **Time**: O(N). Outer loop runs max 26 times? No, max frequency times. Total appends N.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Frequency Array Simulation
Calculate character frequencies. While the result length is less than input length:
- Iterate 'a' through 'z'. if count > 0, append and decrement.
- Iterate 'z' through 'a'. if count > 0, append and decrement.
Return constructed string.
Tính tần suất ký tự. Trong khi độ dài kết quả nhỏ hơn độ dài đầu vào:
- Lặp lại 'a' đến 'z'. nếu số đếm > 0, thêm và giảm.
- Lặp lại 'z' đến 'a'. nếu số đếm > 0, thêm và giảm.
Trả về chuỗi đã xây dựng.

---
