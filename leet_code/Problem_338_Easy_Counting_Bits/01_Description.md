# Result for Counting Bits
# *Kết quả cho bài toán Đếm Bit*

## Description
## *Mô tả*

Given an integer `n`, return *an array* `ans` *of length* `n + 1` *such that for each* `i` (`0 <= i <= n`), `ans[i]` *is the number of* `1`*'s in the binary representation of* `i`.
*Cho một số nguyên `n`, trả về *một mảng* `ans` *có độ dài* `n + 1` *sao cho với mỗi* `i` (`0 <= i <= n`), `ans[i]` *là số lượng số* `1` *trong biểu diễn nhị phân của* `i`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 2`
**Output:** `[0,1,1]`
**Explanation:**
0 --> 0
1 --> 1
2 --> 10

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 5`
**Output:** `[0,1,1,2,1,2]`
**Explanation:**
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

## Constraints:
## *Ràng buộc:*

*   `0 <= n <= 10^5`

**Follow up:**
*   It is very easy to come up with a solution with a runtime of `O(n log n)`. Can you do it in linear time `O(n)` and possibly in a single pass?
*   Can you do it without using any built-in function (i.e., like `__builtin_popcount` in C++)?
**Câu hỏi mở rộng:**
*   *Rất dễ để đưa ra một giải pháp với thời gian chạy là `O(n log n)`. Bạn có thể thực hiện nó trong thời gian tuyến tính `O(n)` và có thể trong một lần duyệt không?*
*   *Bạn có thể thực hiện nó mà không sử dụng bất kỳ hàm tích hợp nào không?*
