# 440. K-th Smallest in Lexicographical Order / Số Nhỏ Thứ K Theo Thứ Tự Từ Điển

## Problem Description / Mô tả bài toán
Given two integers `n` and `k`, return the `k-th` lexicographically smallest integer in the range `[1, n]`.
Cho hai số nguyên `n` và `k`, hãy trả về số nguyên nhỏ thứ `k` theo thứ tự từ điển trong phạm vi `[1, n]`.

### Example 1:
```text
Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest is 10.
```

### Example 2:
```text
Input: n = 1, k = 1
Output: 1
```

## Constraints / Ràng buộc
- `1 <= k <= n <= 10^9`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Denary Tree Traversal (Trie-like) / Duyệt cây 10 nút
The lexicographical order of numbers can be visualized as a **denary tree** (a tree where each node has 10 children: 0 through 9).
- The root is empty.
- Children of 1 are 10, 11, ..., 19.
- Children of 10 are 100, 101, ..., 109.

Algorithm:
1. Start at the "prefix" `curr = 1`.
2. While `k > 1`:
   - Calculate how many numbers exist in the range `[1, n]` that start with the prefix `curr`. Let this count be `steps`.
   - If `steps < k`:
     - The $k$-th smallest number is not in the subtree of `curr`. 
     - Move to the next "sibling": `curr = curr + 1`.
     - Subtract `steps` from `k`.
   - If `steps >= k`:
     - The $k$-th smallest number is inside the subtree of `curr`.
     - Move to the first "child": `curr = curr * 10`.
     - Subtract 1 from `k` (account for the current `curr` node itself).
3. Return `curr`.

How to calculate `steps` between `curr` and `curr + 1`?
- For each level (1, 10, 100, ...), the number of nodes is `min(n + 1, next_level) - current_level`.
- Loop until `current_level > n`.

### Complexity / Độ phức tạp
- **Time**: O((log N)^2). There are log N digits, and for each digit, we might count steps across several siblings.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Prefix-based Step Counting

**Algorithm**:
1.  Implement `countSteps(curr, n, nextPrefix)`.
2.  Iterate to find the correct prefix branch.

---
