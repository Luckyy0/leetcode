# Analysis for Minimum Swaps To Make Sequences Increasing
# *Phân tích cho bài toán Số lần hoán đổi tối thiểu để tạo các chuỗi tăng dần*

## 1. Problem Essence & State Definition
## *1. Bản chất vấn đề & Định nghĩa Trạng thái*

### The Challenge
### *Thách thức*
At each index `i`, we can either swap `nums1[i]` and `nums2[i]` or not.
The choices at index `i` depend on the choices made at index `i-1`.
We need to find the sequence of choices (swap/no-swap) that minimizes the total count of swaps while maintaining the strictly increasing property for both arrays.
*Tại mỗi chỉ số `i`, chúng ta có thể hoán đổi `nums1[i]` và `nums2[i]` hoặc giữ nguyên. Lựa chọn tại `i` phụ thuộc vào lựa chọn tại `i-1`. Ta cần tìm chuỗi các lựa chọn sao cho tổng số lần hoán đổi là ít nhất mà vẫn đảm bảo cả hai mảng đều tăng dần nghiêm ngặt.*

---

## 2. Strategy: Dynamic Programming
## *2. Chiến lược: Quy hoạch động*

### DP States
### *Trạng thái DP*
We define two states for each index `i`:
1.  `keep[i]`: Minimum swaps up to index `i` such that we **did not** swap `nums1[i]` and `nums2[i]`.
2.  `swap[i]`: Minimum swaps up to index `i` such that we **did** swap `nums1[i]` and `nums2[i]`.
*Chúng ta định nghĩa hai trạng thái cho mỗi chỉ số `i`: `keep[i]` là số lần hoán đổi tối thiểu đến `i` nếu không hoán đổi tại `i`, và `swap[i]` là số lượng nếu có hoán đổi tại `i`.*

---

## 3. Transitions
## *3. Chuyển trạng thái*

There are two main conditions comparing index `i` and `i-1`:

**Condition 1: `nums1[i-1] < nums1[i]` and `nums2[i-1] < nums2[i]`**
This means if we made the same choice at `i` as at `i-1` (both swap or both keep), the sequence remains increasing.
- To `keep[i]`: `keep[i] = min(keep[i], keep[i-1])`
- To `swap[i]`: `swap[i] = min(swap[i], swap[i-1] + 1)`
*Điều kiện 1: Cấu trúc sẵn có đã tăng dần. Nếu giữ nguyên cách chọn cũ (cùng đổi hoặc cùng không), mảng vẫn tăng.*

**Condition 2: `nums1[i-1] < nums2[i]` and `nums2[i-1] < nums1[i]`**
This means if we made different choices at `i` and `i-1` (one swap, one keep), the sequence remains increasing.
- To `keep[i]`: `keep[i] = min(keep[i], swap[i-1])`
- To `swap[i]`: `swap[i] = min(swap[i], keep[i-1] + 1)`
*Điều kiện 2: Tráo đổi chéo vẫn tăng dần. Nếu đổi cách chọn (một đổi, một không), mảng vẫn tăng.*

*Note: Both conditions can be true simultaneously.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate through the arrays once.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$. We only need to store the values for the previous index.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

DP with constant space is the optimal way to solve this. Ensure base cases are initialized correctly (`keep[0] = 0`, `swap[0] = 1`).
*Sử dụng DP với không gian hằng số là cách tối ưu. Lưu ý khởi tạo giá trị cơ bản `keep[0] = 0`, `swap[0] = 1`.*
