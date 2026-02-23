# Analysis for String to Integer (atoi)
# *Phân tích cho bài toán Chuỗi thành Số Nguyên (atoi)*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s`. *Chuỗi `s`.*
*   **Output:** 32-bit signed integer. *Số nguyên 32-bit có dấu.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to 200. Very small. *Độ dài lên tới 200. Rất nhỏ.*
*   The main challenge is handling the **state machine** logic (Whitespace -> Sign -> Digits -> Stop) and **Overflow**.
    *Thách thức chính là xử lý logic **máy trạng thái** (Khoảng trắng -> Dấu -> Chữ số -> Dừng) và **Tràn số**.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Deterministic Parsing (DFA equivalent)
### *Hướng tiếp cận: Phân tích Cú pháp Xác định (Tương đương DFA)*

*   **Intuition:** Follow the rules strictly step-by-step.
    *Ý tưởng: Tuân thủ các quy tắc nghiêm ngặt từng bước.*

*   **Algorithm Steps:**
    1.  **Trim/Skip Whitespace:** Loop index `i` while `s[i] == ' '`.
    2.  **Check Sign:** If `s[i] == '-'`, sign is -1. If `+`, sign is +1. Increment `i` only if sign found.
    3.  **Read Digits:** Loop while `i < len` and `Character.isDigit(s[i])`.
        *   Convert char to digit: `d = s[i] - '0'`.
        *   **Overflow Check:** Before `result = result * 10 + d`:
            *   If `result > Integer.MAX_VALUE / 10`, we will overflow.
            *   If `result == Integer.MAX_VALUE / 10` and `d > 7`, we will overflow.
            *   (For simplicity, we can accumulate on a larger type like `long`, but strictly speaking, we should simulate 32-bit check or clamp dynamically). Given Java has `long`, checking `result > Integer.MAX_VALUE` after update is easier, but let's stick to the 32-bit check logic for rigor.
        *   Update result.
    4.  **Apply Sign:** Return `sign * result`.

*   **Complexity:**
    *   Time: $O(N)$. Single pass. *Thời gian: $O(N)$. Duyệt một lần.*
    *   Space: $O(1)$. *Không gian: $O(1)$.*

### Dry Run
### *Chạy thử*
`s = "   -42"`
1.  Skip ' '. `i` moves to 3.
2.  `s[3] == '-'`. `sign = -1`. `i` moves to 4.
3.  `s[4] == '4'`. `res = 4`.
4.  `s[5] == '2'`. `res = 42`.
5.  End. Return `42 * -1 = -42`.

`s = "4193 with words"`
1.  Sign default +1.
2.  Read 4, 1, 9, 3.
3.  Hit ' ' (not digit). Stop.
4.  Return 4193.

`s = "words and 987"`
1.  First char 'w' not digit not sign -> Stop immediately (if obeying rules "integers at start"). Wait, rule 1 is whitespace, rule 2 is sign, rule 3 is next chars. If first non-whitespace is not sign/digit, integer is 0. 'w' != digit/sign. result 0.

### Edge Case: Overflow
`s = "-91283472332"`
Accumulate... until limit. Since negative, clamp to `Integer.MIN_VALUE`.

### Note on Overflow Check using `long` vs `int`
Using `long` makes implementation 10x simpler in Java. The constraints don't forbid `long` explicitly inside the function, just that the environment only stores 32-bit ints (return value). Using `long` buffer is standard for this LeetCode problem in Java. However, strictly following "environment does not allow 64-bit" means we should use the check similar to Problem 7. I will use the Strict 32-bit logic.

*Lưu ý về Kiểm tra Tràn số dùng `long` vs `int`*
*Sử dụng `long` làm cho việc cài đặt đơn giản hơn gấp 10 lần trong Java. Các ràng buộc không cấm `long` một cách rõ ràng bên trong hàm, chỉ là môi trường chỉ lưu trữ số nguyên 32-bit (giá trị trả về). Các dùng bộ đệm `long` là chuẩn cho bài LeetCode này trong Java. Tuy nhiên, tuân thủ nghiêm ngặt "môi trường không cho phép 64-bit" có nghĩa là chúng ta nên dùng kiểm tra tương tự Bài 7. Tôi sẽ dùng logic 32-bit Nghiêm ngặt.*
