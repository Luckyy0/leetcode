# 335. Self Crossing / Tự Cắt

## Problem Description / Mô tả bài toán
You are given an array of integers `distance`.
Bạn được cung cấp một mảng số nguyên `distance`.

You start at `(0, 0)` on an X-Y plane and you move `distance[0]` meters to the north, then `distance[1]` meters to the west, `distance[2]` meters to the south, `distance[3]` meters to the east, and so on. In other words, after each move, your direction changes counter-clockwise.
Bạn bắt đầu tại `(0, 0)` trên mặt phẳng X-Y và di chuyển...

Return `true` if your path crosses itself, and `false` if it does not.
Trả về `true` nếu đường đi của bạn tự cắt và `false` nếu không.

### Example 1:
```text
Input: distance = [2,1,1,2]
Output: true
```

### Example 2:
```text
Input: distance = [1,2,3,4]
Output: false
```

### Example 3:
```text
Input: distance = [1,1,1,1]
Output: true
```

## Constraints / Ràng buộc
- `1 <= distance.length <= 10^5`
- `1 <= distance[i] <= 10^5`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Geometric Patterns / Các Mẫu Hình Học
There are 3 specific cases where a self-crossing happens:
1.  **Fourth line crosses first line**:
    `d[i] >= d[i-2]` and `d[i-1] <= d[i-3]`.
    (Spiral in or standard crossing of box).

2.  **Fifth line meets first line**:
    `d[i-1] == d[i-3]` and `d[i] + d[i-4] >= d[i-2]`.
    (Exact touch).

3.  **Sixth line crosses first line**:
    `d[i-1] <= d[i-3]` (bounded)
    `d[i-1] + d[i-5] >= d[i-3]` (but not too small)
    `d[i-2] > d[i-4]` (was expanding)
    `d[i] + d[i-4] >= d[i-2]` (now crosses).
    Basically, transitioning from expanding spiral to shrinking spiral.

If none of these happen for any `i`, then return `false` (it's either purely expanding or purely shrinking).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Check 3 patterns

**Algorithm**:
1.  Iterate `i` from 3 to N.
2.  Check Case 1: `d[i]>=d[i-2] && d[i-1]<=d[i-3]`.
3.  Check Case 2: `i>=4`. `d[i-1]==d[i-3] && d[i]+d[i-4]>=d[i-2]`.
4.  Check Case 3: `i>=5`. `d[i-1]<=d[i-3] && d[i-1]+d[i-5]>=d[i-3] && d[i-2]>d[i-4] && d[i]+d[i-4]>=d[i-2]`.

---
