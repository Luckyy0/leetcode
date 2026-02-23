# Analysis for Customers Who Bought All Products
# *Phân tích bài toán Những Khách Hàng Đã Mua Lông Toàn Bộ Sản Phẩm*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
You are dealing with a classic relational database scenario. You have two tables: `Customer` which records individual purchase instances (customer x buys product y), and `Product` which serves as a dimensional catalog table holding all valid unique product keys.
The goal is to write a SQL query that retrieves only those `customer_id`s who have purchased EVERY single product listed in the `Product` catalog.
*Đây là trường hợp kinh điển trong các trạm máy chủ dữ liệu Database. Có hai bảng: Bảng `Customer` ghi nhận lịch sử giao dịch (khách hàng X mua sản phẩm Y), và bảng `Product` là danh mục sản phẩm chứa tất cả các mã sản phẩm hợp lệ.*
*Mục tiêu là viết câu lệnh SQL để truy xuất ra những mã `customer_id` của các khách hàng đã mua TOÀN BỘ tất cả các sản phẩm có mặt trong bảng danh mục `Product`.*

---

## 2. Strategy: Optimal (Grouping by Client and Count Distinct Comparison)
## *2. Chiến lược: Tối ưu (Gom Nhóm Theo Khách và Đếm Móc Giá Trị Độc Nhất Trút So Sánh Lọc Gắn Cân)*

### Logic and Rules
### *Lý luận và Quy tắc*

Instead of dynamically looping over every product for every customer, SQL relies on inherently relational aggregation. We can logically approach the problem in basically two conceptual steps:
*Thay vì lập trình vòng lặp kiểm tra từng sản phẩm cho từng khách hàng, SQL xử lý bài toán dựa trên tư duy gom nhóm tập hợp (Aggregation). Chúng ta có thể tiếp cận vấn đề qua 2 bước cốt lõi:*

1. Determine the EXACT absolute mathematically known number of total products in existence globally. This is trivially: `(SELECT COUNT(*) FROM Product)`.
*1. Xác định tổng số lượng toàn bộ các sản phẩm đang thực sự tồn tại ở kho gốc. Phép đếm đơn giản này là: `(SELECT COUNT(*) FROM Product)`.*

2. Group the purchase log table `Customer` categorically by `customer_id`. By doing this, each customer is bucketed with all the products they bought.
*2. Tiến hành gom nhóm bảng lịch sử mua hàng `Customer` theo từng `customer_id` (`GROUP BY customer_id`). Bằng thao tác này, mỗi khách hàng sẽ được nhồi chung vào một nhóm chứa toàn bộ lịch sử mua sắm của họ.*

3. Count strictly HOW MANY UNIQUE products each customer has bought within their bucket (`COUNT(DISTINCT product_key)`).
*Why DISTINCT?* Because the table constraints warn us that duplicate rows are allowed (a customer might buy product '5' multiple times).
*3. Dưới mỗi nhóm khách hàng vừa gộp, tiến hành đếm số lượng SẢN PHẨM KHÁC NHAU mà họ đã mua (`COUNT(DISTINCT product_key)`).*
*Tại sao lại dùng DISTINCT?* Bởi vì ràng buộc đề bài lưu ý rằng bảng mua hàng có thể chứa các dòng trùng lặp (một khách hàng mua cùng 1 mã sản phẩm nhiều lần). Nếu không cạo bỏ trùng lặp sẽ dẫn đến sai lệch kết quả đếm.

4. Filter those buckets using a `HAVING` clause mathematically comparing their counted unique purchases firmly with the total products calculated in step 1.
*4. Lấy bộ lọc `HAVING` để kiểm tra từng nhóm khách hàng. Đem số lượng sản phẩm độc nhất mà khách hàng đó đã mua ra so sánh bằng chính xác với Tổng số sản phẩm (nằm ở Bước 1). Bất cứ khách nào đạt đúng con số này chính là đáp án!*

### SQL Optimal Implementation
### *Triển khai giải pháp SQL Tối Ưu*

```sql
SELECT
    customer_id
FROM
    Customer
GROUP BY
    customer_id
HAVING
    COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Expected $O(N + M)$, where $N$ is the number of rows in `Customer` and $M$ is the number of rows in `Product`. The execution engine safely aggregates functionally and counts uniquely.
    *   **Độ phức tạp thời gian:** $O(N + M)$. Ở đó $N$ và $M$ là số lượng dòng trong hai bảng tương ứng. Một cỗ truy vấn cơ sở dữ liệu sẽ thực thi quét tuyến tính dọc theo các bảng và thiết lập gom nhóm hiệu quả.*
*   **Space Complexity:** $O(C)$ where $C$ represents the total distinct customer groupings securely generated during execution.
    *   **Độ phức tạp không gian:** $O(C)$ phụ thuộc vào cách SQL Engine tổ chức lưu đệm. Ước chừng $O(C)$ với $C$ là số lượng nhóm ID khách hàng `customer_id` cần lưu để phân mảng tính toán trong thuật toán Hash Aggregation.*
