# 1048. Longest String Chain / Chuỗi Chuỗi Dài nhất

## Problem Description / Mô tả bài toán
You are given an array of `words`. Word A is a **predecessor** of word B if and only if we can insert exactly one letter anywhere in word A to make it equal to word B.
Bạn được cho một mảng các `words`. Từ A là **tiền thân** của từ B nếu và chỉ nếu chúng ta có thể chèn chính xác một chữ cái vào bất cứ đâu trong từ A để làm cho nó bằng từ B.

A **word chain** is a sequence of words `[word_1, word_2, ..., word_k]` where `word_1` is a predecessor of `word_2`, `word_2` is a predecessor of `word_3`, and so on.
Một **chuỗi từ** là một chuỗi các từ `[word_1, word_2, ..., word_k]` trong đó `word_1` là tiền thân của `word_2`, `word_2` là tiền thân của `word_3`, v.v.

Return the length of the longest possible word chain.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Sorting / Quy hoạch Động với Sắp xếp
1. Sort words by length.
2. `dp[word]` = max chain length ending at `word`.
3. For each word, try removing one character to form `prevWord`.
4. If `prevWord` exists in `dp`, `dp[word] = max(dp[word], dp[prevWord] + 1)`.
5. Else `dp[word] = max(dp[word], 1)`.

### Complexity / Độ phức tạp
- **Time**: O(N log N + N * L^2). Sorting takes N log N. Loop runs N times. Inside loop, we generate L strings of length L-1, string hashing/map takes O(L). So N * L * L.
- **Space**: O(N * L).

---

## Analysis / Phân tích

### Approach: Predecessor Map DP
Sort words by length to ensure proper processing order. For every word, analyze all potential predecessors (formed by removing one character). Use a hash map to look up the maximum chain length of these predecessors and extend the chain.
Sắp xếp các từ theo độ dài để đảm bảo thứ tự xử lý chính xác. Đối với mỗi từ, hãy phân tích tất cả các tiền thân tiềm năng (được hình thành bằng cách xóa một ký tự). Sử dụng bản đồ băm để tra cứu độ dài chuỗi tối đa của các tiền thân này và mở rộng chuỗi.

---
