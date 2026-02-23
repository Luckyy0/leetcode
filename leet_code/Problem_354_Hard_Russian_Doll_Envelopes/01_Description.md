# Result for Russian Doll Envelopes
# *Kết quả cho bài toán Phong bao Búp bê Nga*

## Description
## *Mô tả*

You are given a 2D array of integers `envelopes` where `envelopes[i] = [wi, hi]` represents the width and the height of an envelope.
*Bạn được cho một mảng 2 chiều các số nguyên `envelopes` trong đó `envelopes[i] = [wi, hi]` đại diện cho chiều rộng và chiều cao của một phong bao.*

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
*Một phong bao có thể nằm gọn trong một phong bao khác nếu và chỉ nếu cả chiều rộng và chiều cao của một phong bao đều lớn hơn chiều rộng và chiều cao của phong bao kia.*

Return *the maximum number of envelopes you can Russian doll (i.e., put one inside the other)*.
*Trả về *số lượng phong bao tối đa bạn có thể lồng vào nhau (theo kiểu búp bê Nga)*.*

**Note:** You cannot rotate an envelope.
**Lưu ý:** Bạn không thể xoay phong bao.

## Example 1:
## *Ví dụ 1:*

**Input:** `envelopes = [[5,4],[6,4],[6,7],[2,3]]`
**Output:** `3`
**Explanation:** The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

## Example 2:
## *Ví dụ 2:*

**Input:** `envelopes = [[1,1],[1,1],[1,1]]`
**Output:** `1`

## Constraints:
## *Ràng buộc:*

*   `1 <= envelopes.length <= 10^5`
*   `envelopes[i].length == 2`
*   `1 <= wi, hi <= 10^5`
