# Result for Substring with Concatenation of All Words
# *Kết quả cho bài toán Chuỗi Con với Sự Nối Của Tất Cả Các Từ*

## Description
## *Mô tả*

You are given a string `s` and an array of strings `words`. All the strings of `words` are of the **same length**.
*Bạn được cho một chuỗi `s` và một mảng các chuỗi `words`. Tất cả các chuỗi trong `words` đều có **cùng độ dài**.*

A **concatenated substring** in `s` is a substring that contains all the strings of any permutation of `words` concatenated.
*Một **chuỗi con nối ghép** trong `s` là một chuỗi con chứa tất cả các chuỗi của bất kỳ hoán vị nào của `words` nối lại với nhau.*

*   For example, if `words = ["ab","cd","ef"]`, then `"abcdef"`, `"abefcd"`, `"cdabef"`, `"cdefab"`, `"efabcd"`, and `"efcdab"` are all concatenated strings. `"acdbef"` is not a concatenated substring because it is not the concatenation of any permutation of `words`.
    *Ví dụ, nếu `words = ["ab","cd","ef"]`, thì `"abcdef"`, `"abefcd"`, `"cdabef"`, `"cdefab"`, `"efabcd"`, và `"efcdab"` đều là các chuỗi nối ghép. `"acdbef"` không phải là một chuỗi con nối ghép vì nó không phải là sự nối của bất kỳ hoán vị nào của `words`.*

Return the starting indices of all the concatenated substrings in `s`. You can return the answer in **any order**.
*Trả về các chỉ số bắt đầu của tất cả các chuỗi con nối ghép trong `s`. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

## Example 1:
## *Ví dụ 1:*

**Input:** `s = "barfoothefoobarman"`, `words = ["foo","bar"]`
**Output:** `[0,9]`
**Explanation:** Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
The output order does not matter. Returning [9,0] is fine too.

## Example 2:
## *Ví dụ 2:*

**Input:** `s = "wordgoodgoodgoodbestword"`, `words = ["word","good","best","word"]`
**Output:** `[]`
**Explanation:** Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.

## Example 3:
## *Ví dụ 3:*

**Input:** `s = "barfoofoobarthefoobarman"`, `words = ["bar","foo","the"]`
**Output:** `[6,9,12]`

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 10^4`
*   `1 <= words.length <= 5000`
*   `1 <= words[i].length <= 30`
*   `s` and `words[i]` consist of lowercase English letters.
