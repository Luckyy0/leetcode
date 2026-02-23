# Result for Implement Magic Dictionary
# *Kết quả cho bài toán Cài đặt Từ điển Ma thuật*

## Description
## *Mô tả*

Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change **exactly one character** in this string to match any word in the data structure.
*Thiết kế một cấu trúc dữ liệu được khởi tạo bằng một danh sách các từ khác nhau. Cho một chuỗi, bạn nên xác định xem mình có thể thay đổi **đúng một ký tự** trong chuỗi này để khớp với bất kỳ từ nào trong cấu trúc dữ liệu đó hay không.*

Implement the `MagicDictionary` class:
*Cài đặt lớp `MagicDictionary`:*

- `MagicDictionary()` Initializes the object.
    - *`MagicDictionary()` Khởi tạo đối tượng.*
- `void buildDict(String[] dictionary)` Sets the data structure with an array of strings `dictionary`.
    - *`void buildDict(String[] dictionary)` Thiết lập cấu trúc dữ liệu với một mảng các chuỗi `dictionary`.*
- `boolean search(String searchWord)` Returns `true` if you can change **exactly one character** in `searchWord` to match any string in the data structure, otherwise returns `false`.
    - *`boolean search(String searchWord)` Trả về `true` nếu bạn có thể thay đổi **đúng một ký tự** trong `searchWord` để khớp với bất kỳ chuỗi nào trong cấu trúc dữ liệu, ngược lại trả về `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input**
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
**Output**
[null, null, false, true, false, false]

**Explanation**
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // return False
magicDictionary.search("hhllo"); // return True
magicDictionary.search("hell"); // return False
magicDictionary.search("leetcoded"); // return False

---

## Constraints:
## *Ràng buộc:*

*   `1 <= dictionary.length <= 100`
*   `1 <= dictionary[i].length <= 100`
*   `dictionary[i]` consists of only lowercase English letters.
*   All the strings in `dictionary` are distinct.
*   `1 <= searchWord.length <= 100`
*   `searchWord` consists of only lowercase English letters.
*   `buildDict` will be called only once before `search`.
*   At most `100` calls will be made to `search`.
