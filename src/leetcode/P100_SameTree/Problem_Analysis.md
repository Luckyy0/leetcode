# 100. Same Tree / Cây Giống Nhau

## Problem Description / Mô tả bài toán
Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.
Cho roots của hai cây nhị phân `p` và `q`, viết một hàm để kiểm tra xem chúng có giống nhau hay không.

Two binary trees are considered **the same** if they are structurally identical, and the nodes have the same value.
Hai cây nhị phân được coi là **giống nhau** nếu chúng giống nhau về mặt cấu trúc và các nút có cùng giá trị.

### Example 1:
```text
Input: p = [1,2,3], q = [1,2,3]
Output: true
```

### Example 2:
```text
Input: p = [1,2], q = [1,null,2]
Output: false
```

### Example 3:
```text
Input: p = [1,2,1], q = [1,1,2]
Output: false
```

## Constraints / Ràng buộc
- The number of nodes in both trees is in the range `[0, 100]`.
- `-10^4 <= Node.val <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tree Equality Definition / Định nghĩa sự bằng nhau của cây
Two trees `T1` and `T2` are **identical** if and only if:
Hai cây `T1` và `T2` **giống nhau** nếu và chỉ nếu:
1.  Both roots are null (base case: both empty trees are equal).
    Cả hai gốc đều là null (trường hợp cơ sở: hai cây rỗng bằng nhau).
2.  OR both roots are non-null AND:
    HOẶC cả hai gốc đều không null VÀ:
    - `T1.root.val == T2.root.val`
    - `T1.left` is identical to `T2.left` (recursive)
    - `T1.right` is identical to `T2.right` (recursive)

### Recursion and Tree Structure / Đệ quy và Cấu trúc Cây
- Trees are **recursive data structures**: a tree is either empty or a root with two subtrees.
- Cây là **cấu trúc dữ liệu đệ quy**: một cây có thể rỗng hoặc là một gốc với hai cây con.
- This naturally lends itself to **recursive solutions**: solve the problem for subtrees, combine results.
- Điều này tự nhiên dẫn đến **giải pháp đệ quy**: giải quyết bài toán cho các cây con, kết hợp kết quả.

### Structural Induction / Quy nạp Cấu trúc
- **Base Case**: Empty trees are equal.
- **Inductive Step**: If subtrees are correctly compared, comparing roots and combining results gives correct answer.
- This is a form of **structural induction** on trees.

---

## Analysis / Phân tích

### Approach 1: Recursion / Đệ Quy
- **Algorithm**:
    ```
    isSameTree(p, q):
        if p == null and q == null: return true
        if p == null or q == null: return false
        if p.val != q.val: return false
        return isSameTree(p.left, q.left) AND isSameTree(p.right, q.right)
    ```
- **Time Complexity**: O(min(N, M)) where N, M are sizes of trees.
- **Space Complexity**: O(min(H1, H2)) for recursion stack.

### Approach 2: Iteration (BFS/DFS with Queue/Stack) / Lặp
- **Idea**: Use a queue/stack to compare nodes level by level or depth-first.
- Push pairs `(p, q)`. Pop and compare. Push children pairs.
- **Time Complexity**: O(min(N, M)).
- **Space Complexity**: O(min(N, M)) for queue/stack.

### Why Recursion is Elegant / Tại sao Đệ quy Thanh lịch
- The recursive solution **directly mirrors** the mathematical definition of tree equality.
- Code is concise, readable, and easy to prove correct.
- Giải pháp đệ quy **phản ánh trực tiếp** định nghĩa toán học của sự bằng nhau của cây.
- Code ngắn gọn, dễ đọc và dễ chứng minh đúng.

---

## Edge Cases / Các trường hợp biên
1.  **Both null**: true.
2.  **One null, one not**: false.
3.  **Same structure, different values**: false.
4.  **Different structure**: false.
