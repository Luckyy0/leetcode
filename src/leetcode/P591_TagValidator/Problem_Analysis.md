# 591. Tag Validator / Trình Xác Thực Thẻ

## Problem Description / Mô tả bài toán
Given a string representing a code snippet, you need to implement a tag validator to parse the code and return whether it is perfectly wrapped for each tag and all tags are well-formed.
Cho một chuỗi đại diện cho đoạn mã, bạn cần triển khai trình xác thực thẻ để phân tích mã và trả về xem nó có được bao bọc hoàn hảo cho mỗi thẻ hay không và tất cả các thẻ đều được định dạng tốt.

Tags rules (simplified):
1. Code must be wrapped in a **valid** CLOSED_TAG.
2. `<TAG_NAME>` is a start tag. `TAG_NAME` must be uppercase, length 1-9.
3. `</TAG_NAME>` is an end tag.
4. Tags must be balanced.
5. Content can be Text or CDATA.
6. CDATA: `<![CDATA[...]]>`. Content inside CDATA is ignored (treated as regular characters).

### Example 1:
```text
Input: code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
Output: true
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack-Based Parsing / Phân Tích Dựa Trên Ngăn Xếp
Iterate through the string index by index.
Use a Stack to keep track of open tags.
1. If start with `<![CDATA[`: Check if inside a tag (stack not empty). If stack empty, invalid (content must be wrapped). Consume CDATA.
2. If start with `</`: Parse End Tag. Check if matches top of stack. Pop.
3. If start with `<`: Parse Start Tag. Push to stack.
4. Else (Text): Check if inside a tag.

Boundary Check:
- Code must start with `<TAG>`.
- Code must end with `</TAG>`.
- After parsing the first valid closed tag pair (which must cover the whole string), the index must be at the end of string.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (Depth of nesting).

---

## Analysis / Phân tích

### Approach: Linear Scan with Stack

**Algorithm**:
1.  Parse character by character.
2.  Identify token types: Start Tag, End Tag, CDATA.
3.  Use Stack for tag balancing.
4.  Handle edge cases (CDATA outside tags, invalid tag names).

---
