# 3. Longest Substring Without Repeating Characters / Chuỗi Con Dài Nhất Không Chứa Ký Tự Lặp Lại

## Problem Description / Mô tả bài toán
Given a string `s`, find the length of the **longest substring** without repeating characters.
Cho một chuỗi `s`, tìm độ dài của **chuỗi con dài nhất** không chứa ký tự lặp lại.

### Example 1:
```text
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

### Example 2:
```text
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

### Example 3:
```text
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

## Constraints / Ràng buộc
- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols and spaces.

---

## Analysis / Phân tích

### Approach 1: Brute Force / Vét cạn
- **Idea**: Check all substrings one by one to see if they have no unique characters.
- **Ý tưởng**: Kiểm tra từng chuỗi con một xem chúng có chứa ký tự duy nhất hay không.
- **Time Complexity**: O(n^3). Nested loops to generate substrings (O(n^2)) + O(n) to check uniqueness.
- **Space Complexity**: O(min(n, m)) for the Set.

### Approach 2: Sliding Window using HashSet / Cửa sổ trượt dùng HashSet
- **Idea**: Use two pointers (`left`, `right`) and a HashSet to maintain a window of unique characters. If `s[right]` exists in Set, remove `s[left]` and increment `left` until the duplicate is removed.
- **Ý tưởng**: Sử dụng hai con trỏ (`left`, `right`) và một HashSet để duy trì cửa sổ các ký tự duy nhất. Nếu `s[right]` đã có trong Set, xóa `s[left]` và tăng `left` cho đến khi hết trùng lặp.
- **Time Complexity**: O(2n) = O(n). In the worst case, each character will be visited twice by `left` and `right`.
- **Space Complexity**: O(min(m, n)). We need O(k) space for the sliding window, where k is the size of the Set.

### Approach 3: Sliding Window Optimized (HashMap/Array) / Cửa sổ trượt tối ưu
- **Idea**: Instead of incrementing `left` one by one, if we find a duplicate character `s[right]` at index `j`, we can immediately skip `left` to `j + 1`. We use a Map to store the index of each character.
- **Ý tưởng**: Thay vì tăng `left` từng bước, nếu ta gặp ký tự trùng `s[right]` tại chỉ số `j`, ta có thể nhảy `left` ngay lập tức đến `j + 1`. Dùng Map để lưu chỉ số của từng ký tự.
- **Time Complexity**: O(n). Index `j` will iterate n times.
- **Space Complexity**: O(min(m, n)).

---

## Edge Cases / Các trường hợp biên
1. **Empty String**: Should return 0.
2. **Single Character**: Should return 1.
3. **All Same Characters**: "aaaaa" -> 1.
4. **No Repeating**: "abcdef" -> 6.
5. **Special Characters**: " " (space), symbols.
