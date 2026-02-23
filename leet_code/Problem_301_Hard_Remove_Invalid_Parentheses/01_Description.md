# Result for Remove Invalid Parentheses
# *Kết quả cho bài toán Loại bỏ Dấu ngoặc Không hợp lệ*

## Description
## *Mô tả*

Given a string `s` that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
*Cho một chuỗi `s` chứa các dấu ngoặc và chữ cái, hãy loại bỏ số lượng tối thiểu các dấu ngoặc không hợp lệ để làm cho chuỗi đầu vào trở nên hợp lệ.*

Return *all the possible results*. You may return the answer in **any order**.
*Trả về *tất cả các kết quả có thể*. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "()())()"`
**Output:** `["(())()","()()()"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "(a)())()"`
**Output:** `["(a())()","(a)()()"]`

## Example 3:
## *Ví dụ 3:*

**Input:** `s = ")("`
**Output:** `[""]`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 25`
*   `s` consists of lowercase English letters and parentheses `'('` and `')'`.
*   There will be at most `20` parentheses in `s`.
