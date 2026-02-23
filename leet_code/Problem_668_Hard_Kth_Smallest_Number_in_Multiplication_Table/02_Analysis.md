# Analysis for Kth Smallest Number in Multiplication Table
# *Phân tích cho bài toán Số nhỏ thứ k trong Bảng Cửu chương*

## 1. Problem Essence & Searching in Matrix
## *1. Bản chất vấn đề & Tìm kiếm trong Ma trận*

### The Challenge
### *Thách thức*
In an $M \times N$ multiplication table, values are structured such that each row and each column is sorted. However, finding the $k$-th smallest value globally is difficult because the values are not linearly sorted across the entire table.
*Trong một bảng cửu chương $M \times N$, các giá trị được cấu trúc sao cho mỗi hàng và mỗi cột đều đã được sắp xếp. Tuy nhiên, việc tìm giá trị nhỏ thứ $k$ trên toàn cục là rất khó vì các giá trị không được sắp xếp tuyến tính trên toàn bộ bảng.*

Since $M$ and $N$ can be up to $30,000$, we cannot construct the table ($M \times N \approx 9 \times 10^8$ cells). We need a sub-linear solution.
*Vì $M$ và $N$ có thể lên đến $30,000$, ta không thể tạo bảng. Chúng ta cần một giải pháp dưới tuyến tính.*

---

## 2. Strategy: Binary Search on the Answer
## *2. Chiến lược: Tìm kiếm Nhị phân trên Kết quả*

We can binary search for the *value* $X$ such that there are at least $k$ elements in the table less than or equal to $X$.
*Chúng ta có thể tìm kiếm nhị phân cho *giá trị* $X$ sao cho có ít nhất $k$ phần tử trong bảng nhỏ hơn hoặc bằng $X$.*

### Search Range
`low = 1`, `high = m * n`.
### Logic for Frequency Count `count(X)`
For a target value $X$:
*   In row $1$, values are $1, 2, \dots, n$. Count $\le X$ is $\min(n, \lfloor X / 1 \rfloor)$.
*   In row $i$, values are $i, 2i, \dots, ni$. Count $\le X$ is $\min(n, \lfloor X / i \rfloor)$.
*   Total count is $\sum_{i=1}^m \min(n, \lfloor X / i \rfloor)$.

### Step-by-Step Logic
### *Logic từng bước*

1.  **Binary Search:** Perform binary search for `X` in range `[1, m*n]`.
    * **Tìm kiếm Nhị phân:** Thực hiện tìm kiếm vị trí của giá trị trong phạm vi `[1, m*n]`.*

2.  **Evaluate Mid:** For the current `mid`:
    * **Đánh giá Mid:** *
    - Calculate total numbers in the table $\le mid$.
    - If `count >= k`: `mid` is a potential answer, search smaller values: `high = mid`.
    - Else: `mid` is too small: `low = mid + 1`.

3.  **Result:** `low`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Count Efficiency:** Calculating `count(X)` takes $O(M)$, which is $30,000$. This is much better than $30,000^2$.
    * **Hiệu quả đếm:** Tính `count(X)` tốn $O(M)$. Điều này tốt hơn nhiều so với $M \times N$.*
*   **Logarithmic Search:** The binary search adds a $\log(M \times N)$ factor.
    * **Tìm kiếm Logarit:** Tìm kiếm nhị phân thêm hệ số $\log(M \times N)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \log(M \times N))$. For $M=30,000$, $M \log(10^9) \approx 30,000 \times 30 = 9 \times 10^5$, which easily passes within 1 second.
    * **Độ phức tạp thời gian:** $O(M \log(M \times N))$.*
*   **Space Complexity:** $O(1)$. No extra storage needed.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**m=3, n=3, k=5**
Table:
```
1 2 3
2 4 6
3 6 9
```
Sorted: 1, 2, 2, 3, 3, 4, 6, 6, 9. 5th is 3.

1. low=1, high=9, mid=5.
   - count(5): Row1: min(3, 5/1)=3. Row2: min(3, 5/2)=2. Row3: min(3, 5/3)=1.
   - total = 3+2+1 = 6.
   - 6 >= 5. Match! high=5.
2. low=1, high=5, mid=3.
   - count(3): Row1: min(3, 3/1)=3. Row2: min(3, 3/2)=1. Row3: min(3, 3/3)=1.
   - total = 3+1+1 = 5.
   - 5 >= 5. Match! high=3.
3. low=1, high=3, mid=2.
   - count(2): Row1: min(3, 2/1)=2. Row2: min(3, 2/2)=1. Row3: 0.
   - total = 3.
   - 3 < 5. Too small. low=3.
4. low=3, high=3. End.
**Result:** 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

"K-th smallest" problems in large implicit structures are almost always solved using Binary Search on the Answer. This technique transforms a "search" problem into a simpler "counting" problem.
*Các bài toán "nhỏ thứ K" trong các cấu trúc ngầm định lớn hầu như luôn được giải bằng Tìm kiếm Nhị phân trên Kết quả.*
---
*Vị thế (k-th smallest) không nhất thiết phải được tìm thấy bằng cách sắp hàng (Sorting). Trong sự mênh mông của bảng nhân (Multiplication Table), ta tìm kiếm giá trị kỳ vọng (mid) và đếm xem có bao nhiêu thực thể nhỏ hơn nó (Counting). Dữ liệu dạy ta rằng bằng cách thu hẹp dần khoảng cách giữa cái quá lớn và cái quá nhỏ (Binary search), sự thật về con số thứ k sẽ dần hiển hiện trong một trật tự toán học hoàn hảo.*
Position (k-th smallest) does not necessarily have to be found by lining up (Sorting). In the immensity of the multiplication table (Multiplication Table), we look for the expected value (mid) and count how many entities are smaller than it (Counting). Data teaches us that by gradually narrowing the gap between the too large and the too small (Binary search), the truth about the k-th number will gradually appear in a perfect mathematical order.
