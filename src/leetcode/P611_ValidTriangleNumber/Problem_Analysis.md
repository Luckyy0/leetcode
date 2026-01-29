# 611. Valid Triangle Number / Số Lượng Tam Giác Hợp Lệ

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Cho một mảng số nguyên `nums`, hãy trả về số lượng bộ ba được chọn từ mảng có thể tạo thành tam giác nếu chúng ta lấy chúng làm độ dài cạnh của một tam giác.

### Example 1:
```text
Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting + Two Pointers / Sắp Xếp + Hai Con Trỏ
Constraint: `a + b > c` is sufficient if `a <= b <= c`.
We sort `nums`.
Filter out zeros (can't form triangle).
Iterate `c` (longest side) from `n-1` down to `2`.
For each `c` at index `i`, we use two pointers `left=0` and `right=i-1`.
If `nums[left] + nums[right] > nums[i]`:
  Then all pairs `(left, right), (left+1, right), ..., (right-1, right)` are valid because increasing left only increases sum.
  Count adds `right - left`.
  Decrement `right` to try smaller secondary side.
Else `nums[left] + nums[right] <= nums[i]`:
  Need larger sum, so increment `left`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(log N) (sorting).

---

## Analysis / Phân tích

### Approach: Two Pointers on Sorted Array

**Algorithm**:
1.  Sort array.
2.  Iterate `k` (index of largest side) backwards.
3.  Use `i, j` pointers for the other two sides.
4.  If `nums[i] + nums[j] > nums[k]`, add `j - i` to count and decrement `j`.
5.  Else increment `i`.

---
