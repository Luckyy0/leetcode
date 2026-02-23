# Result for Add Digits
# *Kết quả cho bài toán Cộng các chữ số*

## Description
## *Mô tả*

Given an integer `num`, repeatedly add all its digits until the result has only one digit, and return it.
*Cho một số nguyên `num`, lặp lại việc cộng tất cả các chữ số của nó cho đến khi kết quả chỉ còn một chữ số, và trả về nó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `num = 38`
**Output:** `2`
**Explanation:** The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

## Example 2:
## *Ví dụ 2:*

**Input:** `num = 0`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `0 <= num <= 2^31 - 1`

**Follow up:** Could you do it without any loop/recursion in `O(1)` runtime?
**Câu hỏi mở rộng:** Bạn có thể làm điều đó mà không cần bất kỳ vòng lặp/đệ quy nào trong thời gian chạy `O(1)` không?
