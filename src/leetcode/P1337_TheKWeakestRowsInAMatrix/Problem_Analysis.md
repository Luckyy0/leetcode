# 1337. The K Weakest Rows in a Matrix / K Hàng Yếu nhất trong Ma trận

## Problem Description / Mô tả bài toán
Binary matrix `m x n`. 1s (soldiers) first, then 0s (civilians).
Weakest row: few soldiers. Tie-break: smaller index.
Find `k` weakest rows.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting / Priority Queue
Count soldiers in each row (linear scan or binary search since sorted).
Store `(count, index)`.
Sort or use Min-Heap.
Return top `k` indices.

### Complexity / Độ phức tạp
- **Time**: O(M log N + M log M) or O(M log N + M log K).
- **Space**: O(M).

---

## Analysis / Phân tích

### Approach: Count and Sort
Since rows are sorted (1s followed by 0s), use binary search to find the count of soldiers in each row (find index of first 0). Store pairs `(count, index)`. Sort these pairs based on count (ascending) and then index (ascending). Return the first `k` indices.
Vì các hàng được sắp xếp (1 theo sau 0), hãy sử dụng tìm kiếm nhị phân để tìm số lượng binh lính trong mỗi hàng (tìm chỉ số của số 0 đầu tiên). Lưu trữ các cặp `(count, index)`. Sắp xếp các cặp này dựa trên số lượng (tăng dần) và sau đó là chỉ số (tăng dần). Trả về `k` chỉ số đầu tiên.

---
