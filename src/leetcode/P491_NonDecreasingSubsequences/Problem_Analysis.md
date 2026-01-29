# 491. Non-decreasing Subsequences / Các Dãy Con Không Giảm

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in **any order**.
Cho một mảng số nguyên `nums`, hãy trả về tất cả các dãy con không giảm khác nhau có thể có của mảng đã cho với ít nhất hai phần tử. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
```

### Example 2:
```text
Input: nums = [4,4,3,2,1]
Output: [[4,4]]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 15`
- `-100 <= nums[i] <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking with Local De-duplication / Quay lui với việc Khử trùng lặp cục bộ
Since we need all unique subsequences and the array size is small (15), we can use backtracking.

Algorithm:
1. `dfs(startIndex, currentList)`:
   - If `currentList.size() >= 2`, add a copy of `currentList` to the global result.
   - Use a `HashSet` **within the current recursion level** to keep track of elements already used as the "next" element. This avoids duplicate subsequences from same values in the source array.
   - Iterate `i` from `startIndex` to `nums.length - 1`:
     - If `nums[i]` is not in the local `HashSet` AND (`currentList` is empty OR `nums[i] >= last element in currentList`):
       - Add `nums[i]` to local `HashSet`.
       - Add `nums[i]` to `currentList`.
       - Recurse: `dfs(i + 1, currentList)`.
       - **Backtrack**: Remove `nums[i]`.

### Complexity / Độ phức tạp
- **Time**: O(2^N) where N = 15.
- **Space**: O(N) for recursion.

---

## Analysis / Phân tích

### Approach: Recursive Subsequence Generation

**Algorithm**:
1.  Initialize result list.
2.  DFS through indices.
3.  Pruning: check non-decreasing property.
4.  De-duplication: set inside loop.

---
