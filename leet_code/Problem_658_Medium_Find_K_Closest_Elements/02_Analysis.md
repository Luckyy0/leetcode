# Analysis for Find K Closest Elements
# *Phân tích cho bài toán Tìm K Phần tử Gần nhất*

## 1. Problem Essence & Window of Closeness
## *1. Bản chất vấn đề & Cửa sổ của sự Gần gũi*

### The Challenge
### *Thách thức*
In a sorted array, we need to find a contiguous range of $k$ elements that are closest to a target $x$. Since the array is sorted, the $k$ closest elements must form a contiguous subarray.
*Trong một mảng đã sắp xếp, chúng ta cần tìm một phạm vi liên tiếp gồm $k$ phần tử gần với mục tiêu $x$ nhất. Vì mảng đã sắp xếp, $k$ phần tử gần nhất phải tạo thành một mảng con liên tiếp.*

---

## 2. Strategy: Binary Search for the Left Boundary
## *2. Chiến lược: Tìm kiếm Nhị phân cho Ranh giới Trái*

Instead of finding $x$ and expanding outwards, we can use binary search to directly find the **starting index** of the $k$-element window.
*Thay vì tìm $x$ rồi mở rộng sang hai bên, chúng ta có thể sử dụng tìm kiếm nhị phân để tìm trực tiếp **chỉ số bắt đầu** của cửa sổ $k$ phần tử.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Define Range for Left Boundary:** The starting index `i` can be anywhere from `0` to `n - k`.
    * **Xác định phạm vi cho Ranh giới Trái:** Chỉ số bắt đầu `i` có thể nằm bất cứ đâu từ `0` đến `n - k`.*

2.  **Binary Search:**
    * **Tìm kiếm Nhị phân:** *
    - Let `low = 0`, `high = n - k`.
    - While `low < high`:
        - `mid = low + (high - low) / 2`.
        - Compare two potential windows: the one starting at `mid` and the one starting at `mid + 1`.
        - To decide if `mid` or `mid + 1` is better, compare the distance of $x$ to the extreme elements:
            - `distMid = x - arr[mid]`.
            - `distMidK = arr[mid + k] - x`.
            - If `distMid > distMidK`: The window at `mid + 1` is closer to $x$ (moving right is better). `low = mid + 1`.
            - Else: The window at `mid` is better (or equally good). `high = mid`.

3.  **Result:** The window starts at `low` and ends at `low + k - 1`.
    * **Kết quả:** Cửa sổ bắt đầu tại `low` và kết thúc tại `low + k - 1`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Logarithmic Efficiency:** This approach runs in $O(\log(N-K))$, significantly faster than $O(N)$ expansion if $N$ is large.
    * **Hiệu suất Logarit:** Cách tiếp cận này chạy trong $O(\log(N-K))$, nhanh hơn nhiều so với việc mở rộng $O(N)$ nếu $N$ lớn.*
*   **Mathematical Elegance:** The condition `x - arr[mid] > arr[mid + k] - x` simplifies the decision of which direction to move the window.
    * **Sự trang nhã toán học:** Điều kiện so sánh giúp đơn giản hóa việc đưa ra quyết định di chuyển cửa sổ theo hướng nào.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log(N-K) + K)$. Logarithmic search for the boundary, then $O(K)$ to build the result list.
    * **Độ phức tạp thời gian:** $O(\log(N-K) + K)$.*
*   **Space Complexity:** $O(1)$ extra space (excluding the result list).
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [1, 2, 3, 4, 5], k=4, x=3
1. low=0, high=1. (n=5, k=4, n-k=1).
2. mid=0.
   - distMid = 3 - arr[0] = 3 - 1 = 2.
   - distMidK = arr[0+4] - 3 = arr[4] - 3 = 5 - 3 = 2.
3. 2 > 2 is **false**. high = mid = 0.
4. Loop ends. low = 0.
**Result:** Window [0, 3] -> [1, 2, 3, 4].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Binary search on the **index of a window** is a powerful pattern for problems requiring contiguous segments from any sorted structure. It avoids messy pointer logic during "outward expansion" and handles edge cases (like $x$ being way outside the array) automatically.
*Tìm kiếm nhị phân trên **chỉ số của một cửa sổ** là một mô hình mạnh mẽ. Nó giúp tránh việc xử lý các con trỏ phức tạp khi mở rộng từ trung tâm.*
---
*Sự gần gũi (Closeness) được định nghĩa bởi sự cân bằng. Trong một mảng đã được trật tự hóa (Sorted array), việc tìm kiếm vị thế lý tưởng (Binary search window) là một quá trình thu hẹp dần ranh giới cho đến khi đạt được sự hài hòa nhất với mục tiêu (Target x). Dữ liệu dạy ta rằng bằng cách so sánh hai đầu của tương lai (mid và mid+k), ta có thể xác định được hướng đi đúng đắn nhất.*
Closeness (Closeness) is defined by balance. In an ordered array (Sorted array), searching for an ideal position (Binary search window) is a process of gradually narrowing the boundaries until the most harmony with the goal (Target x) is achieved. Data teaches us that by comparing two ends of the future (mid and mid+k), we can determine the most correct direction.
