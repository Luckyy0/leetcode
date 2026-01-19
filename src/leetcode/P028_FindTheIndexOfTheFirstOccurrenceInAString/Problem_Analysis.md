# 28. Find the Index of the First Occurrence in a String / Tìm Chỉ Số Của Lần Xuất Hiện Đầu Tiên Trong Chuỗi

## Problem Description / Mô tả bài toán
Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.
Cho hai chuỗi `needle` và `haystack`, trả về chỉ số của lần xuất hiện đầu tiên của `needle` trong `haystack`, hoặc `-1` nếu `needle` không phải là một phần của `haystack`.

### Example 1:
```text
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.
```

### Example 2:
```text
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
```

## Constraints / Ràng buộc
- `1 <= haystack.length, needle.length <= 10^4`
- `haystack` and `needle` consist of only lowercase English characters.

---

## Analysis / Phân tích

### Approach 1: Simple Sliding Window / Cửa Sổ Trượt Đơn Giản
- **Idea**: For every index `i` in `haystack`, check if the substring `haystack[i...i+len(needle)]` matches `needle`.
- **Ý tưởng**: Với mỗi chỉ số `i` trong `haystack`, kiểm tra xem chuỗi con `haystack[i...i+len(needle)]` có khớp với `needle` hay không.
- **Time Complexity**: O(n * m).
- **Space Complexity**: O(1).

### Approach 2: Built-in Method / Phương thức có sẵn
- **Idea**: Use `haystack.indexOf(needle)`.
- **Ý tưởng**: Sử dụng `haystack.indexOf(needle)`.
- **Time Complexity**: depends on implementation (usually optimized).
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Needle longer than Haystack**: Return -1.
2.  **Identical**: Return 0.
