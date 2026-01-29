# 386. Lexicographical Numbers / Các Số Theo Thứ Tự Từ Điển

## Problem Description / Mô tả bài toán
Given an integer `n`, return all the numbers in the range `[1, n]` sorted in lexicographical order.
Cho một số nguyên `n`, trả về tất cả các số trong phạm vi `[1, n]` được sắp xếp theo thứ tự từ điển.

You must write an algorithm that runs in `O(n)` time and uses `O(1)` extra space.

### Example 1:
```text
Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
```

### Example 2:
```text
Input: n = 2
Output: [1,2]
```

## Constraints / Ràng buộc
- `1 <= n <= 5 * 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### DFS / Preorder Traversal / Duyệt Trước
Think of it like a 10-ary tree.
- Root children: 1, 2, ..., 9.
- Child `i` has children: `i*10`, `i*10+1`, ..., `i*10+9`.
- Preorder traversal gives lexicographical order.
- Stop when value > n.

### Iterative Approach / Vòng Lặp
Track `curr = 1`.
Loop n times:
- Add `curr` to result.
- If `curr * 10 <= n`: `curr *= 10` (go deeper).
- Else:
    - If `curr >= n` or `curr % 10 == 9`: go up until we can increment (`curr /= 10`).
    - Then `curr++`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) extra (excluding output).

---

## Analysis / Phân tích

### Approach: Iterative DFS Simulation

**Algorithm**:
1.  `curr = 1`. `List res`.
2.  Loop N times:
    - `res.add(curr)`.
    - If `curr * 10 <= n`: `curr *= 10`.
    - Else:
        - While `curr % 10 == 9 || curr >= n`: `curr /= 10`.
        - `curr++`.

---
