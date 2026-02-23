# Analysis for Valid Number
# *Phân tích cho bài toán Số Hợp Lệ*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s`. *Chuỗi `s`.*
*   **Output:** Boolean (valid or not). *Boolean (hợp lệ hay không).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Complexity should be $O(N)$ with one pass.
*   Multiple rules to follow: sign, decimal, scientific notation, etc.
*   *Độ phức tạp nên là $O(N)$ với một lần duyệt.*
*   *Nhiều quy tắc cần tuân theo: dấu, số thập phân, ký hiệu khoa học, v.v.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Finite State Logic (DFA style)
### *Hướng tiếp cận: Logic Máy Trạng Thái Hữu Hạn (kiểu DFA)*

*   **Intuition:** We sweep the string and maintain flags for `digitSeen`, `dotSeen`, and `eSeen`. Reset the flags for signs/digits after 'e' or 'E'.
*   *Ý tưởng: Chúng ta duyệt chuỗi và duy trì các cờ cho `đã_thấy_số`, `đã_thấy_chấm`, và `đã_thấy_e`. Đặt lại các cờ cho dấu/chữ số sau khi gặp 'e' hoặc 'E'.*

*   **Rules Implementation:**
    1.  `dotSeen`: Cannot see another dot after a dot or 'e'.
    2.  `eSeen`: Cannot see another 'e' after 'e'. Must see at least one digit before 'e'.
    3.  `sign`: Can only appear at index 0 or immediately after 'e'/'E'.
    4.  `digits`: Must see at least one digit overall. After 'e', must see at least one more digit.

*   **Algorithm Steps:**
    1.  Initialize `digitSeen = false`, `dotSeen = false`, `eSeen = false`.
    2.  Iterate `char c` in `s`:
        *   If `c` is digit: `digitSeen = true`.
        *   If `c` is '.': if `dotSeen` or `eSeen` return false. `dotSeen = true`.
        *   If `c` is 'e' or 'E': if `eSeen` or `!digitSeen` return false. `eSeen = true`, reset `digitSeen = false` (to ensure at least one digit after 'e').
        *   If `c` is '+' or '-': if not at start and not after 'e'/'E', return false.
        *   Else: return false (invalid char).
    3.  Return `digitSeen` (ensures trailing 'e' or empty strings are invalid).

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`s = "3e+7"`
1. '3': digitSeen = true.
2. 'e': eSeen = true, digitSeen = false.
3. '+': allowed after 'e'.
4. '7': digitSeen = true.
End. Return `digitSeen` (true).
---
*Việc quản lý trạng thái bằng các cờ giúp xử lý các trường hợp phức tạp một cách gọn gàng.*
Managing states with flags helps handle complex cases cleanly.
