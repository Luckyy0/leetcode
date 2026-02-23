# Analysis for Monotonic Array
# *Phân tích cho bài toán Mảng Đơn điệu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Check if an array is either entirely non-increasing or entirely non-decreasing.
*Kiểm tra xem một mảng có hoàn toàn không tăng hoặc hoàn toàn không giảm hay không.*

### KEY LOGIC
### *Logic chính*
We can track two boolean flags: `isIncreasing` and `isDecreasing`.
- Initialize both to `true`.
- Iterate through the array.
- If `nums[i] > nums[i+1]`, then it cannot be increasing. Set `isIncreasing = false`.
- If `nums[i] < nums[i+1]`, then it cannot be decreasing. Set `isDecreasing = false`.
- If both become `false`, return `false` immediately.
*Chúng ta có thể theo dõi hai cờ boolean: `isIncreasing` và `isDecreasing`. Khởi tạo cả hai là `true`. Duyệt qua mảng. Nếu `nums[i] > nums[i+1]`, nó không thể tăng. Nếu `nums[i] < nums[i+1]`, nó không thể giảm. Nếu cả hai đều `false`, trả về `false` ngay lập tức.*

---

## 2. Strategy: Two Flags One Pass
## *2. Chiến lược: Hai cờ Một lần duyệt*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Flags:** `inc = true`, `dec = true`.
    *   **Khởi tạo Cờ:** `inc = true`, `dec = true`.*

2.  **Iterate:** Loop `i` from 0 to `n-2`.
    - If `nums[i] > nums[i+1]`, `inc = false`.
    - If `nums[i] < nums[i+1]`, `dec = false`.
    *   **Duyệt:** Quét qua các cặp lân cận. Nếu giảm -> không thể là mảng tăng. Nếu tăng -> không thể là mảng giảm.*

3.  **Return:** `inc || dec`.
    *   **Trả về:** `inc || dec`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public boolean isMonotonic(int[] nums) {
    boolean increasing = true;
    boolean decreasing = true;
    
    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            increasing = false;
        }
        if (nums[i] < nums[i + 1]) {
            decreasing = false;
        }
    }
    
    return increasing || decreasing;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of elements.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using two boolean flags is the most straightforward and readable approach. It covers all cases (strict, non-strict, flat) correctly.
*Sử dụng hai cờ boolean là cách tiếp cận trực quan và dễ đọc nhất. Nó bao gồm tất cả các trường hợp (nghiêm ngặt, không nghiêm ngặt, bằng phẳng) một cách chính xác.*
