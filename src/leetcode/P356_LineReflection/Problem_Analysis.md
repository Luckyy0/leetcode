# 356. Line Reflection / Phản Xạ Đường Thẳng

## Problem Description / Mô tả bài toán
Given `n` points on a 2D plane, find if there is such a line parallel to y-axis that reflects the given points symmetrically, in other words, answer whether or not if there exists a line that reflects the points.
Cho `n` điểm trên mặt phẳng 2D, tìm xem có tồn tại đường thẳng nào song song với trục y phản chiếu các điểm đã cho đối xứng hay không.

### Example 1:
```text
Input: points = [[1,1],[-1,1]]
Output: true
```

### Example 2:
```text
Input: points = [[1,1],[-1,-1]]
Output: false
```

## Constraints / Ràng buộc
- `1 <= points.length <= 10^4`
- `-10^8 <= points[i][j] <= 10^8`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Symmetry Property / Tính Chất Đối Xứng
If a reflection line exists at `x = M`, then for every point `(x, y)`, there must be a point `(2M - x, y)`.
Also, `M` must be the midpoint of the minimum `x` and maximum `x` of the set of points.
`min_x + max_x = 2 * M`.
So, for every point `(x, y)`, we must find another point `(min_x + max_x - x, y)` in the set.

Algorithm:
1.  Find `minX` and `maxX` among all points.
2.  Store all points in a `HashSet<String>` or `HashSet<Long>` (encoded coordinate) for O(1) lookup.
3.  Target sum `S = minX + maxX`.
4.  For each point `(x, y)`:
    - Check if `(S - x, y)` exists in the set.
    - If not, return false.
5.  Return true.

Note on Encoding: `x` and `y` can be large. String "x,y" works. Or custom hash.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: HashSet Check

**Algorithm**:
1.  Find bounds.
2.  Populate Set. Handle duplicates? Reflection of duplicate points should match duplicates.
    - "Set of points" usually implies distinct locations?
    - Problem says "n points". Can have duplicates? `[[1,1], [1,1]]`. Reflection line `x=1` works.
    - If `[[1,1], [2,1], [2,1]]`. Reflection line?
    - Usually "set of points" in geometry implies distinct unless specified multiset. But standard HashSet handles distinct. If duplicates matter (multiset reflection), we need HashMap<Point, Count>.
    - LeetCode 356 usually treats distinct points (i.e., duplicates are treated as one point location). The standard solution uses HashSet.

---
