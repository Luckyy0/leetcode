# Analysis for Copy List with Random Pointer
# *Phân tích cho bài toán Sao Chép Danh Sách Với Con Trỏ Ngẫu Nhiên*

## 1. Problem Core: The Random Pointer Dilemma
## *1. Cốt Lõi Vấn Đề: Thế Khó Của Con Trỏ Ngẫu Nhiên*

### Why Simple Traversal Fails
### *Tại Sao Việc Duyệt Đơn Giản Thất Bại*
*   In a standard linked list, we can clone nodes as we traverse using `next` pointers.
    *Trong một danh sách liên kết tiêu chuẩn, chúng ta có thể sao chép các nút khi duyệt bằng con trỏ `next`.*
*   The `random` pointer, however, can point to a node that has not been created yet (a node further down the list) or a node that was already created (a node earlier in the list).
    *Tuy nhiên, con trỏ `random` có thể trỏ đến một nút chưa được tạo (một nút ở xa hơn trong danh sách) hoặc một nút đã được tạo (một nút ở phía trước).*
*   Without a way to remember and map original nodes to their cloned counterparts, we cannot properly link the `random` pointers in a single pass.
    *Nếu không có cách nào để ghi nhớ và ánh xạ các nút gốc sang các nút sao chép tương ứng, chúng ta không thể liên kết chính xác các con trỏ `random` chỉ trong một lần duyệt.*

---

## 2. Approach 1: Iterative with HashMap
## *2. Hướng Tiếp Cận 1: Lặp Với HashMap*

### Logic
### *Logic*
1.  **Pass 1:** Traverse the original list and create a copy of each node. Store the mapping `Map<OriginalNode, CopiedNode>`. At this stage, only values are set; pointers are null.
    *Lượt 1: Duyệt qua danh sách gốc và tạo bản sao của mỗi nút. Lưu trữ ánh xạ `Map<OriginalNode, CopiedNode>`. Ở giai đoạn này, chỉ các giá trị được đặt; các con trỏ đều là null.*
2.  **Pass 2:** Traverse the original list again. For each node `curr`:
    -   `map.get(curr).next = map.get(curr.next);`
    -   `map.get(curr).random = map.get(curr.random);`
3.  Return `map.get(head)`.

### Complexity
### *Độ Phức Tạp*
*   **Time:** $O(N)$.
*   **Space:** $O(N)$ for the HashMap.

---

## 3. Approach 2: Interweaving Nodes (O(1) Extra Space)
## *3. Hướng Tiếp Cận 2: Đan Xen Các Nút (Không Gian Bổ Sung O(1))*

This is the clever optimization that avoids using a HashMap.
*Đây là sự tối ưu hóa thông minh giúp tránh sử dụng HashMap.*

### Logic
### *Logic*
1.  **Phase 1: Interweaving.** Create a copy of each node and insert it directly after the original node in the same list.
    `A -> B -> C` becomes `A -> A' -> B -> B' -> C -> C'`.
    *Giai đoạn 1: Đan xen. Tạo bản sao của mỗi nút và chèn nó ngay sau nút gốc trong cùng một danh sách.*
2.  **Phase 2: Link Random Pointers.** Now, for any node `curr`, its copy is `curr.next`. The original `random` points to `curr.random`. Thus, the copied `random` should point to `curr.random.next`.
    *Giai đoạn 2: Liên kết con trỏ ngẫu nhiên. Bây giờ, đối với bất kỳ nút `curr` nào, bản sao của nó là `curr.next`. Con trỏ `random` gốc trỏ đến `curr.random`. Do đó, con trỏ `random` sao chép nên trỏ đến `curr.random.next`.*
3.  **Phase 3: Separation.** Split the interweaved list into the original list and the cloned list.
    *Giai đoạn 3: Tách rời. Chia danh sách đã đan xen thành danh sách gốc và danh sách sao chép.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We make three passes over the list, but each pass is linear.
    *Độ phức tạp thời gian: $O(N)$. Chúng ta thực hiện ba lượt duyệt danh sách, nhưng mỗi lượt đều là tuyến tính.*
*   **Space Complexity:** $O(1)$ extra space (excluding the memory required for the $N$ new nodes that form the deep copy).
    *Độ phức tạp không gian: $O(1)$ không gian bổ sung (không bao gồm bộ nhớ cần thiết cho $N$ nút mới tạo thành bản sao sâu).*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

While the HashMap approach is easier to implement and less error-prone, the **Interweaving** technique is highly preferred in competitive programming and top-tier technical interviews because of its $O(1)$ space efficiency. It demonstrates a sophisticated level of pointer manipulation.
*Mặc dù phương pháp HashMap dễ triển khai và ít lỗi hơn, kỹ thuật **Đan xen** được ưu tiên cao trong lập trình thi đấu và các cuộc phỏng vấn kỹ thuật hàng đầu vì hiệu quả không gian $O(1)$. Nó thể hiện một trình độ thao tác con trỏ tinh vi.*
---
*Việc đan xen cái mới vào cái cũ là cách ngắn nhất để thấu hiểu mối quan hệ thầm kín của những thực thể xa lạ.*
Interweaving the new into the old is the shortest way to understand the secret relationships of foreign entities.
