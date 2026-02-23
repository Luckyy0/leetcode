# Analysis for Consecutive Available Seats
# *Phân tích cho bài toán Các Ghế Trống Liên tiếp*

## 1. Problem Essence & Local Continuity
## *1. Bản chất vấn đề & Tính liên tục Cục bộ*

### The Challenge
### *Thách thức*
We need to find all seats that belong to a group of two or more adjacent free seats.
*Chúng ta cần tìm tất cả các ghế thuộc vào một nhóm gồm hai hoặc nhiều ghế trống liền kề nhau.*

A seat is "consecutive" if its immediate predecessor is free OR its immediate successor is free.
*Một chiếc ghế được coi là "liên tiếp" nếu chiếc ghế ngay trước nó đang trống HOẶC chiếc ghế ngay sau nó đang trống.*

---

## 2. Strategy: Window Functions (LAG and LEAD)
## *2. Chiến lược: Hàm cửa sổ (LAG và LEAD)*

Window functions allow us to "peek" at adjacent rows without performing complex self-joins.
*Các hàm cửa sổ cho phép chúng ta "nhìn" vào các hàng liền kề mà không cần thực hiện các phép tự nối phức tạp.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Peeking:** Use `LAG(free)` to see the status of the previous seat and `LEAD(free)` to see the status of the next seat.
    * **Quan sát:** Sử dụng `LAG(free)` để xem trạng thái của ghế trước đó và `LEAD(free)` để xem trạng thái của ghế tiếp theo.*

2.  **Filtering:** A seat ID is included in the result if:
    * **Lọc:** Một ID ghế được bao gồm trong kết quả nếu:*
    - The seat itself is free (`free = 1`).
    - *Bản thân chiếc ghế đó đang trống (`free = 1`).*
    - **AND** either its neighbor to the left is free (`prev_free = 1`) OR its neighbor to the right is free (`next_free = 1`).
    - * **VÀ** hoặc là người hàng xóm bên trái của nó đang trống (`prev_free = 1`) HOẶC người hàng xóm bên phải của nó đang trống (`next_free = 1`).*

3.  **Ordering:** Sort by `seat_id` as requested.
    * **Sắp xếp:** Sắp xếp theo `seat_id` như yêu cầu.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Self-Join Alternative:** While solvable with `JOIN ON abs(c1.seat_id - c2.seat_id) = 1`, window functions are more performant on large tables because they only require one pass over the sorted data.
    * **Sự thay thế cho Tự nối:** Mặc dù có thể giải bằng `JOIN ON abs(c1.seat_id - c2.seat_id) = 1`, các hàm cửa sổ mang lại hiệu năng cao hơn trên các bảng lớn vì chúng chỉ yêu cầu một lần duyệt qua dữ liệu đã sắp xếp.*
*   **NULL Handling:** `LAG` at the first row and `LEAD` at the last row return `NULL`. We should treat `NULL` as `0` using `IFNULL` or `COALESCE` if necessary, though in this specific logic, `NULL` will simply fail the `1` equality check correctly.
    * **Xử lý NULL:** `LAG` ở hàng đầu tiên và `LEAD` ở hàng cuối cùng trả về `NULL`. Chúng ta nên coi `NULL` là `0` bằng cách sử dụng `IFNULL` hoặc `COALESCE` nếu cần thiết, mặc dù trong logic cụ thể này, `NULL` sẽ đơn giản là không vượt qua được phép kiểm tra bằng `1` một cách chính xác.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ where $N$ is the number of seats, primarily for sorting by `seat_id`.
    * **Độ phức tạp thời gian:** $O(N \log N)$ trong đó $N$ là số lượng ghế, chủ yếu là để sắp xếp theo `seat_id`.*
*   **Space Complexity:** $O(N)$ for internal buffer processing of window functions.
    * **Độ phức tạp không gian:** $O(N)$ cho việc xử lý bộ đệm nội bộ của các hàm cửa sổ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [1:F, 2:O, 3:F, 4:F, 5:F] (F=Free, O=Occupied)
- Seat 1: Prev=NULL, Next=O. (F but neighbors are not F) -> Fail.
- Seat 2: Occupied -> Fail.
- Seat 3: Prev=O, Next=F. (F and Next is F) -> **Success**.
- Seat 4: Prev=F, Next=F. (F and neighbors are F) -> **Success**.
- Seat 5: Prev=F, Next=NULL. (F and Prev is F) -> **Success**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For adjacency problems in SQL, `LAG` and `LEAD` are the standard tools. They provide a clean, declarative way to express relationships between neighboring rows.
*Đối với các bài toán về tính liền kề trong SQL, `LAG` và `LEAD` là những công cụ tiêu chuẩn. Chúng cung cấp một cách sạch sẽ, mang tính khai báo để thể hiện các mối quan hệ giữa các hàng lân cận.*
---
*Sự đồng điệu (Adjacency) tạo nên cảm giác kết nối. Trong một rạp chiếu phim (Cinema), những khoảng trống lẻ loi không mang lại giá trị bằng những cặp ghế liền kề (Consecutive seats) – nơi những câu chuyện có thể được chia sẻ. Dữ liệu dạy ta rằng giá trị của một vị trí (Seat) thường phụ thuộc vào những gì ở ngay bên cạnh nó.*
Adjacency (Adjacency) creates a sense of connection. In a theater (Cinema), secluded spaces are not as valuable as adjacent pairs of seats (Consecutive seats) – where stories can be shared. Data teaches us that the value of a position (Seat) often depends on what is right next to it.
