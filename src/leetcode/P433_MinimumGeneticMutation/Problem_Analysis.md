# 433. Minimum Genetic Mutation / Đột Biến Gen Tối Thiểu

## Problem Description / Mô tả bài toán
A gene string can be represented by an 8-character long string, with choices from `'A'`, `'C'`, `'G'`, and `'T'`.
Một chuỗi gen có thể được biểu diễn bằng một chuỗi dài 8 ký tự, với các lựa chọn từ các ký tự `'A'`, `'C'`, `'G'`, và `'T'`.

Suppose we need to investigate a mutation from a gene string `start` to `end` where one mutation is defined as changing one character in the gene string. A gene must be in the `bank` to be valid.
Giả sử ta cần nghiên cứu một đột biến từ chuỗi gen `start` sang `end`, trong đó một lần đột biến được định nghĩa là thay đổi một ký tự trong chuỗi gen. Một gen phải nằm trong `bank` (ngân hàng gen) thì mới được coi là hợp lệ.

Given the two gene strings `start` and `end` and the gene bank `bank`, return the minimum number of mutations needed to mutate from `start` to `end`. If there is no such mutation, return `-1`.
Cho hai chuỗi gen `start`, `end` và ngân hàng gen `bank`, hãy trả về số lượng đột biến tối thiểu cần thiết để đột biến từ `start` sang `end`. Nếu không có đột biến nào như vậy, hãy trả về `-1`.

### Example 1:
```text
Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
```

### Example 2:
```text
Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2
```

## Constraints / Ràng buộc
- `start.length == 8`, `end.length == 8`
- `0 <= bank.length <= 10`
- `bank[i].length == 8`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Breadth-First Search (BFS) / Duyệt theo chiều rộng (BFS)
Finding the shortest path in an unweighted graph is a classic application for BFS. Here, each gene string is a node, and two nodes are connected if they differ by exactly one character and the target node is in the `bank`.

Algorithm:
1. Store the `bank` in a `HashSet` for O(1) lookup.
2. If `end` is not in the `bank`, return `-1`.
3. Use a `Queue` for BFS, starting with `start`.
4. Use a `Set` to track `visited` gene strings to avoid cycles and redundant work.
5. In each step of BFS:
   - For the current gene, try changing each of its 8 positions with one of the 4 characters (A, C, G, T).
   - If the resulting gene is equal to `end`, return the current mutation count.
   - If the resulting gene is in the `bank` and hasn't been visited, add it to the queue and mark it visited.
6. If the queue becomes empty and `end` is not reached, return `-1`.

### Complexity / Độ phức tạp
- **Time**: O(B * L * 4) where B is the size of the bank and L is the length of the gene (8). Since the set of characters is small (4) and length is fixed (8), this is efficient.
- **Space**: O(B) to store the bank and the visited set.

---

## Analysis / Phân tích

### Approach: Level-based BFS

**Algorithm**:
1.  Initialize Queue with `start`.
2.  Iterate level by level.
3.  Perform neighbor generation (8 positions * 4 chars).

---
