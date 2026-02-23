# Analysis for Maximum Product Subarray
# *Phân tích cho bài toán Dãy con có tích lớn nhất*

## 1. Problem Essence & Complexity
## *1. Bản chất vấn đề & Độ phức tạp*

### Difference from Maximum Sum Subarray
### *Khác biệt với Dãy con có tổng lớn nhất*
In Kadane's algorithm for the maximum sum, we only track the `maxSoFar`. If the current sum becomes negative, we reset it to zero.
*Trong thuật toán Kadane cho tổng lớn nhất, chúng ta chỉ theo dõi `maxSoFar`. Nếu tổng hiện tại trở nên âm, chúng ta đặt lại nó về không.*

For **products**, the situation is more complex because:
1.  A very small negative number (e.g., -100) can become a very large positive number if multiplied by another negative number.
2.  A zero breaks the product sequence (resets everything to zero).
*Đối với phép **nhân**, tình hình phức tạp hơn vì: 1. Một số âm rất nhỏ (ví dụ: -100) có thể trở thành một số dương rất lớn nếu nhân với một số âm khác. 2. Số 0 làm đứt đoạn chuỗi tích (đưa mọi thứ về không).*

---

## 2. Approach: Dual Dynamic Programming
## *2. Hướng tiếp cận: Quy hoạch động kép*

### Strategy
### *Chiến lược*
At each index `i`, we maintain two values:
- `maxProduct`: The largest product ending at `i`.
- `minProduct`: The smallest product ending at `i`.
*Tại mỗi chỉ số `i`, chúng ta duy trì hai giá trị: `maxProduct` (tích lớn nhất kết thúc tại `i`) và `minProduct` (tích nhỏ nhất kết thúc tại `i`).*

### Transition Logic
### *Logic chuyển đổi*
When we move to the next number `nums[i]`:
1.  If `nums[i]` is **positive**, `maxProduct` stays big and `minProduct` stays small (or gets smaller).
2.  If `nums[i]` is **negative**, the potential `max` and `min` swap places. A previous `minProduct` (highly negative) multiplied by `nums[i]` could become the new `maxProduct`.
3.  If `nums[i]` is **zero**, both `max` and `min` reset to 0 at that position.
*Khi chúng ta chuyển sang số tiếp theo: 1. Nếu số dương, max vẫn lớn và min vẫn nhỏ. 2. Nếu số âm, max và min tiềm năng sẽ hoán đổi vị trí. 3. Nếu số 0, cả hai đều được đặt lại về 0.*

**Formula:**
- New `maxProduct` = `max(nums[i], maxProduct * nums[i], minProduct * nums[i])`
- New `minProduct` = `min(nums[i], maxProduct * nums[i], minProduct * nums[i])`

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Efficiency:** We only need to iterate through the array once ($O(N)$), and we only need constant extra space ($O(1)$) to store the running `max` and `min`.
    *Hiệu quả tối ưu: Chúng ta chỉ cần duyệt mảng một lần và chỉ tốn không gian hằng số để lưu trữ max và min đang chạy.*
*   **Robustness:** By tracking the `minProduct`, we effectively "store" the potential for a negative sign flip, which is the heart of the product problem.
    *Tính mạnh mẽ: Bằng cách theo dõi `minProduct`, chúng ta lưu trữ hiệu quả tiềm năng đảo ngược dấu âm, vốn là cốt lõi của bài toán nhân.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. A single pass through the array.
    *Độ phức tạp thời gian: $O(N)$. Một lần duyệt duy nhất qua mảng.*
*   **Space Complexity:** $O(1)$. We use variables to store `currentMax`, `currentMin`, and `globalMax`.
    *Độ phức tạp không gian: $O(1)$. Chúng ta sử dụng các biến để lưu trữ max hiện tại, min hiện tại và max toàn cục.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[2, 3, -2, 4]`

1.  `i = 0`: `num = 2`. `max = 2`, `min = 2`. `Global = 2`.
2.  `i = 1`: `num = 3`.
    - `curMax = max(3, 2*3, 2*3) = 6`.
    - `curMin = min(3, 2*3, 2*3) = 3`.
    - `Global = 6`.
3.  `i = 2`: `num = -2`.
    - `curMax = max(-2, 6*-2, 3*-2) = -2`.
    - `curMin = min(-2, 6*-2, 3*-2) = -12`.
    - `Global = 6`.
4.  `i = 3`: `num = 4`.
    - `curMax = max(4, -2*4, -12*4) = 4`.
    - `curMin = min(4, -2*4, -12*4) = -48`.
    - `Global = 6`.

**Result:** 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is a classic variation of the Maximum Subarray problem. The key trick to remember is the **swap** when a negative number is encountered. If you find the `max()` and `min()` with three arguments confusing, you can explicitly swap `currentMax` and `currentMin` whenever `nums[i] < 0` before doing the standard multiplication update. This ensures you are always building the largest possible value.
*Đây là một biến thể kinh điển của bài toán Dãy con lớn nhất. Thủ thuật then chốt cần ghi nhớ là việc **hoán đổi** khi gặp một số âm. Nếu bạn thấy việc dùng `max()` và `min()` với ba đối số khó hiểu, bạn có thể hoán đổi `currentMax` và `currentMin` bất cứ khi nào `nums[i] < 0` trước khi thực hiện cập nhật nhân tiêu chuẩn.*
---
*Số âm không chỉ là gánh nặng, đôi khi chúng là sự chuẩn bị âm thầm cho một cú bùng nổ vĩ đại hơn.*
Negative numbers are not just a burden, sometimes they are silent preparations for a greater explosion.
