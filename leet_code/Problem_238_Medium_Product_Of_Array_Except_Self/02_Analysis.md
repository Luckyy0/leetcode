# Analysis for Product of Array Except Self
# *Phân tích cho bài toán Tích của mảng ngoại trừ chính nó*

## 1. Problem Essence & Constraint Handling
## *1. Bản chất vấn đề & Xử lý ràng buộc*

### Challenge: No Division
### *Thách thức: Không dùng phép chia*
- With division: `ProductAll / nums[i]`. (Easy, except for `0` case).
- Without division: We must build the product from scratch.

### The Left-Right Decomposition
### *Phân rã Trái-Phải*
For any index `i`, the product except `nums[i]` is:
$$ (A[0] \cdot ... \cdot A[i-1]) \times (A[i+1] \cdot ... \cdot A[n-1]) $$
$$ Let's \ call \ this: \ PrefixProduct[i] \times SuffixProduct[i] $$
*Với bất kỳ chỉ số `i` nào, tích ngoại trừ `nums[i]` là tích của phần bên trái nhân với tích của phần bên phải.*

---

## 2. Approach: Two Pass (Prefix & Suffix)
## *2. Hướng tiếp cận: Hai lượt quét (Tiền tố & Hậu tố)*

### Logic (O(1) Space)
### *Logic (Không gian O(1))*
To achieve O(1) extra space (ignoring output array):
1.  **Pass 1 (Left to Right):**
    - Use `result` array to store **Prefix Products**.
    - `result[i]` will store product of `nums[0]...nums[i-1]`.
    - `result[0] = 1`.
2.  **Pass 2 (Right to Left):**
    - Maintain a variable `suffixProduct` (initially 1).
    - Multiply `result[i]` by `suffixProduct`.
    - Update `suffixProduct` by multiplying with `nums[i]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Dual Sweep:** Sweeping left accumulates past info. Sweeping right accumulates future info. Meeting at `i` gives the full context without self.
    *Quét kép: Quét trái tích lũy thông tin quá khứ. Quét phải tích lũy thông tin tương lai. Gặp nhau tại `i` cho ta ngữ cảnh đầy đủ mà không có bản thân.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Two passes.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (Constructing output array directly).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 3, 4]`
**Output Array:** `[?, ?, ?, ?]`

**Pass 1 (Left):**
- `i=0`: `res[0] = 1`.
- `i=1`: `res[1] = 1 * nums[0] = 1`.
- `i=2`: `res[2] = 1 * 2 = 2`.
- `i=3`: `res[3] = 2 * 3 = 6`.
**Array now:** `[1, 1, 2, 6]` (This is prefix product exclude self).

**Pass 2 (Right):** `R = 1`.
- `i=3`: `res[3] *= R` -> `6 * 1 = 6`. Update `R *= nums[3] (4)`. R=4.
- `i=2`: `res[2] *= R` -> `2 * 4 = 8`. Update `R *= nums[2] (3)`. R=12.
- `i=1`: `res[1] *= R` -> `1 * 12 = 12`. Update `R *= nums[1] (2)`. R=24.
- `i=0`: `res[0] *= R` -> `1 * 24 = 24`. Update `R *= nums[0] (1)`. R=24.

**Final:** `[24, 12, 8, 6]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

This is the standard algorithm for "Accumulating values from neighbors without checking self". Very useful pattern.
*Đây là thuật toán tiêu chuẩn cho việc "Tích lũy giá trị từ hàng xóm mà không tính bản thân". Mẫu rất hữu ích.*
---
*Để biết giá trị của mình trong một cộng đồng, đôi khi bạn cần nhìn vào tích của những người xung quanh (left * right), chứ không phải chia tách cộng đồng để cô lập bản thân (division).*
To know your value in a community, sometimes you need to look at the product of those around you, not divide the community to isolate yourself.
