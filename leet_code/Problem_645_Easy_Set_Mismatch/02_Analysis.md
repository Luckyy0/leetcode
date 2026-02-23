# Analysis for Set Mismatch
# *Phân tích cho bài toán Tập hợp Sai lệch*

## 1. Problem Essence & Deviation from Ideal
## *1. Bản chất vấn đề & Độ lệch so với Lý tưởng*

### The Challenge
### *Thách thức*
An array of $n$ elements should ideally contain integers from $1$ to $n$. We need to identify exactly which number was duplicated and which one was omitted.
*Một mảng gồm $n$ phần tử lý tưởng nhất nên chứa các số nguyên từ $1$ đến $n$. Chúng ta cần xác định chính xác số nào đã bị lặp lại và số nào đã bị bỏ sót.*

---

## 2. Strategy: In-place Marking (Negative Values)
## *2. Chiến lược: Đánh dấu tại chỗ (Giá trị Âm)*

Since all expected numbers are in the range $[1, n]$, we can use the indices of the array as a "visited" check.
*Vì tất cả các số dự kiến đều nằm trong phạm vi $[1, n]$, chúng ta có thể sử dụng các chỉ số của mảng như một cơ chế kiểm tra "đã ghé thăm".*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Duplicate Detection:** Iterate through the array. For each value `val = abs(nums[i])`:
    * **Phát hiện Trùng lặp:** Duyệt qua mảng. Với mỗi giá trị `val = abs(nums[i])`:*
    - Check the element at index `val - 1`.
    - If `nums[val - 1] < 0`, it means we've seen `val` before. So `val` is the **duplicate**.
    - If `nums[val - 1] > 0`, flip its sign to negative to mark it as visited: `nums[val - 1] *= -1`.

2.  **Missing Detection:** Iterate through the array a second time.
    * **Phát hiện Thiếu:** Duyệt qua mảng lần thứ hai.*
    - If `nums[i] > 0`, it means the number `i + 1` was never visited. So `i + 1` is the **missing** number.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Space Optimization:** This technique uses the existing array for state management, achieving $O(1)$ extra space.
    * **Tối ưu hóa Không gian:** Kỹ thuật này sử dụng mảng hiện có để quản lý trạng thái, đạt được không gian phụ trợ $O(1)$.*
*   **Alternative (XOR/Sum):** One could also use mathematical sums: `sum(nums) - sum(unique_nums) = duplicate`, and `sum(1..n) - sum(unique_nums) = missing`. However, in-place marking is often more elegant for large arrays.
    * **Giải pháp thay thế (XOR/Tổng):** Ta cũng có thể sử dụng các tổng toán học. Tuy nhiên, đánh dấu tại chỗ thường trang nhã hơn cho các mảng lớn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ where $N$ is the number of elements. We scan the array twice.
    * **Độ phức tạp thời gian:** $O(N)$ trong đó $N$ là số lượng phần tử.*
*   **Space Complexity:** $O(1)$ extra space (if we don't count the input array).
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [1, 2, 2, 4]
1. i=0, val=1: `nums[0]` is pos, flip: `[-1, 2, 2, 4]`.
2. i=1, val=2: `nums[1]` is pos, flip: `[-1, -2, 2, 4]`.
3. i=2, val=2: `nums[1]` is already negative. **Duplicate = 2**.
4. i=3, val=4: `nums[3]` is pos, flip: `[-1, -2, 2, -4]`.
5. Second pass: `nums[2]` is positive. **Missing = 3**.
**Result:** [2, 3].

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

In-place negation is a powerful trick for problems where values lie within the range of array indices. It allows you to encode boolean "visited" information directly into the data without allocating extra memory.
*Phép phủ định tại chỗ là một mẹo mạnh mẽ cho các bài toán mà giá trị nằm trong phạm vi của các chỉ số mảng. Nó cho phép bạn mã hóa thông tin "đã ghé thăm" trực tiếp vào dữ liệu.*
---
*Mọi sai lệch (Mismatch) đều để lại dấu vết. Trong sự sắp xếp của các con số, sự thừa thãi (Duplicate) của một kẻ này luôn đi kèm với sự trống vắng (Missing) của một kẻ khác. Dữ liệu dạy ta rằng bằng cách soi rọi vào từng vị trí (Index), ta có thể nhận diện được cả sự hiện diện quá mức lẫn sự biến mất thầm lặng để khôi phục lại trật tự ban đầu.*
Every deviation (Mismatch) leaves a trace. In the arrangement of numbers, the excess (Duplicate) of one always accompanies the absence (Missing) of another. Data teaches us that by scrutinizing each position (Index), we can identify both excessive presence and silent disappearance to restore the original order.
