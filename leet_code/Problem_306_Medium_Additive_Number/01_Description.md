# Result for Additive Number
# *Kết quả cho bài toán Số Cộng*

## Description
## *Mô tả*

An **additive number** is a string whose digits can form an **additive sequence**.
*Một **số cộng** là một chuỗi có các chữ số có thể tạo thành một **dãy cộng**.*

A valid **additive sequence** should contain **at least** three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
*Một **dãy cộng** hợp lệ phải chứa **ít nhất** ba số. Ngoại trừ hai số đầu tiên, mỗi số tiếp theo trong dãy phải là tổng của hai số đứng trước.*

Given a string containing only digits, return `true` if it is an **additive number** or `false` otherwise.
*Cho một chuỗi chỉ chứa các chữ số, trả về `true` nếu nó là một **số cộng** hoặc `false` nếu ngược lại.*

Note: Numbers in the additive sequence **cannot** have leading zeros, so sequence `1, 2, 03` or `1, 02, 3` is invalid.
*Lưu ý: Các số trong dãy cộng **không thể** có số 0 ở đầu, vì vậy dãy `1, 2, 03` hoặc `1, 02, 3` là không hợp lệ.*

## Example 1:
## *Ví dụ 1:*

**Input:** `"112358"`
**Output:** `true`
**Explanation:**
The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

## Example 2:
## *Ví dụ 2:*

**Input:** `"199100199"`
**Output:** `true`
**Explanation:**
The additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199

## Constraints:
## *Ràng buộc:*

*   `1 <= num.length <= 35`
*   `num` consists only of digits.

**Follow up:** How would you handle overflow for very large input integers?
**Câu hỏi mở rộng:** Bạn sẽ xử lý tràn số như thế nào đối với các số nguyên đầu vào rất lớn?
