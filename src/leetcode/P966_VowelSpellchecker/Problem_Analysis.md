# 966. Vowel Spellchecker / Trình kiểm tra Chính tả Nguyên âm

## Problem Description / Mô tả bài toán
Given a `wordlist`, create a spellchecker that processes `queries`.
Cho một `wordlist`, hãy tạo một trình kiểm tra chính tả xử lý các `queries`.

Matching rules (in priority order):
1. **Exact match**: Returns the word itself.
2. **Case-insensitive match**: Returns the first such word in `wordlist`.
3. **Vowel-insensitive match**: (treating 'a', 'e', 'i', 'o', 'u' as identical). Returns the first such word.

If no match, return "".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Multi-map or Multi-level Hashing / Đa bản đồ hoặc Hashing nhiều cấp
Algorithm:
1. `exactSet`: Store all original words.
2. `lowerMap`: Store `lowercase(word) -> word` (keep first occurrence).
3. `vowelMap`: Store `maskVowels(word) -> word` (mask: replace all vowels with '*').

For each query:
1. Check `exactSet`.
2. Check `lowerMap` with `lowercase(query)`.
3. Check `vowelMap` with `maskVowels(lowercase(query))`.

### Complexity / Độ phức tạp
- **Time**: O(Total chars in wordlist + Total chars in queries).
- **Space**: O(Total chars in wordlist).

---

## Analysis / Phân tích

### Approach: Hierarchical Pre-indexing
Organize the dictionary into three layers of specificity: literal, case-normalized, and vowel-anonymized. Querying through these pre-built hash maps in descending order of strictness allows for efficient and rule-compliant spelling correction.
Tổ chức từ điển thành ba lớp đặc thù: theo chữ cái, chuẩn hóa chữ hoa-chữ thường và ẩn danh nguyên âm. Việc truy vấn qua các bản đồ băm được tạo sẵn này theo thứ tự độ nghiêm ngặt giảm dần cho phép sửa lỗi chính tả hiệu quả và tuân thủ quy tắc.

---
