# 288. Unique Word Abbreviation / Viết Tắt Từ Duy Nhất

## Problem Description / Mô tả bài toán
The abbreviation of a word is a concatenation of its first letter, the number of characters between the first and last letter, and its last letter. If a word has only two characters, then it is an abbreviation of itself.
Viết tắt của một từ là sự nối tiếp của chữ cái đầu tiên, số lượng ký tự giữa chữ cái đầu và cuối, và chữ cái cuối cùng. Nếu một từ chỉ có hai ký tự, thì nó là viết tắt của chính nó.

For example:
- "dog" --> "d1g" because there is 1 letter between 'd' and 'g'.
- "internationalization" --> "i18n" because there are 18 letters between 'i' and 'n'.
- "it" --> "it" because there are 0 letters between 'i' and 't'.

Implement the `ValidWordAbbr` class:
- `ValidWordAbbr(String[] dictionary)` Initializes the object with a dictionary of words.
- `boolean isUnique(string word)` Returns `true` if **either** of the following conditions is met (otherwise returns `false`):
    - There is no word in `dictionary` whose abbreviation is equal to `word`'s abbreviation.
    - For any word in `dictionary` whose abbreviation is equal to `word`'s abbreviation, that word and `word` are the **same**.

### Example 1:
```text
Input
["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique", "isUnique"]
[[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"], ["cake"]]
Output
[null, false, true, false, true, true]

Explanation:
- "dear" -> "d2r". Dictionary has "deer" ("d2r"). Different words. Not unique. -> false.
- "cart" -> "c2t". Dictionary has "cake" ("c2e"), "card" ("c2d"). No "c2t". -> true.
- "cane" -> "c2e". Dictionary has "cake" ("c2e"). Different. -> false.
- "make" -> "m2e". Dictionary no "m2e". -> true.
- "cake" -> "c2e". Dictionary has "cake". Same. Unique within group (only cake has c2e). -> true.
```

## Constraints / Ràng buộc
- `1 <= dictionary.length <= 3 * 10^4`
- `1 <= dictionary[i].length <= 20`
- `dictionary[i]` consists of lowercase English letters.
- `1 <= word.length <= 20`
- `word` consists of lowercase English letters.
- At most `5000` calls will be made to `isUnique`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### HashMap Grouping
We need to know:
1.  Does the abbreviation exist?
2.  If yes, which word(s) map to it?
    - If multiples map to same abbr: Abbr is not unique for any NEW word. (And not unique for existing either?). Actually if multiple dict words share abbr (e.g., "door", "deer" -> "d2r"), then `isUnique("door")`?
        - Condition 2: "For ANY word in dictionary whose abbr..., that word and `word` are the same."
        - If dict = ["door", "deer"]. Abbr "d2r".
        - `isUnique("door")`: Dict has "door" and "deer".
        - Is "deer" same as "door"? No. So condition fails. -> False.
    - So if multiple distinct words map to abbr, then NO word is unique for that abbr.

**Data Structure**:
- `Map<String, String>`: `Abbr -> Word`.
- If we encounter same abbr but different word, mark value as specific failure token (e.g., `""` or special string).
- Or `Map<String, Boolean>`: `Abbr -> isUnique`. (Need to store actual word to check identity).
- `Map<String, Set<String>>`? Too heavy.
- Logic: `Abbr -> String`.
    - If key absent: put(abbr, word).
    - If key present:
        - If value equals word: do nothing (duplicate word in dict ignored).
        - If value diff: put(abbr, "") meaning "multiple".

**isUnique(word)**:
- Get `abbr(word)`.
- If map doesn't have abbr -> True.
- If map has abbr:
    - If value == `word` -> True.
    - Else -> False.

### Complexity / Độ phức tạp
- **Time**: O(N) init, O(1) query (assuming word length small constant 20).
- **Space**: O(N) dict words.

---

## Analysis / Phân tích

### Approach: HashMap

**Algorithm**:
1.  Init Map.
2.  Iterate dict:
    - `a = abbr(s)`.
    - If `map.containsKey(a)`:
        - `val = map.get(a)`.
        - If `val != s`: `map.put(a, "")`. (Mark invalid).
    - Else: `map.put(a, s)`.
3.  `isUnique(s)`:
    - `a = abbr(s)`.
    - `val = map.get(a)`.
    - `val == null` Or `val.equals(s)` -> True.
    - Else -> False.

---
