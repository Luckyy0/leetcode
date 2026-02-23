# Height Checker
# *Người Kiểm Tra Chiều Cao*

## Description
## *Mô tả*

A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in **non-decreasing order** by height. Let this ordering be represented by the integer array `expected` where `expected[i]` is the expected height of the `ith` student in line.
*Một ngôi trường đang cố gắng tổ chức chụp bức ảnh kỷ yếu thường niên cho toàn bộ học sinh. Các học sinh được yêu cầu phải tự giác đứng xếp hàng thành một hàng dọc duy nhất theo **thứ tự chiều cao không giảm** (từ thấp đến cao). Hãy gọi thứ tự đứng chuẩn xác như mong đợi này là một mảng số nguyên `expected`, trong đó `expected[i]` biểu diễn khoảng cách tầm vóc chiều cao lý tưởng đáng lẽ phải có của cậu học sinh đứng ở vị trí thứ `i` trong hàng.*

You are given an integer array `heights` representing the **current order** that the students are standing in. Each `heights[i]` is the height of the `ith` student in line (0-indexed).
*Bạn được cung cấp một mảng số nguyên `heights` phơi bày ra **vị trí đứng hiện tại thực tế** lộn xộn mà đám học sinh đang nhốn nháo đứng. Mỗi thông số `heights[i]` phản chiếu chiều cao của cô cậu học sinh hiện đang đứng bưng bít ở vị trí thứ `i` trong hàng (chỉ số tính từ 0).*

Return the **number of indices** where `heights[i] != expected[i]`.
*Hãy trả về số lượng **tổng các vị trí đứng bị sai lệch**, nơi mà chiều cao thực tế của người xếp hàng tại đó `heights[i]` KHÔNG HỀ TƯƠNG XỨNG VỪA VẶN VỚI chiều cao chuẩn lý tưởng `expected[i]` theo đúng yêu cầu đã ban bố ban đầu.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** heights = [1,1,4,2,1,3]
**Output:** 3
**Explanation:** 
*Giải thích:*
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
*Hàng thực tế loạn cào cào: [1,1,4,2,1,3]*
*Hàng chuẩn chỉ thấp cao:  [1,1,1,2,3,4]*
*Các điểm bị lỗi nhịp: Vị trí 2 (thực là 4, chuẩn phải là 1), Vị trí 4 (thực 1, chuẩn 3), và Cột số 5 (thực 3, chuẩn 4). Tổng cộng có 3 vị trí đứng khập khiễng sai lệch.*

## Example 2:
## *Ví dụ 2:*

**Input:** heights = [5,1,2,3,4]
**Output:** 5
**Explanation:** 
*Giải thích:*
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
*Tất tần tật mọi đứa đều trạm trán nhau ở nhầm vị trí, chẳng khớp được điểm nào! Lỗi toàn tập 5 người.*

## Example 3:
## *Ví dụ 3:*

**Input:** heights = [1,2,3,4,5]
**Output:** 0
**Explanation:** 
*Giải thích:*
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
*Bầu không khí trang nghiêm ngoan ngoãn. Tất cả đều ráp vừa vặn như in. Số lỗi bằng 0.*

---

## Constraints:
## *Ràng buộc:*

*   `1 <= heights.length <= 100`
*   `1 <= heights[i] <= 100`
