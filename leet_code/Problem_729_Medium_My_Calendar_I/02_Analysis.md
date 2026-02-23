# Analysis for My Calendar I
# *Phân tích cho bài toán Lịch trình của Tôi I*

## 1. Problem Essence & Overlap Detection
## *1. Bản chất vấn đề & Phát hiện Chồng lấp*

### The Challenge
### *Thách thức*
We need to manage a collection of intervals $[start, end)$ and ensure that no two intervals overlap. Two intervals $[s_1, e_1)$ and $[s_2, e_2)$ overlap if and only if $s_1 < e_2$ and $s_2 < e_1$.
*Chúng ta cần quản lý một bộ sưu tập các khoảng $[start, end)$ và đảm bảo rằng không có hai khoảng nào chồng lấp lên nhau. Hai khoảng $[s_1, e_1)$ và $[s_2, e_2)$ chồng lấp khi và chỉ khi $s_1 < e_2$ và $s_2 < e_1$.*

---

## 2. Strategy: TreeMap for Ordered Intervals
## *2. Chiến lược: TreeMap cho các Khoảng có Thứ tự*

While a simple list with $O(N)$ search is acceptable for 1,000 calls, using a `TreeMap` provides $O(\log N)$ search, which is more scalable.
*Dù một danh sách đơn giản với tìm kiếm $O(N)$ là chấp nhận được cho 1.000 lượt gọi, sử dụng `TreeMap` cung cấp khả năng tìm kiếm $O(\log N)$, giúp hệ thống có khả năng mở rộng tốt hơn.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Map Structure:** Use `TreeMap<Integer, Integer>` where `Key = StartTime` and `Value = EndTime`.
    * **Cấu trúc Map:** Sử dụng `TreeMap` với Khóa là thời điểm bắt đầu và Giá trị là thời điểm kết thúc.*

2.  **Neighbor Check:** For a new request `[s, e)`:
    - **Previous Event:** Find the largest `start` such that `start <= s` (using `floorKey`). If the corresponding `end > s`, there is an overlap with the previous event.
    - **Next Event:** Find the smallest `start` such that `start >= s` (using `ceilingKey`). If that `start < e`, there is an overlap with the next event.
    * **Kiểm tra Lân cận:** Với mỗi yêu cầu mới `[s, e)`:
        * Sự kiện trước: Tìm `start` lớn nhất $\le s$. Nếu `end` của nó $> s$ thì bị trùng.
        * Sự kiện sau: Tìm `start` nhỏ nhất $\ge s$. Nếu nó $< e$ thì bị trùng.*

3.  **Insertion:** If neither neighbor overlaps, add the event to the map and return `true`. Otherwise, return `false`.
    * **Chèn:** Nếu không trùng, lưu vào map và trả về `true`.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$ per `book` call, where $N$ is the number of events already booked. Total time for $M$ calls is $O(M \log M)$.
    * **Độ phức tạp thời gian:** $O(\log N)$ cho mỗi lượt đặt lịch.*
*   **Space Complexity:** $O(N)$ to store all booked events.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Existing:** {10: 20}
1. **book(15, 25):** 
   - `floorKey(15)` is 10. `end(10)` is 20. 20 > 15 -> **Overlap!** Return `false`.
2. **book(20, 30):** 
   - `floorKey(20)` is 10. `end(10)` is 20. 20 is not > 20.
   - `ceilingKey(20)` is null.
   - **No overlap!** Add {20: 30}. Return `true`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The `TreeMap`'s ability to find nearest neighbors in logarithmic time makes it the ideal data structure for interval management problems. It automatically keeps the intervals sorted by their start points.
*Khả năng của `TreeMap` trong việc tìm kiếm các lân cận gần nhất trong thời gian logarit biến nó thành cấu trúc dữ liệu lý tưởng cho các bài toán quản lý khoảng.*
---
*Thời gian là một dòng chảy (Stream) nơi mỗi sự kiện (Event) cần một không gian xác định để tồn tại. Trong lịch trình của cuộc đời, sự chồng lấp (Overlap) là nguồn gốc của sự hỗn loạn. Dữ liệu dạy ta rằng bằng cách duy trì một trật tự nghiêm ngặt (Sorted TreeMap) và luôn quan sát những ranh giới lân cận (Floor/Ceiling checks), ta có thể xây dựng một cấu trúc hài hòa nơi mỗi khoảnh khắc đều được trân trọng mà không bị xâm lấn.*
Time is a flow (Stream) where each event (Event) needs a defined space to exist. In the schedule of life, overlap (Overlap) is the source of chaos. Data teaches us that by maintaining a strict order (Sorted TreeMap) and always observing the neighboring boundaries (Floor/Ceiling checks), we can build a harmonious structure where each moment is cherished without being invaded.
