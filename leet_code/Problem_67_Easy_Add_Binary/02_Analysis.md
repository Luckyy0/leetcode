# Analysis for Add Binary
# *Phân tích cho bài toán Cộng Nhị Phân*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two binary strings `a` and `b`. *Hai chuỗi nhị phân `a` và `b`.*
*   **Output:** Binary sum string. *Chuỗi tổng nhị phân.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Strings can be up to $10^4$ characters. Cannot convert to `long`.
*   *Các chuỗi có thể lên tới $10^4$ ký tự. Không thể chuyển sang kiểu `long`.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Bit-by-bit Simulation
### *Hướng tiếp cận: Mô phỏng từng bit*

*   **Intuition:** Simulate manual addition from right to left using a carry.
*   *Ý tưởng: Mô phỏng phép cộng thủ công từ phải sang trái bằng cách sử dụng số nhớ.*

*   **Algorithm Steps:**
    1.  Use `StringBuilder` to store the result.
    2.  `i = a.length - 1`, `j = b.length - 1`, `carry = 0`.
    3.  While `i >= 0` or `j >= 0` or `carry > 0`:
        *   `sum = carry`.
        *   If `i >= 0`: `sum += a[i--] - '0'`.
        *   If `j >= 0`: `sum += b[j--] - '0'`.
        *   `StringBuilder.append(sum % 2)`.
        *   `carry = sum / 2`.
    4.  Reverse the `StringBuilder` and return as string.

*   **Complexity:**
    *   Time: $O(\max(N, M))$.
    *   Space: $O(\max(N, M))$ for `StringBuilder`.

### Dry Run
### *Chạy thử*
`a = "11", b = "1"`
1. `i=1, j=0, carry=0`: `sum = 0 + 1 + 1 = 2`. `sb="0", carry=1`.
2. `i=0, j=-1, carry=1`: `sum = 1 + 1 = 2`. `sb="00", carry=1`.
3. `i=-1, j=-1, carry=1`: `sum = 1`. `sb="001", carry=0`.
4. Reverse `sb` -> "100".
---
*Việc mô phỏng từng bit đảm bảo xử lý được các chuỗi cực lớn.*
Simulating bit-by-bit ensures handling of extremely large strings.
