# Analysis for Single Element in a Sorted Array
# *Phân tích cho bài toán Phần tử Đơn lẻ trong Mảng Đã sắp xếp*

## 1. Problem Essence & Binary Search
## *1. Bản chất vấn đề & Tìm kiếm Nhị phân*

### The Challenge
### *Thách thức*
Finding the unique element in $O(\log N)$.
- Sorted array implies we can use Binary Search.
- Pairs structure: `[1, 1, 2, 2, 3, 4, 4]`.
- Index property:
    - Before the single element: Pairs are at `(even, odd)` indices. `nums[2k] == nums[2k+1]`.
    - After the single element: Pairs are shifted. `nums[2k] != nums[2k+1]` (actually `nums[2k] == nums[2k-1]`).

### Strategy: Binary Search on Evens
### *Chiến lược: Tìm kiếm Nhị phân trên các số Chẵn*

1.  **Midpoint:** Calculate `mid`. Ensure `mid` is even (start of a potential pair). If `mid` is odd, `mid--`.
2.  **Compare:** Check `nums[mid]` vs `nums[mid+1]`.
    - If `nums[mid] == nums[mid+1]`: The pair is intact. The single element is to the **Right**. `low = mid + 2`.
    - If `nums[mid] != nums[mid+1]`: The pattern is broken. The single element is either at `mid` or to the **Left**. `high = mid`.
3.  **Result:** `nums[low]` (or `nums[high]`).

---

## 2. Approach: Binary Search Pair Check
## *2. Hướng tiếp cận: Kiểm tra Cặp Tìm kiếm Nhị phân*

### Logic
### *Logic*
(See above). Note the `high` bound initialization. The array length is always odd. `high = len - 1`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Time:** Efficient index manipulation.
    *Thời gian Logarithmic: Thao tác chỉ số hiệu quả.*
*   **Space O(1):** No recursion needed.
    *Không gian O(1): Không cần đệ quy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$.
    *Độ phức tạp thời gian: $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 1, 2, 3, 3]`. (Single is 2 at idx 2).
1. `l=0, h=4`.
2. `mid = 2`. Even.
3. Check `nums[2] (2)` vs `nums[3] (3)`. Not equal.
4. Broken pattern means single is left or current. `h = 2`.
5. `l=0, h=2`. `mid = 1`. Make even -> `mid=0`.
6. Check `nums[0] (1)` vs `nums[1] (1)`. Equal.
7. Valid pattern. Single is right. `l = 0 + 2 = 2`.
8. `l=2, h=2`. Return `nums[2]`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Binary Search checking `nums[even] == nums[even+1]`.
*Tìm kiếm nhị phân kiểm tra `nums[even] == nums[even+1]`.*
---
*Trong một thế giới có đôi có cặp (pairs), kẻ cô đơn (single element) chính là người phá vỡ nhịp điệu. Trước khi họ xuất hiện, mọi thứ đều tuân theo quy luật chẵn-lẻ (even-odd). Sau khi họ đi qua, trật tự bị đảo lộn. Chỉ cần tìm điểm gãy (break point), ta sẽ tìm thấy kẻ ấy.*
In a paired world (Pairs), the single person (Single Element) is the one who breaks the rhythm. Before they appear, everything follows the even-odd rule (Even-Odd). After they pass, the order is upset. Just find the break point (Break Point), we will find that person.
