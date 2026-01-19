# 119. Pascal's Triangle II / Tam Giác Pascal II

## Problem Description / Mô tả bài toán
Given an integer `rowIndex`, return the `rowIndex`th (**0-indexed**) row of the **Pascal's triangle**.
Cho một số nguyên `rowIndex`, trả về hàng thứ `rowIndex` (**chỉ số bắt đầu từ 0**) của **tam giác Pascal**.

In **Pascal's triangle**, each number is the sum of the two numbers directly above it.
Trong **tam giác Pascal**, mỗi số là tổng của hai số ngay phía trên nó.

### Example 1:
```text
Input: rowIndex = 3
Output: [1,3,3,1]
```

### Example 2:
```text
Input: rowIndex = 0
Output: [1]
```

### Example 3:
```text
Input: rowIndex = 1
Output: [1,1]
```

## Constraints / Ràng buộc
- `0 <= rowIndex <= 33`

**Follow up**: Could you optimize your algorithm to use only O(rowIndex) extra space?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Difference from Problem 118 / Khác biệt với Bài toán 118

| Problem | Output | Space Requirement |
|---------|--------|-------------------|
| **118** | All rows 0 to n-1 | O(n²) |
| **119** | Only row at index | **O(n)** challenge |

### In-Place Row Update / Cập nhật Hàng Tại Chỗ
Instead of storing all rows, we can update a single row in-place:
Thay vì lưu trữ tất cả các hàng, chúng ta có thể cập nhật một hàng duy nhất tại chỗ:

**Key Insight / Điểm quan trọng**: Update from **right to left** to avoid overwriting values we still need.
Cập nhật từ **phải sang trái** để tránh ghi đè các giá trị chúng ta vẫn cần.

```
Row 0: [1]
Row 1: [1, 1]
Row 2: [1, 2, 1]     <- Update: row[j] = row[j-1] + row[j]
Row 3: [1, 3, 3, 1]  <- Must go right to left!

Why right to left?
[1, 2, 1] -> building row 3
j=2: row[2] = row[1] + row[2] = 2 + 1 = 3 -> [1, 2, 3]
j=1: row[1] = row[0] + row[1] = 1 + 2 = 3 -> [1, 3, 3]
Add 1 at end -> [1, 3, 3, 1]
```

### Mathematical Formula Alternative / Công thức Toán học Thay thế
Row `n`, position `k`: `C(n, k) = C(n, k-1) × (n-k+1) / k`.
This allows computing each element from the previous one without storing the previous row.

---

## Analysis / Phân tích

### Approach: In-Place Update (Right to Left) / Cập nhật Tại chỗ (Phải sang Trái)

**Algorithm**:
```
row = [1]
for i = 1 to rowIndex:
    row.add(1)  // Add space for new element
    for j = i - 1 down to 1:  // Update from right to left
        row[j] = row[j-1] + row[j]
return row
```

### Complexity / Độ phức tạp
- **Time**: O(rowIndex²).
- **Space**: O(rowIndex) - only one row stored.

---

## Edge Cases / Các trường hợp biên
1.  **rowIndex = 0**: `[1]`.
2.  **rowIndex = 1**: `[1, 1]`.
