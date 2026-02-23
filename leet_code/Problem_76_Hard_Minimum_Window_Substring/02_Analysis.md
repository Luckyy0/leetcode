# Analysis for Minimum Window Substring
# *Phân tích cho bài toán Chuỗi Con Cửa Sổ Tối Thiểu*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** Strings `s` and `t`. *Hai chuỗi `s` và `t`.*
*   **Output:** Minimum window substring containing all chars of `t`. *Chuỗi con cửa sổ tối thiểu chứa tất cả các ký tự của `t`.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `s` and `t` up to $10^5$. Time complexity must be $O(M + N)$.
*   Must account for char frequencies (duplicates in `t`).
*   Case sensitive.
*   *`s` và `t` lên đến $10^5$. Độ phức tạp thời gian phải là $O(M + N)$.*
*   *Phải tính đến tần suất ký tự (các ký tự trùng lặp trong `t`).*
*   *Phân biệt chữ hoa chữ thường.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Sliding Window
### *Hướng tiếp cận: Cửa sổ Trượt*

*   **Intuition:** Use two pointers (`left` and `right`) to define a window. Expand `right` until the window contains all chars of `t`. Then contract `left` as much as possible while maintaining the condition. Track the minimum length window.
*   *Ý tưởng: Sử dụng hai con trỏ (`left` và `right`) để xác định một cửa sổ. Mở rộng `right` cho đến khi cửa sổ chứa tất cả các ký tự của `t`. Sau đó thu hẹp `left` nhiều nhất có thể trong khi vẫn duy trì điều kiện. Theo dõi cửa sổ có độ dài tối thiểu.*

*   **Algorithm Steps:**
    1.  Create frequency map for strings in `t`.
    2.  `left = 0, right = 0`. Use another map for chars in the current window.
    3.  `required = count of unique chars in t`, `formed = 0`.
    4.  While `right < s.length()`:
        *   Add `s[right]` to window. If its count matches its frequency in `t`, `formed++`.
        *   While `formed == required`:
            *   Update `minWindow` if current window is smaller.
            *   Remove `s[left]` from window. If its count falls below needed frequency, `formed--`.
            *   `left++`.
        *   `right++`.
    5.  Return `minWindow`.

*   **Complexity:**
    *   Time: $O(M + N)$.
    *   Space: $O(K)$ where $K$ is character set size (52 for English letters).

### Dry Run
### *Chạy thử*
`s = "ADOBECODEBANC", t = "ABC"`
1. `right` moves to `C` (index 5): "ADOBEC". Window has A, B, C. `min = "ADOBEC"`.
2. `left` moves forward: "DOBEC" (no A), stop contracting.
3. `right` moves: ... "CODEBA". Window has A, B, C. `min = "CODEBA"`.
4. `left` moves: "ODEBA", "DEBA", "EBA", "BA", "BANC". Update `min = "BANC"`.
---
*Kỹ thuật cửa sổ trượt với hai con trỏ là cách tối ưu nhất để giải quyết các bài toán về chuỗi con.*
Sliding window with two pointers is the most optimal way to solve substring problems.
