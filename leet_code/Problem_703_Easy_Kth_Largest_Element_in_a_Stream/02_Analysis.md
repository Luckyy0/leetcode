# Analysis for Kth Largest Element in a Stream
# *Phân tích cho bài toán Phần tử lớn thứ K trong một Luồng*

## 1. Problem Essence & Strategy
## *1. Bản chất vấn đề & Chiến lược*

### The Challenge
### *Thách thức*
We need to track the $K$-th largest value as new items are added to the list. Maintaining a full sorted list would be $O(N \log N)$ per addition. We only need the top $K$ items.
*Chúng ta cần theo dõi giá trị lớn thứ $K$ khi các mục mới được thêm vào.ệc duy trì một danh sách được sắp xếp đầy đủ sẽ tốn $O(N \log N)$ mỗi lần thêm. Chúng ta chỉ cần $K$ mục lớn nhất.*

---

## 2. Strategy: Min-Heap of Size K
## *2. Chiến lược: Min-Heap kích thước K*

The most efficient way to keep track of the $K$ largest elements is to use a **Min-Heap** of size $K$.
*Cách hiệu quả nhất để theo dõi $K$ phần tử lớn nhất là sử dụng một **Min-Heap** có kích thước $K$.*

### Logic
1.  **Top K Items:** In a Min-Heap of size $K$, the element at the root (the minimum) is the $K$-th largest element of all added elements.
2.  **Insertion:**
    - If a new value is larger than the heap's minimum, it might be in the top $K$. Pop the minimum and add the new value.
    - If the heap has fewer than $K$ elements, just add the new value.
3.  **Result:** Always return `heap.peek()`.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - Initialization: $O(N \log K)$.
    - Addition: $O(\log K)$.
    * **Độ phức tạp thời gian:** $O(\log K)$ cho mỗi lần thêm.*
*   **Space Complexity:** $O(K)$ to store the heap.
    * **Độ phức tạp không gian:** $O(K)$.*

---

## 4. Summary Recommendation
## *4. Khuyến nghị Tổng kết*

For "Kth something" in a stream, PriorityQueue is the de-facto standard. A Min-Heap of size $K$ effectively discards all elements smaller than the $K$-th largest, keeping only the candidates that matter.
*Đối với bài toán "phần tử thứ K" trong một luồng, PriorityQueue là tiêu chuẩn. Min-Heap kích thước $K$ loại bỏ các phần tử nhỏ hơn mức cần thiết.*
---
*Sự chọn lọc (Kth largest) trong một dòng chảy không ngừng (Stream) là nghệ thuật của việc buông bỏ. Trong một không gian giới hạn (Heap size K), ta chỉ giữ lại những gì ưu tú nhất, và đỉnh của sự khiêm nhường (Min-Heap root) chính là ranh giới của ngôi vị thứ K. Dữ liệu dạy ta rằng bằng cách thanh lọc những gì tầm thường (Discards smallers), ta có thể tập trung vào những giá trị cốt lõi làm nên sức mạnh của hệ thống.*
Selection (Kth largest) in a constant flow (Stream) is the art of letting go. In a limited space (Heap size K), we only keep the most elite, and the peak of humility (Min-Heap root) is the boundary of the K-th position. Data teaches us that by purging the mediocre (Discards smallers), we can focus on the core values that make up the strength of the system.
