# 1079. Letter Tile Possibilities / Khả năng của Ô Chữ cái

## Problem Description / Mô tả bài toán
You have `n`  `tiles`, where each tile has one letter `tiles[i]` printed on it.
Return the number of possible non-empty sequences of letters you can make using the letters printed on those `tiles`.
Bạn có `n` `tiles`, trong đó mỗi ô có một chữ cái `tiles[i]` được in trên đó.
Trả về số lượng chuỗi chữ cái không rỗng có thể có mà bạn có thể tạo ra bằng cách sử dụng các chữ cái được in trên các `tiles` đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / DFS / Quay lui / DFS
We need to form permutations of all subsets of the tiles.
Since duplicate letters exist, this is Permutations with Repetition allowed in input (Multiset Permutations).

Algorithm:
1. Count frequency of each character.
2. `dfs(counts)`:
   - Iterate through counts (A-Z).
   - If `count[i] > 0`:
     - Use one char `i` (decrement count).
     - Add 1 to global result (current sequence is valid).
     - Recursively call `dfs`.
     - Backtrack (increment count).

### Complexity / Độ phức tạp
- **Time**: O(N!), although much smaller because of limited depth (N <= 7).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive Composition with Pruning
Model element selection using a frequency map of available characters. Recursively build sequences by trying to append each available character type. Because identical characters are indistinguishable, iteration order over the frequency map (rather than positions) inherently handles duplicates and avoids redundant computations.
Mô hình hóa việc lựa chọn phần tử bằng cách sử dụng bản đồ tần suất của các ký tự có sẵn. Xây dựng các chuỗi một cách đệ quy bằng cách thử thêm từng loại ký tự có sẵn. Vì các ký tự giống hệt nhau là không thể phân biệt, thứ tự lặp qua bản đồ tần suất (thay vì vị trí) vốn dĩ xử lý các bản sao và tránh tính toán dư thừa.

---
