# 776. Split BST / Chia Cây Tìm kiếm Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary search tree (BST) and a target value `target`, split the tree into two subtrees where one subtree forms all values that are `<= target`, and the other subtree contains all values that are `> target`.
Cho `root` của một cây tìm kiếm nhị phân (BST) và một giá trị `target`, hãy chia cây thành hai cây con trong đó một cây con chứa tất cả các giá trị `<= target` và cây con kia chứa tất cả các giá trị `> target`.

The resulting subtrees should still maintain the BST property.
Các cây con kết quả vẫn phải duy trì thuộc tính BST.

Return an array of the two roots of the resulting subtrees.
Trả về một mảng chứa hai gốc của các cây con kết quả.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Split / Chia đệ quy
In a BST:
- If `root.val <= target`:
  - The root and its entire left subtree must belong to the first subtree (`<= target`).
  - Some parts of its right subtree might also be `<= target`.
  - Recurse on `root.right`. The split of `root.right` gives `[smaller, larger]`.
  - Attach `smaller` as `root.right`.
  - Return `[root, larger]`.
- If `root.val > target`:
  - The root and its entire right subtree must belong to the second subtree (`> target`).
  - Recurse on `root.left`. The split of `root.left` gives `[smaller, larger]`.
  - Attach `larger` as `root.left`.
  - Return `[smaller, root]`.

### Complexity / Độ phức tạp
- **Time**: O(H) where H is the height of the tree.
- **Space**: O(H) recursion stack.

---

## Analysis / Phân tích

### Approach: Structural Reassignment
By leveraging the BST property, we only need to follow one path down the tree to perform the split. At each step, we decide which side of the current node needs further splitting.
Bằng cách tận dụng thuộc tính BST, chúng ta chỉ cần đi theo một đường xuống cây để thực hiện việc chia. Ở mỗi bước, chúng ta quyết định bên nào của nút hiện tại cần chia nhỏ hơn nữa.

---
