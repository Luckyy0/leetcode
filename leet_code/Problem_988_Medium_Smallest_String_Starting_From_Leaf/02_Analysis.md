# Analysis for Smallest String Starting From Leaf
# *Phân tích cho bài toán Chuỗi Nhỏ nhất Bắt đầu Từ Lá*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the lexicographically smallest path string from any leaf back to the root.
*Tìm chuỗi ký tự nhỏ nhất theo thứ tự từ điển, đọc từ bất kỳ lá nào ngược lên gốc.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Tree traversal (DFS) is required to explore all root-to-leaf paths.
- As we traverse down, we can prepend the current node's character to a string (or append to a `StringBuilder` and reverse it at the leaf).
- Prepending strings like `s = char + s` creates a lot of garbage and takes $O(L)$ time per node (where $L$ is path length), leading to $O(N \cdot L)$ worst case.
- A better way is using a fixed `StringBuilder`. Append character passing down. At a leaf node, temporarily `reverse()`, compare to the global `minString`, and `reverse()` back. Or just create a new string `new StringBuilder(sb).reverse().toString()` when a leaf is hit. Since leaf hits are fewer, this is efficient.
- `String minStr = "~"` (`~` is `(char) 126`, which is lexicographically greater than `'z'`).
- Update `minStr` when a leaf is hit if the newly reversed string is smaller.
*Dùng DFS truyền theo String, khi gặp nút lá thì đối chiếu với kết quả nhỏ nhất hiện tại. Sử dụng ghép chuỗi (string concatenation) hoặc `StringBuilder` sau đó lật ngược tại lá để so sánh.*

---

## 2. Strategy: DFS with Reversal
## *2. Chiến lược: DFS với Phép Lật ngược*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Global Minimum:** Initialize a global string variable `ans = "~"`.
    *   **Giá trị Nhỏ nhất Toàn cục:** Khởi tạo `ans = "~"` (ký tự lớn hơn 'z').*

2.  **DFS Traversal:** `dfs(TreeNode node, StringBuilder sb)`
    - Base case: `if (node == null) return;`
    - Append current character: `sb.append((char)('a' + node.val))`.
    - If `node` is a leaf (both left and right are null):
      - Create the path string: `String currentPath = new StringBuilder(sb).reverse().toString()`.
      - If `currentPath.compareTo(ans) < 0`, update `ans = currentPath`.
    - Else:
      - Recurse `dfs(node.left, sb)`.
      - Recurse `dfs(node.right, sb)`.
    - Backtrack: `sb.deleteCharAt(sb.length() - 1)`.
    *   **Duyệt DFS:** Ghép ký tự hiện tại. Khi đến lá, lật ngược chuỗi và so sánh.*

3.  **Return:** `ans`.
    *   **Trả về:** `ans`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    String ans = "~";
    
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }
    
    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        
        sb.append((char)('a' + node.val));
        
        if (node.left == null && node.right == null) {
            String path = new StringBuilder(sb).reverse().toString();
            if (path.compareTo(ans) < 0) {
                ans = path;
            }
        } else {
            dfs(node.left, sb);
            dfs(node.right, sb);
        }
        
        sb.deleteCharAt(sb.length() - 1);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$ in the worst case where $N$ is nodes and $L$ is the depth. The string reversing and comparison at the leaves takes $O(L)$ time for each path. In unbalanced trees, a lot of string creations might occur, however $N \le 8500$ ensures it runs extremely fast within TL constraints.
    *   **Độ phức tạp thời gian:** $O(N \cdot L)$.*
*   **Space Complexity:** $O(H)$ where $H$ is the height of the tree (for the recursion stack and `StringBuilder`).
    *   **Độ phức tạp không gian:** $O(H)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using `StringBuilder` during DFS with reverse on-the-fly at leaves is optimal in minimizing memory fragmentation.
*Sử dụng `StringBuilder` trong quá trình duyệt DFS với phép lộn ngược chuỗi ngay khi gặp lá là tối ưu giúp giảm thiểu phân mảnh bộ nhớ.*
