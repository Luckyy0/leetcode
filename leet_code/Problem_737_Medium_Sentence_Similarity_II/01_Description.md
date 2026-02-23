# Result for Sentence Similarity II
# *Kết quả cho bài toán Sự tương đồng của Câu II (Sentence Similarity II)*

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

In this problem, the similarity relation is **transitive**. For example, if "happy" and "cheerful" are similar, and "cheerful" and "glad" are similar, then "happy" and "glad" are **also** similar.
*Ở bài toán này, quan hệ tương đồng có **tính chất bắc cầu**. Ví dụ, nếu "happy" và "cheerful" là tương đồng, và "cheerful" và "glad" là tương đồng, thì "happy" và "glad" **cũng** tương đồng.*

Similarity is also symmetric. For example, "happy" is similar to "cheerful" means "cheerful" is similar to "happy". Also, a word is always similar with itself.
*Tương đồng cũng có tính đối xứng. Ví dụ, "happy" giống "cheerful" thì "cheerful" cũng giống "happy". Ngoài ra, một từ luôn tương đồng với chính nó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], similarPairs = [["great","good"],["fine","good"],["drama","acting"],["skills","talent"]]
**Output:** true
**Explanation:** 
- "great" and "good" are similar, "fine" and "good" are similar, so "great" and "fine" are similar.
- "drama" and "acting" are similar.
- "skills" and "talent" are similar.

---

## Constraints:
## *Ràng buộc:*

*   `sentence1.length == sentence2.length`
*   `1 <= sentence1.length <= 1000`
*   `sentence1[i].length, sentence2[i].length <= 20`
*   `0 <= similarPairs.length <= 2000`
*   `similarPairs[i].length == 2`
*   `similarPairs[i][j].length <= 20`
*   All the words consist of lower case English letters.
