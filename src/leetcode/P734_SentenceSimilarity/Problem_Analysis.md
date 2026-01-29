# 734. Sentence Similarity / Sự tương đồng của Câu

## Problem Description / Mô tả bài toán
We can represent a sentence as an array of words. Two sentences `sentence1` and `sentence2` are similar if:
Chúng ta có thể biểu diễn một câu dưới dạng một mảng từ. Hai câu `sentence1` và `sentence2` là tương đương nếu:

1. They have the same length.
2. For each pair of words `(w1, w2)` at the same position, they are similar.

Similarity is defined by a list of pairs `similarPairs` where each pair `[u, v]` means `u` and `v` are similar. Similarity is **symmetric** but **not transitive**.
Sự tương đồng được định nghĩa bởi một danh sách các cặp `similarPairs` trong đó mỗi cặp `[u, v]` có nghĩa là `u` và `v` là tương tự. Sự tương đồng có tính **đối xứng** nhưng **không có tính bắc cầu**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap and HashSet / HashMap và HashSet
Store the similar pairs in a `Map<String, Set<String>>`.
Lưu trữ các cặp tương đồng trong một `Map<String, Set<String>>`.

Algorithm:
1. Check lengths first.
2. For each pair of words `w1, w2`:
   - Success if `w1 == w2`.
   - Success if `w1` is in `map[w2]` or `w2` is in `map[w1]`.

### Complexity / Độ phức tạp
- **Time**: O(N + P) where N is sentence length and P is number of pairs.
- **Space**: O(P).

---

## Analysis / Phân tích

### Approach: Pairwise Verification
Map each word to all its similar counterparts. Since it's not transitive, we don't need DSU.
Ánh xạ từng từ tới tất cả các từ tương đồng của nó. Vì không có tính bắc cầu, chúng ta không cần DSU.

---
