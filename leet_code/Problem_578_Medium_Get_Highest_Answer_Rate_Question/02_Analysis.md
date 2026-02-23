# Analysis for Get Highest Answer Rate Question
# *Phân tích cho bài toán Lấy Câu hỏi có Tỷ lệ Trả lời Cao nhất*

## 1. Problem Essence & Efficiency Metrics
## *1. Bản chất vấn đề & Các chỉ số Hiệu quả*

### The Challenge
### *Thách thức*
We need to calculate the "Answer Rate" for each question and identify the one with the highest rate.
*Chúng ta cần tính toán "Tỷ lệ Trả lời" cho mỗi câu hỏi và xác định câu hỏi có tỷ lệ cao nhất.*

The answer rate is defined as: `count(answers) / count(shows)`.
*Tỷ lệ trả lời được định nghĩa là: `số lần trả lời / số lần hiển thị`.*

If there is a tie, we must pick the smallest `question_id`.
*Nếu có sự cân bằng, chúng ta phải chọn `question_id` nhỏ nhất.*

---

## 2. Strategy: Conditional Aggregation with Sorting
## *2. Chiến lược: Tổng hợp có điều kiện với Sắp xếp*

Instead of performing separate counts and joins, we can use conditional summation (`SUM` with `CASE` or `IF`) within a single `GROUP BY` block.
*Thay vì thực hiện các phép đếm và nối riêng biệt, chúng ta có thể sử dụng phép tổng có điều kiện (`SUM` với `CASE` hoặc `IF`) trong một khối `GROUP BY` duy nhất.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Group by Question:** Use `GROUP BY question_id` to aggregate data for each unique question.
    * **Nhóm theo Câu hỏi:** Sử dụng `GROUP BY question_id` để tổng hợp dữ liệu cho mỗi câu hỏi duy nhất.*

2.  **Calculate Shows and Answers:** 
    * **Tính số lần Hiển thị và Trả lời:**
    - `Shows = SUM(CASE WHEN action = 'show' THEN 1 ELSE 0 END)`
    - `Answers = SUM(CASE WHEN action = 'answer' THEN 1 ELSE 0 END)`
    - *Lưu ý: Bạn cũng có thể dùng `COUNT(answer_id)` vì nó chỉ tồn tại cho hành động 'answer'.*

3.  **Define Priority (Sorting):** Sort the results based on the ratio `Answers / Shows` in descending order.
    * **Xác định Ưu tiên (Sắp xếp):** Sắp xếp kết quả dựa trên tỷ lệ `Answers / Shows` theo thứ tự giảm dần.*
    - If the ratios are equal, sort by `question_id` in ascending order.
    - *Nếu các tỷ lệ bằng nhau, hãy sắp xếp theo `question_id` theo thứ tự tăng dần.*

4.  **Extract Winner:** Use `LIMIT 1` to get only the top `question_id`.
    * **Trích xuất Người thắng cuộc:** Sử dụng `LIMIT 1` để chỉ lấy `question_id` hàng đầu.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Avoid Division by Zero:** Since every answer must be preceded (or at least accompanied) by a 'show', `Shows` shouldn't be zero for valid questions. However, the calculation is robust because we only look at items that triggered actions.
    * **Tránh chia cho 0:** Vì mỗi câu trả lời phải được đi kèm (hoặc ít nhất là đi sau) một lượt 'hiển thị', `Shows` không nên bằng không cho các câu hỏi hợp lệ. Tuy nhiên, phép tính vẫn mạnh mẽ vì chúng ta chỉ xem xét các danh mục đã kích hoạt hành động.*
*   **One-Pass Aggregation:** Conditional `SUM` is very efficient compared to subqueries or complex joins.
    * **Tổng hợp một lượt:** `SUM` có điều kiện rất hiệu quả so với các truy vấn con hoặc các phép nối phức tạp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$, where $N$ is the number of rows in `SurveyLog`. This involves grouping and a final sort.
    * **Độ phức tạp thời gian:** $O(N \log N)$, trong đó $N$ là số hàng trong `SurveyLog`. Điều này bao gồm việc nhóm và một bước sắp xếp cuối cùng.*
*   **Space Complexity:** $O(Q)$, where $Q$ is the number of unique questions, to store the intermediate counts in the database.
    * **Độ phức tạp không gian:** $O(Q)$, trong đó $Q$ là số lượng câu hỏi duy nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:**
- Q285: show, answer. Ratio = 1/1 = 1.0.
- Q369: show, skip. Ratio = 0/1 = 0.0.
- **Sorting:**
  - 1. Q285 (Ratio 1.0)
  - 2. Q369 (Ratio 0.0)
- **Top 1:** Question 285.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use conditional aggregation (`SUM` of `CASE`) to calculate ratios and metrics across different categories in a single query pass.
*Sử dụng tổng hợp có điều kiện (`SUM` của `CASE`) để tính toán các tỷ lệ và chỉ số qua các danh mục khác nhau trong một lần truy vấn duy nhất.*
---
*Mỗi câu hỏi (Question) đều mang một giá trị tiềm năng. Tỷ lệ phản hồi (Answer rate) chính là nhịp đập của sự tương tác. Bằng cách quan tâm đến cả sự hiện diện (Show) lẫn hành động (Answer), ta tìm thấy những gì thực sự thu hút được tâm trí của người dùng.*
Every question (Question) carries a potential value. The response rate (Answer rate) is the pulse of interaction. By paying attention to both presence (Show) and action (Answer), we find what truly attracts the user's mind.
