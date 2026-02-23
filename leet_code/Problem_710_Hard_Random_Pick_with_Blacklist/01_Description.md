# Result for Random Pick with Blacklist
# *Kết quả cho bài toán Chọn Ngẫu nhiên với Danh sách Đen*

## Description
## *Mô tả*

You are given an integer `n` and an array of **unique** integers `blacklist`. Design an algorithm to pick a random integer in the range `[0, n - 1]` that is **not** in `blacklist`. Any integer that is not in `blacklist` should be equally likely to be returned.
*Bạn được cho một số nguyên `n` và một mảng các số nguyên **duy nhất** `blacklist`. Hãy thiết kế một thuật toán để chọn một số nguyên ngẫu nhiên trong khoảng `[0, n - 1]` mà **không** nằm trong `blacklist`. Mọi số nguyên không nằm trong `blacklist` đều phải có xác suất xuất hiện như nhau.*

Optimize your algorithm such that it minimizes the number of calls to the built-in random function.
*Hãy tối ưu hóa thuật toán của bạn sao cho giảm thiểu số lần gọi hàm ngẫu nhiên có sẵn.*

Implement the `Solution` class:
*   `Solution(int n, int[] blacklist)` Initializes the object with the integer `n` and the blacklisted integers `blacklist`.
*   `int pick()` Returns a random integer in the range `[0, n - 1]` and not in `blacklist`.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
[[7, [2, 3, 5]], [], [], [], [], [], [], []]
**Output:** [null, 0, 4, 1, 6, 1, 0, 4]
**Explanation:**
Solution solution = new Solution(7, [2, 3, 5]);
solution.pick(); // return 0, 4, 1, or 6 (randomly)

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 10^9`
*   `0 <= blacklist.length <= min(10^5, n - 1)`
*   `0 <= blacklist[i] < n`
*   All the values of `blacklist` are **unique**.
*   At most `2 * 10^4` calls will be made to `pick`.
