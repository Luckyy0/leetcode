# Result for Flip String to Monotone Increasing
# *Kết quả cho bài toán Lật chuỗi để thành Tăng đơn điệu*

## Description
## *Mô tả*

A binary string is monotone increasing if it consists of some number of `0`'s (possibly none), followed by some number of `1`'s (also possibly none).
*Một chuỗi nhị phân là tăng đơn điệu nếu nó bao gồm một số lượng số `0` (có thể không có), theo sau là một số lượng số `1` (cũng có thể không có).*

You are given a binary string `s`. You can flip `s[i]` changing it from `0` to `1` or from `1` to `0`.
*Bạn được cho một chuỗi nhị phân `s`. Bạn có thể lật `s[i]` thay đổi nó từ `0` thành `1` hoặc từ `1` thành `0`.*

Return *the minimum number of flips to make `s` monotone increasing*.
*Hãy trả về *số lần lật tối thiểu để làm cho `s` tăng đơn điệu*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "00110"
**Output:** 1
**Explanation:** We flip the last digit to get 00111.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "010110"
**Output:** 2
**Explanation:** We flip to get 011111, or 000111.

## Example 3:
## *Ví dụ 3:*

**Input:** s = "00011000"
**Output:** 2
**Explanation:** We flip to get 00000000.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^5`
*   `s[i]` is either `'0'` or `'1'`.
