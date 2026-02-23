# Analysis for Binary Search Tree to Greater Sum Tree
# *Phân tích bài toán Đổi Cây Nhị Phân Tìm Kiếm Thành Cây Tổng Lớn Hơn*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given the `root` of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
*Cho `root` của một Cây Nhị Phân Tìm Kiếm (BST). Hãy chuyển đổi nó thành một Cây Tổng Lớn Hơn, sao cho mỗi khóa (giá trị nút) của BST ban đầu được cộng thêm CỘNG DỒN tổng của tất cả các khóa lớn hơn chính nó trong toàn bộ Cây.*

---

## 2. Strategy: Optimal (Reverse In-Order Traversal)
## *2. Chiến lược: Tối ưu (Duyệt Giữa Đảo Ngược Phát Tiến)*

### Logic and Rules
### *Lý luận và Quy tắc*

The defining property of a Binary Search Tree is that the left subtree contains smaller values, and the right subtree holds larger values. Because we want to add the sum of all "larger" elements to our current node, we must visit the nodes in descending order (Largest to Smallest).
*Tính chất cốt lõi của Cây Nhị Phân Tìm Kiếm là nhánh bên trái luôn nhỏ hơn nút Gốc, và nhánh bên phải luôn trĩu trịt quả To Hơn. Vì bài toán bắt cộng dồn toàn bộ những "anh lớn" vào mình, ta BẮT BUỘC phải đi nhặt tiền của từ Những Thằng To Xác Nhất (Max Vô Cực) lùi dần về tụi Lùn Tịt Còm Nhom (Min Lưỡi).*

A standard In-Order traversal (Left -> Root -> Right) visits nodes ascending. Therefore, a Reverse In-Order traversal (Right -> Root -> Left) perfectly processes elements in strict descending order.
*Cách Duyệt Giữa Cổ Điển `Trái -> Gốc -> Phải` mang lại mảng số Tăng Dần. Đảo ngược bánh xe lịch sử: Gọi lệnh Duyệt Giữa Nghịch Chiều `Phải -> Gốc -> Trái` thì thuật toán sẽ quét Cây theo chiều Giảm Dần! Không trượt một phát nào!*

1. Navigate as far Right as possible (Largest node).
2. Keep a running global `sum`. Add the current node's value to `sum`.
3. Update the node's value to the current `sum`.
4. Proceed to explore the Left child recursively.
*Chiến thuật:
1. Đâm sâu Đệ Quy Rẽ Phải tối đa đụng kịch vách lá. 
2. Duy trì một biến toàn cục (Hoặc Biến Mềm truyền Tham Chiếu) `sum` đang chứa Tích Lũy Kế Chóp Tiền Của. Cộng Xác Nút Đương Thể vào túi `sum`!
3. Nộp ngược số tiền `sum` Khổng lồ nát Bơm lại Thẳng Bụng cái Nút. Bây giờ Nút đã Căng To.
4. Lặn Lách xuống khám phá nhánh bên Trái để tiếp tục phát lộc từ túi `sum`.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    int runningSum = 0; // Biến tích lũy tài sản Nhặt trên Ngọn Cây

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            // Đổ nhánh Phải đớp Cục To Tiền Nhất 
            bstToGst(root.right);
            
            // Xó Nút Hiện Hành (Gốc): Nuốt Nút Đai Vào Quỹ Toàn Cục! Rồi Bơm Quỹ Thế Xác Vào Nút!
            runningSum += root.val;
            root.val = runningSum;
            
            // Lần mò xê dịch qua Nhánh Trái chia của còm cõi còn lại!
            bstToGst(root.left);
        }
        return root; // Kết thúc đệ quy, Cây đổi chủ Mới Toanh Lớn Xác
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the total number of nodes in the Binary Search Tree. Exactly one uniform recursive sweep mathematically touches each explicitly constructed structural node once flawlessly.
    *   **Độ phức tạp thời gian:** $O(N)$. Chúng ta sử dụng Thuật Đệ Quy Quét Giữa Đảo, đến một nút chính xác một lần duy nhất mà không băm nát đồ đạc, nên mất trọn $O(N)$ Bước.
*   **Space Complexity:** $O(H)$, where $H$ is the tree height natively allocating specifically the recursion function stack limits explicitly. This efficiently scales to $O(\log N)$ in optimally balanced strict shapes or drops heavily to $O(N)$ for badly skewed vertical lists.
    *   **Độ phức tạp không gian:** $O(H)$, với $H$ là chiều sâu trượt dọc từ Trần tháp xuống lòng đất. Túi Bộ nhớ Ngăn Xếp Tháp (Stack Recursion Limit) bị bòn rút. Cây cực đẹp cực tròn thì tốn $O(\log N)$ rất thưa vắng, nhưng nếu Cây đứt đuôi nòng nọc (Nghiêng Tuyến Tính) thì đùn trượt tới Nốc $O(N)$ RAM.
