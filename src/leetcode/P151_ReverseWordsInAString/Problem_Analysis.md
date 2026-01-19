# 151. Reverse Words in a String / Đảo Ngược Các Từ Trong Chuỗi

## Problem Description / Mô tả bài toán
Given an input string `s`, reverse the order of the **words**.
Cho một chuỗi đầu vào `s`, hãy đảo ngược thứ tự của các **từ**.

A **word** is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space.
Một **từ** được định nghĩa là một chuỗi các ký tự không phải khoảng trắng. Các từ trong `s` sẽ được phân tách bằng ít nhất một khoảng trắng.

Return a string of the words in reverse order concatenated by a single space.
Hãy trả về một chuỗi các từ theo thứ tự đảo ngược, được nối với nhau bằng một khoảng trắng duy nhất.

**Note** that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
**Lưu ý** rằng `s` có thể chứa các khoảng trắng ở đầu hoặc cuối hoặc nhiều khoảng trắng giữa hai từ. Chuỗi trả về chỉ nên có một khoảng trắng duy nhất phân tách các từ. Không bao gồm bất kỳ khoảng trắng thừa nào.

### Example 1:
```text
Input: s = "the sky is blue"
Output: "blue is sky the"
```

### Example 2:
```text
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
```

### Example 3:
```text
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
```

## Constraints / Ràng buộc
- `1 <= s.length <= 10^4`
- `s` contains English letters (upper-case and lower-case), digits, and spaces `' '`.
- There is **at least one** word in `s`.

**Follow-up**: If the string data type is mutable in your language, can you solve it **in-place** with `O(1)` extra space? (Note: In Java, Strings are immutable, so we usually use `char[]` or `StringBuilder`).

---

## Theoretical Foundation / Cơ sở lý thuyết

### String Manipulation / Thao tác Chuỗi
The problem requires three main transformations:
1.  **Trimming**: Remove leading and trailing spaces.
2.  **Splitting**: Break the string into individual words, ignoring extra spaces.
3.  **Reversing**: Reverse the order of the words.

### Approaches / Các Phương pháp

#### 1. Language Built-in Methods / Phương pháp sử dụng Hàm có sẵn
- Use `trim()` to handle padding.
- Use `split("\\s+")` (regex for "one or more spaces") to get words.
- Use `Collections.reverse()` or a custom loop to reverse the list.
- Use `String.join(" ", list)` to combine.

#### 2. Manual Two-Step Reversal / Phương pháp Đảo ngược Hai Bước (In-place style)
1.  **Reverse the entire string**: `"the sky" -> "yks eht"`.
2.  **Reverse each word**: `"yks eht" -> "sky the"`.
3.  Clean up spaces during or after the process.

---

## Analysis / Phân tích

### Approach: Splitting with Regex and Reversing

**Algorithm**:
1.  Trim the string.
2.  Split the string by spaces.
3.  Iterate through the array of words backwards.
4.  Join words that are not empty (if `split(" ")` was used) or just join all (if `split("\\s+")` was used).

### Complexity / Độ phức tạp
- **Time**: O(N) - single pass to split and reverse.
- **Space**: O(N) - to store the words and resulting string.

---

## Edge Cases / Các trường hợp biên
1.  **Single word**: No change (except trimming).
2.  **Multiple spaces between words**: Should be reduced to one.
3.  **Leading/Trailing spaces**: Should be removed.
