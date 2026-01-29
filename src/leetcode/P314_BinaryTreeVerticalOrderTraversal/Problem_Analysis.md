# 314. Binary Tree Vertical Order Traversal / Duyệt Cây Nhị Phân Theo Thứ Tự Dọc

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the **vertical order traversal** of its nodes' values. (i.e., from top to bottom, column by column).
Cho `root` của một cây nhị phân, trả về **duyệt thứ tự dọc** của các giá trị nút. (tức là từ trên xuống dưới, từng cột một).

If two nodes are in the same row and column, the order should be from **left to right**.
Nếu hai nút nằm cùng một hàng và cột, thứ tự phải là từ **trái sang phải**.

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: 9
Column 0: 3, 15
Column 1: 20
Column 2: 7
```

### Example 2:
```text
Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### BFS with Column Index / BFS với Chỉ Số Cột
- Use a `Queue` storing `(Node, Col)`. Start Root at Col 0.
- `Map<Col, List<Integer>>` to store values.
- Left child: `Col - 1`. Right child: `Col + 1`.
- Maintain `minCol` and `maxCol` to iterate map efficiently (or TreeMap, but TreeMap is O(N log N). BFS naturally processes layer by layer, preserving top-to-bottom order. Left-to-right order inside same row/col is preserved by BFS queue order (Left child pushed before Right child).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: BFS

**Algorithm**:
1.  Map `cols`. `min`, `max`.
2.  Queue `q`. Offer `(root, 0)`.
3.  While `q` not empty:
    - Poll. Add val to map.
    - Update range keys.
    - Offer left, right.
4.  Construct list from `min` to `max`.

---
