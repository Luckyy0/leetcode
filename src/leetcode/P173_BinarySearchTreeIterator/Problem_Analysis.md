# 173. Binary Search Tree Iterator / Trình Duyệt Cây Tìm Kiếm Nhị Phân

## Problem Description / Mô tả bài toán
Implement the `BSTIterator` class that represents an iterator over the **in-order traversal** of a binary search tree (BST):
Hãy triển khai lớp `BSTIterator` đại diện cho một trình duyệt qua **phép duyệt trung tự (in-order traversal)** của một cây tìm kiếm nhị phân (BST):

- `BSTIterator(TreeNode root)` Initializes an object of the `BSTIterator` class. The `root` of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
- `boolean hasNext()` Returns `true` if there exists a number in the traversal to the right of the pointer, otherwise returns `false`.
- `int next()` Moves the pointer to the right, then returns the number at the pointer.

Notice that by initializing the pointer to a non-existent smallest number, the first call to `next()` will return the smallest element in the BST.
Lưu ý rằng bằng cách khởi tạo con trỏ tới một số nhỏ nhất không tồn tại, lệnh gọi đầu tiên đến `next()` sẽ trả về phần tử nhỏ nhất trong BST.

You may assume that `next()` calls will always be valid. That is, there will be at least a next number in the in-order traversal when `next()` is called.
Bạn có thể giả định rằng các lệnh gọi `next()` sẽ luôn hợp lệ. Nghĩa là, sẽ có ít nhất một số tiếp theo trong phép duyệt trung tự khi `next()` được gọi.

### Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 10^5]`.
- `0 <= Node.val <= 10^6`
- At most `10^5` calls will be made to `hasNext`, and `next`.

**Follow up**: Could you implement `next()` and `hasNext()` to run in average `O(1)` time and use `O(h)` memory, where `h` is the height of the tree?

---

## Theoretical Foundation / Cơ sở lý thuyết

### In-order Traversal / Duyệt Trung Tự (LNR)
In-order traversal of a BST visits nodes in non-decreasing order.
Phép duyệt trung tự của một BST truy cập các nút theo thứ tự không giảm.

### Iterative In-order using Stack / Duyệt Trung Tự bằng Vòng lặp sử dụng Ngăn xếp
Standard recursive in-order:
```
void inorder(node) {
    inorder(node.left);
    visit(node);
    inorder(node.right);
}
```
To implement an iterator, we need to pause the recursion. We use a **Stack** to simulate the recursion:
1.  From the current node, push all left children onto the stack until we reach the leftmost node.
2.  When `next()` is called:
    - Pop a node from the stack.
    - If the node has a right child, repeat step 1 starting from that right child.
    - Return the value of the popped node.

This satisfies the `O(H)` space constraint because the stack only stores nodes along a single path from root to leaf.

---

## Analysis / Phân tích

### Approach: Controlled Stack Simulation

**Algorithm**:
- **Constructor**: Call `pushLeft(root)`.
- **pushLeft(node)**: While `node != null`, push `node` to stack, `node = node.left`.
- **next()**:
    - `node = stack.pop()`.
    - If `node.right != null`, `pushLeft(node.right)`.
    - Return `node.val`.
- **hasNext()**:
    - Return `!stack.isEmpty()`.

### Complexity / Độ phức tạp
- **Time**: Average O(1) for `next()`. (Each node is pushed and popped exactly once across all calls).
- **Space**: O(H) - where H is the height of the tree.

---

## Edge Cases / Các trường hợp biên
1.  **Skewed Tree** (all left): Stack size will be O(N).
2.  **Skewed Tree** (all right): Stack size will be 1 at most.
3.  **Single Node**.
