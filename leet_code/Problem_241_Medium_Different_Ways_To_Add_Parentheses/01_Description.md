# Result for Different Ways to Add Parentheses
# *Kết quả cho bài toán Các cách thêm dấu ngoặc khác nhau*

## Description
## *Mô tả*

Given a string `expression` of numbers and operators, return *all possible results from computing all the different possible ways to group numbers and operators*. You may return the answer in **any order**.
*Cho một chuỗi `expression` gồm các số và toán tử, hãy trả về *tất cả các kết quả có thể có từ việc tính toán tất cả các cách khác nhau để nhóm các số và toán tử*. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 10^4.
*Các trường hợp thử nghiệm được tạo sao cho các giá trị đầu ra nằm gọn trong số nguyên 32 bit và số lượng kết quả khác nhau không vượt quá 10^4.*

## Example 1:
## *Ví dụ 1:*

**Input:** `expression = "2-1-1"`
**Output:** `[0,2]`
**Explanation:**
((2-1)-1) = 0
(2-(1-1)) = 2

## Example 2:
## *Ví dụ 2:*

**Input:** `expression = "2*3-4*5"`
**Output:** `[-34,-14,-10,-10,10]`
**Explanation:**
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

## Constraints:
## *Ràng buộc:*

*   `1 <= expression.length <= 20`
*   `expression` consists of digits and the operator `+`, `-`, and `*`.
*   All the integer values in the input expression are in the range `[0, 99]`.
