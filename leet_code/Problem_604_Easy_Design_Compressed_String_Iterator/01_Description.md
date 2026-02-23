# Result for Design Compressed String Iterator
# *Kết quả cho bài toán Thiết kế Bộ lặp Chuỗi đã Nén*

## Description
## *Mô tả*

Design and implement a data structure for a compressed string iterator. The given compressed string will be in the form of a character followed by a positive integer representing the number of times that character appears in the original uncompressed string.
*Thiết kế và triển khai một cấu trúc dữ liệu cho bộ lặp chuỗi đã nén. Chuỗi đã nén được cung cấp sẽ có dạng một ký tự theo sau bởi một số nguyên dương đại diện cho số lần ký tự đó xuất hiện trong chuỗi ban đầu chưa nén.*

Implement the StringIterator class:
*Triển khai lớp StringIterator:*

*   `StringIterator(String compressedString)` Initializes the object with the compressed string.
    *   *`StringIterator(String compressedString)` Khởi tạo đối tượng với chuỗi đã nén.*
*   `char next()` Returns the next character if the original string still has uncompressed characters, otherwise returns a white space.
    *   *`char next()` Trả về ký tự tiếp theo nếu chuỗi ban đầu vẫn còn các ký tự chưa nén, ngược lại trả về một khoảng trắng.*
*   `boolean hasNext()` Returns `true` if there is any letter in the uncompressed string that hasn't been returned yet, otherwise returns `false`.
    *   *`boolean hasNext()` Trả về `true` nếu còn bất kỳ chữ cái nào trong chuỗi chưa nén chưa được trả về, ngược lại trả về `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:**
["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
[["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
**Output:**
[null, "L", "e", "e", "t", "C", "o", true, "d", true]

**Explanation:**
```
StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.hasNext(); // return true
iterator.next(); // return 'd'
iterator.hasNext(); // return true
```

---

## Constraints:
## *Ràng buộc:*

*   `1 <= compressedString.length <= 1000`
*   `compressedString` consists of lower-case English letters, upper-case English letters, and digits.
*   The number of characters in the original uncompressed string will be in the range `[1, 10^9]`.
*   At most `1000` calls will be made to `next` and `hasNext`.
