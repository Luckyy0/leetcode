# Analysis for Maximum Subarray
# *Phân tích cho bài toán Mảng Con Lớn Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array `nums`. *Mảng `nums`.*
*   **Output:** Maximum sum of a contiguous subarray. *Tổng lớn nhất của một mảng con liên tiếp.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Length up to $10^5$. Linear time complexity $O(n)$ is required.
*   The array may contain negative numbers.
*   *Độ dài lên tới $10^5$. Độ phức tạp thời gian tuyến tính $O(n)$ là bắt buộc.*
*   *Mảng có thể chứa các số âm.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Kadane's Algorithm
### *Hướng tiếp cận: Thuật toán Kadane*

*   **Intuition:** At each position `i`, the maximum subarray sum ending at `i` is either `nums[i]` itself (if the previous sum was negative) or `nums[i] + max_ending_at_i-1`.
*   *Ý tưởng: Tại mỗi vị trí `i`, tổng mảng con lớn nhất kết thúc tại `i` là chính `nums[i]` (nếu tổng trước đó là âm) hoặc `nums[i] + tổng_lớn_nhất_tại_i-1`.*

*   **Algorithm Steps:**
    1.  Initialize `max_so_far` to the first element and `current_max` to the first element.
    2.  Iterate through the array from the second element:
        *   `current_max = max(nums[i], current_max + nums[i])`.
        *   `max_so_far = max(max_so_far, current_max)`.
    3.  Return `max_so_far`.

*   **Complexity:**
    *   Time: $O(n)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`
- `i=0`: current=-2, max=-2
- `i=1`: current=max(1, -2+1)=1, max=1
- `i=2`: current=max(-3, 1-3)=-2, max=1
- `i=3`: current=max(4, -2+4)=4, max=4
- `i=4`: current=max(-1, 4-1)=3, max=4
- `i=5`: current=max(2, 3+2)=5, max=5
- `i=6`: current=max(1, 5+1)=6, max=6
Result: 6.
---
Kadane's algorithm is efficient and simple.
*Thuật toán Kadane hiệu quả và đơn giản.*
