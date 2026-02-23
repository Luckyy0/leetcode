# Analysis for Plus One
# *Phân tích cho bài toán Cộng Một*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Array of digits. *Mảng các chữ số.*
*   **Output:** Array of digits after adding one. *Mảng các chữ số sau khi cộng một.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   The array can represent a very large number (up to 100 digits).
*   Adding one might cause a carry that ripples through all digits (e.g., `999` -> `1000`).
*   *Mảng có thể đại diện cho một con số rất lớn (lên tới 100 chữ số).*
*   *Việc cộng một có thể gây ra hiện tượng nhớ truyền qua tất cả các chữ số (ví dụ: `999` -> `1000`).*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Linear Scan from Right
### *Hướng tiếp cận: Duyệt tuyến tính từ bên phải*

*   **Intuition:** Start adding from the least significant digit (rightmost). If the digit is less than 9, just add one and return. If it's 9, it becomes 0 and the carry moves to the left.
*   *Ý tưởng: Bắt đầu cộng từ chữ số ít ý nghĩa nhất (ngoài cùng bên phải). Nếu chữ số đó nhỏ hơn 9, chỉ cần cộng một và trả về. Nếu nó là 9, nó trở thành 0 và số nhớ chuyển sang bên trái.*

*   **Algorithm Steps:**
    1.  Iterate `i` from `digits.length - 1` down to `0`:
        *   If `digits[i] < 9`:
            *   `digits[i]++`.
            *   Return `digits`.
        *   Else:
            *   `digits[i] = 0`.
    2.  If the loop finishes, it means we have a carry overflow (e.g., `999` became `000`).
    3.  Create a new array of size `length + 1`, set the first element to `1`, and return it.

*   **Complexity:**
    *   Time: $O(N)$.
    *   Space: $O(N)$ only if a new array is created, otherwise $O(1)$.

### Dry Run
### *Chạy thử*
`digits = [1, 9, 9]`
1. `i = 2`: `digits[2]` is 9. `digits[2] = 0`.
2. `i = 1`: `digits[1]` is 9. `digits[1] = 0`.
3. `i = 0`: `digits[0]` is 1. `digits[0] < 9`. `digits[0] = 2`. Return `[2, 0, 0]`.

`digits = [9, 9]`
1. `i = 1`: `digits[1] = 0`.
2. `i = 0`: `digits[0] = 0`.
3. Loop ends. New array `[1, 0, 0]`. Return.
---
*Việc xử lý số nhớ là chìa khóa của bài toán này.*
Handling the carry is the key to this problem.
