# Result for Restore IP Addresses
# *Kết quả cho bài toán Khôi Phục Địa Chỉ IP*

## Description
## *Mô tả*

A **valid IP address** consists of exactly four integers separated by single dots. Each integer is between `0` and `255` (**inclusive**) and cannot have leading zeros.
*Một **địa chỉ IP hợp lệ** bao gồm chính xác bốn số nguyên được phân tách bằng các dấu chấm đơn. Mỗi số nguyên nằm trong khoảng từ `0` đến `255` (**bao gồm cả hai đầu**) và không được có số 0 ở đầu.*

*   For example, `"0.1.2.201"` and `"192.168.1.1"` are **valid** IP addresses, but `"0.011.255.245"`, `"192.168.1.312"` and `"192.168@1.1"` are **invalid** IP addresses.
*   *Ví dụ: `"0.1.2.201"` và `"192.168.1.1"` là các địa chỉ IP **hợp lệ**, nhưng `"0.011.255.245"`, `"192.168.1.312"` và `"192.168@1.1"` là các địa chỉ IP **không hợp lệ**.*

Given a string `s` containing only digits, return *all possible valid IP addresses that can be formed by inserting dots into `s`*. You are **not** allowed to reorder or remove any digits in `s`. You may return the valid IP addresses in **any** order.
*Cho một chuỗi `s` chỉ chứa các chữ số, hãy trả về *tất cả các địa chỉ IP hợp lệ có thể được tạo thành bằng cách chèn các dấu chấm vào `s`*. Bạn **không** được phép thay đổi thứ tự hoặc xóa bất kỳ chữ số nào trong `s`. Bạn có thể trả về các địa chỉ IP hợp lệ theo **bất kỳ** thứ tự nào.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "25525511135"`
**Output:** `["255.255.11.135","255.255.111.35"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "0000"`
**Output:** `["0.0.0.0"]`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "101023"`
**Output:** `["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 20`
*   `s` consists of digits only.
