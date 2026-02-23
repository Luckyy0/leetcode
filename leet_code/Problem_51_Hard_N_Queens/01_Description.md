# Result for N-Queens
# *Kết quả cho bài toán N-Queens*

## Description
## *Mô tả*

The **n-queens** puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.
*Bài toán **n-queens** là bài toán đặt `n` quân hậu trên một bàn cờ `n x n` sao cho không có hai quân hậu nào tấn công nhau.*

Given an integer `n`, return *all distinct solutions to the **n-queens puzzle***. You may return the answer in **any order**.
*Cho một số nguyên `n`, hãy trả về *tất cả các giải pháp riêng biệt cho **bài toán n-queens***. Bạn có thể trả về câu trả lời theo **bất kỳ thứ tự nào**.*

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.
*Mỗi giải pháp chứa một cấu hình bàn cờ riêng biệt về việc đặt n quân hậu, trong đó `'Q'` và `'.'` lần lượt biểu thị một quân hậu và một ô trống.*

## Example 1:
## *Ví dụ 1:*

**Input:** `n = 4`
**Output:** `[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]`
**Explanation:** There exist two distinct solutions to the 4-queens puzzle as shown above.

## Example 2:
## *Ví dụ 2:*

**Input:** `n = 1`
**Output:** `[["Q"]]`

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 9`
