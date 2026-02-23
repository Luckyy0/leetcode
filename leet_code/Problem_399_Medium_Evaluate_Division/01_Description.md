# Result for Evaluate Division
# *Kết quả cho bài toán Tính toán Phép chia*

## Description
## *Mô tả*

You are given an array of variable pairs `equations` and an array of real numbers `values`, where `equations[i] = [Ai, Bi]` and `values[i]` represent the equation `Ai / Bi = values[i]`. Each `Ai` or `Bi` is a string that represents a single variable.
*Bạn được cho một mảng các cặp biến `equations` và một mảng các số thực `values`, trong đó `equations[i] = [Ai, Bi]` và `values[i]` đại diện cho phương trình `Ai / Bi = values[i]`. Mỗi `Ai` hoặc `Bi` là một chuỗi đại diện cho một biến duy nhất.*

You are also given some `queries`, where `queries[j] = [Cj, Dj]` represents the $j^{th}$ query where you must find the answer for `Cj / Dj = ?`.
*Bạn cũng được cho một số `queries`, trong đó `queries[j] = [Cj, Dj]` đại diện cho truy vấn thứ $j$ mà bạn phải tìm câu trả lời cho `Cj / Dj = ?`.*

Return *the answers to all queries*. If a single answer cannot be determined, return `-1.0`.
*Trả về *câu trả lời cho tất cả các truy vấn*. Nếu một câu trả lời không thể xác định được, hãy trả về `-1.0`.*

**Note:** The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
*Lưu ý: Đầu vào luôn hợp lệ. Bạn có thể giả định rằng việc tính toán các truy vấn sẽ không dẫn đến phép chia cho 0 và không có mâu thuẫn.*

## Example 1:
## *Ví dụ 1:*

**Input:** `equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]`
**Output:** `[6.00000,0.50000,-1.00000,1.00000,-1.00000]`
**Explanation:** 
Given: a / b = 2.0, b / c = 3.0
Queries: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

## Constraints:
## *Ràng buộc:*

*   `1 <= equations.length <= 20`
*   `equations[i].length == 2`
*   `Ai.length, Bi.length <= 5`
*   `values.length == equations.length`
*   `0.0 < values[i] <= 20.0`
*   `1 <= queries.length <= 20`
*   `queries[i].length == 2`
*   `Cj.length, Dj.length <= 5`
*   `Ai, Bi, Cj, Dj` consist of lowercase English letters and digits.
