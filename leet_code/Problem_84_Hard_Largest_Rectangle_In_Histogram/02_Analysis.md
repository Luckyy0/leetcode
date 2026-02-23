# Analysis for Largest Rectangle in Histogram
# *Phân tích cho bài toán Hình Chữ Nhật Lớn Nhất Trong Biểu Đồ Cột*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of integers `heights`. *Mảng các số nguyên `heights`.*
*   **Output:** Maximum rectangle area. *Diện tích hình chữ nhật tối đa.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to $10^5$. $O(n^2)$ is too slow. $O(n)$ is required.
*   Heights can be up to $10^4$.
*   *Độ dài lên đến $10^5$. $O(n^2)$ là quá chậm. $O(n)$ là bắt buộc.*
*   *Chiều cao lên tới $10^4$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Monotonic Stack
### *Hướng tiếp cận: Ngăn xếp Đơn điệu*

*   **Logic:**
    1.  For each bar `i`, the largest rectangle using `heights[i]` as the shortest bar extends to the first bar to the left and right that is shorter than it.
    2.  Use a stack to maintain indices of bars with increasing heights.
    3.  When encountering a bar `i` shorter than the bar at the top of the stack (`stack.peek()`):
        *   The bar at the top of the stack is the height of a potential rectangle.
        *   Its right boundary is `i`.
        *   Its left boundary is the new top of the stack (after popping).
    4.  To simplify, add a bar of height `0` at the end of the array to ensure all bars are processed.

*   **Algorithm Steps:**
    1.  Create a stack to store indices.
    2.  Iterate `i` from 0 to `heights.length`:
        *   `h = (i == heights.length) ? 0 : heights[i]`.
        *   While stack is not empty and `h < heights[stack.peek()]`:
            *   `height = heights[stack.pop()]`.
            *   `width = stack.isEmpty() ? i : i - stack.peek() - 1`.
            *   `maxArea = max(maxArea, height * width)`.
        *   Push `i`.
    3.  Return `maxArea`.

*   **Complexity:**
    *   Time: $O(n)$ (each index is pushed and popped exactly once).
    *   Space: $O(n)$ for the stack.

### Dry Run
### *Chạy thử*
`heights = [2, 1, 5, 6, 2, 3]`
1. `i=0, h=2`: stack `[0]`.
2. `i=1, h=1`: `1 < 2`. Pop 0. Height=2, Width=1. Area=2. Stack `[1]`.
3. `i=2, h=5`: stack `[1, 2]`.
4. `i=3, h=6`: stack `[1, 2, 3]`.
5. `i=4, h=2`:
   - `2 < 6`. Pop 3. Height=6, Width=4-2-1=1. Area=6.
   - `2 < 5`. Pop 2. Height=5, Width=4-1-1=2. Area=10.
   - `2 > 1`. Stop. Stack `[1, 4]`.
...
---
*Ngăn xếp đơn điệu là một kỹ thuật mạnh mẽ để tìm phần tử nhỏ nhất/lớn nhất ở gần nhất.*
Monotonic Stack is a powerful technique for finding the nearest smaller/larger element.
