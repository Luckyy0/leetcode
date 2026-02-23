# Analysis for Friend Requests I: Overall Acceptance Rate
# *Phân tích cho bài toán Yêu cầu Kết bạn I: Tỷ lệ Chấp nhận Tổng thể*

## 1. Problem Essence & Unique Relationships
## *1. Bản chất vấn đề & Các Mối quan hệ Riêng biệt*

### The Challenge
### *Thách thức*
We need to calculate the global acceptance rate: `Total Unique Accepts / Total Unique Requests`.
*Chúng ta cần tính tỷ lệ chấp nhận toàn cầu: `Tổng số chấp nhận riêng biệt / Tổng số yêu cầu riêng biệt`.*

Key constraints to handle:
*Các ràng buộc chính cần xử lý:*
1.  **Uniqueness:** A pair of users might have duplicate records (e.g., same request sent twice or accepted twice if the system allows re-requests). We must use `DISTINCT`.
    * **Tính duy nhất:** Một cặp người dùng có thể có các bản ghi trùng lặp. Chúng ta phải sử dụng `DISTINCT`.*
2.  **Division by Zero:** If there are no requests, the denominator is 0. SQL will return an error or NULL without protection.
    * **Phép chia cho 0:** Nếu không có yêu cầu nào, mẫu số là 0. SQL sẽ trả về lỗi hoặc NULL nếu không có sự bảo vệ.*

---

## 2. Strategy: Subqueries and IFNULL/COALESCE
## *2. Chiến lược: Truy vấn con và IFNULL/COALESCE*

We can treat the counts as independent values calculated in the subquery.
*Chúng ta có thể coi các bộ đếm là các giá trị độc lập được tính toán trong truy vấn con.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Count Unique Requests:**
    * **Đếm số Yêu cầu riêng biệt:**
    - `SELECT COUNT(*) FROM (SELECT DISTINCT sender_id, send_to_id FROM FriendRequest)`
2.  **Count Unique Accepts:**
    * **Đếm số Chấp nhận riêng biệt:**
    - `SELECT COUNT(*) FROM (SELECT DISTINCT requester_id, accepter_id FROM RequestAccepted)`
3.  **Calculate Ratio:** Divide Accepts by Requests. Use `IFNULL` or `COALESCE` with the calculation to handle empty tables.
    * **Tính Tỷ lệ:** Chia số Chấp nhận cho số Yêu cầu. Sử dụng `IFNULL` hoặc `COALESCE` với phép tính để xử lý các bảng trống.*
4.  **Formatting:** Use `ROUND(..., 2)` to match the expected precision.
    * **Định dạng:** Sử dụng `ROUND(..., 2)` để khớp với độ chính xác mong đợi.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Robustness:** By using subqueries to get count constants first, the main query logic becomes very simple and avoids complex joins.
    * **Tính mạnh mẽ:** Bằng cách sử dụng các truy vấn con để lấy các hằng số đếm trước, logic truy vấn chính trở nên rất đơn giản và tránh được các phép nối phức tạp.*
*   **NULL Handling:** In MySQL, `IFNULL(val, 0)` is efficient. In standard SQL, `COALESCE(val, 0)` is used.
    * **Xử lý NULL:** Trong MySQL, `IFNULL(val, 0)` rất hiệu quả. Trong SQL tiêu chuẩn, `COALESCE(val, 0)` được sử dụng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(R + A)$, where $R$ is the number of request records and $A$ is the number of acceptance records. The database performs a distinct count search on each table.
    * **Độ phức tạp thời gian:** $O(R + A)$, trong đó $R$ là số bản ghi yêu cầu và $A$ là số bản ghi chấp nhận.*
*   **Space Complexity:** $O(1)$ additional space beyond the result storage.
    * **Độ phức tạp không gian:** $O(1)$ không gian bổ sung.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:**
- Requests: (1,2), (1,3), (1,4), (2,3), (3,4) -> Distinct Count = 5.
- Accepts: (1,2), (1,3), (2,3), (3,4), (3,4) -> Distinct Accepts = 4 [(1,2), (1,3), (2,3), (3,4)].
**Ratio:** 4 / 5 = 0.80.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

When calculating ratios from independent tables, calculate the numerator and denominator separately using subqueries to ensure clean logic and easy handling of edge cases like zero divisors.
*Khi tính toán các tỷ lệ từ các bảng độc lập, hãy tính tử số và mẫu số riêng biệt bằng cách sử dụng các truy vấn con để đảm bảo logic sạch sẽ và dễ dàng xử lý các trường hợp biên như số chia bằng không.*
---
*Sự kết nối (Connection) bắt đầu từ một lời đề nghị (Request) và hoàn thiện qua sự chấp thuận (Acceptance). Tỷ lệ chấp nhận (Acceptance rate) là nhịp đo của sự cởi mở trong một cộng đồng. Dù đôi khi lời mời bị từ chối, ý định ban đầu (Distinct requests) vẫn là nền tảng của mọi tương tác xã hội.*
Connection (Connection) starts from a proposal (Request) and is completed through approval (Acceptance). The acceptance rate (Acceptance rate) is the pulse of openness in a community. Though invitations are sometimes declined, the original intent (Distinct requests) remains the foundation of all social interaction.
