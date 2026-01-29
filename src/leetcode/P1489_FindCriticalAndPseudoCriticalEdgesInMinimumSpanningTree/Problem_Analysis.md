# 1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree / Tìm Các Cạnh Quan trọng và Giả Quan trọng trong Cây Khung Nhỏ nhất

## Problem Description / Mô tả bài toán
Weighted undirected graph. Find critical edges (deleting increases MST weight) and pseudo-critical edges (can be in some MST but not all, or deleting doesn't increase weight but forcing usage keeps MST weight same).
Basically:
- Critical: Force remove -> MST weight increases or disconnected.
- Pseudo-Critical: Not critical AND Force include -> MST weight same.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Kruskal's Algorithm with Modifications
1. Calculate base MST weight.
2. For each edge `i`:
   - Check Critical: Build MST excluding `i`. If weight > base or disconnected, it's critical.
   - Check Pseudo-Critical: If not critical, check if including it yields same MST weight. Build MST starting with `i` included, then standard Kruskal. If weight == base, it's pseudo-critical.

### Complexity / Độ phức tạp
- **Time**: O(E^2 log E) or O(E^2). Since E=200? Wait, E <= 200? Problem constraints say n <= 100. E can be up to N^2. With E ~ 200, E^2 is small.
Actually constraints N <= 100. Edges <= min(200, n*(n-1)/2).
So E <= 200. This brute force is perfectly fine. `200 * 200 = 40000` ops.

---

## Analysis / Phân tích

### Approach: Brute Force MST Checks
Sort edges by weight. Keep original indices.
Compute `minMST`.
For each edge `i`:
1. Exclude `i`. Run Kruskal. If `weight > minMST` or unconnected, `i` is critical.
2. If not critical: Force include `i`. Run Kruskal (start with `i` connected). If `weight == minMST`, `i` is pseudo-critical.
Sắp xếp các cạnh theo trọng số. Giữ nguyên chỉ số ban đầu.
Tính `minMST`.
Đối với mỗi cạnh `i`:
1. Loại trừ `i`. Chạy Kruskal. Nếu `weight > minMST` hoặc không kết nối, `i` là quan trọng.
2. Nếu không quan trọng: Buộc bao gồm `i`. Chạy Kruskal (bắt đầu với `i` được kết nối). Nếu `weight == minMST`, `i` là giả quan trọng.

---
