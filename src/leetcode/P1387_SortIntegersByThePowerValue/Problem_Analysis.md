# 1387. Sort Integers by The Power Value / Sắp xếp Các Số nguyên theo Giá trị Lũy thừa

## Problem Description / Mô tả bài toán
Power value of x: steps to reach 1 (Collatz conjecture).
Return k-th integer in `[lo, hi]` sorted by power value.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Memoization / Recursion
Calculate power for each number. Store in a list of pairs `(power, value)`.
Sort list. Return k-th.
Use memoization to speed up power calculation.

### Complexity / Độ phức tạp
- **Time**: O((hi - lo) * log(Val)).
- **Space**: O(hi - lo).

---

## Analysis / Phân tích

### Approach: Compute and Sort
Create a helper function `getPower(x)` with memoization. Iterate from `lo` to `hi`, calculate power for each, store in list. Sort the list first by power, then by value. Return the k-th element (0-indexed or 1-indexed? "k-th integer", typically 1-based, index k-1).
Tạo một hàm trợ giúp `getPower(x)` với ghi nhớ. Lặp lại từ `lo` đến `hi`, tính lũy thừa cho mỗi số, lưu trữ trong danh sách. Sắp xếp danh sách trước tiên theo lũy thừa, sau đó theo giá trị. Trả về phần tử thứ k.

---
