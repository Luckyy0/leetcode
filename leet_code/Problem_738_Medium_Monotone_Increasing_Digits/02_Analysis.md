# Analysis for Monotone Increasing Digits
# *Phân tích cho bài toán Số có các Chữ số Tăng dần Đơn điệu*

## 1. Problem Essence & Greedy Correction
## *1. Bản chất vấn đề & Hiệu chỉnh Tham lam*

### The Challenge
### *Thách thức*
We need the largest number $\le N$ whose digits are in non-decreasing order. If $N$ already satisfies this (e.g., `123`), the answer is $N$. If not (e.g., `332`), we must decrease one of the digits to resolve the violation and then maximize the following digits.
*Chúng ta cần tìm số lớn nhất $\le N$ có các chữ số không giảm. Nếu $N$ đã thỏa mãn (ví dụ `123`), đáp án là chính nó. Nếu không (ví dụ `332`), ta phải giảm giá trị của một chữ số để khắc phục sự vi phạm trật tự, sau đó tối đa hóa các chữ số đi sau.*

---

## 2. Strategy: Right-to-Left Scanning
## *2. Chiến lược: Quét từ Phải sang Trái*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Preparation:** Convert the number into a character array for mutability.
    * **Chuẩn bị:** Chuyển số thành mảng ký tự để có thể chỉnh sửa.*

2.  **Greedy Violation Search:**
    - Scan the array from right to left, starting from the second to last digit.
    - If `s[i-1] > s[i]`:
        - This is a violation. To fix it while keeping the number as large as possible, we decrement `s[i-1]`.
        - Mark the index `i` as the start of a "9-zone".
    - Because we go from right to left, a decrement in the middle will propagate correctly if it creates a new violation with the digit to its left.
    * **Tìm kiếm Vi phạm:** Duyệt từ phải sang trái. Nếu chữ số bên trái lớn hơn chữ số bên phải (`s[i-1] > s[i]`), ta giảm chữ số bên trái đi 1 đơn vị và đánh dấu vị trí `i` bắt đầu của "vùng số 9".*

3.  **Maximization:** After the loop, turn all digits from the marked index to the end of the array into `9`. This ensures the number is the maximum possible after the necessary decrement.
    * **Tối đa hóa:** Sau khi lặp xong, chuyển toàn bộ các chữ số từ vị trí đã đánh dấu đến hết mảng thành số 9.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(D)$, where $D$ is the number of digits in $N$. Since $N \le 10^9$, $D \le 10$. The algorithm performs two linear passes over the digits.
    * **Độ phức tạp thời gian:** $O(D)$.*
*   **Space Complexity:** $O(D)$ to store the character array.
    * **Độ phức tạp không gian:** $O(D)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**N = 332**
1. s = ['3', '3', '2']
2. i=2: '3' > '2'. s[1] -> '2', marker = 2. s = ['3', '2', '2']
3. i=1: '3' > '2'. s[0] -> '2', marker = 1. s = ['2', '2', '2']
4. Final Step: Change everything from index 1 to '9'.
**Result:** 299.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The right-to-left greedy approach is optimal because it resolves the most significant violations first and allows "9s" to fill the lower-significance slots. This pattern is common in problems requiring lexicographical or numerical maximization under constraints.
*Cách tiếp cận tham lam từ phải sang trái là tối ưu vì nó giải quyết các vi phạm quan trọng nhất trước và cho phép các số "9" lấp đầy các vị trí ít quan trọng hơn.*
---
*Sự đơn điệu (Monotonicity) trong các con số là một dòng chảy không bao giờ ngoái đầu. Khi một chữ số vượt qua giới hạn của kẻ đi sau, nó buộc phải lùi lại một bước (Decrement) để giữ vững trật tự. Dữ liệu dạy ta rằng bằng cách hy sinh một chút ở hiện tại (Decrease the digit) và tối đa hóa mọi khả năng còn lại (Fill with 9s), ta có thể đạt được sự vĩ đại cao nhất (Largest integer) trong ranh giới của sự cho phép.*
Monotonicity (Monotonicity) in numbers is a flow that never looks back. When a digit exceeds the limit of the one behind it, it is forced to step back (Decrement) to maintain order. Data teaches us that by sacrificing a little in the present (Decrease the digit) and maximizing all remaining possibilities (Fill with 9s), we can achieve the highest greatness (Largest integer) within the boundaries of permission.
