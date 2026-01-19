# 14. Longest Common Prefix / Tiền Tố Chung Dài Nhất

## Problem Description / Mô tả bài toán
Write a function to find the longest common prefix string amongst an array of strings.
Viết một hàm để tìm tiền tố chung dài nhất trong một mảng các chuỗi.

If there is no common prefix, return an empty string `""`.
Nếu không có tiền tố chung, trả về chuỗi rỗng `""`.

### Example 1:
```text
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

### Example 2:
```text
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

## Constraints / Ràng buộc
- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` consists of only lowercase English letters.

---

## Analysis / Phân tích

### Approach 1: Horizontal Scanning / Quét Ngang
- **Idea**: Let `LCP(S1, S2, S3) = LCP(LCP(S1, S2), S3)`.
- **Ý tưởng**: Gọi `prefix` là chuỗi đầu tiên. So sánh nó với chuỗi thứ 2, cập nhật `prefix` là phần chung. Sau đó so sánh với chuỗi thứ 3, v.v.
- **Time Complexity**: O(S), where S is the sum of all characters in all strings.
- **Space Complexity**: O(1) (ignoring result space).

### Approach 2: Vertical Scanning / Quét Dọc
- **Idea**: Compare the first character of all strings. Then the second character, etc. Return immediately if a mismatch is found.
- **Ý tưởng**: So sánh ký tự đầu tiên của tất cả các chuỗi. Sau đó là ký tự thứ hai, v.v. Trả về ngay lập tức nếu tìm thấy sự không khớp.
- **Pros**: Better than horizontal if the last string is very short or different (fail fast).
- **Time Complexity**: O(S).
- **Space Complexity**: O(1).

### Approach 3: Sorting / Sắp Xếp
- **Idea**: Sort the array of strings. The longest common prefix must be the prefix of the *first* and the *last* string (since sorting groups similar prefixes).
- **Ý tưởng**: Sắp xếp mảng các chuỗi. Tiền tố chung dài nhất phải là tiền tố của chuỗi *đầu tiên* và chuỗi *cuối cùng* (vì sắp xếp nhóm các tiền tố giống nhau lại).
- **Time Complexity**: O(N * L * log N) due to sorting.
- **Space Complexity**: O(1) or O(log N) for sort stack.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Array**: Input `[]` -> `""` (Constraint says length >= 1, but good to check).
2.  **Empty String in Array**: `["a", ""]` -> `""`.
3.  **Single String**: `["abc"]` -> `"abc"`.
4.  **No Common Prefix**: `["a", "b"]` -> `""`.
