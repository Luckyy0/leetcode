# 884. Uncommon Words from Two Sentences / Các Từ Bất thường từ Hai Câu

## Problem Description / Mô tả bài toán
Find all words that appear exactly once in one of the sentences, and do not appear in the other sentence.
Tìm tất cả các từ chỉ xuất hiện đúng một lần trong một trong hai câu và không xuất hiện trong câu kia.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Hashmap / Hashmap Tần suất
Actually, the definition is equivalent to: a word is uncommon if it appears exactly once in the combined pool of words from both sentences.
Thực tế, định nghĩa này tương đương với: một từ là bất thường nếu nó xuất hiện đúng một lần trong tập hợp từ kết hợp của cả hai câu.

Algorithm:
1. Split both sentences into words.
2. Count the frequency of every word in both sentences combined using a `HashMap`.
3. Collect words with `count == 1`.

### Complexity / Độ phức tạp
- **Time**: O(N + M) where N, M are lengths of sentences.
- **Space**: O(N + M).

---

## Analysis / Phân tích

### Approach: Global Frequency Filtering
Treat both strings as a single corpus. A word is unique across both sources if and only if its global frequency count is exactly one.
Coi cả hai chuỗi là một ngữ liệu duy nhất. Một từ là duy nhất trên cả hai nguồn khi và chỉ khi số lượng tần suất toàn cầu của nó đúng bằng một.

---
