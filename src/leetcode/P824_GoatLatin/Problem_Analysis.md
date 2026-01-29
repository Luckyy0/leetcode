# 824. Goat Latin / Tiếng Latin Dê

## Problem Description / Mô tả bài toán
You are given a string `sentence` that consists of words separated by spaces. Each word consists of lowercase and uppercase letters only.
Bạn được cấp một chuỗi `sentence` bao gồm các từ được phân cách bằng dấu cách. Mỗi từ chỉ bao gồm các chữ cái thường và hoa.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin).
Chúng ta muốn chuyển đổi câu này sang "Tiếng Latin Dê" (một ngôn ngữ giả định tương tự như Tiếng Latin Lợn).

Rules for each word:
1. If word begins with a vowel (`a, e, i, o, u`), append `"ma"`.
2. If word begins with a consonant, move the first letter to the end and append `"ma"`.
3. Add as many `"a"` characters to the end as the 1-indexed word position.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Manipulation / Thao tác Chuỗi
Algorithm:
1. Split sentence into words.
2. For each word (at index `i`):
   - Check if first char is vowel.
   - Transform accordingly.
   - Append `i + 1` instances of 'a'.
3. Join words back with spaces.

### Complexity / Độ phức tạp
- **Time**: O(N + K^2) where N is sentence length and K is word count.
- **Space**: O(N + K^2) for the result builder.

---

## Analysis / Phân tích

### Approach: Word-by-Word Reconstruction
Simple procedural transformation following strictly defined rules. The number of 'a' characters grows quadratically with the total number of words.
Biến đổi mang tính thủ tục đơn giản tuân theo các quy tắc được định nghĩa nghiêm ngặt. Số lượng ký tự 'a' tăng theo cấp số nhân với tổng số từ.

---
