# Analysis for Subarray Sum Equals K
# *Phân tích cho bài toán Tổng Mảng con bằng K*

## 1. Problem Essence & The Bottleneck of Naivety
## *1. Bản chất vấn đề & Điểm nghẽn của sự Ngây thơ*

### The Challenge
### *Thách thức*
We need to count all contiguous subarrays that sum up to exactly $k$.
*Chúng ta cần đếm tất cả các mảng con liên tiếp có tổng đúng bằng $k$.*

A naive solution checks all pairs of indices $(i, j)$ and calculates the sum of $nums[i...j]$. This $O(N^2)$ or $O(N^3)$ approach is too slow for an array of $20,000$ elements ($N^2 = 400$ million).
*Một giải pháp ngây thơ sẽ kiểm tra tất cả các cặp chỉ số $(i, j)$ và tính tổng của $nums[i...j]$. Cách tiếp cận $O(N^2)$ hoặc $O(N^3)$ này quá chậm đối với một mảng gồm $20.000$ phần tử ($N^2 = 400$ triệu).*

---

## 2. Strategy: Prefix Sum with Frequency Mapping
## *2. Chiến lược: Tổng Tiền tố với Ánh xạ Tần suất*

The key insight is using the mathematical relationship between prefix sums.
*Hiểu biết then chốt là sử dụng mối quan hệ toán học giữa các tổng tiền tố.*

Let $S(i)$ be the sum of elements from index $0$ to $i$.
The sum of a subarray from index $j+1$ to $i$ is $S(i) - S(j)$.
If we want this sum to be $k$, we need:
$S(i) - S(j) = k$
Which implies: $S(j) = S(i) - k$.
*Giả sử $S(i)$ là tổng các phần tử từ chỉ số $0$ đến $i$. Tổng của một mảng con từ chỉ số $j+1$ đến $i$ là $S(i) - S(j)$. Nếu chúng ta muốn tổng này bằng $k$, ta cần: $S(i) - S(j) = k$, tức là: $S(j) = S(i) - k$.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** Create a `HashMap<Integer, Integer>` called `prefix_map` and a variable `sum = 0`.
    * **Khởi tạo:** Tạo một `HashMap<Integer, Integer>` gọi là `prefix_map` và một biến `sum = 0`.*
2.  **Base Case:** Add `{0: 1}` to the map. This represents a prefix sum of 0 occurring once (helpful for subarrays starting at index 0).
    * **Trường hợp cơ sở:** Thêm `{0: 1}` vào bản đồ. Điều này đại diện cho một tổng tiền tố bằng 0 xuất hiện một lần (hữu ích cho các mảng con bắt đầu từ chỉ số 0).*
3.  **Linear Scan:** Iterate through the array.
    * **Quét tuyến tính:** Duyệt qua mảng.*
    - Add the current number to `sum`.
    - *Cộng số hiện tại vào `sum`.*
    - Check if `sum - k` exists in the `prefix_map`. If yes, add its frequency to our result count.
    - *Kiểm tra xem `sum - k` có tồn tại trong `prefix_map` không. Nếu có, hãy cộng tần suất của nó vào số lượng kết quả của chúng ta.*
    - Add/Update the current `sum` frequency in the `prefix_map`.
    - *Thêm/Cập nhật tần suất của `sum` hiện tại trong `prefix_map`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **One-Pass Logic:** The problem is solved in a single traversal, making it extremely efficient.
    * **Logic Một lượt:** Bài toán được giải quyết trong một lần duyệt duy nhất, giúp nó cực kỳ hiệu quả.*
*   **Space-Time Tradeoff:** We trade $O(N)$ space (the map) to achieve an $O(N)$ time complexity.
    * **Sự đánh đổi Không gian-Thời gian:** Chúng ta đánh đổi không gian $O(N)$ (bản đồ) để đạt được độ phức tạp thời gian $O(N)$.*
*   **Negative Values:** This approach naturally handles negative numbers in the array, where sliding window techniques (like Two Pointers) might fail.
    * **Giá trị Âm:** Cách tiếp cận này xử lý một cách tự nhiên các số âm trong mảng, nơi các kỹ thuật cửa sổ trượt (như Hai con trỏ) có thể thất bại.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each element is processed once, and HashMap lookups are $O(1)$ on average.
    * **Độ phức tạp thời gian:** $O(N)$. Mỗi phần tử được xử lý một lần, và việc tra cứu HashMap trung bình là $O(1)$.*
*   **Space Complexity:** $O(N)$ to store the frequencies of the prefix sums.
    * **Độ phức tạp không gian:** $O(N)$ để lưu trữ tần suất của các tổng tiền tố.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `nums = [1, 2, 3], k = 3`
1. `Map = {0: 1}`, `sum = 0`, `count = 0`.
2. Index 0 (num=1): `sum = 1`. `sum - k = -2`. Not in map. `Map = {0: 1, 1: 1}`.
3. Index 1 (num=2): `sum = 3`. `sum - k = 0`. **Match!** `count += Map[0]` -> `count = 1`. `Map = {0: 1, 1: 1, 3: 1}`.
4. Index 2 (num=3): `sum = 6`. `sum - k = 3`. **Match!** `count += Map[3]` -> `count = 2`. `Map = {0: 1, 1: 1, 3: 1, 6: 1}`.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Prefix Sum + HashMap is the "golden pattern" for solving any problem involving counting subarrays with a specific target sum or property.
*Tổng tiền tố + HashMap là "mẫu hình vàng" để giải bất kỳ bài toán nào liên quan đến việc đếm các mảng con với một tổng hoặc đặc tính mục tiêu cụ thể.*
---
*Số lượng mảng con (Subarrays) có thể rất lớn, nhưng thông qua sự tích lũy (Prefix Sum), ta có thể nắm bắt được toàn bộ lịch sử của chúng. Bằng cách ghi nhớ (HashMap) những gì đã qua, chúng ta có thể ngay lập tức nhận ra khi nào mục tiêu (k) được đạt tới, biến một bài toán phức tạp thành một lần lướt qua đơn giản.*
The number of subarrays (Subarrays) can be very large, but through accumulation (Prefix Sum), we can capture their entire history. By remembering (HashMap) what has passed, we can immediately recognize when the goal (k) is reached, turning a complex problem into a simple scan.
