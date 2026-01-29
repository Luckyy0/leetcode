# 1061. Lexicographically Smallest Equivalent String / Chuỗi Tương đương Nhỏ nhất theo Thứ tự Từ điển

## Problem Description / Mô tả bài toán
You are given two strings of the same length `s1` and `s2` and a string `baseStr`.
Bạn được cho hai chuỗi có cùng độ dài `s1` và `s2` và một chuỗi `baseStr`.

We say `s1[i]` and `s2[i]` are equivalent characters.
Equivalence is transitive.
Chúng ta nói `s1[i]` và `s2[i]` là các ký tự tương đương. Sự tương đương có tính chất bắc cầu.
For example, if 'a' == 'b' and 'b' == 'c', then 'a' == 'c'.

Return the lexicographically smallest equivalent string of `baseStr` by transforming every character of `baseStr` to its equivalent character.
Trả về chuỗi tương đương nhỏ nhất theo thứ tự từ điển của `baseStr` bằng cách biến đổi mọi ký tự của `baseStr` thành ký tự tương đương của nó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union-Find (Disjoint Set Union) / Tìm-Hợp (Tập hợp Không Giao nhau)
We can group equivalent characters.
We want every character to map to the **smallest** character in its group.
Modified Union operation: always make the root the smaller character.
Or standard union, then find root, and map root to min characteristic which is root itself if we merge properly.

Algorithm:
1. Initialize DSU for 26 chars. `parent[i] = i`.
2. For each pair `(s1[i], s2[i])`:
   - `root1 = find(s1[i])`, `root2 = find(s2[i])`.
   - If `root1 != root2`:
     - If `root1 < root2`, `parent[root2] = root1`.
     - Else `parent[root1] = root2`.
3. For each char in `baseStr`:
   - Replace with `find(c)`.

### Complexity / Độ phức tạp
- **Time**: O(N + M), where N is length of s1, M is length of baseStr. Almost linear due to path compression.
- **Space**: O(1) (26 chars).

---

## Analysis / Phân tích

### Approach: Min-Root Union-Find
Model character equivalence as connected components using a Union-Find structure. Crucially, when merging two sets, always set the parent of the combined set to be the lexicographically smallest character. This ensures that a simple `find` operation returns the optimal replacement character.
Mô hình hóa sự tương đương của các ký tự như các thành phần liên thông bằng cách sử dụng cấu trúc Union-Find. Quan trọng là, khi hợp nhất hai tập hợp, luôn đặt cha của tập hợp kết hợp là ký tự nhỏ nhất theo thứ tự từ điển. Điều này đảm bảo rằng thao tác `find` đơn giản sẽ trả về ký tự thay thế tối ưu.

---
