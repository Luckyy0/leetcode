# Result for Uncommon Words from Two Sentences
# *Kết quả cho bài toán Các từ Không phổ biến từ Hai Câu*

## Description
## *Mô tả*

A **sentence** is a string of single-space separated words where each word consists only of lowercase letters.
*Một **câu** là một chuỗi các từ được ngăn cách bởi một khoảng trắng, trong đó mỗi từ chỉ bao gồm các chữ cái viết thường.*

A word is **uncommon** if it appears exactly once in one of the sentences, and **does not appear** in the other sentence.
*Một từ là **không phổ biến** nếu nó xuất hiện đúng một lần trong một trong hai câu, và **không xuất hiện** trong câu còn lại.*

Given two sentences `s1` and `s2`, return *a list of all the **uncommon words***. You may return the answer in **any order**.
*Cho hai câu `s1` và `s2`, hãy trả về *một danh sách tất cả các **từ không phổ biến***. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s1 = "this apple is sweet", s2 = "this apple is sour"
**Output:** ["sweet","sour"]
**Explanation:** 
"sweet" appears once in s1 and 0 times in s2. Total 1.
"sour" appears once in s2 and 0 times in s1. Total 1.
"this", "apple", "is" appear in both. Total >= 2.

## Example 2:
## *Ví dụ 2:*

**Input:** s1 = "apple apple", s2 = "banana"
**Output:** ["banana"]
**Explanation:** 
"apple" appears twice in s1. Total 2. Not uncommon.
"banana" appears once in s2. Total 1. Uncommon.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s1.length, s2.length <= 200`
*   `s1` and `s2` consist of lowercase English letters and spaces.
*   `s1` and `s2` do not have leading or trailing spaces.
*   All the words in `s1` and `s2` are separated by a single space.
