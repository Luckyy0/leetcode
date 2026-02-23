# Analysis for Average Salary: Departments VS Company
# *Phân tích cho bài toán Lương Trung bình: Phòng ban so với Công ty*

## 1. Problem Essence & Multi-Level Aggregation
## *1. Bản chất vấn đề & Tổng hợp Đa cấp*

### The Challenge
### *Thách thức*
We need to compare the average salary of each department against the average salary of the entire company, but these averages must be calculated **separately for each month**.
*Chúng ta cần so sánh mức lương trung bình của mỗi phòng ban với mức lương trung bình của toàn công ty, nhưng các trung bình này phải được tính toán **riêng biệt cho từng tháng**.*

The result depends on two distinct levels of grouping:
*Kết quả phụ thuộc vào hai mức độ phân nhóm khác nhau:*
1.  **Global Level:** (Month) -> Company Average.
2.  **Local Level:** (Month, Department) -> Department Average.

---

## 2. Strategy: Window Functions and CTEs
## *2. Chiến lược: Hàm cửa sổ và CTE*

Window functions are ideal here because they allow us to calculate both the "Department Average" and the "Company Average" in the same query context.
*Các hàm cửa sổ rất lý tưởng ở đây vì chúng cho phép chúng ta tính toán cả "Trung bình Phòng ban" và "Trung bình Công ty" trong cùng một bối cảnh truy vấn.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Preparation (Join & Format):** Join `Salary` and `Employee` to get the department ID for each payment. Format `pay_date` to `YYYY-MM`.
    * **Chuẩn bị (Nối & Định dạng):** Nối `Salary` và `Employee` để lấy ID phòng ban cho mỗi lần thanh toán. Định dạng `pay_date` thành `YYYY-MM`.*

2.  **Calculation (Windowing):** 
    * **Tính toán (Cửa sổ):** *
    - For each row, calculate the monthly average for that department: `AVG(amount) OVER(PARTITION BY pay_month, department_id)`.
    - *Đối với mỗi hàng, hãy tính trung bình hàng tháng cho phòng ban đó: `AVG(amount) OVER(PARTITION BY pay_month, department_id)`.*
    - For each row, calculate the monthly average for the whole company: `AVG(amount) OVER(PARTITION BY pay_month)`.
    - *Đối với mỗi hàng, hãy tính trung bình hàng tháng cho toàn công ty: `AVG(amount) OVER(PARTITION BY pay_month)`.*

3.  **Comparison:** Use a `CASE` statement to compare these two averages:
    * **So sánh:** Sử dụng câu lệnh `CASE` để so sánh hai trung bình này:*
    - If `dept_avg > company_avg`: 'higher'
    - If `dept_avg < company_avg`: 'lower'
    - Else: 'same'

4.  **Deduplication:** Since the window function calculates values for every row, we must use `DISTINCT` to return only unique (Month, Department, Comparison) triplets.
    * **Loại bỏ trùng lặp:** Vì hàm cửa sổ tính toán các giá trị cho mỗi hàng, chúng ta phải sử dụng `DISTINCT` để chỉ trả về các bộ ba duy nhất (Tháng, Phòng ban, So sánh).*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Precision Handling:** Average calculations should remain numeric until the comparison is finished. In some SQL dialects, casting to float might be needed for accuracy.
    * **Xử lý độ chính xác:** Các phép tính trung bình nên được giữ ở dạng số cho đến khi quá trình so sánh kết thúc. Trong một số phương ngữ SQL, có thể cần ép kiểu sang float để đảm bảo độ chính xác.*
*   **Logical Flow:** By using CTEs (Common Table Expressions), we keep the logic clean by separating data preparation from the final comparison logic.
    * **Luồng Logic:** Bằng cách sử dụng CTE (Biểu thức Bảng Chung), chúng ta giữ cho logic sạch sẽ bằng cách tách biệt việc chuẩn bị dữ liệu khỏi logic so sánh cuối cùng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ where $N$ is the number of records in the `Salary` table. The sorting required for partitioning by window functions dominates the complexity.
    * **Độ phức tạp thời gian:** $O(N \log N)$ trong đó $N$ là số lượng bản ghi trong bảng `Salary`. Việc sắp xếp cần thiết cho việc phân vùng bằng các hàm cửa sổ chiếm ưu thế về độ phức tạp.*
*   **Space Complexity:** $O(N)$ for intermediate storage of window function partitions and distinct results.
    * **Độ phức tạp không gian:** $O(N)$ để lưu trữ trung gian các phân vùng hàm cửa sổ và các kết quả duy nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Month: 2017-02**
- Employees: [1: 7000, 2: 6000, 3: 8000]
- Company Avg: (7000+6000+8000)/3 = 7000.
- Dept 1 (Emp 1) Avg: 7000. Comparison: **same**. (Oops, example says higher for dept 1. Let's re-read example).
- Wait, the example logic: Pay 2017-02-28: 1(7k, D1), 2(6k, D2), 3(8k, D2). Company Avg = 7k. D1 avg = 7k (same), D2 avg = 7k (same). 
- *Correction:* The problem requires precision. Always trust the mathematical logic of the data provided.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Comparison problems between a part (Department) and a whole (Company) across a dimension (Time) are best solved with Window Functions. Use `PARTITION BY` to define the scope of your aggregates precisely.
*Các bài toán so sánh giữa một phần (Phòng ban) và toàn thể (Công ty) thông qua một chiều không gian (Thời gian) được giải quyết tốt nhất bằng các Hàm cửa sổ. Sử dụng `PARTITION BY` để xác định chính xác phạm vi của các giá trị tổng hợp.*
---
*Sự công bằng (Fairness) thường được đo lường bằng sự so sánh. Khi ta đặt một cá thể trong bối cảnh của cộng đồng (Department vs Company), ta thấy rõ được vị thế và giá trị tương đối của họ. Dữ liệu không chỉ là những con số, mà là tấm gương phản chiếu sự ưu tiên và phân bổ tài nguyên trong một hệ thống.*
Fairness (Fairness) is often measured by comparison. When we place an individual in the context of the community (Department vs Company), we see clearly their relative status and value. Data is not just numbers, but a mirror reflecting priorities and resource allocation within a system.
