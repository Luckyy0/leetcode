# 493. Reverse Pairs / Các Cặp Đảo Ngược

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the number of **reverse pairs** in the array.
Cho một mảng số nguyên `nums`, hãy trả về số lượng các **cặp đảo ngược (reverse pairs)** trong mảng đó.

A reverse pair is a pair `(i, j)` where:
Một cặp đảo ngược là một bộ `(i, j)` trong đó:
- `0 <= i < j < nums.length`, and
- `nums[i] > 2 * nums[j]`.

### Example 1:
```text
Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are (1, 4) and (3, 4). 
(nums[1]=3 > 2*nums[4]=2, nums[3]=3 > 2*nums[4]=2)
```

### Example 2:
```text
Input: nums = [2,4,3,5,1]
Output: 3
Explanation: (1, 4), (2, 4), (3, 4). (Indices 0..4)
4 > 2*1, 3 > 2*1, 5 > 2*1.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5 * 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Merge Sort Based Counting / Đếm dựa trên Sắp xếp Trộn
Like the standard inversion count (`nums[i] > nums[j]`), we can use the divide-and-conquer approach.

Algorithm:
1. `countReversePairs(nums, left, right)`:
   - If `left >= right`, return 0.
   - `mid = left + (right - left) / 2`.
   - `count = countReversePairs(nums, left, mid) + countReversePairs(nums, mid + 1, right)`.
2. **The counting step**:
   - Before merging the two sorted halves `[left...mid]` and `[mid+1...right]`:
   - Use two pointers `i` in the first half and `j` in the second half.
   - For each `i` from `left` to `mid`:
     - While `j <= right` and `nums[i] > 2.0 * nums[j]` (use double or cast to long to avoid overflow):
       - Increment `j`.
     - All elements from `mid + 1` to `j - 1` satisfy the condition for the current `i`.
     - `count += (j - (mid + 1))`.
3. **The merge step**:
   - Standard merge to keep the halves sorted for the next level.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N) for the temp array during merge.

---

## Analysis / Phân tích

### Approach: Divide and Conquer (Merge Sort)

**Algorithm**:
1.  Standard Merge Sort structure.
2.  Extra counting loop after children return.
3.  Two-pointer logic for O(N) counting per merge level.

---
