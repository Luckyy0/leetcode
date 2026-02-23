# Analysis for Roman to Integer
# *Phân tích cho bài toán Đổi Số La Mã sang Số Nguyên*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Roman string `s`. *Chuỗi La Mã `s`.*
*   **Output:** Integer `num`. *Số nguyên `num`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 15. *Độ dài lên tới 15.*
*   Valid input guaranteed. *Đảm bảo đầu vào hợp lệ.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Right-to-Left Pass (or Left-to-Right Lookahead)
### *Hướng tiếp cận: Duyệt Phải-sang-Trái (hoặc Trái-sang-Phải nhìn trước)*

*   **Intuition:** If a smaller Roman numeral appears before a larger one, it's subtraction. Otherwise, it's addition.
    *Ý tưởng: Nếu một số tự La Mã nhỏ hơn xuất hiện trước số lớn hơn, đó là phép trừ. Ngược lại, đó là phép cộng.*
*   **Strategy:** Map each char to value.
    *   Iterate from left to right.
    *   If `map(s[i]) < map(s[i+1])`: subtract `map(s[i])`.
    *   Else: add `map(s[i])`.
    *   Last element always added.
*   **Hash Map Replacement:** Since characters are fixed, we can use a helper function or switch statement instead of `HashMap` for better performance.
    *Thay thế Bảng Băm: Vì các ký tự là cố định, chúng ta có thể dùng hàm hỗ trợ hoặc cấu trúc switch thay vì `HashMap` để có hiệu suất tốt hơn.*

*   **Algorithm Steps:**
    1.  Initialize `sum = 0`.
    2.  Loop `i` from 0 to `n-2`:
        *   If `val(s[i]) < val(s[i+1])`: `sum -= val(s[i])`.
        *   Else: `sum += val(s[i])`.
    3.  Add `val(s[n-1])`.
    4.  Return `sum`.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`s = "MCMXCIV"`
1.  M (1000) >= C (100)? Yes. Wait, checking `s[i] < s[i+1]`.
2.  M (1000) vs C (100). 1000 !< 100. Add 1000. Sum 1000.
3.  C (100) vs M (1000). 100 < 1000. Subtract 100. Sum 900.
4.  M (1000) vs X (10). Add 1000. Sum 1900.
5.  X (10) vs C (100). Subtract 10. Sum 1890.
6.  C (100) vs I (1). Add 100. Sum 1990.
7.  I (1) vs V (5). Subtract 1. Sum 1989.
8.  Last V (5). Add 5. Sum 1994.
