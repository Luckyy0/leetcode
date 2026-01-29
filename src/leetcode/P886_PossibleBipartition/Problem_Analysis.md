# 886. Possible Bipartition / Phân chia Lưỡng cực có thể

## Problem Description / Mô tả bài toán
We want to split a group of `n` people into two groups. Some people dislike each other and should not be in the same group.
Chúng ta muốn chia một nhóm gồm `n` người thành hai nhóm. Một số người không thích nhau và không nên ở cùng một nhóm.

Given `dislikes` where `dislikes[i] = [ai, bi]`, return `true` if it's possible to partition.
Cho `dislikes` trong đó `dislikes[i] = [ai, bi]`, trả về `true` nếu có thể phân chia được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bipartite Graph Checking / Kiểm tra Đồ thị Lưỡng phân
This is a standard problem of checking if a graph is bipartite (2-colorable).
Đây là bài toán tiêu chuẩn nhằm kiểm tra xem một đồ thị có phải là đồ thị lưỡng phân hay không (có thể tô bằng 2 màu).

Algorithm:
1. Build an adjacency list representing the dislikes.
2. Initialize an array `colors` (0: uncolored, 1: red, 2: blue).
3. For each uncolored node, perform DFS or BFS:
   - Assign color 1.
   - For all neighbors, assign color 2.
   - If a neighbor already has the same color as the current node, the graph is NOT bipartite.

### Complexity / Độ phức tạp
- **Time**: O(V + E).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: Conflict-free Coloring
Treat the dislike relationship as edges in a graph. By attempting to alternate colors between connected individuals, we verify if there are any "odd cycles" that would force a dislike pair into the same group.
Coi mối quan hệ không thích nhau là các cạnh trong đồ thị. Bằng cách cố gắng thay đổi màu sắc giữa các cá nhân được kết nối, chúng ta xác minh xem có bất kỳ "chu trình lẻ" nào hay không mà có thể buộc một cặp không thích nhau vào cùng một nhóm.

---
