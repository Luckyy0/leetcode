# 93. Restore IP Addresses / Khôi Phục Địa Chỉ IP

## Problem Description / Mô tả bài toán
A **valid IP address** consists of exactly four integers separated by single dots. Each integer is between `0` and `255` (**inclusive**) and cannot have leading zeros.
Một **địa chỉ IP hợp lệ** bao gồm chính xác bốn số nguyên được phân tách bằng các dấu chấm đơn. Mỗi số nguyên nằm trong khoảng từ `0` đến `255` (**bao gồm**) và không thể có số không ở đầu.
- For example, "0.1.2.201" and "192.168.1.1" are **valid** IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are **invalid** IP addresses.
- Ví dụ, "0.1.2.201" và "192.168.1.1" là các địa chỉ IP **hợp lệ**, nhưng "0.011.255.245", "192.168.1.312" và "192.168@1.1" là các địa chỉ IP **không hợp lệ**.

Given a string `s` containing only digits, return all possible valid IP addresses that can be formed by inserting dots into `s`. You are **not** allowed to reorder or remove any digits in `s`. You may return the valid IP addresses in **any order**.
Cho một chuỗi `s` chỉ chứa các chữ số, hãy trả về tất cả các địa chỉ IP hợp lệ có thể được hình thành bằng cách chèn các dấu chấm vào `s`. Bạn **không** được phép sắp xếp lại hoặc xóa bất kỳ chữ số nào trong `s`. Bạn có thể trả về các địa chỉ IP hợp lệ theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
```

### Example 2:
```text
Input: s = "0000"
Output: ["0.0.0.0"]
```

### Example 3:
```text
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
```

## Constraints / Ràng buộc
- `1 <= s.length <= 20`
- `s` consists of digits only.

---

## Analysis / Phân tích

### Approach: Backtracking / Quay Lui
- **Idea**: Try placing 3 dots to split the string into 4 parts.
- **Ý tưởng**: Thử đặt 3 dấu chấm để chia chuỗi thành 4 phần.
- **Constraints**:
    - Each part length must be 1 to 3.
    - Value must be 0-255.
    - No leading zeros (unless single '0').
- **Optimization**: Check remaining length.
    - Minimum length needed: `(4 - parts_done) * 1`.
    - Maximum length possible: `(4 - parts_done) * 3`.
- **Time Complexity**: O(3^4) -> O(1). Since the number of splits is limited.
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Too Short/Long**: `s.length < 4` or `s.length > 12`. Return empty.
2.  **Leading Zeros**: `01` invalid.
