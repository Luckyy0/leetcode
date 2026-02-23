# Analysis for Trapping Rain Water
# *Phân tích cho bài toán Hứng Nước Mưa*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of non-negative integers `height`. *Mảng các số nguyên không âm `height`.*
*   **Output:** Total units of trapped water. *Tổng đơn vị nước hứng được.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` up to $2 \times 10^4$.
*   Time complexity should be $O(n)$.
*   Space complexity should be $O(1)$ (Optimized).

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Two Pointers
### *Hướng tiếp cận: Hai Con Trỏ*

*   **Intuition:** The amount of water at any position `i` is determined by `min(max_left, max_right) - height[i]`. Instead of precomputing `max_left` and `max_right` for all positions, we can use two pointers from both ends.
*   *Ý tưởng: Lượng nước tại bất kỳ vị trí `i` nào được xác định bởi `min(max_left, max_right) - height[i]`. Thay vì tính toán trước `max_left` và `max_right` cho tất cả các vị trí, chúng ta có thể sử dụng hai con trỏ từ cả hai đầu.*

*   **Algorithm Steps:**
    1.  Initialize `left = 0`, `right = n - 1`, `left_max = 0`, `right_max = 0`, `total_water = 0`.
    2.  While `left < right`:
        *   If `height[left] < height[right]`:
            *   If `height[left] >= left_max`, update `left_max`.
            *   Else, `total_water += left_max - height[left]`.
            *   `left++`.
        *   Else:
            *   If `height[right] >= right_max`, update `right_max`.
            *   Else, `total_water += right_max - height[right]`.
            *   `right--`.
    3.  Return `total_water`.

*   **Complexity:**
    *   Time: $O(n)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`height = [4, 2, 0, 3, 2, 5]`
1.  `left=0 (4), right=5 (5)`. `4 < 5`. `left_max = 4`. `left++`.
2.  `left=1 (2), right=5 (5)`. `2 < 5`. `left_max` is 4. `water += 4 - 2 = 2`. `left++`.
3.  `left=2 (0), right=5 (5)`. `0 < 5`. `left_max` is 4. `water += 4 - 0 = 4` (Total 6). `left++`.
4.  ...
5.  Eventually calculate all trapped areas.
Result: 9.
