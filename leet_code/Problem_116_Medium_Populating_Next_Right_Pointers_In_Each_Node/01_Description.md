# Result for Populating Next Right Pointers in Each Node
# *Kết quả cho bài toán Điền Con Trỏ Bên Phải Tiếp Theo Trong Mỗi Nút*

## Description
## *Mô tả*

You are given a **perfect binary tree** where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
*Bạn được cho một **cây nhị phân hoàn hảo** trong đó tất cả các lá đều nằm trên cùng một tầng và mỗi nút cha có hai con. Cây nhị phân có định nghĩa như sau:*

```java
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.
*Hãy điền vào mỗi con trỏ `next` để trỏ đến nút bên phải tiếp theo của nó. Nếu không có nút bên phải tiếp theo, con trỏ `next` nên được đặt thành `NULL`.*

Initially, all next pointers are set to `NULL`.
*Ban đầu, tất cả các con trỏ `next` đều được đặt thành `NULL`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [1,2,3,4,5,6,7]`
**Output:** `[1,#,2,3,#,4,5,6,7,#]`
**Explanation:** Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = []`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 2^12 - 1]`.
*   `-1000 <= Node.val <= 1000`

## Follow up:
*   You may only use constant extra space.
*   The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
