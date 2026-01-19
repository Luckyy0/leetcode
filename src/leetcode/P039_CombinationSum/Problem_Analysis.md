# 39. Combination Sum / Tổng Tổ Hợp

## Problem Description / Mô tả bài toán
Given an array of **distinct** integers `candidates` and a target integer `target`, return a list of all **unique combinations** of `candidates` where the chosen numbers sum to `target`. You may return the combinations in **any order**.
Cho một mảng các số nguyên **khác nhau** `candidates` và một số nguyên đích `target`, trả về danh sách tất cả các **tổ hợp duy nhất** của `candidates` trong đó các số được chọn có tổng bằng `target`. Bạn có thể trả về các tổ hợp theo **bất kỳ thứ tự nào**.

The **same** number may be chosen from `candidates` an **unlimited number of times**. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
**Cùng một** số có thể được chọn từ `candidates` **không giới hạn số lần**. Hai tổ hợp là duy nhất nếu tần suất của ít nhất một trong các số được chọn là khác nhau.

The test cases are generated such that the number of unique combinations that sum up to `target` is less than 150 combinations for the given input.
Các trường hợp kiểm tra được tạo sao cho số lượng tổ hợp duy nhất có tổng bằng `target` nhỏ hơn 150 tổ hợp cho đầu vào đã cho.

### Example 1:
```text
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
```

### Example 2:
```text
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
```

### Example 3:
```text
Input: candidates = [2], target = 1
Output: []
```

## Constraints / Ràng buộc
- `1 <= candidates.length <= 30`
- `2 <= candidates[i] <= 40`
- All elements of `candidates` are **distinct**.
- `1 <= target <= 40`

---

## Analysis / Phân tích

### Approach: Backtracking / Quay Lui
- **Idea**: Use recursion to build combinations.
- **Ý tưởng**: Sử dụng đệ quy để xây dựng các tổ hợp.
    - At each step (index `i`), we have two choices:
        1.  **Include `candidates[i]`**: Add to current combination, subtract from target, and **stay at index `i`** (since we can reuse it). Check if `target >= candidates[i]`.
        2.  **Skip `candidates[i]`**: Move to index `i + 1`.
    - Base cases:
        - `target == 0`: Found a valid combination, add to result.
        - `target < 0` or `i == candidates.length`: Invalid path, return.
- **Time Complexity**: O(N^(T/M)), where N is number of candidates, T is target, M is min value in candidates. This is exponential but constrained by the problem limits (max 150 combinations).
- **Space Complexity**: O(T/M) for recursion stack (depth of the tree).

---

## Edge Cases / Các trường hợp biên
1.  **Target unreachable**: Returns empty list.
2.  **Smallest candidate > Target**: Returns empty list.
