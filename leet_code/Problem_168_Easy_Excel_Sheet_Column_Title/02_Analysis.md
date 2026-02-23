# Analysis for Excel Sheet Column Title
# *Phân tích cho bài toán Tiêu đề cột trong Excel*

## 1. Problem Essence & Base-26 Logic
## *1. Bản chất vấn đề & Logic hệ cơ số 26*

### Identifying the Pattern
### *Xác định mẫu hình*
This problem is essentially converting a decimal (base-10) number into a base-26 numbering system where 'A' to 'Z' are the digits.
*Bài toán này về bản chất là chuyển đổi một số thập phân (hệ cơ số 10) sang hệ cơ số 26, trong đó 'A' đến 'Z' là các chữ số.*

### The "1-Indexed" Twist
### *Nút thắt "Đánh số từ 1"*
In standard base conversion (like decimal to binary), the digits are `0, 1, ..., base-1.`. In Excel, the digits are effectively `1, 2, ..., 26`. There is no symbol for `0`.
- 1 is 'A'
- 26 is 'Z'
- 27 is 'AA' (Which is $1 \times 26^1 + 1 \times 26^0$)
*Trong chuyển đổi cơ số tiêu chuẩn (như thập phân sang nhị phân), các chữ số là `0, 1, ..., cơ số-1`. Trong Excel, các chữ số thực sự là `1, 2, ..., 26`. Không có biểu tượng cho số `0`.*

Because of this 1-indexing, a direct modulo operation `columnNumber % 26` will result in `0` for 'Z', which is problematic for mapping.
*Do việc đánh số từ 1 này, phép toán modulo trực tiếp `columnNumber % 26` sẽ cho kết quả là `0` đối với 'Z', gây khó khăn cho việc ánh xạ.*

---

## 2. Approach: Iterative Reduction with Offset
## *2. Hướng tiếp cận: Thu gọn lặp lại với độ lệch*

### The "Subtract One" Trick
### *Mẹo "Trừ một"*
To align the 1-26 range (Excel) with a 0-25 range (suitable for modulo), we simply subtract `1` from the `columnNumber` before taking the modulo.
*Để căn chỉnh phạm vi 1-26 (Excel) với phạm vi 0-25 (phù hợp với modulo), chúng ta chỉ cần trừ `1` từ `columnNumber` trước khi lấy modulo.*

### Algorithm Steps
### *Các bước thuật toán*
1.  Initialize a `StringBuilder` to store the characters.
2.  While `columnNumber > 0`:
    a. Decrement `columnNumber` by 1. (`columnNumber--`)
    b. Calculate the remainder: `rem = columnNumber % 26`.
    c. Convert the remainder to a character: `(char)('A' + rem)`. 
       - 0 becomes 'A', 25 becomes 'Z'.
    d. Append the character to the `StringBuilder`.
    e. Update the number: `columnNumber /= 26`.
3.  **Reverse** the result string (since we built it from right to left).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logic Cleanliness:** The `columnNumber--` trick is the most elegant way to handle the lack of a zero symbol in the Excel system. It avoids messy conditional checks for multiples of 26.
    *Sự sạch sẽ về logic: Mẹo `columnNumber--` là cách trang nhã nhất để xử lý việc thiếu biểu tượng số không trong hệ thống Excel.*
*   **Scalability:** This approach works for any size of `columnNumber` as long as it fits in a 32-bit (or 64-bit) integer.
    *Tính mở rộng: Phương pháp này hoạt động với bất kỳ kích thước nào của `columnNumber`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log_{26} N)$, where $N$ is the input number. The number of iterations is the number of characters in the resulting title. For a 32-bit integer, this is at most 7-8 characters.
    *Độ phức tạp thời gian: $O(\log_{26} N)$. Số lần lặp chính là số ký tự trong tiêu đề kết quả.*
*   **Space Complexity:** $O(\log_{26} N)$ or $O(1)$ excluding the output string. We only use a constant amount of extra space during calculation.
    *Độ phức tạp không gian: $O(1)$ (không tính chuỗi kết quả).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `columnNumber = 28`

1. `columnNumber = 28`.
2. `col--` -> `27`. `rem = 27 % 26 = 1`. Char: `'A' + 1 = 'B'`. SB: "B".
3. `col = 27 / 26 = 1`.
4. `col--` -> `0`. `rem = 0 % 26 = 0`. Char: `'A' + 0 = 'A'`. SB: "BA".
5. `col = 0 / 26 = 0`. End loop.
6. Reverse "BA" -> **"AB"**.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Excel Column Title is a classic base-conversion problem with a twist. The most frequent pitfall is forgetting to handle the 'Z' case (multiples of 26). The `columnNumber--` strategy is far superior to using `if (rem == 0)` checks as it naturally accommodates the mapping at every power level of 26. Always remember to reverse the string at the end.
*Tiêu đề cột Excel là một bài toán chuyển đổi cơ số kinh điển có chút biến tấu. Cạm bẫy thường gặp nhất là quên xử lý trường hợp 'Z' (bội số của 26). Chiến lược `columnNumber--` vượt trội hơn nhiều so với việc sử dụng các kiểm tra `if (rem == 0)` vì nó tự nhiên điều chỉnh ánh xạ ở mọi cấp lũy thừa của 26. Luôn nhớ đảo ngược chuỗi ở bước cuối cùng.*
---
*Mọi dãy ký tự phức tạp đều bắt nguồn từ một chu kỳ đơn giản gồm 26 nhịp đập.*
Every complex sequence of characters originates from a simple cycle of 26 heartbeats.
