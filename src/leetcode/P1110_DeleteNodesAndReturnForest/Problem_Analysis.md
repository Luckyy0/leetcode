# 1110. Delete Nodes And Return Forest / Xóa Nút và Trả về Rừng

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in `to_delete`, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest. You may return the result in any order.
Cho `root` của một cây nhị phân, mỗi nút trong cây có một giá trị riêng biệt.
Sau khi xóa tất cả các nút có giá trị trong `to_delete`, chúng ta còn lại với một khu rừng (một hợp của các cây không giao nhau).
Trả về các gốc của các cây trong khu rừng còn lại. Bạn có thể trả về kết quả theo bất kỳ thứ tự nào.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Post-Order DFS / DFS Hậu tố
Traverse tree bottom-up or top-down logic.
Logic:
`process(node)`:
1. Recurse left and right. Update children pointers (they might become null if child deleted).
2. If `node.val` is in `to_delete`:
   - If `node.left` exists (and not deleted), add to result list.
   - If `node.right` exists, add to result list.
   - Return `null` to parent.
3. If `node.val` not in `to_delete`:
   - Return `node` to parent.

Root check: If root itself is not deleted, add it to result.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N + D), D is size of to_delete set.

---

## Analysis / Phân tích

### Approach: Recursive Decomposition
Perform a post-order traversal (or generally recursive processing). When processing a node, check if it needs to be deleted. If a node is deleted, its surviving children become new roots of disjoint trees, so add them to the result forest. If a node is not deleted, it remains attached to its parent. The main root is a special case (added if not deleted).
Thực hiện duyệt hậu tố (hoặc xử lý đệ quy nói chung). Khi xử lý một nút, hãy kiểm tra xem nó có cần bị xóa không. Nếu một nút bị xóa, những đứa trẻ còn sống của nó sẽ trở thành rễ mới của những cái cây rời rạc, vì vậy hãy thêm chúng vào khu rừng kết quả. Nếu một nút không bị xóa, nó vẫn gắn liền với cha mẹ của nó. Rễ chính là một trường hợp đặc biệt (được thêm nếu không bị xóa).

---
