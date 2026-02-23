# Analysis for Sqrt(x)
# *Phân tích cho bài toán Tính Căn Bậc Hai*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Non-negative integer `x`. *Số nguyên không âm `x`.*
*   **Output:** Integer `floor(sqrt(x))`. *Số nguyên `floor(sqrt(x))`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `x` up to `Integer.MAX_VALUE`. Multiplying two large numbers can overflow. Use `long` for intermediate calculations.
*   *`x` lên đến `Integer.MAX_VALUE`. Việc nhân hai số lớn có thể gây tràn số. Sử dụng `long` cho các bước tính toán trung gian.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Binary Search
### *Hướng tiếp cận: Tìm kiếm nhị phân*

*   **Intuition:** The square root of `x` must be between 0 and `x`. For `x >= 1`, it's between 1 and `x`. We can use binary search to find the largest integer `y` such that `y*y <= x`.
*   *Ý tưởng: Căn bậc hai của `x` phải nằm trong khoảng từ 0 đến `x`. Đối với `x >= 1`, nó nằm trong khoảng từ 1 đến `x`. Chúng ta có thể sử dụng tìm kiếm nhị phân để tìm số nguyên `y` lớn nhất sao cho `y*y <= x`.*

*   **Algorithm Steps:**
    1.  Handle `x < 2`: return `x`.
    2.  `left = 2`, `right = x / 2`.
    3.  While `left <= right`:
        *   `pivot = left + (right - left) / 2`.
        *   `num = pivot * pivot`.
        *   If `num > x`: `right = pivot - 1`.
        *   Else if `num < x`: `left = pivot + 1`.
        *   Else: return `pivot`.
    4.  Return `right`.

*   **Complexity:**
    *   Time: $O(\log X)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`x = 8`
1. `left=2, right=4`.
2. `pivot=3`. `3*3 = 9 > 8`. `right=2`.
3. `pivot=2`. `2*2 = 4 < 8`. `left=3`.
4. `left > right`. Stop.
Result: `right = 2`. Correct.
---
*Việc sử dụng `long` là bắt buộc để tránh lỗi tràn số khi tính `pivot * pivot`.*
Using `long` is mandatory to avoid overflow when calculating `pivot * pivot`.
