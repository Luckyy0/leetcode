# 1257. Smallest Common Region / Vùng Chung Nhỏ nhất

## Problem Description / Mô tả bài toán
Given list of `regions` where `regions[i][0]` is region and `regions[i][1...]` are sub-regions.
Given `region1`, `region2`. Find smallest common region containing both.
Input is basically parent-child relationships forming a tree (or forest, but problem implies one hierarchy).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### LCA (Lowest Common Ancestor) / Tổ tiên Chung Thấp nhất
Since we have parent pointers (can build `child -> parent` map from input), this is LCA in a tree with parent pointers.
Algorithm:
1. Build `parent` map. `Map<String, String>`.
2. Trace path from `region1` to root, store in Set.
3. Trace path from `region2` to root. First region found in Set is LCA.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Parent Map and Traversal
Since connections are given as `[Region, Sub1, Sub2...]`, we can easily build a `child -> parent` mapping. To find the Smallest Common Region (LCA), trace the ancestry path of `region1` up to the root and store all visited regions in a HashSet. Then, trace the ancestry path of `region2` upwards; the first region encountered that is already in the HashSet is the LCA.
Vì các kết nối được đưa ra dưới dạng `[Region, Sub1, Sub2...]`, chúng ta có thể dễ dàng xây dựng ánh xạ `con -> cha`. Để tìm Vùng Chung Nhỏ nhất (LCA), hãy theo dõi đường dẫn tổ tiên của `region1` lên gốc và lưu trữ tất cả các vùng đã truy cập trong HashSet. Sau đó, theo dõi đường dẫn tổ tiên của `region2` lên trên; vùng đầu tiên gặp phải đã có trong HashSet là LCA.

---
