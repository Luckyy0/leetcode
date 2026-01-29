# 394. Decode String / Giải Mã Chuỗi

## Problem Description / Mô tả bài toán
Given an encoded string, return its decoded string.
Cho một chuỗi đã được mã hóa, hãy trả về chuỗi đã giải mã.

The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer.
Quy tắc mã hóa là: `k[encoded_string]`, trong đó `encoded_string` bên trong dấu ngoặc vuông được lặp lại đúng `k` lần. Lưu ý rằng `k` được đảm bảo là một số nguyên dương.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, `k`. For example, there will not be input like `3a` or `2[4]`.
Bạn có thể giả định rằng chuỗi đầu vào luôn hợp lệ; không có khoảng trắng thừa, dấu ngoặc vuông được định dạng tốt, v.v. Ngoài ra, bạn có thể giả định rằng dữ liệu ban đầu không chứa bất kỳ chữ số nào và các chữ số chỉ dành cho các số lặp lại đó, `k`. Ví dụ: sẽ không có đầu vào như `3a` hoặc `2[4]`.

### Example 1:
```text
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
```

### Example 2:
```text
Input: s = "3[a2[c]]"
Output: "accaccacc"
```

### Example 3:
```text
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
```

## Constraints / Ràng buộc
- `1 <= s.length <= 30`
- `s` consists of lowercase English letters, digits, and square brackets `'[]'`.
- `s` is guaranteed to be a **valid** input.
- All the integers in `s` are in the range `[1, 300]`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Stack / Ngăn Xếp
We can use two stacks:
1.  `countStack`: to store the repeat numbers `k`.
2.  `stringStack`: to store the string segments formed so far before encountering `[` .

When encountering:
-   **Digit**: Parse the full number `k`.
-   **`[`**: Push `k` to `countStack` and current `res` string to `stringStack`. Reset `k` and `res`.
-   **`]`**: Pop `count` from `countStack`. Repeat current `res` string `count` times. Pop prefix from `stringStack` and append the repeated string.
-   **Character**: Append to current `res` string.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the decoded string.
- **Space**: O(N) for stacks.

---

## Analysis / Phân tích

### Approach: Two Stacks

**Algorithm**:
1.  `countStack`, `resStack`.
2.  `StringBuilder res = new StringBuilder()`.
3.  `int k = 0`.
4.  Iterate through string:
    - If `char` is digit: `k = k * 10 + (c - '0')`.
    - If `char` is `[`:
        - `countStack.push(k)`.
        - `resStack.push(res.toString())`.
        - `res = new StringBuilder()`.
        - `k = 0`.
    - If `char` is `]`:
        - `StringBuilder temp = new StringBuilder(resStack.pop())`.
        - `int repeatTimes = countStack.pop()`.
        - For `repeatTimes`: `temp.append(res)`.
        - `res = temp`.
    - Else: `res.append(c)`.
5.  Return `res.toString()`.

---
