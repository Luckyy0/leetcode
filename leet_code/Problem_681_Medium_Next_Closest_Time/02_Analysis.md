# Analysis for Next Closest Time
# *Phân tích cho bài toán Thời gian Gần nhất Tiếp theo*

## 1. Problem Essence & Circular Time
## *1. Bản chất vấn đề & Thời gian Vòng lặp*

### The Challenge
### *Thách thức*
We need to find the earliest time in the future that can be constructed using only the digits found in the current time. If no such time exists for the current day, it must be the earliest valid time on the next day.
*Chúng ta cần tìm thời điểm sớm nhất trong tương lai có thể được xây dựng chỉ bằng các chữ số có trong thời gian hiện tại. Nếu không có thời điểm nào như vậy trong ngày hiện tại, nó phải là thời điểm sớm nhất hợp lệ vào ngày hôm sau.*

---

## 2. Strategy: Brute Force Minute-by-Minute
## *2. Chiến lược: Duyệt từng Phút*

Since there are only 1440 minutes in a full 24-hour cycle, the most robust way is to simulate the clock moving forward minute by minute.
*Vì chỉ có 1440 phút trong một chu kỳ 24 giờ, cách mạnh mẽ nhất là mô phỏng đồng hồ chạy tiến về phía trước từng phút một.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Extract Allowed Digits:** Collect all unique digits from the input string and store them in a set.
    * **Trích xuất các chữ số được phép:** Thu thập tất cả các chữ số duy nhất từ chuỗi đầu vào.*

2.  **Simulation Loop:**
    - Convert input "HH:MM" to total minutes passed since 00:00.
    - Start a loop for 1440 iterations. 
    - In each iteration, increment the current minutes by 1 (modulo 1440).
    - Convert the new minute count back to "HH" and "MM".
    - Check if every digit in the new "HH:MM" exists in the set of allowed digits.
    - If yes, this is the **next closest time**. Return it.
    * **Vòng lặp Mô phỏng:** Chuyển đổi đầu vào thành tổng số phút. Chạy vòng lặp 1440 lần, mỗi lần tăng thêm 1 phút. Kiểm tra xem các chữ số của thời gian mới có nằm trong tập hợp cho phép hay không. Nếu có, đó là đáp án.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Handling Day Transitions:** The use of `modulo 1440` naturally handles the transition from "23:59" to "00:00" without extra branch logic.
    * **Xử lý Chuyển ngày:** Việc sử dụng phép chia lấy dư 1440 giúp xử lý tự nhiên việc chuyển từ 23:59 sang 00:00.*
*   **Completeness:** By checking every minute, we guarantee finding the truly closest time in the future.
    * **Tính đầy đủ:** Bằng cách kiểm tra từng phút, chúng ta đảm bảo tìm được thời gian gần nhất thực sự.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. We iterate a maximum of 1440 times, which is a constant regardless of the input value.
    * **Độ phức tạp thời gian:** $O(1)$.*
*   **Space Complexity:** $O(1)$ to store the set of allowed digits (maximum 4 digits).
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** "19:34"
1. Allowed digits: {1, 9, 3, 4}.
2. Current: 19*60 + 34 = 1174 mins.
3. +1 min: 1175 -> "19:35". 5 not allowed.
4. ...
5. +5 min: 1179 -> "19:39". Digits {1, 9, 3, 9} are all allowed.
**Result:** "19:39".

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

In time-related problems with a small domain (like 24 hours), brute force simulation is often simpler and less error-prone than complex recursive or combinatoric approaches.
*Trong các bài toán liên quan đến thời gian với phạm vi nhỏ, mô phỏng vét cạn thường đơn giản và ít sai sót hơn các phương pháp tổ hợp phức tạp.*
---
*Thời gian (Time) là một vòng tròn vô tận (Modulo 1440). Trong cuộc tìm kiếm sự kế thừa (Next closest), ta lần theo từng nhịp đập của kim phút để tìm thấy sự lặp lại của bản thể (Allowed digits). Dữ liệu dạy ta rằng bằng cách kiên trì bước tới (Minute-by-minute), ta sẽ tìm thấy sự tương đồng hoàn hảo trong một hình hài mới của tương lai.*
Time (Time) is an infinite circle (Modulo 1440). In the search for inheritance (Next closest), we follow every beat of the minute hand to find the repetition of the self (Allowed digits). Data teaches us that by persistently stepping forward (Minute-by-minute), we will find perfect similarity in a new form of the future.
