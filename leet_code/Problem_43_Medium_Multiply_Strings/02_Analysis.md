# Analysis for Multiply Strings
# *Phân tích cho bài toán Nhân Chuỗi*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two strings `num1`, `num2`. *Hai chuỗi `num1`, `num2`.*
*   **Output:** Product as a string. *Tích dưới dạng chuỗi.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Lengths up to 200. $200 \cdot 200 = 40,000$ operations.
*   No direct string to int conversion.
*   The product of a number of length `M` and a number of length `N` has a maximum length of `M + N`.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Elementary Multiplication Simulation
### *Hướng tiếp cận: Mô phỏng Phép nhân Tiểu học*

*   **Intuition:** We multiply each digit of `num1` by each digit of `num2` and place the result in the corresponding position in the output array.
*   *Ý tưởng: Chúng ta nhân từng chữ số của `num1` với từng chữ số của `num2` và đặt kết quả vào vị trí tương ứng trong mảng đầu ra.*

*   **Algorithm Steps:**
    1.  Initialize an integer array `pos` of size `num1.length() + num2.length()`.
    2.  Iterate through `num1` from right to left (`i = len1 - 1 to 0`).
    3.  Iterate through `num2` from right to left (`j = len2 - 1 to 0`).
    4.  Multiply `digit1` and `digit2`.
    5.  Calculate position indices: `p1 = i + j`, `p2 = i + j + 1`.
    6.  Calculate `sum = mult + pos[p2]`.
    7.  Update `pos[p2] = sum % 10`, `pos[p1] += sum / 10`.
    8.  Convert the `pos` array to a string, skipping leading zeros.

*   **Complexity:**
    *   Time: $O(N \cdot M)$.
    *   Space: $O(N + M)$.

### Dry Run
### *Chạy thử*
`num1 = "12", num2 = "10"`
1.  `pos = [0, 0, 0, 0]`.
2.  `i=1 (2), j=1 (0)`: `mult = 0`. `p1=2, p2=3`. `pos[3]=0, pos[2]=0`.
3.  `i=1 (2), j=0 (1)`: `mult = 2`. `p1=1, p2=2`. `pos[2]=2, pos[1]=0`.
4.  `i=0 (1), j=1 (0)`: `mult = 0`. `p1=1, p2=2`. `pos[2]=2, pos[1]=0`.
5.  `i=0 (1), j=0 (1)`: `mult = 1`. `p1=0, p2=1`. `pos[1]=1, pos[0]=0`.
Result: `[0, 1, 2, 0]` -> "120".
