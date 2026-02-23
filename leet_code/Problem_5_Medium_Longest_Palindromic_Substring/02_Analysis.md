# Analysis for Longest Palindromic Substring
# *Phân tích cho bài toán Chuỗi Con Đối Xứng Dài Nhất*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s`. *Chuỗi `s`.*
*   **Output:** The longest substring that reads the same forwards and backwards. *Chuỗi con dài nhất đọc xuôi ngược như nhau.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `s.length <= 1000`. This suggests an $O(N^2)$ algorithm is acceptable. ($1000^2 = 10^6$ operations).
    *`s.length <= 1000`. Điều này gợi ý rằng thuật toán $O(N^2)$ là chấp nhận được. ($1000^2 = 10^6$ phép tính).*
*   $O(N^3)$ (Brute Force checking all substrings) might TLE.
    *$O(N^3)$ (Vét cạn kiểm tra mọi chuỗi con) có thể bị quá thời gian (TLE).*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Expand Around Center (Optimal in Practice covering O(N^2))
### *Hướng tiếp cận: Mở rộng Quanh Tâm (Tối ưu trong thực tế, bao phủ O(N^2))*

*   **Intuition:** A palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only $2n - 1$ such centers.
    *Ý tưởng: Một chuỗi đối xứng phản chiếu qua tâm của nó. Do đó, một chuỗi đối xứng có thể được mở rộng từ tâm, và chỉ có $2n - 1$ tâm như vậy.*
    *   Example: "aba" center is 'b'. "abba" center is space between 'b's.
        *Ví dụ: "aba" tâm là 'b'. "abba" tâm là khoảng giữa hai chữ 'b'.*

*   **Algorithm Steps:**
    1.  Loop through each character `i` in `s` (from `0` to `n-1`). *Duyệt qua từng ký tự `i` trong `s` (từ `0` đến `n-1`).*
    2.  Check for odd-length palindromes: `expand(i, i)`. *Kiểm tra chuỗi đối xứng độ dài lẻ: `expand(i, i)`.*
    3.  Check for even-length palindromes: `expand(i, i+1)`. *Kiểm tra chuỗi đối xứng độ dài chẵn: `expand(i, i+1)`.*
    4.  Update the maximum length and starting position found so far. *Cập nhật độ dài tối đa và vị trí bắt đầu tìm thấy cho đến nay.*
    5.  Return the substring starting from `start` with length `maxLen`. *Trả về chuỗi con bắt đầu từ `start` với độ dài `maxLen`.*

*   **Complexity:**
    *   Time: $O(N^2)$. *Thời gian: $O(N^2)$.*
    *   Space: $O(1)$. We use variables to store indices. *Không gian: $O(1)$. Chúng ta sử dụng biến để lưu trữ chỉ số.*

### Dry Run
### *Chạy thử*
`s = "babad"`

1.  `i=0 ('b')`.
    *   Expand `b`: "b". Len 1.
    *   Expand `ba`: No match.
2.  `i=1 ('a')`.
    *   Expand `a`: "bab" (left 'b' == right 'b'). "aba" would fail (index out). Len 3. Max updated.
    *   Expand `ab`: No match.
3.  `i=2 ('b')`.
    *   Expand `b`: "aba". Len 3. (Current max already 3, keep "bab" or update depending on logic).
    *   Expand `bd`: "bd" no match.
4.  Result: "bab".

## 3. Alternative (Dynamic Programming)
## *3. Thay thế (Quy hoạch động)*

*   We can use a 2D boolean table `dp[i][j]` true if `s[i..j]` is palindrome.
    *Chúng ta có thể dùng bảng 2D boolean `dp[i][j]` đúng nếu `s[i..j]` là chuỗi đối xứng.*
*   Space complexity $O(N^2)$. "Expand Around Center" uses $O(1)$ space, so it's often preferred for space efficiency.
    *Độ phức tạp không gian $O(N^2)$. "Mở rộng Quanh Tâm" dùng không gian $O(1)$, nên thường được ưu tiên về hiệu quả không gian.*
