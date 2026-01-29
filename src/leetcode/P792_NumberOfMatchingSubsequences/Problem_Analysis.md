# 792. Number of Matching Subsequences / Số lượng Chuỗi con Khớp

## Problem Description / Mô tả bài toán
Given a string `s` and an array of strings `words`, return the number of `words[i]` that is a subsequence of `s`.
Cho một chuỗi `s` và một mảng các chuỗi `words`, hãy trả về số lượng `words[i]` là chuỗi con của `s`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Efficient Subsequence Check / Kiểm tra Chuỗi con Hiệu quả
Checking each word against `s` individually using two pointers would take O(S * N) which might be too slow if `S` and `N` are large.
Việc kiểm tra từng từ so với `s` bằng hai con trỏ sẽ mất O(S * N), điều này có thể quá chậm nếu `S` và `N` lớn.

Optimization:
Instead of iterating through `s` for each word, iterate through `s` **once**.
Thay vì lặp qua `s` cho mỗi từ, hãy lặp qua `s` **một lần duy nhất**.

Algorithm:
1. Create 26 buckets, one for each starting character.
2. Place each word from `words` into the bucket corresponding to its first character.
3. For each character `c` in `s`:
   - Take all words in bucket `c`.
   - For each word, remove its first character. If the word becomes empty, increment the result. Otherwise, put it into the bucket corresponding to its *new* first character.

### Complexity / Độ phức tạp
- **Time**: O(S + Total_Chars_in_words).
- **Space**: O(Total_Words).

---

## Analysis / Phân tích

### Approach: Bucket-based Multi-Pointer tracking
By moving words between buckets based on their current "waiting" character, we effectively process all subsequences in parallel during a single pass of the main string.
Bằng cách di chuyển các từ giữa các thùng chứa dựa trên ký tự "đang chờ" hiện tại của chúng, chúng ta xử lý hiệu quả tất cả các chuỗi con song song trong một lần duyệt qua chuỗi chính.

---
