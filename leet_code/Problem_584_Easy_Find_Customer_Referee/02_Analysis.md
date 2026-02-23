# Analysis for Find Customer Referee
# *Phân tích cho bài toán Tìm Người giới thiệu Khách hàng*

## 1. Problem Essence & The Nullability of Logic
## *1. Bản chất vấn đề & Tính có thể rỗng của Logic*

### The Challenge
### *Thách thức*
We need to find customers who were NOT referred by ID 2.
*Chúng ta cần tìm những khách hàng KHÔNG được giới thiệu bởi ID 2.*

The core of this problem lies in how SQL handles `NULL` values in inequality comparisons.
*Cốt lõi của bài toán này nằm ở cách SQL xử lý các giá trị `NULL` trong các so sánh bất đẳng thức.*

---

## 2. Strategy: Three-Valued Logic Handling
## *2. Chiến lược: Xử lý Logic Ba giá trị*

In SQL, a comparison like `referee_id <> 2` only returns rows where `referee_id` is a number AND that number is not 2.
*Trong SQL, một so sánh như `referee_id <> 2` chỉ trả về các hàng mà `referee_id` là một con số VÀ con số đó không phải là 2.*

If `referee_id` is `NULL`, the result of `NULL <> 2` is `Unknown`, not `True`. Therefore, rows with `referee_id IS NULL` will be ignored unless explicitly handled.
*Nếu `referee_id` là `NULL`, kết quả của `NULL <> 2` là `Unknown` (Không xác định), chứ không phải `True`. Do đó, các hàng có `referee_id IS NULL` sẽ bị bỏ qua trừ khi được xử lý rõ ràng.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Select Column:** We only need the `name`.
    * **Chọn Cột:** Chúng ta chỉ cần `name`.*

2.  **Filtering (The Inclusive OR):** Use a `WHERE` clause that combines two conditions:
    * **Lọc (Phép OR Bao trùm):** Sử dụng mệnh đề `WHERE` kết hợp hai điều kiện:*
    - `referee_id != 2` (Handles cases with other referrers).
    - *`referee_id != 2` (Xử lý các trường hợp có người giới thiệu khác).*
    - `referee_id IS NULL` (Handles cases with no referrer).
    - *`referee_id IS NULL` (Xử lý các trường hợp không có người giới thiệu).*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Boolean Inclusion:** This problem tests basic SQL understanding regarding the `Three-Valued Logic` (True, False, Unknown).
    * **Bao hàm Boolean:** Bài toán này kiểm tra hiểu biết cơ bản về SQL liên quan đến `Logic Ba giá trị` (Đúng, Sai, Không xác định).*
*   **Alternative Functions:** One could also use `IFNULL(referee_id, 0) != 2` or `COALESCE(referee_id, 0) != 2`. However, explicit `OR ... IS NULL` is often easier for the query optimizer to index.
    * **Các hàm thay thế:** Người ta cũng có thể sử dụng `IFNULL(referee_id, 0) != 2` hoặc `COALESCE(referee_id, 0) != 2`. Tuy nhiên, `OR ... IS NULL` rõ ràng thường giúp trình tối ưu hóa truy vấn lập chỉ mục dễ dàng hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of customers. It's a simple full-table scan or index scan.
    * **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là số lượng khách hàng. Đây là một phép quét toàn bảng hoặc quét chỉ mục đơn giản.*
*   **Space Complexity:** $O(1)$ beyond the result output.
    * **Độ phức tạp không gian:** $O(1)$ ngoài đầu ra kết quả.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** {referee_id: [null, null, 2, null, 1, 2]}
- Row 1 (null): (null != 2?) -> Unknown. (null is null?) -> **True**. Keep.
- Row 2 (null): **True**. Keep.
- Row 3 (2): (2 != 2?) -> False. (2 is null?) -> False. Discard.
- Row 4 (null): **True**. Keep.
- Row 5 (1): (1 != 2?) -> **True**. Keep.
- Row 6 (2): Discard.
**Result:** Names from Rows 1, 2, 4, 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always remember that `!=` or `<>` does not capture `NULL` values in SQL. Use explicit `IS NULL` checks or null-handling functions like `COALESCE`.
*Luôn nhớ rằng `!=` hoặc `<>` không nắm bắt được các giá trị `NULL` trong SQL. Hãy sử dụng các phép kiểm tra `IS NULL` rõ ràng hoặc các hàm xử lý null như `COALESCE`.*
---
*Sự vắng mặt (NULL) không đồng nghĩa với việc thuộc về một nhóm đối lập (!= 2). Trong thế giới của dữ liệu, có những thông tin chưa được xác định, và nhiệm vụ của ta là phải bao hàm cả những khoảng lặng (NULL) đó để có được một bức tranh toàn diện nhất về thực tại.*
Absence (NULL) does not mean belonging to an opposing group (!= 2). In the world of data, there is information that has not been defined, and our task is to include those silences (NULL) to get the most comprehensive picture of reality.
