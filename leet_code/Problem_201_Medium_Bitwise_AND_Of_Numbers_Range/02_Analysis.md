# Analysis for Bitwise AND of Numbers Range
# *Phân tích cho bài toán Bitwise AND của một khoảng số*

## 1. Problem Essence & Bitwise Properties
## *1. Bản chất vấn đề & Tính chất Bitwise*

### The Naive Trap
### *Cạm bẫy ngây thơ*
Iterating from `left` to `right` and performing AND operations will fail (Time Limit Exceeded) because the range can be up to $2^{31}$. We need an $O(\log N)$ or $O(1)$ solution.
*Việc lặp từ `left` đến `right` và thực hiện phép AND sẽ thất bại (Vượt quá giới hạn thời gian) vì khoảng có thể lên tới $2^{31}$. Chúng ta cần một giải pháp $O(\log N)$ hoặc $O(1)$.*

### The Logic of Change
### *Logic của sự thay đổi*
Consider the binary transition from `left` to `right`.
- `5`: `1 0 1`
- `6`: `1 1 0`
- `7`: `1 1 1`
Result: `1 0 0` (4).
*Xem xét sự chuyển đổi nhị phân từ `left` sang `right`. Kết quả là 4.*

Notice that as we increment numbers, the bits flip from right to left.
- If a bit position flips at least once in the range `[left, right]`, the AND result for that position will be `0`.
- Only the **Common Left Header (Common Prefix)** of `left` and `right` remains unchanged. All bits to the right of this prefix will eventually encounter a `0` in the sequence.
*Lưu ý rằng khi chúng ta tăng các số, các bit sẽ lật từ phải sang trái. Nếu một vị trí bit lật ít nhất một lần trong khoảng, kết quả AND cho vị trí đó sẽ là `0`. Chỉ có **Phần đầu chung bên trái** của `left` và `right` là không thay đổi. Tất cả các bit bên phải của tiền tố này cuối cùng sẽ gặp số `0` trong chuỗi.*

---

## 2. Approach: Shift to Find Common Prefix
## *2. Hướng tiếp cận: Dịch bit để tìm tiền tố chung*

### Algorithm Steps
### *Các bước thuật toán*
We want to find the most significant bits that are identical in both `left` and `right`.
1.  Shift both `left` and `right` to the right (`>> 1`) until they become equal.
    - Keep track of how many shifts we performed (`shiftcount`).
2.  When `left == right`, we have found the common prefix.
3.  Shift the result back to the left (`<< shiftcount`) to fill the remaining positions with zeros.

*Chúng ta muốn tìm các bit quan trọng nhất giống nhau ở cả `left` và `right`. 1. Dịch cả hai sang phải cho đến khi chúng bằng nhau. Đếm số lần dịch. 2. Khi chúng bằng nhau, đó là tiền tố chung. 3. Dịch kết quả ngược lại sang trái để điền các số 0 vào các vị trí còn lại.*

### Alternative: Brian Kernighan's Algorithm
### *Cách thay thế: Thuật toán Brian Kernighan*
While `left < right`:
- `right = right & (right - 1)`
- This removes the lowest set bit of `right`. We keep doing this until `right` is less than or equal to `left`.
- Finally return `right & left` (which will be `right`).
*Trong khi `left < right`, loại bỏ bit 1 thấp nhất của `right`. Tiếp tục làm vậy cho đến khi `right` nhỏ hơn hoặc bằng `left`.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Logarithmic Efficiency:** The loop runs at most 32 times (for a 32-bit integer).
    *Hiệu quả Logarit: Vòng lặp chạy tối đa 32 lần.*
*   **Space Optimal:** Uses constant extra space.
    *Tối ưu không gian: Sử dụng không gian phụ hằng số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ (specifically $O(32)$).
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `left = 5 (101)`, `right = 7 (111)`

1.  `5 != 7`. Shift both right.
    - `left` -> `2 (10)`
    - `right` -> `3 (11)`
    - `shifts` = 1
2.  `2 != 3`. Shift both right.
    - `left` -> `1 (1)`
    - `right` -> `1 (1)`
    - `shifts` = 2
3.  `1 == 1`. Stop.
4.  Result: `1 << 2` = `100` (Binary) = `4`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is a classic bit manipulation problem. The key insight is realizing that "ANDing" a range effectively wipes out any bits that change. The only bits that survive are the static prefix. The "Shift Right until Equal" method is the most intuitive implementation.
*Đây là bài toán thao tác bit kinh điển. Nhận thức cốt lõi là phép "AND" một khoảng sẽ xóa sạch bất kỳ bit nào thay đổi. Chỉ các bit tiền tố tĩnh mới tồn tại. Phương pháp "Dịch phải cho đến khi bằng nhau" là cách triển khai trực quan nhất.*
---
*Trong một dòng chảy liên tục thay đổi, chỉ những giá trị cốt lõi (tiền tố) mới có thể trụ vững đến cùng.*
In a continuously changing flow, only the core values (prefixes) can withstand to the end.
