# Analysis for Find the Index of the First Occurrence in a String
# *Phân tích cho bài toán Tìm Chỉ Số Của Lần Xuất Hiện Đầu Tiên trong Chuỗi*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Two strings `haystack`, `needle`. *Hai chuỗi `haystack`, `needle`.*
*   **Output:** Integer `index`. *Số nguyên `index`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   Lengths up to $10^4$.
*   $O(N \cdot M)$ brute force is $\approx 10^8$, might be slightly slow but usually passes for Easy problems in Java within 2s.
    *$O(N \cdot M)$ vét cạn là $\approx 10^8$, có thể hơi chậm nhưng thường vượt qua các bài toán Dễ trong Java trong vòng 2 giây.*
*   $O(N+M)$ (KMP) is better but strictly "Easy" problems often accept simpler solutions. I will implement a clean brute force (Sliding Window) to avoid KMP complexity unless necessary, or I can provide a manual sliding window without helper function.
    *$O(N+M)$ (KMP) tốt hơn nhưng các bài toán "Dễ" thường chấp nhận các giải pháp đơn giản hơn. Tôi sẽ triển khai vét cạn sạch (Cửa sổ trượt) để tránh độ phức tạp của KMP trừ khi cần thiết.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sliding Window (Brute Force)
### *Hướng tiếp cận: Cửa sổ trượt (Vét cạn)*

*   **Intuition:** Iterate through `haystack`. For each character, check if the substring starting there matches `needle`.
    *Ý tưởng: Duyệt qua `haystack`. Với mỗi ký tự, kiểm tra xem chuỗi con bắt đầu từ đó có khớp với `needle` hay không.*
*   **Algorithm Steps:**
    1.  Loops `i` from 0 to `haystack.length - needle.length`.
    2.  Check if `haystack[i...i+le - 1] == needle`.
    3.  If match, return `i`.
    4.  If no match found after loop, return `-1`.

*   **Complexity:**
    *   Time: $O(N \cdot M)$.
    *   Space: $O(1)$.

### Dry Run
### *Chạy thử*
`haystack = "sadbutsad"`, `needle = "sad"`
1.  `i=0`. Substring "sad" == "sad". Return 0.

`haystack = "leetcode"`, `needle = "leeto"`
1.  `i=0`. "leet" vs "leeto". Fail.
...
Return -1.
