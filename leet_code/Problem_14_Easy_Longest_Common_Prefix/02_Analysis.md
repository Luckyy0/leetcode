# Analysis for Longest Common Prefix
# *Phân tích cho bài toán Tiền Tố Chung Dài Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of strings. *Mảng các chuỗi.*
*   **Output:** String (prefix). *Chuỗi (tiền tố).*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Array length 200. String length 200. Total characters $\approx 40,000$.
*   $O(S)$ where S is total characters is perfectly fine.
    *$O(S)$ với S là tổng số ký tự là hoàn toàn ổn.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Horizontal Scanning
### *Hướng tiếp cận: Quét Ngang*

*   **Intuition:** The prefix must be contained in the first string. So initialize `prefix = strs[0]`.
    *Ý tưởng: Tiền tố phải nằm trong chuỗi đầu tiên. Vậy khởi tạo `prefix = strs[0]`.*
*   Iterate through remaining strings. For each string `s`, update `prefix` to be the common part between `prefix` and `s`.
    *Duyệt qua các chuỗi còn lại. Với mỗi chuỗi `s`, cập nhật `prefix` thành phần chung giữa `prefix` và `s`.*
*   If `prefix` becomes empty, stop.
    *Nếu `prefix` trở thành rỗng, dừng lại.*

*   **Refinement:** To update `prefix`, use `while (str.indexOf(prefix) != 0) prefix = prefix.substring(0, prefix.length() - 1)`.
    *Tinh chỉnh: Để cập nhật `prefix`, sử dụng `while (str.indexOf(prefix) != 0) prefix = prefix.substring(0, prefix.length() - 1)`.*
    *   This gradually shortens the prefix until it fits.
    *   Điều này dần dần rút ngắn tiền tố cho đến khi nó phù hợp.*

*   **Complexity:**
    *   Time: $O(S)$. S = sum of all chars.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`["flower", "flow", "flight"]`
1.  `prefix = "flower"`.
2.  Next `s = "flow"`.
    *   `"flower"` not in `"flow"`. Shorten -> `"flowe"`.
    *   ... -> `"flow"`. Match! Prefix `"flow"`.
3.  Next `s = "flight"`.
    *   `"flow"` not in `"flight"`. Shorten -> `"flo"`.
    *   `"flo"` not in `"flight"`. Shorten -> `"fl"`.
    *   Match!
Result: "fl".
