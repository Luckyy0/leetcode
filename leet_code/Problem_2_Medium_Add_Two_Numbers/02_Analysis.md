# Analysis for Add Two Numbers
# *Phân tích cho bài toán Cộng Hai Số*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two pointers, `l1` and `l2`, pointing to the heads of two singly linked lists. Each node contains a digit (0-9). *Hai con trỏ, `l1` và `l2`, trỏ đến đầu của hai danh sách liên kết đơn. Mỗi nút chứa một chữ số (0-9).*
*   **Output:** The head of a new linked list representing the sum. *Đầu của một danh sách liên kết mới đại diện cho tổng.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   List length up to 100. Small enough for $O(N)$ solution. *Độ dài danh sách lên tới 100. Đủ nhỏ cho giải pháp $O(N)$.*
*   Nodes store digits in **reverse order** (Least Significant Digit first). This simplifies addition because we align numbers from the "ones" place naturally. *Các nút lưu trữ chữ số theo **thứ tự ngược** (Chữ số ít quan trọng nhất trước). Điều này đơn giản hóa phép cộng vì chúng ta căn chỉnh các số từ hàng "đơn vị" một cách tự nhiên.*

### Edge Cases
### *Các trường hợp biên*
*   Lists with different lengths (e.g., `[9,9]` + `[1]`). *Các danh sách có độ dài khác nhau.*
*   Sum that results in an extra carry at the end (e.g., `[9,9]` + `[1]` = `[0,0,1]`). *Tổng tạo ra một số nhớ thừa ở cuối.*
*   Zero inputs (`[0]` + `[0]`). *Đầu vào là số 0.*

## 2. Data Structure Strategy
## *2. Chiến lược Cấu trúc Dữ liệu*

*   We need a `ListNode` class definition. *Chúng ta cần định nghĩa lớp `ListNode`.*
*   We will use standard Singly Linked List operations. *Chúng ta sẽ sử dụng các thao tác Danh sách Liên kết Đơn chuẩn.*
*   Since we cannot use `java.util`, we will manually manage node creation and linking. *Vì không thể dùng `java.util`, chúng ta sẽ quản lý thủ công việc tạo và liên kết nút.*

## 3. Approach & Algorithm
## *3. Giải thuật & Hướng tiếp cận*

### Approach: Elementary Math (Simulation)
### *Hướng tiếp cận: Toán sơ cấp (Mô phỏng)*

*   **Intuition:** Perform addition digit by digit, just like we do on paper, starting from the rightmost digit (which corresponds to the head of the list). *Ý tưởng: Thực hiện phép cộng từng chữ số, giống như làm trên giấy, bắt đầu từ chữ số ngoài cùng bên phải (tương ứng với đầu danh sách).*
*   **Algorithm Steps:**
    1.  Initialize a `dummyHead` to simplify result construction. *Khởi tạo một `dummyHead` để đơn giản hóa việc xây dựng kết quả.*
    2.  Initialize a pointer `current` to `dummyHead` and a variable `carry` to 0. *Khởi tạo con trỏ `current` trỏ đến `dummyHead` và biến `carry` bằng 0.*
    3.  Loop while `l1` is not null OR `l2` is not null OR `carry` is not 0. *Lặp trong khi `l1` không null HOẶC `l2` không null HOẶC `carry` khác 0.*
        *   Get values `x` from `l1` (or 0 if null) and `y` from `l2` (or 0 if null). *Lấy giá trị `x` từ `l1` (hoặc 0 nếu null) và `y` từ `l2` (hoặc 0 nếu null).*
        *   Calculate `sum = x + y + carry`. *Tính `sum = x + y + carry`.*
        *   Update `carry = sum / 10`. *Cập nhật `carry = sum / 10`.*
        *   Create a new node with value `sum % 10` and attach it to `current.next`. *Tạo nút mới với giá trị `sum % 10` và gắn nó vào `current.next`.*
        *   Move `current`, `l1`, and `l2` forward. *Di chuyển `current`, `l1`, và `l2` về phía trước.*
    4.  Return `dummyHead.next`. *Trả về `dummyHead.next`.*

*   **Complexity:**
    *   Time: $O(max(N, M))$ where $N$ and $M$ are lengths of the lists. *Thời gian: $O(max(N, M))$ với $N$ và $M$ là độ dài của các danh sách.*
    *   Space: $O(max(N, M))$ for the new list. *Không gian: $O(max(N, M))$ cho danh sách mới.*

### Dry Run
### *Chạy thử*
Input: `l1 = [2, 4, 3]`, `l2 = [5, 6, 4]`. `carry = 0`.

1.  `2 + 5 + 0 = 7`. Node(7). `carry = 0`. Result: `[7]`. Move `l1` to 4, `l2` to 6.
2.  `4 + 6 + 0 = 10`. Node(0). `carry = 1`. Result: `[7, 0]`. Move `l1` to 3, `l2` to 4.
3.  `3 + 4 + 1 = 8`. Node(8). `carry = 0`. Result: `[7, 0, 8]`. Move `l1` to null, `l2` to null.
4.  Loop ends. Return `[7, 0, 8]`.
