# Result for Super Egg Drop
# *Kết quả cho bài toán Thả Trứng Siêu đẳng*

## Description
## *Mô tả*

You are given `k` identical eggs and you have access to a building with `n` floors labeled from `1` to `n`.
*Bạn được cho `k` quả trứng giống hệt nhau và bạn có quyền truy cập vào một tòa nhà có `n` tầng được đánh số từ `1` đến `n`.*

There exists a floor `f` (`0 <= f <= n`) such that any egg dropped at a floor higher than `f` will break, and any egg dropped at or below floor `f` will not break.
*Tồn tại một tầng `f` (`0 <= f <= n`) sao cho bất kỳ quả trứng nào thả ở tầng cao hơn `f` sẽ vỡ, và bất kỳ quả trứng nào thả ở tầng `f` hoặc thấp hơn sẽ không vỡ.*

Each move, you can take an unbroken egg and drop it from any floor `x` (`1 <= x <= n`).
*Mỗi bước, bạn có thể lấy một quả trứng chưa vỡ và thả nó từ bất kỳ tầng `x` nào (`1 <= x <= n`).*

Your goal is to know **with certainty** what the value of `f` is.
*Mục tiêu của bạn là biết **chắc chắn** giá trị của `f` là bao nhiêu.*

Return *the minimum number of moves that you need (in a worst-case scenario) to determine `f` with certainty*.
*Hãy trả về *số lượng bước di chuyển tối thiểu mà bạn cần (trong trường hợp xấu nhất) để xác định `f` một cách chắc chắn*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** k = 1, n = 2
**Output:** 2
**Explanation:** 
Drop the egg from floor 1. If it breaks, we know f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.

## Example 2:
## *Ví dụ 2:*

**Input:** k = 2, n = 6
**Output:** 3

## Example 3:
## *Ví dụ 3:*

**Input:** k = 3, n = 14
**Output:** 4

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= 100`
*   `1 <= n <= 10^4`
