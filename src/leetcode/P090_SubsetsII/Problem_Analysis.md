# 90. Subsets II / Tập Con II

## Problem Description / Mô tả bài toán
Given an integer array `nums` that may contain duplicates, return all possible subsets (the power set).
Cho một mảng số nguyên `nums` có thể chứa các giá trị trùng lặp, hãy trả về tất cả các tập con có thể có (tập lũy thừa).

The solution set **must not** contain duplicate subsets. Return the solution in **any order**.
Tập hợp giải pháp **không được** chứa các tập con trùng lặp. Trả về giải pháp theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
```

### Example 2:
```text
Input: nums = [0]
Output: [[],[0]]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`

---

## Analysis / Phân tích

### Approach: Backtracking with Sorting / Quay Lui với Sắp Xếp
- **Idea**: Sort the array first. During recursion, if we decide to skip `nums[i]`, we should skip all identical elements to avoid duplicates.
- **Ý tưởng**: Sắp xếp mảng trước. Trong quá trình đệ quy, nếu chúng ta quyết định bỏ qua `nums[i]`, chúng ta nên bỏ qua tất cả các phần tử giống hệt nhau để tránh trùng lặp.
- **Logic**:
    - `Arrays.sort(nums)`.
    - `backtrack(start, current)`:
        - Add `current` to result.
        - Iterate `i` from `start` to `end`.
        - If `i > start && nums[i] == nums[i-1]`, continue (skip duplicate for this position).
        - Add `nums[i]`, recurse `i + 1`, remove `nums[i]`.
- **Time Complexity**: O(N * 2^N).
- **Space Complexity**: O(N).

---

## Edge Cases / Các trường hợp biên
1.  **All Same**: `[1, 1, 1]` -> `[], [1], [1,1], [1,1,1]`.
2.  **No Duplicates**: Treat as Standard Subsets.
