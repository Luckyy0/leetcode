# 554. Brick Wall / Bức Tường Gạch

## Problem Description / Mô tả bài toán
There is a rectangular brick wall in front of you with `n` rows of bricks. The `i-th` row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.
Có một bức tường gạch hình chữ nhật trước mặt bạn với `n` hàng gạch. Hàng thứ `i` có một số lượng gạch, mỗi viên có cùng chiều cao (tức là 1 đơn vị) nhưng chúng có thể có chiều rộng khác nhau. Tổng chiều rộng của mỗi hàng là như nhau.

Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall.
Vẽ một đường thẳng đứng từ trên xuống dưới và cắt qua ít viên gạch nhất. Nếu đường của bạn đi qua cạnh của một viên gạch, thì viên gạch đó không được coi là bị cắt. Bạn không thể vẽ một đường dọc theo một trong hai cạnh thẳng đứng của bức tường.

Given the 2D array `wall`, return the minimum number of crossed bricks.
Cho mảng 2D `wall`, hãy trả về số lượng gạch bị cắt tối thiểu.

### Example 1:
```text
Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
Output: 2
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap Edge Counting / Đếm Cạnh bằng HashMap
We want to pass through the max number of "gaps" (edges).
`min_crossed_bricks = total_rows - max_gaps`.

Algorithm:
1. Initialize a HashMap `gaps`.
2. For each row:
   - Initialize `current_width = 0`.
   - Iterate through bricks (except the last one):
     - `current_width += brick_width`.
     - `gaps.put(current_width, gaps.getOrDefault(current_width, 0) + 1)`.
3. Find `max_gaps` in the map.
4. Return `wall.size() - max_gaps`.

### Complexity / Độ phức tạp
- **Time**: O(Total Bricks).
- **Space**: O(Total Width) worst case, effectively O(Total Bricks).

---

## Analysis / Phân tích

### Approach: Gap Frequency Map

**Algorithm**:
1.  Iterate through each row of bricks.
2.  Calculate cumulative width for gaps.
3.  Store gap counts i HashMap.
4.  Answer is total rows minus max gap frequency.

---
