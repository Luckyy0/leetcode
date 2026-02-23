# Analysis for Gray Code
# *Phân tích cho bài toán Mã Gray*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n`. *Số nguyên `n`.*
*   **Output:** List of `2^n` integers forming a Gray code sequence. *Danh sách `2^n` số nguyên tạo thành chuỗi mã Gray.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Each pair of adjacent integers must differ by exactly one bit.
*   First and last integers must differ by exactly one bit (circular).
*   `n` is up to 16. $2^{16} = 65536$ elements.
*   *Mỗi cặp số nguyên liền kề phải khác nhau chính xác một bit.*
*   *Số nguyên đầu tiên và số nguyên cuối cùng phải khác nhau chính xác một bit (có tính tuần hoàn).*
*   *`n` lên đến 16. $2^{16} = 65536$ phần tử.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Formula-based or Reflection-based
### *Hướng tiếp cận: Dựa trên Công thức hoặc Phản xạ*

*   **Logic (Formula-based):**
    For any integer `i`, its Gray code can be calculated as `i XOR (i >> 1)`. 
    This is the most direct way to generate the sequence.
    *Đối với bất kỳ số nguyên `i` nào, mã Gray của nó có thể được tính là `i XOR (i >> 1)`. Đây là cách trực tiếp nhất để tạo ra chuỗi.*

*   **Logic (Reflection-based):**
    1.  Start with `n=0`: `[0]`.
    2.  For `n=1`: take `[0]`, reverse it to `[0]`, add `2^0` (which is 1) to the reversed part: `[0, 1]`.
    3.  For `n=2`: take `[0, 1]`, reverse it to `[1, 0]`, add `2^1` (which is 2) to the reversed part: `[0, 1, 3, 2]`.
    4.  Repeat until `n`.

*   **Algorithm Steps (Reflection):**
    1.  Initialize result list with `0`.
    2.  Loop `i` from `0` to `n-1`:
        *   `size = current size of result list`.
        *   `addBit = 1 << i`.
        *   Loop `j` from `size - 1` down to `0`:
            *   Add `result[j] + addBit` to the result list.
    3.  Return result.

*   **Complexity:**
    *   Time: $O(2^n)$.
    *   Space: $O(1)$ (excluding result list).

### Dry Run
### *Chạy thử*
`n = 2`
1. Start: `[0]`.
2. `i = 0, addBit = 1`:
   - `j = 0`: add `0 + 1 = 1`.
   - Result: `[0, 1]`.
3. `i = 1, addBit = 2`:
   - `j = 1`: add `1 + 2 = 3`.
   - `j = 0`: add `0 + 2 = 2`.
   - Result: `[0, 1, 3, 2]`.
Done.
---
*Mã Gray có đặc điểm đối xứng rất thú vị, cho phép chúng ta xây dựng chuỗi n-bit từ chuỗi (n-1)-bit bằng cách phản chiếu.*
Gray code has very interesting symmetry, allowing us to build the n-bit sequence from the (n-1)-bit sequence by reflection.
