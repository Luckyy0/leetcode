# Result for Kth Largest Element in a Stream
# *Kết quả cho bài toán Phần tử lớn thứ K trong một Luồng*

## Description
## *Mô tả*

Design a class to find the `kth` largest element in a stream. Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.
*Thiết kế một lớp để tìm phần tử lớn thứ `k` trong một luồng dữ liệu. Lưu ý rằng đó là phần tử lớn thứ `k` trong thứ tự đã sắp xếp, không phải phần tử phân biệt thứ `k`.*

Implement `KthLargest` class:
*   `KthLargest(int k, int[] nums)` Initializes the object with the integer `k` and the stream of integers `nums`.
*   `int add(int val)` Appends the integer `val` to the stream and returns the element representing the `kth` largest element in the stream.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
**Output:** [null, 4, 5, 5, 8, 8]
**Explanation:**
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= 10^4`
*   `0 <= nums.length <= 10^4`
*   `-10^4 <= nums[i] <= 10^4`
*   `-10^4 <= val <= 10^4`
*   At most `10^4` calls will be made to `add`.
*   It is guaranteed that there will be at least `k` elements in the array when you search for the `kth` largest element.
