# 226. Invert Binary Tree / Đảo Ngược Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, invert the tree, and return its root.
Cho `root` của một cây nhị phân, hãy đảo ngược cây, và trả về root của nó.

(This problem was famously tweeted by Max Howell: "Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.")
(Bài toán này nổi tiếng qua dòng tweet của Max Howell: "Google: 90% kỹ sư của chúng tôi sử dụng phần mềm bạn viết (Homebrew), nhưng bạn không thể đảo ngược cây nhị phân trên bảng trắng nên hãy biến đi.")

### Example 1:
```text
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
```

### Example 2:
```text
Input: root = [2,1,3]
Output: [2,3,1]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Recursive Traversal / Duyệt Đệ quy
To invert a tree, for every node, we need to swap its left and right children.
We can do this recursively.
1.  Swap `left` and `right`.
2.  Recursively call invert on `left` (which was `right`).
3.  Recursively call invert on `right` (which was `left`).

**Pre-order or Post-order**:
Both work.
- Pre-order: Swap current, recurse left, recurse right.
- Post-order: Recurse left, recurse right, swap current.

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Complexity / Độ phức tạp**:
- **Time**: O(N) - Visit each node once.
- **Space**: O(H) - Stack depth (H is height).

---

## Edge Cases / Các trường hợp biên
1.  **Null root**: Return null.
2.  **Leaf node**: Returns itself.
3.  **Skewed tree**: Max depth recursion.
