# 1255. Maximum Score Words Formed by Letters / Điểm Tối đa của các Từ được tạo bởi Chữ cái

## Problem Description / Mô tả bài toán
Given list of `words`, list of characters `letters`, and `score` of each character.
Form words using `letters` to maximize score. Each letter can only be used once.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / Bitmask DP
Constraints: `words` length <= 14. `letters` length <= 100.
Small number of words suggests exploring subsets.
Backtracking: Try including or excluding each word.
Check if current letter availability allows including word.
If yes, subtract letters, recurse, add score.
Restore letters after recursion.

### Complexity / Độ phức tạp
- **Time**: O(2^N * L) where N is words length (14), L is average word length. 2^14 is small.
- **Space**: O(N) stack.

---

## Analysis / Phân tích

### Approach: Backtracking
Use recursion to explore subsets of words. Maintain a frequency array of available letters. For each word (starting from index `i`), we have two choices: skip it, or include it (if sufficient letters are available). If we include it, calculate its score, deduct used letters, recurse for `i+1`, then backtrack (restore letters). The base case is when `i` reaches the end of the word list. Maximize the score.
Sử dụng đệ quy để khám phá các tập hợp con của các từ. Duy trì một mảng tần suất của các chữ cái có sẵn. Đối với mỗi từ (bắt đầu từ chỉ số `i`), chúng ta có hai lựa chọn: bỏ qua hoặc bao gồm nó (nếu có đủ các chữ cái). Nếu chúng ta bao gồm nó, hãy tính điểm của nó, trừ các chữ cái đã sử dụng, đệ quy cho `i+1`, sau đó quay lui (khôi phục các chữ cái). Trường hợp cơ sở là khi `i` đến cuối danh sách từ. Tối đa hóa điểm số.

---
