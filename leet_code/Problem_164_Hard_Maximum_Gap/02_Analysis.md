# Analysis for Maximum Gap
# *Phân tích cho bài toán Khoảng cách tối đa*

## 1. Problem Essence & Complexity Constraints
## *1. Bản chất vấn đề & Ràng buộc độ phức tạp*

### The Paradox
### *Sự nghịch lý*
We need to find the maximum gap between elements in their **sorted form**. Standard comparison-based sorting takes $O(N \log N)$. However, the problem explicitly demands **linear time $O(N)$**.
*Chúng ta cần tìm khoảng cách lớn nhất giữa các phần tử trong dạng **đã sắp xếp**. Sắp xếp dựa trên so sánh tiêu chuẩn tốn $O(N \log N)$. Tuy nhiên, đề bài yêu cầu rõ ràng **thời gian tuyến tính $O(N)$***.*

To achieve $O(N)$, we must look beyond comparison sorts and consider distribution-based sorts like **Bucket Sort** or **Radix Sort**.
*Để đạt được $O(N)$, chúng ta phải nhìn xa hơn các phép sắp xếp so sánh và xem xét các phép sắp xếp dựa trên phân phối như **Sắp xếp theo thùng (Bucket Sort)** hoặc **Sắp xếp cơ số (Radix Sort)***.*

---

## 2. Approach: The Bucket Sort & Pigeonhole Principle
## *2. Hướng tiếp cận: Sắp xếp theo thùng & Nguyên lý chuồng bồ câu*

### The Key Insight
### *Kiến thức cốt lõi*
If we have $N$ elements spanning from $min$ to $max$, the average gap between successive sorted elements is $G = (max - min) / (N - 1)$. 
*Nếu chúng ta có $N$ phần tử trải dài từ $min$ đến $max$, khoảng cách trung bình giữa các phần tử là $G = (max - min) / (N - 1)$.*

If we create buckets of size $S < G$, we can guarantee that the **maximum gap will never happen inside a bucket**. The maximum gap must exist between the `max` of one bucket and the `min` of a subsequent non-empty bucket.
*Nếu chúng ta tạo các thùng có kích thước $S < G$, chúng ta có thể đảm bảo rằng **khoảng cách tối đa sẽ không bao giờ xảy ra bên trong một thùng**. Khoảng cách tối đa phải tồn tại giữa giá trị `max` của một thùng và giá trị `min` của một thùng không trống tiếp theo.*

### Algorithm Steps
### *Các bước thuật toán*
1.  Find the `min` and `max` values in `nums`.
2.  Calculate the `gapSize = max(1, (max - min) / (n - 1))`.
3.  Create $n$ buckets. Each bucket will only store two values: its current `min` and current `max`.
4.  Iterate through `nums`, assign each number to a bucket: `index = (nums[i] - min) / gapSize`. Update that bucket's min and max.
5.  Iterate through the sorted buckets:
    - Skip empty buckets.
    - Calculate the gap between the `current_bucket.min` and the `previous_non_empty_bucket.max`.
    - Keep track of the largest such gap.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Efficiency:** By avoiding a full sorting process and only tracking boundaries of intervals, we stay strictly within $O(N)$.
    *Hiệu quả tuyến tính: Bằng cách tránh quá trình sắp xếp đầy đủ và chỉ theo dõi ranh giới của các khoảng, chúng ta giữ vững độ phức tạp $O(N)$.*
*   **Pigeonhole Logic:** This approach elegantly handles the requirement without needing complex data structures. It's built on a solid mathematical foundation.
    *Logic chuồng bồ câu: Phương pháp này xử lý yêu cầu một cách trang nhã mà không cần các cấu trúc dữ liệu phức tạp. Nó được xây dựng trên một nền tảng toán học vững chắc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. 
    - Finding min/max: $O(N)$.
    - Filling buckets: $O(N)$.
    - Final bucket scan: $O(N)$.
    *Độ phức tạp thời gian: $O(N)$. Tìm min/max, đổ đầy thùng và quét thùng đều tốn thời gian tuyến tính.*
*   **Space Complexity:** $O(N)$. We use auxiliary arrays for bucket min and max, each of size $N$. 
    *Độ phức tạp không gian: $O(N)$. Chúng ta sử dụng các mảng bổ trợ cho min và max của từng thùng.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[3, 6, 9, 1]` ($N=4$)

1. `min=1, max=9`. 
2. `gapSize = (9 - 1) / (4 - 1) = 8 / 3 = 2`.
3. Buckets:
   - Buck 0 [1, 3): contains `1`. (Min: 1, Max: 1) -- Wait, index calc: `(1-1)/2 = 0`.
   - Buck 1 [3, 5): contains `3`. (Min: 3, Max: 3)
   - Buck 2 [5, 7): contains `6`. (Min: 6, Max: 6)
   - Buck 4 [9, ...): contains `9`. (Min: 9, Max: 9)
4. Scan:
   - Gap between Buck 1 and Buck 0: `3 - 1 = 2`.
   - Gap between Buck 2 and Buck 1: `6 - 3 = 3`.
   - Gap between Buck 4 and Buck 2: `9 - 6 = 3`.
5. **Max Gap:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Maximum Gap is a high-level problem that tests your knowledge of alternative sorting techniques. The "Bucket" insight is non-trivial; it requires moving from a "comparison" mindset to a "distribution" mindset. In practice, handle the case where `max == min` or `n < 2` early to avoid division by zero or empty processing.
*Khoảng cách tối đa là một bài toán cấp độ cao kiểm tra kiến thức của bạn về các kỹ thuật sắp xếp thay thế. Kiến thức về "Thùng" không hề đơn giản; nó yêu cầu chuyển từ tư duy "so sánh" sang tư duy "phân phối". Trong thực tế, hãy xử lý sớm trường hợp `max == min` hoặc `n < 2` để tránh chia cho không.*
---
*Những khoảng trống lớn nhất thường không nằm bên trong một khối đồng nhất, mà nằm ở ranh giới của những sự khác biệt.*
The largest gaps usually don't lie within a uniform block, but at the boundaries of differences.
