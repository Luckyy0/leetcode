# Analysis for Restore IP Addresses
# *Phân tích cho bài toán Khôi Phục Địa Chỉ IP*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String of digits `s`. *Chuỗi các chữ số `s`.*
*   **Output:** List of all valid IP addresses. *Danh sách tất cả các địa chỉ IP hợp lệ.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   IP has 4 blocks.
*   Each block: 0-255, no leading zero (except "0").
*   Total length: 4 to 12.
*   *IP có 4 khối.*
*   *Mỗi khối: 0-255, không có số 0 ở đầu (ngoại trừ "0").*
*   *Tổng độ dài: 4 đến 12.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Backtracking
### *Hướng tiếp cận: Quay lui*

*   **Logic:**
    1.  Recursively split the string into 4 segments.
    2.  For each segment, try lengths 1, 2, and 3.
    3.  Validate segment:
        *   If length > 1 and starts with '0', invalid.
        *   If value > 255, invalid.
    4.  Base case: If we have 4 segments and reached the end of the string, join them with '.' and add to result.
    5.  Pruning: If remaining characters are more than what 4 segments can hold (12) or less than needed (4), stop.

*   **Complexity:**
    *   Time: $O(3^4)$ which is constant since the depth is fixed at 4 and branches at 3.
    *   Space: $O(1)$ excluding the result list (fixed recursion depth).

### Dry Run
### *Chạy thử*
`s = "25525511135"`
1. Block 1: "2", "25", "255".
2. If Block 1 is "255":
   - Block 2 can be "2", "25", "255".
   - If Block 2 is "255":
     - Block 3 can be "1", "11", "111".
     - ... and so on.
---
*Việc kiểm tra điều kiện không có số 0 ở đầu là lỗi thường gặp nhất.*
Checking the leading zero condition is the most common mistake.
