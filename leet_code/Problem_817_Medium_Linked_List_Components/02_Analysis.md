# Analysis for Linked List Components
# *Phân tích cho bài toán Các thành phần của danh sách liên kết*

## 1. Problem Essence & Connection Definition
## *1. Bản chất vấn đề & Định nghĩa Kết nối*

### THE CHALLENGE
### *Thách thức*
A "component" is a maximal sequence of one or more adjacent nodes in the linked list that all have values present in the given set `nums`. We need to count how many such continuous segments exist.
*Một "thành phần" là một chuỗi tối đa gồm một hoặc nhiều nút liền kề trong danh sách liên kết mà tất cả đều có giá trị nằm trong tập hợp `nums`. Chúng ta cần đếm xem có bao nhiêu phân đoạn liên tục như vậy tồn tại.*

---

## 2. Strategy: Traversal with Set Lookup
## *2. Chiến lược: Duyệt kèm tra cứu Tập hợp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Use a HashSet:** Store all values from `nums` in a `HashSet` for $O(1)$ average time lookup.
    *   **Sử dụng HashSet:** Lưu tất cả các giá trị từ `nums` vào một `HashSet` để tra cứu nhanh.*

2.  **Traverse the List:** Iterate through the linked list starting from the `head`.
    *   **Duyệt danh sách:** Duyệt qua danh sách liên kết bắt đầu từ `head`.*

3.  **Detect Component Boundaries:**
    - A new component is counted whenever we encounter a node value that **is** in the `HashSet`, and the **next** node is either `null` or its value **is not** in the `HashSet`.
    - Alternatively: Count a component when the current node is in `nums` and (it's the last node OR the next node is not in `nums`).
    *   **Phát hiện ranh giới thành phần:** Một thành phần mới được tính bất cứ khi nào chúng ta gặp một giá trị nút nằm trong `HashSet`, và nút **tiếp theo** là `null` hoặc giá trị của nó **không** nằm trong `HashSet`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numComponents(ListNode head, int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);
    
    int components = 0;
    ListNode curr = head;
    
    while (curr != null) {
        // If current value is in the set...
        if (set.contains(curr.val)) {
            // ...and it's the end of a contiguous sequence of set members
            if (curr.next == null || !set.contains(curr.next.val)) {
                components++;
            }
        }
        curr = curr.next;
    }
    
    return components;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$, where $N$ is the number of nodes in the linked list and $M$ is the size of `nums`. We traverse the list once and iterate through `nums` once to build the set.
    *   **Độ phức tạp thời gian:** $O(N + M)$. Ta duyệt danh sách một lần và mảng `nums` một lần.*
*   **Space Complexity:** $O(M)$, to store the values of `nums` in a `HashSet`.
    *   **Độ phức tạp không gian:** $O(M)$, để lưu trữ các giá trị của `nums` trong `HashSet`.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `head = [0,1,2,3], nums = [0,1,3]`
- Set: `{0, 1, 3}`
- Node 0: In set. Next is 1 (In set). Continue.
- Node 1: In set. Next is 2 (Not in set). **Count = 1**.
- Node 2: Not in set. Continue.
- Node 3: In set. Next is null. **Count = 2**.
**Result:** 2

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a `HashSet` to store `nums` is essential for performance. Counting components at their "ending" nodes (where the next node is either null or outside the subset) is a simple and effective logic to avoid duplicate counting.
*Sử dụng `HashSet` để lưu `nums` là rất quan trọng cho hiệu suất. Việc đếm các thành phần tại các nút "kết thúc" (nơi nút tiếp theo là null hoặc nằm ngoài tập hợp) là một logic đơn giản và hiệu quả để tránh đếm lặp.*
