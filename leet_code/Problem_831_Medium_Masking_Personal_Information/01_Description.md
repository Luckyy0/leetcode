# Result for Masking Personal Information
# *Kết quả cho bài toán Che giấu Thông tin Cá nhân*

## Description
## *Mô tả*

You are given a personal information string `s`, which may represent either an **email address** or a **phone number**. All characters in `s` are either lowercase or uppercase English letters, digits, or the characters `'+'`, `'-'`, `'('`, `')'`, `'*'`, `'.'`, or `'@'`.
*Bạn được cho một chuỗi thông tin cá nhân `s`, có thể đại diện cho một **địa chỉ email** hoặc một **số điện thoại**. Tất cả các ký tự trong `s` là chữ cái tiếng Anh (viết hoa hoặc viết thường), chữ số, hoặc các ký tự đặc biệt như `'+'`, `'-'`, `'('`, `')'`, `'*'`, `'.'`, hoặc `'@'`.*

We want to mask the personal information according to the following rules:
*Chúng ta muốn che giấu thông tin cá nhân theo các quy tắc sau:*

### Email Address:
An email address is of the form `name@domain.com`.
The `name` consists of letters.
Lowercase the entire address.
Keep the first and last character of `name` and replace everything in between with five asterisks `"*****"`.
*Một địa chỉ email có dạng `tên@tên_miền`. Chuyển tất cả thành chữ thường. Giữ lại ký tự đầu và cuối của phần `tên` và thay thế mọi thứ ở giữa bằng năm dấu sao `"*****"`.*

### Phone Number:
A phone number contains digits and optional special characters like `'+'`, `'-'`, `'('`, `')'`, `'*'`, `'.'`, or `'@'`.
Ignore all special characters and keep only the digits.
A local phone number consists of **10 digits**.
A phone number may also include a country code, which could be **1, 2, or 3 digits**.
The personal information should be converted to the following format:
- Local number: `"***-***-XXXX"`
- With country code: `"+*-***-***-XXXX"`, `"+**-***-***-XXXX"`, or `"+***-***-***-XXXX"`.
The `"XXXX"` represents the last 4 digits of the phone number.
*Số điện thoại bao gồm chữ số và các ký tự đặc biệt. Bỏ qua các ký tự đặc biệt, chỉ giữ lại chữ số. Một số điện thoại nội địa gồm 10 chữ số. Số điện thoại có thể có mã quốc gia dài 1, 2 hoặc 3 chữ số. Quy tắc che giấu: số nội địa thành `"***-***-XXXX"`, số quốc tế có thêm mã quốc gia tương ứng đằng trước.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "LeetCode@LeetCode.com"
**Output:** "l*****e@leetcode.com"
**Explanation:** s is an email. All characters are lowercased and name part is masked.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "AB@qq.com"
**Output:** "a*****b@qq.com"

## Example 3:
## *Ví dụ 3:*

**Input:** s = "1(234)567-890"
**Output:** "***-***-8900"
**Explanation:** s is a phone number. 10 digits, no country code.

---

## Constraints:
## *Ràng buộc:*

*   `s` is either a valid email or a phone number.
*   If `s` is an email:
    - `8 <= s.length <= 40`
    - `s` contains exactly one `'@'`.
*   If `s` is a phone number:
    - It contains between 10 and 13 digits.
