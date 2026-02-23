# Analysis for Word Break II
# *Phân tích cho bài toán Tách Từ II*

## 1. Problem Essence & Complexity
## *1. Bản Chất Vấn Đề & Độ Phức Tạp*

### Beyond Boolean Result
### *Hơn Cả Mọi Kết Quả Boolean*
*   In Part I (139), we only needed to know *if* a segmentation was possible. In Part II, we must return **all** possible segmentations.
    *Trong Phần I (139), chúng ta chỉ cần biết *liệu* một sự phân tách có khả thi hay không. Trong Phần II, chúng ta phải trả về **tất cả** các cách phân tách có thể.*
*   The string length constraint ($N \le 20$) is much smaller than Part I ($N \le 300$). This is because the number of possible sentences can grow exponentially.
    *Ràng buộc đội dài chuỗi ($N \le 20$) nhỏ hơn nhiều so với Phần I ($N \le 300$). Điều này là do số lượng các câu khả thi có thể tăng theo hàm mũ.*

### Strategy Selection
### *Lựa Chọn Chiến Lược*
*   A pure backtracking approach without optimization will recalculate lists of results for the same suffixes repeatedly.
    *Một phương pháp quay lui thuần túy không có tối ưu hóa sẽ tính toán lại danh sách kết quả cho cùng một hậu tố nhiều lần.*
*   To solve this efficiently, we use **Backtracking with Memoization** (also known as Top-Down Dynamic Programming).
    *Để giải quyết vấn đề này hiệu quả, chúng ta sử dụng **Quay lui với Ghi nhớ (Memoization)** (còn được gọi là Quy hoạch động từ trên xuống).*

---

## 2. Approach: Backtracking with Memoization
## *2. Hướng Tiếp Cận: Quay Lui với Ghi nhớ*

### Logic
### *Logic*
1.  Maintain a `HashMap<String, List<String>> memo` where the key is a substring and the value is a list of all valid segmentations of that substring.
    *Duy trì một `HashMap<String, List<String>> memo` trong đó khóa là một chuỗi con và giá trị là danh sách tất cả các cách phân tách hợp lệ của chuỗi con đó.*
2.  Define a recursive function `breakWord(s)`:
    -   **Base Case:** If `s` is empty, return a list containing an empty string `[""]`.
    -   **Memo Check:** If `s` is already in `memo`, return the cached list.
    -   **Loop through prefixes:** For each possible split `i` from 1 to `s.length()`:
        -   `prefix = s.substring(0, i)`.
        -   If `prefix` is in `wordDict`:
            -   `suffixSolutions = breakWord(s.substring(i))`.
            -   For each `suffixSol` in `suffixSolutions`:
                -   Add `prefix + (suffixSol.isEmpty() ? "" : " " + suffixSol)` to our current results.
3.  Store the final result for `s` in `memo` and return it.

---

## 3. Structural Advantages
## *3. Ưu Điểm Cấu Trúc*

*   **Recursive Decomposition:** We break the problem into smaller and smaller suffixes. This is very clean and follows the "divide and conquer" philosophy.
    *Phân tách đệ quy: Chúng ta chia bài toán thành các hậu tố ngày càng nhỏ hơn. Điều này rất sạch sẽ và tuân theo triết lý "chia để trị".*
*   **Performance:** Memoization ensures that once a starting point's solutions are found, they are reused. This is crucial for strings with many redundant fragments.
    *Hiệu suất: Ghi nhớ đảm bảo rằng một khi các giải pháp của một điểm bắt đầu được tìm thấy, chúng sẽ được tái sử dụng. Điều này rất quan trọng đối với các chuỗi có nhiều đoạn dư thừa.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** In the worst case, $O(2^N)$. However, with memoization and the given constraints ($N \le 20$), the actual work is much less. The output size limit ($10^5$) also restricts the runtime.
    *Độ phức tạp thời gian: Trong trường hợp xấu nhất là $O(2^N)$. Tuy nhiên, với việc ghi nhớ và các ràng buộc đã cho ($N \le 20$), công việc thực tế ít hơn nhiều. Giới hạn kích thước đầu ra ($10^5$) cũng làm hạn chế thời gian chạy.*
*   **Space Complexity:** $O(2^N \cdot N)$. We store lists of strings in the memoization map. Each string can be $O(N)$ in length.
    *Độ phức tạp không gian: $O(2^N \cdot N)$. Chúng ta lưu trữ các danh sách chuỗi trong bảng ghi nhớ. Mỗi chuỗi có thể có độ dài $O(N)$.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

This "Hard" problem is an excellent test of recursive thinking. The difference between Part I and Part II highlights how a change in the required output (boolean vs. exhaustive list) shifts the optimal algorithm from plain DP to search-based backtracking. Using a `Map` for memoization is the industry-standard way to handle these types of "All Paths" problems.
*Bài toán "Khó" này là một bài kiểm tra tuyệt vời về tư duy đệ quy. Sự khác biệt giữa Phần I và Phần II làm nổi bật cách sự thay đổi trong đầu ra được yêu cầu (boolean so với danh sách đầy đủ) chuyển đổi thuật toán tối ưu từ DP thông thường sang quay lui dựa trên tìm kiếm. Sử dụng `Map` để ghi nhớ là cách tiêu chuẩn công nghiệp để xử lý các loại bài toán "Tất cả các con đường" này.*
---
*Đôi khi một cái cây lớn có hàng ngàn cách để đâm chồi, và việc ghi lại từng con đường ấy chính là cách để thấu hiểu sự phong phú của tự nhiên.*
Sometimes a large tree has thousands of ways to sprout, and recording each of those paths is the way to understand the richness of nature.
