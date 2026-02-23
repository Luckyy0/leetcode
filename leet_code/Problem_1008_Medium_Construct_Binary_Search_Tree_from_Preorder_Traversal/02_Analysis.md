# Analysis for Construct Binary Search Tree from Preorder Traversal
# *Phân tích cho bài toán Xây dựng Cây tìm kiếm nhị phân từ Preorder*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given an array containing the preorder traversal of a Binary Search Tree (BST), reconstruct the original BST.
*Cho mảng duyệt theo thứ tự trước (preorder) của một Cây Tìm kiếm Nhị phân (BST), hãy tái tạo lại gốc của BST đó.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The first element of a preorder array `[root, left_subtree, right_subtree]` is ALWAYS the root of the (sub)tree.
- Because it is a *Binary Search Tree*, all elements in the `left_subtree` must be strictly less than the `root`, and all elements in the `right_subtree` must be strictly greater than the `root`.
- Thus, we can find the root and then partition the rest of the array into `left` values and `right` values, solving recursively.
*Phần tử đầu tiên của mảng Preorder luôn là Gốc. Vì là Cây Tìm Kiếm Nhị Phân, tất cả nhánh trái phải bé hơn gốc và nhánh phải lớn hơn gốc. Cách chia mảng này thành các đoạn đệ quy rất hiệu quả.*

---

## 2. Strategy 1: Naive (Recursive Split)
## *2. Chiến lược 1: Ngây thơ (Chia đệ quy)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive strategy is to insert each element one by one into the BST, starting from an empty root. Or, taking the first element as the root, finding the split index where elements become larger than the root, and recursively sending subarrays to left and right construct functions.
*Ý tưởng ngây thơ là chèn tuần tự từng phần tử như thao tác Insert thông thường của BST. Hoặc cầm phần tử đầu làm gốc, dò tìm (scan) chỉ số cắt chia đôi nửa bé nửa lớn, rồi đệ quy mảng.*

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    public TreeNode bstFromPreorderNaive(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return build(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) return null;
        
        TreeNode root = new TreeNode(preorder[start]);
        
        // Cần vòng lặp O(N) tìm điểm chia
        int i = start + 1;
        while (i <= end && preorder[i] < root.val) {
            i++;
        }
        
        root.left = build(preorder, start + 1, i - 1);
        root.right = build(preorder, i, end);
        return root;
    }
}
```

- **Weakness (Điểm yếu):** For each recursive call, we spend time iterating to find the split index (the right child). If the array is sorted (meaning the tree is a completely skewed list), finding the split takes $O(N)$ for every step, leading to an overall $O(N^2)$ time complexity.
  *Với mỗi hàm gọi đệ quy, ta mất công chạy vòng lặp đi tìm chỉ số chẻ nhánh phải. Lỡ như cây bị lệch hoàn toàn (mảng tăng dần), mỗi bước vòng lặp phải mò mẫm qua hết tất cả phần tử bên phải gây ra tình trạng thời gian vọt lên $O(N^2)$.*

---

## 3. Strategy 2: Optimal (Upper Bound Reference)
## *3. Chiến lược 2: Tối ưu (Dùng chặn trên)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

We can build the tree globally without any repetitive splitting by passing an `upper_bound` boundary to the recursive function. We maintain a global pointer/index `idx`. 
If `preorder[idx]` is smaller than the `upper_bound`, it belongs to the current subtree, so we create the node and advance the pointer. When recursively calling for the left child, the upper bound acts as the parent's value. For the right child, the upper bound is whatever the parent's upper bound was.
Because $1 \le preorder[i]$, we can start by setting an infinite bound. Each element gets visited exactly once, with zero redundant while loops.
*Thay vì quét chẻ bằng vòng lặp gắt, chỉ giữ độc một con trỏ Toàn cục (`index`). Bơm một giới hạn "chặn trên" mảng (`bound`). Nếu phần tử hiện hành đang còn thấp hơn chặn trên này, tức là nó vẫn thuộc về nhánh con, vậy thì găm Node vào và đun con trỏ tiến đi. Khi truyền đệ quy nhánh trái, chặn trên chính là giá trị Gốc vừa khởi tạo. Khi truyền nhánh phải, chặn trên là chặn trên từ gốc dội xuống. Chặn trên siêu hạng đánh sập độ trượt O(N^2) xuống thuần túy $O(N)$.*

### Step by Step:
1.  **Global state:** We use an array of size 1 `int[] i = {0}` or a class member `int i = 0` to track the current index in the `preorder` array.
2.  **Recursive Build:** `buildNode(preorder, bound)`
    - If `i == preorder.length` or `preorder[i] > bound`, return `null`. (It doesn't belong here).
    - Otherwise, create `root = new TreeNode(preorder[i++])`.
    - Recursively assign `root.left = buildNode(preorder, root.val)` because everything on the left must be strictly smaller than the root.
    - Recursively assign `root.right = buildNode(preorder, bound)` because everything on the right can be larger than the root but strictly smaller than the current inherited upper limit.
    - Return `root`.

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    int i = 0; // Global pointer
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildNode(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode buildNode(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = buildNode(preorder, root.val);
        root.right = buildNode(preorder, bound);
        
        return root;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. The global pointer `i` visits every single element in `preorder` exactly once. There are no loops internal to the recursion.
    *   **Độ phức tạp thời gian:** $O(N)$. Con trỏ toàn cục `i` cày nát mảng đúng một lần từ trước tới sau không quay đầu.*
*   **Space Complexity:** $O(N)$. The implicit recursive stack memory overhead. In the worst case (skewed tree), the depth of the recursion tree can be $N$. If the tree is balanced, it's $O(\log N)$.
    *   **Độ phức tạp không gian:** $O(N)$ do bộ nhớ chồng đệ quy giới hạn tối đa vươn tới số lượng nút N.*
