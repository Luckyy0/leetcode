# 605. Can Place Flowers / Có Thể Trồng Hoa

## Problem Description / Mô tả bài toán
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Bạn có một luống hoa dài trong đó một số ô đã được trồng và một số thì không. Tuy nhiên, hoa không thể được trồng trong các ô liền kề.

Given an integer array `flowerbed` containing `0`'s and `1`'s, where `0` means empty and `1` means not empty, and an integer `n`, return `true` if `n` new flowers can be planted in the `flowerbed` without violating the no-adjacent-flowers rule and `false` otherwise.
Cho một mảng số nguyên `flowerbed` chứa các số `0` và `1`, trong đó `0` có nghĩa là trống và `1` có nghĩa là không trống, và một số nguyên `n`, hãy trả về `true` nếu `n` bông hoa mới có thể được trồng trong `flowerbed` mà không vi phạm quy tắc không có hoa liền kề và `false` nếu ngược lại.

### Example 1:
```text
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
```
### Example 2:
```text
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Linear Scan / Quét Tuyến Tính Tham Lam
Iterate through the array. Try to plant a flower in every eligible spot.
A spot `i` is eligible if:
1. `flowerbed[i] == 0`.
2. `flowerbed[i-1] == 0` (or `i` is 0).
3. `flowerbed[i+1] == 0` (or `i` is last).

If we find such a spot, update `flowerbed[i] = 1`, decrement `n`.
If `n <= 0` at any point, return true.
If loop finishes and `n > 0`, return false.

Note: We modify the array (or a virtual view of it) to enforce the non-adjacent constraint for subsequent checks.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Check

**Algorithm**:
1.  Scan array.
2.  If current is 0 and neighbours are 0 (handling boundaries), plant flower.
3.  Set current to 1.
4.  Decrease required count.
5.  Check completion condition.

---
