# 84. Largest Rectangle in Histogram / Hình Chữ Nhật Lớn Nhất Trong Biểu Đồ

## Problem Description / Mô tả bài toán
Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return the area of the largest rectangle in the histogram.
Cho một mảng số nguyên `heights` biểu thị chiều cao của các thanh trong biểu đồ trong đó chiều rộng của mỗi thanh là `1`, hãy trả về diện tích của hình chữ nhật lớn nhất trong biểu đồ.

### Example 1:
```text
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The largest rectangle is shown in the red area, which has an area = 10 units.
(Height 5 and 6 form a rectangle of height 5 and width 2).
```

### Example 2:
```text
Input: heights = [2,4]
Output: 4
```

## Constraints / Ràng buộc
- `1 <= heights.length <= 10^5`
- `0 <= heights[i] <= 10^4`

---

## Analysis / Phân tích

### Approach: Monotonic Stack / Ngăn Xếp Đơn Điệu
- **Idea**: For each bar, find the nearest smaller bar to the left and to the right. The width of the rectangle with current bar's height is `rightIndex - leftIndex - 1`.
- **Ý tưởng**: Đối với mỗi thanh, tìm thanh nhỏ hơn gần nhất ở bên trái và bên phải. Chiều rộng của hình chữ nhật với chiều cao của thanh hiện tại là `rightIndex - leftIndex - 1`.
- **Algorithm**:
    - Use a stack to store indices.
    - Ideally, stack keeps increasing heights.
    - When we see a bar `h` smaller than `heights[stack.peek()]`, we know we found the "right boundary" for the bar at stack top.
    - Pop the top, calculate area: `h * (i - stack.peek() - 1)`. (If stack empty, width is `i`).
    - Repeat until stack top <= current bar. Push current index.
- **Time Complexity**: O(N). Each element pushed and popped once.
- **Space Complexity**: O(N).

---

## Edge Cases / Các trường hợp biên
1.  **Ascending**: `[1,2,3]`. Stack never pops until end. Need to process remaining stack.
2.  **Descending**: `[3,2,1]`. Pops immediately.
3.  **Single Element**: `[2]` -> 2.
