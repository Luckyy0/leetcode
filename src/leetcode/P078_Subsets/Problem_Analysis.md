# 78. Subsets / Tập Con

## Problem Description / Mô tả bài toán
Given an integer array `nums` of **unique** elements, return all possible subsets (the power set).
Cho một mảng số nguyên `nums` gồm các phần tử **duy nhất**, hãy trả về tất cả các tập con có thể có (tập lũy thừa).

The solution set **must not** contain duplicate subsets. Return the solution in **any order**.
Tập hợp giải pháp **không được** chứa các tập con trùng lặp. Trả về giải pháp theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

### Example 2:
```text
Input: nums = [0]
Output: [[],[0]]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
- All the numbers of `nums` are **unique**.

---

## Analysis / Phân tích

### Approach 1: Backtracking (Cascading) / Quay Lui (Kéo Theo)
- **Idea**: For each element, either include it or exclude it.
- **Ý tưởng**: Đối với mỗi phần tử, bao gồm nó hoặc loại trừ nó.
- **Algorithm**:
    - `backtrack(start, current)`
    - Add `current` to result (every state is a valid subset).
    - Loop `i` from `start` to `n`:
        - Add `nums[i]` to `current`.
        - `backtrack(i + 1, current)`.
        - Remove `nums[i]`.
- **Time Complexity**: O(N * 2^N).
- **Space Complexity**: O(N).

### Approach 2: Bit Manipulation / Thao Tác Bit
- **Idea**: There are 2^n subsets. Each bitmask from 0 to 2^n - 1 represents a subset.
- **Algorithm**: Loop `i` from 0 to 2^n - 1. If j-th bit is set, include `nums[j]`.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Subset**: Always included.
2.  **Single Element**: `[], [1]`.
