# Result for Top K Frequent Words
# *Kết quả cho bài toán Top K Từ phổ biến nhất*

## Description
## *Mô tả*

Given an array of strings `words` and an integer `k`, return the `k` most frequent strings.
*Cho một mảng các chuỗi `words` và một số nguyên `k`, hãy trả về `k` chuỗi xuất hiện thường xuyên nhất.*

Return the answer **sorted** by the frequency from highest to lowest. Sort the words with the same frequency by their **lexicographical order**.
*Trả về câu trả lời được **sắp xếp** theo tần suất từ cao đến thấp. Sắp xếp các từ có cùng tần suất theo **thứ tự từ điển**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** words = ["i","love","leetcode","i","love","coding"], k = 2
**Output:** ["i","love"]
**Explanation:** "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

## Example 2:
## *Ví dụ 2:*

**Input:** words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
**Output:** ["the","is","sunny","day"]
**Explanation:** "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= words.length <= 500`
*   `1 <= words[i].length <= 10`
*   `words[i]` consists of lowercase English letters.
*   `k` is in the range `[1, The number of unique words[i]]`

---

## Follow-up:
## *Mở rộng:*

Could you solve it in $O(n \log k)$ time and $O(n)$ extra space?
*Bạn có thể giải quyết bài toán trong thời gian $O(n \log k)$ và không gian phụ trợ $O(n)$ không?*
