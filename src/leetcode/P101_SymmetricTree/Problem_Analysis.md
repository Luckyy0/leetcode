# 101. Symmetric Tree / Cây Đối Xứng

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Cho `root` của một cây nhị phân, kiểm tra xem nó có phải là hình ảnh phản chiếu của chính nó hay không (tức là đối xứng quanh tâm của nó).

### Example 1:
```text
Input: root = [1,2,2,3,4,4,3]
Output: true
```

### Example 2:
```text
Input: root = [1,2,2,null,3,null,3]
Output: false
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 1000]`.
- `-100 <= Node.val <= 100`

**Follow up**: Could you solve it both recursively and iteratively?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Definition of Symmetric Tree / Định nghĩa Cây Đối Xứng
A tree is **symmetric** if and only if it is a **mirror image** of itself.
Một cây **đối xứng** nếu và chỉ nếu nó là **hình ảnh phản chiếu** của chính nó.

Mathematically, for a tree rooted at `r`:
Về mặt toán học, đối với một cây có gốc tại `r`:
- The left subtree of `r` must be a **mirror** of the right subtree of `r`.
- Cây con bên trái của `r` phải là **hình ảnh phản chiếu** của cây con bên phải của `r`.

### Mirror Property / Thuộc tính Phản chiếu
Two trees `T1` and `T2` are **mirrors** of each other if:
Hai cây `T1` và `T2` là **hình ảnh phản chiếu** của nhau nếu:
1.  Both are null (empty trees are mirrors).
    Cả hai đều là null (cây rỗng là hình ảnh phản chiếu).
2.  OR both are non-null AND:
    HOẶC cả hai đều không null VÀ:
    - `T1.root.val == T2.root.val`
    - `T1.left` is a mirror of `T2.right` (Cross comparison - left vs right)
    - `T1.right` is a mirror of `T2.left` (Cross comparison - right vs left)

**Key Insight / Điểm quan trọng**: 
- This is different from "Same Tree" where we compare `left with left` and `right with right`.
- For mirror/symmetry, we compare `left with right` and `right with left`.
- Điều này khác với "Cây Giống Nhau" nơi chúng ta so sánh `trái với trái` và `phải với phải`.
- Đối với phản chiếu/đối xứng, chúng ta so sánh `trái với phải` và `phải với trái`.

### Visual Representation / Biểu diễn trực quan
```
       1
      / \
     2   2     <- Values must match
    /\   /\
   3  4 4  3   <- Mirror: left-left(3) matches right-right(3)
                         left-right(4) matches right-left(4)
```

---

## Analysis / Phân tích

### Approach 1: Recursion / Đệ Quy
- **Algorithm**:
    ```
    isSymmetric(root):
        if root == null: return true
        return isMirror(root.left, root.right)
    
    isMirror(t1, t2):
        if t1 == null and t2 == null: return true
        if t1 == null or t2 == null: return false
        return t1.val == t2.val 
               AND isMirror(t1.left, t2.right) 
               AND isMirror(t1.right, t2.left)
    ```
- **Time Complexity**: O(N) - visit each node once.
- **Space Complexity**: O(H) - recursion stack, where H is tree height.

### Approach 2: Iteration with Queue / Lặp với Hàng đợi
- **Idea**: Use BFS-like approach. Enqueue pairs of nodes that should be mirrors.
- **Ý tưởng**: Sử dụng phương pháp giống BFS. Đưa vào hàng đợi các cặp nút cần là hình ảnh phản chiếu.
- **Algorithm**:
    ```
    queue.add(root.left, root.right)
    while queue not empty:
        t1, t2 = queue.poll()
        if t1 == null and t2 == null: continue
        if t1 == null or t2 == null: return false
        if t1.val != t2.val: return false
        queue.add(t1.left, t2.right)
        queue.add(t1.right, t2.left)
    return true
    ```
- **Time Complexity**: O(N).
- **Space Complexity**: O(N) for queue.

### Comparison / So sánh
| Aspect | Recursion | Iteration |
|--------|-----------|-----------|
| Space (best) | O(log N) balanced | O(N) |
| Space (worst) | O(N) skewed | O(N) |
| Readability | More intuitive | More explicit |
| Stack overflow risk | Yes for deep trees | No |

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree (null root)**: true (by convention).
2.  **Single node**: true.
3.  **Two nodes only**: `[1,2]` -> `left=2, right=null` -> false.
4.  **Same structure, different values**: false.
