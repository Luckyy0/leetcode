# 804. Unique Morse Code Words / Các Từ có Mã Morse Duy nhất

## Problem Description / Mô tả bài toán
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes.
Mã Morse quốc tế định nghĩa một mã hóa tiêu chuẩn trong đó mỗi chữ cái được ánh xạ tới một chuỗi các dấu chấm và dấu gạch ngang.

Given an array of strings `words` where each word can be written as a concatenation of the Morse code of each letter.
Cho một mảng các chuỗi `words` trong đó mỗi từ có thể được viết dưới dạng nối liền các mã Morse của từng chữ cái.

Return the number of different transformations among all words we have.
Trả về số lượng các phép biến đổi khác nhau trong số tất cả các từ chúng ta có.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap / HashSet for Uniqueness / HashMap / HashSet cho tính duy nhất
We can simply convert each word and store the result in a `HashSet`.
Chúng ta chỉ cần chuyển đổi từng từ và lưu trữ kết quả trong một `HashSet`.

Algorithm:
1. Define the Morse mapping for 'a'-'z'.
2. For each word:
   - Construct its Morse representation.
   - Add to `Set`.
3. Return `set.size()`.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where L is average word length.
- **Space**: O(N * L) to store the result strings.

---

## Analysis / Phân tích

### Approach: Linear Transformation
Standard transformation and deduplication.
Chuyển đổi tiêu chuẩn và loại bỏ trùng lặp.

---
