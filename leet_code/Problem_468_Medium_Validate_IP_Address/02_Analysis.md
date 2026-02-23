# Analysis for Validate IP Address
# *Phân tích cho bài toán Xác thực Địa chỉ IP*

## 1. Problem Essence & Strict Parsing
## *1. Bản chất vấn đề & Phân tích Cú pháp Nghiêm ngặt*

### The Challenge
### *Thách thức*
Distinguishing between valid IPv4, valid IPv6, and invalid strings. This requires adhering to specific rules for delimiters, character sets, value ranges, and leading zeros.

### Strategy: Divide and Conquer (Split & Validate)
### *Chiến lược: Chia để Trị (Tách & Xác thực)*

1.  **Identify Type:** Check if the string contains `.` or `:`.
    - If strictly `.` (and no `:`), treat as potential IPv4.
    - If strictly `:` (and no `.`), treat as potential IPv6.
    - Otherwise (mixed or neither), return "Neither".
2.  **Validate IPv4:**
    - Split by `.`. **Crucial:** Use a split limit or manual counting to ensure edge cases like `1.1.1.1.` are handled correctly (should be invalid). Correct split should yield exactly 4 parts.
    - For each part:
        - Must be non-empty.
        - Must contain only digits.
        - Length must be between 1 and 3.
        - **No leading zeros:** If length > 1, the first digit cannot be '0'.
        - Value must be `0 <= x <= 255`.
3.  **Validate IPv6:**
    - Split by `:`. Correct split should yield exactly 8 parts.
    - For each part:
        - Must be non-empty.
        - Length must be between 1 and 4.
        - Must contain only hex digits (0-9, a-f, A-F).

---

## 2. Approach: String Splitting vs. Regex
## *2. Hướng tiếp cận: Tách Chuỗi vs. Biểu thức Chính quy*

### Logic
### *Logic*
(See above). While Regex is powerful, it can be complex to write correctly for all edge cases (like value ranges 0-255). A procedural "split and check" approach is often more readable and easier to debug in an interview setting.

**Important Note on Splitting:**
In Java, `String.split("\\.")` discards trailing empty strings by default. We must use `String.split("\\.", -1)` to preserve trailing empty strings to detect invalid IPs like `192.168.1.1.` accurately.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Modularity:** Separates IPv4 and IPv6 logic completely.
    *Tính mô-đun: Tách biệt hoàn toàn logic IPv4 và IPv6.*
*   **Precision:** Parsing each chunk allows strict checks on range and leading zeros.
    *Độ chính xác: Phân tích cú pháp từng đoạn cho phép kiểm tra chặt chẽ phạm vi và số 0 ở đầu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ to store the split parts.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `"172.16.254.1"`
1. Contains `.`. Try IPv4.
2. Split: `["172", "16", "254", "1"]`. Count is 4. OK.
3. Check "172": Digits? Yes. Range? Yes. Leading zero? No. OK.
4. Check "16": OK.
5. Check "254": OK.
6. Check "1": OK.
Result: "IPv4".

**Input:** `"2001:0db8:85a3:0:0:8A2E:0370:7334"`
1. Contains `:`. Try IPv6.
2. Split: 8 parts. OK.
3. Check "2001": Hex? Yes. Len <= 4? Yes.
4. ...
Result: "IPv6".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Parsing by splitting with strict validation rules.
*Phân tích cú pháp bằng cách tách chuỗi với các quy tắc xác thực nghiêm ngặt.*
---
*Một địa chỉ đúng (valid address) là cánh cửa để kết nối với thế giới. Việc xác thực (validation) không chỉ là kiểm tra cú pháp, mà là đảm bảo tính toàn vẹn của giao tiếp. Bằng cách chia nhỏ vấn đề thành từng thành phần cơ bản (octets/hextets) và kiểm tra kỹ lưỡng từng mảnh ghép, ta xây dựng được sự tin cậy trong mạng lưới thông tin hỗn loạn.*
A valid address (valid address) is the door to connect with the world. Validation (validation) is not only checking syntax, but ensuring the integrity of communication. By breaking the problem into basic components (octets/hextets) and thoroughly checking each piece, we build trust in the chaotic information network.
