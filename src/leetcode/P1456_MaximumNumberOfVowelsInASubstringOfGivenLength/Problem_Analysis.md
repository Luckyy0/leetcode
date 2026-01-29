# 1456. Maximum Number of Vowels in a Substring of Given Length / Số lượng Nguyên âm Tối đa trong Chuỗi con có Độ dài đã cho

## Problem Description / Mô tả bài toán
String `s`. Integer `k`. Find max number of vowels in substring of length `k`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window
Window size `k`.
Count vowels in first `k`.
Slide window: Remove `s[i-k]`, Add `s[i]`. Update max.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Fixed Window
Initialize current vowel count for first `k` characters. `maxVowels`.
Iterate `i` from `k` to `n`.
If `s[i]` is vowel, `count++`.
If `s[i-k]` is vowel, `count--`.
`maxVowels = max(maxVowels, count)`.
Set: 'a', 'e', 'i', 'o', 'u'.
Khởi tạo số lượng nguyên âm hiện tại cho `k` ký tự đầu tiên. `maxVowels`.
Lặp `i` từ `k` đến `n`.
Nếu `s[i]` là nguyên âm, `count++`.
Nếu `s[i-k]` là nguyên âm, `count--`.
`maxVowels = max(maxVowels, count)`.

---
