# Result for Self Dividing Numbers
# *Kết quả cho bài toán Số tự Chia hết (Self Dividing Numbers)*

## Description
## *Mô tả*

A **self-dividing number** is a number that is divisible by every digit it contains.
*Một **số tự chia hết** là một số có thể chia hết cho mọi chữ số mà nó chứa.*

For example, `128` is a self-dividing number because `128 % 1 == 0`, `128 % 2 == 0`, and `128 % 8 == 0`.
*Ví dụ, `128` là một số tự chia hết vì `128 % 1 == 0`, `128 % 2 == 0`, và `128 % 8 == 0`.*

A self-dividing number is **not allowed to contain the digit zero**.
*Một số tự chia hết **không được phép chứa chữ số 0**.*

Given two integers `left` and `right`, return a list of all the self-dividing numbers in the range `[left, right]`.
*Cho hai số nguyên `left` và `right`, hãy trả về một danh sách chứa tất cả các số tự chia hết trong khoảng `[left, right]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** left = 1, right = 22
**Output:** [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

## Example 2:
## *Ví dụ 2:*

**Input:** left = 47, right = 85
**Output:** [48, 55, 66, 77]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= left <= right <= 10^4`
