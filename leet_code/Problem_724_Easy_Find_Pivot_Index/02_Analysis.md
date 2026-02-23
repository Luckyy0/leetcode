# Analysis for Find Pivot Index
# *Phân tích cho bài toán Tìm Chỉ số Điểm tựa (Pivot)*

## 1. Problem Essence & Prefix Sum
## *1. Bản chất vấn đề & Tổng Tiền tố*

### The Challenge
### *Thách thức*
We need to find an index $i$ such that $\sum_{j=0}^{i-1} nums[j] = \sum_{j=i+1}^{n-1} nums[j]$. Calculating these sums repeatedly for every index would result in $O(N^2)$ time. We need a more efficient way to track the balance between the left and right sides.
*Chúng ta cần tìm một chỉ số $i$ sao cho tổng bên trái bằng tổng bên phải. Việc tính lại các tổng này cho mỗi chỉ số sẽ tốn $O(N^2)$. Ta cần một cách hiệu quả hơn để theo dõi sự cân bằng giữa hai bên.*

---

## 2. Strategy: Total Sum Observation
## *2. Chiến lược: Quan sát Tổng cộng*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Calculate Total Sum:** First, find the sum of all elements in the array: `totalSum`.
    * **Tính Tổng cộng:** Trước tiên, tính tổng của toàn bộ phần tử trong mảng.*

2.  **Iterate and Compare:** Use a variable `leftSum` to keep track of the cumulative sum of elements seen so far. For each element `nums[i]`:
    - The right sum can be derived as: `rightSum = totalSum - leftSum - nums[i]`.
    - Check if `leftSum == rightSum`. If true, return $i$.
    - Add `nums[i]` to `leftSum` and move to the next index.
    * **Duyệt và So sánh:** Sử dụng biến `leftSum` để theo dõi tổng tích lũy bên trái. Tại mỗi phần tử, tổng bên phải sẽ là `totalSum - leftSum - nums[i]`. Nếu hai bên bằng nhau, ta tìm được điểm tựa.*

3.  **Failure Case:** If the loop completes without a match, return `-1`.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of elements. We pass through the array twice (once for total sum, once for comparison).
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$ as we only store a few sum variables.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**nums = [1, 7, 3, 6, 5, 6]**
`totalSum` = 28
- i = 0 (1): leftSum = 0, rightSum = 28-0-1 = 27. (0 != 27)
- i = 1 (7): leftSum = 1, rightSum = 28-1-7 = 20. (1 != 20)
- i = 2 (3): leftSum = 8, rightSum = 28-8-3 = 17. (8 != 17)
- i = 3 (6): leftSum = 11, rightSum = 28-11-6 = 11. (11 == 11) -> **Found!**

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Using the formula `rightSum = totalSum - leftSum - current` is a standard optimization that turns any "prefix vs suffix" comparison problem into a linear scan with constant space.
*Sử dụng công thức tính tổng bên phải dựa trên tổng cộng và tổng bên trái là kỹ thuật tối ưu hóa tiêu chuẩn giúp biến bài toán so sánh tiền tố/hậu tố thành duyệt tuyến tính với không gian hằng số.*
---
*Sự cân bằng (Balance) là trung tâm của mọi sự vận động. Trong dòng chảy của những con số, điểm tựa (Pivot) là nơi áp lực từ cả hai phía triệt tiêu lẫn nhau, tạo nên một khoảnh khắc của sự tĩnh lặng. Dữ liệu dạy ta rằng bằng cách thấu hiểu cái toàn thể (Total sum) và quan sát sự tích lũy (Left sum), ta có thể xác định được mắt bão của sự ổn định mà không cần phải cân đo đong đếm quá nhiều lần.*
Balance (Balance) is the center of all movement. In the flow of numbers, the anchor (Pivot) is where the pressure from both sides cancels out, creating a moment of stillness. Data teaches us that by understanding the whole (Total sum) and observing the accumulation (Left sum), we can identify the eye of the storm of stability without having to measure and count too many times.
