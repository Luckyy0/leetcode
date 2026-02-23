# Analysis for Median of Two Sorted Arrays
# *Phân tích cho bài toán Trung vị của Hai Mảng Đã Sắp Xếp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two sorted arrays `nums1` and `nums2`. *Hai mảng đã sắp xếp `nums1` và `nums2`.*
*   **Output:** A `double` value representing the median. *Một giá trị `double` đại diện cho trung vị.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Time complexity must be $O(\log(m+n))$. This rules out merging the arrays ($O(n+m)$). *Độ phức tạp thời gian phải là $O(\log(m+n))$. Điều này loại trừ việc gộp mảng ($O(n+m)$).*
*   We must use **Binary Search**. *Chúng ta phải sử dụng **Tìm kiếm Nhị phân**.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Binary Search on Partition
### *Hướng tiếp cận: Tìm kiếm Nhị phân trên Phân hoạch*

*   **Intuition:** The median divides the combined set of numbers into two equal halves. We try to find a partition line in `nums1` and `nums2` such that:
    *Ý tưởng: Trung vị chia tập hợp các số đã gộp thành hai nửa bằng nhau. Chúng ta cố gắng tìm một đường phân chia trong `nums1` và `nums2` sao cho:*
    1.  The number of elements on the left side is equal to (or 1 greater than) the right side. *Số lượng phần tử ở phía bên trái bằng (hoặc lớn hơn 1 so với) phía bên phải.*
    2.  All elements on the left side $\le$ All elements on the right side. *Tất cả phần tử bên trái $\le$ Tất cả phần tử bên phải.*

*   **Logic:**
    *   Assume `m <= n` (if not, swap `nums1` and `nums2`). We binary search on `nums1`. *Giả sử `m <= n` (nếu không, đổi chỗ `nums1` và `nums2`). Chúng ta tìm kiếm nhị phân trên `nums1`.*
    *   Condition: `maxLeftX <= minRightY` AND `maxLeftY <= minRightX`.
    *   `partitionX` is the cut index in `nums1`. `partitionY` is calculated based on total length. *`partitionX` là chỉ số cắt trong `nums1`. `partitionY` được tính dựa trên tổng độ dài.*
    *   If valid, calculate median from the boundary values. *Nếu hợp lệ, tính trung vị từ các giá trị biên.*
    *   If `maxLeftX > minRightY`, move left in `nums1` (high = partitionX - 1).
    *   If `maxLeftY > minRightX`, move right in `nums1` (low = partitionX + 1).

*   **Complexity:**
    *   Time: $O(\log(\min(m, n)))$. *Thời gian: $O(\log(\min(m, n)))$.*
    *   Space: $O(1)$. *Không gian: $O(1)$.*

### Dry Run
### *Chạy thử*
`nums1 = [1, 3]`, `nums2 = [2]`. `m=2, n=1`. Swap -> `nums1=[2], nums2=[1, 3]`. `m=1, n=2`.
Total `len = 3`. Half = `(1 + 2 + 1) / 2 = 2`.

1.  **BS range:** `[0, 1]`. `mid (partX) = 0`. `partY = 2 - 0 = 2`.
    *   LeftX = $-\infty$, RightX = 2.
    *   LeftY = 3 (`nums2[1]`), RightY = $\infty$.
    *   Check: $-\infty \le \infty$ (OK), $3 \le 2$ (FAIL).
    *   `LeftY > RightX` -> Move right. `low = 1`.
2.  **BS range:** `[1, 1]`. `mid (partX) = 1`. `partY = 2 - 1 = 1`.
    *   LeftX = 2, RightX = $\infty$.
    *   LeftY = 1 (`nums2[0]`), RightY = 3.
    *   Check: $2 \le 3$ (OK), $1 \le \infty$ (OK). Valid!
    *   Odd length: Max of lefts = `max(2, 1) = 2`. Return 2.0.
