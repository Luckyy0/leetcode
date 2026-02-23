# Analysis for Merge Two Binary Trees
# *Phân tích cho bài toán Hợp nhất Hai Cây Nhị phân*

## 1. Problem Essence & Structural Overlay
## *1. Bản chất vấn đề & Sự Chồng lấp Cấu trúc*

### The Challenge
### *Thách thức*
We need to combine two binary trees. The rules are simple but must be applied recursively across all nodes.
*Chúng ta cần kết hợp hai cây nhị phân. Các quy tắc rất đơn giản nhưng phải được áp dụng đệ quy cho tất cả các nút.*

- If both nodes at a certain position are `null`, the merged result is `null`.
- *Nếu cả hai nút tại một vị trí nhất định đều là `null`, kết quả hợp nhất là `null`.*
- If only one is `null`, return the other as the merged subtree.
- *Nếu chỉ có một nút là `null`, hãy trả về nút kia làm cây con đã hợp nhất.*
- If both exist, sum their values and recurse for their children.
- *Nếu cả hai cùng tồn tại, hãy cộng giá trị của chúng lại và đệ quy cho các nút con.*

---

## 2. Strategy: Recursive DFS (Preorder)
## *2. Chiến lược: DFS Đệ quy (Tiền thứ tự)*

Recursion is the natural fit for tree problems. We solve for the `root` and then let the recursive calls handle the left and right subtrees.
*Đệ quy là sự lựa chọn tự nhiên cho các bài toán về cây. Chúng ta giải quyết cho nút `root` và sau đó để các lệnh gọi đệ quy xử lý các cây con bên trái và bên phải.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Base Case (One or both Null):**
    * **Trường hợp Base (Một hoặc cả hai Null):**
    - If `root1` is `null`, return `root2`. (Covers both being null if `root2` is also null).
    - If `root2` is `null`, return `root1`.
2.  **Merging Values:** Create a new node (or modify `root1` in-place) with the value `root1.val + root2.val`.
    * **Hợp nhất Giá trị:** Tạo một nút mới (hoặc sửa đổi `root1` trực tiếp) với giá trị `root1.val + root2.val`.*
3.  **Recursive Step:**
    * **Bước Đệ quy:**
    - NewNode.left = mergeTrees(root1.left, root2.left)
    - NewNode.right = mergeTrees(root1.right, root2.right)
4.  **Final Exit:** Return the merged node.
    * **Kết thúc:** Trả về nút đã hợp nhất.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **In-place vs New Tree:** Modifying `root1` in-place is more memory-efficient ($O(1)$ extra space excluding recursion), but creating a new tree is safer from a functional programming perspective (preserving original data).
    * **Tại chỗ so với Cây mới:** Sửa đổi `root1` trực tiếp sẽ hiệu quả hơn về bộ nhớ (không tốn thêm không gian $O(1)$ ngoài đệ quy), nhưng tạo một cây mới sẽ an toàn hơn từ góc độ lập trình hàm (bảo toàn dữ liệu gốc).*
*   **Pruning:** When one node is `null`, we return the entire other subtree. This is an efficient "pruning" mechanism as we don't need to traverse the children of that subtree further manually.
    * **Cắt tỉa:** Khi một nút là `null`, chúng ta trả về toàn bộ cây con còn lại. Đây là một cơ chế "cắt tỉa" hiệu quả vì chúng ta không cần phải duyệt qua các nút con của cây con đó theo cách thủ công nữa.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\min(N, M))$, where $N$ and $M$ are the number of nodes in the two trees. We only visit positions where both trees have nodes.
    * **Độ phức tạp thời gian:** $O(\min(N, M))$, trong đó $N$ và $M$ là số lượng nút trong hai cây. Chúng ta chỉ ghé thăm các vị trí mà cả hai cây đều có nút.*
*   **Space Complexity:** $O(\min(H_1, H_2))$ for the recursion stack, where $H$ is the height of the tree.
    * **Độ phức tạp không gian:** $O(\min(H_1, H_2))$ cho ngăn xếp đệ quy, trong đó $H$ là chiều cao của cây.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Tree 1:** [1,3,2] **Tree 2:** [2,1,3]
1. Root: both exist. New val = 1+2 = 3.
2. Left: both exist. New val = 3+1 = 4.
3. Right: both exist. New val = 2+3 = 5.
**Result:** [3,4,5].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For merging structure problems, identifying the base cases where one component exists but the other doesn't is critical. It allows for efficient subtree recycling and clear recursion flow.
*Đối với các bài toán hợp nhất cấu trúc, việc xác định các trường hợp cơ bản khi một thành phần tồn tại nhưng thành phần kia thì không là rất quan trọng. Nó cho phép tái chế cây con hiệu quả và luồng đệ quy rõ ràng.*
---
*Sự hòa hợp (Merging) là quá trình biến đổi hai thực thể riêng biệt thành một thể thống nhất trọn vẹn. Trong cấu trúc của cây (Tree), việc cộng hưởng giá trị (Summing values) thể hiện sức mạnh của sự kết hợp. Dữ liệu dạy ta rằng sự trọn vẹn (Completeness) không chỉ là phép cộng, mà là sự bù đắp cho những khoảng trống của nhau.*
Harmony (Merging) is the process of transforming two separate entities into a complete unified whole. In the structure of a tree (Tree), resonating values (Summing values) shows the power of combination. Data teaches us that wholeness (Completeness) is not just addition, but the filling of each other's gaps.
