# Result for Numbers With Same Consecutive Differences
# *Kết quả cho bài toán Các Số có Hiệu Liên tiếp Giống nhau*

## Description
## *Mô tả*

Return all non-negative integers of length `n` such that the absolute difference between every two consecutive digits is `k`.
*Trả về tất cả các số nguyên không âm có độ dài `n` sao cho giá trị tuyệt đối của hiệu giữa mỗi hai chữ số liên tiếp là `k`.*

Note that **every** two consecutive digits must have that difference. For example, if `k = 1`, then `1234` is valid (d=1, d=1, d=1), but `1243` is not valid (d=1, d=2, d=1).
*Lưu ý rằng **mọi** hai chữ số liên tiếp phải có hiệu đó. Ví dụ, nếu `k = 1`, thì `1234` là hợp lệ (d=1, d=1, d=1), nhưng `1243` không hợp lệ (d=1, d=2, d=1).*

You may return the answer in **any order**.
*Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

Note: The integers should not have leading zeros. Integers as strings are of length `n`. For example, integers with 2 digits are `[10, 11, ..., 99]`, not `[01, ..., 09]`.
*Lưu ý: Các số nguyên không được có số 0 đứng đầu. Các số nguyên dưới dạng chuỗi có độ dài `n`. Ví dụ, các số nguyên có 2 chữ số là `[10, 11, ..., 99]`, không phải `[01, ..., 09]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3, k = 7
**Output:** [181,292,707,818,929]
**Explanation:** Note that 070 is not a valid number, because it has leading zeroes.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 2, k = 1
**Output:** [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

---

## Constraints:
## *Ràng buộc:*

*   `2 <= n <= 9`
*   `0 <= k <= 9`
