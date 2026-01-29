# 1133. Largest Unique Number / Số Duy nhất Lớn nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the largest integer that only occurs once. If no integer occurs once, return -1.
Cho một mảng số nguyên `nums`, hãy trả về số nguyên lớn nhất chỉ xuất hiện một lần. Nếu không có số nguyên nào xuất hiện một lần, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Counting / Đếm Tần suất
1. Count frequencies.
2. Iterate keys descending.
3. First key with count 1 is answer.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---
