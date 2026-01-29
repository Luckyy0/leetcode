# 315. Count of Smaller Numbers After Self / Đếm Số Lượng Số Nhỏ Hơn Sau Nó

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return an integer array `counts` where `counts[i]` is the number of smaller elements to the right of `nums[i]`.
Cho một mảng số nguyên `nums`, trả về một mảng số nguyên `counts` trong đó `counts[i]` là số lượng các phần tử nhỏ hơn nằm bên phải của `nums[i]`.

### Example 1:
```text
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
```

### Example 2:
```text
Input: nums = [-1]
Output: [0]
```

### Example 3:
```text
Input: nums = [-1,-1]
Output: [0,0]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Merge Sort (Inversion Counting) / Sắp Xếp Trộn (Đếm Nghịch Đảo)
This problem basically asks for the "inversion count" for each specific element.
Using Merge Sort:
- During `merge` step of `left_part` and `right_part`.
- If `left[i] > right[j]`, it means `right[j]` is smaller than `left[i]` and is to the right. It "jumps" over `left[i]`.
- Actually, logic is:
  For a fixed element in `left_part`, how many elements from `right_part` jumped to its left during merge? A jump happens when we pick from right because it's smaller.
  Standard merge sort picks smallest.
  - If we pick `right[j]`, we increment a counter `countRightSmaller`.
  - If we pick `left[i]`, we add `countRightSmaller` to `result[original_index_of_left[i]]`.

We need to track original indices. `Item { val, originalIdx }`.

### Binary Indexed Tree (BIT)
- Coordinate compression (values -10^4 to 10^4 -> rank 1 to 20000). Or offset +10001.
- Iterate from right to left.
- `count = query(rank(nums[i]) - 1)`.
- `update(rank(nums[i]), 1)`.

Merge Sort is O(N log N). BIT is also O(N log N) but requires handling value range (which is small here). BIT is cleaner if constraints allow array map. Values range 20,000 size array. Perfect.

### Complexity / Độ phức tạp
- **Time**: O(N log N) (Merge Sort or BIT).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: BIT (Fenwick Tree) with Offset

**Algorithm**:
1.  Values in range `[-10000, 10000]`. Offset by `+10001` to make positive `[1, 20001]`. Size `20002`.
2.  Init `counts` array. `BIT` array.
3.  Loop `i` from `n-1` down to 0:
    - `rank = nums[i] + 10001`.
    - `counts[i] = query(rank - 1)`.
    - `update(rank, 1)`.
4.  Return `counts`.

---
