# Result for Unique Word Abbreviation
# *Kết quả cho bài toán Viết tắt Từ Duy nhất*

## Description
## *Mô tả*

The abbreviation of a word is a concatenation of its first letter, the number of characters between the first and last letter, and its last letter. If a word has only two characters, then it is an abbreviation of itself.
*Viết tắt của một từ là sự ghép nối giữa chữ cái đầu tiên, số lượng ký tự giữa chữ cái đầu và cuối, và chữ cái cuối cùng. Nếu một từ chỉ có hai ký tự, thì nó là viết tắt của chính nó.*

The following are valid abbreviations:
`"dog" --> "d1g"`
`"internationalization" --> "i18n"`
`"it" --> "it"`

Implement the `ValidWordAbbr` class:
*   `ValidWordAbbr(String[] dictionary)` Initializes the object with a dictionary of words.
*   `boolean isUnique(string word)` Returns `true` if **either** of the following conditions is met (otherwise returns `false`):
    *   There is no word in `dictionary` whose abbreviation is equal to `word`'s abbreviation.
    *   For any word in `dictionary` whose abbreviation is equal to `word`'s abbreviation, that word and `word` are the **same**.
*   *Trả về `true` nếu thỏa mãn **một trong** các điều kiện sau (ngược lại trả về `false`):*
    *   *Không có từ nào trong `dictionary` có từ viết tắt bằng với từ viết tắt của `word`.*
    *   *Đối với bất kỳ từ nào trong `dictionary` có từ viết tắt bằng với từ viết tắt của `word`, từ đó và `word` là **giống nhau**.*

## Example 1:
## *Ví dụ 1:*

**Input**
`["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique", "isUnique"]`
`[[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"], ["cake"]]`
**Output**
`[null, false, true, false, true, true]`

**Explanation**
ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
validWordAbbr.isUnique("dear"); // return false, dictionary word "deer" and word "dear" have the same abbreviation "d2r" but are not the same.
validWordAbbr.isUnique("cart"); // return true, no words in the dictionary have the abbreviation "c2t".
validWordAbbr.isUnique("cane"); // return false, dictionary word "cake" and word "cane" have the same abbreviation "c2e" but are not the same.
validWordAbbr.isUnique("make"); // return true, no words in the dictionary have the abbreviation "m2e".
validWordAbbr.isUnique("cake"); // return true, because "cake" is already in the dictionary and no other word in the dictionary has the abbreviation "c2e".

## Constraints:
## *Ràng buộc:*

*   `1 <= dictionary.length <= 3 * 10^4`
*   `1 <= dictionary[i].length <= 20`
*   `dictionary[i]` consists of lowercase English letters.
*   `1 <= word.length <= 20`
*   `word` consists of lowercase English letters.
*   At most `5000` calls will be made to `isUnique`.
