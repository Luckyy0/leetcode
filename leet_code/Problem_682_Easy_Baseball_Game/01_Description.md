# Result for Baseball Game
# *Kết quả cho bài toán Trận bóng chày*

## Description
## *Mô tả*

You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
*Bạn đang ghi điểm cho một trận bóng chày với các quy tắc kỳ lạ. Khi bắt đầu trận đấu, bạn bắt đầu với một bản ghi trống.*

You are given a list of strings `operations`, where `operations[i]` is the $i^{th}$ operation you must apply to the record and is one of the following:
*Bạn được cho một danh sách các chuỗi `operations`, trong đó `operations[i]` là thao tác thứ $i$ bạn phải áp dụng vào bản ghi và là một trong các loại sau:*

1.  **An integer `x`:** Record a new score of `x`.
    *   *Một số nguyên `x`: Ghi một điểm mới là `x`.*
2.  **`'+'`:** Record a new score that is the sum of the previous two scores.
    *   *`'+'`: Ghi một điểm mới là tổng của hai điểm trước đó.*
3.  **`'D'`:** Record a new score that is double the previous score.
    *   *`'D'`: Ghi một điểm mới gấp đôi điểm ngay trước đó.*
4.  **`'C'`:** Invalidate the previous score, removing it from the record.
    *   *`'C'`: Hủy bỏ điểm ngay trước đó, loại bỏ nó khỏi bản ghi.*

Return the sum of all the scores on the record after applying all the operations.
*Hãy trả về tổng của tất cả các điểm trong bản ghi sau khi áp dụng tất cả các thao tác.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** ops = ["5","2","C","D","+"]
**Output:** 30
**Explanation:**
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.

## Example 2:
## *Ví dụ 2:*

**Input:** ops = ["5","-2","4","C","D","9","+","+"]
**Output:** 27

---

## Constraints:
## *Ràng buộc:*

*   `1 <= operations.length <= 1000`
*   `operations[i]` is `"C"`, `"D"`, `"+"`, or a string representing an integer in the range `[-3 * 10^4, 3 * 10^4]`.
*   For operation `"+"`, there will always be at least two previous scores on the record.
*   For operations `"C"` and `"D"`, there will always be at least one previous score on the record.
