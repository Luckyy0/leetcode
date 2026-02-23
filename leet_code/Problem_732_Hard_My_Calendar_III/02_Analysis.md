# Analysis for My Calendar III
# *Phân tích cho bài toán Lịch trình của Tôi III*

## 1. Problem Essence & Global Maximum Overlap
## *1. Bản chất vấn đề & Chồng lấp Cực đại Toàn cục*

### The Challenge
### *Thách thức*
We need to find the maximum number of concurrent events at any point in time (the "K" in K-booking). Since the number of queries is relatively small ($N=400$), we can use a dynamic approach that updates and then recalculates the maximum overlap.
*Chúng ta cần tìm số lượng sự kiện đồng thời lớn nhất tại bất kỳ thời điểm nào (giá trị "K" trong K-booking). Vì số lượng truy vấn tương đối nhỏ, ta có thể sử dụng cách tiếp cận động: cập nhật rồi tính toán lại mức chồng lấp cực đại.*

---

## 2. Strategy: Line Sweep Algorithm
## *2. Chiến lược: Thuật toán Quét dòng (Line Sweep)*

This is a classic "Boundary Counting" or "Difference Array" pattern applied to a timeline.
*Đây là mô hình "Đếm biên" hoặc "Mảng hiệu" điển hình áp dụng trên dòng thời gian.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Map Initialization:** Use a `TreeMap<Integer, Integer>` to store the changes in the number of active bookings at specific timestamps.
    * **Khởi tạo Map:** Sử dụng `TreeMap` để lưu trữ sự thay đổi số lượng đặt lịch tại các mốc thời gian cụ thể.*

2.  **Boundary Marking:** For each new booking `[start, end)`:
    - Increment the count at `start` (`+1`): A new event begins here.
    - Decrement the count at `end` (`-1`): An event ends here.
    * **Đánh dấu Biên:** Với mỗi sự kiện mới, tăng giá trị tại `start` và giảm giá trị tại `end`.*

3.  **Prefix Sum Calculation (Sweep):** To find the maximum $K$:
    - Traverse the `TreeMap` in ascending order of keys (time).
    - Maintain a running variable `activeBookings`.
    - Update `maxK = max(maxK, activeBookings)`.
    * **Tính Tổng Tích lũy (Quét):** Duyệt qua `TreeMap` theo thứ tự thời gian tăng dần, cộng dồn các giá trị để tìm số lượng sự kiện đang diễn ra tại mỗi thời điểm và cập nhật giá trị cực đại.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Ordered Map:** The `TreeMap` is essential because it automatically keeps the time points sorted, which is a requirement for the Line Sweep algorithm.
    * **Map có thứ tự:** TreeMap cực kỳ quan trọng vì nó tự động sắp xếp các mốc thời gian.*
*   **Decoupled Intervals:** We don't need to know which interval is which; we only care about the net change in capacity over time.
    * **Khoảng cách biệt lập:** Chúng ta không cần quan tâm sự kiện cụ thể nào đang diễn ra, chỉ cần biết sự thay đổi ròng về số lượng theo thời gian.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ per `book` call to traverse the map. With $N$ calls, the total time is $O(N^2)$. Given $N=400$, the operations are well within limits.
    * **Độ phức tạp thời gian:** $O(N)$ cho mỗi lượt đặt lịch (tổng $O(N^2)$).*
*   **Space Complexity:** $O(N)$ to store up to $2N$ boundary points in the map.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Line Sweep is the most robust way to solve maximum overlap problems. While a **Dynamic Segment Tree** could provide $O(\log T)$ per update, the Line Sweep with `TreeMap` is much simpler to implement and sufficient for these constraints.
*Quét dòng là cách mạnh mẽ nhất để giải các bài toán chồng lấp cực đại. Dù **Cây phân đoạn động** có thể cho hiệu suất cao hơn, nhưng Quét dòng với `TreeMap` lại đơn giản hơn nhiều và đủ dùng cho các ràng buộc này.*
---
*Mật độ (Density) của các sự kiện trong thời gian tỷ lệ thuận với sự hội tụ của các ranh giới. Trong nhịp đập của lịch trình, đỉnh cao nhất (Max K) là nơi những mong muốn khác nhau gặp nhau tại cùng một khoảnh khắc. Dữ liệu dạy ta rằng bằng cách đánh dấu sự bắt đầu (Inc) và kết thúc (Dec) của mọi hành trình, ta có thể phác họa được bức tranh toàn cảnh về sự bận rộn của thực tại.*
The density (Density) of events in time is proportional to the convergence of boundaries. In the pulse of the schedule, the highest peak (Max K) is where different desires meet at the same moment. Data teaches us that by marking the beginning (Inc) and the end (Dec) of every journey, we can sketch a panoramic picture of the busyness of reality.
