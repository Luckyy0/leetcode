# Analysis for Find Minimum in Rotated Sorted Array
# *Phân tích cho bài toán Tìm phần tử nhỏ nhất trong mảng đã sắp xếp bị xoay*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### Identifying the Inflection Point
### *Xác định điểm uốn*
In a rotated sorted array, there is exactly one point where the value decreases instead of increasing. This is the **inflection point**, and it corresponds to the **minimum element**.
- Before the inflection point: All elements are larger than the last element of the array.
- At the inflection point: We find the minimum.
- After the inflection point: All elements are smaller than the first element (if rotated).
*Trong một mảng đã sắp xếp bị xoay, có đúng một điểm mà giá trị giảm xuống thay vì tăng lên. Đây là **điểm uốn**, và nó tương ứng với **phần tử nhỏ nhất**.*

### The O(log N) Requirement
### *Yêu cầu O(log N)*
The requirement for logarithmic time immediately points to **Binary Search**. We need to adapt the standard binary search to work on a non-monotonically increasing array.
*Yêu cầu về thời gian logarit ngay lập tức hướng tới **Tìm kiếm nhị phân**. Chúng ta cần điều chỉnh tìm kiếm nhị phân tiêu chuẩn để hoạt động trên một mảng không tăng đơn điệu.*

---

## 2. Approach: Binary Search with Right-Comparison
## *2. Hướng tiếp cận: Tìm kiếm nhị phân so sánh với bên phải*

### Logic
### *Logic*
To find the minimum, we compare the middle element `nums[mid]` with the rightmost element `nums[right]`. This is superior to comparing with the left because it clearly distinguishes which half contains the "drop" (inflection point).
*Để tìm giá trị nhỏ nhất, chúng ta so sánh phần tử giữa `nums[mid]` với phần tử ngoài cùng bên phải `nums[right]`. Cách này ưu việt hơn so với so sánh với bên trái vì nó phân biệt rõ ràng nửa nào chứa "điểm rơi" (điểm uốn).*

1.  **Case 1: `nums[mid] > nums[right]`**
    - This means the right half is unsorted and contains the inflection point.
    - Example: `[4, 5, 6, 7, 0, 1, 2]`. `mid` is 7, `right` is 2. `7 > 2`. The minimum must be after 7.
    - Action: `left = mid + 1`.
2.  **Case 2: `nums[mid] < nums[right]`**
    - This means the right half is sorted. The minimum could be `mid` itself or somewhere to the left.
    - Example: `[4, 5, 0, 1, 2, 3]`. `mid` is 0, `right` is 3. `0 < 3`. The minimum is `mid` or before.
    - Action: `right = mid`. (We don't do `mid - 1` because `mid` itself might be the minimum).

Loop continues while `left < right`. When they meet, we have found the minimum.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficiency:** By halving the search space at each step, we reach the result in at most $\log_2 N$ steps.
    *Hiệu quả: Bằng cách chia đôi không gian tìm kiếm ở mỗi bước, chúng ta đạt được kết quả trong tối đa $\log_2 N$ bước.*
*   **Unique Elements:** Because all elements are unique, we don't have to worry about cases where `nums[mid] == nums[right]`, which would make it impossible to determine which direction to go (a scenario addressed in Part II).
    *Các phần tử duy nhất: Vì tất cả các phần tử là duy nhất, chúng ta không phải lo lắng về trường hợp `nums[mid] == nums[right]`, vốn sẽ khiến việc xác định hướng đi trở nên bất khả thi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$. Standard binary search complexity.
    *Độ phức tạp thời gian: $O(\log N)$. Độ phức tạp tìm kiếm nhị phân tiêu chuẩn.*
*   **Space Complexity:** $O(1)$. We only use a few pointer variables.
    *Độ phức tạp không gian: $O(1)$. Chúng ta chỉ sử dụng một vài biến con trỏ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[3, 4, 5, 1, 2]`

1.  `left = 0, right = 4`. `mid = 2`. `nums[2] = 5`.
2.  `5 > nums[4]` (2)? Yes.
3.  `left = mid + 1 = 3`.
4.  `left = 3, right = 4`. `mid = 3`. `nums[3] = 1`.
5.  `1 < nums[4]` (2)? Yes.
6.  `right = mid = 3`.
7.  `left == right == 3`. Stop.

**Result:** `nums[3]` = 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Binary search is not just for finding a specific value; it's for any range where we can discard half based on a property. In rotated arrays, comparing with the `right` boundary is the most robust property. Always pay attention to whether `mid` should be included or excluded (`mid` vs `mid + 1`) during the range update to avoid infinite loops or missing the answer.
*Tìm kiếm nhị phân không chỉ để tìm một giá trị cụ thể; nó dành cho bất kỳ phạm vi nào mà chúng ta có thể loại bỏ một nửa dựa trên một thuộc tính. Trong mảng xoay, so sánh với ranh giới bên `phải` là thuộc tính mạnh mẽ nhất. Luôn chú ý xem `mid` nên được bao gồm hay loại trừ trong khi cập nhật phạm vi để tránh vòng lặp vô hạn hoặc bỏ lỡ câu trả lời.*
---
*Điểm thấp nhất của một vòng quay đôi khi lại là nơi trật tự bắt đầu được tái lập.*
The lowest point of a rotation is sometimes where order begins to be re-established.
