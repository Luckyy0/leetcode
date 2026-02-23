# Analysis for Shortest Unsorted Continuous Subarray
# *Phân tích cho bài toán Mảng con Liên tục Ngắn nhất chưa sắp xếp*

## 1. Problem Essence & The Boundary of Chaos
## *1. Bản chất vấn đề & Ranh giới của sự Hỗn loạn*

### The Challenge
### *Thách thức*
We are looking for a window $[L, R]$ such that all elements before $L$ and all elements after $R$ are already in their correct sorted positions.
*Chúng ta đang tìm kiếm một cửa sổ $[L, R]$ sao cho tất cả các phần tử trước $L$ và tất cả các phần tử sau $R$ đã nằm đúng vị trí được sắp xếp của chúng.*

An element is in its correct place if it is greater than or equal to everything to its left, and less than or equal to everything to its right.
*Một phần tử ở đúng vị trí nếu nó lớn hơn hoặc bằng mọi thứ bên trái nó, và nhỏ hơn hoặc bằng mọi thứ bên phải nó.*

---

## 2. Strategy: Dual-Pass Bound Finding (Linear Scan)
## *2. Chiến lược: Tìm Ranh giới Hai lượt (Quét tuyến tính)*

While sorting the array and comparing indices works ($O(N \log N)$), we can achieve a more efficient solution in $O(N)$ by tracking the maximum and minimum values encountered during a scan.
*Mặc dù việc sắp xếp mảng và so sánh các chỉ số có thể thực hiện được ($O(N \log N)$), chúng ta có thể đạt được giải pháp hiệu quả hơn trong $O(N)$ bằng cách theo dõi các giá trị lớn nhất và nhỏ nhất gặp phải trong quá trình quét.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Find the Right Boundary (`end`):** Iterate from left to right.
    * **Tìm Ranh giới Phải (`end`):** Duyệt từ trái sang phải.*
    - Maintain a `maxSoFar`. If the current element `nums[i]` is smaller than `maxSoFar`, it means `nums[i]` is out of order and must be part of the unsorted subarray. Update `end = i`.
    - *Duy trì một `maxSoFar`. Nếu phần tử hiện tại `nums[i]` nhỏ hơn `maxSoFar`, điều đó có nghĩa là `nums[i]` nằm sai thứ tự và phải là một phần của mảng con chưa sắp xếp. Cập nhật `end = i`.*

2.  **Find the Left Boundary (`start`):** Iterate from right to left.
    * **Tìm Ranh giới Trái (`start`):** Duyệt từ phải sang trái.*
    - Maintain a `minSoFar`. If the current element `nums[i]` is larger than `minSoFar`, it means `nums[i]` is out of order. Update `start = i`.
    - *Duy trì một `minSoFar`. Nếu phần tử hiện tại `nums[i]` lớn hơn `minSoFar`, điều đó có nghĩa là `nums[i]` nằm sai thứ tự. Cập nhật `start = i`.*

3.  **Result Calculation:** If `end > start`, return `end - start + 1`. Otherwise, return 0.
    * **Tính toán kết quả:** Nếu `end > start`, trả về `end - start + 1`. Ngược lại, trả về 0.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Efficiency:** We avoid the overhead of sorting by leveraging the property that any element in the "middle" that violates the monotonic property defines the boundaries.
    * **Hiệu quả Tuyến tính:** Chúng ta tránh được chi phí sắp xếp bằng cách tận dụng thuộc tính rằng bất kỳ phần tử nào ở "giữa" vi phạm thuộc tính đơn điệu đều xác định ranh giới.*
*   **Minimal Space:** The algorithm only requires a few pointers, making it $O(1)$ in extra space.
    * **Không gian tối thiểu:** Thuật toán chỉ yêu cầu một vài con trỏ, làm cho nó tốn $O(1)$ không gian phụ trợ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We perform two linear passes over the array.
    * **Độ phức tạp thời gian:** $O(N)$. Chúng ta thực hiện hai lượt quét tuyến tính qua mảng.*
*   **Space Complexity:** $O(1)$. No extra data structures are used.
    * **Độ phức tạp không gian:** $O(1)$. Không sử dụng cấu trúc dữ liệu bổ sung nào.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `[2, 6, 4, 8, 10, 9, 15]`
- **Pass 1 (Right to Left):**
  - maxSoFar = 2, 6, 6 (4 < 6! end=2), 8, 10, 10 (9 < 10! end=5), 15.
  - Final `end = 5`.
- **Pass 2 (Left to Right):**
  - minSoFar = 15, 9, 9, 9 (8 < 9! no), 8, 4, 4 (6 > 4! start=1), 2.
  - Final `start = 1`.
- **Result:** 5 - 1 + 1 = 5. Subarray is `[6, 4, 8, 10, 9]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use the two-scan approach with max/min tracking for boundary detection in arrays that should be sorted.
*Sử dụng phương pháp quét hai lượt với theo dõi max/min để phát hiện ranh giới trong các mảng cần được sắp xếp.*
---
*Trật tự (Order) là sự ổn định của dòng chảy. Khi một phần tử đi ngược lại xu thế chung (Smaller than Max or Larger than Min), nó tạo ra một vùng hỗn loạn (Unsorted). Để khôi phục lại sự hài hòa, ta cần xác định chính xác nơi sự bình yên kết thúc (Start) và nơi trật tự bắt đầu trở lại (End).*
Order (Order) is the stability of flow. When an element goes against the general trend (Smaller than Max or Larger than Min), it creates a region of chaos (Unsorted). To restore harmony, we need to correctly identify where peace ends (Start) and where order begins again (End).
