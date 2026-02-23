# Result for Beautiful Arrangement II
# *Kết quả cho bài toán Sắp đặt Đẹp mắt II*

## Description
## *Mô tả*

Given two integers `n` and `k`, construct a list `answer` that contains `n` distinct integers from `1` to `n` and the following condition is true:
*Cho hai số nguyên `n` và `k`, hãy xây dựng một danh sách `answer` chứa `n` số nguyên phân biệt từ `1` đến `n` thỏa mãn điều kiện sau:*
- The list `[|answer[0] - answer[1]|, |answer[1] - answer[2]|, ..., |answer[n-2] - answer[n-1]|]` has exactly `k` distinct integers.
    - *Danh sách hiệu số trị tuyệt đối giữa các phần tử liên tiếp có đúng `k` số nguyên phân biệt.*

Return the list `answer`. If there are multiple valid answers, return any of them.
*Hãy trả về danh sách `answer`. Nếu có nhiều câu trả lời hợp lệ, hãy trả về bất kỳ cái nào trong số đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 3, k = 1
**Output:** [1,2,3]
**Explanation:** The [|1-2|, |2-3|] has exactly 1 distinct integer: 1.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 3, k = 2
**Output:** [1,3,2]
**Explanation:** The [|1-3|, |3-2|] has exactly 2 distinct integers: 1 and 2.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k < n <= 10^4`
