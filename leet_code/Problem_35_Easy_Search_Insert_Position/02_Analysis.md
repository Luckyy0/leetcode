# Analysis for Search Insert Position
# *Phân tích cho bài toán Tìm Vị Trí Chèn*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Sorted array `nums`, `target`. *Mảng đã sắp xếp `nums`, `target`.*
*   **Output:** Index. *Chỉ số.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `O(log n)` required.
*   Distinct values (simplifies things).

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Binary Search
### *Hướng tiếp cận: Tìm kiếm Nhị phân*

*   **Intuition:** Standard Binary Search.
    *   If `target` found, return `mid`.
    *   If not found, `low` will eventually be the insertion point because the loop terminates when `low > high`, and `low` is the index of the first element greater than target (or `n` if all are smaller).
    *   *Ý tưởng: Tìm kiếm Nhị phân chuẩn. Nếu tìm thấy `target`, trả về `mid`. Nếu không, `low` cuối cùng sẽ là điểm chèn vì vòng lặp kết thúc khi `low > high`, và `low` là chỉ số của phần tử đầu tiên lớn hơn target (hoặc `n` nếu tất cả đều nhỏ hơn).*

*   **Algorithm Steps:**
    1.  `low = 0`, `high = n - 1`.
    2.  While `low <= high`:
        *   `mid = ...`.
        *   If `nums[mid] == target`, return `mid`.
        *   If `nums[mid] < target`, `low = mid + 1`.
        *   Else `high = mid - 1`.
    3.  Return `low`.

*   **Complexity:**
    *   Time: $O(\log N)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`[1,3,5,6]`, target 2.
1.  L=0, H=3. Mid=1 (3).
    *   `3 > 2`. H -> 0.
2.  L=0, H=0. Mid=0 (1).
    *   `1 < 2`. L -> 1.
3.  L=1, H=0. Stop. Return L (1). Correct.
