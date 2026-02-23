# Result for Unique Morse Code Words
# *Kết quả cho bài toán Các từ mã Morse duy nhất*

## Description
## *Mô tả*

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes.
*Mã Morse quốc tế định nghĩa một bảng mã tiêu chuẩn trong đó mỗi chữ cái được ánh xạ thành một chuỗi các dấu chấm và dấu gạch ngang.*

*   'a' maps to `".-"`, 'b' maps to `"-..."`, and so on.
*   *'a' ánh xạ tới `".-"`, 'b' ánh xạ tới `"-..."`, v.v.*

Given an array of strings `words` where each word can be written as a concatenation of the Morse code of each letter. For example, `"cab"` can be written as `"-.-." + ".-" + "-..."`, which is `"-.-....-..."`. We will call such a concatenation the **transformation** of a word.
*Cho một mảng `words`, mỗi từ có thể được viết bằng cách nối mã Morse của từng chữ cái. Chúng ta gọi chuỗi nối này là **chuyển đổi** của một từ.*

Return *the number of different **transformations** among all words we have*.
*Trả về *số lượng các **chuyển đổi** khác nhau trong tất cả các từ mà chúng ta có*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["gin","zen","gig","msg"]
**Output:** 2
**Explanation:** The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations: "--...-." and "--...--.".

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["a"]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 100`
*   `1 <= words[i].length <= 12`
*   `words[i]` consists of lowercase English letters.
