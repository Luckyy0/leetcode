# 385. Mini Parser / Bộ Phân Tích Cú Pháp Mini

## Problem Description / Mô tả bài toán
Given a string `s` represents the serialization of a nested list, implement a parser to deserialize it and return the deserialized `NestedInteger`.
Cho một chuỗi `s` đại diện cho việc tuần tự hóa của danh sách lồng nhau, triển khai một bộ phân tích cú pháp để giải tuần tự hóa nó.

Each element is either an integer or a list whose elements may also be integers or other lists.

### Example 1:
```text
Input: s = "324"
Output: 324
Explanation: You should return a NestedInteger object which contains a single integer 324.
```

### Example 2:
```text
Input: s = "[123,[456,[789]]]"
Output: [123,[456,[789]]]
Explanation: Return a NestedInteger object containing a nested list with 2 elements:
1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 5 * 10^4`
- `s` consists of digits, square brackets `"[]"`, negative sign `'-'`, and commas `','`.
- `s` is the serialization of valid `NestedInteger`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Stack-Based Parsing / Phân Tích Dựa Trên Ngăn Xếp
We can use a Stack to track nested lists.
- `[` : Create new NestedInteger (list), push to stack.
- `]` : Pop from stack, add to parent (top of stack).
- `,` : Separator.
- Digits/`-` : Parse integer, add to current list (top of stack).

### Recursive Descent Parsing / Phân Tích Đệ Quy
Alternative: Recursive parsing using index tracking.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(D) stack depth (nesting depth).

---

## Analysis / Phân tích

### Approach: Stack

**Algorithm**:
1.  If `s[0] != '['`, it's a single integer. Return `NestedInteger(parseInt(s))`.
2.  Stack. `i = 0`.
3.  Loop while `i < len`:
    - If `'['`: Create new list NestedInteger, push.
    - If `']'`: Pop. If stack not empty, add to new top.
    - If digit or `-`: Parse number, add to top.
    - If `','`: skip.
4.  Return result.

---
