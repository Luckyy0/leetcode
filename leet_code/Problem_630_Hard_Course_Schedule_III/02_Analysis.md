# Analysis for Course Schedule III
# *Phân tích cho bài toán Lập lịch Khóa học III*

## 1. Problem Essence & Deadline Priority
## *1. Bản chất vấn đề & Ưu tiên Thời hạn*

### The Challenge
### *Thách thức*
We need to maximize the number of courses taken, where each course has a duration and a hard deadline. This is a classic scheduling problem.
*Chúng ta cần tối đa hóa số lượng khóa học tham gia, trong đó mỗi khóa học có thời lượng và một thời hạn cố định. Đây là một bài toán lập lịch kinh điển.*

The conflict arises when a long course has an early deadline, potentially blocking multiple shorter courses that share the same time window.
*Xung đột nảy sinh khi một khóa học dài có thời hạn sớm, có khả năng ngăn cản nhiều khóa học ngắn hơn trong cùng một khoảng thời gian.*

---

## 2. Strategy: Greedy Sorting and Priority Queue Replacement
## *2. Chiến lược: Sắp xếp Tham lam và Thay thế bằng Hàng đợi Ưu tiên*

The greedy choice is twofold:
1.  **Process by Deadline:** Sort courses by their `lastDay`. This ensures we always try to fit courses with tighter deadlines first.
2.  **Backtrack on Overload:** If adding a course exceeds its deadline, swap out the longest course taken so far to free up maximum time.

### Step-by-Step Logic
### *Logic từng bước*

1.  **Sorting:** Sort courses by `lastDay` in ascending order ($O(N \log N)$).
    * **Sắp xếp:** Sắp xếp các khóa học theo `lastDay` tăng dần.*

2.  **Tracking:** Use a Max-Heap (PriorityQueue) to store the durations of all courses taken so far. Maintain a `time` variable for the current total duration.
    * **Theo dõi:** Sử dụng một Max-Heap (Hàng đợi Ưu tiên) để lưu trữ thời lượng của tất cả các khóa học đã tham gia cho đến nay. Duy trì một biến `time` cho tổng thời lượng hiện tại.*

3.  **Simulation:** For each course `[dur, end]`:
    * **Mô phỏng:** Đối với mỗi khóa học `[dur, end]`:*
    - Add course duration to `time`.
    - Push duration into PriorityQueue.
    - **Check Deadline:** If `time > end`:
        - Remove the largest duration from the PriorityQueue: `time -= pq.poll()`.
        - *Bằng cách loại bỏ khóa học dài nhất, chúng ta tiết kiệm được thời gian nhiều nhất cho các khóa học tiềm năng trong tương lai mà không làm giảm tổng số lượng khóa học hiện tại.*

4.  **Result:** The size of the PriorityQueue is the answer.
    * **Kết quả:** Kích thước của Hàng đợi Ưu tiên là câu trả lời.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Greedy Correctness:** Swapping a previously accepted course for a shorter one that ends at the same or later time will *never* make the schedule worse. It only makes it easier to fit more courses later.
    * **Tính Tham lam Chính xác:** Việc hoán đổi một khóa học đã chấp nhận trước đó lấy một khóa học ngắn hơn kết thúc cùng lúc hoặc muộn hơn sẽ *không bao giờ* làm cho lịch trình tệ đi. Nó chỉ giúp dễ dàng thêm nhiều khóa học hơn sau đó.*
*   **Backtracking vs Replacement:** This isn't traditional backtracking; it's a "replacement" strategy within a greedy framework.
    * **Quay lui so với Thay thế:** Đây không phải là quay lui truyền thống; đó là chiến lược "thay thế" trong một khung tham lam.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$, where $N$ is the number of courses. Sorting takes $O(N \log N)$ and heap operations take $O(N \log N)$ total.
    * **Độ phức tạp thời gian:** $O(N \log N)$, trong đó $N$ là số lượng khóa học. Sắp xếp tốn $O(N \log N)$ và các thao tác heap tốn tổng cộng $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ for storing courses in the PriorityQueue.
    * **Độ phức tạp không gian:** $O(N)$ để lưu trữ các khóa học trong Hàng đợi Ưu tiên.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Courses:** [100,200], [1000,1250], [200,1300], [2000,3200]
1. [100,200]: time=100. fits (100<=200). PQ: [100].
2. [1000,1250]: time=1100. fits (1100<=1250). PQ: [1000, 100].
3. [200,1300]: time=1300. fits (1300<=1300). PQ: [1000, 200, 100].
4. [2000,3200]: time=3300. Fails (3300 > 3200).
   - Poll largest: 2000 vs current max 1000. Actually, 2000 is the new one.
   - Wait, if time=3300, poll 2000 from PQ. time back to 1300.
**Final PQ size:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For scheduling problems where you need to maximize the *count* of items with deadlines, sort by deadline and use a priority queue to eject the most "expensive" (longest duration) items when a limit is hit. This ensures you always maintain the leanest possible schedule.
*Đối với các bài toán lập lịch mà bạn cần tối đa hóa *số lượng* các mục có thời hạn, hãy sắp xếp theo thời hạn và sử dụng hàng đợi ưu tiên để loại bỏ các mục "đắt nhất" (thời lượng dài nhất) khi đạt đến giới hạn. Điều này đảm bảo bạn luôn duy trì một lịch trình gọn nhẹ nhất có thể.*
---
*Thời gian (Time) là hữu hạn, nhưng sự lựa chọn (Choice) là vô hạn. Trong dòng đời đầy rẫy những thời hạn (Deadlines), kẻ thông thái là kẻ biết từ bỏ những gánh nặng cồng kềnh (Long duration) để dành chỗ cho những cơ hội linh hoạt hơn. Dữ liệu dạy ta rằng sự đánh đổi (Replacement) không phải là thất bại, mà là sự đầu tư cho một lịch trình tối ưu hơn.*
Time (Time) is finite, but choice (Choice) is infinite. In a life full of deadlines (Deadlines), the wise man is the one who knows how to give up bulky burdens (Long duration) to make room for more flexible opportunities. Data teaches us that trade-offs (Replacement) are not failures, but investments for a more optimal schedule.
