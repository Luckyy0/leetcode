# 1353. Maximum Number of Events That Can Be Attended / Số lượng Sự kiện Tối đa Có thể Tham dự

## Problem Description / Mô tả bài toán
Events `[startDay, endDay]`.
Can attend one event per day.
Maximize attended events.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Priority Queue
Sort events by start day.
Iterate days `d` from 1 to 100000.
1. Add all events starting on day `d` to Min-Heap (ordered by end day).
2. Remove expired events from heap (end day < `d`).
3. Attend the event with smallest end day (greedy choice: attend the one ending soonest to save others for later). Pop from heap.
4. Increment result.
Loop until heap empty and no more events.

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(D log N) where D is range of days.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy + Min-Heap
This is a classic interval scheduling problem where we want to pick the event that finishes earliest among available ones (EDF - Earliest Deadline First).
Algorithm:
1. Sort events by start time.
2. Iterate through days starting from day 1 (or min start day).
3. On each day `d`:
   - Add all events that start on day `d` to a Priority Queue (min-heap based on end time).
   - Remove events from the queue that have already ended (`end < d`).
   - If the queue is not empty, pop the top event (earliest end time). This means we attend this event on day `d`. Count it.
   - Increment `d`.
   - If queue is empty and we haven't processed all events, jump `d` to the next event's start time to save iterations.
Thuật toán:
1. Sắp xếp các sự kiện theo thời gian bắt đầu.
2. Lặp qua các ngày bắt đầu từ ngày 1.
3. Vào mỗi ngày `d`:
   - Thêm tất cả các sự kiện bắt đầu vào ngày `d` vào Hàng đợi ưu tiên (min-heap dựa trên thời gian kết thúc).
   - Xóa các sự kiện khỏi hàng đợi đã kết thúc (`end < d`).
   - Nếu hàng đợi không trống, pop sự kiện trên cùng (thời gian kết thúc sớm nhất). Điều này có nghĩa là chúng ta tham dự sự kiện này vào ngày `d`. Đếm nó.
   - Tăng `d`.
   - Nếu hàng đợi trống và chúng ta chưa xử lý tất cả các sự kiện, hãy nhảy `d` đến thời gian bắt đầu của sự kiện tiếp theo.

---
