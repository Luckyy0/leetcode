# Result for Decode String
# *Kết quả cho bài toán Giải mã Chuỗi*

## Description
## *Mô tả*

Given an encoded string, return its decoded string.
*Cho một chuỗi đã được mã hóa, hãy trả về chuỗi đã giải mã.*

The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer.
*Quy tắc mã hóa là: `k[chuỗi_mã_hóa]`, trong đó `chuỗi_mã_hóa` bên trong dấu ngoặc vuông được lặp lại đúng `k` lần. Lưu ý rằng `k` được đảm bảo là một số nguyên dương.*

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, `k`. For example, there will not be input like `3a` or `2[4]`.
*Bạn có thể giả định rằng chuỗi đầu vào luôn hợp lệ; không có khoảng trắng thừa, các dấu ngoặc vuông được định dạng tốt, v.v. Ngoài ra, bạn có thể giả định rằng dữ liệu thô không chứa bất kỳ chữ số nào và các chữ số chỉ dành cho các số lặp lại, `k`. Ví dụ, sẽ không có đầu vào như `3a` hoặc `2[4]`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "3[a]2[bc]"`
**Output:** `"aaabcbc"`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "3[a2[c]]"`
**Output:** `"accaccacc"`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "2[abc]3[cd]ef"`
**Output:** `"abcabccdcdcdef"`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 30`
*   `s` consists of lowercase English letters, digits, and square brackets `[]`.
*   `s` is guaranteed to be a **valid** input.
*   All the integers in `s` are in the range `[1, 300]`.
