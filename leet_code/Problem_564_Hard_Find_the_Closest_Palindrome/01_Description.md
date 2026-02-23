# Result for Find the Closest Palindrome
# *Kết quả cho bài toán Tìm Số Đối xứng Gần nhất*

## Description
## *Mô tả*

Given a string `n` representing an integer, return *the closest integer (not including itself), which is a **palindrome***. If there is a tie, return *the **smaller one***.
*Cho một chuỗi `n` biểu diễn một số nguyên, hãy trả về *số nguyên gần nhất (không bao gồm chính nó) là một **số đối xứng (palindrome)***. Nếu có sự cân bằng về khoảng cách, hãy trả về *số **nhỏ hơn***.*

The closest is defined as the absolute difference minimized between two integers.
*Gần nhất được định nghĩa là giá trị tuyệt đối của hiệu giữa hai số nguyên được thu nhỏ tối đa.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = "123"`
**Output:** `"121"`

## Example 2:
## *Ví dụ 2:*

**Input:** `n = "1"`
**Output:** `"0"`
**Explanation:** 0 and 2 are the closest palindromes but we return the smallest which is 0.

## Constraints:
## *Ràng buộc:*

*   `1 <= n.length <= 18`
*   `n` consists of only digits.
*   `n` does not have leading zeros.
*   `n` is representing an integer in the range `[1, 10^18 - 1]`.
