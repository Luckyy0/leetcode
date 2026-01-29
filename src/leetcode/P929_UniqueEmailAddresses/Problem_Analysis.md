# 929. Unique Email Addresses / Địa chỉ Email Duy nhất

## Problem Description / Mô tả bài toán
Every email consists of a local name and a domain name.
Mỗi email bao gồm tên cục bộ và tên miền.
- If you add periods `.` in the local name, they are ignored.
Nếu bạn thêm dấu chấm `.` vào tên cục bộ, chúng sẽ bị bỏ qua.
- If you add a plus `+` in the local name, everything after the plus is ignored.
Nếu bạn thêm dấu cộng `+` vào tên cục bộ, mọi thứ sau dấu cộng sẽ bị bỏ qua.

Given a list of emails, return the number of unique addresses.
Cho một danh sách các email, hãy trả về số lượng các địa chỉ duy nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Normalization / Chuẩn hóa Chuỗi
Algorithm:
1. For each email, split by '@' into `local` and `domain`.
2. Process `local`:
   - Take substring before the first `+`.
   - Remove all `.` characters.
3. Reconstruct: `local + "@" + domain`.
4. Add to a `HashSet`.
5. Return set size.

### Complexity / Độ phức tạp
- **Time**: O(Total chars in all emails).
- **Space**: O(Total chars in all emails).

---

## Analysis / Phân tích

### Approach: Canonical Transformation
Convert each email into its simplest equivalent form based on the specific parsing rules. By stripping irrelevant formatting characters from the local part while preserving the domain, we can accurately distinguish truly distinct accounts using a set.
Chuyển đổi mỗi email thành dạng tương đương đơn giản nhất dựa trên các quy tắc phân tích cú pháp cụ thể. Bằng cách loại bỏ các ký tự định dạng không liên quan khỏi phần cục bộ trong khi vẫn duy trì tên miền, chúng ta có thể phân biệt chính xác các tài khoản thực sự khác nhau bằng cách sử dụng một tập hợp.

---
