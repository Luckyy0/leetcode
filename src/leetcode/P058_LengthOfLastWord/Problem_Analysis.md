# 58. Length of Last Word / Độ Dài Của Từ Cuối Cùng

## Problem Description / Mô tả bài toán
Given a string `s` consisting of words and spaces, return the length of the **last** word in the string.
Cho một chuỗi `s` bao gồm các từ và khoảng trắng, hãy trả về độ dài của **từ cuối cùng** trong chuỗi.

A **word** is a maximal substring consisting of non-space characters only.
Một **từ** là một chuỗi con tối đa chỉ bao gồm các ký tự không phải khoảng trắng.

### Example 1:
```text
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
```

### Example 2:
```text
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^4`
- `s` consists of only English letters and spaces `' '`.
- There will be at least one word in `s`.

---

## Analysis / Phân tích

### Approach: Iterate Backwards / Duyệt Ngược
- **Idea**: Scan from the end of the string.
- **Ý tưởng**: Quét từ cuối chuỗi.
- **Steps**:
    1.  Skip trailing spaces (if any).
    2.  Count characters until a space or beginning of string is found.
- **Time Complexity**: O(n).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Trailing Spaces**: "a ".
2.  **Single Word**: "a".
3.  **Multiple Words**: "a b".
