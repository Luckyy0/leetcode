# Result for Edit Distance
# *Kết quả cho bài toán Khoảng Cách Chỉnh Sửa*

## Description
## *Mô tả*

Given two strings `word1` and `word2`, return *the minimum number of operations required to convert `word1` to `word2`*.
*Cho hai chuỗi `word1` và `word2`, hãy trả về *số lượng thao tác tối thiểu cần thiết để chuyển đổi `word1` thành `word2`**.*

You have the following three operations permitted on a word:
*Bạn được phép thực hiện ba thao tác sau trên một từ:*

1.  Insert a character (*Chèn một ký tự*)
2.  Delete a character (*Xóa một ký tự*)
3.  Replace a character (*Thay thế một ký tự*)

## Example 1:
## *Ví dụ 1:*

**Input:** `word1 = "horse", word2 = "ros"`
**Output:** `3`
**Explanation:** 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

## Example 2:
## *Ví dụ 2:*

**Input:** `word1 = "intention", word2 = "execution"`
**Output:** `5`
**Explanation:** 
intention -> entention (replace 'i' with 'e')
entention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (replace 't' with 'u')
execution -> execution (already done)
Wait, let's look carefully:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

## Constraints:
## *Ràng buộc:*

*   `0 <= word1.length, word2.length <= 500`
*   `word1` and `word2` consist of lowercase English letters.
