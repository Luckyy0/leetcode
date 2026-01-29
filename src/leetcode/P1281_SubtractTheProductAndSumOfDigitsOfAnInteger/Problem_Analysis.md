# 1281. Subtract the Product and Sum of Digits of an Integer / Trừ Tích và Tổng các Chữ số của một Số nguyên

## Problem Description / Mô tả bài toán
Input: integer `n`.
Return: `(product of digits) - (sum of digits)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Digit Extraction
Extract digits using `n % 10` and `n / 10`.
Accumulate product and sum.
Handle `n` until 0.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Iteration
Iterate through the digits of the number. Extract the last digit using modulo 10. Update the `product` by multiplying with this digit and the `sum` by adding it. Remove the last digit by integer division by 10. Continue until the number is 0. Finally, return `product - sum`.
Lặp lại qua các chữ số của số. Trích xuất chữ số cuối cùng bằng cách sử dụng modulo 10. Cập nhật `product` bằng cách nhân với chữ số này và `sum` bằng cách cộng nó. Xóa chữ số cuối cùng bằng phép chia nguyên cho 10. Tiếp tục cho đến khi số bằng 0. Cuối cùng, trả về `product - sum`.

---
