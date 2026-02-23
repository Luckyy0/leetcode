# Analysis for Design Phone Directory
# *Phân tích cho bài toán Thiết kế Danh bạ Điện thoại*

## 1. Problem Essence & Multi-DS Management
## *1. Bản chất vấn đề & Quản lý Đa cấu trúc dữ liệu*

### The Challenge
### *Thách thức*
Managing a pool of available integers with efficient retrieval, checking, and recycling.

### Strategy: Queue + HashSet
### *Chiến lược: Hàng đợi + Tập hợp băm*
1.  **Requirement:** Obtain *any* available number quickly. A **Queue** (or Stack) can store all currently available numbers.
2.  **Requirement:** Check if a number is available in $O(1)$. A **HashSet** (or boolean array) can store which numbers are *not yet assigned*.
3.  **Operations:**
    - `get`: Poll from Queue and remove from HashSet.
    - `check`: Return `contains` on HashSet.
    - `release`: Only if not in HashSet, add to Queue and HashSet.

---

## 2. Approach: Set + Queue
## *2. Hướng tiếp cận: Tập hợp + Hàng đợi*

### Logic
### *Logic*
(See above). The Queue gives us "the next available" and the Set gives us "membership".

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Time:** All operations (`get`, `check`, `release`) are constant time.
    *Thời gian O(1): Tất cả các thao tác đều là thời gian hằng số.*
*   **Predictable Performance:** No matter how many numbers are in use, the response time remains the same.
    *Hiệu suất ổn định: Thời gian phản hồi không đổi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ per operation. Constructor takes $O(N)$ to initialize.
    *Độ phức tạp thời gian: $O(1)$ mỗi thao tác. Hàm khởi tạo mất $O(N)$.*
*   **Space Complexity:** $O(N)$ to store $N$ numbers in both data structures.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**maxNumbers = 3**
1. Init: `Queue = [0, 1, 2]`, `Set = {0, 1, 2}`.
2. `get()`: Poll `0`. `Set = {1, 2}`. Return 0.
3. `check(0)`: `0` in Set? No. Result: false.
4. `release(0)`: `0` in Set? No. Push `0` to Queue. `Set = {1, 2, 0}`.
5. `check(0)`: `0` in Set? Yes. Result: true.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Queue (for retrieval) + Set (for lookup).
*Hàng đợi (để lấy số) + Tập hợp (để tra cứu).*
---
*Một hệ thống danh bạ hiệu quả không chỉ cần biết cái gì đang được sử dụng (Set), mà còn phải sẵn sàng cung cấp cái mới (Queue) ngay lập tức. Sự kết hợp giữa khả năng ghi nhớ và khả năng dự phòng tạo nên một cấu trúc linh hoạt cho mọi nhu cầu kết nối.*
An effective directory system not only needs to know what is in use (Set), but also must be ready to provide something new (Queue) immediately. The combination of memory and redundancy creates a flexible structure for all connection needs.
