# Analysis for Count Binary Substrings
# *Phân tích cho bài toán Đếm Chuỗi con Nhị phân*

## 1. Problem Essence & Local Grouping
## *1. Bản chất vấn đề & Nhóm Cục bộ*

### The Challenge
### *Thách thức*
We need to count substrings that have an equal number of `0`s and `1`s, with the strict condition that all `0`s are together and all `1`s are together (e.g., `0011` is okay, but `0101` is not). 
*Chúng ta cần đếm các chuỗi con có số lượng `0` và `1` bằng nhau, với điều kiện khắt khe là các số giống nhau phải nằm cạnh nhau. Ví dụ: `0011` được chấp nhận, nhưng `0101` thì không.*

---

## 2. Strategy: Group Count Comparison
## *2. Chiến lược: So sánh Số lượng Nhóm*

Instead of checking $O(N^2)$ substrings, we can observe that valid substrings only occur at the boundary between a block of `0`s and a block of `1`s.
*Thay vì kiểm tra tất cả các chuỗi con, ta thấy rằng các chuỗi hợp lệ chỉ xuất hiện tại ranh giới giữa một khối `0` và một khối `1`.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Count Consecutive Blocks:** Iterate through the string and count the lengths of consecutive identical characters.
    - String `"00110011"` becomes `[2, 2, 2, 2]`.
    - String `"10101"` becomes `[1, 1, 1, 1, 1]`.
    * **Đếm các Khối Liên tiếp:** Duyệt qua chuỗi và đếm độ dài của các nhóm ký tự giống nhau liên tiếp.*

2.  **Calculate Substrings at Boundaries:** Between two adjacent blocks of sizes `prev` and `curr`, the number of valid centered substrings is `min(prev, curr)`.
    - For example, if we have `000` (size 3) followed by `11` (size 2), we can form:
        - `01`
        - `0011`
        - Total = $\min(3, 2) = 2$.
    * **Tính toán tại Ranh giới:** Giữa hai khối liền kề có kích thước `prev` và `curr`, số lượng chuỗi con hợp lệ là `min(prev, curr)`.*

3.  **Summation:** Sum all these `min` values as you scan through the blocks.
    * **Phép cộng:** Cộng tất cả các giá trị `min` này lại.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Pass:** We only need to store the current group length and the previous group length. This allows us to solve the problem in a single pass with $O(1)$ extra space (excluding the input string).
    * **Duyệt tuyến tính:** Chúng ta chỉ cần lưu độ dài nhóm hiện tại và nhóm trước đó, giúp tối ưu không gian.*
*   **Intuition:** This approach effectively reduces a string pattern matching problem into a simple arithmetic accumulation based on run-length encoding.
    * **Trực giác:** Phương pháp này chuyển đổi bài toán khớp mẫu chuỗi thành việc tính toán số học đơn giản dựa trên mã hóa độ dài chạy.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$ if we only keep track of the last two group counts.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**s = "00110"**
1. Group 1 ('0'): count = 2. `prev = 0, curr = 2`.
2. Transition to '1'.
3. Group 2 ('1'): count = 2. `prev = 2, curr = 2`.
   - Result += min(2, 2) = 2.
4. Transition to '0'.
5. Group 3 ('0'): count = 1. `prev = 2, curr = 1`.
   - Result += min(2, 1) = 1.
**Total:** 2 + 1 = 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Pattern detection is often easier when looking at "transitions" rather than "windows." By focusing on the switch from `0` to `1` or vice versa, we can leverage the block-size property to count exponentially growing substrings in linear time.
*Việc phát hiện mẫu thường dễ dàng hơn khi nhìn vào các "điểm chuyển tiếp". Bằng cách tập trung vào sự thay đổi từ `0` sang `1` hoặc ngược lại, chúng ta có thể đếm các chuỗi con trong thời gian tuyến tính.*
---
*Sự đối lập (Binary) tạo nên nhịp điệu khi các khối được sắp đặt cạnh nhau. Trong dòng chảy của các bit, sự công bằng (Equal count) chỉ nảy nở tại ranh giới của sự khác biệt (Transition). Dữ liệu dạy ta rằng bằng cách đo lường độ dài của từng khối đồng nhất (Group counts) và chọn lấy phần cốt lõi tối thiểu (Min), ta có thể tìm thấy sự cân bằng hoàn hảo trong một cấu trúc nhị phân.*
Opposition (Binary) creates rhythm when blocks are arranged side by side. In the flow of bits, fairness (Equal count) only blooms at the boundary of difference (Transition). Data teaches us that by measuring the length of each uniform block (Group counts) and choosing the minimum core (Min), we can find the perfect balance in a binary structure.
