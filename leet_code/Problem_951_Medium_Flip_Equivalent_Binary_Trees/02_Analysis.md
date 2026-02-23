# Analysis for Flip Equivalent Binary Trees
# *Phân tích cho bài toán Cây Nhị phân Tương đương Lật*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Check if two trees are equivalent given we can swap left/right children at any node.
*Kiểm tra xem hai cây có tương đương nhau không nếu ta có thể hoán đổi con trái/phải tại bất kỳ nút nào.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Recursive problem structure.
- Two trees `node1` and `node2` are flip equivalent if:
  1. Both are null (True).
  2. One is null, other is not (False).
  3. Values are different (False).
  4. Values are same, AND:
     - (Left matches Left AND Right matches Right) OR
     - (Left matches Right AND Right matches Left) -> This represents the flip.
- Canonical Representation approach: Modified traversal where we always visit smaller child first. Then compare traversal strings. But recursion is simpler.
*Cấu trúc đệ quy. Hai cây tương đương nếu cả hai null, hoặc giá trị giống nhau và con cái khớp nhau (có thể đảo ngược).*

---

## 2. Strategy: Recursion
## *2. Chiến lược: Đệ quy*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Base Cases:**
    - If `root1 == root2`, return true. (Covers both null case).
    - If `root1 == null` or `root2 == null`, return false.
    - If `root1.val != root2.val`, return false.
    *   **Trường hợp cơ sở:** Kiểm tra null và giá trị.*

2.  **Recursive Step:**
    - Check No Flip: `flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right)`.
    - Check Flip: `flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left)`.
    - Return `noFlip || flip`.
    *   **Bước đệ quy:** Kiểm tra cả trường hợp không lật và có lật.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true; // Both null or same reference
        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
               (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\min(N1, N2))$. In worst case we explore all possibilities but actually we prune heavily because values must match. Since values are unique, each node is visited constant times.
    *   **Độ phức tạp thời gian:** $O(\min(N1, N2))$.*
*   **Space Complexity:** $O(H)$. Recursion stack.
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Recursive isomorphism check by trying both flip and no-flip conditions.
*Kiểm tra đẳng cấu đệ quy bằng cách thử cả điều kiện lật và không lật.*
