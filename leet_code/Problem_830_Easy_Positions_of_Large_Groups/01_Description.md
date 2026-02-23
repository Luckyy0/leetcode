# Result for Positions of Large Groups
# *Kết quả cho bài toán Vị trí của các Nhóm Lớn*

## Description
## *Mô tả*

In a string `s` of lowercase letters, these letters form consecutive groups of the same character.
*Trong một chuỗi `s` gồm các chữ cái viết thường, các chữ cái này tạo thành các nhóm liên tiếp các ký tự giống nhau.*

*   For example, a string `s = "abbxxxxzzy"` has the groups `"a"`, `"bb"`, `"xxxx"`, `"zz"`, and `"y"`.
*   *Ví dụ, chuỗi `s = "abbxxxxzzy"` có các nhóm "a", "bb", "xxxx", "zz", và "y".*

A group is identified by an interval `[start, end]`, where `start` and `end` denote the start and end indices (inclusive) of the group. In the above example, `"xxxx"` has the interval `[3, 6]`.
*Một nhóm được xác định bởi một khoảng `[start, end]`, trong đó `start` và `end` biểu thị các chỉ số bắt đầu và kết thúc của nhóm. Trong ví dụ trên, "xxxx" có khoảng [3, 6].*

A group is considered **large** if it has **3 or more** characters.
*Một nhóm được coi là **lớn** nếu nó có **từ 3 ký tự trở lên**.*

Return *the intervals of every **large** group sorted in **increasing order by start index***.
*Trả về *các khoảng của mọi nhóm **lớn**, được sắp xếp theo **thứ tự tăng dần của chỉ số bắt đầu***.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** s = "abbxxxxzzy"
**Output:** [[3,6]]
**Explanation:** "xxxx" is the only large group with start index 3 and end index 6.

## Example 2:
## *Ví dụ 2:*

**Input:** s = "abc"
**Output:** []
**Explanation:** We have groups "a", "b", and "c", none of which are large groups.

## Example 3:
## *Ví dụ 3:*

**Input:** s = "abcdddeeeeaabbbcd"
**Output:** [[3,5],[6,9],[12,14]]
**Explanation:** The large groups are "ddd", "eeee", and "bbb".

---

## Constraints:
## *Ràng buộc:*

*   `1 <= s.length <= 1000`
*   `s` consists of lowercase English letters only.
