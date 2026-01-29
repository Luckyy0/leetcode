# 428. Serialize and Deserialize N-ary Tree / Tuần Tự Hóa và Giải Tuần Tự Hóa Cây N-Phân

## Problem Description / Mô tả bài toán
Design an algorithm to serialize and deserialize an **N-ary tree**. An N-ary tree is a rooted tree in which each node has at most `N` children.
Hãy thiết kế một thuật toán để tuần tự hóa (serialize) và giải tuần tự hóa (deserialize) một **Cây N-phân**. Cây N-phân là một cây có gốc, trong đó mỗi nút có tối đa `N` nút con.

There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Không có hạn chế nào về cách hoạt động của thuật toán tuần tự hóa/giải tuần tự hóa của bạn. Bạn chỉ cần đảm bảo rằng một cây N-phân có thể được tuần tự hóa thành một chuỗi và chuỗi này có thể được giải tuần tự hóa về cấu trúc cây ban đầu.

### Example 1:
```text
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,null,3,2,4,null,5,6]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^4]`.
- `0 <= Node.val <= 10^4`
- The height of the N-ary tree is less than or equal to `1000`.
- Do not use class member/global/static variables to store states. Your encode/decode algorithms should be stateless.

---

## Theoretical Foundation / Cơ sở lý thuyết

### DFS with Child Count / DFS kèm theo số lượng nút con
A robust way to serialize an N-ary tree is to record the value of each node followed by the number of its children. This allows the deserializer to know exactly how many subsequent nodes belong to the current parent.

Algorithm:
- **Serialization**:
  1. Perform a preorder traversal (DFS).
  2. For each node, append its value and the size of its `children` list to the result string.
  3. Recursively serialize all children.
- **Deserialization**:
  1. Split the string into a list or queue of values.
  2. Read the next two values: `val` and `numChildren`.
  3. Create a new `Node(val)`.
  4. Loop `numChildren` times and recursively call the deserializer to create child nodes, adding them to the parent's `children` list.

### Complexity / Độ phức tạp
- **Time**: O(N) for both serialization and deserialization.
- **Space**: O(N) to store the result string/list, and O(H) recursion stack.

---

## Analysis / Phân tích

### Approach: Preorder Traversal (Val-Count Method)

**Algorithm**:
1.  Serialize: `node.val` + `,` + `node.children.size()` + `,` ...
2.  Deserialize: Queue-based recursive builder.

---
