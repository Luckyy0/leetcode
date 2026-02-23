# Analysis for Design Log Storage System
# *Phân tích cho bài toán Thiết kế Hệ thống Lưu trữ Nhật ký*

## 1. Problem Essence & Multi-Level Granularity
## *1. Bản chất vấn đề & Độ chi tiết Đa cấp*

### The Challenge
### *Thách thức*
We need to store time-stamped logs and perform range queries. The complexity lies in the `granularity` parameter, which dictates which parts of the fixed-format timestamp `YYYY:MM:DD:HH:mm:ss` should be compared.
*Chúng ta cần lưu trữ các nhật ký có gắn dấu thời gian và thực hiện các truy vấn trong phạm vi. Sự phức tạp nằm ở tham số `granularity`, tham số này quyết định phần nào của dấu thời gian có định dạng cố định `YYYY:MM:DD:HH:mm:ss` cần được so sánh.*

Since the timestamps are zero-padded and in a hierarchical format (largest units first), standard string comparison works perfectly as long as we truncate or mask the strings correctly.
*Vì các dấu thời gian được đệm bằng số không và theo định dạng phân cấp (đơn vị lớn nhất đứng trước), việc so sánh chuỗi tiêu chuẩn sẽ hoạt động hoàn hảo miễn là chúng ta cắt bớt hoặc che (mask) các chuỗi một cách chính xác.*

---

## 2. Strategy: Prefix Indexing
## *2. Chiến lược: Lập chỉ mục Tiền tố*

We can map each granularity to a specific prefix length of the timestamp string.
*Chúng ta có thể ánh xạ mỗi bộ chi tiết (granularity) tới một độ dài tiền tố cụ thể của chuỗi dấu thời gian.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Define Granularity Map:**
    - `Year`: prefix up to index 4 (YYYY)
    - `Month`: prefix up to index 7 (YYYY:MM)
    - `Day`: prefix up to index 10 (YYYY:MM:DD)
    - `Hour`: prefix up to index 13 (YYYY:MM:DD:HH)
    - `Minute`: prefix up to index 16 (YYYY:MM:DD:HH:mm)
    - `Second`: prefix up to index 19 (full string)

2.  **Lắng nghe (Put):** Store logs in a simple list or a `TreeMap` for faster ranges. Given the constraint of 500 calls, a list is sufficient.
    * **Lưu giữ (Put):** Lưu trữ các nhật ký trong một danh sách đơn giản hoặc một `TreeMap`. Với ràng buộc 500 cuộc gọi, một danh sách là đủ.*

3.  **Truy xuất (Retrieve):**
    - Identify the prefix length $L$ based on the `granularity`.
    - Truncate the `start` and `end` timestamps to length $L$.
    - Iterate through all stored logs:
        - Truncate the log's timestamp to length $L$.
        - If `truncatedStart <= truncatedLogTimestamp <= truncatedEnd`, add the ID to the result.
    - *Xác định độ dài tiền tố $L$ dựa trên `granularity`. Cắt bớt dấu thời gian `start` và `end` xuống độ dài $L$. Duyệt qua tất cả các nhật ký đã lưu: Cắt bớt dấu thời gian của nhật ký xuống độ dài $L$. Nếu `truncatedStart <= truncatedLogTimestamp <= truncatedEnd`, hãy thêm ID vào kết quả.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Lexicographical Correctness:** Hierarchical strings like `YYYY:MM:DD` allow for direct alphabetical comparison. `2017:01` is naturally "greater than" `2016:12`.
    * **Tính chính xác về Từ điển:** Các chuỗi phân cấp như `YYYY:MM:DD` cho phép so sánh trực tiếp theo bảng chữ cái. `2017:01` tự nhiên "lớn hơn" `2016:12`.*
*   **Decoupled Storage:** By using a prefix method, the retrieval logic becomes independent of the format's internals (months, days, leap years), as we are just treating them as strings.
    * **Lưu trữ Tách biệt:** Bằng cách sử dụng phương pháp tiền tố, logic truy xuất trở nên độc lập với các chi tiết nội bộ của định dạng (tháng, ngày, năm nhuận), vì chúng ta chỉ coi chúng là các chuỗi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `put`: $O(1)$.
    - `retrieve`: $O(N)$ where $N$ is the number of logs. We check every log once.
    - *Độ phức tạp thời gian: `put` là $O(1)$, `retrieve` là $O(N)$ trong đó $N$ là số lượng nhật ký.*
*   **Space Complexity:** $O(N \times S)$ where $S$ is the length of the timestamp (19 chars).
    * **Độ phức tạp không gian: $O(N \times S)$ trong đó $S$ là độ dài của dấu thời gian.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** start="2016:01:01:01:01:01", end="2017:01:01:23:00:00", granularity="Year"
1. L = 4. 
2. startPrefix = "2016", endPrefix = "2017".
3. Log 1 (2017...): prefix "2017". Inside? Yes.
4. Log 2 (2016...): prefix "2016". Inside? Yes.
**Result:** [1, 2].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For hierarchical time strings of fixed length, string comparison is the most efficient and least error-prone method. Avoid converting to complex date objects unless calculations like "difference in days" are required.
*Đối với các chuỗi thời gian phân cấp có độ dài cố định, so sánh chuỗi là phương pháp hiệu quả nhất và ít gây lỗi nhất. Tránh chuyển đổi sang các đối tượng ngày tháng phức tạp trừ khi cần các tính toán như "số ngày chênh lệch".*
---
*Thời gian (Time) là một dòng chảy liên tục, nhưng việc ta nhìn nhận nó phụ thuộc vào lăng kính (Granularity) ta chọn. Trong hệ thống nhật ký (Log Storage), sự chính xác (Accuracy) nằm ở việc biết lọc bỏ những chi tiết thừa để tập trung vào quy mô (Prefix) cần thiết. Dữ liệu dạy ta rằng sự tinh giản (String truncation) đôi khi mang lại hiệu quả cao hơn sự phức tạp hóa.*
Time (Time) is a continuous flow, but how we perceive it depends on the prism (Granularity) we choose. In a log system (Log Storage), accuracy (Accuracy) lies in knowing how to filter out unnecessary details to focus on the necessary scale (Prefix). Data teaches us that simplification (String truncation) sometimes brings higher efficiency than complication.
