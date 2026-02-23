# Analysis for Largest Number
# *Phân tích cho bài toán Số lớn nhất*

## 1. Problem Essence & Sorting Logic
## *1. Bản chất vấn đề & Logic sắp xếp*

### The Lexicographical Trap
### *Cạm bẫy từ điển*
If we sort the numbers based on their numerical value, we get `[10, 2] -> "102"`, which is wrong (210 is larger).
If we sort them as strings (lexicographical), we get `["3", "30"] -> "330"`, which works. But what about `["34", "3"]`? Lexicographically `"34" > "3"`, result `"343"`. Wait, `34` and `3` actually works both ways but `9` and `91`: `991` vs `919`.
*Nếu chúng ta sắp xếp các số dựa trên giá trị số của chúng, chúng ta có thể nhận được kết quả sai (ví dụ 102 thay vì 210). Nếu sắp xếp theo thứ tự từ điển, nó cũng chưa chắc đã đúng cho mọi trường hợp.*

### The Golden Rule: String Concatenation Comparison
### *Quy tắc vàng: So sánh chuỗi nối*
To determine if number `A` should come before `B`, we compare the two possible concatenations:
- `A + B`
- `B + A`
If `A + B` is larger than `B + A`, then `A` must come before `B`.
*Để xác định liệu số `A` nên đứng trước `B` hay không, chúng ta so sánh hai tổ hợp chuỗi có thể: `A + B` và `B + A`. Nếu `A + B` lớn hơn `B + A`, thì `A` phải đứng trước `B`.*

Example: `A = 3`, `B = 30`.
- `A + B = "330"`
- `B + A = "303"`
- Since `330 > 303`, the order is `[3, 30]`.

---

## 2. Approach: Custom Comparator Sorting
## *2. Hướng tiếp cận: Sắp xếp với bộ so sánh tùy chỉnh*

### Implementation Steps
### *Các bước triển khai*
1.  **Convert to Strings:** Convert all integers in `nums` into an array of strings.
2.  **Custom Sort:** Use a sorting algorithm (like QuickSort or MergeSort) with the custom comparator: `(s1, s2) -> (s2 + s1).compareTo(s1 + s2)`.
    - Note: We use `(s2 + s1).compareTo(s1 + s2)` for descending order (largest first).
3.  **Handle Edge Case:** If the sorted array starts with "0", it means all numbers were 0 or the largest is 0. Return "0" once, not "00...".
    *Xử lý trường hợp biên: Nếu mảng sau khi sắp xếp bắt đầu bằng "0", kết quả trả về là "0" thay vì "000".*
4.  **Join:** Use a `StringBuilder` to join all strings and return.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Mathematical Proof:** This comparison rule `(A+B > B+A)` is transitive. If `A` is better than `B`, and `B` is better than `C`, then `A` is guaranteed to be better than `C`. This makes it a valid sorting criterion.
    *Bằng chứng toán học: Quy tắc so sánh này có tính bắc cầu, do đó nó là một tiêu chí sắp xếp hợp lệ.*
*   **Arbitrary Large numbers:** By treating everything as strings and comparing concatenations, we avoid any overflow issues related to the massive magnitude of the final number.
    *Số lớn tùy ý: Bằng cách coi mọi thứ là chuỗi, chúng ta tránh được vấn đề tràn số.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N \times K)$, where $N$ is the count of numbers and $K$ is the average number of digits. The string concatenation and comparison inside the sort take $O(K)$.
    *Độ phức tạp thời gian: $O(N \log N \times K)$.*
*   **Space Complexity:** $O(N \times K)$. We need space to store the strings and the final result.
    *Độ phức tạp không gian: $O(N \times K)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[3, 30, 34, 5, 9]`

1.  Strings: `["3", "30", "34", "5", "9"]`
2.  Comparing `3` and `30`: `330 > 303` -> `3` before `30`.
3.  Comparing `34` and `3`: `343 > 334` -> `34` before `3`.
4.  Sorted List: `["9", "5", "34", "3", "30"]`
5.  Join: `"9534330"`

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

The "Largest Number" problem is a classic lesson in defining sorting criteria. Many students fail by trying to pad smaller numbers with zeros or identifying digit-by-digit patterns. The concatenation comparison `(A+B vs B+A)` is a robust, universal shortcut that bypasses all those edge cases. Don't forget the "all zeros" edge case, as it's a common failing point in LeetCode submissions.
*Bài toán "Số lớn nhất" là bài học kinh điển về việc xác định tiêu chí sắp xếp. Cách so sánh nối chuỗi `(A+B và B+A)` là một phím tắt mạnh mẽ và phổ quát. Đừng quên trường hợp biên "toàn số 0", vì đó là lỗi thường gặp nhất.*
---
*Khi thứ tự bị xáo trộn, sức mạnh không nằm ở giá trị riêng lẻ, mà nằm ở cách chúng hòa quyện và đứng cạnh nhau.*
When the order is shuffled, power lies not in individual values, but in how they blend and stand beside each other.
