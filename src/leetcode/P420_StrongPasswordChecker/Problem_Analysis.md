# 420. Strong Password Checker / Kiểm Tra Mật Khẩu Mạnh

## Problem Description / Mô tả bài toán
A password is said to be strong if it satisfies all the following conditions:
Một mật khẩu được coi là mạnh nếu nó thỏa mãn tất cả các điều kiện sau:

1. It has at least `6` characters and at most `20` characters. (Độ dài từ 6 đến 20).
2. It contains at least one lowercase letter, at least one uppercase letter, and at least one digit. (Chứa ít nhất một chữ thường, một chữ hoa và một chữ số).
3. It does not contain three consecutive repeating characters (i.e., `"aaa"` is weak, but `"aaab"` is strong). (Không chứa ba ký tự giống nhau liên tiếp).

Given a string `password`, return the minimum number of steps required to make it strong. A step can be inserting one character, deleting one character, or replacing one character with another.
Cho một chuỗi `password`, hãy trả về số bước tối thiểu cần thiết để làm cho nó trở nên mạnh. Một bước có thể là chèn một ký tự, xóa một ký tự hoặc thay thế một ký tự.

### Example 1:
```text
Input: password = "a"
Output: 5
```

### Example 2:
```text
Input: password = "aA1"
Output: 3
```

## Constraints / Ràng buộc
- `1 <= password.length <= 50`
- `password` consists of letters, digits, and punctuation marks.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Case-Based Analysis / Phân tích Tham lam theo trường hợp
This problem involves three types of violations:
1. **Length Violation**: Too short or too long.
2. **Category Violation**: Missing lowercase, uppercase, or digit.
3. **Repeating Violation**: Consecutive characters of length $\ge 3$.

Greedy Logic:
- **Case 1: Length < 6**. Minimum steps = `max(6 - n, missing_types)`. Insertion handles both length and missing types.
- **Case 2: 6 <= Length <= 20**. Minimum steps = `max(replacements_to_fix_repeats, missing_types)`. Replacement handles both repeats and missing types.
- **Case 3: Length > 20**. We must delete `over = n - 20` characters. Deletion should be used strategically to reduce the number of replacements needed for repeating groups.
  - A repeating group of length `L` requires `L/3` replacements.
  - Deleting 1 char from a group of length `3k` reduces replacements by 1.
  - Deleting 2 chars from a group of length `3k+1` reduces replacements by 1.
  - Deleting 3 chars from a group of length `3k+2` reduces replacements by 1.

### Complexity / Độ phức tạp
- **Time**: O(N) to scan the password and identify repeating groups.
- **Space**: O(N) to store the lengths of repeating groups.

---

## Analysis / Phân tích

### Approach: Greedy Heuristic

**Algorithm**:
1.  Check missing categories.
2.  Identify repeating groups and their lengths.
3.  Apply logic for short, normal, and long passwords.
4.  For long passwords, allocate deletes to groups of length `3k`, then `3k+1`, then others.

---
