# 447. Number of Boomerangs / Số Lượng Boomerang

## Problem Description / Mô tả bài toán
You are given `n` points in the plane that are all **distinct**, where `points[i] = [xi, yi]`. A **boomerang** is a tuple of points `(i, j, k)` such that the distance between `i` and `j` equals the distance between `i` and `k` (the order of the tuple matters).
Bạn được cho `n` điểm trên mặt phẳng đều **phân biệt**, trong đó `points[i] = [xi, yi]`. Một **boomerang** là một bộ ba các điểm `(i, j, k)` sao cho khoảng cách giữa `i` và `j` bằng khoảng cách giữa `i` và `k` (thứ tự của bộ ba là quan trọng).

Return the number of boomerangs.
Hãy trả về số lượng các boomerang.

### Example 1:
```text
Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
(Point [1,0] is at distance 1 from both [0,0] and [2,0]).
```

### Example 2:
```text
Input: points = [[1,1],[2,2],[3,3]]
Output: 2
```

## Constraints / Ràng buộc
- `n == points.length`
- `1 <= n <= 500`
- `points[i].length == 2`
- `-10^4 <= xi, yi <= 10^4`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Distance Counting with Map / Đếm khoảng cách với Map
For each point `i`, we can count how many other points `j` are at a specific distance `d`.
If there are `m` points at distance `d` from point `i`, we can pick any 2 of them to form a boomerang `(i, j, k)`.
The number of ways to pick 2 points out of `m` where order matters is `P(m, 2) = m * (m - 1)`.

Algorithm:
1. Initialize `total_boomerangs = 0`.
2. For each point `p1` in `points`:
   - Create a `Map<Integer, Integer> distanceCount`.
   - For every other point `p2`:
     - Calculate the squared distance `d^2 = (x1-x2)^2 + (y1-y2)^2`. (Squared distance avoids floating point issues).
     - Update `distanceCount[d^2]++`.
   - For each count `m` in `distanceCount.values()`:
     - `total_boomerangs += m * (m - 1)`.
3. Return `total_boomerangs`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) where N is the number of points.
- **Space**: O(N) for the map in each iteration.

---

## Analysis / Phân tích

### Approach: Distance Frequency per Point

**Algorithm**:
1.  Outer loop for each point as a pivot.
2.  Inner loop to compute distances.
3.  Calculate permutations.

---
