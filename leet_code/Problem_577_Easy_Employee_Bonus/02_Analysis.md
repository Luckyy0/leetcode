# Analysis for Employee Bonus
# *Phân tích cho bài toán Tiền thưởng Nhân viên*

## 1. Problem Essence & The Inclusive Join
## *1. Bản chất vấn đề & Phép nối Bao trùm*

### The Challenge
### *Thách thức*
We need to list employees whose bonuses are less than 1000.
*Chúng ta cần liệt kê những nhân viên có tiền thưởng nhỏ hơn 1000.*

The critical detail is that employees with **no bonus records** (i.e., they don't appear in the `Bonus` table) must also be included. In SQL terms, a missing record manifests as a `NULL` value when performing a join.
*Chi tiết quan trọng là những nhân viên **không có bản ghi tiền thưởng** (tức là họ không xuất hiện trong bảng `Bonus`) cũng phải được đưa vào. Trong thuật ngữ SQL, một bản ghi bị thiếu sẽ biểu hiện dưới dạng giá trị `NULL` khi thực hiện phép nối.*

---

## 2. Strategy: LEFT JOIN with NULL Filtering
## *2. Chiến lược: LEFT JOIN với Lọc giá trị NULL*

To ensure all employees are considered, we must start with the `Employee` table and link it to the `Bonus` table using an outer join.
*Để đảm bảo tất cả nhân viên đều được xem xét, chúng ta phải bắt đầu từ bảng `Employee` và liên kết nó với bảng `Bonus` bằng một phép nối ngoài (outer join).*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Select Tables:** Use `Employee` as the base table (left) and `Bonus` as the secondary table (right).
    * **Chọn bảng:** Sử dụng `Employee` làm bảng cơ sở (bên trái) và `Bonus` làm bảng phụ (bên phải).*

2.  **Left Join:** Join them on `Employee.empId = Bonus.empId`.
    * **Phép nối Trái:** Nối chúng theo điều kiện `Employee.empId = Bonus.empId`.*
    - For employees with no bonus, the `bonus` column in the result will be `NULL`.
    - *Đối với những nhân viên không có thưởng, cột `bonus` trong kết quả sẽ là `NULL`.*

3.  **Apply Filter:** Filter for rows where the `bonus` is either less than 1000 OR is `NULL`.
    * **Áp dụng Bộ lọc:** Lọc các hàng mà `bonus` nhỏ hơn 1000 HOẶC là `NULL`.*
    `WHERE bonus < 1000 OR bonus IS NULL`

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Left vs Inner Join:** An `INNER JOIN` would automatically discard employees without bonuses, violating the problem requirements. `LEFT JOIN` is essential.
    * **Nối Trái so với Nối Trong:** Phép `INNER JOIN` sẽ tự động loại bỏ các nhân viên không có tiền thưởng, vi phạm yêu cầu của bài toán. `LEFT JOIN` là bắt buộc.*
*   **NULL Logic:** In SQL, `NULL < 1000` evaluates to "Unknown", not "True". Therefore, we must explicitly check `IS NULL`.
    * **Logic giá trị NULL:** Trong SQL, biểu thức `NULL < 1000` được đánh giá là "Unknown" (Không xác định), chứ không phải "True". Do đó, chúng ta phải kiểm tra rõ ràng bằng `IS NULL`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + B)$, where $N$ is the number of employees and $B$ is the number of bonus records. This is a linear scan and join operation.
    * **Độ phức tạp thời gian:** $O(N + B)$, trong đó $N$ là số lượng nhân viên và $B$ là số lượng bản ghi tiền thưởng. Đây là một thao tác quét tuyến tính và phép nối.*
*   **Space Complexity:** $O(N)$ for the result set storage.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Employees:** John (1), Dan (2)
**Bonuses:** Dan (2) gets 500
- **Left Join Result:**
  - John, null
  - Dan, 500
- **Filter:**
  - John (null is null): Keep.
  - Dan (500 < 1000): Keep.
- **Output:** John (null), Dan (500).

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always use `LEFT JOIN` when optional data (like bonuses) needs to be presented alongside mandatory entities (like employees), and remember that `NULL` needs specific handling.
*Luôn sử dụng `LEFT JOIN` khi dữ liệu tùy chọn (như tiền thưởng) cần được trình bày cùng với các thực thể bắt buộc (như nhân viên), và hãy nhớ rằng giá trị `NULL` cần được xử lý riêng biệt.*
---
*Sự công nhận (Bonus) đôi khi không hiện hữu (NULL), nhưng giá trị của cá nhân (Employee) thì luôn tồn tại. Trong hệ thống dữ liệu, một phép nối bao trùm (LEFT JOIN) đảm bảo rằng không ai bị lãng quên, cho dù họ có nhận được phần thưởng hay không. Sự quan tâm trọn vẹn bắt đầu từ việc chấp nhận cả những khoảng trống.*
Recognition (Bonus) is sometimes non-existent (NULL), but individual value (Employee) always exists. In a data system, an inclusive join (LEFT JOIN) ensures that no one is forgotten, whether they receive a reward or not. Full consideration starts with accepting even the gaps.
