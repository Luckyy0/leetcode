# 391. Perfect Rectangle / Hình Chữ Nhật Hoàn Hảo

## Problem Description / Mô tả bài toán
Given an array of axis-aligned rectangles `rectangles` where `rectangles[i] = [x1, y1, x2, y2]` represents an inclusive rectangle with its bottom-left corner at `(x1, y1)` and top-right corner at `(x2, y2)`, return `true` if all the rectangles together form an exact cover of a rectangular region.
Cho một mảng các hình chữ nhật vuông góc `rectangles` trong đó `rectangles[i] = [x1, y1, x2, y2]` biểu diễn một hình chữ nhật bao gồm các điểm từ `(x1, y1)` đến `(x2, y2)`. Trả về `true` nếu tất cả các hình chữ nhật cùng nhau tạo thành một vùng hình chữ nhật duy nhất không có chồng lấn và không có khoảng trống.

### Example 1:
```text
Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
Output: true
Explanation: All rectangles together form a 4x4 rectangle.
```

### Example 2:
```text
Input: rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
Output: false
Explanation: There is a gap between the two groups of rectangles.
```

## Constraints / Ràng buộc
- `1 <= rectangles.length <= 2 * 10^4`
- `rectangles[i].length == 4`
- `-10^5 <= x1, y1, x2, y2 <= 10^5`
- `x1 < x2` và `y1 < y2`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Area Sum + Corner Set / Tổng Diện Tích + Tập Các Góc
The union of rectangles forms a perfect rectangle iff:
1. The total area of all small rectangles equals the area of the bounding rectangle (minX, minY, maxX, maxY).
2. All interior corners appear an even number of times, leaving only the four corners of the bounding rectangle appearing exactly once.
We can use a `Set<String>` to store corner points as strings `"x:y"`. For each rectangle we add its four corners; if a corner already exists we remove it (pairwise cancellation). After processing all rectangles, the set should contain exactly the four corners of the bounding rectangle.

### Complexity / Độ phức tạp
- **Time**: O(N) where N = number of rectangles.
- **Space**: O(N) for the corner set (worst‑case 4N entries, but typically much smaller).

---

## Analysis / Phân tích

### Approach: Area + Corner Set

**Algorithm**:
1. Initialise `minX = INF, minY = INF, maxX = -INF, maxY = -INF` and `area = 0`.
2. For each rectangle `[x1, y1, x2, y2]`:
   - Update bounding box.
   - `area += (long)(x2 - x1) * (y2 - y1)`.
   - For each of the four corners `(x1,y1)`, `(x1,y2)`, `(x2,y1)`, `(x2,y2)`:
       - Encode as `"x:y"`.
       - If the corner is already in the set, remove it; otherwise add it.
3. After the loop, the set must contain exactly four points: the corners of the bounding rectangle.
4. Compute `expectedArea = (long)(maxX - minX) * (maxY - minY)`.
5. Return `area == expectedArea && set size == 4 && set contains the four bounding corners`.

---
