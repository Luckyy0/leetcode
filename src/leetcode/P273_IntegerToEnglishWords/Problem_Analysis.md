# 273. Integer to English Words / Chuyển Đổi Số Nguyên Thành Tiếng Anh

## Problem Description / Mô tả bài toán
Convert a non-negative integer `num` to its English words representation.
Chuyển đổi một số nguyên không âm `num` thành biểu diễn tiếng Anh của nó.

### Example 1:
```text
Input: num = 123
Output: "One Hundred Twenty Three"
```

### Example 2:
```text
Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
```

### Example 3:
```text
Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
```

## Constraints / Ràng buộc
- `0 <= num <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Group Processing / Xử Lý Theo Nhóm
English numbers are grouped by thousands:
- Billions (10^9)
- Millions (10^6)
- Thousands (10^3)
- Hundreds/Units

We can process the number in chunks of 3 digits (0-999).
Helper function `processThreeDigits(n)`:
- Returns string for `n` (e.g., "One Hundred Twenty Three").
- Handles `n < 20`, `n < 100`, `n >= 100`.

**Algorithm**:
1.  Handle 0 -> "Zero".
2.  Arrays for:
    - Less than 20: ["", "One", ..., "Nineteen"]
    - Tens: ["", "Ten", "Twenty", ..., "Ninety"]
    - Thousands: ["", "Thousand", "Million", "Billion"]
3.  Iterate through groups (billion, million, thousand, unit).
4.  For each group, if value > 0: `processThreeDigits(val) + " " + GroupName`.
5.  Trim spaces.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is number of digits (log num). Technically O(1) since num fits in int.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Recursive/Iterative Grouping

**Edge Cases**:
1.  **0**: "Zero".
2.  **Trailing zeros**: 1000 -> "One Thousand". (No "Zero Hundred").
3.  **Intermediate zeros**: 1001 -> "One Thousand One".

---
