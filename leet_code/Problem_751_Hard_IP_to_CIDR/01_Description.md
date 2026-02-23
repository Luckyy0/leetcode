# Result for IP to CIDR
# *Kết quả cho bài toán IP sang CIDR*

## Description
## *Mô tả*

Given a start IP address `ip` and a number of identical IPs we need to cover `n`, return *a representation of the range as a list (of smallest possible length) of CIDR blocks*.
*Cho một địa chỉ IP bắt đầu `ip` và một số lượng IP giống nhau cần bao phủ `n`, hãy trả về *một biểu diễn của phạm vi dưới dạng một danh sách (có độ dài nhỏ nhất có thể) các khối CIDR*.*

A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example: "123.45.67.89/20". That means the first 20 bits of the IP are the prefix, and the rest (32 - 20 = 12) bits are the suffix.
*Một khối CIDR là một chuỗi bao gồm một IP, theo sau là dấu gạch chéo và độ dài tiền tố. Ví dụ: "123.45.67.89/20". Điều đó có nghĩa là 20 bit đầu tiên của IP là tiền tố, và phần còn lại (32 - 20 = 12) bit là hậu tố.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** ip = "255.0.0.7", n = 10
**Output:** ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
**Explanation:**
The initial IP is 11111111 00000000 00000000 00000111
We need to cover 10 IPs:
1. 255.0.0.7 -> /32 (1 address)
2. 255.0.0.8 -> /29 (8 addresses, covering 255.0.0.8 to 255.0.0.15)
3. 255.0.0.16 -> /32 (1 address)
Total covered: 1 + 8 + 1 = 10.

---

## Constraints:
## *Ràng buộc:*

*   `ip` is a valid IPv4 address.
*   `1 <= n <= 1000`.
