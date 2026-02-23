# Analysis for Encode and Decode Strings
# *Phân tích cho bài toán Mã hóa và Giải mã Chuỗi*

## 1. Problem Essence & Delimiters
## *1. Bản chất vấn đề & Dấu phân cách*

### The Challenge
### *Thách thức*
We need to combine multiple strings into one.
Simple separators like `,` or `#` don't work because the strings themselves might contain those characters.
We need a way to know **exactly where each string ends**.

### Strategy: Length Prefixing
### *Chiến lược: Tiền tố độ dài*
Before each string, store its **length** followed by a special separator (like `#` or `/`).
Format: `length + delimiter + string`.
Example: `["hello", "world"]` -> `5#hello5#world`.
Even if string contains `#` (e.g., `["#"]`), it becomes `1##`.
Parsing:
1.  Read digits until `#`.
2.  Parse int `len`.
3.  Read `len` characters.
4.  Repeat.

This is unambiguous because the length tells us exactly how many characters to consume, ignoring any separators inside the content.

---

## 2. Approach: Chunked Transfer Encoding
## *2. Hướng tiếp cận: Mã hóa truyền tải phân đoạn*

### Encode
### *Mã hóa*
Iterate list. For each string:
- `sb.append(str.length())`
- `sb.append('#')`
- `sb.append(str)`

### Decode
### *Giải mã*
Pointer `i = 0`.
While `i < s.length()`:
- Find next `#` from `i`. Let it be `slash`.
- Substring `s[i...slash]` is the length string. Parse to `len`.
- Content starts at `slash + 1`.
- `content = s.substring(slash + 1, slash + 1 + len)`.
- Add to list.
- `i = slash + 1 + len`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Self-Describing:** The length prefix acts as metadata describing the payload, making it robust against any content.
    *Tự mô tả: Tiền tố độ dài hoạt động như siêu dữ liệu mô tả nội dung, giúp nó bền vững trước mọi nội dung.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ (total characters).
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ extra space (excluding result).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["63/Rc", "h", "Se", "ko"]`

1.  **Encode:**
    - "63/Rc": `5#63/Rc` (Length 5).
    - "h": `1#h`.
    - "Se": `2#Se`.
    - "ko": `2#ko`.
    - Result: `5#63/Rc1#h2#Se2#ko`.

2.  **Decode:**
    - Find `#` at 1. Length "5". `slash=1`.
    - Read 5 chars from 2: "63/Rc". `i` moves to $1+1+5 = 7$.
    - Find `#` at 8. Length "1". `slash=8`.
    - Read 1 char from 9: "h". `i` moves to $9+1+1 = 11$.
    - ...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard protocol design pattern (TLV: Type-Length-Value, here just Length-Value).
*Mẫu thiết kế giao thức tiêu chuẩn (TLV: Type-Length-Value, ở đây chỉ là Length-Value).*
---
*Để hiểu đúng một thông điệp, đôi khi ta cần biết trước độ dài của nó. Sự chuẩn bị (biết trước length) giúp tránh hiểu lầm nội dung.*
To correctly understand a message, sometimes we need to know its length beforehand. Preparation (knowing length) helps avoid misunderstanding the content.
