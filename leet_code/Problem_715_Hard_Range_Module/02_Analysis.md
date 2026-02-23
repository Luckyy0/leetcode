# Analysis for Range Module
# *Phân tích cho bài toán Mô-đun Quản lý Khoảng*

## 1. Problem Essence & Interval Management
## *1. Bản chất vấn đề & Quản lý Khoảng*

### The Challenge
### *Thách thức*
We need to manage a set of disjoint half-open intervals $[L, R)$. The operations involve merging overlapping intervals (`addRange`), splitting or trimming intervals (`removeRange`), and checking if a range is fully contained within one established interval (`queryRange`).
*Chúng ta cần quản lý một bộ các khoảng nửa mở $[L, R)$ rời nhau. Các thao tác bao gồm hợp nhất các khoảng chồng lấp (`addRange`), chia nhỏ hoặc cắt bớt (`removeRange`), và kiểm tra xem một khoảng có nằm hoàn toàn trong một khoảng hiện có hay không (`queryRange`).*

---

## 2. Strategy: TreeMap of Disjoint Intervals
## *2. Chiến lược: TreeMap quản lý các Khoảng rời nhau*

A `TreeMap<Integer, Integer>` where the **Key** is the start of an interval and the **Value** is the end is ideal for this task.
*Sử dụng `TreeMap<Integer, Integer>` trong đó **Khóa** là điểm bắt đầu và **Giá trị** là điểm kết thúc của khoảng là lựa chọn lý tưởng.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **addRange(left, right):**
    - Find all intervals that overlap with $[left, right)$.
    - The lowest possible start for the new merged interval is $\min(left, \text{start of first overlapping interval})$.
    - The highest possible end for the new merged interval is $\max(right, \text{end of last overlapping interval})$.
    - Remove all overlapping intervals and insert the single merged one.
    * **Thêm Khoảng:** Tìm tất cả các khoảng chồng lấp, xác định biên mới (nhỏ nhất và lớn nhất trong số chúng) rồi gộp tất cả lại thành một khoảng duy nhất.*

2.  **removeRange(left, right):**
    - Find overlapping intervals.
    - If an interval $[s, e)$ overlaps with $[left, right)$, we may need to:
        - Re-add the left part $[s, left)$ if $s < left$.
        - Re-add the right part $[right, e)$ if $e > right$.
    - Remove the middle overlapping parts.
    * **Xóa Khoảng:** Cắt tỉa các khoảng hiện có tại vị trí bị xóa. Nếu một khoảng bị chia đôi, ta thêm lại hai phần còn dư.*

3.  **queryRange(left, right):**
    - Search for an interval whose start is $\le left$.
    - If such an interval exists and its end is $\ge right$, then the range is fully covered.
    * **Truy vấn:** Tìm khoảng có điểm bắt đầu $\le left$. Nếu khoảng đó kết thúc $\ge right$, nghĩa là phạm vi được bao phủ hoàn toàn.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Disjoint Property:** By always merging in `addRange`, we ensure that the total number of entries in the `TreeMap` remains small, enabling efficient lookups.
    * **Tính rời nhau:** Việc luôn hợp nhất giúp số lượng mục trong Map ít đi, tăng tốc độ tìm kiếm.*
*   **Logarithmic Search:** `TreeMap` provides $O(\log N)$ methods like `floorEntry` and `subMap`, which are crucial for finding candidate intervals quickly.
    * **Tìm kiếm Logarit:** Các phương thức như `floorEntry` cực kỳ hữu ích.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - `addRange`, `removeRange`: Amortized $O(\log N)$ where $N$ is the number of intervals. Although we might delete many intervals, each interval is added only once.
    - `queryRange`: $O(\log N)$.
    * **Độ phức tạp thời gian:** $O(\log N)$ trên trung bình.*
*   **Space Complexity:** $O(N)$ where $N$ is the total number of disjoint intervals stored.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Existing:** {10: 20} (Interval [10, 20))
- **removeRange(14, 16):**
    - Find overlap: [10, 20).
    - Left part: [10, 14) -> Add {10: 14}.
    - Right part: [16, 20) -> Add {16: 20}.
- **queryRange(10, 14):** 
    - `floor(10)` is {10: 14}. $14 \ge 14$, so `true`.
- **queryRange(13, 15):** 
    - `floor(13)` is {10: 14}. $14 < 15$, so `false`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For range management problems with high update frequency, a self-balancing binary search tree (like `TreeMap`) representing disjoint intervals is the most efficient and readable solution.
*Với các bài toán quản lý khoảng có tần suất cập nhật cao, cây tìm kiếm nhị phân tự cân bằng đại diện cho các khoảng rời nhau là giải pháp hiệu quả và dễ hiểu nhất.*
---
*Các khoảng thời gian (Ranges) dệt nên một dải băng của thực tại. Trong sự giao thoa (Overlapping) của chúng, việc hợp nhất (Add) tạo nên sự liền lạc, trong khi sự loại bỏ (Remove) tạo nên những vết cắt của sự lãng quên. Dữ liệu dạy ta rằng bằng cách duy trì trật tự của những mảnh ghép (TreeMap) và xác định ranh giới bao trùm (Query), ta có thể thấu thị được tính liên tục của mọi dòng chảy thông tin.*
Intervals (Ranges) weave a ribbon of reality. In their intersection (Overlapping), merging (Add) creates continuity, while removal (Remove) creates cuts of oblivion. Data teaches us that by maintaining the order of the pieces (TreeMap) and identifying overarching boundaries (Query), we can see the continuity of all information flows.
