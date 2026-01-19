# 47. Permutations II / Hoán Vị II

## Problem Description / Mô tả bài toán
Given a collection of numbers, `nums`, that might contain duplicates, return all possible unique permutations in **any order**.
Cho một tập hợp các số `nums` có thể chứa các số trùng lặp, trả về tất cả các hoán vị duy nhất có thể theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: nums = [1,1,2]
Output: [[1,1,2],[1,2,1],[2,1,1]]
```

### Example 2:
```text
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 8`
- `-10 <= nums[i] <= 10`

---

## Analysis / Phân tích

### Approach: Backtracking with Used Array / Quay Lui với Mảng Đã Sử Dụng
- **Idea**: Similar to Permutations I, but inputs contain duplicates.
- **Ý tưởng**: Tương tự như Permutations I, nhưng đầu vào chứa các số trùng lặp.
- **Handling Duplicates**:
    1.  Sort the `nums` array.
    2.  Use a boolean array `used` to keep track of visited elements in the current path.
    3.  When iterating `i` from 0 to `n-1`:
        - If `used[i]` is true, skip.
        - **Crucial Step**: If `(i > 0 && nums[i] == nums[i-1] && !used[i-1])`, skip.
            - Interpretation: If the current number is the same as the previous one, and the previous one was NOT used in this current depth (meaning we just finished the recursive tree for that previous identical number), then using the current number would start an identical recursive tree. So we skip it to avoid duplicates.
- **Time Complexity**: O(N * N!).
- **Space Complexity**: O(N).

---

## Edge Cases / Các trường hợp biên
1.  **All Duplicates**: `[1, 1, 1]` -> `[[1, 1, 1]]`.
2.  **No Duplicates**: Handled correctly.
