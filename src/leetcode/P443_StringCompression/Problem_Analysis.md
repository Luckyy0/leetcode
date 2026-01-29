# 443. String Compression / Nén Chuỗi

## Problem Description / Mô tả bài toán
Given an array of characters `chars`, compress it using the following algorithm:
Cho một mảng các ký tự `chars`, hãy nén nó bằng thuật toán sau:

Begin with an empty string `s`. For each group of **consecutive repeating characters** in `chars`:
- If the group's length is `1`, append the character to `s`.
- Otherwise, append the character followed by the group's length.

The compressed string `s` **should not be returned separately**, but instead, be stored **in the input character array `chars`**. Note that group lengths that are 10 or longer will be split into multiple characters in `chars`.
Chuỗi nén `s` không được trả về riêng lẻ, mà phải được lưu trữ ngay trong mảng ký tự đầu vào `chars`. Lưu ý rằng độ dài nhóm từ 10 trở lên sẽ được tách thành nhiều ký tự trong `chars`.

Return the new length of the array.
Trả về độ dài mới của mảng.

You must write an algorithm that uses only constant extra space.
Bạn phải viết một thuật toán chỉ sử dụng không gian bổ sung không đổi.

### Example 1:
```text
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
```

### Example 2:
```text
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
```

### Example 3:
```text
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"]
```

## Constraints / Ràng buộc
- `1 <= chars.length <= 2000`
- `chars[i]` is a lowercase English letter, uppercase English letter, digit, or symbol.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Hai con trỏ
We use one pointer `read` to iterate through the input and another pointer `write` to record the results in-place.

Algorithm:
1. Initialize `write = 0`, `read = 0`.
2. While `read < chars.length`:
   - Store the current character `char currentChar = chars[read]`.
   - Count the number of consecutive occurrences of `currentChar`: `count`.
   - Write `currentChar` to `chars[write++]`.
   - If `count > 1`:
     - Convert `count` to a string and write each digit to `chars[write++]`.
3. Return `write`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `chars`.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: In-place Writing with Two Pointers

**Algorithm**:
1.  Nested loop to find groups of same characters.
2.  Write character.
3.  Write digits of count if `count > 1`.
4.  Advance pointers.

---
