# 1509. Minimum Difference Between Largest and Smallest Value in Three Moves / Sự khác biệt Tối thiểu Giữa Giá trị Lớn nhất và Nhỏ nhất trong Ba lần Di chuyển

## Problem Description / Mô tả bài toán
Array `nums`. Can change at most 3 elements.
Minimize difference between max and min.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting
If N <= 4, can make all equal -> diff 0.
Else, we essentially remove 3 elements (change them to satisfy equality with others).
We remove 3 smallest, OR 3 largest, OR 2 smallest 1 largest, etc.
Possible removals:
1. 0 smallest, 3 largest -> `new diff = nums[n-4] - nums[0]`.
2. 1 smallest, 2 largest -> `new diff = nums[n-3] - nums[1]`.
3. 2 smallest, 1 largest -> `new diff = nums[n-2] - nums[2]`.
4. 3 smallest, 0 largest -> `new diff = nums[n-1] - nums[3]`.
Return min of these.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sorting
Sort. Compare 4 scenarios.
Sắp xếp. So sánh 4 kịch bản.

---
