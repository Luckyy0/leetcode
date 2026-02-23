# Analysis for Maximum Product of Three Numbers
# *Phân tích cho bài toán Tích Lớn nhất của Ba số*

## 1. Problem Essence & Sign Combinations
## *1. Bản chất vấn đề & Các Kết hợp Dấu*

### The Challenge
### *Thách thức*
Finding the maximum product of three numbers is not as simple as picking the three largest numbers, because the array may contain negative numbers.
*Việc tìm tích lớn nhất của ba số không đơn giản chỉ là chọn ba số lớn nhất, vì mảng có thể chứa các số âm.*

A large positive product can be formed in two main ways:
*Một tích dương lớn có thể được tạo ra theo hai cách chính:*
1.  **Three largest positive numbers:** (positive) * (positive) * (positive).
2.  **Two smallest negative numbers and one largest positive number:** (negative) * (negative) * (positive).

---

## 2. Strategy: Tracking Extremes
## *2. Chiến lược: Theo dõi các Cực trị*

Instead of sorting ($O(N \log N)$), we can iterate once ($O(N)$) to find:
*Thay vì sắp xếp ($O(N \log N)$), chúng ta có thể duyệt một lần ($O(N)$) để tìm:*
1.  The three largest numbers: `max1`, `max2`, `max3`.
2.  The two smallest numbers (which could be the most negative): `min1`, `min2`.

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialization:** Set global maxes to infinity-small and global mins to infinity-large.
    * **Khởi tạo:** Đặt các giá trị cực đại toàn cục là vô cùng bé và các giá trị cực tiểu toàn cục là vô cùng lớn.*

2.  **Single Pass Scan:** Update the five variables as we iterate through `nums`.
    * **Quét một lần:** Cập nhật năm biến này khi chúng ta duyệt qua `nums`.*

3.  **Compete:** Compare the two potential candidates for the maximum product:
    * **So sánh:** So sánh hai ứng cử viên tiềm năng cho tích lớn nhất:*
    - `candidate1 = max1 * max2 * max3`
    - `candidate2 = min1 * min2 * max1` (Two negatives becoming positive)

4.  **Result:** `Math.max(candidate1, candidate2)`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Efficiency:** Finding a fixed number of extremes $k$ is always $O(N)$. Sorting is unnecessary if $k$ is small.
    * **Hiệu suất Tuyến tính:** Việc tìm một số lượng cố định $k$ các cực trị luôn là $O(N)$. Sắp xếp là không cần thiết nếu $k$ nhỏ.*
*   **Sign Handling:** Even if all numbers are negative, the math holds. `max1 * max2 * max3` would be the least negative (largest math value).
    * **Xử lý Dấu:** Ngay cả khi tất cả các số đều âm, toán học vẫn đúng. `max1 * max2 * max3` sẽ là số âm ít nhất (giá trị toán học lớn nhất).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the number of elements. We scan the array exactly once.
    * **Độ phức tạp thời gian:** $O(N)$ trong đó $N$ là số lượng phần tử. Chúng ta quét mảng chính xác một lần.*
*   **Space Complexity:** $O(1)$ extra space to store the five variables.
    * **Độ phức tạp không gian:** $O(1)$ không gian bổ sung để lưu trữ năm biến.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [-10, -10, 1, 3, 2]
1. Finding 3 Largest: 3, 2, 1.
2. Finding 2 Smallest: -10, -10.
3. Candidate 1: 3 * 2 * 1 = 6.
4. Candidate 2: (-10) * (-10) * 3 = 300.
**Result:** 300.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For problems involving the maximum product, always consider the impact of negative numbers. A pair of negative numbers can create a massive positive contribution. Tracking a few key extremes is often more efficient than an expensive sort.
*Đối với các bài toán liên quan đến tích lớn nhất, hãy luôn xem xét tác động của các số âm. Một cặp số âm có thể tạo ra một đóng góp dương cực lớn. Việc theo dõi một vài cực trị then chốt thường hiệu quả hơn việc sắp xếp tốn kém.*
---
*Đỉnh cao (Maximum) không chỉ thuộc về những kẻ lớn nhất, mà còn thuộc về sự kết hợp khéo léo của các thái cực. Trong toán học, hai thực thể tiêu cực (Negative numbers) có thể cùng nhau tạo nên một sức mạnh tích cực (Positive product). Dữ liệu dạy ta rằng sự đa dạng (Diversity of extremes) là mấu chốt để tìm thấy giá trị tối ưu nhất.*
The peak (Maximum) does not only belong to the biggest, but also to the clever combination of extremes. In mathematics, two negative entities (Negative numbers) can together create a positive power (Positive product). Data teaches us that diversity (Diversity of extremes) is the key to finding the most optimal value.
