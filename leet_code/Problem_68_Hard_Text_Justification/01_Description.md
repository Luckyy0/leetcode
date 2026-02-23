# Result for Text Justification
# *Kết quả cho bài toán Căn Lề Văn Bản*

## Description
## *Mô tả*

Given an array of strings `words` and a width `maxWidth`, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.
*Cho một mảng các chuỗi `words` và một chiều rộng `maxWidth`, hãy định dạng văn bản sao cho mỗi dòng có chính xác `maxWidth` ký tự và được căn đều (trái và phải).*

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly `maxWidth` characters.
*Bạn nên đóng gói các từ theo phương pháp tham lam; tức là đóng gói nhiều từ nhất có thể vào mỗi dòng. Thêm các khoảng trắng `' '` khi cần thiết sao cho mỗi dòng có đúng `maxWidth` ký tự.*

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
*Các khoảng trắng thừa giữa các từ nên được phân bổ đều nhất có thể. Nếu số lượng khoảng trắng trên một dòng không chia đều giữa các từ, các ô trống bên trái sẽ được gán nhiều khoảng trắng hơn các ô trống bên phải.*

For the last line of text, it should be left-justified, and no extra space is inserted between words.
*Đối với dòng văn bản cuối cùng, nó nên được căn lề trái và không chèn thêm khoảng trắng thừa giữa các từ.*

**Note:**
*   A word is defined as a character sequence consisting of non-space characters only.
*   Each word's length is guaranteed to be greater than `0` and not exceed `maxWidth`.
*   The input array `words` contains at least one word.

## Example 1:
## *Ví dụ 1:*

**Input:** `words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16`
**Output:**
```
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

## Example 2:
## *Ví dụ 2:*

**Input:** `words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 12`
**Output:**
```
[
  "What must be",
  "acknowledgment",
  "shall be    "
]
```

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 300`
*   `1 <= words[i].length <= 20`
*   `words[i]` consists of only English letters and symbols.
*   `1 <= maxWidth <= 100`
*   Each `words[i].length <= maxWidth`
