# Analysis for Find First and Last Position of Element in Sorted Array
# *Phân tích cho bài toán Tìm Vị Trí Đầu Tiên và Cuối Cùng của Phần Tử trong Mảng Đã Sắp Xếp*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Sorted array `nums`. Integer `target`. *Mảng đã sắp xếp `nums`. Số nguyên `target`.*
*   **Output:** Array `[start, end]`. *Mảng `[start, end]`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `O(log n)` required.
*   Two Binary Searches needed (one for left, one for right).

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Twice Binary Search
### *Hướng tiếp cận: Tìm kiếm Nhị phân Hai lần*

*   **Intuition:**
    *   To find the first occurrence (left bound): Standard BS, but when `nums[mid] == target`, don't stop. Move `high` to `mid - 1` and record `mid` as candidate.
    *   To find the last occurrence (right bound): Standard BS, but when `nums[mid] == target`, move `low` to `mid + 1` and record `mid` as candidate.
    *   *Để tìm lần xuất hiện đầu tiên (giới hạn trái): BS chuẩn, nhưng khi `nums[mid] == target`, không dừng lại. Di chuyển `high` về `mid - 1` và ghi nhận `mid` là ứng viên.*
    *   *Để tìm lần xuất hiện cuối cùng (giới hạn phải): BS chuẩn, nhưng khi `nums[mid] == target`, di chuyển `low` về `mid + 1` và ghi nhận `mid` là ứng viên.*

*   **Algorithm Steps:**
    1.  `findLeft(nums, target)`:
        *   `res = -1`. `low`, `high`.
        *   While `low <= high`:
            *   `mid`.
            *   If `nums[mid] >= target`: `high = mid - 1`. If `==` update `res = mid`.
            *   Else: `low = mid + 1`.
        *   WAIT, correct logic for strict Left:
            *   If `nums[mid] == target`: `res = mid`, `high = mid - 1` (keep searching left).
            *   If `nums[mid] < target`: `low = mid + 1`.
            *   If `nums[mid] > target`: `high = mid - 1`.
    2.  `findRight(nums, target)`:
        *   Similar, but if `==`, `res = mid`, `low = mid + 1` (keep searching right).
    3.  Return `[left, right]`.

*   **Complexity:**
    *   Time: $O(\log N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[5, 7, 7, 8, 8, 10]`, target 8.
1.  Left Search:
    *   Mid (8). Record 3. High -> 2.
    *   Left Part ... Found nothing. Return 3.
2.  Right Search:
    *   Mid (8). Record 3. Low -> 4.
    *   Next Mid (8 at idx 4). Record 4. Low -> 5.
    *   Next Mid (10). Too big. High -> 4.
    *   Low > High. Return 4.
Result `[3, 4]`.
