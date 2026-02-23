# Analysis for Smallest Range II
# *Phân tích cho bài toán Khoảng Nhỏ nhất II*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Minimize the difference between the maximum and minimum elements of an array, where for each element `x`, we must choose either `x + k` or `x - k`.
*Giảm thiểu sự khác biệt giữa phần tử lớn nhất và nhỏ nhất của mảng, trong đó với mỗi phần tử `x`, ta phải chọn `x + k` hoặc `x - k`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- First, sort the array `A`. Let the sorted elements be $A[0], A[1], \dots, A[n-1]$.
- Small elements should be increased (pick $+k$), and large elements should be decreased (pick $-k$) to bring them closer.
- There must be a division point (pivot) index `i` such that:
  - All elements $A[0 \dots i]$ are increased ($+k$).
  - All elements $A[i+1 \dots n-1]$ are decreased ($-k$).
- Why? If we increase a larger element and decrease a smaller element, we likely widen the gap or don't help close it efficiently compared to the pivot strategy.
- For a specific pivot `i`:
  - The new values for the left part are $A[0]+k \dots A[i]+k$.
  - The new values for the right part are $A[i+1]-k \dots A[n-1]-k$.
  - The potential maximums are $A[i]+k$ (largest of increased set) and $A[n-1]-k$ (largest of decreased set).
  - The potential minimums are $A[0]+k$ (smallest of increased set) and $A[i+1]-k$ (smallest of decreased set).
  - New range = $\max(A[i]+k, A[n-1]-k) - \min(A[0]+k, A[i+1]-k)$.

*Đầu tiên, sắp xếp mảng. Các phần tử nhỏ nên được tăng lên, các phần tử lớn nên được giảm xuống. Sẽ có một điểm chia `i` sao cho mọi phần tử bên trái `i` đều cộng `k`, và bên phải `i` đều trừ `k`. Với mỗi điểm chia, tính phạm vi mới và tìm giá trị nhỏ nhất.*

---

## 2. Strategy: Sorting + Linear Scan
## *2. Chiến lược: Sắp xếp + Quét Tuyến tính*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Sort `A`.**
    *   **Sắp xếp `A`.**

2.  **Initialize Result:** `ans = A[n-1] - A[0]`. (This corresponds to increasing everything or decreasing everything).
    *   **Khởi tạo kết quả:** Hiệu số ban đầu (tương đương với việc tăng tất cả hoặc giảm tất cả).*

3.  **Iterate Pivot `i`:** From `0` to `n-2`.
    - Consider splitting between `i` and `i+1`.
    - Left part ends at `i` (add `k`). Right part starts at `i+1` (subtract `k`).
    - `high = max(A[n-1] - k, A[i] + k)`.
    - `low = min(A[0] + k, A[i+1] - k)`.
    - `ans = min(ans, high - low)`.
    *   **Duyệt điểm chia `i`:** Tính `high` và `low` mới. Cập nhật `ans`.*

4.  **Return `ans`.**
    *   **Trả về `ans`.**

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int smallestRangeII(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    int ans = nums[n - 1] - nums[0];
    
    for (int i = 0; i < n - 1; i++) {
        int a = nums[i];
        int b = nums[i + 1];
        
        int high = Math.max(nums[n - 1] - k, a + k);
        int low = Math.min(nums[0] + k, b - k);
        
        ans = Math.min(ans, high - low);
    }
    
    return ans;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting. The scan is $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(1)$ or $O(\log N)$ for sorting stack.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting allows us to reduce the problem to finding a single optimal split point where all elements to the left go up and all elements to the right go down.
*Việc sắp xếp cho phép ta quy bài toán về việc tìm một điểm chia tối ưu duy nhất, nơi tất cả các phần tử bên trái đi lên và tất cả các phần tử bên phải đi xuống.*
