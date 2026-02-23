# Analysis for Sum Root to Leaf Numbers
# *Phân tích cho bài toán Tổng Các Số Từ Gốc Đến Lá*

## 1. Problem Essence & Numeric Representation
## *1. Bản Chất Vấn Đề & Biểu Diễn Số Học*

### Path as a Number
### *Đường Đi Dưới Dạng Một Số*
*   In this problem, the sequence of node values encountered from the root down to a leaf is interpreted as a decimal number.
    *Trong bài toán này, chuỗi các giá trị của nút gặp phải từ gốc xuống đến một lá được hiểu là một số thập phân.*
*   For every step we move down a level, the previous accumulated value shifts one decimal place to the left (is multiplied by 10) and the current node's value is added as the new units digit.
    *Đối với mỗi bước chúng ta di chuyển xuống một tầng, giá trị tích lũy trước đó sẽ dịch chuyển một chữ số thập phân sang trái (được nhân với 10) và giá trị của nút hiện tại được thêm vào dưới dạng chữ số hàng đơn vị mới.*

### Mathematical Formula
### *Công Thức Toán Học*
If the path is represented by digits $d_1, d_2, d_3, ..., d_k$:
The number is $N = d_1 \cdot 10^{k-1} + d_2 \cdot 10^{k-2} + ... + d_k \cdot 10^0$.
However, recursively, it's easier to think as:
`NewSum = (ParentSum * 10) + currentDigit`.
*Nếu đường đi được đại diện bởi các chữ số $d_1, d_2, d_3, ..., d_k$, thì con số là $N = d_1 \cdot 10^{k-1} + d_2 \cdot 10^{k-2} + ... + d_k \cdot 10^0$. Tuy nhiên, về mặt đệ quy, sẽ dễ dàng hơn khi nghĩ là: `NewSum = (ParentSum * 10) + currentDigit`.*

---

## 2. Approach: Pre-order Traversal (DFS)
## *2. Hướng Tiếp Cận: Duyệt Theo Thứ Tự Trước (DFS)*

### Logic
### *Logic*
1.  We define a recursive helper function `sumNodes(node, currentSum)`:
    -   **Base Case:** If `node` is `null`, return 0.
    -   **Accumulation:** Update `currentSum = currentSum * 10 + node.val`.
    -   **Leaf Verification:** If `node` is a leaf (both `left` and `right` are null), it means we have completed a path. Return the `currentSum`.
    -   **Recursive Step:** If not a leaf, return the sum of the results from the left child and the right child.
        *Nếu không phải là lá, trả về tổng các kết quả từ nút con bên trái và nút con bên phải.*

---

## 3. Structural Considerations
## *3. Các Cân Nhắc Về Cấu Trúc*

*   **Tree Traversal Choice:** Pre-order DFS is optimal here because we need to pass the information (the numeric prefix) from top to bottom.
    *Lựa Chọn Duyệt Cây: DFS theo thứ tự trước là tối ưu ở đây vì chúng ta cần truyền thông tin (tiền tố số) từ trên xuống dưới.*
*   **Integer Overflow:** The constraints state that the depth is $\le 10$. This means the largest possible number is around $9,999,999,999 \approx 10^{10}$, which might exceed a standard 32-bit `int` ($2 \cdot 10^9$). Wait, actually the description says "the answer will fit in a 32-bit integer", so we are safe using `int`.
    *Tràn Số Nguyên: Các ràng buộc nêu rằng chiều sâu $\le 10$. Điều này có nghĩa là con số lớn nhất có thể là khoảng $9.999.999 .999 \approx 10^{10}$, có thể vượt quá một số `int` 32-bit chuẩn ($2 \cdot 10^9$). Tuy nhiên, phần mô tả có ghi "câu trả lời sẽ khớp với một số nguyên 32-bit", vì vậy chúng ta an toàn khi sử dụng `int`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes in the binary tree. We visit each node exactly once.
    *Độ phức tạp thời gian: $O(N)$, trong đó $N$ là số lượng nút trong cây nhị phân. Chúng ta truy cập mỗi nút đúng một lần.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree. This is the space used by the recursion stack. In the worst case (skewed tree), $O(H) = O(N)$. Given the depth constraint of 10, this is extremely small ($O(1)$ effectively).
    *Độ phức tạp không gian: $O(H)$, trong đó $H$ là chiều cao của cây. Đây là không gian được sử dụng bởi ngăn xếp đệ quy. Trong trường hợp xấu nhất (cây bị lệch), $O(H)=O(N)$. Với ràng buộc về chiều sâu là 10, con số này cực kỳ nhỏ (về mặt hiệu quả là $O(1)$).*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

This is a classic DFS problem that tests your ability to propagate values down a tree. The key is recognizing how decimal numbers are formed and knowing when to return the accumulated value (at leaf nodes). The recursive structure makes the code clean and easy to read.
*Đây là một bài toán DFS kinh điển kiểm tra khả năng truyền các giá trị xuống một cái cây của bạn. Chìa khóa là nhận ra cách các số thập phân được hình thành và biết khi nào cần trả về giá trị tích lũy (tại các nút lá). Cấu trúc đệ quy làm cho mã sạch sẽ và dễ đọc.*
---
*Mỗi nhánh cây là một con đường, và mỗi con đường kể một câu chuyện về những con số được ghép lại từ cội nguồn.*
Each branch of the tree is a path, and each path tells a story of numbers pieced together from the source.
