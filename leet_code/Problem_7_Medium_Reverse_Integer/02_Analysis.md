# Analysis for Reverse Integer
# *Phân tích cho bài toán Đảo Ngược Số Nguyên*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `x` (32-bit signed). *Số nguyên `x` (32-bit có dấu).*
*   **Output:** Reversed integer. 0 if overflow. *Số nguyên đảo ngược. 0 nếu tràn số.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   **Overflow Check is Key:** We cannot use `long` (64-bit) to store the reversed number and then check. We must check for overflow *before* it happens during calculation.
    ***Kiểm tra Tràn số là Chìa khóa:** Chúng ta không thể sử dụng `long` (64-bit) để lưu số đảo ngược rồi kiểm tra. Chúng ta phải kiểm tra tràn số *trước khi* nó xảy ra trong quá trình tính toán.*
*   Range: `Integer.MIN_VALUE` (-2147483648) to `Integer.MAX_VALUE` (2147483647).
    *Phạm vi: `Integer.MIN_VALUE` (-2147483648) đến `Integer.MAX_VALUE` (2147483647).*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Pop and Push Digits with Overflow Check
### *Hướng tiếp cận: Lấy và Đẩy Chữ số với Kiểm tra Tràn số*

*   **Intuition:**
    *   Extract the last digit: `pop = x % 10`.
    *   Update `x`: `x = x / 10`.
    *   Append digit to result: `rev = rev * 10 + pop`.
    *   **Crucial Step:** Before `rev * 10 + pop`, check if this operation will cause overflow.
    *   *Ý tưởng:*
        *   *Lấy chữ số cuối: `pop = x % 10`.*
        *   *Cập nhật `x`: `x = x / 10`.*
        *   *Thêm chữ số vào kết quả: `rev = rev * 10 + pop`.*
        *   ***Bước quan trọng:** Trước khi thực hiện `rev * 10 + pop`, kiểm tra xem thao tác này có gây ra tràn số không.*

*   **Overflow Logic:**
    *   `MAX_VALUE = 2147483647`, `MIN_VALUE = -2147483648`.
    *   If `rev > MAX_VALUE / 10`, then `rev * 10` will overflow. Return 0.
        *Nếu `rev > MAX_VALUE / 10`, thì `rev * 10` sẽ bị tràn. Trả về 0.*
    *   If `rev == MAX_VALUE / 10`, overflow occurs if `pop > 7` (last digit of MAX).
        *Nếu `rev == MAX_VALUE / 10`, tràn số xảy ra nếu `pop > 7` (chữ số cuối của MAX).*
    *   Similar checks for negative numbers (`MIN_VALUE` and last digit -8).
        *Kiểm tra tương tự cho số âm (`MIN_VALUE` và chữ số cuối -8).*

*   **Complexity:**
    *   Time: $O(\log_{10}(x))$ (Number of digits, roughly 10 iterations). *Thời gian: $O(\log_{10}(x))$ (Số lượng chữ số, khoảng 10 lần lặp).*
    *   Space: $O(1)$. *Không gian: $O(1)$.*

### Dry Run
### *Chạy thử*
`x = 123`
1.  `pop = 3`, `x = 12`. `rev` safe `0`. `rev` becomes 3.
2.  `pop = 2`, `x = 1`. `rev` safe `3`. `rev` becomes 32.
3.  `pop = 1`, `x = 0`. `rev` safe `32`. `rev` becomes 321.
Result: 321.

`x = 1534236469` (Reversing gives 9646324351 > MAX 2147483647).
...
At last step: `rev` is `964632435`. `pop` is 1.
`rev > MAX/10` (964632435 > 214748364) is TRUE.
Check returns 0.
