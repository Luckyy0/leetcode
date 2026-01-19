# 249. Group Shifted Strings / Nhóm Các Chuỗi Dịch Chuyển

## Problem Description / Mô tả bài toán
We can shift a string by shifting each of its letters to its successive letter.
Chúng ta có thể dịch chuyển một chuỗi bằng cách dịch chuyển từng chữ cái của nó sang chữ cái kế tiếp.

- For example, `"abc"` can be shifted to be `"bcd"`.

We can keep shifting the string to form a sequence.
- For example, we can keep shifting `"abc"` to form the sequence: `"abc" -> "bcd" -> ... -> "xyz"`.

Given an array of strings `strings`, group all `strings[i]` that belong to the same shifting sequence. You may return the answer in **any order**.
Cho một mảng các chuỗi `strings`, hãy nhóm tất cả các `strings[i]` thuộc cùng một chuỗi dịch chuyển. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
```

### Example 2:
```text
Input: strings = ["a"]
Output: [["a"]]
```

## Constraints / Ràng buộc
- `1 <= strings.length <= 200`
- `1 <= strings[i].length <= 50`
- `strings[i]` consists of lowercase English letters.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Canonical Key Representation / Biểu Diễn Khóa Chính Tắc
To group shifted strings, we need a unique identifier (key) for each group.
Since shifting preserves the **relative distance** between characters modulo 26, we can use the sequence of differences (intervals) between adjacent characters as the key.
Or simpler: Normalize the string by shifting it such that the first character becomes 'a'.
- "bcd": Shift 'b' -> 'a' (minus 1). "bcd" -> "abc".
- "xyz": Shift 'x' -> 'a' (minus 23, or plus 3). "xyz" -> "abc".
- "az": Shift 'a' -> 'a'. "az" -> "az".
- "ba": Shift 'b' -> 'a'. "ba" -> "az". (b-1=a, a-1=z).

**Key Generation Strategy**:
For string `s`:
Calculate `offset = s[0] - 'a'`.
New characters `c' = (c - offset + 26) % 26 + 'a'`.
The resulting string is the key.

### Complexity / Độ phức tạp
- **Time**: O(N * K) where N is number of strings, K is max length.
- **Space**: O(N * K) to store map and keys.

---

## Analysis / Phân tích

### Approach: HashMap Grouping

**Algorithm**:
1.  Map `key -> List<String>`.
2.  For each string in input:
    - Generate key by shifting string so first char is 'a'.
    - Add original string to the list for that key.
3.  Return values of map.

---

## Edge Cases / Các trường hợp biên
1.  **Single char strings**: All map to "a". Group together.
2.  **Different lengths**: "abc" and "ab" cannot be same group. Key generation handles this naturally (different lengths).
