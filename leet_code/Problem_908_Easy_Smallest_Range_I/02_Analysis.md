# Analysis for Smallest Range I
# *Phân tích cho bài toán Khoảng Nhỏ nhất I*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Minimize the difference between the minimum and maximum elements of an array after adding a value from $[-k, k]$ to each element.
*Giảm thiểu sự khác biệt giữa phần tử nhỏ nhất và lớn nhất của mảng sau khi thêm một giá trị từ $[-k, k]$ vào mỗi phần tử.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- To minimize the range `max - min`, we should try to:
  - Increase the minimum value `min(A)` as much as possible (add `+k`).
  - Decrease the maximum value `max(A)` as much as possible (add `-k`).
- The new minimum would be ideally `min(A) + k`.
- The new maximum would be ideally `max(A) - k`.
- The new range is `(max(A) - k) - (min(A) + k) = max(A) - min(A) - 2k`.
- However, the range cannot be negative. If `max(A) - min(A) <= 2k`, we can make all elements equal to some intermediate value, resulting in a range of 0.
*Để giảm thiểu khoảng `max - min`, ta nên cố gắng tăng giá trị nhỏ nhất lên nhiều nhất có thể (cộng `+k`) và giảm giá trị lớn nhất xuống nhiều nhất có thể (trừ `k`). Khoảng mới sẽ là `max(A) - min(A) - 2k`. Nếu kết quả này âm, nghĩa là ta có thể làm cho tất cả các phần tử bằng nhau (khoảng bằng 0).*

---

## 2. Strategy: Math
## *2. Chiến lược: Toán học*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Find Min and Max:** Iterate through `nums` to find `minVal` and `maxVal`.
    *   **Tìm Min và Max:** Duyệt qua mảng để tìm giá trị nhỏ nhất và lớn nhất.*

2.  **Calculate Difference:** `diff = maxVal - minVal`.
    *   **Tính hiệu:** `diff = maxVal - minVal`.*

3.  **Apply Logic:** Return `max(0, diff - 2 * k)`.
    *   **Áp dụng Logic:** Trả về `max(0, diff - 2 * k)`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int smallestRangeI(int[] nums, int k) {
    int minVal = nums[0];
    int maxVal = nums[0];
    
    for (int x : nums) {
        if (x < minVal) minVal = x;
        if (x > maxVal) maxVal = x;
    }
    
    int diff = maxVal - minVal;
    return Math.max(0, diff - 2 * k);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, one pass to find min/max.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple greedy math problem. Just compress the range from both ends by `k`.
*Bài toán toán học tham lam đơn giản. Chỉ cần nén khoảng từ cả hai đầu bằng `k`.*
