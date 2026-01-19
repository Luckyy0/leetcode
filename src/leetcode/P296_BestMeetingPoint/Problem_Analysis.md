# 296. Best Meeting Point / Điểm Gặp Gỡ Tốt Nhất

## Problem Description / Mô tả bài toán
Given an `m x n` binary grid `grid` where each `1` marks the home of one friend, return the minimal total travel distance.
Cho một lưới nhị phân `m x n` `grid` trong đó mỗi `1` đánh dấu nhà của một người bạn, hãy trả về tổng khoảng cách di chuyển tối thiểu.

The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
Tổng khoảng cách di chuyển là tổng khoảng cách từ nhà của những người bạn đến điểm gặp gỡ.

The distance is calculated using Manhattan Distance, where `distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|`.
Khoảng cách được tính bằng Khoảng cách Manhattan.

### Example 1:
```text
Input: grid = [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 6
Explanation: Given three friends living at (0,0), (0,4), and (2,2).
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal.
So return 6.
```

### Example 2:
```text
Input: grid = [[1,1]]
Output: 1
```

## Constraints / Ràng buộc
- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 200`
- `grid[i][j]` is either `0` or `1`.
- There will be at least two friends in the grid.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Manhattan Distance Independence / Tính Độc Lập của Khoảng Cách Manhattan
Since `dist = |x1 - x2| + |y1 - y2|`, the minimization for X and Y can be done independently.
Total Distance = Sum(|xi - meetX|) + Sum(|yi - meetY|).
The point that minimizes the sum of absolute differences to a set of points is the **Median**.

**Algorithm**:
1.  Collect all X coordinates of 1s in a list `rows`.
2.  Collect all Y coordinates of 1s in a list `cols`.
    - Note: To get sorted `cols` effectively, iterate column by column.
3.  Find median of `rows` (since we collect by row iteration, it's sorted).
    - Actually, we don't need the median value explicitly. The sum of distances to median is `Sum(|xi - median|)`.
    - This is equivalent to `Sum(end - start)` for pairs from outside in.
    - Logic: Median minimizes it. But calculation is simply `(rows[last] - rows[0]) + (rows[last-1] - rows[1]) + ...`.
4.  Calculate minimal distance 1D for X.
5.  Calculate minimal distance 1D for Y.
6.  Sum them.

### Complexity / Độ phức tạp
- **Time**: O(M * N). Collect coords.
- **Space**: O(M * N) list of coords.

---

## Analysis / Phân tích

### Approach: Median 1D

**Algorithm**:
1.  List `rows`: iterate i from 0..m, j from 0..n. if 1, add i.
2.  List `cols`: iterate j from 0..n, i from 0..m. if 1, add j. (Iterate j outer to get sorted).
3.  `minTotal(List)`: two pointers `i=0, j=size-1`. `sum += list.get(j) - list.get(i)`. `i++, j--`.

---
