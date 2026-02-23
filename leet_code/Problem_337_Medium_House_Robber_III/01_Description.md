# Result for House Robber III
# *Kết quả cho bài toán Kẻ Trộm Nhà III*

## Description
## *Mô tả*

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called `root`.
*Kẻ trộm lại tìm thấy một nơi mới để thực hiện vụ trộm của mình. Chỉ có một lối vào khu vực này, được gọi là `root`.*

Besides the `root`, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if **two directly-linked houses were broken into on the same night**.
*Ngoài `root`, mỗi ngôi nhà chỉ có một và chỉ một ngôi nhà cha mẹ. Sau khi tham quan, kẻ trộm thông minh nhận ra rằng tất cả các ngôi nhà ở nơi này tạo thành một cây nhị phân. Cảnh sát sẽ tự động được liên lạc nếu **hai ngôi nhà được liên kết trực tiếp bị đột nhập trong cùng một đêm**.*

Given the `root` of the binary tree, return *the maximum amount of money the thief can rob without alerting the police*.
*Cho `root` của cây nhị phân, trả về *số tiền tối đa mà kẻ trộm có thể cướp mà không báo động cảnh sát*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [3,2,3,null,3,null,1]`
**Output:** `7`
**Explanation:** Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

## Example 2:
## *Ví dụ 2:*

**Input:** `root = [3,4,5,1,3,null,1]`
**Output:** `9`
**Explanation:** Maximum amount of money the thief can rob = 4 + 5 = 9.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[1, 10^4]`.
*   `0 <= Node.val <= 10^4`
