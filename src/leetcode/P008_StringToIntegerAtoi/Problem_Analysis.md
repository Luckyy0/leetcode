# 8. String to Integer (atoi) / Chuyển Đổi Chuỗi Sang Số Nguyên

## Problem Description / Mô tả bài toán
Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function).
Thực hiện hàm `myAtoi(string s)`, chuyển đổi một chuỗi thành số nguyên 32-bit có dấu (tương tự như hàm `atoi` trong C/C++).

The algorithm for `myAtoi(string s)` is as follows:
Thuật toán cho `myAtoi(string s)` như sau:

1.  **Whitespace**: Read in and ignore any leading whitespace.
    **Khoảng trắng**: Đọc và bỏ qua bất kỳ khoảng trắng nào ở đầu.
2.  **Sign**: Check if the next character (if not already at the end of the string) is `'-'` or `'+'`. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    **Dấu**: Kiểm tra xem ký tự tiếp theo (nếu chưa đến cuối chuỗi) có phải là `'-'` hoặc `'+'` không. Đọc ký tự này nếu có. Điều này xác định kết quả cuối cùng là âm hay dương. Giả định kết quả là dương nếu không có dấu nào.
3.  **Conversion**: Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
    **Chuyển đổi**: Đọc các ký tự tiếp theo cho đến khi gặp ký tự không phải số hoặc hết chuỗi. Phần còn lại của chuỗi bị bỏ qua.
4.  **Clamping**: If the integer is out of the 32-bit signed integer range `[-2^31, 2^31 - 1]`, then clamp the integer so that it remains in the range. Specifically, integers less than `-2^31` should be clamped to `-2^31`, and integers greater than `2^31 - 1` should be clamped to `2^31 - 1`.
    **Kẹp giá trị**: Nếu số nguyên nằm ngoài phạm vi số nguyên 32-bit có dấu `[-2^31, 2^31 - 1]`, hãy kẹp số nguyên đó để nó nằm trong phạm vi. Cụ thể, các số nhỏ hơn `-2^31` sẽ được kẹp thành `-2^31`, và các số lớn hơn `2^31 - 1` sẽ được kẹp thành `2^31 - 1`.
5.  **Return**: Return the integer as the final result.
    **Trả về**: Trả về số nguyên làm kết quả cuối cùng.

### Example 1:
```text
Input: s = "42"
Output: 42
```

### Example 2:
```text
Input: s = "   -42"
Output: -42
```

### Example 3:
```text
Input: s = "4193 with words"
Output: 4193
```

## Constraints / Ràng buộc
- `0 <= s.length <= 200`
- `s` consists of English letters (lower-case and upper-case), digits (`0-9`), `' '`, `'+'`, `'-'`, and `'.'`.

---

## Analysis / Phân tích

### Approach: Linear Scan / Duyệt Tuyến Tính
- **Idea**: Simply follow the rules step-by-step.
- **Ý tưởng**: Chỉ cần tuân theo các quy tắc từng bước một.
    - Use an index `i` to traverse.
    - Skip spaces `while s[i] == ' '`.
    - Check sign `if s[i] == '+' or '-'`.
    - Loop digits `while Character.isDigit(s[i])`.
    - **Overflow Handling**: Similar to Problem 7 (Reverse Integer), we need to check for overflow *before* adding the new digit.
        - `result > MAX / 10` OR `result == MAX / 10 && digit > 7`.
- **Time Complexity**: O(n). We visit each character at most once.
- **Space Complexity**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Empty or Whitespace only**: "" or "   " -> 0.
2.  **Signs**: "+1", "-1".
3.  **Invalid Start**: "words and 987" -> 0.
4.  **Overflow**: "20000000000000000000" -> 2147483647.
5.  **Leading Zeros**: "   0000000000012345678" -> 12345678.
