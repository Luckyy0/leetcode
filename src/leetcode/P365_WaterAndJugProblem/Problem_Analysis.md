# 365. Water and Jug Problem / Vấn Đề Bình Nước

## Problem Description / Mô tả bài toán
You are given two jugs with capacities `x` liters and `y` liters. You have an infinite water supply. Return whether the total amount of water in both jugs may reach `target` using the following operations:
- Fill any of the jugs completely with water.
- Empty any of the jugs.
- Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.

### Example 1:
```text
Input: x = 3, y = 5, target = 4
Output: true
```

### Example 2:
```text
Input: x = 2, y = 6, target = 5
Output: false
```

## Constraints / Ràng buộc
- `1 <= x, y, target <= 10^3`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Mathematical (Bézout's identity) / Toán Học (Định Lý Bézout)
This is a classic problem solvable via GCD.
The amount of water we can measure is always a linear combination `a*x + b*y`.
According to Bézout's identity, the smallest positive amount we can measure is `gcd(x, y)`.
Any measurable amount must be a multiple of `gcd(x, y)`.
Conditions:
1.  `target % gcd(x, y) == 0`.
2.  `target <= x + y` (Total capacity).

### Complexity / Độ phức tạp
- **Time**: O(log(min(x, y))).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: GCD

**Algorithm**:
1.  If `target > x + y`, return false.
2.  If `target == 0` return true.
3.  Return `target % gcd(x, y) == 0`.

---
