# Analysis for Count and Say
# *Phân tích cho bài toán Đếm và Nói*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Integer `n`. *Số nguyên `n`.*
*   **Output:** String `result`. *Chuỗi `result`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `n` up to 30.
*   Sequence length grows but stays manageable for `n=30`.

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Iterative Simulation (Run-Length Encoding)
### *Hướng tiếp cận: Mô phỏng Lặp (Mã hóa Độ dài Chạy)*

*   **Intuition:** Start with "1". Apply the transformation `n-1` times.
    *Ý tưởng: Bắt đầu với "1". Áp dụng chuyển đổi `n-1` lần.*
*   **Transformation Logic:**
    *   Iterate through the string.
    *   Count consecutive identical characters.
    *   Append count, then character to new string.
    *   Repeat.
*   **Algorithm Steps:**
    1.  `s = "1"`.
    2.  Loop from 2 to `n`:
        *   `sb = new StringBuilder()`
        *   Loop through `s`:
            *   Count identical chars `c`.
            *   `sb.append(count).append(c)`.
        *   `s = sb.toString()`.
    3.  Return `s`.

*   **Complexity:**
    *   Time: $O(M)$ where M is total characters generated.
    *   Space: $O(M)$.

### Dry Run
### *Chạy thử*
`n=4`.
1.  `s="1"`.
2.  `i=2`. Scan "1". Count=1. `sb="11"`. `s="11"`.
3.  `i=3`. Scan "11". Count=2. `sb="21"`. `s="21"`.
4.  `i=4`. Scan "21".
    *   '2': count 1. `sb="12"`.
    *   '1': count 1. `sb="1211"`.
    *   `s="1211"`.
Result "1211".
