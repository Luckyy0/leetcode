# Result for License Key Formatting
# *Kết quả cho bài toán Định dạng Khóa Giấy phép*

## Description
## *Mô tả*

You are given a license key represented as a string `s` that consists of only alphanumeric characters and dashes. The string is separated into `n + 1` groups by `n` dashes. You are also given an integer `k`.
*Bạn được cho một khóa giấy phép được biểu diễn dưới dạng chuỗi `s` chỉ bao gồm các ký tự chữ và số và dấu gạch ngang. Chuỗi được chia thành `n + 1` nhóm bởi `n` dấu gạch ngang. Bạn cũng được cho một số nguyên `k`.*

We want to reformat the string `s` such that each group contains exactly `k` characters, except for the first group, which could be shorter than `k` but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
*Chúng tôi muốn định dạng lại chuỗi `s` sao cho mỗi nhóm chứa chính xác `k` ký tự, ngoại trừ nhóm đầu tiên có thể ngắn hơn `k` nhưng vẫn phải chứa ít nhất một ký tự. Hơn nữa, phải có một dấu gạch ngang được chèn giữa hai nhóm và bạn nên chuyển đổi tất cả các chữ cái thường thành chữ hoa.*

Return *the reformatted license key*.
*Hãy trả về *khóa giấy phép đã được định dạng lại*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "5F3Z-2e-9-w", k = 4`
**Output:** `"5F3Z-2E9W"`
**Explanation:** The string s has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "2-5g-3-J", k = 2`
**Output:** `"2-5G-3J"`
**Explanation:** The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s` consists of English letters, digits, and dashes `'-'`.
*   `1 <= k <= 10^4`
