# 1108. Defanging an IP Address / Defanging một Địa chỉ IP

## Problem Description / Mô tả bài toán
Given a valid (IPv4) IP `address`, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".
Cho một địa chỉ IP (IPv4) hợp lệ `address`, hãy trả về phiên bản defanged của địa chỉ IP đó.
Một địa chỉ IP defanged thay thế mỗi dấu chấm "." bằng "[.]".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Manipulation / Thao tác Chuỗi
Replace all occurrences.
`s.replace(".", "[.]")`.
Or iterate and build `StringBuilder`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: String Replacement
Replace every occurrence of literal period `.` with string `[.]`. Most languages provide built-in replace functions, or this can be done manually via a linear scan.
Thay thế mỗi lần xuất hiện của dấu chấm đen `.` bằng chuỗi `[.]`. Hầu hết các ngôn ngữ đều cung cấp các hàm thay thế tích hợp sẵn hoặc việc này có thể được thực hiện thủ công thông qua quét tuyến tính.

---
