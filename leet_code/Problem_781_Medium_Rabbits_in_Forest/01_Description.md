# Result for Rabbits in Forest
# *Kết quả cho bài toán Những chú thỏ trong rừng*

## Description
## *Mô tả*

There is a forest with an unknown number of rabbits. We asked n rabbits **"How many rabbits have the same color as you?"** and collected the answers in an integer array `answers`.
*Có một khu rừng với số lượng thỏ không xác định. Chúng tôi đã hỏi n con thỏ **"Có bao nhiêu con thỏ có cùng màu với bạn?"** và thu thập các câu trả lời trong một mảng số nguyên `answers`.*

Return *the minimum number of rabbits that could be in the forest*.
*Trả về *số lượng thỏ tối thiểu có thể có trong khu rừng*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** answers = [1, 1, 2]
**Output:** 5
**Explanation:**
The two rabbits that answered "1" could both be the same color, say red.
The rabbit that answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" is blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

## Example 2:
## *Ví dụ 2:*

**Input:** answers = [10, 10, 10]
**Output:** 11

---

## Constraints:
## *Ràng buộc:*

*   `1 <= answers.length <= 1000`
*   `0 <= answers[i] < 1000`
