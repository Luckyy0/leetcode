# Result for Shuffle an Array
# *Kết quả cho bài toán Tráo đổi Mảng*

## Description
## *Mô tả*

Given an integer array `nums`, design an algorithm to randomly shuffle the array. All permutations of the array should be **equally likely** as a result of the shuffling.
*Cho một mảng số nguyên `nums`, hãy thiết kế một thuật toán để tráo đổi mảng một cách ngẫu nhiên. Tất cả các hoán vị của mảng phải có **khả năng xảy ra như nhau**.*

Implement the `Solution` class:
*Thực hiện lớp `Solution`:*

*   `Solution(int[] nums)` Initializes the object with the integer array `nums`.
    *`Solution(int[] nums)` Khởi tạo đối tượng với mảng số nguyên `nums`.*
*   `int[] reset()` Resets the array to its original configuration and returns it.
    *`int[] reset()` Đặt lại mảng về cấu hình ban đầu và trả về nó.*
*   `int[] shuffle()` Returns a random shuffling of the array.
    *`int[] shuffle()` Trả về một kết quả tráo đổi ngẫu nhiên của mảng.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["Solution", "shuffle", "reset", "shuffle"]`
`[[[1, 2, 3]], [], [], []]`
**Output:**
`[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]`

**Explanation:**
```java
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
```

## Constraints:
## *Ràng buộc:*

*   `1 <= nums.length <= 50`
*   `-10^6 <= nums[i] <= 10^6`
*   All the elements of `nums` are **unique**.
*   At most `10^4` calls in total will be made to `reset` and `shuffle`.
