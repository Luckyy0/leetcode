# Result for Partition Labels
# *Kết quả cho bài toán Phân vùng Nhãn*

## Description
## *Mô tả*

You are given a string `s`. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
*Bạn được cho một chuỗi `s`. Chúng ta muốn phân chia chuỗi thành càng nhiều phần càng tốt sao cho mỗi ký tự chỉ xuất hiện trong tối đa một phần.*

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be `s`.
*Lưu ý rằng việc phân chia được thực hiện sao cho sau khi nối tất cả các phần theo thứ tự, chuỗi kết quả phải là `s`.*

Return *a list of integers representing the size of these parts*.
*Trả về *một danh sách các số nguyên đại diện cho kích thước của các phần này*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "ababcbacadefegdehijhklij"
**Output:** [9,7,8]
**Explanation:**
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "eccbbbbdec"
**Output:** [10]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 500`
*   `s` consists of lowercase English letters.
