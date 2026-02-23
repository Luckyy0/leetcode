# Analysis for Excel Sheet Column Number
# *Phân tích cho bài toán Số cột trong Excel*

## 1. Problem Essence & Base-26 Logic
## *1. Bản chất vấn đề & Logic hệ cơ số 26*

### The Reverse Mapping
### *Ánh xạ ngược*
This problem is the inverse of "Excel Sheet Column Title" (168). Here, we are given a string (base-26) and must convert it to a decimal (base-10) integer.
*Bài toán này là nghịch đảo của "Excel Sheet Column Title" (168). Ở đây, chúng ta được cho một chuỗi (hệ cơ số 26) và phải chuyển đổi nó thành số nguyên thập phân (hệ cơ số 10).*

### Base Calculation Principle
### *Nguyên lý tính toán hệ cơ số*
In a standard base conversion (like binary or hexadecimal), each position $i$ (from right) has a value of $Digit \times Base^i$.
- Binary `101` = $1 \times 2^2 + 0 \times 2^1 + 1 \times 2^0 = 4 + 0 + 1 = 5$.
- Excel `AA` = $1 \times 26^1 + 1 \times 26^0 = 26 + 1 = 27$.
*Trong chuyển đổi hệ cơ số tiêu chuẩn, mỗi vị trí $i$ có giá trị bằng $Chữ số \times Cơ số^i$.*

---

## 2. Approach: Left-to-Right Iterative Accumulation
## *2. Hướng tiếp cận: Tích lũy lặp lại từ trái sang phải*

### Logic
### *Logic*
Instead of calculating $26^i$ explicitly, we can iterate from left to right and multiply our current total by 26 before adding the next digit. This is highly efficient and avoids floating-point operations.
*Thay vì tính $26^i$ một cách tường minh, chúng ta có thể lặp từ trái sang phải và nhân tổng hiện tại với 26 trước khi cộng thêm chữ số tiếp theo. Cách này rất hiệu quả và tránh được các phép toán dấu phẩy động.*

1.  Initialize `result = 0`.
2.  Iterate through each character `c` in the `columnTitle` from index 0 to length-1.
3.  Calculate the value of the character: `val = c - 'A' + 1`. 
    - 'A' becomes 1, 'B' becomes 2, ..., 'Z' becomes 26.
4.  Update the result: `result = result * 26 + val`.
5.  Return the final `result`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Simplicity:** The logic follows the natural reading order (left to right), making it very intuitive to implement.
    *Sự đơn giản tuyến tính: Logic tuân theo thứ tự đọc tự nhiên (từ trái sang phải), rất trực quan để triển khai.*
*   **No Buffer Required:** Unlike the reverse operation which usually requires a `StringBuilder`, this operation only needs a single integer variable to accumulate the result.
    *Không cần bộ đệm: Không giống như thao tác ngược lại thường yêu cầu `StringBuilder`, thao tác này chỉ cần một biến nguyên duy nhất.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L)$, where $L$ is the length of the string `columnTitle`. We process each character exactly once.
    *Độ phức tạp thời gian: $O(L)$, trong đó $L$ là độ dài của chuỗi. Chúng ta xử lý mỗi ký tự đúng một lần.*
*   **Space Complexity:** $O(1)$. We only use a single integer variable for the calculation.
    *Độ phức tạp không gian: $O(1)$. Chỉ sử dụng một biến số nguyên duy nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `columnTitle = "ZY"`

1. `result = 0`.
2. `c = 'Z'`: 
   - `val = 'Z' - 'A' + 1 = 26`.
   - `result = 0 * 26 + 26 = 26`.
3. `c = 'Y'`:
   - `val = 'Y' - 'A' + 1 = 25`.
   - `result = 26 * 26 + 25 = 676 + 25 = 701`.

**Result:** 701.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Excel Column Number is a straightforward base-conversion problem. The most important thing to remember is the offset of `1`. In programming, `'A' - 'A'` is 0, so you must always add 1 to match Excel's system. This problem is very similar to `String to Integer (atoi)` or parsing any number in a specific base.
*Số cột Excel là một bài toán chuyển đổi hệ cơ số đơn giản. Điều quan trọng nhất cần nhớ là độ lệch `1`. Trong lập trình, `'A' - 'A'` bằng 0, vì vậy bạn phải luôn cộng thêm 1 để khớp với hệ thống của Excel. Bài toán này rất giống với `atoi` hoặc phân tích bất kỳ con số nào trong một hệ cơ số cụ thể.*
---
*Những chữ cái vốn vô tri bỗng trở nên sống động khi chúng mang trong mình sức mạnh của những con số bền bỉ.*
Letters that were once lifeless suddenly come alive when they carry the power of persistent numbers.
