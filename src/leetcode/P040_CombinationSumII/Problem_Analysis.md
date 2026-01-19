# 40. Combination Sum II / Tổng Tổ Hợp II

## Problem Description / Mô tả bài toán
Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`.
Cho một tập hợp các số ứng viên (`candidates`) và một số đích (`target`), hãy tìm tất cả các tổ hợp duy nhất trong `candidates` sao cho tổng các số ứng viên bằng `target`.

Each number in `candidates` may only be used **once** in the combination.
Mỗi số trong `candidates` chỉ được sử dụng **một lần** trong tổ hợp.

**Note**: The solution set must not contain duplicate combinations.
**Lưu ý**: Tập hợp kết quả không được chứa các tổ hợp trùng lặp.

### Example 1:
```text
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
```

### Example 2:
```text
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
```

## Constraints / Ràng buộc
- `1 <= candidates.length <= 100`
- `1 <= candidates[i] <= 50`
- `1 <= target <= 30`

---

## Analysis / Phân tích

### Approach: Backtracking with Duplicate Handling / Quay Lui với Xử Lý Trùng Lặp
- **Idea**: Similar to Combination Sum I, but we cannot reuse elements, and the input may contain duplicates.
- **Ý tưởng**: Tương tự như Combination Sum I, nhưng chúng ta không thể sử dụng lại các phần tử và đầu vào có thể chứa các phần tử trùng lặp.
    - **Sorting**: First sort the `candidates` array. This helps in two ways:
        1.  Pruning if `candidate > remaining`.
        2.  Skipping duplicates easily.
    - **Backtracking**:
        - Base Case: `remaining == 0` -> Add to result.
        - Loop `i` from `start` to `end`:
        - **Skip Duplicates**: `if (i > start && candidates[i] == candidates[i-1]) continue`. This ensures that for a specific position in the combination, we only try a specific value once per recursive level.
        - Include `candidates[i]`, recurse with `i + 1` (move to next element).
- **Time Complexity**: O(2^N). Each element can be included or not. Practically faster due to constraints and pruning.
- **Space Complexity**: O(N) for recursion.

---

## Edge Cases / Các trường hợp biên
1.  **All Duplicates**: `[1, 1, 1]`, target 2 -> `[[1, 1]]`.
2.  **Unreachable**: Returns empty list.
