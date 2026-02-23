# Analysis for Maximum Vacation Days
# *Phân tích cho bài toán Số ngày Nghỉ tối đa*

## 1. Problem Essence & The Multi-Stage Decision
## *1. Bản chất vấn đề & Quyết định Đa giai đoạn*

### The Challenge
### *Thách thức*
We have $K$ weeks and $N$ cities. Each week, we can choose to stay in our current city or fly to a connected one. Each city offers a specific number of "vacation days" during a specific week.
*Chúng ta có $K$ tuần và $N$ thành phố. Mỗi tuần, chúng ta có thể chọn ở lại thành phố hiện tại hoặc bay tới một thành phố có kết nối. Mỗi thành phố cung cấp một số lượng "ngày nghỉ" nhất định trong một tuần cụ thể.*

The objective is to find a path through cities across $K$ weeks that maximizes the total sum of vacation days. This is a classic sequential decision problem where future gains depend on present location.
*Mục tiêu là tìm ra một lộ trình qua các thành phố trong suốt $K$ tuần sao cho tối đa hóa tổng số ngày nghỉ. Đây là một bài toán quyết định tuần tự điển hình, nơi lợi ích trong tương lai phụ thuộc vào vị thế ở hiện tại.*

---

## 2. Strategy: Forward Dynamic Programming (State Evolution)
## *2. Chiến lược: Quy hoạch động Tiến (Sự tiến hóa của Trạng thái)*

We can think of this as moving through a multi-layered graph where each layer represents a week.
*Chúng ta có thể coi đây là việc di chuyển qua một đồ thị nhiều lớp, trong đó mỗi lớp đại diện cho một tuần.*

### State Definition
### *Định nghĩa Trạng thái*
`dp[i]`: The maximum vacation days possible if the employee ends the *current* week in city `i`.
*`dp[i]`: Số ngày nghỉ tối đa có thể đạt được nếu nhân viên kết thúc tuần *hiện tại* ở thành phố `i`.*

### Transition Logic
### *Logic Chuyển trạng thái*
For each week `w` from 0 to $K-1$:
*Đối với mỗi tuần `w` từ 0 đến $K-1$:*

1.  **Preparation:** Create a `next_dp` array initialized to $-\infty$. This array will store the best results for the *end* of week `w`.
    * **Chuẩn bị:** Tạo một mảng `next_dp` được khởi tạo bằng $-\infty$. Mảng này sẽ lưu trữ các kết quả tốt nhất cho *thời điểm cuối* của tuần `w`.*

2.  **Trial Flight:** For every target city `j`:
    * **Thử bay:** Đối với mọi thành phố mục tiêu `j`:*
    - For every potential source city `i` from the *previous* week:
    - *Đối với mọi thành phố xuất phát `i` tiềm năng từ tuần *trước*:*
    - If `i == j` (Stay) OR `flights[i][j] == 1` (Fly):
    - *Nếu `i == j` (Ở lại) HOẶC `flights[i][j] == 1` (Bay):*
    - The new candidate value is `dp[i] + days[j][w]`.
    - *Giá trị ứng cử viên mới là `dp[i] + days[j][w]`.*
    - `next_dp[j] = max(next_dp[j], candidate_value)`.

3.  **Progression:** Update `dp = next_dp` and proceed to the next week.
    * **Tiến triển:** Cập nhật `dp = next_dp` và chuyển sang tuần tiếp theo.*

---

## 3. Structural Advantages & Space Compression
## *3. Ưu điểm Cấu trúc & Nén không gian*

*   **Optimal Substructure:** We build week $w$ solely based on the optimal values of week $w-1$.
    * **Cấu trúc con tối ưu:** Chúng ta xây dựng tuần $w$ duy nhất dựa trên các giá trị tối ưu của tuần $w-1$.*
*   **Space Compression:** Instead of a 2D table `dp[K][N]`, we only need two 1D arrays of size $N$. This reduces space from $O(KN)$ to $O(N)$.
    * **Nén không gian:** Thay vì một bảng 2D `dp[K][N]`, chúng ta chỉ cần hai mảng 1D kích thước $N$. Điều này làm giảm không gian từ $O(KN)$ xuống $O(N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K \times N^2)$. For each of the $K$ weeks, we iterate through $N$ possible target cities, and for each target, we check $N$ possible source cities.
    * **Độ phức tạp thời gian:** $O(K \times N^2)$. Đối với mỗi tuần trong số $K$ tuần, chúng ta lặp qua $N$ thành phố mục tiêu khả dĩ, và với mỗi mục tiêu, chúng ta kiểm tra $N$ thành phố nguồn khả dĩ.*
*   **Space Complexity:** $O(N)$. We only store the results of the current and previous states.
    * **Độ phức tạp không gian:** $O(N)$. Chúng ta chỉ lưu trữ kết quả của các trạng thái hiện tại và trước đó.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** 3 Cities, 2 Weeks. Start City 0.
- **Initial:** `dp = [0, -inf, -inf]`
- **Week 0:**
  - To City 0: From 0 (Stay). `dp[0] + days[0][0]`.
  - To City 1: From 0 (Fly). `dp[0] + days[1][0]`.
  - ... and so on.
- **Week 1:**
  - To City 0: Could be from 0 (Stay), from 1 (Fly), or from 2 (Fly).
  - Pick the maximum of all valid arrivals.
- **Finish:** Return `max(dp)`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use Iterative DP with state compression for pathfinding problems where history can be summarized by the current location.
*Sử dụng DP lặp với nén trạng thái cho các bài toán tìm đường nơi mà lịch sử có thể được tóm gọn bằng vị trí hiện tại.*
---
*Số ngày nghỉ (Vacation days) là phần thưởng cho những lựa chọn di chuyển đúng đắn. Trong một mạng lưới các chuyến bay (Flights), việc biết khi nào nên đi, khi nào nên ở lại (Stay) chính là nghệ thuật tối ưu hóa cuộc đời. Đôi khi, một hành trình rắc rối (Complex path) lại dẫn tới sự thư thái (Max vacation) tuyệt vời nhất.*
Vacation days (Vacation days) are a reward for the right travel choices. In a network of flights (Flights), knowing when to go and when to stay (Stay) is the art of life optimization. Sometimes, a troublesome journey (Complex path) leads to the most wonderful relaxation (Max vacation).
