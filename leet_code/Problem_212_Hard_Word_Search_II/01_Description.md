# Result for Word Search II
# *Kết quả cho bài toán Tìm kiếm từ II*

## Description
## *Mô tả*

Given an `m x n` `board` of characters and a list of strings `words`, return *all words on the board*.
*Cho một bảng ký tự `m x n` `board` và một danh sách các chuỗi `words`, hãy trả về *tất cả các từ có trên bảng***.*

Each word must be constructed from letters of sequentially adjacent cells, where **adjacent cells** are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
*Mỗi từ phải được tạo thành từ các chữ cái của các ô liền kề nhau, trong đó **các ô liền kề** là láng giềng theo chiều ngang hoặc chiều dọc. Cùng một ô chữ cái không được sử dụng nhiều hơn một lần trong một từ.*

## Example 1:
## *Ví dụ 1:*

**Input:** `board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]`
**Output:** `["eat","oath"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `board = [["a","b"],["c","d"]], words = ["abcb"]`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   `m == board.length`
*   `n == board[i].length`
*   `1 <= m, n <= 12`
*   `board[i][j]` is a lowercase English letter.
*   `1 <= words.length <= 3 * 10^4`
*   `1 <= words[i].length <= 10`
*   `words[i]` consists of lowercase English letters.
*   All the strings of `words` are unique.
