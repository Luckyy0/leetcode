# 149. Max Points on a Line / Số Điểm Tối Đa Trên Một Đường Thẳng

## Problem Description / Mô tả bài toán
Given an array of `points` where `points[i] = [xi, yi]` represents a point on the **X-Y** plane, return the maximum number of points that lie on the same straight line.
Cho một mảng `points` trong đó `points[i] = [xi, yi]` đại diện cho một điểm trên mặt phẳng **X-Y**, hãy trả về số lượng điểm tối đa nằm trên cùng một đường thẳng.

### Example 1:
```text
Input: points = [[1,1],[2,2],[3,3]]
Output: 3
```

### Example 2:
```text
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
```

## Constraints / Ràng buộc
- `1 <= points.length <= 300`
- `points[i].length == 2`
- `-10^4 <= xi, yi <= 10^4`
- All the `points` are **unique**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Line Equation / Phương trình Đường thẳng
A line is uniquely determined by two points. Any point `(x, y)` on a line satisfies `y = mx + c`, where `m` is the slope.
Một đường thẳng được xác định duy nhất bởi hai điểm. Bất kỳ điểm `(x, y)` nào trên đường thẳng đều thỏa mãn `y = mx + c`, trong đó `m` là hệ số góc.

### Slope Logic / Logic Hệ số góc
For any two points `(x1, y1)` and `(x2, y2)`, the slope is `(y2 - y1) / (x2 - x1)`.
- If two points have the same slope relative to a fixed point `A`, they all lie on the same line passing through `A`.
- To avoid floating-point precision issues, represent the slope as a reduced fraction `dy / dx` using the **Greatest Common Divisor (GCD)**.

**Handling Vertical Lines**: If `x2 - x1 == 0`, the slope is undefined (vertical).
**GCD Approach**:
1. `dy = y2 - y1`, `dx = x2 - x1`.
2. `g = gcd(dy, dx)`.
3. Store the slope as a string or a custom pair `(dy/g, dx/g)`.

---

## Analysis / Phân tích

### Approach: Hash Map of Slopes

**Algorithm**:
1.  If number of points < 3, return the length.
2.  Iterate through each point `i` as the anchor.
3.  For each point `i`, maintain a hash map where the key is the slope with subsequent points `j`.
4.  The slope is stored as a string `"dy/dx"`.
5.  Find the maximum count in the map for anchor `i`.
6.  Update the global maximum.

**Complexity / Độ phức tạp**:
- **Time**: O(N^2 * log(maxCoord)) - N^2 pairs, log for GCD.
- **Space**: O(N) - to store slopes for one anchor at a time.

---

## Edge Cases / Các trường hợp biên
1.  **Strictly vertical/horizontal lines**: Handled by GCD.
2.  **Duplicate points**: Problem states points are unique.
3.  **Few points**: Covered by base logic.
