# Analysis for All Possible Full Binary Trees
# *Phân tích cho bài toán Tất cả các Cây Nhị phân Đầy đủ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Generate all Full Binary Trees with exactly `N` nodes. A Full Binary Tree means every node has either 0 or 2 children.
*Tạo tất cả các Cây Nhị phân Đầy đủ với chính xác `N` nút. Cây Nhị phân Đầy đủ nghĩa là mọi nút có 0 hoặc 2 con.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A full binary tree must have an **odd** number of nodes. (Root = 1, Subtrees always add pairs of nodes). If `N` is even, return empty list.
- A tree with `N` nodes consists of a Root, a Left Subtree with `L` nodes, and a Right Subtree with `R` nodes.
- `L + R + 1 = N` or `L + R = N - 1`.
- Since left/right subtrees must also be full, `L` and `R` must be odd.
- We can iterate through all possible odd values for `L` (from 1 to `N-2`). Then `R = N - 1 - L`.
- Recursively generate all left subtrees and all right subtrees, then combine them.
*Một cây nhị phân đầy đủ phải có số lẻ nút. Nếu `N` chẵn, trả về danh sách rỗng. Một cây gồm Gốc, Cây con Trái `L` nút, Cây con Phải `R` nút. `L + R = N - 1`. `L` và `R` cũng phải là số lẻ. Chúng ta có thể duyệt qua tất cả giá trị lẻ của `L`, sau đó đệ quy tạo cây.*

---

## 2. Strategy: Recursion with Memoization
## *2. Chiến lược: Đệ quy có Nhớ (Memoization)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Memoization Map:** Use `Map<Integer, List<TreeNode>>` to store results for each `N`.
    *   **Bản đồ Ghi nhớ:** Sử dụng Map để lưu kết quả cho mỗi `N`.*

2.  **Base Case:**
    - If `N` is even, return empty list.
    - If `N == 1`, return a list containing a single node `[0]`.
    *   **Trường hợp cơ sở:** Nếu `N` chẵn, trả về rỗng. Nếu `N == 1`, trả về danh sách chứa một nút.*

3.  **Recursive Step:**
    - If `N` is in memo, return it.
    - Initialize `res` list.
    - For `leftSize` from 1 to `N-2` step 2:
        - `rightSize = N - 1 - leftSize`.
        - `leftTrees = allPossibleFBT(leftSize)`.
        - `rightTrees = allPossibleFBT(rightSize)`.
        - For each `l` in `leftTrees` and `r` in `rightTrees`:
            - Create new root. `root.left = l`. `root.right = r`.
            - Add `root` to `res`.
    - Put `res` in memo and return.
    *   **Bước Đệ quy:** Nếu `N` đã có trong memo, trả về. Duyệt `leftSize`. Lấy danh sách cây con trái và phải. Kết hợp từng cặp để tạo cây mới. Lưu vào memo.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
class Solution {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>(); // Even N impossible
        if (n == 1) {
            List<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }
        if (memo.containsKey(n)) return memo.get(n);
        
        List<TreeNode> res = new ArrayList<>();
        // Iterate through possible sizes for left subtree (must be odd)
        for (int i = 1; i < n; i += 2) {
            int leftSize = i;
            int rightSize = n - 1 - i;
            
            List<TreeNode> leftTrees = allPossibleFBT(leftSize);
            List<TreeNode> rightTrees = allPossibleFBT(rightSize);
            
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        
        memo.put(n, res);
        return res;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Roughly $O(2^N / \sqrt{N})$ (related to Catalan numbers). With N up to 20, it's small enough.
    *   **Độ phức tạp thời gian:** Liên quan đến số Catalan, đủ nhỏ với N=20.*
*   **Space Complexity:** $O(2^N / \sqrt{N})$ to store the trees.
    *   **Độ phức tạp không gian:** Để lưu trữ các cây.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This is a classic variation of generating Catalan structures. Correctly identifying the recursive structure (Root + Left Subtree + Right Subtree) and the odd-size constraint is key.
*Đây là một biến thể cổ điển của việc tạo cấu trúc Catalan. Việc xác định chính xác cấu trúc đệ quy (Gốc + Cây con Trái + Cây con Phải) và ràng buộc kích thước lẻ là chìa khóa.*
