# Analysis for Smallest Rotation with Highest Score
# *Phân tích cho bài toán Vòng xoay nhỏ nhất với điểm số cao nhất*

## 1. Problem Essence & Range Contribution
## *1. Bản chất vấn đề & Đóng góp khoảng*

### The Challenge
### *Thách thức*
A number `nums[i]` at index `i` scores a point if `nums[i] <= i`.
When we rotate the array by `k`, the index `i` changes to `(i - k + N) % N`.
We need to find a `k` that maximizes the points.
Brute force $O(N^2)$ will TLE because $N = 10^5$.
*Một số `nums[i]` tại chỉ số `i` ghi điểm nếu `nums[i] <= i`. Khi xoay mảng đi `k`, chỉ số `i` đổi thành `(i - k + N) % N`. Ta cần tìm `k` để tối đa hóa điểm số. Cách duyệt trâu $O(N^2)$ sẽ bị quá thời gian vì $N = 10^5$.*

### Range Analysis
### *Phân tích Khoảng*
For a fixed value `v = nums[i]`, what are the values of `k` such that `v` earns a point?
After rotation `k`, the new index is $i' = (i - k + N) \% N$.
Condition: $v \le (i - k + N) \% N$.
This condition holds for most values of `k`, except for a specific range where `v` "loses" its point.
Specifically, `v` earns a point if:
- If $i$ is the initial index, after rotating by $k$:
  - When $k=0$, index is $i$.
  - When $k$ increases, index decreases.
  - When $k=i+1$, index becomes $N-1$ (wraps around).
  - A point is lost when the index becomes less than $v$.
  - The range of $k$ where a point is **lost** for $nums[i]$ is easier to identify:
    $k$ should be in $[(i - v + 1 + N) \% N, (i + 1) \% N]$.
    Actually, it's easier to think about when $nums[i]$ **scores**:
    It scores when $k$ is in some intervals.
*Với một giá trị cố định `v = nums[i]`, `v` ghi điểm nếu $v \le i'$. Khi `k` tăng, chỉ số giảm dần. Một điểm bị mất khi chỉ số nhỏ hơn `v`. Thay vì đếm khi nào ghi điểm, ta đếm khi nào **mất điểm** cho từng `nums[i]`. Khoảng `k` bị mất điểm là $[(i - v + 1 + N) \% N, (i + 1) \% N]$.*

---

## 2. Strategy: Difference Array
## *2. Chiến lược: Mảng Hiệu (Difference Array)*

### Algorithm
### *Thuật toán*

1.  **Initialize Difference Array:** `bad[N]` to track points lost for each `k`.
    - Initial score for $k=0$ is easily calculated.
    - For each $i$, `nums[i]` loses its point when rotated by $k$ such that the new index $i'$ becomes $v-1$.
    - The point is regained when $i'$ wraps around to $N-1$.
    *   **Khởi tạo Mảng Hiệu:** `bad[N]` để theo dõi điểm bị mất cho mỗi `k`. Điểm số ban đầu cho $k=0$ được tính dễ dàng. Với mỗi $i$, `nums[i]` mất điểm khi xoay sao cho chỉ số mới là $v-1$ và lấy lại điểm khi chỉ số vòng lại $N-1$.*

2.  **Mark Intervals:**
    - For each `nums[i]`, it stays $\ge v$ until $k$ reaches $i - v + 1$ (if $i \ge v$) or something more complex with modulo.
    - Let's use the property: $nums[i]$ loses a point at $k = (i - nums[i] + 1 + N) \% N$.
    - It gains a point at $k = (i + 1) \% N$.
    - We can use a difference array `change[N]` to mark these transitions.
    - `change[k]--` when a point is lost, `change[k]++` when a point is gained.
    *   **Đánh dấu Khoảng:** Với mỗi `nums[i]`, nó mất điểm tại $k = (i - nums[i] + 1 + N) \% N$ và lấy lại điểm tại $k = (i + 1) \% N$. Dùng mảng hiệu `change[N]`: `change[k]--` khi mất điểm, `change[k]++` khi lấy lại điểm.*

3.  **Prefix Sum:**
    - Compute the prefix sums of `change` to get the net change for each `k`.
    - Compute the score for $k=0$ as the base.
    - Iterate through $k=1 \dots N-1$ updating the score and finding the maximum.
    *   **Cộng dồn:** Tính tổng tiền tố của `change` để biết thay đổi ròng cho mỗi `k`. Tính điểm cơ bản cho $k=0$. Duyệt qua các `k` tiếp theo để cập nhật điểm và tìm giá trị lớn nhất.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate through the array once to build the difference array, and once more to find the max.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for the difference array.
    *   **Độ phức tạp không gian:** $O(N)$ cho mảng hiệu.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `nums = [2,3,1,4,0]`
1. $k=0$: Scores: 2(ind 0) NO, 3(ind 1) NO, 1(ind 2) YES, 4(ind 3) NO, 0(ind 4) YES. Total = 2.
2. Marks:
   - For `nums[i]`, point lost at `(i - nums[i] + 1 + N) % N`.
   - `i=0, v=2`: lost at $(0-2+1+5)\%5 = 4$, gain at $(0+1)\%5=1$.
   - `i=1, v=3`: lost at $(1-3+1+5)\%5 = 4$, gain at $(1+1)\%5=2$.
   - `i=2, v=1`: lost at $(2-1+1+5)\%5 = 2$, gain at $(2+1)\%5=3$.
   - ...
3. Calculate prefix sums and update starting from 2.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The difference array approach is the standard optimal way for range updates or tracking point changes across rotations.
*Sử dụng mảng hiệu là cách tối ưu tiêu chuẩn để theo dõi sự thay đổi điểm số qua các vòng xoay.*
