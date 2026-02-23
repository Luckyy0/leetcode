# Analysis for Serialize and Deserialize Binary Tree
# *Phân tích cho bài toán Tuần tự hóa và Giải tuần tự hóa Cây nhị phân*

## 1. Problem Essence & Preorder Traversal
## *1. Bản chất vấn đề & Duyệt Preorder*

### The Challenge
### *Thách thức*
Convert tree to string and back.
We need to handle `null` pointers explicitly to preserve structure uniquely.
Standard traversals (Inorder, Preorder, Postorder) are not unique unless we include nulls.

### Strategy: Preorder + Null Markers
### *Chiến lược: Preorder + Đánh dấu Null*
Format: `root,left,right`.
- If node is null, append "N".
- Else, append `value`.
Example: `[1,2,3]`.
Preorder: 1 -> 2 -> N -> N -> 3 -> N -> N.
String: `"1,2,N,N,3,N,N"`.

Why Preorder?
- Root is first.
- Easy to rebuild: First elem is root. Recursively build left, then right. The stream order matches the reconstruction order.

### Alternative: BFS (Level Order)
### *Thay thế: BFS (Thứ tự Tầng)*
Like LeetCode's input format `[1,2,3,null,null,4,5]`.
Works too, but requires a Queue and handling "trailing nulls" can be slightly tricky or verbose.
Recursive Preorder is cleaner code.

---

## 2. Approach: Recursive Preorder (DFS)
## *2. Hướng tiếp cận: Preorder Đệ quy (DFS)*

### Serialization
### *Tuần tự hóa*
`sb.append(root.val).append(",")`.
Recurse left.
Recurse right.
Helper function handles nulls first: `if root == null return "N,"`.

### Deserialization
### *Giải tuần tự hóa*
Split string by `,`. Use a Queue/List iterator.
Helper:
- `val = queue.poll()`.
- If `val == "N"`, return null.
- `node = new TreeNode(val)`.
- `node.left = helper()`.
- `node.right = helper()`.
- Return `node`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Self-Contained:** The structure is fully defined by the sequence of values and nulls.
    *Tự bao hàm: Cấu trúc được xác định đầy đủ bởi chuỗi giá trị và null.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ visit each node once.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for string/recursion.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 1 - (L:2, R:3)
Serialize:
- Visit 1. "1,"
- Left 2. "1,2,"
- Left 2->L (Null). "1,2,N,"
- Left 2->R (Null). "1,2,N,N,"
- Back to 1. Recurse Right 3. "1,2,N,N,3,"
- 3->L (N). "1,2,N,N,3,N,"
- 3->R (N). "1,2,N,N,3,N,N,".

Deserialize:
- Pop "1". Root 1.
- recurse left: Pop "2". Node 2.
    - recurse left: Pop "N". Return null.
    - recurse right: Pop "N". Return null.
    - 2 done.
- recurse right: Pop "3". Node 3.
    - recurse left: N.
    - recurse right: N.
- 1 done. Return tree.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Recursive Preorder is robust and easy to implement.
*Preorder Đệ quy mạnh mẽ và dễ cài đặt.*
---
*Việc lưu giữ (serialize) ký ức không chỉ là ghi lại những gì hiện hữu (nodes), mà còn phải ghi nhận cả những khoảng trống (nulls). Chỉ khi đó, ta mới có thể tái hiện (deserialize) quá khứ một cách trọn vẹn.*
Preserving (serializing) memories is not just recording what exists (nodes), but also acknowledging the voids (nulls). Only then can we fully reconstruct (deserialize) the past.
