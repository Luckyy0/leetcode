# Result for Profitable Schemes
# *Kết quả cho bài toán Các kế hoạch Có lợi*

## Description
## *Mô tả*

There is a group of `n` members, and a list of various crimes they could commit. The `i`-th crime generates a `profit[i]` and requires `group[i]` members to participate in it. If a member participates in one crime, that member can't participate in another crime.
*Có một nhóm gồm `n` thành viên và một danh sách các tội phạm khác nhau mà họ có thể thực hiện. Tội phạm thứ `i` tạo ra lợi nhuận `profit[i]` và yêu cầu `group[i]` thành viên tham gia. Nếu một thành viên tham gia vào một tội phạm, thành viên đó không thể tham gia vào một tội phạm khác.*

A **profitable scheme** is a subset of crimes such that the total number of members involved is at most `n`, and the total profit generated is at least `minProfit`.
*Một **kế hoạch có lợi** là một tập con các tội phạm sao cho tổng số thành viên tham gia tối đa là `n` và tổng lợi nhuận tạo ra ít nhất là `minProfit`.*

Return *the number of schemes that can be chosen*. Since the answer may be very large, **return it modulo `10^9 + 7`**.
*Hãy trả về *số lượng các kế hoạch có thể được chọn*. Vì câu trả lời có thể rất lớn, hãy **trả về kết quả theo modulo `10^9 + 7`**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 5, minProfit = 3, group = [2,2], profit = [2,3]
**Output:** 2
**Explanation:** To make a profit of at least 3, the group could either commit just the second crime, or both crimes.
In total, there are 2 schemes.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
**Output:** 7
**Explanation:** To make a profit of at least 5, the group could commit any single crime, any two crimes, or all three crimes.
In total, there are 7 schemes.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 100`
*   `0 <= minProfit <= 100`
*   `1 <= group.length <= 100`
*   `group.length == profit.length`
*   `1 <= group[i] <= 100`
*   `0 <= profit[i] <= 100`
