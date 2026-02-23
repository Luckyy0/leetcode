# Analysis for K Empty Slots
# *Phân tích cho bài toán K Vị trí Trống*

## 1. Problem Essence & Reverse Mapping
## *1. Bản chất vấn đề & Ánh xạ Ngược*

### The Challenge
### *Thách thức*
The input tells us "which position turns on which day". To find a distance of $K$ between bulbs, it's easier to think in terms of "which day each position turns on". 
*Đầu vào cho chúng ta biết "vị trí nào bật vào ngày nào". Để tìm khoảng cách $K$ giữa các bóng đèn, sẽ dễ dàng hơn nếu ta tư duy theo kiểu "từng vị trí sẽ bật vào ngày nào".*

---

## 2. Strategy: Sliding Window on Days
## *2. Chiến lược: Cửa sổ trượt trên Ngày*

### Data Transformation
### *Chuyển đổi dữ liệu*
Convert the `bulbs` array into a `days` array where `days[x] = i` means the bulb at position `x` is turned on on day `i`.
*Chuyển đổi mảng `bulbs` thành mảng `days` trong đó `days[x] = i` có nghĩa là bóng đèn tại vị trí `x` được bật vào ngày `i`.*

### Logical Nuance
### *Sắc thái Logic*
We are looking for a pair of positions `left` and `right` such that:
1.  `right = left + k + 1`.
2.  All bulbs *between* `left` and `right` must be turned on **later** than both `left` and `right`.
    - i.e., For all $m \in (left, right)$, `days[m] > days[left]` AND `days[m] > days[right]`.

The day this configuration is completed is `max(days[left], days[right])`. We want the minimum of these days.
*Chúng ta tìm cặp vị trí `left` và `right` sao cho mọi bóng đèn ở giữa chúng đều bật **muộn hơn** cả `left` và `right`. Ngày hoàn thành cấu trúc này là ngày muộn nhất trong hai ngày `left` và `right`. Chúng ta cần tìm ngày sớm nhất trong số các ngày hoàn thành đó.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate with Window:** Initialize `left = 0`, `right = k + 1`.
2.  **Verify Inner Bulbs:** Iterate `i` from `left + 1` to `right - 1`.
    - If `days[i] < days[left]` or `days[i] < days[right]`:
        - The window is invalid because a bulb inside turned on too early.
        - Move the window: `left = i`, `right = i + k + 1`.
    - If `i == right`:
        - Success! A valid window is found.
        - Update `ans = min(ans, max(days[left], days[right]))`.
        - Move to the next potential window: `left = right`, `right = left + k + 1`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Efficiency:** Instead of checking all $O(N^2)$ pairs, the sliding window ensures each position is visited a constant number of times.
    * **Hiệu suất tuyến tính:** Thay vì kiểm tra tất cả các cặp, cửa sổ trượt đảm bảo mỗi vị trí chỉ được ghé thăm một số lần cố định.*
*   **Edge Case Handling:** If the window extends beyond array bounds, the search naturally ends.
    * **Xử lý Biên:** Nếu cửa sổ vượt quá giới hạn mảng, cuộc tìm kiếm tự động kết thúc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of bulbs. One pass to create `days`, one pass for sliding window.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ to store the `days` array.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**bulbs = [1, 3, 2], k = 1**
1. `days`: [1, 3, 2] (Indices 0, 1, 2 representing positions 1, 2, 3).
2. `left = 0, right = 2`.
3. `i = 1`: `days[1] = 3`. 
   - Is `days[1] > days[0]`? Yes (3 > 1).
   - Is `days[1] > days[2]`? Yes (3 > 2).
4. `i` reaches `right`. Valid window!
5. `ans = max(days[0], days[2]) = max(1, 2) = 2`.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always consider if a problem can be solved more easily by inverting the mapping (from "Day -> Pos" to "Pos -> Day"). The condition "nothing in between can happen before the boundaries" is a classic sliding window trigger.
*Luôn cân nhắc xem một bài toán có thể được giải quyết dễ dàng hơn bằng cách đảo ngược ánh xạ hay không. Điều kiện "không có gì ở giữa được phép xảy ra trước các biên" là một dấu hiệu điển hình của kỹ thuật cửa sổ trượt.*
---
*Ánh sáng (Bulbs) không chỉ rực rỡ bởi vị trí, mà còn bởi thời gian (Days). Trong hàng dài của những bóng đèn, sự vắng lặng của $K$ khoảng trống giữa hai điểm sáng là kết quả của một nhịp độ tinh tế. Dữ liệu dạy ta rằng bằng cách đảo ngược góc nhìn từ thời gian sang không gian (Reverse mapping) và trượt đi những khả năng (Sliding window), ta có thể tìm thấy khoảnh khắc đầu tiên của sự cân bằng.*
Light (Bulbs) is not only brilliant because of position, but also because of time (Days). In the long line of bulbs, the silence of $K$ gaps between two bright points is the result of a delicate rhythm. Data teaches us that by inverting the perspective from time to space (Reverse mapping) and sliding through possibilities (Sliding window), we can find the first moment of balance.
