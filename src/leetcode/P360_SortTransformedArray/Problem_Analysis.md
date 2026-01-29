# 360. Sort Transformed Array / Sắp Xếp Mảng Đã Chuyển Đổi

## Problem Description / Mô tả bài toán
Given a **sorted** integer array `nums` and three integers `a`, `b` and `c`, apply a quadratic function of the form `f(x) = ax^2 + bx + c` to each element `x` in the array.
Cho một mảng số nguyên đã sắp xếp `nums` và ba số nguyên `a`, `b`, và `c`, áp dụng hàm bậc hai `f(x) = ax^2 + bx + c` cho mỗi phần tử `x` trong mảng.

The resulting array must be in **sorted order**.
Mảng kết quả phải được sắp xếp.

### Example 1:
```text
Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]
```

### Example 2:
```text
Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 200`
- `nums` is sorted in ascending order.

**Follow up**: Could you solve it in `O(n)` time?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Parabola Properties + Two Pointers / Tính Chất Parabol + Hai Con Trỏ
`f(x) = ax^2 + bx + c` is a parabola (or line if a=0).
1.  **If `a > 0`**: Parabola opens upwards.
    - Values are large at the ends (`-infinity`, `+infinity`) and small near the vertex (`-b/2a`).
    - Since input `nums` is sorted, the transformed values will likely be decreasing then increasing (or just one of those).
    - Largest values are at the ends (`nums[0]` or `nums[n-1]`).
    - Use Two Pointers from both ends, fill the result array from **end to start** (largest to smallest).
2.  **If `a < 0`**: Parabola opens downwards.
    - Values are small at the ends and large near vertex.
    - Smallest values are at the ends.
    - Use Two Pointers from both ends, fill result array from **start to end** (smallest to largest).
3.  **If `a = 0`**: It's a line `bx + c`.
    - If `b > 0`, increasing. Just transform.
    - If `b < 0`, decreasing. Fill reversed? Or treat as special case.
    - Actually, `a >= 0` logic handles `a=0` if we treat ends carefully. If `b>0`, large end is right. If `b<0`, large end is left. The generic "compare ends" logic works.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (output array).

---

## Analysis / Phân tích

### Approach: Two Pointers depending on sign of `a`

**Algorithm**:
1.  Result array `res`.
2.  `l = 0`, `r = n - 1`.
3.  `idx`: if `a >= 0` then `n - 1` (fill max to min), else `0` (fill min to max).
4.  Loop while `l <= r`:
    - Calc `y1 = f(nums[l])`, `y2 = f(nums[r])`.
    - If `a >= 0`:
        - We want MAX. Compare `y1`, `y2`. Put larger at `idx--`. Move pointer corresponding to larger.
    - If `a < 0`:
        - We want MIN. Compare `y1`, `y2`. Put smaller at `idx++`. Move pointer corresponding to smaller.

---
