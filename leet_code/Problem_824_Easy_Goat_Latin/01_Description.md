# Result for Goat Latin
# *Kết quả cho bài toán Tiếng Latin của Dê*

## Description
## *Mô tả*

You are given a string `sentence` that consists of words separated by spaces. Each word consists of lowercase and uppercase letters only.
*Cho một chuỗi `sentence` bao gồm các từ cách nhau bởi khoảng trắng. Mỗi từ chỉ bao gồm các chữ cái viết thường và viết hoa.*

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
*Chúng ta muốn chuyển đổi câu này sang "Goat Latin" (một ngôn ngữ giả tưởng tương tự như Pig Latin). Các quy tắc như sau:*

1.  If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append `"ma"` to the end of the word.
    - For example, the word `"apple"` becomes `"applema"`.
2.  If a word begins with a consonant, remove the first letter and append it to the end, then append `"ma"`.
    - For example, the word `"goat"` becomes `"oatgma"`.
3.  Add one letter `'a'` to the end of each word per its 1-indexed position in the sentence, starting with 'a', then "aa", then "aaa", and so on.
    - For example, the first word gets `"a"` added to the end, the second word gets `"aa"` added to the end, and so on.

Return *the final sentence representing the conversion from `sentence` to Goat Latin*.
*Trả về *câu cuối cùng sau khi chuyển đổi sang Goat Latin*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** sentence = "I speak Goat Latin"
**Output:** "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

## Example 2:
## *Ví dụ 2:*

**Input:** sentence = "The quick brown fox jumped over the lazy dog"
**Output:** "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

---

## Constraints:
## *Ràng buộc:*

*   `1 <= sentence.length <= 150`
*   `sentence` consists of English letters and spaces.
*   `sentence` has no leading or trailing spaces.
*   All the words in `sentence` are separated by a single space.
