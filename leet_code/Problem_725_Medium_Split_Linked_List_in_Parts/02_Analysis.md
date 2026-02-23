# Analysis for Split Linked List in Parts
# *Phân tích cho bài toán Chia Danh sách Liên kết thành các Phần*

## 1. Problem Essence & Distribution Logic
## *1. Bản chất vấn đề & Logic Phân phối*

### The Challenge
### *Thách thức*
We need to divide $N$ nodes into $K$ parts as evenly as possible. This means if $N$ is not perfectly divisible by $K$, we distribute the remainder across the first few parts. Specifically, if $N = L \cdot K + R$, the first $R$ parts get $(L+1)$ nodes, and the remaining $(K-R)$ parts get $L$ nodes.
*Chúng ta cần chia $N$ nút thành $K$ phần đều nhất có thể. Nếu $N$ không chia hết cho $K$, phần dư sẽ được phân phối vào các phần đầu tiên. Cụ thể, nếu $N = L \cdot K + R$, thì $R$ phần đầu tiên sẽ có $(L+1)$ nút, và các phần còn lại có $L$ nút.*

---

## 2. Strategy: Count-Calculate-Cut
## *2. Chiến lược: Đếm-Tính-Cắt*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Count Total Length:** Traverse the entire list once to find the total number of nodes `totalLen`.
    * **Đếm Tổng Độ dài:** Duyệt qua toàn bộ danh sách một lần để tìm tổng số nút.*

2.  **Determine Sizes:**
    - `baseSize = totalLen / k`
    - `extraNodes = totalLen % k`
    * **Xác định Kích thước:** Tính kích thước cơ bản và số lượng nút dư cần phân phối.*

3.  **Split Implementation:**
    - Use a pointer `curr` to traverse and `prev` to decouple the segments.
    - Iterate from `i = 0` to `k-1`:
        - Save `curr` as the head of the $i$-th result part.
        - Calculate current part size: `currentPartSize = baseSize + (i < extraNodes ? 1 : 0)`.
        - Advance `curr` by `currentPartSize` steps.
        - Set `prev.next = null` to terminate the segment.
    * **Thực hiện Chia:** Sử dụng con trỏ để duyệt và cắt các phân đoạn. Lưu đầu của mỗi phân đoạn vào mảng kết quả và ngắt kết nối với phần tiếp theo sau khi đã đi đủ số nút cần thiết.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + K)$, where $N$ is the number of nodes in the list and $K$ is the number of parts. We traverse the list to count and then traverse once more to split.
    * **Độ phức tạp thời gian:** $O(N + K)$.*
*   **Space Complexity:** $O(K)$ for the output array of heads.
    * **Độ phức tạp không gian:** $O(K)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**List: 1->2->3->4->5->6->7->8->9->10, k = 3**
`totalLen` = 10, `baseSize` = 10/3 = 3, `extraNodes` = 10%3 = 1.
- Part 1: size = 3 + 1 = 4. Nodes: [1, 2, 3, 4]. Break 4->5.
- Part 2: size = 3 + 0 = 3. Nodes: [5, 6, 7]. Break 7->8.
- Part 3: size = 3 + 0 = 3. Nodes: [8, 9, 10].
**Result:** [[1,2,3,4], [5,6,7], [8,9,10]]

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Splitting a linked list is all about pointer isolation. Always store the "next head" before nullifying the tail of the current segment to avoid losing the rest of the list.
*Chia danh sách liên kết chủ yếu là việc cô lập các con trỏ. Luôn lưu lại "đầu của phần tiếp theo" trước khi gán `null` cho đuôi của phân đoạn hiện tại để không làm mất phần còn lại của danh sách.*
---
*Sự công bằng (Fairness) trong phân chia không có nghĩa là mọi phần đều bằng nhau tuyệt đối, mà là sự chênh lệch tối thiểu (Difference $\le 1$). Trong dòng chảy của các mắt xích (Nodes), việc phân bổ phần dư (Remainder) vào những phân đoạn khởi đầu tạo nên một sự ưu tiên có trật tự. Dữ liệu dạy ta rằng bằng cách đo lường cái toàn thể (Total length) và quyết đoán trong việc ngắt kết nối (Decoupling), ta có thể tạo ra những mảnh ghép hài hòa từ một thực thể duy nhất.*
Fairness (Fairness) in division does not mean that every part is absolutely equal, but rather a minimum difference (Difference $\le 1$). In the flow of links (Nodes), allocating the remainder (Remainder) to the initial segments creates an ordered priority. Data teaches us that by measuring the whole (Total length) and being decisive in disconnecting (Decoupling), we can create harmonious fragments from a single entity.
