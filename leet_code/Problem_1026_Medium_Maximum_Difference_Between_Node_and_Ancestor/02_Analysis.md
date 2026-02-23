# Analysis for Maximum Difference Between Node and Ancestor
# *Phân tích bài toán Độ Chênh lệch lớn nhất giữa Cha và Con cháu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*

In a directed vertical tree hierarchy, an "ancestor" is strictly anyone who geographically sits *above* a node along the direct descending lineage line.
*Trong Cây Phả Hệ Nhị Phân, "Tổ Tiên" được quy định là bất kỳ nút nào nằm phía trên so với nút "Con cháu" theo một đường nối trực hệ đi xuống.*
We must compute the absolute maximum mathematical difference `|Ancestor.val - Descendant.val|` among all structurally valid pairs traversing completely down vertically.
*Chúng ta phải tính độ chênh lệch tuyệt đối lớn nhất `|Ancestor.val - Descendant.val|` giữa tất cả các cặp hợp lệ trên các đường đi từ gốc xuống lá.*
Sibling splits don't count!
*Các nút anh em rẽ nhánh không được tính!*

---

## 2. Strategy 1: Naive (Nested DFS Every Node)
## *2. Chiến lược 1: Ngây thơ (Lồng Đệ quy xới từng Gốc)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea mechanically iterates through every single designated Node globally.
*Ý tưởng ngây thơ là duyệt qua từng nút cụ thể trên toàn bộ Cây.*
For each specific node treated as an "Ancestor", we launch a dedicated Depth-First Search (DFS) plunging physically deep to touch all its descendants manually calculating the diffs `|Ancestor.val - Child.val|`.
*Đối với mỗi nút được xem là "Tổ tiên", chúng ta khởi chạy một thuật toán Tìm Kiếm Theo Chiều Sâu (DFS) lặn sâu xuống để chạm tới tất cả con cháu của nó, tính toán thủ công độ chênh lệch `|Ancestor.val - Child.val|`.*
We continuously log and update the maximum diff encountered.
*Chúng ta liên tục ghi lại và cập nhật độ chênh lệch lớn nhất gặp phải.*

```java
public class Solution {
    int maxDifference = 0;
    
    public int maxAncestorDiffNaive(TreeNode root) {
        if (root == null) return 0;
        dfsFindChildren(root, root.val);
        // Quăng Đội tìm kiếm cho 2 Cánh phó
        maxAncestorDiffNaive(root.left);
        maxAncestorDiffNaive(root.right);
        return maxDifference;
    }
    
    // Đội DFS Lặn sục Chắt của Nút Gốc Truyền Kỳ
    private void dfsFindChildren(TreeNode node, int ancestorVal) {
        if (node == null) return;
        maxDifference = Math.max(maxDifference, Math.abs(ancestorVal - node.val));
        dfsFindChildren(node.left, ancestorVal);
        dfsFindChildren(node.right, ancestorVal);
    }
}
```

- **Weakness:** We do a full subtree scan strictly for *every* individual node independently. This creates massive heavy structural overlapping. A node deep down gets re-visited countless times by every single ancestor residing above it! For a linear skewed tree height ($H = N$), the time complexity exponentially falls apart into atrocious $O(N^2)$.
- ***Điểm yếu:** Chúng ta thực hiện quét toàn bộ cây con cho từng nút độc lập. Điều này tạo ra sự chồng chéo cấu trúc khổng lồ. Một nút nằm sâu bên dưới sẽ bị duyệt lại vô số lần bởi từng tổ tiên nằm phía trên nó! Đối với một cây nghiêng tuyến tính với chiều cao ($H = N$), độ phức tạp thời gian sẽ rớt thảm hại xuống $O(N^2)$.*

---

## 3. Strategy 2: Optimal (Top-Down Range Tracking)
## *3. Chiến lược 2: Tối ưu (Mang Theo Mốc Min/Max Lướt Từ Ngọn)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Why constantly look *downward* exhaustively testing every node when we can proactively **pass the records** *from the top down* elegantly?
*Tại sao cứ phải liên tục nhìn xuống kiểm tra từng nút một khi chúng ta có thể chủ động truyền các giá trị kỷ lục từ trên xuống dưới một cách thanh lịch?*
At any node geographically buried deeply in the tree, what dictates its ultimate maximum "Diff" evaluating against all ancestors collectively?
*Tại bất kỳ nút nào nằm sâu trong cây, điều gì định đoạt "Độ chênh lệch" tối đa của nó so với tất cả các tổ tiên?*
It's just the Absolute Difference comparing against either the **Absolute Maximum** ancestor or the **Absolute Minimum** ancestor currently witnessed along its specific direct path from the literal root!
*Đó chính là Độ chênh lệch tuyệt đối so với độ lớn của tổ tiên Lớn nhất hoặc Tổ tiên Nhỏ nhất trên đường đi trực tiếp của nó từ đỉnh gốc!*
We literally only need to pass exactly two simple integer scalars (`currentMax`, `currentMin`) plunging downward through the recursive stack path traversal call.
*Chúng ta thực sự chỉ cần truyền chuẩn xác 2 biến nguyên (`currentMax`, `currentMin`) đi dọc xuống qua mỗi cuộc gọi đệ quy.*
1. Compute the local leaf difference immediately: `max(abs(currentMax - node.val), abs(currentMin - node.val))`
*1. Tính độ lệch tại nút cục bộ ngay lập tức: `max(abs(currentMax - node.val), abs(currentMin - node.val))`*
2. Incorporate the new `node.val` into the pool: `currentMax = max(currentMax, node.val)` and `currentMin = min(currentMin, node.val)`.
*2. Đưa `node.val` mới vào nhóm kỷ lục: `currentMax = max(currentMax, node.val)` và `currentMin = min(currentMin, node.val)`.*
3. Unconditionally pass these newly refined bounds to strictly direct Left and Right children lines!
*3. Truyền vô điều kiện các giới hạn vừa tinh chỉnh này cho nhánh con Trái và Phải!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int maxAncestorDiff(TreeNode root) {
        // Mở cửa hầm Đệ quy: Chết dở chưa có kỉ lục thì gán gốc cho cả Min và Max
        return dfsFindDiff(root, root.val, root.val);
    }
    
    // Đổ bộ lướt thảm từ Trần nhà xuống Đất
    private int dfsFindDiff(TreeNode node, int currentMin, int currentMax) {
        // Rớt khỏi bản đồ Lục Địa -> Nứt Nhánh vô thực, Mức chênh mặc định ranh giới bù 0
        if (node == null) {
            // Đến đích Mút Tận Cùng thì lôi 2 kỉ lục Cương Quyết Lõm/Lồi ra trừ thẳng tính Điểm Tổng!
            return currentMax - currentMin;
        }
        
        // Cập nhật Cẩm nang Gia Phả mới chui xuống Trạm dưới cắp nách theo!
        currentMax = Math.max(currentMax, node.val);
        currentMin = Math.min(currentMin, node.val);
        
        // Khóa Chốt Kỷ lục con đường Mạch Trái và Mạch Phải
        int leftPathDiff = dfsFindDiff(node.left, currentMin, currentMax);
        int rightPathDiff = dfsFindDiff(node.right, currentMin, currentMax);
        
        // Giành Cúp Vô địch trên đỉnh chóp giao thoa
        return Math.max(leftPathDiff, rightPathDiff);
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes in the binary tree. We visit each node exactly once during our single Top-Down DFS traversal. Algebraic comparisons take $O(1)$ time per node.
*   *   **Độ phức tạp thời gian:** $O(N)$, với $N$ là số lượng nút trong cây nhị phân. Chúng ta ghé thăm mỗi nút đúng một lần trong chuyến duyệt DFS từ trên xuống. Các phép tính so sánh mất $O(1)$ thời gian ở mỗi nút.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the binary tree. This bound explicitly represents the theoretical maximum call stack size constrained by the maximum root-to-leaf depth. In worst-case highly skewed trees $H = N$, driving space to $O(N)$, but strictly efficiently $O(\log N)$ perfectly optimally for flawlessly balanced tree components.
*   *   **Độ phức tạp không gian:** $O(H)$, với $H$ là chiều cao của cây. Lượng bộ nhớ này thể hiện kích thước ngăn xếp gọi đệ quy tối đa bị ràng buộc bởi chiều sâu của cây. Trong trường hợp xấu nhất cây nghiêng vẹo trần trụi thì $H = N$, đẩy bộ nhớ lên $O(N)$, nhưng đạt mức $O(\log N)$ khi cây cân bằng hoàn hảo.*
