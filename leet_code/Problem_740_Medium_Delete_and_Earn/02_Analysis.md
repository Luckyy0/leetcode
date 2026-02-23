# Analysis for Delete and Earn
# *Phân tích cho bài toán Xóa và Nhận thưởng*

## 1. Problem Essence & Transforming to House Robber
## *1. Bản chất vấn đề & Chuyển đổi sang bài toán Kẻ trộm (House Robber)*

### The Challenge
### *Thách thức*
At first glance, the rule about deleting $x-1$ and $x+1$ after picking $x$ seems complex. However, if we group all identical values together, the problem simplifies. If we decide to take value $x$, we should take **all** occurrences of $x$ to maximize points, because they all delete the same neighbors anyway. This turns the problem into a choice: "If I take value $x$, I cannot take value $x-1$ or $x+1$."
*Thoạt nhìn, quy tắc xóa $x-1$ và $x+1$ khi chọn $x$ có vẻ phức tạp. Tuy nhiên, nếu ta nhóm tất cả các giá trị giống nhau lại, bài toán sẽ đơn giản hơn. Nếu đã chọn $x$, ta nên chọn **tất cả** các số $x$ để tối đa hóa điểm số. Điều này biến bài toán thành: "Nếu tôi chọn giá trị $x$, tôi không thể chọn giá trị $x-1$ hoặc $x+1$."*

---

## 2. Strategy: Aggregate and DP
## *2. Chiến lược: Tổng hợp và Quy hoạch động*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Bucketing:** Create an array `points` where `points[i]` is the total sum of all occurrences of value `i` in the input. For example, if `nums = [2, 2, 3]`, then `points[2] = 4` and `points[3] = 3`.
    * **Góm nhóm:** Tạo mảng `points` trong đó `points[i]` là tổng giá trị của tất cả các số `i`. Ví dụ, nếu có hai số 2, thì `points[2] = 4`.*

2.  **Dynamic Programming (House Robber style):**
    - Now we have an array where we cannot pick two adjacent indices.
    - Define `dp[i]` as the maximum points using numbers up to `i`.
    - **Transition:** `dp[i] = max(dp[i-1], dp[i-2] + points[i])`.
        - Either we skip value `i` and keep the best from `i-1`.
        - Or we take value `i`, which means we must skip `i-1` and add `points[i]` to the best from `i-2`.
    * **Quy hoạch động:** Bây giờ ta có một mảng mà không thể chọn hai chỉ số kề nhau. Công thức: `dp[i] = max(dp[i-1], dp[i-2] + points[i])`. Hoặc bỏ qua `i` để lấy kết quả của `i-1`, hoặc chọn `i` và lấy kết quả của `i-2` cộng thêm.*

3.  **Space Optimization:** We only need the previous two results (`prev1`, `prev2`) to calculate the current one, so we can use $O(1)$ extra space beyond the `points` array.
    * **Tối ưu không gian:** Chỉ cần hai biến để lưu kết quả của các bước trước đó.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$, where $N$ is the number of elements in `nums` and $M$ is the maximum value in `nums` (fixed at $10^4$). We iterate once through `nums` to fill buckets and once through `points` for DP.
    * **Độ phức tạp thời gian:** $O(N + M)$.*
*   **Space Complexity:** $O(M)$ to store the `points` array.
    * **Độ phức tạp không gian:** $O(M)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**nums = [2, 2, 3, 3, 3, 4]**
1. points: `[0, 0, 4, 9, 4]` (Indices 2, 3, 4 are 2*2, 3*3, 4*1)
2. dp[0] = 0
3. dp[1] = 0
4. dp[2] (value 2): max(0, 0 + 4) = 4
5. dp[3] (value 3): max(4, 0 + 9) = 9
6. dp[4] (value 4): max(9, 4 + 4) = 9
**Result:** 9.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Reducing a new problem to a well-known one (like House Robber) is a key skill. The "sum-by-value" bucketing strategy effectively linearizes the constraints placed on numerical values.
*Chuyển đổi một bài toán mới về một bài toán đã biết (như House Robber) là một kỹ năng quan trọng. Chiến lược gộp nhóm theo giá trị giúp làm tuyến tính hóa các ràng buộc đặt trên các con số.*
---
*Sự tích lũy (Accumulation) đôi khi đòi hỏi sự từ bỏ (Renunciation). Trong thế giới của những lựa chọn, việc giành được một giá trị (Earn) có thể buộc ta phải xóa bỏ những khả năng lân cận. Dữ liệu dạy ta rằng bằng cách tổng hợp sức mạnh từ những nguồn giống nhau (Bucketing) và cân nhắc kỹ lưỡng giữa việc nắm giữ hay buông bỏ (DP transition), ta có thể tối ưu hóa thành quả của mình giữa những ràng buộc đối nghịch.*
Accumulation (Accumulation) sometimes requires renunciation (Renunciation). In a world of choices, gaining a value (Earn) may force us to eliminate nearby possibilities. Data teaches us that by aggregating power from similar sources (Bucketing) and carefully weighing between holding or letting go (DP transition), we can optimize our achievements amidst opposing constraints.
