# 271. Encode and Decode Strings / Mã Hóa và Giải Mã Chuỗi

## Problem Description / Mô tả bài toán
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
Thiết kế một thuật toán để mã hóa một danh sách các chuỗi thành một chuỗi. Chuỗi đã mã hóa sau đó được gửi qua mạng và được giải mã trở lại thành danh sách chuỗi ban đầu.

Implement the `Codec` class:
- `String encode(List<String> strs)` Encodes a list of strings to a single string.
- `List<String> decode(String s)` Decodes a single string to a list of strings.

### Example 1:
```text
Input: ["Hello","World"]
Output: ["Hello","World"]
```

### Example 2:
```text
Input: [""]
Output: [""]
```

## Constraints / Ràng buộc
- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` contains any possible characters out of 256 valid ASCII characters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Length Prefixing / Tiền Tố Độ Dài
To handle any character (including delimiters like `,`, `#`, or newlines) inside the strings, we cannot simply join with a character.
Instead, we prefix each string with its **length** and a chosen **delimiter**.
Format: `length` + `#` + `content`.
Example: `["abc", "de"]` -> `3#abc2#de`.

Decoding:
1.  Read digits until `#`.
2.  Parse digits to get `len`.
3.  Read `len` characters.
4.  Repeat.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is total characters.
- **Space**: O(N) for string building.

---

## Analysis / Phân tích

### Approach: Chunked Encoding

**Algorithm**:
- **Encode**: Loop strings. Append `s.length()`, `#`, `s`.
- **Decode**:
    - Pointer `i = 0`.
    - Find next `#` at `slash`.
    - Length string = `s.substring(i, slash)`.
    - `len` = parse(Length string).
    - `content` = `s.substring(slash + 1, slash + 1 + len)`.
    - Add content to list.
    - `i = slash + 1 + len`.

---

## Edge Cases / Các trường hợp biên
1.  **Empty list**: Handle carefully (returns empty list object).
2.  **Strings with `#`**: Works because we read EXACTLY `len` chars.
3.  **Strings with digits**: Works.
