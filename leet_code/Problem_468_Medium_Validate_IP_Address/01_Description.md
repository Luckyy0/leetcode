# Result for Validate IP Address
# *Kết quả cho bài toán Xác thực Địa chỉ IP*

## Description
## *Mô tả*

Given a string `queryIP`, return `"IPv4"` if IP is a valid IPv4 address, `"IPv6"` if IP is a valid IPv6 address or `"Neither"` if IP is not a correct IP of any type.
*Cho một chuỗi `queryIP`, hãy trả về `"IPv4"` nếu IP là một địa chỉ IPv4 hợp lệ, `"IPv6"` nếu là địa chỉ IPv6 hợp lệ hoặc `"Neither"` nếu không phải là IP đúng của bất kỳ loại nào.*

**IPv4** addresses are represented in dot-decimal notation, which consists of four decimal numbers, each ranging from `0` to `255`, separated by dots (`"."`), e.g., `172.16.254.1`.
- Leading zeros are invalid. For example, `172.16.254.01` is invalid.

**IPv6** addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (`":"`). For example, `2001:0db8:85a3:0000:0000:8a2e:0370:7334` is a valid address. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters to upper-case characters.
- For example, `2001:db8:85a3:0:0:8A2E:0370:7334` is a valid IPv6 address.
- `extra leading zeros`, `consecutive colons` or `more than 4 digits per group` are invalid.

## Example 1:
## *Ví dụ 1:*

**Input:** `queryIP = "172.16.254.1"`
**Output:** `"IPv4"`

## Example 2:
## *Ví dụ 2:*

**Input:** `queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"`
**Output:** `"IPv6"`

## Example 3:
## *Ví dụ 3:*

**Input:** `queryIP = "256.256.256.256"`
**Output:** `"Neither"`

## Constraints:
## *Ràng buộc:*

*   `queryIP` consists only of English letters, digits and the characters `'.'` and `':'`.
