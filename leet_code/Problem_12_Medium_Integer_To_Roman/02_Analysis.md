# Analysis for Integer to Roman
# *Phân tích cho bài toán Đổi Số Nguyên sang Số La Mã*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `num`. *Số nguyên `num`.*
*   **Output:** Roman numeral String. *Chuỗi số La Mã.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `num` up to 3999. *`num` lên tới 3999.*
*   We can hardcode values and symbols.
    *Chúng ta có thể mã hóa cứng các giá trị và ký hiệu.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Greedy with Predefined Arrays
### *Hướng tiếp cận: Tham lam với Mảng Định nghĩa trước*

*   **Intuition:** Convert from largest value to smallest.
    *Ý tưởng: Chuyển đổi từ giá trị lớn nhất đến nhỏ nhất.*
*   **Data Structures:**
    *   `values`: `[1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]`
    *   `symbols`: `["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]`
*   **Algorithm Steps:**
    1.  Initialize empty `StringBuilder`.
    2.  Loop through `values`.
    3.  While `num >= values[i]`:
        *   Subtract `values[i]` from `num`.
        *   Append `symbols[i]` to result.
    4.  Return result.

*   **Complexity:**
    *   Time: $O(1)$ (since num is bounded < 4000, fixed iterations).
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`num = 1994`
1.  Check 1000 ("M"): `1994 >= 1000`. Append "M", `num=994`.
2.  Check 900 ("CM"): `994 >= 900`. Append "CM", `num=94`.
3.  Check 500..100: Skip.
4.  Check 90 ("XC"): `94 >= 90`. Append "XC", `num=4`.
5.  Check 50..5: Skip.
6.  Check 4 ("IV"): `4 >= 4`. Append "IV", `num=0`.
Result: "MCMXCIV".
