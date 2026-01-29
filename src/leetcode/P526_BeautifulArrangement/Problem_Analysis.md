# 526. Beautiful Arrangement / Sắp Xếp Đẹp

## Problem Description / Mô tả bài toán
Suppose you have `n` integers labeled `1` through `n`. A permutation of those `n` integers `perm` (1-indexed) is considered a **beautiful arrangement** if for every `i` (`1 <= i <= n`), either of the following is true:
Giả sử bạn có `n` số nguyên được đánh số từ `1` đến `n`. Một hoán vị của `n` số nguyên đó `perm` (đánh số từ 1) được coi là **sắp xếp đẹp** nếu với mọi `i` (`1 <= i <= n`), một trong các điều sau đây là đúng:

- `perm[i]` is divisible by `i`. / `perm[i]` chia hết cho `i`.
- `i` is divisible by `perm[i]`. / `i` chia hết cho `perm[i]`.

Given an integer `n`, return the number of the beautiful arrangements that you can construct.
Cho một số nguyên `n`, hãy trả về số lượng các sắp xếp đẹp mà bạn có thể tạo ra.

### Example 1:
```text
Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1, 2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2, 1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
```

## Constraints / Ràng buộc
- `1 <= n <= 15`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / Quay lui
Since `n` is small (up to 15), we can try all permutations but prune the search space as soon as a condition is violated.

Algorithm:
1. Use a recursive backtracking function `backtrack(index, visited)`.
2. `index` represents the current position we are trying to fill (from 1 to `n`).
3. `visited` keeps track of which numbers have already been used.
4. For each number `num` from 1 to `n`:
   - If `num` is not visited AND (`num % index == 0` OR `index % num == 0`):
     - Mark `num` as visited.
     - Recurse: `backtrack(index + 1, visited)`.
     - Backtrack: Mark `num` as unvisited.
5. If `index > n`, we found a valid arrangement, increment count.

### Complexity / Độ phức tạp
- **Time**: O(k), where k is the number of valid permutations. In worst case O(n!), but pruning makes it much faster.
- **Space**: O(n) for recursion stack and visited array.

---

## Analysis / Phân tích

### Approach: Recursive Permutation Construction

**Algorithm**:
1.  Initialize recursion at index 1.
2.  Iterate through candidate numbers.
3.  Check divisibility constraints.
4.  Recursive step and backtracking.

---
