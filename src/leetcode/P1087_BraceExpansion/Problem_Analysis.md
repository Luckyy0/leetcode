# 1087. Brace Expansion / Mở rộng Dấu ngoặc nhọn

## Problem Description / Mô tả bài toán
You are given a string `s` representing a list of words. Each letter in the word has 1 or more options.
If there is one option, the letter is represented as is.
If there is more than one option, then curly braces delimit the options. For example, `{a,b,c}` represents options `a`, `b`, `c`.
For example, `{a,b}c{d,e}f` represents the list `["acdf", "acef", "bcdf", "bcef"]`.

Return all words that can be formed in this manner, in lexicographical order.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / Recursion / Quay lui / Đệ quy
Algorithm:
1. Parse the string into a List of Lists of Characters/Strings.
   - Iterate chars.
   - If `{`, read content until `}`, split by `,`, add group.
   - Else, add single char as a group of size 1.
2. Perform DFS to form combinations.
3. Collect results, sort them.

### Complexity / Độ phức tạp
- **Time**: O(N * 2^(N/K)). Output size.
- **Space**: O(Output).

---

## Analysis / Phân tích

### Approach: Recursive Expansion
Parse the input string into a sequence of option groups (where fixed characters are singleton groups). Use a recursive Backtracking method to generate all possible combinations by selecting one character from each group in order. Store the generated strings and sort them lexicographically for the final output.
Phân tích chuỗi đầu vào thành một chuỗi các nhóm tùy chọn (trong đó các ký tự cố định là các nhóm đơn). Sử dụng phương pháp Quay lui đệ quy để tạo tất cả các kết hợp có thể bằng cách chọn một ký tự từ mỗi nhóm theo thứ tự. Lưu trữ các chuỗi đã tạo và sắp xếp chúng theo thứ tự từ điển cho đầu ra cuối cùng.

---
