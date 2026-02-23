# Result for Cracking the Safe
# *Kết quả cho bài toán Phá két sắt*

## Description
## *Mô tả*

There is a safe protected by a password that involves `n` digits, where each digit can be in the range `[0, k - 1]`.
*Có một két sắt được bảo vệ bằng mật khẩu gồm `n` chữ số, trong đó mỗi chữ số có thể nằm trong khoảng `[0, k - 1]`.*

The safe has a peculiar way of checking the password. When you enter a sequence of digits, checking starts from the last `n` digits you entered.
*Két sắt có một cách kiểm tra mật khẩu đặc biệt. Khi bạn nhập một chuỗi các chữ số, việc kiểm tra bắt đầu từ `n` chữ số cuối cùng bạn đã nhập.*

For example, checking the password "345" would require you to enter the digits '3', '4', and '5'. However, if you enter "012345", the safe will check the passwords "012", "123", "234", and "345".
*Ví dụ, để kiểm tra mật khẩu "345", bạn cần nhập các chữ số '3', '4', và '5'. Tuy nhiên, nếu bạn nhập "012345", két sắt sẽ kiểm tra các mật khẩu "012", "123", "234", và "345".*

Return *any string of minimum length* that allows us to open the safe, knowing that the password is one of the $k^n$ possible passwords.
*Hãy trả về *bất kỳ chuỗi nào có độ dài tối thiểu* cho phép mở két sắt, biết rằng mật khẩu là một trong $k^n$ mật khẩu có thể xảy ra.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 1, k = 2
**Output:** "01"
**Explanation:** "01" will be treated as "0" and "1". Both 0 and 1 are possible passwords. "10" is also a valid output.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 2, k = 2
**Output:** "00110"
**Explanation:** "00110" covers "00", "01", "11", "10".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 4`
*   `1 <= k <= 10`
*   `k^n <= 4096`
