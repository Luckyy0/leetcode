# Result for Path Sum IV
# *Kết quả cho bài toán Tổng Đường đi IV*

## Description
## *Mô tả*

If the depth of a tree is smaller than `5`, then this tree can be represented by a list of three-digit integers. For each integer in this list:
*Nếu độ sâu của một cây nhỏ hơn `5`, thì cây này có thể được biểu diễn bằng một danh sách các số nguyên có ba chữ số. Đối với mỗi số nguyên trong danh sách này:*
- The hundreds digit represents the depth `d` of this node, `1 <= d <= 4`.
    - *Chữ số hàng trăm đại diện cho độ sâu `d` của nút này, `1 <= d <= 4`.*
- The tens digit represents the position `p` of this node in the level, `1 <= p <= 8`. The position is the same as that in a full binary tree.
    - *Chữ số hàng chục đại diện cho vị trí `p` của nút này trong tầng, `1 <= p <= 8`. Vị trí này tương tự như trong một cây nhị phân đầy đủ.*
- The units digit represents the value `v` of this node, `0 <= v <= 9`.
    - *Chữ số hàng đơn vị đại diện cho giá trị `v` của nút này, `0 <= v <= 9`.*

Given a list of `nums` representing a binary tree, return the sum of all paths from the root towards the leaves.
*Cho một danh sách các số nguyên `nums` biểu diễn một cây nhị phân, hãy trả về tổng của tất cả các đường đi từ gốc đến các lá.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [113, 215, 221]
**Output:** 12
**Explanation:** 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [113, 221]
**Output:** 4
**Explanation:** 
The tree that the list represents is:
    3
     \
      1

The path sum is (3 + 1) = 4.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 15`
*   `nums[i]` is between `110` and `489`.
*   The tree represented by `nums` is a **valid** binary tree.
