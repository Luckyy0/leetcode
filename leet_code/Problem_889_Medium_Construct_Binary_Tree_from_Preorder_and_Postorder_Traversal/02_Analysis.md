# Analysis for Construct Binary Tree from Preorder and Postorder Traversal
# *Phân tích cho bài toán Xây dựng Cây Nhị phân từ Duyệt Tiền thứ tự và Hậu thứ tự*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given `preorder` (Root -> Left -> Right) and `postorder` (Left -> Right -> Root) arrays, reconstruct the binary tree.
*Cho mảng `preorder` (Gốc -> Trái -> Phải) và `postorder` (Trái -> Phải -> Gốc), hãy xây dựng lại cây nhị phân.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The first element of `preorder` is always the **Root**.
- The second element of `preorder` (if it exists) is the **Root of the Left Subtree**.
- In `postorder`, the root of the left subtree appears just after all its descendants. By finding this value in `postorder`, we can determine the size of the left subtree.
*Phần tử đầu tiên của `preorder` luôn là **Gốc**. Phần tử thứ hai của `preorder` (nếu có) là **Gốc của Cây con Trái**. Trong `postorder`, gốc của cây con trái xuất hiện ngay sau tất cả các con cháu của nó. Bằng cách tìm giá trị này trong `postorder`, ta có thể xác định kích thước của cây con trái.*

---

## 2. Strategy: Recursive Divide & Conquer
## *2. Chiến lược: Chia để Trị Đệ quy*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Base Case:** If `preStart > preEnd`, return `null`. If `preStart == preEnd`, return a node with value `pre[preStart]`.
    *   **Trường hợp cơ sở:** Nếu chỉ số bắt đầu lớn hơn chỉ số kết thúc, trả về `null`. Nếu bằng nhau, trả về một nút lá.*

2.  **Identify Roots:**
    - `rootVal = pre[preStart]`.
    - `leftRootVal = pre[preStart + 1]`.
    *   **Xác định Gốc:** Gốc hiện tại là `pre[preStart]`, gốc con trái là `pre[preStart + 1]`.*

3.  **Find Partition:** Find the index of `leftRootVal` in `postorder`. Let this be `idx`.
    - Everything from `postStart` to `idx` in `postorder` belongs to the left subtree.
    - The size of the left subtree is `L = idx - postStart + 1`.
    *   **Tìm phân vùng:** Tìm chỉ số của `leftRootVal` trong `postorder` (gọi là `idx`). Mọi thứ từ `postStart` đến `idx` thuộc về cây con trái. Kích thước là `L`.*

4.  **Recurse:**
    - `root.left`: `build(preStart + 1, preStart + L, postStart, idx)`
    - `root.right`: `build(preStart + L + 1, preEnd, idx + 1, postEnd - 1)`
    *   **Đệ quy:** Xây dựng cây con trái và phải dựa trên các mảng con đã xác định.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    int n = preorder.length;
    Map<Integer, Integer> postMap = new HashMap<>();
    for (int i = 0; i < n; i++) postMap.put(postorder[i], i);
    
    return build(preorder, 0, n - 1, postorder, 0, n - 1, postMap);
}

private TreeNode build(int[] pre, int preStart, int preEnd, 
                       int[] post, int postStart, int postEnd, 
                       Map<Integer, Integer> postMap) {
    if (preStart > preEnd) return null;
    if (preStart == preEnd) return new TreeNode(pre[preStart]);
    
    int rootVal = pre[preStart];
    TreeNode root = new TreeNode(rootVal);
    
    int leftRootVal = pre[preStart + 1];
    int leftRootIndex = postMap.get(leftRootVal);
    int leftSize = leftRootIndex - postStart + 1;
    
    root.left = build(pre, preStart + 1, preStart + leftSize, 
                      post, postStart, leftRootIndex, postMap);
    root.right = build(pre, preStart + leftSize + 1, preEnd, 
                       post, leftRootIndex + 1, postEnd - 1, postMap);
                       
    return root;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We visit each node once.
    *   **Độ phức tạp thời gian:** $O(N)$, duyệt qua mỗi nút một lần.*
*   **Space Complexity:** $O(N)$ for the recursion stack and the HashMap.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a HashMap to store indices of the `postorder` array allows $O(1)$ lookup, making the recursive construction linear in time.
*Việc sử dụng HashMap để lưu chỉ số của mảng `postorder` cho phép tra cứu trong $O(1)$, giúp quá trình xây dựng đệ quy đạt độ phức tạp tuyến tính.*
