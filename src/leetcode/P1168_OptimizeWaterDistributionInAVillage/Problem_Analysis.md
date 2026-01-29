# 1168. Optimize Water Distribution in a Village / Tối ưu hóa Phân phối Nước trong Làng

## Problem Description / Mô tả bài toán
There are `n` houses.
You can build a well in a house with `wells[i-1]` cost.
You can connect houses `i` and `j` with pipes with `pipes[k]` cost.
Find min cost to supply water to all houses (either via well or pipe connection to water).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Minimum Spanning Tree with Virtual Node / Cây Khung Nhỏ nhất với Nút Ảo
Add a virtual node 0 (The Aquifer / Water Source).
Construct edges from 0 to each house `i` with cost `wells[i-1]`.
Include existing pipe edges.
Find MST of this graph with `n+1` nodes.
 MST cost is the answer.

### Complexity / Độ phức tạp
- **Time**: O(E log E) or O(E log V).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: MST with Virtual Source
Model the problem as finding a Minimum Spanning Tree. Introduce a virtual node "0" representing the water source. Building a well at house `i` is equivalent to an edge between "0" and `i` with weight `wells[i]`. The pipe connections are standard weighted edges between houses. Run Kruskal's or Prim's algorithm on this augmented graph to find the minimum cost to connect to the "source" (cover all nodes).
Mô hình hóa bài toán như tìm Cây Khung Nhỏ nhất. Giới thiệu một nút ảo "0" đại diện cho nguồn nước. Xây dựng một cái giếng tại nhà `i` tương đương với một cạnh giữa "0" và `i` với trọng số `wells[i]`. Các kết nối đường ống là các cạnh có trọng số tiêu chuẩn giữa các ngôi nhà. Chạy thuật toán Kruskal hoặc Prim trên đồ thị tăng cường này để tìm chi phí tối thiểu để kết nối với "nguồn" (bao phủ tất cả các nút).

---
