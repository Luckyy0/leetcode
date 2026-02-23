# Result for Delete Columns to Make Sorted
# *Kết quả cho bài toán Xóa Cột để Thực hiện Sắp xếp*

## Description
## *Mô tả*

You are given an array of `n` strings `strs`, all of the same length.
*Bạn được cho một mảng `n` chuỗi `strs`, tất cả đều có cùng độ dài.*

The strings can be arranged such that there is one on each line, making a grid.
*Các chuỗi có thể được sắp xếp sao cho mỗi chuỗi nằm trên một dòng, tạo thành một lưới.*

*   For example, `strs = ["abc", "bce", "cae"]` can be arranged as:
    *   *Ví dụ, `strs = ["abc", "bce", "cae"]` có thể được sắp xếp như sau:*

```
abc
bce
cae
```

You want to **delete** the columns that are **not sorted lexicographically**. In the above example (0-indexed), columns 0 (`'a'`, `'b'`, `'c'`) and 2 (`'c'`, `'e'`, `'e'`) are sorted while column 1 (`'b'`, `'c'`, `'a'`) is not, so you would delete column 1.
*Bạn muốn **xóa** các cột **không được sắp xếp theo thứ tự từ điển**. Trong ví dụ trên (được đánh chỉ số 0), các cột 0 (`'a'`, `'b'`, `'c'`) và 2 (`'c'`, `'e'`, `'e'`) được sắp xếp trong khi cột 1 (`'b'`, `'c'`, `'a'`) thì không, vì vậy bạn sẽ xóa cột 1.*

Return *the number of columns that you will delete*.
*Trả về *số lượng cột mà bạn sẽ xóa*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** strs = ["cba","daf","ghi"]
**Output:** 1
**Explanation:** The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.

## Example 2:
## *Ví dụ 2:*

**Input:** strs = ["a","b"]
**Output:** 0
**Explanation:** The grid looks as follows:
  a
  b
Column 0 is the only column and is sorted, so you will not delete any columns.

## Example 3:
## *Ví dụ 3:*

**Input:** strs = ["zyx","wvu","tsr"]
**Output:** 3
**Explanation:** The grid looks as follows:
  zyx
  wvu
  tsr
All 3 columns are not sorted, so you will delete all 3.

---

## Constraints:
## *Ràng buộc:*

*   `n == strs.length`
*   `1 <= n <= 100`
*   `1 <= strs[i].length <= 1000`
*   `strs[i]` consists of lowercase English letters.
