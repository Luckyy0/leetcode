# Result for Smallest Integer Divisible by K
# *Kết quả cho bài toán Số nguyên nhỏ nhất chia hết cho K*

## Description
## *Mô tả*

Given a positive integer `k`, you need to find the **length** of the **smallest** positive integer `n` such that `n` is divisible by `k`, and `n` only contains the digit `1`.
*Cho một số nguyên dương `k`, bạn cần tìm **độ dài** của số nguyên dương `n` **nhỏ nhất** sao cho `n` chia hết cho `k`, và `n` chỉ chứa toàn chữ số `1`.*

Return *the **length** of* `n`. If there is no such `n`, return -1.
*Trả về độ dài của `n`. Nếu không tồn tại `n` như vậy, trả về -1.*

**Note:** `n` may not fit in a 64-bit signed integer.
*Lưu ý: `n` có thể lớn hơn giới hạn của số nguyên có dấu 64-bit.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** k = 1
**Output:** 1
**Explanation:** The smallest answer is n = 1, which has length 1.
*Giải thích: Đáp án nhỏ nhất là n = 1 (chia hết cho 1), độ dài là 1.*

## Example 2:
## *Ví dụ 2:*

**Input:** k = 2
**Output:** -1
**Explanation:** There is no such positive integer n divisible by 2.
*Giải thích: Không có số nguyên dương nào toàn số 1 mà lại chia hết cho 2 (số chẵn).*

## Example 3:
## *Ví dụ 3:*

**Input:** k = 3
**Output:** 3
**Explanation:** The smallest answer is n = 111, which has length 3.
*Giải thích: Đáp án nhỏ nhất là n = 111 (chia hết cho 3), độ dài là 3.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= 10^5`
