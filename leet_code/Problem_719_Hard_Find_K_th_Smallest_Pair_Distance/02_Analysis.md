# Analysis for Find K-th Smallest Pair Distance
# *Phân tích cho bài toán Tìm Khoảng cách cặp nhỏ thứ K*

## 1. Problem Essence & Searching the Answer Space
## *1. Bản chất vấn đề & Tìm kiếm trên Không gian Đáp án*

### The Challenge
### *Thách thức*
We need to find the $K$-th smallest distance. There are $O(N^2)$ possible pairs, so calculating all distances and sorting them would take $O(N^2 \log N)$ time, which is too slow for $N=10,000$. Instead, we can notice that the possible distances range from `0` to `max(nums) - min(nums)`. This range is sorted, allowing us to perform **Binary Search on the Result**.
*Chúng ta cần tìm khoảng cách nhỏ thứ $K$. Có $O(N^2)$ cặp, nên việc tính tất cả và sắp xếp sẽ tốn $O(N^2 \log N)$, quá chậm. Thay vào đó, ta thấy các khoảng cách nằm trong đoạn từ 0 đến khoảng cách tối đa. Đoạn này đã được sắp xếp, cho phép ta **Tìm kiếm nhị phân trên Đáp án**.*

---

## 2. Strategy: Binary Search + Two Pointers
## *2. Chiến lược: Tìm kiếm nhị phân + Hai con trỏ*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Sorting:** Sort the array `nums` in ascending order. This allows us to use two pointers to count pairs efficiently.
    * **Sắp xếp:** Sắp xếp mảng để sử dụng kỹ thuật hai con trỏ.*

2.  **Binary Search for Distance:**
    - Let `low = 0` and `high = max - min`.
    - Trial `mid` distance.
    - Count how many pairs have a distance $\le mid$.
    - If `count >= k`: The $K$-th distance might be `mid` or smaller. Set `high = mid`.
    - If `count < k`: The $K$-th distance must be larger than `mid`. Set `low = mid + 1`.
    * **Tìm kiếm nhị phân:** Thử một khoảng cách `mid`, đếm số cặp có khoảng cách $\le mid$. Nếu đủ $K$ cặp, đáp án có thể nhỏ hơn hoặc bằng `mid`.*

3.  **Counting Pairs (Sliding Window):**
    - For each `right` index from `0` to `n-1`:
    - Move `left` forward until `nums[right] - nums[left] <= mid`.
    - Every pair `(i, right)` where `left <= i < right` has distance $\le mid$.
    - Add `right - left` to the total count.
    * **Đếm số cặp (Cửa sổ trượt):** Với mỗi `right`, tìm `left` xa nhất sao cho khoảng cách $\le mid$. Số cặp mới là `right - left`.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N + N \log D)$, where $N$ is the array length and $D$ is the maximum distance ($10^6$).
    * **Độ phức tạp thời gian:** $O(N \log N + N \log D)$.*
*   **Space Complexity:** $O(1)$ (ignoring space for sorting).
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**nums = [1, 1, 6], k = 2**
Sorted: [1, 1, 6]. Range [0, 5].
Trial mid = 2:
- R=0: count += 0.
- R=1: bits[1]-bits[0]=0 <= 2. count += 1.
- R=2: bits[2]-bits[1]=5 > 2. Left moves to 2. count += 0.
Total count = 1.
1 < 2, so low = 2 + 1 = 3.
... Continuing Binary Search ...
**Result:** 5 (Distances are 0, 5, 5. The 2nd is 5).

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Whenever you need the "K-th smallest/largest" of a set too large to materialize, always consider Binary Search on the Answer. The monotonic relationship between the value (distance) and its rank (count) is the key.
*Bất cứ khi nào bạn cần "phần tử thứ K" của một tập hợp quá lớn để liệt kê, hãy cân nhắc Tìm kiếm nhị phân trên Đáp án. Mối quan hệ đơn điệu giữa giá trị và thứ hạng là chìa khóa.*
---
*Khoảng cách (Distance) giữa các sự vật định hình nên vị trí của chúng trong một trật tự (Rank). Trong một biển các cặp dữ liệu (Pairs), việc tìm kiếm ngôi vị thứ K yêu cầu một sự thấu thị về giới hạn (Binary search). Dữ liệu dạy ta rằng bằng cách thử thách các ranh giới (Trial mid) và đếm những gì nằm trong tầm kiểm soát (Two pointers), ta có thể xác định chính xác một quy luật ẩn giấu mà không cần phải chạm tay vào mọi phần tử đơn lẻ.*
Distance (Distance) between things defines their place in an order (Rank). In a sea of data pairs (Pairs), searching for the K-th position requires an insight into limits (Binary search). Data teaches us that by challenging boundaries (Trial mid) and counting what is within control (Two pointers), we can accurately determine a hidden law without having to touch every single element.
