# Result for Random Pick Index
# *Kết quả cho bài toán Chọn Chỉ số Ngẫu nhiên*

## Description
## *Mô tả*

Given an integer array `nums` with possible duplicates, randomly output the index of a given `target` number. You can assume that the given target number must exist in the array.
*Cho một mảng số nguyên `nums` có thể chứa các phần tử trùng lặp, hãy xuất ra một chỉ số ngẫu nhiên của một số `target` cho trước. Bạn có thể giả định rằng số mục tiêu được cho chắc chắn tồn tại trong mảng.*

Implement the `Solution` class:
*Thực hiện lớp `Solution`:*

*   `Solution(int[] nums)` Initializes the object with the array `nums`.
    *`Solution(int[] nums)` Khởi tạo đối tượng với mảng `nums`.*
*   `int pick(int target)` Picks a random index `i` from `nums` such that `nums[i] == target`. If there are multiple valid indices, each index should have an **equal probability** of being returned.
    *`int pick(int target)` Chọn một chỉ số ngẫu nhiên `i` từ `nums` sao cho `nums[i] == target`. Nếu có nhiều chỉ số hợp lệ, mỗi chỉ số phải có **xác suất được trả về như nhau**.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["Solution", "pick", "pick", "pick"]`
`[[[1, 2, 3, 3, 3]], [3], [3], [1]]`
**Output:**
`[null, 4, 2, 0]`

**Explanation:**
```java
Solution solution = new Solution([1, 2, 3, 3, 3]);
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(1); // It should return 0 since in the array only nums[0] is equal to 1.
```

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 2 * 10^4`
*   `-2^31 <= nums[i] <= 2^31 - 1`
*   `target` is guaranteed to be in `nums`.
*   At most `10^4` calls will be made to `pick`.
