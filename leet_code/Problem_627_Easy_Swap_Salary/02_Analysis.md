# Analysis for Swap Salary
# *Phân tích cho bài toán Hoán đổi Lương*

## 1. Problem Essence & Atomic Transformation
## *1. Bản chất vấn đề & Biến đổi Nguyên tử*

### The Challenge
### *Thách thức*
We need to toggle values in a column (`'m'` to `'f'` and `'f'` to `'m'`) using only one SQL `UPDATE` statement.
*Chúng ta cần chuyển đổi các giá trị trong một cột (`'m'` thành `'f'` và `'f'` thành `'m'`) chỉ bằng một câu lệnh SQL `UPDATE` duy nhất.*

Crucially, we cannot use temporary tables or subqueries. The update must be row-wise and simultaneous for all impacted records.
*Quan trọng là, chúng ta không được sử dụng các bảng tạm hoặc truy vấn con. Việc cập nhật phải diễn ra theo từng hàng và đồng thời cho tất cả các bản ghi bị ảnh hưởng.*

---

## 2. Strategy: Inline Conditional Logic
## *2. Chiến lược: Logic có điều kiện Nội dòng*

SQL `UPDATE` statements support conditional expressions within the `SET` clause. This allows us to define the "new value" based on the "current value".
*Các câu lệnh SQL `UPDATE` hỗ trợ các biểu thức có điều kiện trong mệnh đề `SET`. Điều này cho phép chúng ta định nghĩa "giá trị mới" dựa trên "giá trị hiện tại".*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Selection of Tool:** We can use `CASE WHEN` (Standard SQL) or `IF` (MySQL specifically).
    * **Lựa chọn Công cụ:** Chúng ta có thể sử dụng `CASE WHEN` (SQL Tiêu chuẩn) hoặc `IF` (đặc thù của MySQL).*

2.  **Implementation:**
    * **Triển khai:** *
    - Set `sex = CASE WHEN sex = 'm' THEN 'f' ELSE 'm' END`.
    - This works because if `sex` is 'm', it becomes 'f'. If it was NOT 'm' (meaning it was 'f'), it becomes 'm'.
    - *Điều này hoạt động vì nếu `sex` là 'm', nó trở thành 'f'. Nếu nó KHÔNG PHẢI 'm' (nghĩa là nó là 'f'), nó trở thành 'm'.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Atomicity:** The `UPDATE` statement is atomic. The database engine calculates the `CASE` expression for each row based on the state *before* the update started, avoiding the "double-flip" problem where an 'm' becomes 'f' and then immediately becomes 'm' again.
    * **Tính Nguyên tử:** Câu lệnh `UPDATE` mang tính nguyên tử. Công cụ cơ sở dữ liệu tính toán biểu thức `CASE` cho mỗi hàng dựa trên trạng thái *trước khi* việc cập nhật bắt đầu, tránh vấn đề "lật hai lần" khi 'm' trở thành 'f' rồi ngay lập tức trở lại thành 'm'.*
*   **Performance:** A single statement update is significantly faster than multiple updates or using scripts because it minimizes transaction overhead and logging.
    * **Hiệu suất:** Cập nhật bằng một câu lệnh duy nhất nhanh hơn đáng kể so với nhiều lượt cập nhật hoặc sử dụng mã lệnh vì nó giảm thiểu chi phí giao dịch và nhật ký ghi (logging).*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the number of rows in the table. Each row is updated once.
    * **Độ phức tạp thời gian:** $O(N)$ trong đó $N$ là số hàng trong bảng. Mỗi hàng được cập nhật một lần.*
*   **Space Complexity:** $O(1)$ extra space beyond the table storage.
    * **Độ phức tạp không gian:** $O(1)$ không gian bổ sung ngoài lưu trữ của bảng.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Original Data:** {1:'m', 2:'f', 3:'m'}
1. Row 1: sex is 'm'. Case 'm' -> 'f'. New Value: 'f'.
2. Row 2: sex is 'f'. Case 'm' fail -> Else 'm'. New Value: 'm'.
3. Row 3: sex is 'm'. Case 'm' -> 'f'. New Value: 'f'.
**Result:** {1:'f', 2:'m', 3:'f'}.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "Binary Toggles" or simple value rotations in SQL, use categorical logic (`CASE` or `IF`) directly in the `SET` clause of an `UPDATE` statement. This ensures efficiency and preserves data integrity through atomicity.
*Đối với các phép "Chuyển đổi nhị phân" hoặc xoay vòng giá trị đơn giản trong SQL, hãy sử dụng logic phân loại (`CASE` hoặc `IF`) trực tiếp trong mệnh đề `SET` của câu lệnh `UPDATE`. Điều này đảm bảo hiệu quả và duy trì tính toàn vẹn dữ liệu thông qua tính nguyên tử.*
---
*Sự hoán đổi (Swapping) không nhất thiết phải cần một thùng chứa tạm thời. Trong thế giới của logic (Binary logic), khi ta định nghĩa lại những giá trị đối lập (m vs f), ta tạo ra một sự dịch chuyển tức thời (Instantaneous shift). Dữ liệu dạy ta rằng sự trực diện (Direct update) thường là con đường ngắn nhất và thanh lịch nhất để giải quyết những mâu thuẫn.*
Swapping (Swapping) does not necessarily need a temporary container. In the world of logic (Binary logic), when we redefine opposing values (m vs f), we create an instantaneous shift (Instantaneous shift). Data teaches us that directness (Direct update) is often the shortest and most elegant way to resolve conflicts.
