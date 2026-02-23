# Analysis for Container With Most Water
# *Phân tích cho bài toán Thùng Chứa Nhiều Nước Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `height`. *Mảng `height`.*
*   **Output:** Integer `maxArea`. *Số nguyên `maxArea`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` up to $10^5$.
*   $O(N^2)$ brute force (checking all pairs) is roughly $10^{10}$ operations -> Time Limit Exceeded.
    *$O(N^2)$ vét cạn (kiểm tra mọi cặp) là khoảng $10^{10}$ phép tính -> Lỗi Quá Thời Gian.*
*   Must use $O(N)$ approach.
    *Phải dùng phương pháp $O(N)$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Two Pointers (Greedy)
### *Hướng tiếp cận: Hai Con Trỏ (Tham lam)*

*   **Intuition:** Area is calculated by $\min(height[left], height[right]) \times (right - left)$.
    *Ý tưởng: Diện tích được tính bằng $\min(height[left], height[right]) \times (right - left)$.*
*   We want to maximize both width and height.
    *Chúng ta muốn tối đa hóa cả chiều rộng và chiều cao.*
*   Start with maximum width (pointers at both ends).
    *Bắt đầu với chiều rộng tối đa (con trỏ ở hai đầu).*
*   **Greedy Logic:** The height of the container is limited by the *shorter* line. Moving the taller line inward will essentially never increase the area (width decreases, height is still limited by the existing short line). Moving the shorter line *might* find a taller line, potentially increasing area despite width decrease.
    *Logic Tham lam: Chiều cao của thùng chứa bị giới hạn bởi đường *ngắn hơn*. Di chuyển đường cao hơn vào trong về cơ bản sẽ không bao giờ làm tăng diện tích (chiều rộng giảm, chiều cao vẫn bị giới hạn bởi đường ngắn hiện tại). Di chuyển đường ngắn hơn *có thể* tìm thấy đường cao hơn, có khả năng làm tăng diện tích mặc dù chiều rộng giảm.*

*   **Algorithm Steps:**
    1.  Initialize `left = 0`, `right = n - 1`.
    2.  `maxArea = 0`.
    3.  Loop while `left < right`:
        *   Calculate `currentArea`.
        *   Update `maxArea`.
        *   If `height[left] < height[right]`: `left++`.
        *   Else: `right--`.
    4.  Return `maxArea`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[1, 8, 6, 2, 5, 4, 8, 3, 7]`
1.  L=0(1), R=8(7). Area = 1 * 8 = 8. Move L (1 < 7).
2.  L=1(8), R=8(7). Area = 7 * 7 = 49. Move R (8 > 7).
3.  L=1(8), R=7(3). Area = 3 * 6 = 18. Move R.
... and so on.
