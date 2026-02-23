# Analysis for Minimum Index Sum of Two Lists
# *Phân tích cho bài toán Tổng Chỉ số Tối thiểu của Hai Danh sách*

## 1. Problem Essence & Preference Matching
## *1. Bản chất vấn đề & Sự Kết hợp Sở thích*

### The Challenge
### *Thách thức*
We have two ranked lists (arrays) and want to find shared items that are ranked highest collectively (i.e., having the smallest sum of their indices).
*Chúng ta có hai danh sách xếp hạng (mảng) và muốn tìm các mục chung được xếp hạng cao nhất một cách tập thể (tức là có tổng chỉ số nhỏ nhất).*

The result can be multiple strings if they share the same minimum index sum.
*Kết quả có thể là nhiều chuỗi nếu chúng có cùng tổng chỉ số tối thiểu.*

---

## 2. Strategy: HashMap with Min Tracking
## *2. Chiến lược: HashMap với Theo dõi Giá trị Nhỏ nhất*

To avoid $O(N \times M)$ comparisons, we use a `HashMap` to store indices of one list.
*Để tránh các phép so sánh $O(N \times M)$, chúng ta sử dụng một `HashMap` để lưu trữ các chỉ số của một danh sách.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Map First List:** Iterate through `list1` and store `(String, Index)` in a Map.
    * **Ánh xạ Danh sách đầu tiên:** Duyệt qua `list1` và lưu trữ `(Chuỗi, Chỉ số)` vào một Map.*

2.  **Scan Second List:** Iterate through `list2`.
    * **Quét Danh sách thứ hai:** Duyệt qua `list2`.*
    - For each item at index `j`, check if it exists in the Map.
    - *Đối với mỗi mục ở chỉ số `j`, kiểm tra xem nó có tồn tại trong Map hay không.*
    - If it exists, calculate the sum $S = Map.get(item) + j$.
    - *Nếu nó tồn tại, hãy tính tổng $S = Map.get(item) + j$.*

3.  **Update Minimum and Result:**
    * **Cập nhật Giá trị nhỏ nhất và Kết quả:**
    - If $S < minSum$:
      - Update `minSum = S`.
      - Clear the current result list and add the new item.
      - *Cập nhật `minSum = S`. Làm sạch danh sách kết quả hiện tại và thêm mục mới.*
    - If $S == minSum$:
      - Add the item to the result list.
      - *Thêm mục vào danh sách kết quả.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Time:** The Map ensures we only visit each list once, resulting in linear complexity.
    * **Thời gian Tuyến tính:** Map đảm bảo chúng ta chỉ thăm mỗi danh sách một lần, dẫn đến độ phức tạp tuyến tính.*
*   **Tie Handling:** The "Clear and Add" vs "Add" logic correctly handles situations where a new, better minimum is found versus when a tying result is found.
    * **Xử lý Bằng điểm:** Logic "Làm sạch và Thêm" so với "Thêm" xử lý chính xác các tình huống khi tìm thấy giá trị nhỏ nhất mới, tốt hơn so với khi tìm thấy kết quả bằng điểm.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$, where $N$ and $M$ are lengths of the two lists.
    * **Độ phức tạp thời gian:** $O(N + M)$, trong đó $N$ và $M$ là độ dài của hai danh sách.*
*   **Space Complexity:** $O(\min(N, M))$ to create the HashMap for one of the lists.
    * **Độ phức tạp không gian:** $O(\min(N, M))$ để tạo HashMap cho một trong các danh sách.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**L1:** [A:0, B:1, C:2] **L2:** [B:0, A:1]
1. Map: {A:0, B:1, C:2}
2. Scan L2 Index 0 (B):
   - Sum = 1 (from Map) + 0 (from L2) = 1.
   - minSum = 1. Result = ["B"].
3. Scan L2 Index 1 (A):
   - Sum = 0 (from Map) + 1 (from L2) = 1.
   - Sum == minSum. Result = ["B", "A"].
**Result:** ["B", "A"].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Use Map-based lookup for set intersection problems involving additional properties (like index or count) to achieve $O(1)$ search time.
*Sử dụng tra cứu dựa trên Map cho các bài toán giao tập hợp liên quan đến các thuộc tính bổ sung (như chỉ số hoặc số đếm) để đạt được thời gian tìm kiếm $O(1)$.*
---
*Sự đồng thuận (Agreement) quan trọng nhất khi mọi người đều đặt nó ở vị trí ưu tiên (Smallest index). Khi hai tâm hồn (Lists) gặp nhau tại một điểm chung, tổng hòa của sự nhiệt huyết (Index sum) sẽ cho ta thấy đâu là sự lựa chọn tốt nhất. Tìm kiếm điểm chung (Intersection) là bước đầu tiên để xây dựng sự hòa hợp.*
Agreement (Agreement) is most important when everyone puts it in priority (Smallest index). When two souls (Lists) meet at a common point, the harmony of enthusiasm (Index sum) will show us the best choice. Searching for commonality (Intersection) is the first step to building harmony.
