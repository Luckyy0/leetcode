# 468. Validate IP Address / Xác Thực Địa Chỉ IP

## Problem Description / Mô tả bài toán
Given a string `queryIP`, return `"IPv4"` if IP is a valid IPv4 address, `"IPv6"` if IP is a valid IPv6 address or `"Neither"` if IP is not a correct IP of any type.
Cho một chuỗi `queryIP`, hãy trả về `"IPv4"` nếu đó là địa chỉ IPv4 hợp lệ, `"IPv6"` nếu đó là địa chỉ IPv6 hợp lệ, hoặc `"Neither"` nếu không phải là cả hai.

An **IPv4** address is IP in the form `"x1.x2.x3.x4"` where `0 <= xi <= 255` and `xi` **cannot** contain leading zeros. 
Một địa chỉ **IPv4** có dạng `"x1.x2.x3.x4"`, trong đó `0 <= xi <= 255` và `xi` **không được** chứa số 0 ở đầu.

An **IPv6** address is IP in the form `"x1:x2:x3:x4:x5:x6:x7:x8"` where:
- `1 <= xi.length <= 4`
- `xi` is a **hexadecimal string**.
- `xi` is allowed to have leading zeros.

### Example 1:
```text
Input: queryIP = "172.16.254.1"
Output: "IPv4"
```

### Example 2:
```text
Input: queryIP = "2001:0db8:85a3:0:0:8a2e:0370:7334"
Output: "IPv6"
```

### Example 3:
```text
Input: queryIP = "256.256.256.256"
Output: "Neither"
```

## Constraints / Ràng buộc
- `queryIP` consists only of English letters, digits and the characters `'.'` and `':'`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Splitting and Rules Verification / Tách chuỗi và Xác thực quy tắc
We need to carefully check the specific rules for IPv4 and IPv6.

**IPv4 Rules**:
1. Must have exactly 4 segments separated by `.`.
2. Each segment must be a decimal number from 0 to 255.
3. No leading zeros (unless the number is `0`).
4. Every character must be a digit.

**IPv6 Rules**:
1. Must have exactly 8 segments separated by `:`.
2. Each segment length must be between 1 and 4.
3. Each segment must be a hexadecimal number (0-9, a-f, A-F).

*Implementation detail*: Using `split()` requires care because it ignores trailing separators. Check for the count of separators manually or use `split(regex, -1)`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `queryIP`.
- **Space**: O(N) to store split segments.

---

## Analysis / Phân tích

### Approach: Manual String Validation

**Algorithm**:
1.  Detect separator.
2.  If `.`, validate IPv4.
3.  If `:`, validate IPv6.
4.  Otherwise, return "Neither".

---
