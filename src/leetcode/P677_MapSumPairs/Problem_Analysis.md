# 677. Map Sum Pairs / Cặp Tổng Bản đồ

## Problem Description / Mô tả bài toán
Design a map that allows you to do the following:
- Maps a string key to a given value.
- Returns the sum of the values that have a key with a given prefix.

Implement the `MapSum` class:
- `void insert(String key, int val)`: Inserts the `key-val` pair into the map. If the `key` already existed, the original `key-val` pair will be overridden to the new one.
- `int sum(String prefix)`: Returns the sum of all the pairs' value whose `key` starts with the `prefix`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie / Cây Tiền tố (Trie)
A Trie is efficient for prefix searches.
Một Trie mang lại hiệu quả cho việc tìm kiếm tiền tố.

Each node in the Trie can store a `sum` value representing the total values of all keys passing through that node.
Mỗi nút trong Trie có thể lưu trữ một giá trị `sum` đại diện cho tổng giá trị của tất cả các khóa đi qua nút đó.

When inserting a key:
1. Find the difference between the new value and the old value (if any).
2. Update the `sum` of all nodes along the insertion path.

### Complexity / Độ phức tạp
- **Time**: `insert`: O(Length), `sum`: O(Length).
- **Space**: O(AlphabetSize * N * Length).

---

## Analysis / Phân tích

### Approach: Trie with Path Summing
Each Trie node stores the sum of all keys in its subtree. This allows the `sum` operation to run in time proportional to the prefix length rather than iterating through all words.
Mỗi nút Trie lưu trữ tổng của tất cả các khóa trong cây con của nó. Điều này cho phép thao tác `sum` chạy liên quan đến độ dài tiền tố thay vì lặp qua tất cả các từ.

---
