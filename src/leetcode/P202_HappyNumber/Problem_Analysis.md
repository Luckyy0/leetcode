# 202. Happy Number / Số Hạnh Phúc

## Problem Description / Mô tả bài toán
Write an algorithm to determine if a number `n` is happy.
Viết một thuật toán để xác định xem số `n` có phải là số hạnh phúc hay không.

A happy number is a number defined by the following process:
1.  Starting with any positive integer, replace the number by the sum of the squares of its digits.
2.  Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
3.  Those numbers for which this process ends in 1 are happy.

Return `true` if `n` is a happy number, and `false` if not.

### Example 1:
```text
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
```

### Example 2:
```text
Input: n = 2
Output: false
```

## Constraints / Ràng buộc
- `1 <= n <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Cycle Detection / Phát hiện Chu trình
The sequence of numbers generated must either reach 1 or enter a cycle.
Dãy số được tạo ra phải hoặc là đạt đến 1 hoặc đi vào một chu trình.
- For 32-bit integers, the maximum possible next value is for `1,999,999,999` => `1 + 9*81 = 730`.
- Thus, the numbers will not grow indefinitely; they are bounded (<= 730 generally).
- Since the domain is finite, a cycle is guaranteed if we don't reach 1.

We can use **Floyd's Cycle-Finding Algorithm** (Tortoise and Hare) or a **HashSet** to detect the cycle.

---

## Analysis / Phân tích

### Approach: HashSet

**Algorithm**:
1.  Initialize a Set `seen`.
2.  While `n != 1`:
    - Calculate `sum` of squares of digits.
    - If `sum` is already in `seen`, return `false` (cycle detected).
    - Add `sum` to `seen`.
    - Update `n = sum`.
3.  Return `true`.

### Complexity / Độ phức tạp
- **Time**: O(log N) - finding digit sum is logarithmic. The number of steps is small constant.
- **Space**: O(log N) - or O(1) practically since the set size is limited by the maximum possible sum (730).

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: Happy.
2.  **Small loop**: 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4.
3.  **Large numbers**: Max integer.
