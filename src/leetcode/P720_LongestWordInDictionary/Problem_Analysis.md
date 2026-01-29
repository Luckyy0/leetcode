# 720. Longest Word in Dictionary / Từ Dài nhất trong Từ điển

## Problem Description / Mô tả bài toán
Given an array of strings `words` representing an English Dictionary, return the longest word in `words` that can be built one character at a time by other words in `words`.
Cho một mảng các chuỗi `words` đại diện cho một Từ điển tiếng Anh, hãy trả về từ dài nhất trong `words` có thể được xây dựng từng ký tự một bởi các từ khác trong `words`.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return an empty string.
Nếu có nhiều hơn một câu trả lời khả thi, hãy trả về từ dài nhất có thứ tự từ điển nhỏ nhất. Nếu không có câu trả lời, hãy trả về một chuỗi trống.

### Example:
```text
Input: words = ["w","wo","wor","worl","world"]
Output: "world"
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie or Hash Set / Trie hoặc Tập hợp Băm
We can use a `HashSet` to store all words for O(1) lookup.
Chúng ta có thể sử dụng `HashSet` để lưu trữ tất cả các từ để tra cứu nhanh.

Algorithm:
1. Sort words lexicographically (to handle tie-breaking early or by sorting).
2. Iterate through words:
   - For each word, check if all its prefixes exist in the set.
   - Example: For "apple", check "a", "ap", "app", "appl".
3. Update the longest valid word found.

### Complexity / Độ phức tạp
- **Time**: O(Sum of length of words * Avg length).
- **Space**: O(Sum of length of words).

---

## Analysis / Phân tích

### Approach: Prefix Verification via HashSet
Sort the words by length (asc) and then lexicographically (asc). Use a Set to track valid words (those whose prefix length - 1 is also valid).
Sắp xếp các từ theo độ dài và sau đó theo thứ tự từ điển. Sử dụng một Tập hợp để theo dõi các từ hợp lệ (những từ có tiền tố độ dài - 1 cũng hợp lệ).

---
