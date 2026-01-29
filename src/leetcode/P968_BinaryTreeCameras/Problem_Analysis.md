# 968. Binary Tree Cameras / Camera Cây Nhị phân

## Problem Description / Mô tả bài toán
You are given the `root` of a binary tree. We install cameras on the nodes of the tree.
Bạn được cho `root` của một cây nhị phân. Chúng ta lắp đặt máy ảnh trên các nút của cây.

Each camera at a node can monitor its parent, itself, and its immediate children.
Mỗi camera tại một nút có thể giám sát chính nó, nút cha và các nút con trực tiếp của nó.

Return the minimum number of cameras needed to monitor all nodes of the tree.
Hãy trả về số lượng camera tối thiểu cần thiết để giám sát tất cả các nút của cây.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Approach (Bottom-up) / Tiếp cận Tham lam (Từ dưới lên)
Algorithm:
Define three states for a node:
- 0: Node is NOT covered. (Cần được giám sát).
- 1: Node HAS a camera. (Có đặt camera).
- 2: Node IS covered by a camera. (Đã được giám sát).

Traversal logic:
1. Base case: `null` nodes are covered (Status 2).
2. If any child is NOT covered (Status 0):
   - We MUST place a camera here: `ans++`, return 1.
3. If any child has a camera (Status 1):
   - Current node is covered: return 2.
4. Otherwise (both children are covered):
   - Current node is not covered yet (Status 0), let parent handle it.

Special case: Root might still be status 0. If so, add one more camera.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Post-order Delegation
Use a bottom-up greedy strategy. By deferring camera placement to parents as much as possible, we maximize the monitoring range of each camera. A camera is only "forced" onto a node when one of its children remains unprotected.
Sử dụng chiến lược tham lam từ dưới lên. Bằng cách trì hoãn việc đặt camera lên các nút cha nhiều nhất có thể, chúng ta tối đa hóa phạm vi giám sát của mỗi camera. Một camera chỉ bị "ép" đặt vào một nút khi một trong các nút con của nó vẫn chưa được bảo vệ.

---
