# Result for Find the Town Judge
# *Kết quả cho bài toán Tìm Thẩm phán của Thị trấn*

## Description
## *Mô tả*

In a town, there are `n` people labeled from `1` to `n`. There is a rumor that one of these people is secretly the town judge.
*Trong một thị trấn, có `n` người được đánh số từ `1` đến `n`. Có tin đồn rằng một người trong số họ bí mật là thẩm phán của thị trấn.*

If the town judge exists, then:
*Nếu thẩm phán của thị trấn tồn tại, thì:*

1.  The town judge trusts nobody.
    *   *Thẩm phán của thị trấn không tin tưởng ai.*
2.  Everybody (except for the town judge) trusts the town judge.
    *   *Mọi người (ngoại trừ thẩm phán của thị trấn) đều tin tưởng thẩm phán của thị trấn.*
3.  There is exactly one person that satisfies properties 1 and 2.
    *   *Có chính xác một người thỏa mãn tính chất 1 và 2.*

You are given an array `trust` where `trust[i] = [a_i, b_i]` representing that the person labeled `a_i` trusts the person labeled `b_i`. If a trust relationship does not exist in `trust` array, then such a trust relationship does not exist.
*Bạn được cho một mảng `trust` trong đó `trust[i] = [a_i, b_i]` biểu diễn rằng người có nhãn `a_i` tin tưởng người có nhãn `b_i`. Nếu một mối quan hệ tin tưởng không tồn tại trong mảng `trust`, thì mối quan hệ tin tưởng đó không tồn tại.*

Return *the label of the town judge if the town judge exists and can be identified, or return* `-1` *otherwise*.
*Trả về *nhãn của thẩm phán của thị trấn nếu thẩm phán đó tồn tại và có thể được xác định, nếu không trả về* `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 2, trust = [[1,2]]
**Output:** 2

## Example 2:
## *Ví dụ 2:*

**Input:** n = 3, trust = [[1,3],[2,3]]
**Output:** 3

## Example 3:
## *Ví dụ 3:*

**Input:** n = 3, trust = [[1,3],[2,3],[3,1]]
**Output:** -1

---

## Constraints:
## *Ràng buộc:*

*   `1 <= n <= 1000`
*   `0 <= trust.length <= 10^4`
*   `trust[i].length == 2`
*   All the pairs of `trust` are **unique**.
*   `a_i != b_i`
*   `1 <= a_i, b_i <= n`
