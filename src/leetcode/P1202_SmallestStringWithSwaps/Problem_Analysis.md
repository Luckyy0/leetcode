# 1202. Smallest String With Swaps / Chuỗi Nhỏ nhất Với Hoán đổi

## Problem Description / Mô tả bài toán
You are given a string `s`, and an array of pairs of indices `pairs`, where `pairs[i] = [a, b]` indicates swaps.
You can swap the characters at any pair of indices in `pairs` any number of times.
Return the lexicographically smallest string that `s` can be changed to.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union-Find (Disjoint Set Union) / Union-Find (Tập hợp Không Giao nhau)
Pairs define connectivity. If index `i` is connected to `j`, and `j` to `k`, then `i, j, k` form a connected component.
Within a component, characters can be freely rearranged.
So, for each component:
1. Collect all characters at these indices.
2. Sort characters.
3. Put them back into the indices in sorted order.

Algorithm:
1. Union-Find on indices `0..n-1`.
2. Group indices by root. `Map<Integer, List<Integer>>`.
3. For each group:
   - Collect chars.
   - Sort chars.
   - Sort indices (already sorted if iterated linearly, but map values might need care. Actually just iterate 0..n-1, find root, add to list. Lists will be sorted by index naturally).
   - Assign sorted chars to indices.

### Complexity / Độ phức tạp
- **Time**: O(N log N) (due to sorting chars in components). Union-Find is nearly O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Connected Components Sorting
Model the permissible swaps as edges in a graph where indices are nodes. Using Union-Find (or DFS/BFS), identify connected components of indices. Characters at indices belonging to the same component can be rearranged arbitrarily within those positions. To achieve the lexicographically smallest string, collect all characters within a component, sort them in ascending order, and place them back into the component's indices (sorted ascending).
Mô hình hóa các hoán đổi cho phép dưới dạng các cạnh trong đồ thị nơi các chỉ số là các nút. Sử dụng Union-Find (hoặc DFS/BFS), xác định các thành phần được kết nối của các chỉ số. Các ký tự tại các chỉ số thuộc cùng một thành phần có thể được sắp xếp lại tùy ý trong các vị trí đó. Để đạt được chuỗi nhỏ nhất theo thứ tự từ điển, hãy thu thập tất cả các ký tự trong một thành phần, sắp xếp chúng theo thứ tự tăng dần và đặt chúng trở lại các chỉ số của thành phần (được sắp xếp tăng dần).

---
