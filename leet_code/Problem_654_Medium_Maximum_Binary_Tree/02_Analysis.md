# Analysis for Maximum Binary Tree
# *Phân tích cho bài toán Cây Nhị phân Lớn nhất*

## 1. Problem Essence & Divide and Conquer
## *1. Bản chất vấn đề & Chia để trị*

### The Challenge
### *Thách thức*
We need to build a binary tree where each node is the maximum value in its range, with its left and right children being constructed from the arrays to its left and right.
*Chúng ta cần xây dựng một cây nhị phân trong đó mỗi nút là giá trị lớn nhất trong phạm vi của nó, với các nút con bên trái và bên phải được xây dựng từ các mảng ở bên trái và bên phải của nó.*

This process is inherently recursive and follows a **Divide and Conquer** paradigm.
*Quá trình này về bản chất là đệ quy và tuân theo mô hình **Chia để trị**.*

---

## 2. Strategy: Recursive Construction
## *2. Chiến lược: Xây dựng Đệ quy*

We define a helper function `build(nums, left, right)` that constructs a tree from the subarray `nums[left...right]`.
*Chúng ta xác định một hàm phụ trợ `build(nums, left, right)` để xây dựng cây từ mảng con `nums[left...right]`.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Base Case:** If `left > right`, returning `null`.
    * **Trường hợp cơ sở:** Nếu `left > right`, trả về `null`.*

2.  **Find Maximum:** Scan the range `[left, right]` to find the index of the maximum element (`maxIdx`).
    * **Tìm cực đại:** Quét phạm vi `[left, right]` để tìm chỉ số của phần tử lớn nhất.*

3.  **Create Node:** Create a new `TreeNode` with `nums[maxIdx]`.
    * **Tạo Nút:** Tạo một `TreeNode` mới với giá trị tại `maxIdx`.*

4.  **Recurse:**
    * **Đệ quy:** *
    - Set the left child by calling `build(nums, left, maxIdx - 1)`.
    - Set the right child by calling `build(nums, maxIdx + 1, right)`.

5.  **Return:** The root of the constructed subtree.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Recursion Clarity:** The recursive approach directly mirrors the problem description, making it easy to implement and verify.
    * **Sự rõ ràng của đệ quy:** Cách tiếp cận đệ quy trực tiếp phản ánh mô tả bài toán, giúp dễ dàng triển khai và kiểm chứng.*
*   **Efficiency:** Finding the maximum in each range takes $O(N)$ in total across each level of the tree. In the worst case (skewed tree), this is $O(N^2)$. For a balanced tree, it is $O(N \log N)$.
    * **Hiệu suất:** Việc tìm cực đại trong mỗi phạm vi tốn $O(N)$. Trong trường hợp xấu nhất, độ phức tạp là $O(N^2)$. Với cây cân bằng, nó là $O(N \log N)$.*
*   **Monotonic Stack Alternative:** For $O(N)$ performance, one could use a monotonic stack to build the tree in a single pass. However, for $N \le 1000$, $O(N^2)$ is perfectly acceptable.
    * **Giải pháp Ngăn xếp đơn điệu:** Để đạt hiệu suất $O(N)$, ta có thể dùng ngăn xếp đơn điệu. Tuy nhiên với $N \le 1000$, $O(N^2)$ là hoàn toàn chấp nhận được.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$ in the worst case (already sorted array); $O(N \log N)$ in the average case.
    * **Độ phức tạp thời gian:** $O(N^2)$ trong trường hợp xấu nhất; $O(N \log N)$ trong trường hợp trung bình.*
*   **Space Complexity:** $O(N)$ for the recursion stack in the worst case.
    * **Độ phức tạp không gian:** $O(N)$ cho ngăn xếp đệ quy.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [3, 2, 1, 6, 0, 5]
1. Find max in [3, 2, 1, 6, 0, 5] -> 6 at index 3. Root = 6.
2. Left of 6: [3, 2, 1]. Max = 3 at index 0. 6.left = 3.
3. Right of 6: [0, 5]. Max = 5 at index 5. 6.right = 5.
4. Left of 3: []. null.
5. Right of 3: [2, 1]. Max = 2 at index 1. 3.right = 2.
... and so on.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The "Maximum Tree" pattern is common in problems requiring hierarchical representation based on magnitude. For small constraints, recursion is king. For large constraints ($N > 10^5$), always transition to a Monotonic Stack to maintain linear performance.
*Mô hình "Cây cực đại" phổ biến trong các bài toán yêu cầu biểu diễn phân cấp dựa trên độ lớn. Với ràng buộc nhỏ, đệ quy là số một. Với ràng buộc lớn, hãy chuyển sang Ngăn xếp đơn điệu.*
---
*Đỉnh cao (Maximum) xác định vị thế. Trong dòng chảy của các con số, kẻ mạnh nhất luôn được chọn làm gốc (Root), chia cắt thế giới thành hai nửa trái và phải. Dữ liệu dạy ta rằng bằng cách liên tục tìm kiếm điểm tựa vững chãi nhất (Divide and Conquer), ta có thể xây dựng được một trật tự (Tree structure) phản ánh chính xác sự phân cấp của thực tại.*
The peak (Maximum) determines the position. In the flow of numbers, the strongest is always chosen as the root (Root), dividing the world into two halves, left and right. Data teaches us that by continuously searching for the strongest fulcrum (Divide and Conquer), we can build an order (Tree structure) that accurately reflects the hierarchy of reality.
