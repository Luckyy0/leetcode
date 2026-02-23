# Result for Unique Email Addresses
# *Kết quả cho bài toán Địa chỉ Email Duy nhất*

## Description
## *Mô tả*

Every **valid email** consists of a **local name** and a **domain name**, separated by the `'@'` sign. Besides lowercase letters, the email may contain one or more `'.'` or `'+'`.
*Mỗi **email hợp lệ** bao gồm một **tên cục bộ** và một **tên miền**, được phân tách bằng dấu `'@'`. Ngoài các chữ cái thường, email có thể chứa một hoặc nhiều dấu `'.'` hoặc `'+'`.*

*   For example, in `"alice@leetcode.com"`, `"alice"` is the **local name**, and `"leetcode.com"` is the **domain name**.
    *   *Ví dụ, trong `"alice@leetcode.com"`, `"alice"` là **tên cục bộ**, và `"leetcode.com"` là **tên miền**.*

If you add periods `'.'` between some characters in the **local name** part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule **does not apply** to **domain names**.
*Nếu bạn thêm dấu chấm `'.'` vào giữa một số ký tự trong phần **tên cục bộ** của địa chỉ email, thư gửi đến đó sẽ được chuyển tiếp đến cùng một địa chỉ mà không có dấu chấm trong tên cục bộ. Lưu ý rằng quy tắc này **không áp dụng** cho **tên miền**.*

*   For example, `"alice.z@leetcode.com"` and `"alicez@leetcode.com"` forward to the same email address.
    *   *Ví dụ, `"alice.z@leetcode.com"` và `"alicez@leetcode.com"` chuyển tiếp đến cùng một địa chỉ email.*

If you add a plus `'+'` in the **local name**, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule **does not apply** to **domain names**.
*Nếu bạn thêm dấu cộng `'+'` trong **tên cục bộ**, mọi thứ sau dấu cộng đầu tiên sẽ bị bỏ qua. Điều này cho phép lọc một số email nhất định. Lưu ý rằng quy tắc này **không áp dụng** cho **tên miền**.*

*   For example, `"m.y+name@email.com"` will be forwarded to `"my@email.com"`.
    *   *Ví dụ, `"m.y+name@email.com"` sẽ được chuyển tiếp đến `"my@email.com"`.*

It is possible to use both of these rules at the same time.
*Có thể sử dụng cả hai quy tắc này cùng một lúc.*

Given an array of strings `emails` where we send one email to each `email[i]`, return *the number of different addresses that actually receive mails*.
*Cho một mảng các chuỗi `emails` trong đó chúng tôi gửi một email đến mỗi `email[i]`, hãy trả về *số lượng địa chỉ khác nhau thực sự nhận được thư*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
**Output:** 2
**Explanation:** "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.

## Example 2:
## *Ví dụ 2:*

**Input:** emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
**Output:** 3

---

## Constraints:
## *Ràng buộc:*

*   `1 <= emails.length <= 100`
*   `1 <= emails[i].length <= 100`
*   `emails[i]` consist of lowercase English letters, `'+'`, `'.'` and `'@'`.
*   Each `emails[i]` contains exactly one `'@'` character.
*   All local and domain names are non-empty.
*   Local names do not start with a `'+'` character.
*   Domain names end with the `".com"` suffix.
