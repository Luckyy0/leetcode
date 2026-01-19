# 254. Factor Combinations / Các Tổ Hợp Thừa Số

## Problem Description / Mô tả bài toán
Numbers can be regarded as product of its factors. For example,
Số có thể được coi là tích của các thừa số của nó. Ví dụ,
`8 = 2 x 2 x 2 = 2 x 4`.

Given an integer `n`, return all possible combinations of its factors. You may return the answer in **any order**.
Cho một số nguyên `n`, hãy trả về tất cả các tổ hợp có thể của các thừa số của nó. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

Note that the factors should be in the range `[2, n - 1]`.
Lưu ý rằng các thừa số phải nằm trong khoảng `[2, n - 1]`.

### Example 1:
```text
Input: n = 1
Output: []
```

### Example 2:
```text
Input: n = 12
Output: [[2,6],[2,2,3],[3,4],[2,2,3]] -> wait, duplicates?
Standard output: [[2, 6], [2, 2, 3], [3, 4]]
```

### Example 3:
```text
Input: n = 37
Output: []
```

## Constraints / Ràng buộc
- `1 <= n <= 10^7`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Backtracking / Quay Lui
We need to decompose `n` into factors `f1 * f2 * ... * fk`.
To avoid duplicates (like `2*6` and `6*2`), we enforce a non-decreasing order of factors.
We pass `start` to the recursive function, trying factors from `start` up to `sqrt(n)`.

**Algorithm**:
1.  Function `dfs(n, start, currentPath, result)`.
2.  Iterate `i` from `start` to `sqrt(n)`:
    - If `n % i == 0`:
        - Add `i` to `currentPath`.
        - Add `currentPath` + `n/i` to `result` (one valid decomposition: `i * (n/i)`).
        - Recurse `dfs(n/i, i, currentPath, result)`.
        - Backtrack: Remove `i` from `currentPath`.

**Corner Case**:
- `n` itself is not added as a single factor `[n]` because factors must be `< n`.
- Input `1`: Returns empty.

### Complexity / Độ phức tạp
- **Time**: Depends on number of factors. Roughly exponential in worst case but pruned heavily.
- **Space**: O(log N) recursion depth.

---

## Analysis / Phân tích

### Approach: Recursive Backtracking

**Algorithm**:
1.  Check `n <= 1`. Return empty.
2.  `dfs(n, 2, list, res)`.

---
