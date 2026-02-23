# Analysis for Two Sum IV - Input is a BST
# *Phân tích cho bài toán Two Sum IV - Đầu vào là Cây Nhị phân Tìm kiếm*

## 1. Problem Essence & Multi-Element Search
## *1. Bản chất vấn đề & Tìm kiếm Đa phần tử*

### The Challenge
### *Thách thức*
We need to find if any two nodes in a Binary Search Tree (BST) sum up to a target `k`. 
*Chúng ta cần kiểm tra xem liệu có bất kỳ hai nút nào trong Cây Nhị phân Tìm kiếm (BST) có tổng bằng mục tiêu `k` hay không.*

Even though it's a BST, we can treat it as a general set of numbers and use standard "Two Sum" techniques, or we can leverage the sorted property of BSTs.
*Mặc dù đây là một BST, chúng ta có thể coi nó như một tập hợp số thông thường và sử dụng các kỹ thuật "Two Sum" tiêu chuẩn, hoặc chúng ta có thể tận dụng thuộc tính đã sắp xếp của BST.*

---

## 2. Strategy: DFS with HashSet
## *2. Chiến lược: DFS với HashSet*

The simplest approach is to traverse the tree and keep track of the values we've seen so far in a HashSet.
*Cách tiếp cận đơn giản nhất là duyệt cây và theo dõi các giá trị chúng ta đã thấy cho đến nay trong một HashSet.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Traversal:** Use DFS (pre-order, in-order, or post-order) to visit every node.
    * **Duyệt cây:** Sử dụng DFS để ghé thăm từng nút.*

2.  **Complement Check:** For each node with value `v`:
    * **Kiểm tra phần bù:** Đối với mỗi nút có giá trị `v`:*
    - Check if `k - v` exists in the `HashSet`.
    - If yes, return `true`.
    - If no, add `v` to the `HashSet` and continue traversal.

3.  **Termination:** If traversal finishes without a match, return `false`.
    * **Kết thúc:** Nếu việc duyệt cây kết thúc mà không có kết quả phù hợp, trả về `false`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Sorted Array Alternative:** One could also perform an in-order traversal to get a sorted array, then use Two Pointers. This is useful if space is a concern (since the array is linear and pointers don't need a hash table), but DFS+HashSet is more direct.
    * **Giải pháp mảng đã sắp xếp:** Ta cũng có thể duyệt trung thứ tự để có một mảng đã sắp xếp, sau đó sử dụng Hai con trỏ. Điều này hữu ích nếu không gian là vấn đề, nhưng DFS+HashSet trực tiếp hơn.*
*   **Time vs. Space:** This method is $O(N)$ for both time and space.
    * **Thời gian và Không gian:** Phương pháp này là $O(N)$ cho cả thời gian và không gian.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We visit each node once and perform constant-time lookup in the HashSet.
    * **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là số lượng nút. Mỗi nút được ghé thăm một lần và thực hiện tra cứu trong HashSet.*
*   **Space Complexity:** $O(N)$ to store $N$ values in the HashSet and for the recursion stack.
    * **Độ phức tạp không gian:** $O(N)$ để lưu trữ các giá trị trong HashSet và cho ngăn xếp đệ quy.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** tree = [5, 3, 6], k = 9
1. Node 5: Target complement 9-5=4. Not in set. Set: {5}.
2. Node 3: Target complement 9-3=6. Not in set. Set: {5, 3}.
3. Node 6: Target complement 9-6=3. **Match found in set!** Return `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "Two Sum" variations on trees, a HashSet is usually the most efficient and readable solution unless you are strictly limited in extra memory. It simplifies the problem by decoupling the tree structure from the value search.
*Đối với các biến thể "Two Sum" trên cây, HashSet thường là giải pháp hiệu quả và dễ đọc nhất trừ khi bạn bị giới hạn nghiêm ngặt về bộ nhớ phụ. Nó đơn giản hóa vấn đề bằng cách tách biệt cấu trúc cây khỏi việc tìm kiếm giá trị.*
---
*Sự kết hợp (Sum) hoàn hảo thường nằm ở sự bù đắp (Complement). Trong kiến trúc của cây (BST), mỗi giá trị là một mảnh ghép của một bức tranh lớn hơn. Dữ liệu dạy ta rằng bằng cách lưu giữ những ký ức (HashSet), ta có thể tìm thấy sự tương thích ngay khi nó xuất hiện, thay vì phải tìm kiếm lại từ đầu.*
Perfect connection (Sum) often lies in compensation (Complement). In tree architecture (BST), each value is a piece of a larger picture. Data teaches us that by keeping memories (HashSet), we can find compatibility as soon as it appears, instead of having to search again from scratch.
