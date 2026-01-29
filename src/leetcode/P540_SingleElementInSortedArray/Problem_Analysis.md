# 540. Single Element in a Sorted Array / Phần Tử Duy Nhất Trong Mảng Đã Sắp Xếp

## Problem Description / Mô tả bài toán
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Bạn được cho một mảng đã sắp xếp chỉ bao gồm các số nguyên, trong đó mọi phần tử xuất hiện chính xác hai lần, ngoại trừ một phần tử xuất hiện chính xác một lần.

Return the single element that appears only once.
Hãy trả về phần tử duy nhất xuất hiện một lần.

Your solution must run in `O(log n)` time and `O(1)` space.
Giải pháp của bạn phải chạy trong thời gian `O(log n)` và không gian `O(1)`.

### Example 1:
```text
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Indices / Tìm Kiếm Nhị Phân trên Chỉ Số
Observation:
- Before the single element, pairs start at **even** indices: `(0,1), (2,3), ...` -> `nums[even] == nums[even+1]`.
- After the single element, pairs start at **odd** indices due to shift: `(odd, even)` -> `nums[odd] == nums[odd+1]`.

Algorithm:
1. `left = 0`, `right = n - 1`.
2. While `left < right`:
   - `mid = (left + right) / 2`.
   - Ensure `mid` is even: if `mid % 2 == 1`, `mid--`.
   - If `nums[mid] == nums[mid + 1]`:
     - The single element is to the right (pattern holds so far).
     - `left = mid + 2`.
   - Else:
     - The single element is at `mid` or to the left.
     - `right = mid`.
3. Return `nums[left]`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search Pair Checking

**Algorithm**:
1.  Initialize pointers.
2.  Calculate mid and force even index.
3.  Compare with next neighbor.
4.  Adjust search range based on equality.

---
