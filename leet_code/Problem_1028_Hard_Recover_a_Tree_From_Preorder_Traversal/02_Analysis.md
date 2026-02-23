# Analysis for Recover a Tree From Preorder Traversal
# *Phân tích bài toán Khôi phục Cây từ phép duyệt Tiền tố*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
In a Preorder traversal, we fundamentally process sequentially: `Root -> Left Child -> Right Child`. The input string perfectly mimics this sequential flow. The sole clue to explicitly determine whether the next encountered node is a child of the current node, or a sibling/cousin reverting back up the tree, strictly lies natively within its specific depth marker `D` (the exact number of dashes preceding it).
*Phép Duyệt Cây Tiền Tố (Preorder) đóng đinh theo chiều dọc: `Gốc Mẹ -> Nút Con Trái -> Nút Con Phải`. Chuỗi truyền nhân từ bài toán lột tả rành mạch lại nguyên bản chuyến đi rong ruổi đó. Manh mối độc đinh duy nhất để Biện minh xem Nút sắp nhú lên tiếp theo là Mụn Chồi Non (sâu thêm) hay LÀ nhánh Rẽ Xiên Ngang mọc chung Cụ Tổ mạn ngược rễ, LÀ DỰA VÀO ĐỘ SÂU `D` của nó (Tức là số Vạch Cạch Ngang ghim phía trước).*

---

## 2. Strategy 1: Naive (Recursive Substring Parsing)
## *2. Chiến lược 1: Ngây thơ (Cưa Cắt Chuỗi Phân Tích Đệ Quy)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea relies on heavily recursive functions extracting substrings manually. At current recursion height `D`, we manually scan the remaining string to hunt for the substring bearing precisely `D + 1` dashes. Once found, we furiously split the remaining string chunk in half and evaluate recursive structures manually down to leaves!
*Ý tưởng bốc đồng lao thẳng đầu vào Vách Đá Phân Rã Mảng (Substring Array). Tại độ sâu `D`, ta đục đẽo con mắt quét mù dọc xuống khúc ruột chuỗi còn lại để Trinh Sát tìm ĐÚNG cụm `D + 1` vạch! Thấy rồi, ta lôi rìu vọt tới cưa đôi làm Nhánh Trái, Nhánh Phải rồi nốc Đệ quy đè lên 2 khúc chuỗi mới toác đó.*

```java
public class Solution {
    public TreeNode recoverFromPreorderNaive(String traversal) {
        return buildTree(traversal, 0);
    }
    
    private TreeNode buildTree(String S, int depth) {
        if (S.isEmpty()) return null;
        
        int dashCount = 0;
        int i = 0;
        // ... (Parsing logic messy substring slicing)
        
        return null;
    }
}
```

- **Weakness:** Manually splitting sub-chunks forces exponential scanning operations, continually reproducing garbage `String` instances. Memory scales up catastrophically, triggering JVM Garbage Collection lag spikes and pulling algorithms into $O(N^2)$ heavily. 
- ***Điểm yếu:** Chiêu cưa khúc xé thịt Mảng quá Tốn Kém! Cắt vụn String khiến Heap mệt mỏi đẻ non rác rưởi Oject khổng lồ, ép xung bộ máy cào rác bốc khói! Tốc độ lề mề kéo thời gian xử lý đổ bục rơi xuống Vực Sâu $O(N^2)$ bế tắc kinh hoàng.*

---

## 3. Strategy 2: Optimal (Iterative Monotonic Deep Stack)
## *3. Chiến lược 2: Tối ưu (Trụ Gỗ Cắm Ngăn Xếp)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Why hack chunks when the Preorder perfectly maps structurally to a descending DFS Stack physical sequence? Let's just use an actual `Stack<TreeNode>` physically mimicking the exact ancestral path traversal! The Stack physically represents the current live lineage path dropping forcefully deep down identically towards the current processing node.
*Tại cớ sự vất vả chi mà phải xé màn băm thịt trong khi cái lộ tuyến Tiền Tố (Preorder) vốn NÓ ĐÃ MANG LINH HỒN CỦA MỘT CÁI NGĂN XẾP (STACK) CHÌM DẦN MỘT MẠCH rành rành ra đó? Khôn khéo dựng ngay một cái Ống Khói Ngăn Xếp `Stack<TreeNode>` mô phỏng nguyên y xì đúc cái Dây rốn Gia Phả Sống.*

**The Master Algorithm:**
*Thuật toán đỉnh cao:*
1. Parse the string character by character sequentially once.
*1. Duyệt vòng lặp kéo con trỏ trượt 1 nét qua mặt chữ.*
2. Count dashes `'-'` to effectively obtain the `depth` explicitly of the very immediate next upcoming node!
*2. Đếm Vạch Ngang `'-'` chễm chệ chấn giữ ranh giới: Số vạch ĐÚNG LÀ Độ Sâu Nước `depth`.*
3. Retrieve gracefully its value `val` explicitly. Create a fresh `TreeNode` instantly.
*3. Dòm lén con Số đằng sau vạch: Ép xác nó Phôi thai ngay một Nút Cây `TreeNode`!*
4. **Resolution Rule:** The size of our active stack essentially represents the current depth bound. If `stack.size() > depth`, our stack path mathematically ended its chronological run! We pop nodes shedding off obsolete lineage strictly until `stack.size() == depth`.
*4. **Chiếu Rọi Ngăn Xếp (Luật Sinh Tồn):** Số lượng nút trong Stack chính là Độ Sâu Lún Trục hiện hành. Thấy `stack.size() > depth` có nghĩa là Lộ tuyến Stack đã đi Lố Đáy, Đường hầm gãy khúc! Bỏ Mấy Nút rụng khỏi Đỉnh Ống Bằng `pop()` không thương tiếc, Cho Tới Khi `stack.size() == depth` MỚI THÔI. Nút lộ ra trên chỏm Stack MỚI CHÍNH LÀ Tổ Tiên!*
5. Link the recently spawned `node` gracefully to the top element of the stack `stack.peek()`. Attach to `.left` first, else correctly map to `.right`. Finally push the newborn exactly onto the stack seamlessly.
*5. Ghép xương Đứa con `node` vô thẳng người Mẹ Gốc `stack.peek()`. Mẹ rỗng nhánh `left` thì nhét nó làm con cưng nhánh Trái, lỡ Mẹ đẻ Trái rồi thì cưỡng ép nhét nốt gác con rơi vào nhánh `right`. Hoàn hảo.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.Stack;

public class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        int n = traversal.length();
        
        while (i < n) {
            int currentDepth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                currentDepth++;
                i++;
            }
            
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            
            TreeNode node = new TreeNode(val);
            
            while (stack.size() > currentDepth) {
                stack.pop(); 
            }
            
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek(); 
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            
            stack.push(node);
        }
        
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ rigorously natively constrained. The global loop glides a lone pointer identically matching elements exactly! Nodes are effectively pushed and popped perfectly minimally uniformly properly.
*   *   **Độ phức tạp thời gian:** $O(N)$ trôi rùng mình bão táp! Vòng lặp quét độc 1 Lần Duy Nhất xuyên dọc (Tránh TLE). Các nút bị nện vào `push()` và rớt `pop()` vỏn vẹn Độc 1 Lần. Trung bình chia ra là hằng số $O(1)$.*
*   **Space Complexity:** $O(H)$ firmly mathematically bounded strictly tracking tree height parameters directly allocating efficiently dynamically!
*   *   **Độ phức tạp không gian:** $O(H)$. Chỉ tốn vài chục viên đạn Gỗ vào Ngăn Xếp `Stack`. H là Chiều Cao Lớn Nhất của Tháp Nhị phân.*
