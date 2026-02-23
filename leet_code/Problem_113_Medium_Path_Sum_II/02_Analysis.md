# Analysis for Path Sum II
# *Phân tích cho bài toán Tổng Đường Đi II*

## 1. Problem Extension
## *1. Phần mở rộng của bài toán*

### From Boolean to Collection
### *Từ giá trị Boolean đến Tập hợp*
*   In the first version (Path Sum I), we only needed to know if **at least one** path existed.
    *Trong phiên bản đầu tiên (Tổng Đường Đi I), chúng ta chỉ cần biết liệu có tồn tại **ít nhất một** con đường hay không.*
*   In this version (Path Sum II), we must collect **every** valid path and return them as a list of lists.
    *Trong phiên bản này (Tổng Đường Đi II), chúng ta phải thu thập **mọi** con đường hợp lệ và trả chúng về dưới dạng một danh sách các danh sách.*

### Constraints and Considerations
### *Ràng buộc và Cân nhắc*
*   Values can be negative, which means we cannot stop searching early (pruning) if the current sum exceeds the target.
    *Giá trị có thể là số âm, nghĩa là chúng ta không thể dừng tìm kiếm sớm (cắt tỉa) nếu tổng hiện tại vượt quá mục tiêu.*
*   We must ensure we only count paths that end at a **true leaf node** (no left and no right children).
    *Chúng ta phải đảm bảo rằng chúng ta chỉ tính các con đường kết thúc tại một **nút lá thực sự** (không có con bên trái và không có con bên phải).*

---

## 2. Approach: Backtracking (DFS)
## *2. Hướng tiếp cận: Quay lui (DFS)*

### Core Logic
### *Logic cốt lõi*
1.  We use a global result list to store all valid paths found.
    *Chúng ta sử dụng một danh sách kết quả chung để lưu trữ tất cả các con đường hợp lệ được tìm thấy.*
2.  We use a temporary list (`currentPath`) to store nodes contributing to the current exploration.
    *Chúng ta sử dụng một danh sách tạm thời (`currentPath`) để lưu trữ các nút đóng góp vào quá trình khám phá hiện tại.*
3.  As we visit a node:
    -   Add its value to `currentPath`.
    -   Check if it is a leaf and if the current path's sum equals `targetSum`.
    -   If yes, create a **copy** of `currentPath` and add it to the result list. (Important: Add a copy, not the reference!).
    -   If not a leaf, recurse into children.
    -   **Backtrack:** Remove the current node's value from `currentPath` before returning to the parent. This restores the state for other branches.

### The Backtracking Mechanism
### *Cơ chế Quay lui*
Backtracking is essential here. Because the `currentPath` list is shared across different recursive calls, failing to remove the current node before rotating back to the parent would result in "garbage" data from previous branches being carried over.
*Quay lui là điều cần thiết ở đây. Vì danh sách `currentPath` được chia sẻ qua các lời gọi đệ quy khác nhau, việc không xóa nút hiện tại trước khi quay trở lại nút cha sẽ dẫn đến dữ liệu "rác" từ các nhánh trước đó bị mang theo.*

---

## 3. Algorithmic Efficiency
## *3. Hiệu quả giải thuật*

### Complexity Analysis
### *Phân tích độ phức tạp*
*   **Time Complexity:** $O(N^2)$ in the worst case.
    *Độ phức tạp thời gian: $O(N^2)$ trong trường hợp xấu nhất.*
    *   We visit $N$ nodes once ($O(N)$).
        *Chúng ta truy cập $N$ nút một lần.*
    *   However, whenever we find a valid path, we copy the path to the result list. A path can have at most $N$ nodes. In a highly skewed tree with many paths (e.g., a "binary" caterpillar), the copying process dominates.
        *Tuy nhiên, bất cứ khi nào tìm thấy một con đường hợp lệ, chúng ta sao chép con đường đó vào danh sách kết quả. Một con đường có thể có tối đa $N$ nút. Trong một cây bị lệch nghiêm trọng với nhiều con đường, quá trình sao chép sẽ chiếm ưu thế.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*
    *   The `currentPath` uses $O(N)$ space.
        *Danh sách `currentPath` sử dụng không gian $O(N)$.*
    *   The recursion stack uses $O(H)$ space, which is $O(N)$ in the worst case.
        *Ngăn xếp đệ quy sử dụng không gian $O(H)$, tức là $O(N)$ trong trường hợp xấu nhất.*
    *   The result list itself also stores paths, but space for results is usually not counted in space complexity unless specified.
        *Danh sách kết quả cũng lưu trữ các con đường, nhưng không gian cho kết quả thường không được tính vào độ phức tạp không gian trừ khi được chỉ định.*

---

## 4. Key Implementation Nuances
## *4. Những sắc thái quan trọng khi triển khai*

*   **Passing the Target:** Like Path Sum I, we can pass `targetSum - node.val` to avoid an extra variable.
    *Truyền mục tiêu: Giống như bài Tổng Đường Đi I, chúng ta có thể truyền `targetSum - node.val` để tránh biến phụ.*
*   **Copying the Path:** `result.add(new ArrayList<>(currentPath))` is the standard Java way to capture the current state of a list.
    *Sao chép con đường: `result.add(new ArrayList<>(currentPath))` là cách chuẩn trong Java để nắm bắt trạng thái hiện tại của một danh sách.*
*   **Base Case Handling:** Ensure the function returns immediately if a node is null to prevent errors.
    *Xử lý trường hợp cơ sở: Đảm bảo hàm trả về ngay lập tức nếu một nút là null để ngăn chặn lỗi.*
*   **Leaf Condition:** Remember, a leaf must have *no* children. A node with one child is not a leaf.
    *Điều kiện nút lá: Hãy nhớ rằng, một lá không được có con. Một nút có một con không phải là lá.*
---
*Xử lý đúng quy trình "Thêm - Khám phá - Xóa" là chìa khóa của mọi bài toán quay lui.*
Handling the "Add - Explore - Remove" process correctly is the key to every backtracking problem.
