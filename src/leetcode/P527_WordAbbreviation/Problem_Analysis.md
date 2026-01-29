# 527. Word Abbreviation / Viết Tắt Từ

## Problem Description / Mô tả bài toán
Given an array of `n` distinct non-empty strings, return an array of their abbreviations.
Cho một mảng gồm `n` chuỗi khác nhau không rỗng, hãy trả về một mảng chứa các từ viết tắt của chúng.

The abbreviation of a string is constructed by keeping the first char, followed by the number of characters skipped, followed by the last char. If the abbreviation is not shorter than the original string, keep the original string.
Từ viết tắt của một chuỗi được tạo bằng cách giữ lại ký tự đầu tiên, theo sau là số lượng ký tự bị bỏ qua, và cuối cùng là ký tự cuối cùng. Nếu từ viết tắt không ngắn hơn chuỗi gốc, hãy giữ nguyên chuỗi gốc.

However, if two words have the same abbreviation, we need to choose a longer prefix to differentiate them (increase prefix length until unique).
Tuy nhiên, nếu hai từ có cùng từ viết tắt, chúng ta cần chọn tiền tố dài hơn để phân biệt chúng (tăng độ dài tiền tố cho đến khi duy nhất).

## Constraints / Ràng buộc
- `1 <= words.length <= 400`
- `2 <= words[i].length <= 400`
- The words are unique.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Refinement / Tham lam với Tinh chỉnh
We can initially compute the shortest possible abbreviation (prefix length = 1) for everyone. Then, we resolve conflicts.

Algorithm:
1. Initialize result array with default abbreviations (prefix len = 1).
2. Use a loop to detect duplicates:
   - Group indices by their abbreviation string.
   - For any group with size > 1 (conflict):
     - Increment the prefix length for all words in that group.
     - Recompute abbreviations.
3. Repeat until no duplicates exist.
4. Final check: if abbreviation length >= original length - 2, use original string.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where N is number of words and L is max length. Conflicts reduce over time.
- **Space**: O(N * L) to store logical abbreviations.

---

## Analysis / Phân tích

### Approach: Iterative Conflict Resolution

**Algorithm**:
1.  Generate initial abbreviations.
2.  Identify conflict groups.
3.  Extend prefixes for conflicts.
4.  Re-generate and repeat until unique.

---
