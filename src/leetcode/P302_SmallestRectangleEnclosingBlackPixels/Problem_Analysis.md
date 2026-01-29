# 302. Smallest Rectangle Enclosing Black Pixels / Hình Chữ Nhật Nhỏ Nhất Bao Quanh Các Pixel Đen

## Problem Description / Mô tả bài toán
You are given an `m x n` binary matrix `image` where `0` represents a white pixel and `1` represents a black pixel.
Bạn được cung cấp một ma trận nhị phân `image` kích thước `m x n` trong đó `0` đại diện cho pixel trắng và `1` đại diện cho pixel đen.

The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location `(x, y)` of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
Các pixel đen được kết nối, nghĩa là chỉ có một vùng đen. Các pixel được kết nối theo chiều ngang và dọc. Cho vị trí `(x, y)` của một trong những pixel đen, trả về diện tích của hình chữ nhật nhỏ nhất (thẳng hàng với trục) bao quanh tất cả các pixel đen.

### Example 1:
```text
Input: image = [["0","0","1","0"],["0","1","1","0"],["0","1","0","0"]], x = 0, y = 2
Output: 6
Explanation: The black pixels are at (0, 2), (1, 1), (1, 2), (2, 1).
The smallest rectangle enclosing all is [0, 2] x [1, 2], width = 2, height = 3. Area = 6.
Wait, Rect runs from x=0 to x=2, y=1 to y=2?
Rows indices of black: {0, 1, 2} -> Top=0, Bottom=2. Height = 2 - 0 + 1 = 3.
Col indices of black: {1, 2} -> Left=1, Right=2. Width = 2 - 1 + 1 = 2.
Area = 3 * 2 = 6.
```

### Example 2:
```text
Input: image = [["1"]], x = 0, y = 0
Output: 1
```

## Constraints / Ràng buộc
- `m == image.length`
- `n == image[i].length`
- `1 <= m, n <= 100`
- `image[i][j]` is either `'0'` or `'1'`.
- `1 <= x < m`
- `1 <= y < n`
- `image[x][y] == '1'`.
- The black pixels in the `image` only form one component.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Projection and Binary Search / Chiếu và Tìm Kiếm Nhị Phân
Since all black pixels are connected, if we project them onto the X-axis (creating a 1D array where value is 1 if row has any black pixel), the 1s will form a continuous block. Same for Y-axis.
- We have a seed point `(x, y)`.
- We want to find:
    1.  **Top**: Smallest row index `i <= x` such that row `i` has a black pixel.
    2.  **Bottom**: Largest row index `i >= x` such that row `i` has a black pixel.
    3.  **Left**: Smallest col index `j <= y` such that col `j` has a black pixel.
    4.  **Right**: Largest col index `j >= y` such that col `j` has a black pixel.

Because of the connectivity (and thus convexity of projection), we can use **Binary Search**.
- **Find Top**: Search in range `[0, x]`. Condition `hasBlackInRow(mid)`. We want first true.
- **Find Bottom**: Search in range `[x, m]`. Condition `hasBlackInRow(mid)`. We want last true (or first false - 1).

**Check Function**:
- `hasBlackInRow(row)`: Iterate column 0 to n. O(N).
- `hasBlackInCol(col)`: Iterate row 0 to m. O(M).

Total Complexity: `O(N log M + M log N)`. (Check takes O(N), BS takes log M steps).
Compared to BFS `O(MN)`, this is faster if M, N large.

### Complexity / Độ phức tạp
- **Time**: O(N log M + M log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: 4 Binary Searches

**Searching Boundaries**:
1.  **Top**: Range `[0, x]`. Find first `r` where row `r` has '1'.
2.  **Bottom**: Range `[x + 1, m]`. Find first `r` where row `r` has NO '1'. Bottom is `r - 1`.
3.  **Left**: Range `[0, y]`. Find first `c` where col `c` has '1'.
    - *Optimization*: Check row range `[top, bottom]` instead of `[0, m]`? Yes, black pixel must be within known vertical bounds.
4.  **Right**: Range `[y + 1, n]`. Find first `c` where col `c` has NO '1'. Right is `c - 1`.

---
