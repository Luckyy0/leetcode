# Analysis for Factor Combinations
# *Phân tích cho bài toán Tổ hợp thừa số*

## 1. Problem Essence & Backtracking
## *1. Bản chất vấn đề & Quay lui*

### The Challenge
### *Thách thức*
Decompose `n` into product of integers $\ge 2$.
It's similar to finding all paths in a divisor tree.
The constraint $N \le 10^7$ allows standard DFS backtracking.

### Strategy
### *Chiến lược*
Iterate `i` from `start` (initially 2) up to $\sqrt{n}$.
If `n % i == 0`, we have two choices:
1.  Take `i` as a factor, and recursively decompose `n/i`.
2.  Take `i` and `n/i` as a final pair (if `n/i >= i` to maintain order and avoid duplicates).

Actually, the standard backtracking handles `n/i` implicitly.
Recursive function `dfs(n, start, currentPath)`:
- Iterate `i` from `start` to `sqrt(n)`:
    - If `n % i == 0`:
        - Add `i` to path.
        - Add `i + decompose(n/i)` to results.
        - Backtrack.
- Corner case: We must not include `n` itself as a factor if path is empty (definition says factors in `[2, n-1]`). Wait, definition says combination of factors.
- `8 = 8` is usually not decomposed. `[2,4]` is valid.

Correct Approach:
Loop `i` from `start` while `i * i <= n`:
   If `i` divides `n`:
     - Add `i`.
     - Recurse on `n/i` with new start `i`.
     - Also add `n/i` to result (as the final element of this path branch).
     - Remove `i`.

---

## 2. Approach: Backtracking
## *2. Hướng tiếp cận: Quay lui*

### Logic
### *Logic*
1.  `helper(n, start, path, result)`
2.  Loop `i` from `start` to `sqrt(n)`.
3.  If `n % i == 0`:
    - `path.add(i)`
    - `path.add(n/i)` -> Add copy to result. `path.removeLast()`.
    - `path.add(i)`
    - `helper(n/i, i, path, result)`
    - `path.removeLast()`

Wait, simpler logic:
Always recurse. When pushing to result?
When `path` is not empty, `path + [n]` is a valid factorization (where `n` is the remaining part).
But we need to ensure unique combinations. Enforce non-decreasing order (`start`).

Refined Algorithm:
`dfs(n, start)`:
  For `i` from `start` to `sqrt(n)`:
    If `n % i == 0`:
       item `i` and remaining `n/i`.
       1. Add `path + [i, n/i]` to result.
       2. Add `i` to path, recurse `dfs(n/i, i)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Sorted Factors:** Enforcing `i >= start` eliminates duplicates like `[2, 4]` and `[4, 2]`.
    *Thừa số sắp xếp: Bắt buộc `i >= start` loại bỏ trùng lặp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Depends on number of factors. Hard to state exactly, but sub-exponential.
    *Độ phức tạp thời gian: Phụ thuộc vào số lượng thừa số.*
*   **Space Complexity:** $O(\log N)$ stack depth.
    *Độ phức tạp không gian: $O(\log N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 12. Start 2.
1.  i=2. 12%2==0. Remainder 6.
    - Add `[2, 6]` to result.
    - Recurse `dfs(6, 2)` (Path `[2]`).
        - i=2. 6%2==0. Remainder 3.
            - Add `path + [2, 3]` -> `[2, 2, 3]`.
            - Recurse `dfs(3, 2)` (Path `[2, 2]`).
                - i loop 2 to sqrt(3)=1. No loop.
        - i=3. 3*3 > 6. Stop.
    - Backtrack.
2.  i=3. 12%3==0. Remainder 4.
    - Add `[3, 4]` to result.
    - Recurse `dfs(4, 3)` (Path `[3]`).
        - i=3. 3*3 > 4. Loop runs? 3*3=9 > 4. No loop.
        - Backtrack.
3.  i=4. 4*4 > 12. Stop.

Results: `[2, 6], [2, 2, 3], [3, 4]`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic backtracking. The crucial check is `i * i <= n` to avoid TLE and duplicates.
*Quay lui kinh điển. Kiểm tra quan trọng là `i * i <= n`.*
---
*Chia nhỏ một số thành các thừa số cũng giống như phân tích một thành công lớn thành những nỗ lực nhỏ. Có nhiều cách để đạt được cùng một kết quả.*
Breaking a number into factors is like analyzing a big success into small efforts. There are many ways to achieve the same result.
