# 30. Substring with Concatenation of All Words / Chuỗi Con Nối Ngôi Tất Cả Các Từ

## Problem Description / Mô tả bài toán
You are given a string `s` and an array of strings `words` of the **same length**. Return all starting indices of substring(s) in `s` that is a concatenation of each word in `words` exactly once, **in any order**, and without any intervening characters.
Bạn được cho một chuỗi `s` và một mảng các chuỗi `words` có **cùng độ dài**. Trả về tất cả các chỉ số bắt đầu của (các) chuỗi con trong `s` là sự nối tất cả các từ trong `words` chính xác một lần, **theo bất kỳ thứ tự nào**, và không có bất kỳ ký tự xen kẽ nào.

You can return the answer in **any order**.
Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively. The output order does not matter, returning [9,0] is fine too.
```

### Example 2:
```text
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
```

### Example 3:
```text
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^4`
- `1 <= words.length <= 5000`
- `1 <= words[i].length <= 30`
- `s` and `words[i]` consist of lowercase English letters.

---

## Analysis / Phân tích

### Approach: Sliding Window with HashMap / Cửa Sổ Trượt dùng HashMap
- **Idea**: Since all words are the same length `L`, we can check windows of size `totalLen = L * count`.
- **Ý tưởng**: Vì tất cả các từ có cùng độ dài `L`, ta có thể kiểm tra các cửa sổ có kích thước `totalLen = L * count`.
- **Optimization**: Instead of checking every index `i`, we can process `L` parallel scans (offsets 0 to `L-1`).
    - For each offset `i` from `0` to `L-1`:
        - Use `left` and `right` pointers hopping by `L`.
        - Maintain a map `seen` for the current window.
        - `right` moves forward, add word to `seen`.
        - If count of a word > expected count, move `left` forward until valid.
        - If window size == total count, add `left` to result.
- **Time Complexity**: O(N * L) where N is length of s, L is word length.
- **Space Complexity**: O(M) where M is number of words (for Map).

---

## Edge Cases / Các trường hợp biên
1.  **Length Mismatch**: `s` shorter than concatenation.
2.  **No Match**: Returns empty list.
