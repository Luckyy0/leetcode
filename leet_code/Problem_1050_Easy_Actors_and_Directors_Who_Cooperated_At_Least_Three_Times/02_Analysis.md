# Analysis for Actors and Directors Who Cooperated At Least Three Times
# *Phân tích bài toán Tài Tử Và Đạo Diễn Đá Cặp Cùng Nhau Ít Nhất Ba Bộ Phim*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
This is a fundamental relational SQL problem. We need to comb through a transaction-like table (recording every instance where an actor and director shoot a film together) and identify only those specific `(actor_id, director_id)` pairs whose count of collaborations strictly reaches or exceeds the threshold of 3.
*Đây là dạng toán Lọc và Gom Nhóm cơ sở trên Cơ sở dữ liệu! Đề bài đổ ra một Bảng Ghi Nhận Lịch Sử Lợp Phim (ghi lại từng khoảnh khắc một Tài Tử X và Đạo diễn Y khởi quay chung). Nhiệm vụ của bạn là phải quét lướt toàn bộ để vớt gọn lại những cặp đôi bài trùng `(actor_id, director_id)` đã từng hợp tác chung cùng nhau Tính Điểm Chạm ngưỡng hoặc Lớn hơn 3 Phim.*

---

## 2. Strategy: Optimal (GROUP BY and HAVING)
## *2. Chiến lược: Tối ưu (Gom Nhóm Bằng Cặp Cột và Tuyền Thề Xé Bộ Lọc Bộ Đếm)*

### Logic and Rules
### *Lý luận và Quy tắc*

The operation required is an aggregative summarization strictly partitioned by a combination of two keys. Instead of grouping by just `actor_id` (which counts all the actor's films regardless of director), or just `director_id`, we must group rows that uniquely pair BOTH an `actor_id` AND a `director_id`.
*Hành động cốt lõi để phá vỡ chướng ngại này là lập phép toán Tổng Hợp Gom Nhóm (Aggregation) phân vùng khâu nối bằng việc kết hợp 2 chìa khóa.*
*Tuyệt đối KHÔNG ĐƯỢC chỉ nhóm riêng theo `actor_id` (hành động này sẽ Đếm Toán Loạn toàn bộ phim gã tài tử đó đóng bất chấp Đạo Diễn là ai), hay ngược lại độc diễn nhét riêng `director_id`. Ta BẮT BUỘC phải dùng rọ Gom Nhóm Ráp Nối Đồng Thời Chặt Kẽ: Cả Tên Diễn Viên LẪN Tên Đạo Diễn.*

1. Apply `GROUP BY actor_id, director_id` to aggregate all records corresponding to a unique collaboration pair.
*1. Bức tường gạch gắn nóc `GROUP BY actor_id, director_id` này sẽ đóng vai trò như một thỏi nam châm, hút toàn bộ khối sự kiện lịch sử quay phim chung bốc vỏn vẹn nhóm riêng thành một Cặp Cộng Tác viên Độc quyền về chung đụng một rọ không lẫn lộn với các cặp khác.*

2. Use the `HAVING` clause to explicitly filter the aggregated groups. Filter condition is `COUNT(*) >= 3`.
*2. Bức Ngáng Thép Cửa Kiểm Soát Cuối Dòng: Thiết giáp Đầu Băng `HAVING`!*
*Dưới vòm trời từng Cặp Đôi vừa Gom Kín, Đặt Màn Rào Phễu Lọc Tuyên Đoán Rằng Số Lượng bản khai Phiếu Hợp tác của Cặp Đó Đạt Tiêu Chuẩn Phải Chạm `COUNT(*) >= 3`. Nhóm nào không vượt Cửa Số 3 sẽ lập tức bị lọc bỏ.*

### SQL Optimal Implementation
### *Triển khai giải pháp SQL Tối Ưu*

```sql
SELECT 
    actor_id, 
    director_id
FROM 
    ActorDirector
GROUP BY 
    actor_id, 
    director_id
HAVING 
    COUNT(*) >= 3;
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Expected $O(N)$ or $O(N \log N)$ depending on whether the relational database engine executes a Sorting or Hashing technique to aggregate the dataset containing $N$ rows.
    *   **Độ phức tạp thời gian:** Mong đợi Đạt Chốt $O(N)$ hoặc hơi lùi lên ngưỡng $O(N \log N)$. Thời gian tiêu tốn Căn cứ dựa trên bộ Máy Gầm Tính Toán Lịch SQL Execution Planner (Phối Trí thuật toán Hash Aggregation hoặc Sắp xếp Giao Thêm Quét Dần). Nhìn chung Bộ Engine gánh quét Lọc một mạch $N$ Phân luồng Song Song Siêu Nhanh.*
*   **Space Complexity:** $O(U)$ where $U$ represents the number of strictly unique pairs of `actor_id` and `director_id`.
    *   **Độ phức tạp không gian:** $O(U)$ với $U$ là tổng số các cặp đôi diễn viên và đạo diễn đã hợp tác. Dung lượng RAM SQL Engine tốn để cất giữ bộ phân các gói Hash Bucket lưu trữ số đếm.*
