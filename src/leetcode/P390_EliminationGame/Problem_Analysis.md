# 390. Elimination Game / Trò Chơi Loại Bỏ

## Problem Description / Mô tả bài toán
You have a list `arr` of all integers in the range `[1, n]` sorted in a strictly increasing order. Apply the following algorithm on `arr`:
Bạn có một danh sách `arr` gồm tất cả các số nguyên trong phạm vi `[1, n]`...

- Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
- Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
- Keep repeating the steps again, alternating left to right and right to left, until a single number remains.

Given the integer `n`, return the last number that remains in `arr`.

### Example 1:
```text
Input: n = 9
Output: 6
Explanation:
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr = [2, 4, 6, 8]
arr = [2, 6]
arr = [6]
```

### Example 2:
```text
Input: n = 1
Output: 1
```

## Constraints / Ràng buộc
- `1 <= n <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Mathematical Pattern / Mẫu Toán Học
Simulate is O(N). Too slow.
Track `head` (first element of current sequence), `step` (gap between elements), `remaining` (count).
Go left-to-right: `head` always updates.
Go right-to-left: `head` updates only if `remaining` is odd.
`step` doubles each round. `remaining` halves.
Stop when `remaining == 1`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Math Simulation

**Algorithm**:
1.  `head = 1`, `step = 1`, `remaining = n`, `left = true`.
2.  While `remaining > 1`:
    - If `left` or `remaining % 2 == 1`:
        - `head += step`.
    - `remaining /= 2`.
    - `step *= 2`.
    - `left = !left`.
3.  Return `head`.

---
