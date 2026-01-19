# 65. Valid Number / Số Hợp Lệ

## Problem Description / Mô tả bài toán
A **valid number** can be split up into these components (in order):
Một **số hợp lệ** có thể được chia thành các thành phần sau (theo thứ tự):
1.  A **decimal number** or an **integer**.
    Một **số thập phân** hoặc một **số nguyên**.
2.  (Optional) An `'e'` or `'E'` followed by an **integer**.
    (Tùy chọn) Một `'e'` hoặc `'E'` theo sau bởi một **số nguyên**.

A **decimal number** can be split up into these components (in order):
Một **số thập phân** có thể được chia thành các thành phần sau (theo thứ tự):
1.  (Optional) A sign character (either `'+'` or `'-'`).
2.  One of the following formats:
    1.  At least one digit, followed by a dot `'.'`.
    2.  At least one digit, followed by a dot `'.'`, followed by at least one digit.
    3.  A dot `'.'`, followed by at least one digit.

An **integer** can be split up into these components (in order):
1.  (Optional) A sign character (either `'+'` or `'-'`).
2.  At least one digit.

### Example 1:
```text
Input: s = "0"
Output: true
```

### Example 2:
```text
Input: s = "e"
Output: false
```

### Example 3:
```text
Input: s = "."
Output: false
```

## Constraints / Ràng buộc
- `1 <= s.length <= 20`
- `s` consists of only English letters (both upper and lower cases), digits (`0-9`), plus `'+'`, minus `'-'`, or dot `'.'`.

---

## Analysis / Phân tích

### Approach: Flag Scanning / Quét Cờ
- **Idea**: Iterate through the string and enforce rules using boolean flags.
- **Ý tưởng**: Duyệt qua chuỗi và thực thi các quy tắc bằng cách sử dụng các cờ boolean.
- **Flags**:
    - `seenDigit`: Have we seen a digit yet?
    - `seenDot`: Have we seen a decimal point?
    - `seenExponent`: Have we seen 'e' or 'E'?
- **Rules**:
    - **Digit**: Mark `seenDigit = true`.
    - **+/-**: Allowed only at start or immediately after 'e'/'E'.
    - **.**: Allowed if `!seenDot` and `!seenExponent`.
    - **e/E**: Allowed if `seenDigit` and `!seenExponent`. After 'e', reset `seenDigit = false` (must have digits after e).
    - **Other**: Return false.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **"e9"**: False (no digit before e).
2.  **"1e"**: False (no digit after e).
3.  **"."**: False.
4.  **"3."**: True.
