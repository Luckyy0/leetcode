# 1170. Compare Strings by Frequency of the Smallest Character / So sánh Chuỗi theo Tần suất của Ký tự Nhỏ nhất

## Problem Description / Mô tả bài toán
Function `f(s)` calcs frequency of lexicographically smallest character in `s`.
Given arrays `queries` and `words`.
Return array `answer` where `answer[i]` is number of words `w` such that `f(queries[i]) < f(w)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Precomputation and Suffix Sums / Tính toán trước và Tổng Hậu tố
1. Compute `f(w)` for all words. Store in frequency array (counts of frequencies). Or sort frequencies.
   - Max possible frequency is 10 (string length constraint).
   - Actually min length is 1, max is 2000? Constraints: length up to 10? No, standard constraints usually larger.
   - Wait, leetcode constraints: `1 <= queries[i].length, words[i].length <= 10`. So max frequency is 10. `2000` is array length.
   - Frequencies are within [1, 10].
2. Use a count array `counts[12]`. `counts[x]` = number of words with freq `x`.
3. Compute suffix sums of `counts`. `suffix[x]` = number of words with freq `>= x`.
4. Actually current query needs `f(w) > f(query)`.
   - So `answer[i] = suffix[f(query) + 1]`.

### Complexity / Độ phức tạp
- **Time**: O(N*L + M*L). N words, M queries. Computing f is O(L).
- **Space**: O(1) (array size 12).

---

## Analysis / Phân tích

### Approach: Frequency Counting and Suffix Sums
Calculate the characteristic frequency `f(s)` for each word in `words` and `queries`. Since the maximum possible frequency is small (constrained by string length, e.g., 10), we can use a frequency bucket array (or just count occurrences). Create a suffix sum array where `suffix[i]` stores the number of words with frequency strictly greater than `i` (or `>= i` and adjust query). For each query `q`, compute `f(q)` and look up the answer in constant time using the suffix array.
Tính toán tần suất đặc trưng `f(s)` cho mỗi từ trong `words` và `queries`. Vì tần suất tối đa có thể nhỏ (bị giới hạn bởi độ dài chuỗi, ví dụ: 10), chúng ta có thể sử dụng mảng thùng tần suất (hoặc chỉ đếm số lần xuất hiện). Tạo mảng tổng hậu tố trong đó `suffix[i]` lưu trữ số lượng từ có tần suất lớn hơn hoàn toàn `i` (hoặc `>= i` và điều chỉnh truy vấn). Đối với mỗi truy vấn `q`, tính `f(q)` và tra cứu câu trả lời trong thời gian không đổi bằng cách sử dụng mảng hậu tố.

---
