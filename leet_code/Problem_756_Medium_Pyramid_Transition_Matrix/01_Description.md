# Result for Pyramid Transition Matrix
# *Kết quả cho bài toán Ma trận Chuyển tiếp Kim tự tháp*

## Description
## *Mô tả*

You are stacking blocks to form a pyramid. Each block has a color which is a one-letter string.
*Bạn đang xếp các khối để tạo thành một kim tự tháp. Mỗi khối có một màu là một chuỗi ký tự đơn.*

We are allowed to place any color block `C` on top of two adjacent blocks of colors `A` and `B` if and only if `(A, B, C)` is an allowed triple.
*Chúng ta được phép đặt bất kỳ khối màu `C` nào lên trên hai khối liền kề có màu `A` và `B` khi và chỉ khi `(A, B, C)` là một bộ ba được phép.*

We start with a bottom row of `bottom`, represented as a single string. We also have a list of `allowed` triples.
*Chúng ta bắt đầu với một hàng đáy `bottom`, được biểu diễn dưới dạng một chuỗi đơn. Chúng ta cũng có một danh sách các bộ ba `allowed`.*

Return `true` if and only if we can build the pyramid to the top (i.e., until a single block remains).
*Trả về `true` khi và chỉ khi chúng ta có thể xây dựng kim tự tháp đến đỉnh (tức là cho đến khi chỉ còn lại một khối).*

---

## Example 1:
## *Ví dụ 1:*

**Input:** bottom = "BCD", allowed = ["BCC","CDE","CEA","FFF"]
**Output:** true
**Explanation:**
We can stack the pyramid like this:
    A
   / \
  C   E
 / \ / \
B   C   D

We are allowed to place 'C' on top of 'B' and 'C' because "BCC" is allowed.
We are allowed to place 'E' on top of 'C' and 'D' because "CDE" is allowed.
We are allowed to place 'A' on top of 'C' and 'E' because "CEA" is allowed.
So, the pyramid is:
A
CE
BCD

## Example 2:
## *Ví dụ 2:*

**Input:** bottom = "AABA", allowed = ["AAA","AAB","ABA","ABB","BAC"]
**Output:** false
**Explanation:**
We can't likely stack the pyramid to the top.
Note that there could be multiple valid tops on a pair.

---

## Constraints:
## *Ràng buộc:*

*   `2 <= bottom.length <= 8`
*   `0 <= allowed.length <= 200`
*   `allowed[i].length == 3`
*   The letters in all strings are taken from the set `{'A', 'B', 'C', 'D', 'E', 'F', 'G'}`.
