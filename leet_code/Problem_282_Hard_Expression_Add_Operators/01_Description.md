# Result for Expression Add Operators
# *Kết quả cho bài toán Thêm toán tử vào Biểu thức*

## Description
## *Mô tả*

Given a string `num` that contains only digits and an integer `target`, return *all possibilities to insert the binary operators* `'+'`, `'-'`, *and/or* `'*'` *between the digits of* `num` *so that the resultant expression evaluates to the* `target` *value*.
*Cho một chuỗi `num` chỉ chứa các chữ số và một số nguyên `target`, hãy trả về *tất cả các khả năng chèn các toán tử nhị phân* `'+'`, `'-'`, *và/hoặc* `'*'` *giữa các chữ số của* `num` *sao cho biểu thức kết quả được tính thành giá trị* `target`.*

Note that operands in the returned expressions should not contain leading zeros.
*Lưu ý rằng các toán hạng trong biểu thức trả về không được chứa các số 0 ở đầu.*

## Example 1:
## *Ví dụ 1:*

**Input:** `num = "123", target = 6`
**Output:** `["1*2*3","1+2+3"]`
**Explanation:** Both "1*2*3" and "1+2+3" evaluate to 6.

## Example 2:
## *Ví dụ 2:*

**Input:** `num = "232", target = 8`
**Output:** `["2*3+2","2+3*2"]`
**Explanation:** Both "2*3+2" and "2+3*2" evaluate to 8.

## Constraints:
## *Ràng buộc:*

*   `1 <= num.length <= 10`
*   `num` consists of only digits.
*   `-2^31 <= target <= 2^31 - 1`
