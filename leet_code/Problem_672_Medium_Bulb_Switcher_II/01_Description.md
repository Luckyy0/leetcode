# Result for Bulb Switcher II
# *Kết quả cho bài toán Bộ chuyển đổi Bóng đèn II*

## Description
## *Mô tả*

There is a room with `n` bulbs labeled from `1` to `n` that are all on initially. In the room, there are four buttons that can perform different operations on the bulbs:
*Có một căn phòng với `n` bóng đèn được đánh số từ `1` đến `n` ban đầu đều đang bật. Trong phòng, có bốn nút có thể thực hiện các thao tác khác nhau trên các bóng đèn:*

1.  **Button 1:** Flips the status of all the bulbs.
    *   *  **Nút 1:** Đảo ngược trạng thái của tất cả các bóng đèn.*
2.  **Button 2:** Flips the status of all the bulbs with even labels (i.e., 2, 4, ...).
    *   *  **Nút 2:** Đảo ngược trạng thái của tất cả các bóng đèn có nhãn chẵn (ví dụ: 2, 4, ...).*
3.  **Button 3:** Flips the status of all the bulbs with odd labels (i.e., 1, 3, ...).
    *   *  **Nút 3:** Đảo ngược trạng thái của tất cả các bóng đèn có nhãn lẻ (ví dụ: 1, 3, ...).*
4.  **Button 4:** Flips the status of all the bulbs with a label `3k + 1` (i.e., 1, 4, 7, ...).
    *   *  **Nút 4:** Đảo ngược trạng thái của tất cả các bóng đèn có nhãn dạng `3k + 1` (ví dụ: 1, 4, 7, ...).*

You are given `n` (the number of bulbs) and `m` (the number of operations you can perform).
*Bạn được cho `n` (số lượng bóng đèn) và `m` (số lượng thao tác bạn có thể thực hiện).*

Return the number of different possible statuses of the `n` bulbs that can be generated after performing exactly `m` operations.
*Hãy trả về số lượng trạng thái khác nhau có thể có của `n` bóng đèn sau khi thực hiện đúng `m` thao tác.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 1, m = 1
**Output:** 2
**Explanation:** Status can be: [on], [off].

## Example 2:
## *Ví dụ 2:*

**Input:** n = 2, m = 1
**Output:** 3
**Explanation:** Status can be: [off, off], [off, on], [on, off].

## Example 3:
## *Ví dụ 3:*

**Input:** n = 3, m = 1
**Output:** 4
**Explanation:** Status can be: [off, off, off], [off, on, off], [on, off, on], [off, on, on].

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 1000`
*   `0 <= m <= 1000`
