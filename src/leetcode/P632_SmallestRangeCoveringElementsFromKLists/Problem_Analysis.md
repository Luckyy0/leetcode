# 632. Smallest Range Covering Elements from K Lists / Khoảng Nhỏ Nhất Bao Phủ Các Phần Tử từ K Danh Sách

## Problem Description / Mô tả bài toán
You have `k` lists of sorted integers in **non-decreasing order**. Find the **smallest** range that includes at least one number from each of the `k` lists.
Bạn có `k` danh sách các số nguyên được sắp xếp theo **thứ tự không giảm**. Tìm khoảng **nhỏ nhất** bao gồm ít nhất một số từ mỗi danh sách trong số `k` danh sách.

We define the range `[a, b]` is smaller than range `[c, d]` if `b - a < d - c` or `a < c` if `b - a == d - c`.
Chúng tôi định nghĩa khoảng `[a, b]` nhỏ hơn khoảng `[c, d]` nếu `b - a < d - c` hoặc `a < c` nếu `b - a == d - c`.

### Example 1:
```text
Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Priority Queue (Min Heap) / Sliding Window
We need one element from each list.
Let's maintain a set of indices `[ptr1, ptr2, ..., ptrK]` where initial `ptr_i = 0`.
The current range covers `[Min(vals), Max(vals)]` where `vals` are `nums[i][ptr_i]`.
To minimize range, we want to increase the minimum value (shrink from left).
Max value only increases or changes when we pick a new element. (Actually if we advance the pointer corresponding to Min, the new element will be larger, potentially updating Max).

Algorithm:
1. Initialize Min-Heap with first element of all k lists: `(val, listIndex, elementIndex)`.
2. Track `maxVal` among current elements in heap.
3. While heap size == k (we have one from each list):
   - Pop min element `(minVal, r, c)`.
   - Update global min range if `maxVal - minVal` is better.
   - If list `r` has next element, push `(nums[r][c+1], r, c+1)`. Update `maxVal = Max(maxVal, nums[r][c+1])`.
   - Else loop terminates (cannot cover all lists).

### Complexity / Độ phức tạp
- **Time**: O(N log K) where N is total elements.
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Heap based Multi-pointer

**Algorithm**:
1.  Push first elements of all lists to min-heap.
2.  Keep track of current max.
3.  Pop min, checking range.
4.  Push next element from same list, update max.
5.  Stop when any list is exhausted.

---
