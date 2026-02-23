# Analysis for Equal Tree Partition
# *Phân tích cho bài toán Chia Cây Thành Hai Phần Bằng nhau*

## 1. Problem Essence & Subtree Sum Target
## *1. Bản chất vấn đề & Mục tiêu Tổng Cây con*

### The Challenge
### *Thách thức*
We want to split a tree into two components with equal sums by removing a single edge. Removing an edge essentially detaches a subtree. Therefore, the problem is equivalent to: Is there a subtree whose sum is exactly half of the total tree sum?
*Chúng ta muốn chia một cây thành hai phần có tổng bằng nhau bằng cách loại bỏ một cạnh duy nhất. Việc loại bỏ một cạnh thực chất là tách một cây con. Do đó, bài toán tương đương với: Có cây con nào mà tổng của nó chính bằng một nửa tổng của cả cây hay không?*

---

## 2. Strategy: Post-order Traversal with Sum Storage
## *2. Chiến lược: Duyệt hậu thứ tự với Lưu trữ Tổng*

We can calculate the sum of every subtree recursively.
*Chúng ta có thể tính tổng của mọi cây con bằng cách đệ quy.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Calculate Total Sum:** Use a first pass or a combined pass to find the `TotalSum` of all nodes in the tree.
    * **Tính Tổng Tất cả:** Tìm `TotalSum` của tất cả các nút trong cây.*

2.  **Target:** The target sum for a detached subtree is `TotalSum / 2`. 
    * If `TotalSum` is odd, return `false` immediately.
    * **Mục tiêu:** Tổng mục tiêu cho một cây con bị tách ra là `TotalSum / 2`. Nếu `TotalSum` lẻ, trả về `false` ngay lập tức.*

3.  **Collect Subtree Sums:** Perform a post-order traversal to compute subtree sums. Store all subtree sums (except the total sum itself) in a map or set.
    * **Thu thập Tổng Cây con:** Thực hiện duyệt hậu thứ tự để tính tổng các cây con. Lưu trữ tất cả các tổng cây con (ngoại trừ tổng của chính nút gốc/cả cây) vào một tập hợp.*

4.  **Verification:** Check if the target exists in our collection of subtree sums.
    * **Xác minh:** Kiểm tra xem mục tiêu có tồn tại trong tập hợp các tổng cây con của chúng ta hay không.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Total Sum Constraint:** We must not count the `TotalSum` itself as a candidate for a partition, because partitioning requires removing an edge, which results in two *non-empty* trees. Detaching the "whole tree" is not allowed.
    * **Ràng buộc Tổng Tất cả:** Chúng ta không được tính `TotalSum` của chính nút gốc như một ứng cử viên cho việc chia tách, vì việc chia tách yêu cầu loại bỏ một cạnh, dẫn đến hai cây *không rỗng*. Không được phép "tách" toàn bộ cây.*
*   **Efficiency:** Post-order traversal ($O(N)$) is the natural way to compute sums from leaves up to the root.
    * **Hiệu suất:** Duyệt hậu thứ tự ($O(N)$) là cách tự nhiên để tính tổng từ lá lên gốc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We visit each node once and store sums in a hash-based structure.
    * **Độ phức tạp thời gian:** $O(N)$. Chúng ta ghé thăm mỗi nút một lần.*
*   **Space Complexity:** $O(N)$ to store the subtree sums in a stack (recursion) and a set/list.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [5, 10, 10, null, null, 2, 3]
1. `SubtreeSum(2)` = 2.
2. `SubtreeSum(3)` = 3.
3. `SubtreeSum(Right 10)` = 10 + 2 + 3 = 15.
4. `SubtreeSum(Left 10)` = 10.
5. `TotalSum` = 15 + 10 + 5 = 30.
6. Target = 30 / 2 = 15.
7. Does 15 exist in collected sums? Yes (from the right 10 subtree).
**Result:** true.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "partitioning" or "split" problems on trees, detachment of a subtree is the primary geometric transformation. Recording subtree properties during a post-order traversal allows you to answer "existence" questions related to these splits efficiently.
*Đối với các bài toán "chia tách" trên cây, việc tách một cây con là phép biến đổi hình học chính. Việc ghi lại các thuộc tính của cây con trong quá trình duyệt hậu thứ tự cho phép bạn trả lời các câu hỏi "tồn tại" liên quan đến các lần chia tách này một cách hiệu quả.*
---
*Sự cân bằng (Equal) trong một cấu trúc phức tạp (Tree) chỉ đạt được khi ta tìm thấy điểm đứt gãy hoàn hảo (Removing an edge). Khi một bộ phận (Subtree) mang trong mình trọng lượng bằng đúng một nửa tinh hoa của toàn thể (TotalSum / 2), sự tách rời sẽ tạo nên hai thế giới song hành và đồng điệu. Dữ liệu dạy ta rằng bằng cách lắng nghe tiếng nói từ những nhánh nhỏ nhất (Post-order), ta sẽ tìm thấy được chìa khóa để phân chia sự hỗn loạn thành hai thực thể cân bằng.*
Balance (Equal) in a complex structure (Tree) is only achieved when we find the perfect splitting point (Removing an edge). When a part (Subtree) carries a weight equal to exactly half of the soul of the whole (TotalSum / 2), the separation will create two parallel and harmonious worlds. Data teaches us that by listening to the voices from the smallest branches (Post-order), we will find the key to dividing chaos into two balanced entities.
