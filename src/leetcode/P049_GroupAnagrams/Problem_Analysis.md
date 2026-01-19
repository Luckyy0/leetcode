# 49. Group Anagrams / Nhóm Các Từ Đảo Chữ

## Problem Description / Mô tả bài toán
Given an array of strings `strs`, group **the anagrams** together. You can return the answer in **any order**.
Cho một mảng các chuỗi `strs`, hãy nhóm **các từ đảo chữ** lại với nhau. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Một **Anagram** (từ đảo chữ) là một từ hoặc cụm từ được hình thành bằng cách sắp xếp lại các chữ cái của một từ hoặc cụm từ khác, thường sử dụng tất cả các chữ cái ban đầu chính xác một lần.

### Example 1:
```text
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

### Example 2:
```text
Input: strs = [""]
Output: [[""]]
```

### Example 3:
```text
Input: strs = ["a"]
Output: [["a"]]
```

## Constraints / Ràng buộc
- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

---

## Analysis / Phân tích

### Approach 1: Sorting as Key / Sắp Xếp Làm Khóa
- **Idea**: Two strings are anagrams if and only if their sorted characters are the same.
- **Ý tưởng**: Hai chuỗi là anagram nếu và chỉ nếu các ký tự đã sắp xếp của chúng giống nhau.
- **Algorithm**:
    - Iterate through each string `s`.
    - Sort `s` -> `key`.
    - Add `s` to the list in `map.get(key)`.
- **Time Complexity**: O(N * K log K), where N is number of strings, K is max length of a string.
- **Space Complexity**: O(N * K).

### Approach 2: Frequency Count as Key / Đếm Tần Suất Làm Khóa
- **Idea**: Use a character count (e.g., "a1b0...z0") as key.
- **Time Complexity**: O(N * K).
- **Space Complexity**: O(N * K).

---

## Edge Cases / Các trường hợp biên
1.  **Empty String**: `[""]` -> `[[""]]`.
2.  **Single Group**: All disjoint.
