# Analysis for Sort Colors
# *Phân tích cho bài toán Sắp Xếp Màu Sắc*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of 0s, 1s, and 2s. *Mảng gồm các số 0, 1 và 2.*
*   **Output:** Sorted array in-place. *Mảng đã sắp xếp tại chỗ.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   One-pass algorithm.
*   $O(1)$ extra space.
*   *Thuật toán một lần duyệt.*
*   *Không gian bổ sung $O(1)$.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Dutch National Flag (Three-Way Partitioning)
### *Hướng tiếp cận: Lá cờ Hà Lan (Phân vùng 3 chiều)*

*   **Intuition:** Maintain three pointers: `low`, `mid`, and `high`. 
    *   `0` to `low-1`: All Red (0s).
    *   `low` to `mid-1`: All White (1s).
    *   `mid` to `high`: Unknown.
    *   `high+1` to `N-1`: All Blue (2s).
*   *Ý tưởng: Duy trì ba con trỏ: `low`, `mid`, và `high`.*
    *   *Từ `0` đến `low-1`: Toàn màu Đỏ (0).*
    *   *Từ `low` đến `mid-1`: Toàn màu Trắng (1).*
    *   *Từ `mid` đến `high`: Chưa xác định.*
    *   *Từ `high+1` đến `N-1`: Toàn màu Xanh (2).*

*   **Algorithm Steps:**
    1.  `low = 0`, `mid = 0`, `high = n - 1`.
    2.  While `mid <= high`:
        *   If `nums[mid] == 0`: swap `nums[mid]` and `nums[low]`, `low++`, `mid++`.
        *   If `nums[mid] == 1`: `mid++`.
        *   If `nums[mid] == 2`: swap `nums[mid]` and `nums[high]`, `high--`. (Don't increment `mid` yet because the swapped value from `high` is unknown).

*   **Complexity:**
    *   Time: $O(N)$ (one pass).
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[2,0,1]`
1. `low=0, mid=0, high=2`.
2. `nums[mid]=2`: Swap `nums[0], nums[2]`. Array: `[1, 0, 2]`. `high=1`.
3. `nums[mid]=1`: `mid=1`.
4. `nums[mid]=0`: Swap `nums[1], nums[0]`. Array: `[0, 1, 2]`. `low=1, mid=2`.
5. `mid > high`. Stop.
---
*Thuật toán này cực kỳ hiệu quả vì nó sắp xếp mảng chỉ trong một lần duyệt mà không cần bộ nhớ phụ.*
This algorithm is extremely efficient as it sorts the array in a single pass without auxiliary memory.
