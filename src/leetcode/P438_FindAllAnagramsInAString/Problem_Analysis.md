# 438. Find All Anagrams in a String / Tìm Tất Cả Các Từ Đảo Chữ Trong Một Chuỗi

## Problem Description / Mô tả bài toán
Given two strings `s` and `p`, return an array of all the start indices of `p`'s anagrams in `s`. You may return the answer in any order.
Cho hai chuỗi `s` và `p`, hãy trả về một mảng chứa tất cả các chỉ số bắt đầu của các từ đảo chữ (anagram) của `p` có trong `s`. Bạn có thể trả về câu trả lời theo bất kỳ thứ tự nào.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Một **từ đảo chữ (anagram)** là một từ hoặc cụm từ được tạo thành bằng cách sắp xếp lại các chữ cái của một từ hoặc cụm từ khác, thường sử dụng tất cả các chữ cái ban đầu đúng một lần.

### Example 1:
```text
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
```

### Example 2:
```text
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```

## Constraints / Ràng buộc
- `1 <= s.length, p.length <= 3 * 10^4`
- `s` and `p` consist of lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sliding Window / Cửa sổ trượt
We use a fixed-size sliding window of length `p.length()` to traverse `s`.

Algorithm:
1. Count the frequency of characters in `p` and store it in an array `pFreq` (size 26).
2. Count the frequency of characters in the first window of `s` (from index 0 to `p.length() - 1`) and store it in `sFreq`.
3. If `sFreq` equals `pFreq`, index 0 is a result.
4. Slide the window one character at a time from index 1 to `s.length() - p.length()`:
   - Add the new character (at `right`) to `sFreq`.
   - Remove the old character (at `left`) from `sFreq`.
   - Compare `sFreq` and `pFreq` (can be done in O(26) or O(1) with a difference counter).
5. Store matching indices and return.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s` (since we compare local frequency array of size 26 for each step).
- **Space**: O(1) for the frequency arrays.

---

## Analysis / Phân tích

### Approach: Fixed Window Matching

**Algorithm**:
1.  Initialize frequency arrays.
2.  Initial window count.
3.  Shift and compare loop.

---
