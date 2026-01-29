# 482. License Key Formatting / Định Dạng Khóa Bản Quyền

## Problem Description / Mô tả bài toán
You are given a license key represented as a string `s` that consists of only alphanumeric characters and dashes. The string is separated into `n + 1` groups by `n` dashes. You are also given an integer `k`.
Bạn được cho một khóa bản quyền dưới dạng một chuỗi `s` bao gồm các chữ cái, chữ số và dấu gạch ngang. Chuỗi được chia thành `n + 1` nhóm bởi `n` dấu gạch ngang. Bạn cũng được cho một số nguyên `k`.

We want to reformat the string `s` such that each group contains exactly `k` characters, except for the first group, which could be shorter than `k` but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
Chúng ta muốn định dạng lại chuỗi `s` sao cho mỗi nhóm chứa đúng `k` ký tự, ngoại trừ nhóm đầu tiên có thể ngắn hơn `k` nhưng phải chứa ít nhất một ký tự. Hơn nữa, phải có một dấu gạch ngang chèn giữa hai nhóm và bạn nên chuyển tất cả các chữ cái thường thành chữ hoa.

Return the reformatted license key.
Hãy trả về khóa bản quyền đã được định dạng lại.

### Example 1:
```text
Input: s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"
Explanation: The string s has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
```

### Example 2:
```text
Input: s = "2-5g-3-J", k = 2
Output: "2-5G-3J"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^5`
- `s` consists of English letters, digits, and dashes `'-'`.
- `1 <= k <= 10^4`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse Processing / Xử lý ngược
Since the first group can be shorter but all subsequent groups must have exactly `k` characters, it's easier to process from **right to left**.

Algorithm:
1. Traverse the string `s` from the end to the beginning.
2. Ignore all existing dashes.
3. Keep track of the number of characters added to the current group.
4. After every `k` characters, insert a dash `-`.
5. Convert characters to uppercase as you go.
6. Reverse the result and remove any leading dash if it was inserted at the very end.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `s`.
- **Space**: O(N) to store the result.

---

## Analysis / Phân tích

### Approach: Right-to-Left Aggregation

**Algorithm**:
1.  Iterate backwards skipping `-`.
2.  Count characters modulo `k` to insert `-`.
3.  Upper-case transform.
4.  Reverse and trim.

---
