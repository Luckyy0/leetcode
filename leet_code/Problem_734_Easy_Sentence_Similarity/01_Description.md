# Result for Sentence Similarity
# *Kết quả cho bài toán Sự tương đồng của Câu (Sentence Similarity)*

## Description
## *Mô tả*

We can represent a sentence as an array of strings, for example, the sentence "I am happy with leetcode" can be represented as `sentence1 = ["I","am","happy","with","leetcode"]`.
*Chúng ta có thể đại diện cho một câu bằng một mảng các chuỗi, ví dụ, câu "I am happy with leetcode" có thể được đại diện là `sentence1 = ["I","am","happy","with","leetcode"]`.*

Given two sentences `sentence1` and `sentence2` each represented as a string array and given a list of similar word pairs `similarPairs`, return `true` if these two sentences are similar.
*Cho hai câu `sentence1` và `sentence2`, mỗi câu được đại diện bởi một mảng chuỗi, và cho một danh sách các cặp từ tương đồng `similarPairs`. Hãy trả về `true` nếu hai câu này tương đồng.*

Return `true` if:
1. `sentence1` and `sentence2` have the same length.
2. For each index `i`, the words `sentence1[i]` and `sentence2[i]` are similar.

*Hãy trả về `true` nếu:*
* 1. `sentence1` và `sentence2` có cùng độ dài.*
* 2. Với mỗi chỉ số `i`, các từ `sentence1[i]` và `sentence2[i]` là tương đồng.*

A word `w1` and `w2` are similar if:
- `w1 == w2`
- They are a pair in `similarPairs`. For example, `(w1, w2)` is in `similarPairs`.

*Hai từ `w1` và `w2` được coi là tương đồng nếu:*
* - `w1 == w2`*
* - Chúng là một cặp trong `similarPairs`. Ví dụ, `(w1, w2)` nằm trong `similarPairs`.*

Note that the similarity relation is **not transitive**. For example, if "happy" and "cheerful" are similar, and "cheerful" and "glad" are similar, it does **not** imply that "happy" and "glad" are similar.
*Lưu ý rằng quan hệ tương đồng này **không có tính bắc cầu**. Ví dụ, nếu "happy" và "cheerful" là tương đồng, và "cheerful" và "glad" là tương đồng, điều đó **không** có nghĩa là "happy" và "glad" là tương đồng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]]
**Output:** true
**Explanation:** The pairs of words at each index are similar.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= sentence1.length, sentence2.length <= 1000`
*   `sentence1[i].length, sentence2[i].length <= 20`
*   `0 <= similarPairs.length <= 1000`
*   `similarPairs[i].length == 2`
*   `similarPairs[i][j].length <= 20`
*   All the words consist of lower case English letters.
