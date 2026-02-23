# Analysis for Shortest Subarray with Sum at Least K
# *Phân tích cho bài toán Mảng con Ngắn nhất có Tổng ít nhất K*

## 1. Problem Essence & Complexity
## *1. Bản chất vấn đề & Độ phức tạp*

### THE CHALLENGE
### *Thách thức*
We need to find the shortest contiguous subarray with a sum $\ge K$. Since `nums` can contain negative numbers, the standard sliding window approach (two pointers) does not work because the sum is not monotonic when moving the right pointer.
*Chúng ta cần tìm mảng con liên tiếp ngắn nhất có tổng $\ge K$. Vì `nums` có thể chứa các số âm, phương pháp cửa sổ trượt tiêu chuẩn (hai con trỏ) không hoạt động vì tổng không đơn điệu khi di chuyển con trỏ bên phải.*

---

## 2. Strategy: Prefix Sums with Monotonic Deque
## *2. Chiến lược: Tổng tiền tố với Hàng đợi hai đầu đơn điệu (Monotonic Deque)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Prefix Sum Array:** Create a `long` array `P` such that `P[i]` is the sum of the first `i` elements. The sum of a subarray `nums[i...j-1]` is `P[j] - P[i]`.
    *   **Mảng tổng tiền tố:** Tạo một mảng kiểu `long` `P` sao cho `P[i]` là tổng của `i` phần tử đầu tiên. Tổng của mảng con `nums[i...j-1]` là `P[j] - P[i]`.*

2.  **Maintaining a Deque:** Use a double-ended queue (`Deque`) to store indices of `P` in **monotonically increasing** order of their prefix sum values.
    *   **Duy trì Hàng đợi hai đầu:** Sử dụng một hàng đợi hai đầu (`Deque`) để lưu trữ các chỉ số của `P` theo thứ tự **tăng dần đơn điệu** của các giá trị tổng tiền tố.*

3.  **The Processing Logic:**
    - For each prefix sum `P[j]`:
    - **Update Result:** If `P[j] - P[deque.first()] >= K`, calculate length `j - deque.first()`, update `minResult`, and **remove `first`** (as any later subarray using this `first` will be longer).
    - **Maintain Monotonicity:** Before adding `j`, remove indices from the **back** of the deque if their prefix sum is $\ge$ `P[j]`. This is because a smaller prefix sum at a later index is always a better "starting point" for future subarrays.
    *   **Logic xử lý:** Với mỗi tổng tiền tố `P[j]`: Cập nhật kết quả: Nếu `P[j] - P[deque.first()] >= K`, tính độ dài, cập nhật `minResult`, và **xóa `first`** (vì bất kỳ mảng con sau này sử dụng `first` này đều sẽ dài hơn). Duy trì tính đơn điệu: Trước khi thêm `j`, hãy xóa các chỉ số từ **phía sau** của hàng đợi nếu tổng tiền tố của chúng $\ge$ `P[j]`. Điều này là do một tổng tiền tố nhỏ hơn ở một chỉ số sau này luôn là "điểm bắt đầu" tốt hơn cho các mảng con trong tương lai.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int shortestSubarray(int[] nums, int k) {
    int n = nums.length;
    long[] p = new long[n + 1];
    for (int i = 0; i < n; i++) p[i + 1] = p[i] + nums[i];
    
    int minLen = n + 1;
    Deque<Integer> deque = new LinkedList<>();
    
    for (int j = 0; j <= n; j++) {
        while (!deque.isEmpty() && p[j] - p[deque.peekFirst()] >= k) {
            minLen = Math.min(minLen, j - deque.pollFirst());
        }
        while (!deque.isEmpty() && p[j] <= p[deque.peekLast()]) {
            deque.pollLast();
        }
        deque.addLast(j);
    }
    return minLen <= n ? minLen : -1;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, as each index is added and removed from the deque at most once.
    *   **Độ phức tạp thời gian:** $O(N)$, vì mỗi chỉ số được thêm và xóa khỏi hàng đợi tối đa một lần.*
*   **Space Complexity:** $O(N)$ for prefix sum array and deque.
    *   **Độ phức tạp không gian:** $O(N)$ cho mảng tổng tiền tố và hàng đợi.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The combination of prefix sums and a monotonic deque is the definitive way to handle sliding window problems with non-monotonic properties (caused by negative numbers).
*Sự kết hợp giữa tổng tiền tố và hàng đợi hai đầu đơn điệu là cách giải quyết dứt điểm các bài toán cửa sổ trượt có tính chất không đơn điệu (gây ra bởi các số âm).*
