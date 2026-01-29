# 831. Masking Personal Information / Che giấu Thông tin Cá nhân

## Problem Description / Mô tả bài toán
Mask either an email address or a phone number according to specific rules.
Che giấu địa chỉ email hoặc số điện thoại theo các quy tắc cụ thể.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Manipulation and Case Handling / Thao tác Chuỗi và Xử lý Kiểu chữ
Algorithm for Email:
1. Normalize to lowercase.
2. Format as `f*****l@domain`. (`f` is first char, `l` is last char before `@`).

Algorithm for Phone:
1. Extract all digits.
2. Last 10 digits are local: `***-***-XXXX`.
3. Extra digits (if any) are country code: `+*-`, `+**-`, `+***-`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Conditional Formatting
Detect if the input is an email (contains '@') or a phone number. Apply string slicing and concatenation based on the respective masking protocols.
Phát hiện xem đầu vào là email (chứa '@') hay số điện thoại. Áp dụng cắt chuỗi và nối chuỗi dựa trên các giao thức che giấu tương ứng.

---
