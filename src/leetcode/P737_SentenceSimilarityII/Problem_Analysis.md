# 737. Sentence Similarity II / Sự tương đồng của Câu II

## Problem Description / Mô tả bài toán
This is similar to Sentence Similarity I, but now similarity is **transitive**.
Bài toán này tương tự như Sự tương đồng của Câu I, nhưng bây giờ sự tương đồng có tính **bắc cầu**.

Two words `w1` and `w2` are similar if:
1. They are the same word.
2. `[w1, w2]` is in `similarPairs`.
3. `w1` is similar to `w3` and `w3` is similar to `w2`.

Return `true` if `sentence1` and `sentence2` are similar.
Trả về `true` nếu `sentence1` và `sentence2` tương đồng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union-Find (DSU) / Tìm kiếm Tập hợp rời nhau
Transitive similarity forms connected components in a graph.
Sự tương đồng bắc cầu tạo thành các thành phần được kết nối trong đồ thị.

Algorithm:
1. Use DSU to group all similar words into the same component.
2. For each pair of words `(w1, w2)` in the sentences:
   - Check if `find(w1) == find(w2)`.

### Complexity / Độ phức tạp
- **Time**: O(P * α(V) + N * α(V)) where P is number of pairs, V is number of unique words, and N is sentence length.
- **Space**: O(V).

---

## Analysis / Phân tích

### Approach: DSU on Words
Unlike part I, where we used a simple set, we now need a Union-Find structure to handle chains of similarity. Map each unique string to an ID for DSU processing.
Không giống như phần I mà chúng ta sử dụng tập hợp đơn giản, giờ đây chúng ta cần cấu trúc Union-Find để xử lý các chuỗi tương đồng. Ánh xạ từng chuỗi duy nhất với một ID để xử lý DSU.

---
