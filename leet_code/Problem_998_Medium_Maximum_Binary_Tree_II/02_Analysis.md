# Analysis for Maximum Binary Tree II
# *Phân tích cho bài toán Cây Nhị phân Lớn nhất II*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Append a value to the conceptually un-materialized array that generated a Maximum Binary Tree, and return the modified tree root.
*Nối một giá trị vào mảng gốc (mảng đã tạo ra Cây Nhị phân Lớn nhất) và trả về gốc của cây đã được sửa đổi.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We are simulating appending `val` to the end of array `A`. The array is not given.
- Because `val` is appended to the *end* of the array, it is geometrically located to the right of *every* existing element. Therefore, it will always be attached somewhere along the **rightmost path** of the tree.
- **Scenario A:** If `val > root.val`, the newly appended value is the largest in the entire array. It must become the new root. Since the entire old tree comes *before* `val` in the array, the old tree simply becomes the **left child** of the new root `val`.
- **Scenario B:** If `val < root.val`, the old root remains the root because it is still the largest. The new `val` is still appended to the array's right side, meaning it must be inserted into the **right subtree**. We simply recurse: `root.right = insertIntoMaxTree(root.right, val)`.
- If we reach a `null` node while recursing down the right side, we just create a new node with `val` and return it.
*Do `val` được nối vào cuối mảng, nó luôn nằm bên phải tất cả các nút. Nút mới sẽ luôn nằm trên nhánh phải cùng của cây. Nếu nó lớn hơn gốc hiện tại, nó thành gốc mới, cây cũ thành con trái. Nếu nhỏ hơn, tiếp tục đệ quy xuống con phải.*

---

## 2. Strategy: Right-Path Recursion
## *2. Chiến lược: Đệ quy theo Nhánh Phải*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Base Case:** If `root == null`, return `new TreeNode(val)`.
    *   **Trường hợp cơ sở:** Nếu nút rỗng, tạo nút mới.*

2.  **Compare Values:**
    - If `val > root.val`:
      - Create `newRoot = new TreeNode(val)`.
      - Set `newRoot.left = root`. (Because all elements of `root`'s array are to the left of `val`).
      - Return `newRoot`.
    - Else (if `val < root.val`):
      - We must append it to the right subtree.
      - Set `root.right = insertIntoMaxTree(root.right, val)`.
      - Return `root`.
    *   **So sánh:** Nút lớn hơn làm gốc mới (cây cũ làm con trái). Nút nhỏ hơn thì đệ quy xuống con phải.*

3.  **Return:** Returns the properly adjusted root node.
    *   **Trả về:** Gốc đã chỉnh sửa.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // Base case: Reached the bottom of the rightmost path
        if (root == null) {
            return new TreeNode(val);
        }
        
        // If the new value is greater than current root,
        // it becomes the new root, and the entire old tree becomes its left child.
        if (val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        // Otherwise, it must be inserted into the right subtree
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(H)$ where $H$ is the height of the rightmost path of the tree. In the worst case (a right-skewed tree), this is $O(N)$.
    *   **Độ phức tạp thời gian:** $O(H)$.*
*   **Space Complexity:** $O(H)$ for the recursion stack. Worst case $O(N)$.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Understanding the logical behavior of how trees are constructed from an array directly leads to this clean, sub-10 line recursive solution.
*Hiểu rõ hành vi logic của việc xây dựng cây từ mảng giúp đưa ra giải pháp đệ quy cực kỳ gọn gàng (dưới 10 dòng code).*
